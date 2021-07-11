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
import java.util.Set;
import java.util.concurrent.ExecutionException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.pguisolffi.Configuracoes;
import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Objetos.Objeto_Mesa;
import com.pguisolffi.Telas.Tela_AddItens;
import com.pguisolffi.Utilidades.Globals;
import com.pguisolffi.Utilidades.MinhasThreads;
import com.pguisolffi.Utilidades.botesConstrutor;
import com.pguisolffi.sgbd.Bd_get;
import com.pguisolffi.Utilidades.Formatacoes;

public class Painel_Mesa extends JPanel implements ActionListener {

	public static List<JLabel> lista_mesas;
	public static List<JPanel> lista_mesas_painel;
	public static List<JButton> lista_botoes_mesas;

	// List<Objeto_Atendimento> list_atendimentoModel;

	// Patric
	int indice, numero;
	String status = "Em Aberto", observacao, duracao, entrada;
	JPanel table, corStatus, mesa, interiorMesa;
	JLabel lduracao, lnomeMesa, lentrada;
	JButton btnPlay, btnEye, btnAdd;
	Boolean duracaoAtivada;
	Thread threadDuracao;

	public static List<Objeto_Mesa> listModelsMesas = new ArrayList<Objeto_Mesa>();

	// private List<JLabel> mesas;
	public static JButton botaoAddMesa;
	public static JScrollPane painel_mesas_com_scroll;
	public static JPanel painel_mesas;
	public static int colunasPainelMesas = 5, linhasPainelMesas = 1;

	int qtde_mesas = Configuracoes.qtde_mesas;
	List<Objeto_Atendimento> list_modelsAtendimentos;

	public Painel_Mesa() {

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

	public void AdicionaMesa(int qtde) {

		for (int x = 0; x < qtde; x++) {
			indice++;
			float resto = (indice > 1 ? indice - 1 : 2) % 5;

			if (resto == 0) {
				linhasPainelMesas = linhasPainelMesas + 1;
				painel_mesas.setLayout(new GridLayout(linhasPainelMesas, colunasPainelMesas, 15, 15));
			}

			botesConstrutor btnsMesas = new botesConstrutor();

			Objeto_Mesa mesaModel = new Objeto_Mesa(numero, status, observacao, lduracao, mesa, corStatus, interiorMesa,
					btnPlay, btnEye, btnAdd, lnomeMesa, lentrada, duracao, entrada, duracaoAtivada, threadDuracao);

			mesaModel.btnPlay = btnsMesas.ConfirmButton;
			mesaModel.btnEye = btnsMesas.EyeButton;
			mesaModel.btnAdd = btnsMesas.PlayButton;
			mesaModel.numero = indice;
			mesaModel.corStatus = new JPanel();
			mesaModel.interiorMesa = new JPanel(new GridBagLayout());
			mesaModel.lduracao = new JLabel();
			mesaModel.lentrada = new JLabel();
			mesaModel.lnomeMesa = new JLabel("Mesa " + indice);
			mesaModel.mesa = new JPanel(new GridBagLayout());
			Formatacoes format = new Formatacoes();
			format.Formatar_ObjetoMesa(mesaModel);
			mesaModel.mesa.add(mesaModel.corStatus, BorderLayout.PAGE_START);
			mesaModel.interiorMesa.add(mesaModel.lnomeMesa, BorderLayout.PAGE_START);
			mesaModel.interiorMesa.add(mesaModel.btnAdd, BorderLayout.CENTER);
			mesaModel.mesa.add(mesaModel.interiorMesa, BorderLayout.CENTER);

			painel_mesas.add(mesaModel.mesa);
			lista_mesas_painel.add(mesaModel.mesa);
			listModelsMesas.add(mesaModel);

			mesaModel.btnPlay.addActionListener(this);
			mesaModel.btnEye.addActionListener(this);
			mesaModel.btnAdd.addActionListener(this);

			painel_mesas_com_scroll.revalidate();
		}

	}

	/************************************************
	 * M�todo que trata quando uma a��o � executada *
	 ************************************************/
	public void actionPerformed(ActionEvent e) {

		// Adicionar mesa na tela
		if (e.getSource() == Painel_Mesa.botaoAddMesa) {

			AdicionaMesa(1);

		}

		// Iniciar "CONSUMINDO"
		for (int x = 0; x < Painel_Mesa.listModelsMesas.size(); x++) {

			if (e.getSource() == Painel_Mesa.listModelsMesas.get(x).btnPlay) {

				Painel_Mesa.listModelsMesas.get(x).corStatus.setBackground(Color.blue);
				Painel_Mesa.listModelsMesas.get(x).isThreadActive = false;
				Painel_Mesa.listModelsMesas.get(x).threadDuracao.interrupt();

			}
		}

		// Inciar o Atendimento (Mesa)
		for (int x = 0; x < Painel_Mesa.listModelsMesas.size(); x++) {

			if (e.getSource() == Painel_Mesa.listModelsMesas.get(x).btnAdd) {

				Date date = new Date();
				SimpleDateFormat formatoHoraMinuto = new SimpleDateFormat("HH:mm");
				Painel_Mesa.listModelsMesas.get(x).lentrada
						.setText("    " + formatoHoraMinuto.format(date).toString() + "    ");
				Painel_Mesa.listModelsMesas.get(x).entrada = date.toString();
				Painel_Mesa.listModelsMesas.get(x).corStatus.setBackground(Color.orange);
				Painel_Mesa.listModelsMesas.get(x).interiorMesa.remove(Painel_Mesa.listModelsMesas.get(x).btnAdd);
				Painel_Mesa.listModelsMesas.get(x).interiorMesa.add(Painel_Mesa.listModelsMesas.get(x).btnPlay,
						BorderLayout.LINE_START);
				Painel_Mesa.listModelsMesas.get(x).interiorMesa.add(Painel_Mesa.listModelsMesas.get(x).btnEye,
						BorderLayout.CENTER);
				Painel_Mesa.listModelsMesas.get(x).interiorMesa.add(Painel_Mesa.listModelsMesas.get(x).lentrada,
						BorderLayout.LINE_END);
				Painel_Mesa.listModelsMesas.get(x).mesa.add(Painel_Mesa.listModelsMesas.get(x).lduracao,
						BorderLayout.PAGE_END);
				Painel_Mesa.listModelsMesas.get(x).isThreadActive = true;

				MinhasThreads minhasThreads = new MinhasThreads(Painel_Mesa.listModelsMesas.get(x), x);

				Globals globals = new Globals();
				globals.numeroPedido++;

				list_modelsAtendimentos = new ArrayList<Objeto_Atendimento>();
				try {
					Tela_AddItens tela_AddItens = new Tela_AddItens(Painel_Mesa.listModelsMesas.get(x),
							list_modelsAtendimentos);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExecutionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Painel_Mesa.painel_mesas_com_scroll.updateUI();
			}
		}

		// Visualizar ítens da mesa (botão Eye)
		for (int x = 0; x < Painel_Mesa.listModelsMesas.size(); x++) {

			if (e.getSource() == Painel_Mesa.listModelsMesas.get(x).btnEye) {

				list_modelsAtendimentos = new ArrayList(list_modelsAtendimentos);

				try {
					list_modelsAtendimentos = new Bd_get().Get_ItensAtendimento(x + 1);
				} catch (InterruptedException | ExecutionException | IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				try {
					Tela_AddItens tela_AddItens = new Tela_AddItens(Painel_Mesa.listModelsMesas.get(x),
							list_modelsAtendimentos);
				} catch (InterruptedException | ExecutionException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}

	}

}
