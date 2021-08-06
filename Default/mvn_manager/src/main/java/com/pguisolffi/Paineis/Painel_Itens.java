package com.pguisolffi.Paineis;

import java.awt.*;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.pguisolffi.Acoes.Carregar_Botoes;
import com.pguisolffi.Objetos.Objeto_Item;

import javax.swing.Box;
import java.text.NumberFormat;

public class Painel_Itens {

    JPanel pPanel_text_Observacoes, pPanelTituloPratos, pPanelTituloAdicionais, pPanel_Titulo_Observacoes,pPanelTituloBebidas;

    public static JPanel pPainel_SecundarioPratos,pPainel_SecundarioBebidas;
    public static JPanel pPainelItens,Panel_LadoEsquerdoBebidas;
    public static JPanel pPanel_ItensAdicionais;

    public JPanel pPainel_PrincipalPratos, panel_PrincipalBebidas;

    JLabel lTituloPratos,lTituloBebidas, lTitulosAdicionais, lTitulo_Observacoes;

    JSeparator jSeparator_TituloPratos, jSeparator_Observacoes, jSeparatorItensAdicionais,
            jSeparator_PratosToAdicionais;


    public static JTextArea tTextField_Observacoes;
    public static List<Objeto_Item> listModel_Produtos = new ArrayList<Objeto_Item>();

    NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());

    public Painel_Itens() {
    }

    public JPanel Panel_Almoco(List<Objeto_Item> listObj_Produtos) {

        format.setCurrency(Currency.getInstance("BRL"));

        listModel_Produtos = listObj_Produtos;

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
        tTextField_Observacoes = new JTextArea();
        lTitulo_Observacoes = new JLabel();

        pPainel_PrincipalPratos.setMinimumSize(new Dimension(400, 800));
        pPainel_PrincipalPratos.setPreferredSize(new Dimension(400, 750));
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
        Carregar_Botoes carregar_Botoes = new Carregar_Botoes();
        carregar_Botoes.CarregarPratos();

        pPainel_SecundarioPratos.add(Box.createRigidArea(new Dimension(0, 25)));

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
        carregar_Botoes.CarregarAdicionais();

        pPanel_Titulo_Observacoes.setMaximumSize(new Dimension(2300, 30));
        lTitulo_Observacoes.setFont(new Font("Leelawadee UI Semilight", 2, 14)); // NOI18N
        lTitulo_Observacoes.setText("Observações");
        pPanel_Titulo_Observacoes.add(lTitulo_Observacoes);
        pPainel_SecundarioPratos.add(pPanel_Titulo_Observacoes);

        jSeparator_Observacoes.setMaximumSize(new Dimension(20, 20));
        jSeparator_Observacoes.setPreferredSize(new Dimension(0, 10));
        pPainel_SecundarioPratos.add(jSeparator_Observacoes);

        tTextField_Observacoes.setToolTipText("Digite a Observação");
        tTextField_Observacoes.setMinimumSize(new Dimension(200, 50));
        tTextField_Observacoes.setPreferredSize(new Dimension(400, 50));
        tTextField_Observacoes.setLineWrap(true);
        pPanel_text_Observacoes.add(tTextField_Observacoes);
        pPainel_SecundarioPratos.add(pPanel_text_Observacoes);

        pPainel_SecundarioPratos.add(Box.createRigidArea(new Dimension(0, 30)));

        carregar_Botoes.CarregarObservacao(pPainel_SecundarioPratos);

        pPainel_PrincipalPratos.add(pPainel_SecundarioPratos);

        return pPainel_PrincipalPratos;

    }


    public JPanel Panel_Bebidas(List<Objeto_Item> listObj_Produtos) {

        format.setCurrency(Currency.getInstance("BRL"));

        listModel_Produtos = listObj_Produtos;

        panel_PrincipalBebidas = new JPanel();
        pPainel_SecundarioBebidas = new JPanel();
        pPanelTituloBebidas = new JPanel();
        lTituloBebidas = new JLabel();
        jSeparator_TituloPratos = new JSeparator();
        Panel_LadoEsquerdoBebidas = new JPanel(new FlowLayout());
        pPanel_Titulo_Observacoes = new JPanel();
        jSeparator_Observacoes = new JSeparator();
        pPanel_text_Observacoes = new JPanel();
        tTextField_Observacoes = new JTextArea();
        lTitulo_Observacoes = new JLabel();

        panel_PrincipalBebidas.setMinimumSize(new Dimension(400, 400));
        panel_PrincipalBebidas.setPreferredSize(new Dimension(400, 400));
        pPainel_SecundarioBebidas.setLayout(new BoxLayout(pPainel_SecundarioBebidas, BoxLayout.PAGE_AXIS));

        pPanelTituloBebidas.setMaximumSize(new Dimension(2300, 30));
        lTituloBebidas.setFont(new Font("Leelawadee UI Semilight", 2, 14)); // NOI18N
        lTituloBebidas.setText("Bebidas");
        pPanelTituloBebidas.add(lTituloBebidas);
        pPainel_SecundarioBebidas.add(pPanelTituloBebidas);

        jSeparator_TituloPratos.setMaximumSize(new Dimension(20, 20));
        jSeparator_TituloPratos.setPreferredSize(new Dimension(0, 10));
        pPainel_SecundarioBebidas.add(jSeparator_TituloPratos);

        // ****ADICIONAR OS botões das bebidas
        Carregar_Botoes carregar_Botoes = new Carregar_Botoes();
        carregar_Botoes.CarregarBebidas();

        pPainel_SecundarioBebidas.add(Box.createRigidArea(new Dimension(0, 25)));

        panel_PrincipalBebidas.add(pPainel_SecundarioBebidas);
        return panel_PrincipalBebidas;

    }




    public void fit_Redimen_Heigth(JPanel jpanel) {
        jpanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, jpanel.getMinimumSize().height));
    }




}
