package com.pguisolffi.Telas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.pguisolffi.Acoes.Carregar_ItensAtendimento;
import com.pguisolffi.Graficos.DesenhandoGraficos;
import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Utilidades.Calendario;
import com.pguisolffi.Utilidades.Globals;
import com.pguisolffi.Utilidades.RedimensionarComplementos;
import com.pguisolffi.Utilidades.RoundedBorder;
import com.pguisolffi.Utilidades.botesConstrutor;
import com.pguisolffi.sgbd.Bd_get;

import org.jdesktop.swingx.JXDatePicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Timestamp;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import java.awt.*;


public class Aba_Relatorios extends JButton implements ActionListener{

    public static JPanel painel_Tela_Relatorios;

    JButton btn_consultarPedidos;
    List<JComboBox> list_comboBox_Status = new ArrayList<JComboBox>();
    List<JXDatePicker> list_datasDeInicio= new ArrayList<JXDatePicker>();
    List<JXDatePicker> list_datasDeFim= new ArrayList<JXDatePicker>();
    List<Integer> listDistinct_Pedidos= new ArrayList<Integer>();
    List<String> listDistinct_ItensProdutos= new ArrayList<String>();
    List<JButton> btns_Olhar= new ArrayList<JButton>();

    JButton btn_gerarRelatorio;
    JPanel grid_pedidos;
    JPanel grid_Itens;
    JPanel valorTotal;
    JPanel PanelConsultarPedidos;
    GridBagConstraints c;

    List<Objeto_Atendimento> list_pedidosRelatorio = new ArrayList<Objeto_Atendimento>();
    List<Objeto_Atendimento> list_atendimentosRelatorio = new ArrayList<Objeto_Atendimento>();

    JPanel panel_DadosPesquisa,panel_respostaPesquisa,panel_GraficoQtde,panel_graficoReceita, 
    panel_EscolherData, panel_calendarioInicio, panel_calendarioFim, panel_dtInicio, panel_dtFim,painel_Center;

    JLabel label_dataInicial, label_dataFinal,label_ValorTotal;

    public JPanel Relatorios(){

        painel_Tela_Relatorios = new JPanel(new BorderLayout());
        painel_Tela_Relatorios.setBorder(new EmptyBorder(0,30,70,30));

        //painel_Center = new JPanel(new BorderLayout());
        panel_DadosPesquisa = new JPanel();
        panel_DadosPesquisa.setLayout(new BoxLayout(panel_DadosPesquisa, BoxLayout.PAGE_AXIS));
        panel_DadosPesquisa.setBorder(new EmptyBorder(10,70,10,40));
        //painel_Tela_Relatorios.setPreferredSize(new Dimension(1200,800));

        JPanel grafico = new JPanel();
        //grafico.setBackground(Color.green);
        grafico.setBorder(new EmptyBorder(10,40,10,35));
        grafico.setLayout(new BoxLayout(grafico, BoxLayout.PAGE_AXIS));
        grafico.setPreferredSize(new Dimension(600,600));
        //grafico.setBackground(null);
        grafico.add(DadosgraficosReceita());
        grafico.add(DadosgraficosQtde());
        
        
        titulo_TelaRelatorios();
        escolherDatas();
        painel_comboBox();
        botaoConsultar();
        consultarPedidos();
        

        //painel_Center.add(resultadoDaConsulta(), BorderLayout.LINE_START);

        painel_Tela_Relatorios.add(resultadoDaConsulta(), BorderLayout.CENTER);
        painel_Tela_Relatorios.add(grafico, BorderLayout.LINE_END);
        painel_Tela_Relatorios.add(new JPanel(), BorderLayout.PAGE_END);
        
        painel_Tela_Relatorios.updateUI();

        return painel_Tela_Relatorios;
    }

    public void titulo_TelaRelatorios(){

        RedimensionarComplementos redim = new RedimensionarComplementos();
		int largura_FramePrincipal = redim.Largura_FrameMesas();
		int Altura_FramePrincipal = redim.Altura_FrameMesas();

        JPanel panel = new JPanel();
        //panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        JLabel labelTituloPainelPrincipal = new JLabel("Relatório de atendimentos", JLabel.CENTER);
		labelTituloPainelPrincipal.setFont(new Font("Futura", Font.BOLD, (int)Math.round(largura_FramePrincipal*0.02)));
        panel.add(labelTituloPainelPrincipal);
        panel.add(Box.createRigidArea(new Dimension(0, 100)));
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

        JXDatePicker ComboDataDeInicio = new Calendario().calendario();
        JXDatePicker ComboDataDeFim = new Calendario().calendario();

        list_datasDeInicio.add(ComboDataDeInicio);
        list_datasDeFim.add(ComboDataDeFim);

        panel_calendarioInicio = new JPanel();
        panel_calendarioFim = new JPanel();

        panel_calendarioInicio.add(ComboDataDeInicio);
        panel_calendarioFim.add(ComboDataDeFim);

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

        list_comboBox_Status.add(comboStatus);

        fit_Redimen_Heigth(Painel_comboBox);

        return Painel_comboBox;

    }

    public void painel_comboBox(){

        panel_DadosPesquisa.add(comboBoxStatus());
        painel_Tela_Relatorios.updateUI();
    }

    public void botaoConsultar(){

        JPanel panelParaBotao = new JPanel();
        btn_gerarRelatorio = new JButton("Gerar relatório");
        btn_gerarRelatorio.setBackground(Color.orange);
        btn_gerarRelatorio.setPreferredSize(new Dimension(150,35));
        btn_gerarRelatorio.setBorder(new RoundedBorder(20));
        
        panelParaBotao.add(btn_gerarRelatorio);

        btn_gerarRelatorio.addActionListener(this);

        fit_Redimen_Heigth(panelParaBotao);
        panel_DadosPesquisa.add(Box.createRigidArea(new Dimension(0, 10)));
        panel_DadosPesquisa.add(panelParaBotao);
        panel_DadosPesquisa.add(Box.createRigidArea(new Dimension(0, 20)));
        painel_Tela_Relatorios.updateUI();

    }

    public void consultarPedidos(){

        PanelConsultarPedidos = new JPanel();
        PanelConsultarPedidos.setLayout(new BoxLayout(PanelConsultarPedidos, BoxLayout.PAGE_AXIS));
        PanelConsultarPedidos.setBorder(BorderFactory.createRaisedBevelBorder());

        JPanel Panel_paraScroll = new JPanel();

        grid_pedidos = new JPanel(new GridLayout(0, 3, 2, 2));
        grid_pedidos.setBorder(null);
        JScrollPane scrollPedidos = new JScrollPane(Panel_paraScroll);
        scrollPedidos.setBorder(null);
        scrollPedidos.setPreferredSize(new Dimension(panel_DadosPesquisa.getSize().width,600));
       
        JLabel pedido = new JLabel("Pedido",JLabel.CENTER);
        JLabel situacao = new JLabel("Situação",JLabel.CENTER);
        JLabel visulizar = new JLabel("visulizar",JLabel.CENTER);
        JPanel Painel_pedido = new JPanel();
        Painel_pedido.setBackground(Color.lightGray);
        JPanel Painel_situacao = new JPanel();
        Painel_situacao.setBackground(Color.lightGray);
        JPanel Painel_visulizar = new JPanel();
        Painel_visulizar.setBackground(Color.lightGray);

        Painel_pedido.add(pedido);
        Painel_situacao.add(situacao); 
        Painel_visulizar.add(visulizar);


        grid_pedidos.add(Painel_pedido);
        grid_pedidos.add(Painel_situacao);
        grid_pedidos.add(Painel_visulizar);

        JPanel panelParaBotao = new JPanel();
        btn_consultarPedidos = new JButton("Consultar Pedidos");
        btn_consultarPedidos.setBackground(Color.orange);
        btn_consultarPedidos.setPreferredSize(new Dimension(200,30));
        btn_consultarPedidos.setBorder(new RoundedBorder(30));

        btn_consultarPedidos.addActionListener(this);
        
        panelParaBotao.add(btn_consultarPedidos);
        
        PanelConsultarPedidos.add(calendarioInicioFim());
        PanelConsultarPedidos.add(comboBoxStatus());
        PanelConsultarPedidos.add(Box.createRigidArea(new Dimension(0, 10)));
        PanelConsultarPedidos.add(panelParaBotao);
        PanelConsultarPedidos.add(Box.createRigidArea(new Dimension(0, 10)));
        Panel_paraScroll.add(grid_pedidos);
        PanelConsultarPedidos.add(scrollPedidos);


        panel_DadosPesquisa.add(PanelConsultarPedidos);

        //fit_Redimen_Heigth(PanelConsultarPedidos);
        fit_Redimen_Heigth(panelParaBotao);
        fit_Redimen_Heigth(Panel_paraScroll);
        //fit_Redimen_Heigth(painel_Tela_Relatorios);
        //fit_Redimen_Heigth(panel_DadosPesquisa);

        painel_Tela_Relatorios.updateUI();

    }

    public JPanel resultadoDaConsulta(){

        JPanel PanelResultadoItens = new JPanel();
        PanelResultadoItens.setLayout(new FlowLayout());
        //PanelResultadoItens.setBorder(BorderFactory.createRaisedBevelBorder());
        //PanelResultadoItens.setBackground(Color.green);
        //PanelResultadoItens.setPreferredSize(new Dimension(500,1200));

        JPanel PanelResultadoItens2 = new JPanel();
        PanelResultadoItens2.setLayout(new BoxLayout(PanelResultadoItens2,BoxLayout.PAGE_AXIS ));
        PanelResultadoItens2.setPreferredSize(new Dimension(500,800));
        PanelResultadoItens2.setBorder(BorderFactory.createRaisedBevelBorder());

        valorTotal = new JPanel();
        valorTotal.setBackground(Color.orange);
        label_ValorTotal = new JLabel();
        label_ValorTotal.setFont(new Font("book Antiqua", Font.BOLD, 14));
        valorTotal.add(label_ValorTotal);
        valorTotal.setVisible(false);
        

        grid_Itens = new JPanel(new GridBagLayout());
        c = new GridBagConstraints();
        JScrollPane scrollItens = new JScrollPane(PanelResultadoItens);
        scrollItens.setPreferredSize(new Dimension(500,900));
        scrollItens.setMaximumSize(new Dimension(500,900));
        //scrollItens.setBorder(BorderFactory.createRaisedBevelBorder());

        cabecalhoGridResultado();

        PanelResultadoItens2.add(grid_Itens);
        PanelResultadoItens2.add(valorTotal);
        fit_Redimen_Heigth(PanelResultadoItens2);
        fit_Redimen_Heigth(grid_Itens);
        fit_Redimen_Heigth(PanelResultadoItens);
        fit_Redimen_Heigth(valorTotal);
        PanelResultadoItens.add(PanelResultadoItens2);



        return PanelResultadoItens;
    }

    public void cabecalhoGridResultado(){
        
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
        Painel_Descricao.setBackground(Color.orange);
        Painel_Qtde.setBackground(Color.orange);
        Painel_Valor.setBackground(Color.orange);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 1;
        c.weightx = 3f;
        grid_Itens.add(Painel_Descricao, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1f;
        //c.anchor = GridBagConstraints.EAST;
        grid_Itens.add(Painel_Qtde, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 1f;
        grid_Itens.add(Painel_Valor, c);
    }

    public JPanel DadosgraficosReceita(){

        final DesenhandoGraficos desenhando = new DesenhandoGraficos();
        
        desenhando.setTitulos("Receita por dia", "Dia",
        "Receita R$");
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

        desenhando.setTipoGrafico(0);

        return desenhando;

}    
    
    public JPanel DadosgraficosQtde(){

    final DesenhandoGraficos desenhando = new DesenhandoGraficos();
    
    desenhando.setTitulos("Qtde por dia", "Dia",
    "Quantidade");
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

    @Override
    public void actionPerformed(ActionEvent e) {
    
        //Ao apertar, consultar pedidos
        if (e.getSource() == btn_consultarPedidos){

            String status =  list_comboBox_Status.get(1).getSelectedItem().toString();

            JFormattedTextField editorInicio = list_datasDeInicio.get(1).getEditor();
            Date dateInicio = (Date) editorInicio.getValue();
            Timestamp tsInicio = new Timestamp(dateInicio.getTime());  

            JFormattedTextField editorFim = list_datasDeFim.get(1).getEditor();
            Date dateFim = (Date) editorFim.getValue();
            Timestamp tsFim = new Timestamp(dateFim.getTime()); 


            try {
                list_pedidosRelatorio = new Bd_get().Get_ItensAtendimentoRelatorio(status,tsInicio.toString(),tsFim.toString());
            } catch (InterruptedException | ExecutionException | IOException e1) {
                e1.printStackTrace();
            }

            //Gera Distincts Pedidos
            listDistinct_Pedidos = list_pedidosRelatorio.stream().map(o -> o.pedido).distinct().collect(Collectors.toList());

            for (Integer objDistinct : listDistinct_Pedidos) {

                JPanel pedido = new JPanel();
                JLabel numeroPedido = new JLabel(String.valueOf(objDistinct));
                pedido.add(numeroPedido);
                grid_pedidos.add(pedido);

                for(int x=0; x < list_pedidosRelatorio.size(); x++){
                    if (list_pedidosRelatorio.get(x).pedido == objDistinct){

                        botesConstrutor btns = new botesConstrutor();

                        JLabel situacao = new JLabel(list_pedidosRelatorio.get(x).statusAtendimento);
                        JPanel psituacao = new JPanel();
                        psituacao.add(situacao);

                        JButton botaoOlhar = btns.EyeButtonDelivery;
                        botaoOlhar.setBackground(null);
                        btns_Olhar.add(botaoOlhar);

                        botaoOlhar.addActionListener(this);
                                                        
                        grid_pedidos.add(psituacao);
                        grid_pedidos.add(botaoOlhar);
                        fit_Redimen_Heigth(grid_pedidos);
                        fit_Redimen_Heigth(psituacao);
                        fit_Redimen_Heigth(pedido);
                        fit_Redimen_Heigth(grid_pedidos);
                        fit_Redimen_Heigth(PanelConsultarPedidos);
                        x=list_pedidosRelatorio.size();

                    }
                }


                JPanel situacao = new JPanel();
                JLabel labelSituacao = new JLabel(String.valueOf(objDistinct));
                pedido.add(numeroPedido);

                fit_Redimen_Heigth(situacao);
                fit_Redimen_Heigth(grid_pedidos);

                painel_Tela_Relatorios.updateUI();
                
            }

        }
       
        //AO APERTAR NO BOTAO OLHAR
        for (int x=0;x< btns_Olhar.size();x++){
            if (e.getSource() == btns_Olhar.get(x)){
                System.out.println("Pedido: "+listDistinct_Pedidos.get(x));

                List<Objeto_Atendimento> list_ObjetosAtendimentos = new ArrayList<Objeto_Atendimento>();
                Globals.ehAtendimentoAntigo = true;
				

				try {
					list_ObjetosAtendimentos = new Bd_get().Get_ItensAtendimentoPedidos(listDistinct_Pedidos.get(x));
					Globals.nuseqItemAtual = new Bd_get().get_MaxNuSeq(list_ObjetosAtendimentos.get(0).pedido) + 1;
				} catch (InterruptedException | ExecutionException | IOException e2) {
					e2.printStackTrace();
				}

                if (!list_ObjetosAtendimentos.get(0).ehDelivery){
                    Globals.ehDelivery = false;
                    Globals.pedidoAtual = list_ObjetosAtendimentos.get(0).pedido;
                    try {
                        if (!list_ObjetosAtendimentos.isEmpty()) {
                        new Tela_AddItens(list_ObjetosAtendimentos.get(0).numeroMesa);
                        new Carregar_ItensAtendimento(list_ObjetosAtendimentos);
                        }
                    } catch (InterruptedException | ExecutionException | IOException e1) {
                        e1.printStackTrace();
                    }   
                }
                else{
                    Globals.ehDelivery = true;
                    Globals.pedidoAtual = list_ObjetosAtendimentos.get(0).pedido;
                    try {
                        list_ObjetosAtendimentos = new Bd_get().Get_ItensAtendimentoDelivery(listDistinct_Pedidos.get(x));
                    } catch (InterruptedException | ExecutionException | IOException e2) {
                        e2.printStackTrace();
                    }          
                    try {
                        new Tela_AddItens(0);
                    } catch (InterruptedException | ExecutionException | IOException e1) {
                        e1.printStackTrace();
                    }
                    new Carregar_ItensAtendimento(list_ObjetosAtendimentos);

                }


            }
        }

        //AO APERTAR O BOTAO GERAR RELATÓRIO
        if (e.getSource()== btn_gerarRelatorio){

            
           grid_Itens.removeAll();
           cabecalhoGridResultado();

            String status =  list_comboBox_Status.get(0).getSelectedItem().toString();

            JFormattedTextField editorInicio = list_datasDeInicio.get(0).getEditor();
            Date dateInicio = (Date) editorInicio.getValue();
            Timestamp tsInicio = new Timestamp(dateInicio.getTime());  

            JFormattedTextField editorFim = list_datasDeFim.get(0).getEditor();
            Date dateFim = (Date) editorFim.getValue();
            Timestamp tsFim = new Timestamp(dateFim.getTime()); 

            try {
                list_atendimentosRelatorio = new Bd_get().Get_ItensAtendimentoRelatorio(status,tsInicio.toString(),tsFim.toString());
            } catch (InterruptedException | ExecutionException | IOException e1) {
                e1.printStackTrace();
            }

            //Gera Distincts dos produtos retornados.
            listDistinct_ItensProdutos = list_atendimentosRelatorio.stream().map(o -> o.sDescricao).distinct().collect(Collectors.toList());
            int linha = 0;

            for (String produtoDistinct : listDistinct_ItensProdutos){

                //Pegar a Qtde total por ítem
                long Qtde = list_atendimentosRelatorio.stream().filter(o -> o.sDescricao.equals(produtoDistinct)).count();

                Stream<Objeto_Atendimento> ReceitaPorItem = list_atendimentosRelatorio.stream().filter(o -> o.fValorItem > 0 && o.sDescricao.equals(produtoDistinct));
                double ValordoItem = ReceitaPorItem.collect(Collectors.summingDouble(o -> o.fValorItem));

                JPanel panelDescricao = new JPanel();
                JPanel panelQtde = new JPanel();
                JPanel panelValor = new JPanel();

                panelDescricao.add(new JLabel(produtoDistinct.equals("")?"Observação":produtoDistinct));
                panelQtde.add(new JLabel(String.valueOf(Qtde)));
                panelValor.add(new JLabel("R$ "+String.valueOf(ValordoItem)));

                {   
                    //GridBagConstraints c = new GridBagConstraints();
                    c.fill = GridBagConstraints.HORIZONTAL;
                    c.gridx = 0;
                    linha = linha + 1;
                    c.gridy = linha;
                    c.ipadx = 1;
                    c.weightx = 3f;
                    grid_Itens.add(panelDescricao, c);
                    c.fill = GridBagConstraints.HORIZONTAL;
                    c.gridx = 1;
                    c.gridy = linha;
                    c.weightx = 1f;
                    //c.anchor = GridBagConstraints.EAST;
                    grid_Itens.add(panelQtde, c);
                    c.fill = GridBagConstraints.HORIZONTAL;
                    c.gridx = 2;
                    c.gridy = linha;
                    c.weightx = 1f;
                    grid_Itens.add(panelValor, c);
                }

                fit_Redimen_Heigth(grid_Itens);
                painel_Tela_Relatorios.updateUI();

            }

            Stream<Objeto_Atendimento> Receitatotal = list_atendimentosRelatorio.stream().filter(o -> o.fValorItem > 0);
            double ValortotalRelatorio = Receitatotal.collect(Collectors.summingDouble(o -> o.fValorItem));
            label_ValorTotal.setText("TOTAL: R$ "+ValortotalRelatorio);
            valorTotal.setVisible(true);
            fit_Redimen_Heigth(valorTotal);
            painel_Tela_Relatorios.updateUI();

        }

    }

}


