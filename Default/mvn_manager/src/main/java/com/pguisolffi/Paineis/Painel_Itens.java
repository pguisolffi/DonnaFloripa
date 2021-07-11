package com.pguisolffi.Paineis;

import java.awt.*;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import com.pguisolffi.Acoes.Actions_ButtonsItens;
import com.pguisolffi.Acoes.Inserir_Observacao;
import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Objetos.Objeto_Item;
import com.pguisolffi.Telas.Tela_AddItens;
import com.pguisolffi.Utilidades.Globals;
import com.pguisolffi.Utilidades.botesConstrutor;

import javax.swing.Box;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class Painel_Itens implements ActionListener {

    JPanel jPanel7, pPanel_text_Observacoes, jPanel, pPanel_BotaoEnviar, pPainel_SecundarioPratos, pPanelTituloPratos,
            pPainelItens, jPanel22, pPanelTituloAdicionais, pPanel_ItensAdicionais, jPanel13, pPanel_Titulo_Observacoes;

    public JPanel pPainel_PrincipalPratos;

    JLabel lTituloPratos, lTitulosAdicionais, lTitulo_Observacoes;
    JSeparator jSeparator_TituloPratos, jSeparator_Observacoes, jSeparatorItensAdicionais,
            jSeparator_PratosToAdicionais;
    JButton jButton8, btn_Enviar, jButton2, jButton1, btn_Pratos, btn_ItensAdicionais;
    JTextField tTextField_Observacoes;
    JScrollPane scrollItemsAlmocos, scrollItemsAdicionais;

    List<Objeto_Item> listModel_Item_Almoco;
    List<Objeto_Item> listModel_Item_ItensAdicionais;

    public static List<Objeto_Atendimento> listModel_Atendimento;

    int pedido, numeroMesa, cdItem;
    String statusAtendimento, horaInicioAtendimento, horaFimAtendimento, duracaoAtendimento, sTipo, sDescricao;
    Boolean ehDelivery;
    JLabel lDescricao, lValorItem;
    double fValorItem, fValorTotal = 0;
    JButton btn_remover;

    NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());

    public Painel_Itens(List<Objeto_Item> listObj_Almoco, List<Objeto_Item> listObj_ItensAdicionais) {

        format.setCurrency(Currency.getInstance("BRL"));

        listModel_Atendimento = new ArrayList<Objeto_Atendimento>();
        listModel_Item_Almoco = listObj_Almoco;
        listModel_Item_ItensAdicionais = listObj_ItensAdicionais;

        pPainel_PrincipalPratos = new JPanel();
        pPainel_SecundarioPratos = new JPanel();
        pPanelTituloPratos = new JPanel();
        lTituloPratos = new JLabel();
        jSeparator_TituloPratos = new JSeparator();
        pPainelItens = new JPanel(new FlowLayout());
        pPanelTituloAdicionais = new JPanel();
        lTitulosAdicionais = new JLabel();
        jSeparatorItensAdicionais = new JSeparator();
        pPanel_ItensAdicionais = new JPanel(new FlowLayout());
        pPanel_Titulo_Observacoes = new JPanel();
        jSeparator_Observacoes = new JSeparator();
        pPanel_text_Observacoes = new JPanel();
        tTextField_Observacoes = new JTextField();
        pPanel_BotaoEnviar = new JPanel();
        btn_Enviar = new JButton();
        lTitulo_Observacoes = new JLabel();

        pPainel_PrincipalPratos.setMinimumSize(new Dimension(400, 800));
        pPainel_PrincipalPratos.setPreferredSize(new Dimension(400, 557));
        pPainel_SecundarioPratos.setLayout(new BoxLayout(pPainel_SecundarioPratos, BoxLayout.PAGE_AXIS));

        pPanelTituloPratos.setMaximumSize(new Dimension(2300, 30));
        lTituloPratos.setFont(new Font("Leelawadee UI Semilight", 2, 14)); // NOI18N
        lTituloPratos.setText("Pratos Executivos");
        pPanelTituloPratos.add(lTituloPratos);
        pPainel_SecundarioPratos.add(pPanelTituloPratos);

        jSeparator_TituloPratos.setMaximumSize(new Dimension(20, 20));
        jSeparator_TituloPratos.setPreferredSize(new Dimension(0, 10));
        pPainel_SecundarioPratos.add(jSeparator_TituloPratos);

        // ****ADICIONAR PRATOS
        JPanel grid_Pratos = new JPanel(new GridLayout(0, 2, 10, 10));
        scrollItemsAlmocos = new JScrollPane(grid_Pratos);
        scrollItemsAlmocos.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        scrollItemsAlmocos.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
        scrollItemsAlmocos.setPreferredSize(new Dimension(400, 200));
        scrollItemsAlmocos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollItemsAlmocos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        for (int y = 0; y < listModel_Item_Almoco.size(); y++) {

            btn_Pratos = new JButton(listModel_Item_Almoco.get(y).sDescricao);
            listModel_Item_Almoco.get(y).btn_item = btn_Pratos;
            listModel_Item_Almoco.get(y).btn_item.setFont(new Font("book Antiqua", Font.BOLD, 14));
            listModel_Item_Almoco.get(y).btn_item
                    .setPreferredSize(new Dimension(btn_Pratos.getMaximumSize().width, 40));
            listModel_Item_Almoco.get(y).btn_item.setBackground(Color.orange);
            listModel_Item_Almoco.get(y).btn_item.setMargin(new Insets(0, 0, 0, 0));
            listModel_Item_Almoco.get(y).btn_item.setBorder(null);
            grid_Pratos.add(listModel_Item_Almoco.get(y).btn_item);
            listModel_Item_Almoco.get(y).btn_item.addActionListener(this);
        }

        pPainelItens.add(scrollItemsAlmocos);
        scrollItemsAlmocos.setBorder(null);
        pPainel_SecundarioPratos.add(pPainelItens);
        pPainel_SecundarioPratos.add(Box.createRigidArea(new Dimension(0, 25)));
        // FIM DA ADIÇÃO DE PRATOS

        pPanelTituloAdicionais.setMaximumSize(new Dimension(2300, 30));
        lTitulosAdicionais.setFont(new Font("Leelawadee UI Semilight", 2, 14)); // NOI18N
        lTitulosAdicionais.setHorizontalAlignment(SwingConstants.CENTER);
        lTitulosAdicionais.setText("Ítens adicionais");
        lTitulosAdicionais.setHorizontalTextPosition(SwingConstants.CENTER);
        pPanelTituloAdicionais.add(lTitulosAdicionais);
        pPainel_SecundarioPratos.add(pPanelTituloAdicionais);
        jSeparatorItensAdicionais.setMaximumSize(new Dimension(20, 20));
        jSeparatorItensAdicionais.setPreferredSize(new Dimension(0, 10));
        pPainel_SecundarioPratos.add(jSeparatorItensAdicionais);

        // ****ADICIONAR ITENS_ADICIONAIS
        scrollItemsAdicionais = new JScrollPane(pPanel_ItensAdicionais);
        scrollItemsAdicionais.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        scrollItemsAdicionais.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
        scrollItemsAdicionais.setPreferredSize(new Dimension(400, 200));
        scrollItemsAdicionais.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollItemsAdicionais.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollItemsAdicionais.setBorder(null);

        for (int x = 0; x < listModel_Item_ItensAdicionais.size(); x++) {

            btn_ItensAdicionais = new JButton(listModel_Item_ItensAdicionais.get(x).sDescricao);
            listModel_Item_ItensAdicionais.get(x).btn_item = btn_ItensAdicionais;
            listModel_Item_ItensAdicionais.get(x).btn_item.setFont(new Font("book Antiqua", Font.BOLD, 12));
            listModel_Item_ItensAdicionais.get(x).btn_item
                    .setPreferredSize(new Dimension(btn_ItensAdicionais.getMaximumSize().width, 20));
            listModel_Item_ItensAdicionais.get(x).btn_item.setBackground(new Color(237, 179, 119));
            listModel_Item_ItensAdicionais.get(x).btn_item.setMargin(new Insets(0, 0, 0, 0));
            listModel_Item_ItensAdicionais.get(x).btn_item.setBorder(null);
            pPanel_ItensAdicionais.add(listModel_Item_ItensAdicionais.get(x).btn_item);
            pPanel_ItensAdicionais.setPreferredSize(new Dimension(400, 190));

            listModel_Item_ItensAdicionais.get(x).btn_item.addActionListener(this);
        }
        pPainel_SecundarioPratos.add(scrollItemsAdicionais);
        // FIM DA ADIÇÃO DE ITENS_ADICIONAIS

        pPanel_Titulo_Observacoes.setMaximumSize(new Dimension(2300, 30));
        lTitulo_Observacoes.setFont(new Font("Leelawadee UI Semilight", 2, 14)); // NOI18N
        lTitulo_Observacoes.setText("Observações");
        pPanel_Titulo_Observacoes.add(lTitulo_Observacoes);
        pPainel_SecundarioPratos.add(pPanel_Titulo_Observacoes);

        jSeparator_Observacoes.setMaximumSize(new Dimension(20, 20));
        jSeparator_Observacoes.setPreferredSize(new Dimension(0, 10));
        pPainel_SecundarioPratos.add(jSeparator_Observacoes);

        tTextField_Observacoes.setToolTipText("Digite a Observação");
        tTextField_Observacoes.setMinimumSize(new Dimension(200, 100));
        tTextField_Observacoes.setPreferredSize(new Dimension(400, 100));
        pPanel_text_Observacoes.add(tTextField_Observacoes);
        pPainel_SecundarioPratos.add(pPanel_text_Observacoes);

        pPanel_BotaoEnviar.setMaximumSize(new Dimension(80, 25));
        pPanel_BotaoEnviar.setMinimumSize(new Dimension(80, 25));
        pPanel_BotaoEnviar.setPreferredSize(new Dimension(50, 25));
        pPanel_BotaoEnviar.setLayout(new CardLayout());

        btn_Enviar.setLabel("Enviar");
        btn_Enviar.addActionListener(this);
        pPanel_BotaoEnviar.add(btn_Enviar, "card2");
        pPainel_SecundarioPratos.add(pPanel_BotaoEnviar);
        pPainel_PrincipalPratos.add(pPainel_SecundarioPratos);

    }

    public void actionPerformed(ActionEvent e) {

        for (int x = 0; x < listModel_Item_ItensAdicionais.size(); x++) {
            if (e.getSource() == listModel_Item_ItensAdicionais.get(x).btn_item) {
                new Actions_ButtonsItens().AdicionarItensAdicionais(listModel_Item_ItensAdicionais, e, x);
            }
        }

        for (int x = 0; x < listModel_Item_Almoco.size(); x++) {
            if (e.getSource() == listModel_Item_Almoco.get(x).btn_item) {
                new Actions_ButtonsItens().AdicionarItensAdicionais(listModel_Item_Almoco, e, x);
            }
        }

        if (e.getSource() == btn_Enviar) {

            String textoObservacao = tTextField_Observacoes.getText();
            new Inserir_Observacao(textoObservacao);
        }

    }

    public void fit_Redimen_Heigth(JPanel jpanel) {
        jpanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, jpanel.getMinimumSize().height));
    }
}
