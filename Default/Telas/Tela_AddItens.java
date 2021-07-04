package Default.Telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import Default.botesConstrutor;
import Default.Objetos.Objeto_Item;
import Default.Objetos.Objeto_Mesa;
import Default.Paineis.Painel_Comanda;
import Default.Paineis.Painel_Itens;

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

    Objeto_Item itemModel = new Objeto_Item(_cdItem, _sTipo, _sDescricao, _lDescricao, _lValorItem, _fValorItem,
            _btn_item, _btn_remover);
    public List<Objeto_Item> listItemModels = new ArrayList<Objeto_Item>();
    Objeto_Mesa mesaModel;

    public Tela_AddItens(Objeto_Mesa objMesa) {
        mesaModel = objMesa;
        fSelecaoItens = new JFrame();
        tGuias = new JTabbedPane();
        pPanel_guiaAlmoco = new JPanel();
        // CarregarItensAlmoco();
        CarregarItensAdicionais();

        tGuias.setTabPlacement(JTabbedPane.LEFT);
        fSelecaoItens.add(tGuias, BorderLayout.CENTER);
        tGuias.setBackground(Color.orange);
        pPanel_guiaAlmoco.setLayout(new BoxLayout(pPanel_guiaAlmoco, BoxLayout.LINE_AXIS));

        Painel_Comanda painel_Comanda = new Painel_Comanda(mesaModel);
        Painel_Itens painel_Itens = new Painel_Itens(listItemModels);

        pPanel_guiaAlmoco.add(painel_Itens.pPainel_PrincipalPratos);
        pPanel_guiaAlmoco.add(painel_Comanda.pPanel_EspacoDireito);

        tGuias.addTab("Almoço", pPanel_guiaAlmoco);
        /*
         * jTabbedPane3.addTab("Bebidas", jPanel3); jTabbedPane3.addTab("Doces e Bolos",
         * jPanel4); jTabbedPane3.addTab("Cafés", jPanel5);
         * jTabbedPane3.addTab("Salgados", jPanel6);
         */

        fSelecaoItens.setSize(1000, 800);
        fSelecaoItens.setResizable(false);
        fSelecaoItens.setVisible(true);

    }

    public void CarregarItensAlmoco() {

        for (int x = 0; x < 7; x++) {

            Objeto_Item itemModel = new Objeto_Item(_cdItem, _sTipo, _sDescricao, _lDescricao, _lValorItem, _fValorItem,
                    _btn_item, _btn_remover);
            itemModel.cdItem = x + 5;
            itemModel.sTipo = "Almoco ";

            switch (x) {
                case 0:
                    itemModel.lDescricao = new JLabel("A lá minuta de Frango");
                    itemModel.sDescricao = "A lá minuta de Frango";
                    itemModel.fValorItem = 18.00;
                    break;
                case 1:
                    itemModel.lDescricao = new JLabel("Prato do DIA");
                    itemModel.sDescricao = "Prato do DIA";
                    itemModel.fValorItem = 22.00;
                    break;
                case 2:
                    itemModel.lDescricao = new JLabel("Executivo de Peixe");
                    itemModel.sDescricao = "Executivo de Peixe";
                    itemModel.fValorItem = 20.00;
                    break;
                case 3:
                    itemModel.lDescricao = new JLabel("Executivo de Peixe");
                    itemModel.sDescricao = "Executivo de Peixe";
                    itemModel.fValorItem = 20.00;
                    break;
                case 4:
                    itemModel.lDescricao = new JLabel("Executivo de Frango");
                    itemModel.sDescricao = "Executivo de Frango";
                    itemModel.fValorItem = 20.00;
                    break;
                case 5:
                    itemModel.lDescricao = new JLabel("Kids");
                    itemModel.sDescricao = "Kids";
                    itemModel.fValorItem = 15.00;
                    break;
                case 6:
                    itemModel.lDescricao = new JLabel("Omelete");
                    itemModel.sDescricao = "Omelete";
                    itemModel.fValorItem = 18.00;
                    break;
                default:
                    itemModel.lDescricao = new JLabel("A lá minuta de Frango");
                    itemModel.sDescricao = "A lá minuta de Frango";
                    itemModel.fValorItem = 18.00;
            }

            itemModel.lDescricao.setHorizontalAlignment(JLabel.RIGHT);
            itemModel.lValorItem = new JLabel(String.valueOf(itemModel.fValorItem));
            itemModel.lValorItem.setHorizontalAlignment(JLabel.CENTER);
            itemModel.lDescricao.setHorizontalAlignment(JLabel.RIGHT);
            listItemModels.add(itemModel);

        }

    }

    public void CarregarItensAdicionais() {

        for (int x = 0; x < 7; x++) {

            botesConstrutor btnsMesas = new botesConstrutor();
            Objeto_Item itemModel = new Objeto_Item(_cdItem, _sTipo, _sDescricao, _lDescricao, _lValorItem, _fValorItem,
                    _btn_item, _btn_remover);
            itemModel.cdItem = x + 5;
            itemModel.sTipo = "Itens Adicionais ";

            switch (x) {
                case 0:

                    itemModel.sDescricao = "Ovo";
                    itemModel.lDescricao = new JLabel("Ovo");
                    itemModel.fValorItem = 2.00;
                    break;
                case 1:

                    itemModel.sDescricao = "Bacon";
                    itemModel.lDescricao = new JLabel("Bacon");
                    itemModel.fValorItem = 4.00;
                    break;
                case 2:

                    itemModel.sDescricao = "Farofa";
                    itemModel.lDescricao = new JLabel("Farofa");
                    itemModel.fValorItem = 2.50;
                    break;
                case 3:

                    itemModel.sDescricao = "Mel";
                    itemModel.lDescricao = new JLabel("Mel");
                    itemModel.fValorItem = 7.00;
                    break;
                case 4:

                    itemModel.sDescricao = "Pé de galinha";
                    itemModel.lDescricao = new JLabel("Pé de galinha");
                    itemModel.fValorItem = 29.00;
                    break;
                case 5:

                    itemModel.sDescricao = "Abacate";
                    itemModel.lDescricao = new JLabel("Abacate");
                    itemModel.fValorItem = 6.00;
                    break;
                case 6:
                    itemModel.sDescricao = "Camarão";
                    itemModel.lDescricao = new JLabel("Camarão");
                    itemModel.fValorItem = 69.00;
                    break;
                default:
                    itemModel.sDescricao = "A lá minuta de Frango";
                    itemModel.lDescricao = new JLabel("A lá minuta de Frango");
                    itemModel.fValorItem = 18.00;

            }

            itemModel.lDescricao.setHorizontalAlignment(JLabel.RIGHT);
            itemModel.lValorItem = new JLabel(String.valueOf(itemModel.fValorItem));
            itemModel.lValorItem.setHorizontalAlignment(JLabel.CENTER);
            listItemModels.add(itemModel);

        }

    }
}
