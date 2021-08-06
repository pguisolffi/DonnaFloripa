package com.pguisolffi.Paineis;

import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.pguisolffi.Configuracoes;
import com.pguisolffi.Acoes.BarraCircularDeProgresso_gif;
import com.pguisolffi.Acoes.Botoes_Mesa;
import com.pguisolffi.Acoes.Carregar_ItensAtendimento;
import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Objetos.Objeto_Delivery;
import com.pguisolffi.Objetos.Objeto_Mesa;
import com.pguisolffi.Telas.Tela_AddItens;
import com.pguisolffi.Utilidades.Globals;
import com.pguisolffi.Utilidades.MinhasThreadsMesa;
import com.pguisolffi.Utilidades.botesConstrutor;
import com.pguisolffi.sgbd.Bd_get;
import com.pguisolffi.sgbd.Bd_update;

//import org.apache.commons.lang3.ObjectUtils.Null;

import com.pguisolffi.Utilidades.Formatacoes;

public class Painel_Mesa extends JPanel implements ActionListener {

	public static List<JLabel> lista_mesas;
	public static List<JPanel> lista_mesas_painel;
	public static List<JButton> lista_botoes_mesas;

	// List<Objeto_Atendimento> list_atendimentoModel;

	// Patric
	public int indice, numero;
	String status = "Em Aberto", observacao, duracao, entrada;
	JPanel table, corStatus, mesa, interiorMesa;
	JLabel lduracao, lnomeMesa, lentrada;
	JButton btnPlay, btnEye, btnAdd;
	Boolean duracaoAtivada;
	Thread threadDuracao;

	public static List<Objeto_Mesa> list_ObjetoMesa = new ArrayList<Objeto_Mesa>();

	// private List<JLabel> mesas;
	public static JButton botaoAddMesa;
	public static JScrollPane painel_mesas_com_scroll;
	public static JPanel painel_mesas;
	public static int colunasPainelMesas = 5, linhasPainelMesas = 1;

	int qtde_mesas = Configuracoes.qtde_mesas;
	List<Objeto_Atendimento> list_ObjetosAtendimentos;

	public Painel_Mesa() throws InterruptedException, ExecutionException, IOException {

		// Objeto_Mesa mesaModel = new Objeto_Mesa(indice, status, observacao, table);
		// INSTANCIAR OBJETOS
		lista_mesas = new ArrayList<>(); // ------------------------------- LISTA DE MESAS
		lista_mesas_painel = new ArrayList<>(); // ------------------------ LISTA DE MESAS
		painel_mesas = new JPanel(new GridLayout(linhasPainelMesas, colunasPainelMesas, 10, 10));
		painel_mesas.setBackground(Color.ORANGE);

		painel_mesas_com_scroll = new JScrollPane(painel_mesas); // - PAINEL COM SCROLL PARA CONTER O PAINEL DE MESAS

		// DIMENÇÕES DA LARGURA DO SCROLL
		painel_mesas_com_scroll.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
		painel_mesas_com_scroll.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));

		// Botao
		botesConstrutor btnsMesas = new botesConstrutor();
		botaoAddMesa = new JButton();
		botaoAddMesa = btnsMesas.add_Mesa;

		// CARATER�STICAS DOS OBJETOS
		// painel_mesas.setPreferredSize(new Dimension(300, 150));
		painel_mesas_com_scroll.setPreferredSize(new Dimension(1500, 650));
		painel_mesas_com_scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		painel_mesas_com_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		// painel_mesas_com_scroll.setAlignmentY(JPanel.CENTER_ALIGNMENT);

		this.add(botaoAddMesa);
		this.add(painel_mesas_com_scroll);

		// ADICIONA OS "ESCUTADORES"
		this.botaoAddMesa.addActionListener(this);
		AdicionaMesa(15);// QTDE 15

	}

	public void AdicionaMesa(int qtde) throws InterruptedException, ExecutionException, IOException {

		Globals.mesasNaoFinalizadas = new Bd_get().get_MesasNãoFinalizadas();

			for (int x = 0; x < qtde; x++) {

				indice++;
				float resto = (indice > 1 ? indice - 1 : 2) % 5;

				if (resto == 0) {
					linhasPainelMesas = linhasPainelMesas + 1;
					painel_mesas.setLayout(new GridLayout(linhasPainelMesas, colunasPainelMesas, 15, 15));
			}
		
			Painel_MesaVazia p_mesaVazia = new Painel_MesaVazia();
			Objeto_Mesa mesaVazia = p_mesaVazia.Painel_MesaVazia(indice);

			int mesaAtual = x+1;		

			if(Globals.mesasNaoFinalizadas.contains(mesaAtual)){
				mesaVazia.numero = mesaAtual;
				mesaVazia.entrada = new Bd_get().get_DataInicioAtendimento(mesaAtual);
				new Painel_MesaAtendIniciado(mesaVazia,true);
			}

			painel_mesas.add(mesaVazia.mesa);
			lista_mesas_painel.add(mesaVazia.mesa);
			list_ObjetoMesa.add(mesaVazia);

			mesaVazia.btnPlay.addActionListener(this);
			mesaVazia.btnEye.addActionListener(this);
			mesaVazia.btnAdd.addActionListener(this);

			painel_mesas_com_scroll.revalidate();
		}

	}

	/************************************************
	 * M�todo que trata quando uma a��o � executada *
	 ************************************************/
	public void actionPerformed(ActionEvent e) {

		// Adicionar mesa na tela
		if (e.getSource() == Painel_Mesa.botaoAddMesa) {

			try {
				AdicionaMesa(1);
			} catch (InterruptedException | ExecutionException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		// Iniciar "CONSUMINDO"
		for (int x = 0; x < Painel_Mesa.list_ObjetoMesa.size(); x++) {

			if (e.getSource() == Painel_Mesa.list_ObjetoMesa.get(x).btnPlay) {
				
				try {
					new Bd_update().BD_Update_Status_Atend_Mesa(Painel_Mesa.list_ObjetoMesa.get(x).numero, "Consumindo");
					new Painel_MesaConsumindo(x);
				} catch (InterruptedException | ExecutionException | IOException e1) {
					e1.printStackTrace();
				}			

			}
		}

		// Inciar o Atendimento (Mesa)
		for (int x = 0; x < Painel_Mesa.list_ObjetoMesa.size(); x++) {
			if (e.getSource() == Painel_Mesa.list_ObjetoMesa.get(x).btnAdd) {
				Globals.ehAtendimentoAntigo = false;
				Globals.objMesaAtual = Painel_Mesa.list_ObjetoMesa.get(x);
				new Botoes_Mesa().Botao_IniciarAtendimentoNaMesa(Painel_Mesa.list_ObjetoMesa.get(x),x);
			}
		}

		// Visualizar ítens da mesa (botão Eye)
		for (int x = 0; x < Painel_Mesa.list_ObjetoMesa.size(); x++) {

			if (e.getSource() == Painel_Mesa.list_ObjetoMesa.get(x).btnEye) {

				Globals.ehAtendimentoAntigo = true;
				

				try {
					list_ObjetosAtendimentos = new Bd_get().Get_ItensAtendimentoMesas(x + 1);
					Globals.nuseqItemAtual = new Bd_get().get_MaxNuSeq(list_ObjetosAtendimentos.get(0).pedido) + 1;
				} catch (InterruptedException | ExecutionException | IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				try {

					if (!list_ObjetosAtendimentos.isEmpty()) {
					new Tela_AddItens(Painel_Mesa.list_ObjetoMesa.get(x));
					BarraCircularDeProgresso_gif barraCircular = new BarraCircularDeProgresso_gif();
					new Carregar_ItensAtendimento(list_ObjetosAtendimentos);
					}
				} catch (InterruptedException | ExecutionException | IOException e1) {
					JOptionPane.showMessageDialog(null,"Não há ítens nessa Mesa");
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}

	}

}
