package com.pguisolffi.Telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.pguisolffi.Acoes.Carregar_ItensAtendimento;
import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Objetos.Objeto_Item;
import com.pguisolffi.Objetos.Objeto_Mesa;
import com.pguisolffi.Paineis.Painel_Comanda;
import com.pguisolffi.Paineis.Painel_Itens;
import com.pguisolffi.sgbd.Bd_get;

public class Tela_AddItens {

    JFrame fSelecaoItens;
    JTabbedPane tGuias;
    public static JPanel pPanel_guiaAlmoco;

    int _cdItem;
    String _sTipo;
    String _sDescricao;
    double _fValorItem;
    JButton _btn_item, _btn_remover;
    JLabel _lDescricao, _lValorItem;

    Objeto_Item itemModel = new Objeto_Item(0, 0, _sTipo, _sDescricao, _fValorItem, _btn_item, false);
    public static List<Objeto_Item> listItemModels_Almoco = new ArrayList<Objeto_Item>();
    public static List<Objeto_Item> listItemModels_ItensAdicionais = new ArrayList<Objeto_Item>();
    Objeto_Mesa mesaModel;
    // bd_get bdGet = new bd_get();

    public Tela_AddItens(Objeto_Mesa objMesa, List<Objeto_Atendimento> list_atendimentosModels)
            throws InterruptedException, ExecutionException, IOException {

        mesaModel = objMesa;
        fSelecaoItens = new JFrame();
        tGuias = new JTabbedPane();
        pPanel_guiaAlmoco = new JPanel();

        listItemModels_Almoco = new Bd_get().Get_Almoco();
        listItemModels_ItensAdicionais = new Bd_get().Get_ItensAdicionais();

        tGuias.setTabPlacement(JTabbedPane.LEFT);
        fSelecaoItens.add(tGuias, BorderLayout.CENTER);
        tGuias.setBackground(Color.orange);
        pPanel_guiaAlmoco.setLayout(new BoxLayout(pPanel_guiaAlmoco, BoxLayout.LINE_AXIS));

        Painel_Comanda painel_Comanda = new Painel_Comanda(mesaModel);
        Painel_Itens painel_Itens = new Painel_Itens(listItemModels_Almoco, listItemModels_ItensAdicionais);

        if (!list_atendimentosModels.isEmpty()) {
            new Carregar_ItensAtendimento(list_atendimentosModels);
        }

        pPanel_guiaAlmoco.add(painel_Itens.pPainel_PrincipalPratos);
        pPanel_guiaAlmoco.add(painel_Comanda.pPanel_EspacoDireito);

        tGuias.addTab("Almoço", pPanel_guiaAlmoco);
        tGuias.setBackgroundAt(0, Color.orange);
        tGuias.addTab("Bebidas", new JPanel());
        tGuias.setBackgroundAt(1, Color.black);
        tGuias.setForegroundAt(1, Color.white);
        tGuias.addTab("Doces e Bolos", new JPanel());
        tGuias.setBackgroundAt(2, Color.orange);
        tGuias.addTab("Cafés", new JPanel());
        tGuias.setBackgroundAt(3, Color.black);
        tGuias.setForegroundAt(3, Color.white);
        tGuias.addTab("Salgados", new JPanel());
        tGuias.setBackgroundAt(4, Color.orange);

        fSelecaoItens.setSize(1000, 800);
        fSelecaoItens.setResizable(false);
        fSelecaoItens.setVisible(true);

    }

}
