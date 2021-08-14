package com.pguisolffi.Telas;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.pguisolffi.Paineis.Painel_Delivery;
import com.pguisolffi.Paineis.Painel_Mesa;
import com.pguisolffi.Utilidades.Globals;
import com.pguisolffi.Utilidades.RedimensionarComplementos;
import com.pguisolffi.sgbd.Bd_get;
import com.pguisolffi.sgbd.InitializeBd;
import com.pguisolffi.Acoes.abasMenu;
import com.pguisolffi.Objetos.Objeto_Item;

import java.awt.*;
import java.io.IOException;

public class Tela_Principal extends JFrame {

	public static JFrame Frame_TelaPrincipal;
	public static JPanel Painel_DeMesas;

	public List<Objeto_Item> listItemModels_Almoco = new ArrayList<Objeto_Item>();
	public List<Objeto_Item> listItemModels_ItensAdicionais = new ArrayList<Objeto_Item>();

	public Tela_Principal() throws IOException, InterruptedException, ExecutionException {

		Frame_TelaPrincipal = new JFrame();
		Frame_TelaPrincipal.setSize(1024, 768);

		RedimensionarComplementos redim = new RedimensionarComplementos();
		int largura_FramePrincipal = redim.Largura_FrameMesas();
		int Altura_FramePrincipal = redim.Altura_FrameMesas();

		new InitializeBd();

		listItemModels_Almoco = new Bd_get().Get_Produtos();
		listItemModels_ItensAdicionais = new Bd_get().Get_ItensAdicionais();

		Globals globals = new Globals();
		globals.numeroPedido = new Bd_get().get_MaxPedido();

		ImageIcon imgdf = new ImageIcon(
				"C:/Projetos/Donna/DonnaFloripa/Default/mvn_manager/src/main/java/com/pguisolffi/images/DonnaFloripa.png");
		Image imgedf = imgdf.getImage().getScaledInstance((int)Math.round(largura_FramePrincipal*0.24), (int)Math.round(Altura_FramePrincipal*0.24), Image.SCALE_DEFAULT);
		ImageIcon imgDonnaFloripa = new ImageIcon(imgedf);

		ImageIcon leg = new ImageIcon(
				"C:/Projetos/Donna/DonnaFloripa/Default/mvn_manager/src/main/java/com/pguisolffi/images/legendas.png");
		Image legNew = leg.getImage().getScaledInstance((int)Math.round(largura_FramePrincipal*1.2), (int)Math.round(Altura_FramePrincipal*0.3), Image.SCALE_DEFAULT);
		ImageIcon legendas = new ImageIcon(legNew);

		JLabel lLogo = new JLabel();
		lLogo.setIcon(imgDonnaFloripa);

		JLabel legendas_label = new JLabel();
		legendas_label.setIcon(legendas);

		JPanel logoDonnaFloripa = new JPanel();
		logoDonnaFloripa.setLayout(new BoxLayout(logoDonnaFloripa, BoxLayout.LINE_AXIS));
		logoDonnaFloripa.setBackground(Color.ORANGE);
		logoDonnaFloripa.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		logoDonnaFloripa.add(Box.createRigidArea(new Dimension((int)Math.round(largura_FramePrincipal*0.055), 0)));
		logoDonnaFloripa.add(legendas_label);
		logoDonnaFloripa.add(lLogo);

		JLabel labelTituloPainelPrincipal = new JLabel("Painel de atendimentos - Donna Floripa", JLabel.CENTER);
		labelTituloPainelPrincipal.setFont(new Font("Futura", Font.BOLD, (int)Math.round(largura_FramePrincipal*0.04)));

		Painel_Mesa panel_Mesa = new Painel_Mesa();
		panel_Mesa.setAlignmentY(Painel_Mesa.BOTTOM_ALIGNMENT);
		panel_Mesa.setBackground(Color.ORANGE);

		JPanel panelDasMesas = new JPanel();
		panelDasMesas.setLayout(new BoxLayout(panelDasMesas, BoxLayout.PAGE_AXIS));
		panelDasMesas.setBackground(Color.ORANGE);
		panelDasMesas.add(Box.createRigidArea(new Dimension(0, (int)Math.round(largura_FramePrincipal*0.055))));
		panelDasMesas.add(panel_Mesa);

		Painel_Delivery panel_Delivery = new Painel_Delivery();
		panel_Delivery.setBackground(Color.ORANGE);
		
		JPanel panelDasDelivery = new JPanel();
		panelDasDelivery.setLayout(new BoxLayout(panelDasDelivery, BoxLayout.PAGE_AXIS));
		panelDasDelivery.setBackground(Color.ORANGE);
		panelDasDelivery.add(Box.createRigidArea(new Dimension(0, (int)Math.round(largura_FramePrincipal*0.055))));
		panelDasDelivery.add(panel_Delivery);

		JPanel panelBotaoInserir = new JPanel();
		panelBotaoInserir.setBackground(Color.ORANGE);
		panelBotaoInserir.add(panel_Mesa.botaoAddMesa);
		panelBotaoInserir.setAlignmentY(JPanel.TOP_ALIGNMENT);

		new abasMenu();

		Frame_TelaPrincipal.setLayout(new BorderLayout());
		Frame_TelaPrincipal.setTitle("DONNA FLORIPA");
		Frame_TelaPrincipal.setIconImage(imgdf.getImage());
		Frame_TelaPrincipal.getContentPane().setBackground(Color.ORANGE);
		Frame_TelaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);

		Painel_DeMesas = new JPanel(new BorderLayout());
		Painel_DeMesas.setBackground(Color.ORANGE);
		Painel_DeMesas.add(labelTituloPainelPrincipal, BorderLayout.PAGE_START);
		Painel_DeMesas.add(panelDasMesas, BorderLayout.CENTER);
		Painel_DeMesas.add(panelBotaoInserir, BorderLayout.LINE_START);
		Painel_DeMesas.add(panelDasDelivery, BorderLayout.LINE_END);
		Painel_DeMesas.add(logoDonnaFloripa, BorderLayout.PAGE_END);


		Frame_TelaPrincipal.getContentPane().add(Painel_DeMesas);


		// Frame_TelaPrincipal.getContentPane().add(labelTituloPainelPrincipal, BorderLayout.PAGE_START);
		// Frame_TelaPrincipal.getContentPane().add(panelDasMesas, BorderLayout.CENTER);
		// Frame_TelaPrincipal.getContentPane().add(panelBotaoInserir, BorderLayout.LINE_START);
		// Frame_TelaPrincipal.getContentPane().add(panelDasDelivery, BorderLayout.LINE_END);
		// Frame_TelaPrincipal.getContentPane().add(logoDonnaFloripa, BorderLayout.PAGE_END);

		Frame_TelaPrincipal.pack();
		Frame_TelaPrincipal.setVisible(true);
		Frame_TelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame_TelaPrincipal.show(); // MOSTRA O FRAME

	}

}
