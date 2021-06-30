package Default;

import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.Scrollable;

public class Painel_Mesa extends JPanel implements ActionListener {

	public static List<JLabel> lista_mesas;
	public static List<JPanel> lista_mesas_painel;
	public static List<JButton> lista_botoes_mesas;

	// Patric
	int indice, numero;
	String status = "Em Aberto", observacao;
	JPanel table, corStatus, mesa, interiorMesa;
	JLabel duracao, nomeMesa, entrada;
	JButton btnPlay, btnEye, btnAdd;

	List<Objeto_Mesa> listModelsMesas = new ArrayList<Objeto_Mesa>();

	// private List<JLabel> mesas;
	public JButton botaoAddMesa;
	public static JScrollPane painel_mesas_com_scroll;
	public static JPanel painel_mesas;
	public static int colunasPainelMesas = 5, linhasPainelMesas = 1;

	int qtde_mesas = Configuracoes.qtde_mesas;

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
		AdicionaMesa(15);

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
			System.out.println("Resto: " + resto);
			Objeto_Mesa mesaModel = new Objeto_Mesa(numero, status, observacao, duracao, mesa, corStatus, interiorMesa,
					btnPlay, btnEye, btnAdd, nomeMesa, entrada);

			mesaModel.btnPlay = btnsMesas.ConfirmButton;
			mesaModel.btnEye = btnsMesas.EyeButton;
			mesaModel.btnAdd = btnsMesas.PlayButton;
			mesaModel.numero = indice;
			mesaModel.corStatus = new JPanel();
			mesaModel.corStatus.setBackground(Color.green);
			mesaModel.interiorMesa = new JPanel(new GridBagLayout());
			mesaModel.interiorMesa.setLayout(new BorderLayout());
			mesaModel.interiorMesa.setBackground(Color.white);
			mesaModel.duracao = new JLabel("Duração: 00:11");
			mesaModel.entrada = new JLabel("Entrada: 12:27");
			mesaModel.duracao.setFont(new Font("Calibri", Font.BOLD, 30));
			mesaModel.duracao.setHorizontalAlignment(JLabel.CENTER);
			mesaModel.duracao.setVerticalAlignment(JLabel.CENTER);
			mesaModel.nomeMesa = new JLabel("Mesa " + indice);
			mesaModel.nomeMesa.setFont(new Font("Verdana", 1, 20));
			mesaModel.nomeMesa.setHorizontalAlignment(JLabel.CENTER);
			mesaModel.nomeMesa.setVerticalAlignment(JLabel.NORTH);
			mesaModel.mesa = new JPanel(new GridBagLayout());
			mesaModel.mesa.setLayout(new BorderLayout());
			mesaModel.mesa.setBackground(Color.white);
			mesaModel.mesa.setBorder(BorderFactory.createRaisedBevelBorder());
			mesaModel.mesa.add(mesaModel.corStatus, BorderLayout.PAGE_START);
			mesaModel.interiorMesa.add(mesaModel.nomeMesa, BorderLayout.PAGE_START);
			mesaModel.interiorMesa.add(mesaModel.btnAdd, BorderLayout.CENTER);
			mesaModel.mesa.add(mesaModel.interiorMesa, BorderLayout.CENTER);

			mesaModel.mesa.setPreferredSize(new Dimension(200, 200));

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

		if (e.getSource() == botaoAddMesa) {

			AdicionaMesa(1);

		}

		// Identificar em qual btnPlay está clicando.
		for (int x = 0; x < listModelsMesas.size(); x++) {

			if (e.getSource() == listModelsMesas.get(x).btnPlay) {

				listModelsMesas.get(x).corStatus.setBackground(Color.blue);

			}
		}

		// Identificar em qual btnAdd está clicando.
		for (int x = 0; x < listModelsMesas.size(); x++) {

			if (e.getSource() == listModelsMesas.get(x).btnAdd) {

				listModelsMesas.get(x).corStatus.setBackground(Color.orange);
				listModelsMesas.get(x).interiorMesa.remove(listModelsMesas.get(x).btnAdd);
				listModelsMesas.get(x).interiorMesa.add(listModelsMesas.get(x).btnPlay, BorderLayout.LINE_START);
				listModelsMesas.get(x).interiorMesa.add(listModelsMesas.get(x).btnEye, BorderLayout.CENTER);
				listModelsMesas.get(x).interiorMesa.add(listModelsMesas.get(x).entrada, BorderLayout.LINE_END);
				listModelsMesas.get(x).mesa.add(listModelsMesas.get(x).duracao, BorderLayout.PAGE_END);
				painel_mesas_com_scroll.updateUI();
			}
		}

		// Identificar em qual btnEye está clicando.
		for (int x = 0; x < listModelsMesas.size(); x++) {

			if (e.getSource() == listModelsMesas.get(x).btnEye) {

				// listModelsMesas.get(x).corStatus.setBackground(Color.Black);

			}
		}

	}

}
