package com.pguisolffi.Paineis;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.pguisolffi.Configuracoes;
import com.pguisolffi.Acoes.Botoes_Delivery;
import com.pguisolffi.Objetos.Objeto_Delivery;
import com.pguisolffi.Telas.Tela_AddItens;
import com.pguisolffi.Utilidades.Globals;
import com.pguisolffi.Utilidades.RedimensionarComplementos;
import com.pguisolffi.Utilidades.botesConstrutor;
import com.pguisolffi.sgbd.Bd_get;

public class Painel_Delivery extends JPanel implements ActionListener {

    // Patric
    public static int numeroPedido;
    public static int linhasGridPreparando = 1;
    public static int linhasGridTransito = 1;
    public static int linhasGridEntregas = 1;
    String duracao, horaEntrada;
    List<JLabel> list_L_Duracao, list_L_numeroPedido, list_l_Editar;
    JLabel lduracao, lHoraEntrega, lFinalizar, liberar, lPreparando, lEmTransito, lUltimasEntregas, lTitulo, lNPedido;
    JButton btnPlay, btnEye, btnAdd;

    public static JButton botao, botao2, botao3;
    public static JScrollPane scrollDelivery;
    public static JPanel painelPrincipal_Delivery, painelTopo, painelTituloPreparando, painelTituloTransito,
            painelTituloEntregas;

    // List<Objeto_Delivery> listaDeliveryModels = new ArrayList<Objeto_Delivery>();
    public static List<Objeto_Delivery> listPreparando = new ArrayList<Objeto_Delivery>();
    public static List<Objeto_Delivery> listEmTransito = new ArrayList<Objeto_Delivery>();
    public static List<Objeto_Delivery> listUltimasEntregas = new ArrayList<Objeto_Delivery>();

    public static JPanel painelPreparando_Grid = new JPanel(new GridLayout(linhasGridPreparando, 4));
    public static JPanel painelTransito_Grid = new JPanel(new GridLayout(linhasGridTransito, 4));
    public static JPanel painelEntregas_Grid = new JPanel(new GridLayout(linhasGridEntregas, 4));

    // private List<JLabel> mesas;
    int qtde_mesas = Configuracoes.qtde_mesas;

    public Painel_Delivery() throws InterruptedException, ExecutionException, IOException {

        RedimensionarComplementos redim = new RedimensionarComplementos();
        int largura_FramePrincipal = redim.Largura_FrameMesas();
        int Altura_FramePrincipal = redim.Altura_FrameMesas();

        // INSTANCIANDO
        list_L_Duracao = new ArrayList<JLabel>();
        list_L_numeroPedido = new ArrayList<JLabel>();
        list_l_Editar = new ArrayList<JLabel>();
        list_L_Duracao.add(new JLabel("Duração", JLabel.CENTER));
        list_L_Duracao.add(new JLabel("Duração", JLabel.CENTER));
        list_L_Duracao.add(new JLabel("Duração", JLabel.CENTER));
        list_L_numeroPedido.add(new JLabel("Nº Pedido", JLabel.CENTER));
        list_L_numeroPedido.add(new JLabel("Nº Pedido", JLabel.CENTER));
        list_L_numeroPedido.add(new JLabel("Nº Pedido", JLabel.CENTER));
        lHoraEntrega = new JLabel("Entrega", JLabel.CENTER);
        list_l_Editar.add(new JLabel("Editar", JLabel.CENTER));
        list_l_Editar.add(new JLabel("Editar", JLabel.CENTER));
        list_l_Editar.add(new JLabel("Editar", JLabel.CENTER));
        liberar = new JLabel("Liberar", JLabel.CENTER);
        lFinalizar = new JLabel("Finalizar", JLabel.CENTER);
        lPreparando = new JLabel("Preparando", JLabel.CENTER);
        lEmTransito = new JLabel("Em trânsito", JLabel.CENTER);
        lUltimasEntregas = new JLabel("Últimas Entregas", JLabel.CENTER);
        lTitulo = new JLabel("        DELÍVERY");
        painelPrincipal_Delivery = new JPanel();
        painelPrincipal_Delivery.setLayout(new BoxLayout(painelPrincipal_Delivery, BoxLayout.PAGE_AXIS));
        scrollDelivery = new JScrollPane(painelPrincipal_Delivery, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        botesConstrutor btnsMesas = new botesConstrutor();
        painelTopo = new JPanel(new FlowLayout(FlowLayout.LEADING));
        painelTituloPreparando = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelTituloTransito = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelTituloEntregas = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // CORES, FONTS
        {
            lTitulo.setFont(new Font("Courier", Font.BOLD, (int)Math.round(largura_FramePrincipal*0.010667
            )));
            painelTituloPreparando.setBackground(Color.lightGray);
            painelTituloTransito.setBackground(Color.lightGray);
            painelTituloEntregas.setBackground(Color.lightGray);
            painelPreparando_Grid.setBackground(Color.white);
            painelTransito_Grid.setBackground(Color.white);
            painelEntregas_Grid.setBackground(Color.white);
        }

        // DIMENÇÕES DA LARGURA DO SCROLL E DIMENSÕES DO PAINEL PRINCIPAL DO DELIVERY
        {
            scrollDelivery.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
            scrollDelivery.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
            painelPrincipal_Delivery.setBorder(BorderFactory.createLineBorder(Color.black));
            //300/650
            scrollDelivery.setPreferredSize(new Dimension((int)Math.round(largura_FramePrincipal*0.16), (int)Math.round(Altura_FramePrincipal*0.601031)));
            scrollDelivery.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollDelivery.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        }

        // ADICIONANDO OS TITULOS E COLUNAS
        {
            btnPlay = btnsMesas.addDeliveryButton;
            painelTopo.add(btnPlay);
            painelTopo.add(lTitulo);
            painelTituloPreparando.add(lPreparando);
            painelPreparando_Grid.add(list_L_numeroPedido.get(0));
            painelPreparando_Grid.add(liberar);
            painelPreparando_Grid.add(list_l_Editar.get(0));
            painelPreparando_Grid.add(list_L_Duracao.get(0));
            painelTituloTransito.add(lEmTransito);
            painelTransito_Grid.add(list_L_numeroPedido.get(1));
            painelTransito_Grid.add(lFinalizar);
            painelTransito_Grid.add(list_l_Editar.get(1));
            painelTransito_Grid.add(list_L_Duracao.get(1));
            painelTituloEntregas.add(lUltimasEntregas);
            painelEntregas_Grid.add(list_L_numeroPedido.get(2));
            painelEntregas_Grid.add(list_l_Editar.get(2));
            painelEntregas_Grid.add(lHoraEntrega);
            painelEntregas_Grid.add(list_L_Duracao.get(2));
        }

        // REDIMENSIONAR OS TAMANHOS (FIT)
        {
            fit_Redimen_Heigth(painelTituloPreparando);
            fit_Redimen_Heigth(painelTituloTransito);
            fit_Redimen_Heigth(painelTituloEntregas);
            fit_Redimen_Heigth(painelTopo);
            fit_Redimen_Heigth(painelPreparando_Grid);
            fit_Redimen_Heigth(painelTransito_Grid);
            fit_Redimen_Heigth(painelEntregas_Grid);
            fit_Redimen_Heigth(painelTituloPreparando);
            btnPlay.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnPlay.getMinimumSize().height));

        }

        // Adições no Painel principal
        {
            painelPrincipal_Delivery.add(painelTopo);
            painelPrincipal_Delivery.add(painelTituloPreparando);
            painelPrincipal_Delivery.add(painelPreparando_Grid);
            painelPrincipal_Delivery.add(Box.createRigidArea(new Dimension(0, 50))); //
            painelPrincipal_Delivery.add(painelTituloTransito);
            painelPrincipal_Delivery.add(painelTransito_Grid);
            painelPrincipal_Delivery.add(Box.createRigidArea(new Dimension(0, 50)));
            painelPrincipal_Delivery.add(painelTituloEntregas);
            painelPrincipal_Delivery.add(painelEntregas_Grid);
        }


        List<Integer> Pedidos_deliverysPreparando = new Bd_get().get_Deliverys("Preparando");
        List<Integer> Pedidos_deliverysEmTransito = new Bd_get().get_Deliverys("Em Transito");
        List<Integer> Pedidos_deliverysEntregue = new Bd_get().get_Deliverys("Entregue");


        if (!Pedidos_deliverysPreparando.isEmpty()){
            for (int x = 0; x <Pedidos_deliverysPreparando.size();x++) {
                Globals.ehAtendimentoAntigo = true;
                Globals.ehDelivery = true;
                new Botoes_Delivery().Preparando(Pedidos_deliverysPreparando.get(x));
            }
        }

        if (!Pedidos_deliverysEmTransito.isEmpty()){
            for (int x = 0; x <Pedidos_deliverysEmTransito.size();x++) {
                Globals.ehAtendimentoAntigo = true;
                new Botoes_Delivery().EmTransito(Pedidos_deliverysEmTransito.get(x));
            }
        }

        if (!Pedidos_deliverysEntregue.isEmpty()){
            Globals.ehAtendimentoAntigo = true;
            for (int x = 0; x <Pedidos_deliverysEntregue.size();x++) {
                new Botoes_Delivery().Entregue(Pedidos_deliverysEntregue.get(x));
            }
        }




        this.add(scrollDelivery);

        this.btnPlay.addActionListener(this);

    }

    public void fit_Redimen_Heigth(JPanel jpanel) {
        jpanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, jpanel.getMinimumSize().height));
    }

    public void actionPerformed(ActionEvent e) {

        //AO CLICAR NA MOTINHO E ENVIAR UM NOVO ATENDIMENTO
        if (e.getSource() == btnPlay) {
            Globals.numeroPedido++;
            Globals.ehAtendimentoAntigo = false;
            Globals.ehDelivery = true;
            try {
                new Tela_AddItens(null);
                //new Botoes_Delivery().Preparando(Globals.numeroPedido);
            } catch (InterruptedException | ExecutionException | IOException e1) {
                e1.printStackTrace();
            }    
        }

    }

}
