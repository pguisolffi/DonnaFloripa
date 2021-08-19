package com.pguisolffi.GerenciarProdutos;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

public class Painel_multiSelecao {

    public static JPanel Painel_Tela_Configuracoes;
    
    JPanel PanelEsquerdo_Centro;

    public JPanel Painel_multiSelecao(){

        Painel_Tela_Configuracoes = new JPanel(new BorderLayout());
        Painel_Tela_Configuracoes.setBorder(new EmptyBorder(0,30,70,30));

        JPanel Painel_Botoes = new JPanel();
        Painel_Botoes.setLayout(new BoxLayout(Painel_Botoes, BoxLayout.PAGE_AXIS));
        Painel_Botoes.setBorder(BorderFactory.createRaisedBevelBorder());

        JLabel tituloGerenciarProdutos = new JLabel("Gerencias Produtos", JLabel.CENTER);
        tituloGerenciarProdutos.setFont(new Font("Futura", Font.BOLD, 14));
        JPanel panelTitulo = new JPanel();
        panelTitulo.add(tituloGerenciarProdutos);
       

        JButton IncluirNovoProduto = new JButton("Incluir novo Produto");
        JButton AlterarProduto = new JButton("    Alterar Produto    ");
        JPanel PanelInclui = new JPanel();
        JPanel PanelAltera = new JPanel();
        PanelInclui.add(IncluirNovoProduto);
        PanelAltera.add(AlterarProduto);
        //AlterarProduto.setPreferredSize(new Dimension(IncluirNovoProduto.getSize().width,IncluirNovoProduto.getSize().height));

        Painel_Botoes.add(panelTitulo);
        Painel_Botoes.add(Box.createRigidArea(new Dimension(0, 20)));
        Painel_Botoes.add(PanelInclui);
        Painel_Botoes.add(Box.createRigidArea(new Dimension(0, 5)));
        Painel_Botoes.add(PanelAltera);


        JPanel painelGerenciarProdutos = new JPanel();
        painelGerenciarProdutos.setLayout(new BoxLayout(painelGerenciarProdutos, BoxLayout.PAGE_AXIS));
        painelGerenciarProdutos.setBorder(new EmptyBorder(0,70,0,50));
        painelGerenciarProdutos.add(Painel_Botoes);
        JPanel cadastrar = CadastrarItem();
        painelGerenciarProdutos.add(Box.createRigidArea(new Dimension(0, 30)));
        painelGerenciarProdutos.add(cadastrar);
        JPanel alterar = AlterarItem();
        painelGerenciarProdutos.add(Box.createRigidArea(new Dimension(0, 30)));
        painelGerenciarProdutos.add(alterar);

        fit_Redimen_Heigth(panelTitulo);
        fit_Redimen_Heigth(PanelInclui);
        fit_Redimen_Heigth(PanelAltera);
        fit_Redimen_Heigth(Painel_Botoes);
        fit_Redimen_Heigth(cadastrar);

        Painel_Tela_Configuracoes.add(painelGerenciarProdutos, BorderLayout.LINE_START);
        Painel_Tela_Configuracoes.add(Box.createRigidArea(new Dimension(0, 50)),BorderLayout.PAGE_START);
        
        CadastrarItem();

        return Painel_Tela_Configuracoes;
    }

    public JPanel CadastrarItem(){
        
        JPanel Cadastrar_item = new JPanel();
        Cadastrar_item.setLayout(new BoxLayout(Cadastrar_item, BoxLayout.PAGE_AXIS));
        Cadastrar_item.setBorder(BorderFactory.createRaisedBevelBorder());

        String[] listString = {"Almoco", "Itens Adicionais","Cafes Quentes", "Cafes Gelados","Bebidas","Sanduiches","Adicionais Sanduiches","Salgados","Bolos e Doces"};
        JPanel panelCombo = new JPanel();
        panelCombo.setLayout(new BoxLayout(panelCombo, BoxLayout.LINE_AXIS));
        JLabel tipoItem = new JLabel("Tipo de Produto", JLabel.CENTER);
        JComboBox comboTipoProduto = new JComboBox(listString);

        JPanel panelDescricao = new JPanel();
        panelDescricao.setLayout(new BoxLayout(panelDescricao, BoxLayout.LINE_AXIS));
        JLabel DescricaoItem = new JLabel("Nome do Item", JLabel.CENTER);
        JTextArea fieldDescricaoItem = new JTextArea();

        JPanel panelvalor = new JPanel();
        panelvalor.setLayout(new BoxLayout(panelvalor, BoxLayout.LINE_AXIS));
        JLabel valorItem = new JLabel("Valor do Item", JLabel.CENTER);
        JTextArea fieldvalorItem = new JTextArea();

        JButton confirmarInclusao = new JButton("Confirmar Inclusão");
        confirmarInclusao.setBackground(Color.green);
        confirmarInclusao.setBorder(BorderFactory.createRaisedBevelBorder());
        JPanel PanelConfirmar = new JPanel();
        PanelConfirmar.add(confirmarInclusao);

        panelCombo.add(tipoItem);
        panelCombo.add(Box.createRigidArea(new Dimension(30, 0)));
        panelCombo.add(comboTipoProduto);
        panelCombo.setBackground(Color.orange);

        panelDescricao.add(DescricaoItem);
        panelDescricao.add(Box.createRigidArea(new Dimension(30, 0)));
        panelDescricao.add(fieldDescricaoItem);
        panelDescricao.setBackground(Color.orange);

        panelvalor.add(valorItem);
        panelvalor.add(Box.createRigidArea(new Dimension(30, 0)));
        panelvalor.add(fieldvalorItem);
        panelvalor.setBackground(Color.orange);

        Cadastrar_item.add(panelCombo);
        Cadastrar_item.add(Box.createRigidArea(new Dimension(0, 15)));
        Cadastrar_item.add(panelDescricao);
        Cadastrar_item.add(Box.createRigidArea(new Dimension(0, 15)));
        Cadastrar_item.add(panelvalor);
        Cadastrar_item.add(Box.createRigidArea(new Dimension(0, 25)));
        Cadastrar_item.add(PanelConfirmar);

        fit_Redimen_Heigth(panelCombo);
        fit_Redimen_Heigth(panelDescricao);
        fit_Redimen_Heigth(panelvalor);
        fit_Redimen_Heigth(PanelConfirmar);
        fit_Redimen_Heigth(Cadastrar_item);
        
        return Cadastrar_item;

    }

    public JPanel AlterarItem(){
        
        JPanel Cadastrar_item = new JPanel();
        Cadastrar_item.setLayout(new BoxLayout(Cadastrar_item, BoxLayout.PAGE_AXIS));
        Cadastrar_item.setBorder(BorderFactory.createRaisedBevelBorder());

        String[] listString = {"Almoco", "Itens Adicionais","Cafes Quentes", "Cafes Gelados","Bebidas","Sanduiches","Adicionais Sanduiches","Salgados","Bolos e Doces"};
        JPanel panelCombo = new JPanel();
        
        panelCombo.setLayout(new BoxLayout(panelCombo, BoxLayout.LINE_AXIS));
        JLabel tipoItem = new JLabel("Tipo de Produto", JLabel.CENTER);
        JComboBox comboTipoProduto = new JComboBox(listString);

        JPanel panelDescricao = new JPanel();
        panelDescricao.setLayout(new BoxLayout(panelDescricao, BoxLayout.LINE_AXIS));
        JLabel DescricaoItem = new JLabel("Nome do Item", JLabel.CENTER);
        JComboBox comboDescricoes = new JComboBox(listString);

        JPanel panelvalor = new JPanel();
        panelvalor.setLayout(new BoxLayout(panelvalor, BoxLayout.LINE_AXIS));
        JLabel valorItem = new JLabel("Valor do Item", JLabel.CENTER);
        JTextArea fieldvalorItem = new JTextArea();

        JButton confirmarInclusao = new JButton("Confirmar Alteração");
        confirmarInclusao.setBackground(Color.green);
        confirmarInclusao.setBorder(BorderFactory.createRaisedBevelBorder());
        JPanel PanelConfirmar = new JPanel();
        PanelConfirmar.add(confirmarInclusao);

        confirmarInclusao.addActionListener((ActionListener) JOptionPane.showMessageDialog(this, "BINGO!",
        "Information: ", JOptionPane.INFORMATION_MESSAGE));

        JButton remover = new JButton("Remover Produto");
        remover.setBackground(Color.red);
        remover.setForeground(Color.white);
        remover.setBorder(BorderFactory.createRaisedBevelBorder());
        //JPanel PanelRemover = new JPanel();
        PanelConfirmar.add(remover);

        panelCombo.add(tipoItem);
        panelCombo.add(Box.createRigidArea(new Dimension(30, 0)));
        panelCombo.add(comboTipoProduto);
        panelCombo.setBackground(Color.orange);

        panelDescricao.add(DescricaoItem);
        panelDescricao.add(Box.createRigidArea(new Dimension(30, 0)));
        panelDescricao.add(comboDescricoes);
        panelDescricao.setBackground(Color.orange);

        panelvalor.add(valorItem);
        panelvalor.add(Box.createRigidArea(new Dimension(30, 0)));
        panelvalor.add(fieldvalorItem);
        panelvalor.setBackground(Color.orange);

        Cadastrar_item.add(panelCombo);
        Cadastrar_item.add(Box.createRigidArea(new Dimension(0, 15)));
        Cadastrar_item.add(panelDescricao);
        Cadastrar_item.add(Box.createRigidArea(new Dimension(0, 15)));
        Cadastrar_item.add(panelvalor);
        Cadastrar_item.add(Box.createRigidArea(new Dimension(0, 25)));
        Cadastrar_item.add(PanelConfirmar);

        fit_Redimen_Heigth(panelCombo);
        fit_Redimen_Heigth(panelDescricao);
        fit_Redimen_Heigth(panelvalor);
        fit_Redimen_Heigth(PanelConfirmar);
        fit_Redimen_Heigth(Cadastrar_item);
        
        return Cadastrar_item;

    }

    public void fit_Redimen_Heigth(JPanel jpanel) {
        jpanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, jpanel.getMinimumSize().height));
    }

    
}
