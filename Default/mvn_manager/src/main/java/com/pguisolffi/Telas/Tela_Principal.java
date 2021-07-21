package com.pguisolffi.Telas;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.pguisolffi.Paineis.Painel_Delivery;
import com.pguisolffi.Paineis.Painel_Mesa;
import com.pguisolffi.Utilidades.Globals;
import com.pguisolffi.sgbd.Bd_get;
import com.pguisolffi.sgbd.InitializeBd;
import com.pguisolffi.Objetos.Objeto_Item;

import java.awt.*;
import java.io.IOException;

public class Tela_Principal extends JFrame {
	// LISTA DE OBJETOS DO TIPO PAINEL_MESA

	public List<Objeto_Item> listItemModels_Almoco = new ArrayList<Objeto_Item>();
	public List<Objeto_Item> listItemModels_ItensAdicionais = new ArrayList<Objeto_Item>();

	public Tela_Principal() throws IOException, InterruptedException, ExecutionException {
		// initComponets();

		new InitializeBd();

		listItemModels_Almoco = new Bd_get().Get_Almoco();
		listItemModels_ItensAdicionais = new Bd_get().Get_ItensAdicionais();

		Globals globals = new Globals();
		globals.numeroPedido = new Bd_get().get_MaxPedido();

		ImageIcon imgdf = new ImageIcon(
				"C:/Projetos/Donna/DonnaFloripa/Default/mvn_manager/src/main/java/com/pguisolffi/images/DonnaFloripa.png");
		Image imgedf = imgdf.getImage().getScaledInstance(300, 194, Image.SCALE_DEFAULT);
		ImageIcon imgDonnaFloripa = new ImageIcon(imgedf);

		ImageIcon leg = new ImageIcon(
				"C:/Projetos/Donna/DonnaFloripa/Default/mvn_manager/src/main/java/com/pguisolffi/images/legendas.png");
		Image legNew = leg.getImage().getScaledInstance(1193, 188, Image.SCALE_DEFAULT);
		ImageIcon legendas = new ImageIcon(legNew);

		JLabel lLogo = new JLabel();
		lLogo.setIcon(imgDonnaFloripa);

		JLabel legendas_label = new JLabel();
		legendas_label.setIcon(legendas);

		JPanel logoDonnaFloripa = new JPanel();
		logoDonnaFloripa.setLayout(new BoxLayout(logoDonnaFloripa, BoxLayout.LINE_AXIS));
		logoDonnaFloripa.setBackground(Color.ORANGE);
		logoDonnaFloripa.add(Box.createRigidArea(new Dimension(0, 50)));
		logoDonnaFloripa.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		logoDonnaFloripa.add(Box.createRigidArea(new Dimension(45, 0)));
		logoDonnaFloripa.add(legendas_label);
		logoDonnaFloripa.add(Box.createRigidArea(new Dimension(200, 0)));
		logoDonnaFloripa.add(lLogo);

		JLabel labelTituloPainelPrincipal = new JLabel("Painel de atendimentos - Donna Floripa", JLabel.CENTER);
		labelTituloPainelPrincipal.setFont(new Font("Futura", Font.BOLD, 30));

		Painel_Mesa panel_Mesa = new Painel_Mesa();
		panel_Mesa.setAlignmentY(Painel_Mesa.BOTTOM_ALIGNMENT);
		panel_Mesa.setBackground(Color.ORANGE);

		JPanel panelDasMesas = new JPanel();
		panelDasMesas.setLayout(new BoxLayout(panelDasMesas, BoxLayout.PAGE_AXIS));
		panelDasMesas.setBackground(Color.ORANGE);
		panelDasMesas.add(Box.createRigidArea(new Dimension(0, 50)));
		panelDasMesas.add(panel_Mesa);

		Painel_Delivery panel_Delivery = new Painel_Delivery();
		panel_Delivery.setBackground(Color.ORANGE);
		// testeInternet panel = new testeInternet();

		JPanel panelDasDelivery = new JPanel();
		panelDasDelivery.setLayout(new BoxLayout(panelDasDelivery, BoxLayout.PAGE_AXIS));
		panelDasDelivery.setBackground(Color.ORANGE);
		panelDasDelivery.add(Box.createRigidArea(new Dimension(0, 50)));
		panelDasDelivery.add(panel_Delivery);

		JPanel panelBotaoInserir = new JPanel();
		panelBotaoInserir.setBackground(Color.ORANGE);
		panelBotaoInserir.add(panel_Mesa.botaoAddMesa);
		panelBotaoInserir.setAlignmentY(JPanel.TOP_ALIGNMENT);

		this.setLayout(new BorderLayout());
		this.setTitle("DONNA FLORIPA");
		this.setIconImage(imgdf.getImage());
		this.getContentPane().setBackground(Color.ORANGE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// this.setSize(1024, 768);
		this.getContentPane().add(labelTituloPainelPrincipal, BorderLayout.PAGE_START);
		this.getContentPane().add(panelDasMesas, BorderLayout.CENTER);
		this.getContentPane().add(panelBotaoInserir, BorderLayout.LINE_START);
		this.getContentPane().add(panelDasDelivery, BorderLayout.LINE_END);
		this.getContentPane().add(logoDonnaFloripa, BorderLayout.PAGE_END);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.show(); // MOSTRA O FRAME

	}

}
