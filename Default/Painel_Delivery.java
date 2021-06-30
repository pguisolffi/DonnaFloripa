package Default;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;

public class Painel_Delivery extends JPanel implements ActionListener {

    // public static List<JLabel> lista_mesas;
    // public static List<JPanel> lista_mesas_painel;

    // Patric
    int numeroPedido, linhasGridPreparando = 1, linhasGridTransito = 1, linhasGridEntregas = 1;
    String duracao, horaEntrada;
    List<JLabel> list_L_Duracao, list_L_numeroPedido, list_l_Editar;
    JLabel lduracao, lHoraEntrega, lFinalizar, liberar, lPreparando, lEmTransito, lUltimasEntregas, lTitulo, lNPedido;
    JButton btnPlay, btnEye, btnAdd;

    public static JButton botao, botao2, botao3;
    public static JScrollPane scrollDelivery;
    public static JPanel painelPrincipal_Delivery, painelTopo, painelTituloPreparando, painelTituloTransito,
            painelTituloEntregas;

    // List<Objeto_Delivery> listaDeliveryModels = new ArrayList<Objeto_Delivery>();
    List<Objeto_Delivery> listPreparando = new ArrayList<Objeto_Delivery>();
    List<Objeto_Delivery> listEmTransito = new ArrayList<Objeto_Delivery>();
    List<Objeto_Delivery> listUltimasEntregas = new ArrayList<Objeto_Delivery>();

    JPanel painelPreparando_Grid = new JPanel(new GridLayout(linhasGridPreparando, 4));
    JPanel painelTransito_Grid = new JPanel(new GridLayout(linhasGridTransito, 4));
    JPanel painelEntregas_Grid = new JPanel(new GridLayout(linhasGridEntregas, 4));

    // private List<JLabel> mesas;

    int qtde_mesas = Configuracoes.qtde_mesas;

    public Painel_Delivery() {

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
        // lista_mesas = new ArrayList<>();
        // lista_mesas_painel = new ArrayList<>();
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
            lTitulo.setFont(new Font("Courier", Font.BOLD, 20));
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

            // scrollDelivery.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            // painelPrincipal_Delivery.setPreferredSize(new Dimension(300, 500));
            painelPrincipal_Delivery.setBorder(BorderFactory.createLineBorder(Color.black));
            scrollDelivery.setPreferredSize(new Dimension(300, 650));
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
            painelTituloPreparando
                    .setMaximumSize(new Dimension(Integer.MAX_VALUE, painelTituloPreparando.getMinimumSize().height));
            painelTituloTransito
                    .setMaximumSize(new Dimension(Integer.MAX_VALUE, painelTituloPreparando.getMinimumSize().height));
            painelTituloEntregas
                    .setMaximumSize(new Dimension(Integer.MAX_VALUE, painelTituloEntregas.getMinimumSize().height));
            btnPlay.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnPlay.getMinimumSize().height));
            painelTopo.setMaximumSize(new Dimension(Integer.MAX_VALUE, painelTopo.getMinimumSize().height));
            painelPreparando_Grid
                    .setMaximumSize(new Dimension(Integer.MAX_VALUE, painelPreparando_Grid.getMinimumSize().height));
            painelTransito_Grid
                    .setMaximumSize(new Dimension(Integer.MAX_VALUE, painelTransito_Grid.getMinimumSize().height));
            painelEntregas_Grid
                    .setMaximumSize(new Dimension(Integer.MAX_VALUE, painelEntregas_Grid.getMinimumSize().height));
        }

        // Adições no Painel principal
        {

            painelPrincipal_Delivery.add(painelTopo);
            painelPrincipal_Delivery.add(painelTituloPreparando);
            painelPrincipal_Delivery.add(painelPreparando_Grid);
            painelPrincipal_Delivery.add(Box.createRigidArea(new Dimension(0, 50))); //
            // SizedBox
            painelPrincipal_Delivery.add(painelTituloTransito);
            painelPrincipal_Delivery.add(painelTransito_Grid);
            painelPrincipal_Delivery.add(Box.createRigidArea(new Dimension(0, 50))); //
            // SizedBox
            painelPrincipal_Delivery.add(painelTituloEntregas);
            painelPrincipal_Delivery.add(painelEntregas_Grid);
            // this.add(painelPrincipal_Delivery);
        }

        // Botões dos pedidos
        {
            // this.add(btnPlay);
        }

        this.add(scrollDelivery);

        // ADICIONA OS "ESCUTADORES"
        this.btnPlay.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnPlay) {

            botesConstrutor btnsMesas = new botesConstrutor();
            Objeto_Delivery deliveryModel = new Objeto_Delivery(numeroPedido, duracao, horaEntrada, lduracao, lNPedido,
                    lHoraEntrega, btnPlay, btnEye, btnAdd);

            linhasGridPreparando = linhasGridPreparando + 1;
            painelPreparando_Grid.setLayout(new GridLayout(linhasGridPreparando, 4));

            painelPreparando_Grid
                    .setMaximumSize(new Dimension(Integer.MAX_VALUE, painelPreparando_Grid.getMinimumSize().height));

            deliveryModel.btnPlay = btnsMesas.ConfirmButtonDelivery;
            deliveryModel.btnPlay.setAlignmentX(JButton.CENTER_ALIGNMENT);
            deliveryModel.btnEye = btnsMesas.EyeButtonDelivery;
            deliveryModel.btnEye.setAlignmentX(JButton.CENTER_ALIGNMENT);
            deliveryModel.horaEntrada = "12:20";
            deliveryModel.lduracao = new JLabel("06:00");
            deliveryModel.lduracao.setHorizontalAlignment(JLabel.CENTER);
            deliveryModel.nPedido = new JLabel("1112231");
            deliveryModel.nPedido.setHorizontalAlignment(JLabel.CENTER);

            painelPreparando_Grid.add(deliveryModel.nPedido);
            painelPreparando_Grid.add(deliveryModel.btnPlay);
            painelPreparando_Grid.add(deliveryModel.btnEye);
            painelPreparando_Grid.add(deliveryModel.lduracao);

            listPreparando.add(deliveryModel);

            deliveryModel.btnPlay.addActionListener(this);
            deliveryModel.btnEye.addActionListener(this);

            painelPrincipal_Delivery.updateUI();

        }

        for (int x = 0; x < listPreparando.size(); x++) {

            if (e.getSource() == listPreparando.get(x).btnPlay) {

                botesConstrutor btnsMesas = new botesConstrutor();
                linhasGridTransito = linhasGridTransito + 1;
                painelTransito_Grid.setLayout(new GridLayout(linhasGridTransito, 4));

                Objeto_Delivery deliveryModel = new Objeto_Delivery(numeroPedido, duracao, horaEntrada, lduracao,
                        lNPedido, lHoraEntrega, btnPlay, btnEye, btnAdd);

                deliveryModel.btnPlay = btnsMesas.ConfirmButtonDelivery;
                deliveryModel.btnPlay.setAlignmentX(JButton.CENTER_ALIGNMENT);
                deliveryModel.btnEye = btnsMesas.EyeButtonDelivery;
                deliveryModel.btnEye.setAlignmentX(JButton.CENTER_ALIGNMENT);
                deliveryModel.lduracao = listPreparando.get(x).lduracao;
                deliveryModel.nPedido = listPreparando.get(x).nPedido;

                painelTransito_Grid.add(deliveryModel.nPedido);
                painelTransito_Grid.add(deliveryModel.btnPlay);
                painelTransito_Grid.add(deliveryModel.btnEye);
                painelTransito_Grid.add(deliveryModel.lduracao);

                listEmTransito.add(deliveryModel);

                painelTransito_Grid
                        .setMaximumSize(new Dimension(Integer.MAX_VALUE, painelTransito_Grid.getMinimumSize().height));

                linhasGridPreparando = linhasGridPreparando - 1;
                painelPreparando_Grid.setLayout(new GridLayout(linhasGridPreparando, 4));

                painelPreparando_Grid.remove(listPreparando.get(x).nPedido);
                painelPreparando_Grid.remove(listPreparando.get(x).btnPlay);
                painelPreparando_Grid.remove(listPreparando.get(x).btnEye);
                painelPreparando_Grid.remove(listPreparando.get(x).lduracao);

                painelPreparando_Grid.setMaximumSize(
                        new Dimension(Integer.MAX_VALUE, painelPreparando_Grid.getMinimumSize().height));

                deliveryModel.btnPlay.addActionListener(this);
                deliveryModel.btnEye.addActionListener(this);

                painelPrincipal_Delivery.updateUI();

            }
        }

        for (int x = 0; x < listEmTransito.size(); x++) {

            if (e.getSource() == listEmTransito.get(x).btnPlay) {

                botesConstrutor btnsMesas = new botesConstrutor();
                linhasGridEntregas = linhasGridEntregas + 1;
                painelEntregas_Grid.setLayout(new GridLayout(linhasGridEntregas, 4));

                Objeto_Delivery deliveryModel = new Objeto_Delivery(numeroPedido, duracao, horaEntrada, lduracao,
                        lNPedido, lHoraEntrega, btnPlay, btnEye, btnAdd);

                deliveryModel.btnPlay = btnsMesas.ConfirmButtonDelivery;
                deliveryModel.btnPlay.setAlignmentX(JButton.CENTER_ALIGNMENT);
                deliveryModel.btnEye = btnsMesas.EyeButtonDelivery;
                deliveryModel.btnEye.setAlignmentX(JButton.CENTER_ALIGNMENT);
                deliveryModel.lduracao = listEmTransito.get(x).lduracao;
                deliveryModel.nPedido = listEmTransito.get(x).nPedido;

                painelEntregas_Grid.add(deliveryModel.nPedido);
                painelEntregas_Grid.add(deliveryModel.btnPlay);
                painelEntregas_Grid.add(deliveryModel.btnEye);
                painelEntregas_Grid.add(deliveryModel.lduracao);

                listUltimasEntregas.add(deliveryModel);

                painelEntregas_Grid
                        .setMaximumSize(new Dimension(Integer.MAX_VALUE, painelEntregas_Grid.getMinimumSize().height));

                linhasGridTransito = linhasGridTransito - 1;
                painelTransito_Grid.setLayout(new GridLayout(linhasGridTransito, 4));

                painelTransito_Grid.remove(listEmTransito.get(x).nPedido);
                painelTransito_Grid.remove(listEmTransito.get(x).btnPlay);
                painelTransito_Grid.remove(listEmTransito.get(x).btnEye);
                painelTransito_Grid.remove(listEmTransito.get(x).lduracao);

                painelTransito_Grid
                        .setMaximumSize(new Dimension(Integer.MAX_VALUE, painelTransito_Grid.getMinimumSize().height));

                deliveryModel.btnPlay.addActionListener(this);
                deliveryModel.btnEye.addActionListener(this);

                painelPrincipal_Delivery.updateUI();

            }
        }

    }

}
