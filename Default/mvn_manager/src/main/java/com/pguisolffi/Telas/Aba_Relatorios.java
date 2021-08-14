package com.pguisolffi.Telas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label;
import com.pguisolffi.Graficos.DesenhandoGraficos;
import com.pguisolffi.Utilidades.Calendario;
import com.pguisolffi.Utilidades.RedimensionarComplementos;
import com.pguisolffi.Utilidades.RoundedBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Aba_Relatorios extends JButton{

    public static JPanel painel_Tela_Relatorios;

    JPanel panel_DadosPesquisa,panel_respostaPesquisa,panel_GraficoQtde,panel_graficoReceita, 
    panel_EscolherData, panel_calendarioInicio, panel_calendarioFim, panel_dtInicio, panel_dtFim;

    JLabel label_dataInicial, label_dataFinal;

    public JPanel Relatorios(){

        painel_Tela_Relatorios = new JPanel(new BorderLayout());
        panel_DadosPesquisa = new JPanel();
        panel_DadosPesquisa.setLayout(new BoxLayout(panel_DadosPesquisa, BoxLayout.PAGE_AXIS));
        panel_DadosPesquisa.setBorder(new EmptyBorder(10,30,10,10));
        //painel_Tela_Relatorios.setPreferredSize(new Dimension(1200,800));

        JPanel grafico = new JPanel();
        grafico.setLayout(new BoxLayout(grafico, BoxLayout.PAGE_AXIS));

        grafico.add(Dadosgraficos());
        
        
        titulo_TelaRelatorios();
        escolherDatas();
        painel_comboBox();
        botaoConsultar();
        consultarPedidos();

        painel_Tela_Relatorios.add(resultadoDaConsulta(), BorderLayout.CENTER);
        painel_Tela_Relatorios.add(grafico, BorderLayout.LINE_END);
        
        painel_Tela_Relatorios.updateUI();

        return painel_Tela_Relatorios;
    }



    public void titulo_TelaRelatorios(){

        RedimensionarComplementos redim = new RedimensionarComplementos();
		int largura_FramePrincipal = redim.Largura_FrameMesas();
		int Altura_FramePrincipal = redim.Altura_FrameMesas();

        JPanel panel = new JPanel();
        JLabel labelTituloPainelPrincipal = new JLabel("Relatório de atendimentos", JLabel.CENTER);
		labelTituloPainelPrincipal.setFont(new Font("Futura", Font.BOLD, (int)Math.round(largura_FramePrincipal*0.04)));
        panel.add(labelTituloPainelPrincipal);
        painel_Tela_Relatorios.add(panel,BorderLayout.PAGE_START);
        
    }

    public JPanel calendarioInicioFim(){

        panel_EscolherData = new JPanel();
        panel_EscolherData.setLayout(new BoxLayout(panel_EscolherData, BoxLayout.LINE_AXIS));
        panel_dtInicio = new JPanel();
        panel_dtInicio.setLayout(new BoxLayout(panel_dtInicio, BoxLayout.PAGE_AXIS));
        panel_dtFim = new JPanel();
        panel_dtFim.setLayout(new BoxLayout(panel_dtFim, BoxLayout.PAGE_AXIS));

        label_dataInicial = new JLabel("Data inicial", JLabel.LEFT);
        label_dataFinal = new JLabel("Data final", JLabel.LEFT);

        panel_calendarioInicio = new Calendario().calendario();
        panel_calendarioFim = new Calendario().calendario();

        panel_dtInicio.add(label_dataInicial);
        panel_dtInicio.add(panel_calendarioInicio);
        panel_dtFim.add(label_dataFinal);
        panel_dtFim.add(panel_calendarioFim);

        panel_EscolherData.add(panel_dtInicio);
        panel_EscolherData.add(panel_dtFim);

        fit_Redimen_Heigth(panel_EscolherData);

        return panel_EscolherData;

    }

    public void escolherDatas(){

        panel_DadosPesquisa.add(calendarioInicioFim());
        painel_Tela_Relatorios.add(panel_DadosPesquisa,BorderLayout.LINE_START);

    }
 
    public JPanel comboBoxStatus(){
        
        JPanel Painel_comboBox = new JPanel();
        //Painel_comboBox.setBackground(Color.BLUE);
        JLabel tituloCombo = new JLabel("Situação");
        String[] todosOsStatus = {"Todos","Preparando","Consumindo","Finalizado","Em Transito","Entregue"};
        JComboBox comboStatus = new JComboBox(todosOsStatus);

        comboStatus.setSize(500, comboStatus.getPreferredSize().height);

        Painel_comboBox.add(Box.createRigidArea(new Dimension(0, 20)));
        //Painel_comboBox.add(Box.createRigidArea(new Dimension(25, 0)));
        Painel_comboBox.add(tituloCombo);
        Painel_comboBox.add(Box.createRigidArea(new Dimension(62, 0)));
        Painel_comboBox.add(comboStatus);

        fit_Redimen_Heigth(Painel_comboBox);

        return Painel_comboBox;

    }

    public void painel_comboBox(){

        panel_DadosPesquisa.add(comboBoxStatus());
        painel_Tela_Relatorios.updateUI();
    }

    public void botaoConsultar(){

        JPanel panelParaBotao = new JPanel();
        JButton gerarRelatorio = new JButton("Gerar relatório");
        gerarRelatorio.setBackground(Color.cyan);
        gerarRelatorio.setPreferredSize(new Dimension(150,35));
        gerarRelatorio.setBorder(new RoundedBorder(20));
        
        panelParaBotao.add(gerarRelatorio);
        fit_Redimen_Heigth(panelParaBotao);
        panel_DadosPesquisa.add(Box.createRigidArea(new Dimension(0, 10)));
        panel_DadosPesquisa.add(panelParaBotao);
        panel_DadosPesquisa.add(Box.createRigidArea(new Dimension(0, 20)));
        painel_Tela_Relatorios.updateUI();

    }

    public void consultarPedidos(){

        JPanel PanelConsultarPedidos = new JPanel();
        PanelConsultarPedidos.setLayout(new BoxLayout(PanelConsultarPedidos, BoxLayout.PAGE_AXIS));
        PanelConsultarPedidos.setBorder(BorderFactory.createRaisedBevelBorder());

        JPanel grid_pedidos = new JPanel(new GridLayout(0, 3, 2, 2));
        JScrollPane scrollPedidos = new JScrollPane(grid_pedidos);
        scrollPedidos.setPreferredSize(new Dimension(panel_DadosPesquisa.getSize().width,600));
       
        JLabel pedido = new JLabel("Pedido",JLabel.CENTER);
        JLabel situacao = new JLabel("Situação",JLabel.CENTER);
        JLabel visulizar = new JLabel("visulizar",JLabel.CENTER);
        JPanel Painel_pedido = new JPanel();
        pedido.setBackground(Color.lightGray);
        JPanel Painel_situacao = new JPanel();
        situacao.setBackground(Color.lightGray);
        JPanel Painel_visulizar = new JPanel();
        visulizar.setBackground(Color.lightGray);

        Painel_pedido.add(pedido);
        Painel_situacao.add(situacao); 
        Painel_visulizar.add(visulizar);


        grid_pedidos.add(Painel_pedido);
        grid_pedidos.add(Painel_situacao);
        grid_pedidos.add(Painel_visulizar);

        
        //fit_Redimen_Heigth(scrollPedidos);


        JPanel panelParaBotao = new JPanel();
        JButton consultarPedidos = new JButton("Consultar Pedidos");
        consultarPedidos.setBackground(Color.cyan);
        consultarPedidos.setPreferredSize(new Dimension(200,30));
        consultarPedidos.setBorder(new RoundedBorder(30));
        
        panelParaBotao.add(consultarPedidos);
        
        PanelConsultarPedidos.add(calendarioInicioFim());
        PanelConsultarPedidos.add(comboBoxStatus());
        PanelConsultarPedidos.add(Box.createRigidArea(new Dimension(0, 10)));
        PanelConsultarPedidos.add(panelParaBotao);
        PanelConsultarPedidos.add(Box.createRigidArea(new Dimension(0, 10)));
        PanelConsultarPedidos.add(scrollPedidos);


        panel_DadosPesquisa.add(PanelConsultarPedidos);

        fit_Redimen_Heigth(PanelConsultarPedidos);
        fit_Redimen_Heigth(panelParaBotao);
        fit_Redimen_Heigth(grid_pedidos);
        fit_Redimen_Heigth(painel_Tela_Relatorios);

        painel_Tela_Relatorios.updateUI();

    }

    public JPanel resultadoDaConsulta(){

        JPanel PanelResultadoItens = new JPanel();
        PanelResultadoItens.setLayout(new BoxLayout(PanelResultadoItens, BoxLayout.PAGE_AXIS));
        PanelResultadoItens.setBorder(BorderFactory.createRaisedBevelBorder());
        PanelResultadoItens.setPreferredSize(new Dimension(200,600));



        JPanel grid_Itens = new JPanel(new GridLayout(0, 3, 20, 20));
        JScrollPane scrollItens = new JScrollPane(grid_Itens);
        scrollItens.setPreferredSize(new Dimension(500,600));

        JLabel Descricao = new JLabel("Descricao",JLabel.CENTER);
        JLabel Qtde = new JLabel("Qtde",JLabel.CENTER);
        JLabel Valor = new JLabel("Valor",JLabel.CENTER);
        JPanel Painel_Descricao = new JPanel();
        Descricao.setBackground(Color.lightGray);
        JPanel Painel_Qtde = new JPanel();
        Qtde.setBackground(Color.lightGray);
        JPanel Painel_Valor = new JPanel();
        Valor.setBackground(Color.lightGray);

        Painel_Descricao.add(Descricao);
        Painel_Qtde.add(Qtde); 
        Painel_Valor.add(Valor);
        Painel_Descricao.setBackground(Color.pink);


        grid_Itens.add(Painel_Descricao);
        grid_Itens.add(Painel_Qtde);
        grid_Itens.add(Painel_Valor);
        //grid_Itens.setMaximumSize(new Dimension(grid_Itens.getMinimumSize().width, grid_Itens.getMinimumSize().height));
        //jpanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, jpanel.getMinimumSize().height));
        //PanelResultadoItens.setMaximumSize(new Dimension(PanelResultadoItens.getMinimumSize().width, PanelResultadoItens.getMinimumSize().height));

        Painel_Descricao.setPreferredSize(new Dimension(30, 30));
        Painel_Qtde.setPreferredSize(new Dimension(30, 30));
        Painel_Valor.setPreferredSize(new Dimension(30, 30));

        //PanelResultadoItens.add(grid_Itens);

        // fit_Redimen_Heigth(Painel_Descricao);
        // fit_Redimen_Heigth(Painel_Qtde);
        // fit_Redimen_Heigth(Painel_Valor);

        // fit_Redimen_Heigth(PanelResultadoItens);
        // fit_Redimen_Heigth(grid_Itens);

        return PanelResultadoItens;
    }

    public JPanel Dadosgraficos(){

        final DesenhandoGraficos desenhando = new DesenhandoGraficos();
        
        desenhando.setTitulos("Amostras por Periodo", "Mes",
        "Quantidade de Amostras");
        desenhando.setParametros(30, "Jan.");
        desenhando.setParametros(60, "Fev.");
        desenhando.setParametros(25, "Mar.");
        desenhando.setParametros(45, "Abr.");
        desenhando.setParametros(115, "Mai.");
        desenhando.setParametros(73, "Jun.");
        desenhando.setParametros(87, "Jul.");
        desenhando.setParametros(55, "Ago.");
        desenhando.setParametros(19, "Set.");
        desenhando.setParametros(90, "Out.");
        desenhando.setParametros(45, "Nov.");
        desenhando.setParametros(102, "Dez.");

        desenhando.setTipoGrafico(1);

        return desenhando;

}    
    public void fit_Redimen_Heigth(JPanel jpanel) {
        jpanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, jpanel.getMinimumSize().height));
    }

}


