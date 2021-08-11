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

    JPanel pPanel_text_Observacoes,pPanel_text_ObservacoesSanduiche,pPanel_Titulo_ObservacoesSanduiche, pPanelTituloPratos,pPanelTituloSanduiche, pPanelTituloAdicionais,pPanelTituloCafesGelados, pPanel_Titulo_Observacoes,pPanelTituloBebidas;

    public static JPanel pPainel_SecundarioPratos,pPainel_SecundarioBebidas,pPainel_SecundarioCafes,pPainel_SecundarioSanduiche;
    public static JPanel pPainelItens,Panel_LadoEsquerdoBebidas,pPanel_CafesGelados,Panel_LadoEsquerdoCafes;
    public static JPanel pPanel_ItensAdicionais,pPainelItensSanduiche,pPanel_ItensAdicionaisSanduiche;

    public JPanel pPanelTituloAdicionaisSanduiche,pPainel_PrincipalPratos,pPanelTituloCafes, panel_PrincipalBebidas,panel_PrincipalCafes,pPainel_PrincipalSanduiche;

    JLabel lTituloPratos,lTitulo_ObservacoesSanduiche,lTituloBebidas,lTitulosAdicionaisSanduiche,lTituloCafes,lTituloSanduiche,lTitulosAdicionais, lTitulosCafesGelados, lTitulo_Observacoes;

    JSeparator jSeparator_TituloPratos,jSeparator_TituloSanduiche,jSeparatorItensAdicionaisSanduiche, jSeparator_Observacoes, jSeparatorItensAdicionais, jSeparatorCafes,jSeparatorCafesGelados,
            jSeparator_PratosToAdicionais,jSeparator_ObservacoesSanduiche;


    public static JTextArea tTextField_Observacoes,tTextField_ObservacoesSanduiche;
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

    public JPanel Panel_Sanduiche(List<Objeto_Item> listObj_Produtos) {

        format.setCurrency(Currency.getInstance("BRL"));

        listModel_Produtos = listObj_Produtos;

        pPainel_PrincipalSanduiche = new JPanel();
        pPainel_SecundarioSanduiche = new JPanel();
        pPanelTituloSanduiche = new JPanel();
        lTituloSanduiche = new JLabel();
        jSeparator_TituloSanduiche = new JSeparator();
        pPainelItensSanduiche = new JPanel(new FlowLayout());
        pPanelTituloAdicionaisSanduiche = new JPanel();
        lTitulosAdicionaisSanduiche = new JLabel();
        jSeparatorItensAdicionaisSanduiche = new JSeparator();
        pPanel_ItensAdicionaisSanduiche = new JPanel(new FlowLayout());
        pPanel_Titulo_ObservacoesSanduiche = new JPanel();
        jSeparator_ObservacoesSanduiche = new JSeparator();
        pPanel_text_ObservacoesSanduiche = new JPanel();
        tTextField_ObservacoesSanduiche = new JTextArea();
        lTitulo_ObservacoesSanduiche = new JLabel();

        pPainel_PrincipalSanduiche.setMinimumSize(new Dimension(400, 800));
        pPainel_PrincipalSanduiche.setPreferredSize(new Dimension(400, 750));
        pPainel_SecundarioSanduiche.setLayout(new BoxLayout(pPainel_SecundarioSanduiche, BoxLayout.PAGE_AXIS));

        pPanelTituloSanduiche.setMaximumSize(new Dimension(2300, 30));
        lTituloSanduiche.setFont(new Font("Leelawadee UI Semilight", 2, 14)); // NOI18N
        lTituloSanduiche.setText("Pratos Executivos");
        pPanelTituloSanduiche.add(lTituloSanduiche);
        pPainel_SecundarioSanduiche.add(pPanelTituloSanduiche);

        jSeparator_TituloSanduiche.setMaximumSize(new Dimension(20, 20));
        jSeparator_TituloSanduiche.setPreferredSize(new Dimension(0, 10));
        pPainel_SecundarioSanduiche.add(jSeparator_TituloSanduiche);

        // ****ADICIONAR PRATOS
        Carregar_Botoes carregar_Botoes = new Carregar_Botoes();
        carregar_Botoes.CarregarSanduiches();

        pPainel_SecundarioSanduiche.add(Box.createRigidArea(new Dimension(0, 25)));

        pPanelTituloAdicionaisSanduiche.setMaximumSize(new Dimension(2300, 30));
        lTitulosAdicionaisSanduiche.setFont(new Font("Leelawadee UI Semilight", 2, 14)); // NOI18N
        lTitulosAdicionaisSanduiche.setHorizontalAlignment(SwingConstants.CENTER);
        lTitulosAdicionaisSanduiche.setText("Ítens adicionais");
        lTitulosAdicionaisSanduiche.setHorizontalTextPosition(SwingConstants.CENTER);
        pPanelTituloAdicionaisSanduiche.add(lTitulosAdicionaisSanduiche);
        pPainel_SecundarioSanduiche.add(pPanelTituloAdicionaisSanduiche);
        jSeparatorItensAdicionaisSanduiche.setMaximumSize(new Dimension(20, 20));
        jSeparatorItensAdicionaisSanduiche.setPreferredSize(new Dimension(0, 10));
        pPainel_SecundarioSanduiche.add(jSeparatorItensAdicionaisSanduiche);

        // ****ADICIONAR ITENS_ADICIONAIS
        carregar_Botoes.CarregarAdicionaisSanduiches();

        pPanel_Titulo_ObservacoesSanduiche.setMaximumSize(new Dimension(2300, 30));
        lTitulo_ObservacoesSanduiche.setFont(new Font("Leelawadee UI Semilight", 2, 14)); // NOI18N
        lTitulo_ObservacoesSanduiche.setText("Observações");
        pPanel_Titulo_ObservacoesSanduiche.add(lTitulo_ObservacoesSanduiche);
        pPainel_SecundarioSanduiche.add(pPanel_Titulo_ObservacoesSanduiche);

        jSeparator_ObservacoesSanduiche.setMaximumSize(new Dimension(20, 20));
        jSeparator_ObservacoesSanduiche.setPreferredSize(new Dimension(0, 10));
        pPainel_SecundarioSanduiche.add(jSeparator_ObservacoesSanduiche);

        tTextField_ObservacoesSanduiche.setToolTipText("Digite a Observação");
        tTextField_ObservacoesSanduiche.setMinimumSize(new Dimension(200, 50));
        tTextField_ObservacoesSanduiche.setPreferredSize(new Dimension(400, 50));
        tTextField_ObservacoesSanduiche.setLineWrap(true);
        pPanel_text_ObservacoesSanduiche.add(tTextField_ObservacoesSanduiche);
        pPainel_SecundarioSanduiche.add(pPanel_text_ObservacoesSanduiche);

        pPainel_SecundarioSanduiche.add(Box.createRigidArea(new Dimension(0, 30)));

        carregar_Botoes.CarregarObservacao(pPainel_SecundarioSanduiche);

        pPainel_PrincipalSanduiche.add(pPainel_SecundarioSanduiche);

        return pPainel_PrincipalSanduiche;

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

    public JPanel Panel_Cafes(List<Objeto_Item> listObj_Produtos) {

        format.setCurrency(Currency.getInstance("BRL"));

        listModel_Produtos = listObj_Produtos;

        panel_PrincipalCafes = new JPanel();
        pPainel_SecundarioCafes = new JPanel();
        pPanelTituloCafes = new JPanel();
        lTituloCafes = new JLabel();
        jSeparatorCafes = new JSeparator();
        pPanel_CafesGelados = new JPanel(new FlowLayout());
        Panel_LadoEsquerdoCafes = new JPanel(new FlowLayout());
        pPanelTituloCafesGelados = new JPanel();
        jSeparator_TituloPratos = new JSeparator();
        pPanel_text_Observacoes = new JPanel();
        tTextField_Observacoes = new JTextArea();
        lTitulosCafesGelados = new JLabel();

        panel_PrincipalCafes.setMinimumSize(new Dimension(400, 400));
        panel_PrincipalCafes.setPreferredSize(new Dimension(400, 400));
        pPainel_SecundarioCafes.setLayout(new BoxLayout(pPainel_SecundarioCafes, BoxLayout.PAGE_AXIS));

        pPanelTituloCafes.setMaximumSize(new Dimension(2300, 30));
        lTituloCafes.setFont(new Font("Leelawadee UI Semilight", 2, 14)); // NOI18N
        lTituloCafes.setText("Cafés Quentes");
        pPanelTituloCafes.add(lTituloCafes);
        pPainel_SecundarioCafes.add(pPanelTituloCafes);

        jSeparator_TituloPratos.setMaximumSize(new Dimension(20, 20));
        jSeparator_TituloPratos.setPreferredSize(new Dimension(0, 10));
        pPainel_SecundarioCafes.add(jSeparator_TituloPratos);

        // ****ADICIONAR OS botões das bebidas
        Carregar_Botoes carregar_Botoes = new Carregar_Botoes();
        carregar_Botoes.CarregarCafesQuentes();

        pPainel_SecundarioCafes.add(Box.createRigidArea(new Dimension(0, 25)));

        pPanelTituloCafesGelados.setMaximumSize(new Dimension(2300, 30));
        lTitulosCafesGelados.setFont(new Font("Leelawadee UI Semilight", 2, 14)); // NOI18N
        lTitulosCafesGelados.setHorizontalAlignment(SwingConstants.CENTER);
        lTitulosCafesGelados.setText("Cafés Gelados");
        lTitulosCafesGelados.setHorizontalTextPosition(SwingConstants.CENTER);
        pPanelTituloCafesGelados.add(lTitulosCafesGelados);
        pPainel_SecundarioCafes.add(pPanelTituloCafesGelados);
        jSeparatorCafes.setMaximumSize(new Dimension(20, 20));
        jSeparatorCafes.setPreferredSize(new Dimension(0, 10));
        pPainel_SecundarioCafes.add(jSeparatorCafes);

        // ****ADICIONAR ITENS_ADICIONAIS
        carregar_Botoes.CarregarCafesGelados();

        pPainel_SecundarioCafes.add(Box.createRigidArea(new Dimension(0, 25)));

        panel_PrincipalCafes.add(pPainel_SecundarioCafes);
        return panel_PrincipalCafes;

    }




    public void fit_Redimen_Heigth(JPanel jpanel) {
        jpanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, jpanel.getMinimumSize().height));
    }




}
