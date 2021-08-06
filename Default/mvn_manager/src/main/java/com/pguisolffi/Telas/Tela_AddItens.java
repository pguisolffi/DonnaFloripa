package com.pguisolffi.Telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import com.pguisolffi.Objetos.Objeto_Delivery;
import com.pguisolffi.Objetos.Objeto_Item;
import com.pguisolffi.Objetos.Objeto_Mesa;
import com.pguisolffi.Paineis.Painel_Comanda;
import com.pguisolffi.Paineis.Painel_Itens;
import com.pguisolffi.Utilidades.Globals;
import com.pguisolffi.sgbd.Bd_get;

public class Tela_AddItens {

    public static JFrame Frame_SelecaoItens;
    JTabbedPane tGuias;
    public static JPanel pPanel_guiaAlmoco,pPanel_guiaBebidas,Panel_Produtos;
    public boolean ehDelivery;

    Objeto_Item itemModel = new Objeto_Item(0, 0, null, null, 0, null, null, false);
    public static List<Objeto_Item> listItemModels_Produtos = new ArrayList<Objeto_Item>();
    //public static List<Objeto_Item> listItemModels_ItensAdicionais = new ArrayList<Objeto_Item>();
    Objeto_Mesa mesaModel;
    // bd_get bdGet = new bd_get();

    public Tela_AddItens(Objeto_Mesa objMesa) throws InterruptedException, ExecutionException, IOException {

  
        mesaModel = objMesa;
        ehDelivery = Globals.ehDelivery;
        Frame_SelecaoItens = new JFrame();
        tGuias = new JTabbedPane();
        tGuias.setPreferredSize(new Dimension(500,500));
        Panel_Produtos = new JPanel();
        Panel_Produtos.setLayout(new BoxLayout(Panel_Produtos, BoxLayout.LINE_AXIS));
        pPanel_guiaAlmoco = new JPanel();
        pPanel_guiaBebidas = new JPanel();
        pPanel_guiaAlmoco.setLayout(new BoxLayout(pPanel_guiaAlmoco, BoxLayout.LINE_AXIS));
        pPanel_guiaBebidas.setLayout(new BoxLayout(pPanel_guiaBebidas, BoxLayout.LINE_AXIS));
        // pPanel_guiaAlmoco.setBorder(BorderFactory.createEmptyBorder());
        // pPanel_guiaBebidas.setBorder(BorderFactory.createEmptyBorder());

        Painel_Comanda painel_Comanda = new Painel_Comanda(ehDelivery ? 0 : mesaModel.numero);

        listItemModels_Produtos = new Bd_get().Get_Produtos();
        //listItemModels_ItensAdicionais = new Bd_get().Get_ItensAdicionais();
        //Painel_Itens painel_Itens = new Painel_Itens(listItemModels_Produtos);

        //Adiciona as Abas no Frame de Itens
        tGuias.addTab("Almoço", pPanel_guiaAlmoco);
        tGuias.setBackgroundAt(0, Color.orange);
        tGuias.addTab("Bebidas", pPanel_guiaBebidas);
        tGuias.setBackgroundAt(1, Color.black);
        tGuias.setForegroundAt(1, Color.white);
        tGuias.addTab("Doces e Bolos", new JPanel());
        tGuias.setBackgroundAt(2, Color.orange);
        tGuias.addTab("Cafés", new JPanel());
        tGuias.setBackgroundAt(3, Color.black);
        tGuias.setForegroundAt(3, Color.white);
        tGuias.addTab("Salgados", new JPanel());
        tGuias.setBackgroundAt(4, Color.orange);
        tGuias.setTabPlacement(JTabbedPane.LEFT);

        pPanel_guiaAlmoco.add(new Painel_Itens().Panel_Almoco(listItemModels_Produtos));
        pPanel_guiaBebidas.add(new Painel_Itens().Panel_Bebidas(listItemModels_Produtos));

        Insets insets = UIManager.getInsets("TabbedPane.contentBorderInsets");
        insets.top = -1;
        insets.bottom = -1;
        insets.left = 1;
        insets.right = -1;
        UIManager.put("TabbedPane.contentBorderInsets", insets);

        Panel_Produtos.add(tGuias);
        Panel_Produtos.add(painel_Comanda.pPanel_EspacoDireito);


        Frame_SelecaoItens.add(Panel_Produtos, BorderLayout.CENTER);

        Frame_SelecaoItens.setSize(1000, 768);
        Frame_SelecaoItens.setResizable(false);
        Frame_SelecaoItens.setVisible(true);
        Frame_SelecaoItens.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        Frame_SelecaoItens.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(Frame_SelecaoItens, 
                    "Você deseja sair sem Salvar ?", "Close Window?", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                        Frame_SelecaoItens.dispose();
                }
            }
        });

    }

}
