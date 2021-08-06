package com.pguisolffi.Paineis;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.SwingConstants;

import com.pguisolffi.Acoes.Botao_SalvarComanda;
import com.pguisolffi.Objetos.Objeto_Mesa;
import com.pguisolffi.Utilidades.Globals;
import com.pguisolffi.Utilidades.botesConstrutor;
import com.pguisolffi.Objetos.Objeto_Atendimento;

import javax.swing.ScrollPaneConstants;

public class Painel_Comanda extends JPanel implements ActionListener {

    public static JPanel painelItensDaComanda, pBox_Comanda, pPanel_EspacoDireito, pPanel_DentroEspacoDireito;
    public static JLabel lTotalGeral;
    public int numeroMesaAtual;

    JPanel pPanel_Impressora, pPainel_nomeMesa, pPanel_NumeroComanda, pPanel_tituloComanda, pPanel_TotalGeral,
            pPanel_botaoSalvar;

    JLabel lNomeMesa, lNumeroComanda, lTituloComanda;
    JButton btn_Impressora, btn_Salvar;
    JScrollPane scrollComanda;

    public static List<Objeto_Atendimento> list_ItensDoAtendimento;
    public static List<Objeto_Atendimento> list_RemoverItensAtendimento;

    public Painel_Comanda(int numeroMesa) {

        list_ItensDoAtendimento = new ArrayList<Objeto_Atendimento>();
        list_RemoverItensAtendimento = new ArrayList<Objeto_Atendimento>();

        numeroMesaAtual = numeroMesa;
        pPanel_EspacoDireito = new JPanel();
        pPanel_DentroEspacoDireito = new JPanel();
        pBox_Comanda = new JPanel();
        pPanel_Impressora = new JPanel();
        btn_Impressora = new JButton();
        pPainel_nomeMesa = new JPanel();
        lNomeMesa = new JLabel();
        pPanel_NumeroComanda = new JPanel();
        lNumeroComanda = new JLabel();
        pPanel_tituloComanda = new JPanel();
        lTituloComanda = new JLabel();
        painelItensDaComanda = new JPanel();
        pPanel_TotalGeral = new JPanel();
        lTotalGeral = new JLabel();
        pPanel_botaoSalvar = new JPanel();
        btn_Salvar = new JButton();
        scrollComanda = new JScrollPane(pBox_Comanda);

        scrollComanda.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        scrollComanda.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
        scrollComanda.setPreferredSize(new Dimension(400, 600));
        scrollComanda.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollComanda.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        pPanel_EspacoDireito.setMinimumSize(new Dimension(336, 800));
        pPanel_DentroEspacoDireito.setLayout(new BoxLayout(pPanel_DentroEspacoDireito, BoxLayout.PAGE_AXIS));
        pPanel_DentroEspacoDireito.setPreferredSize(new Dimension(400, 650));
        pBox_Comanda.setLayout(new BoxLayout(pBox_Comanda, BoxLayout.PAGE_AXIS));
        pBox_Comanda.setBorder(BorderFactory.createRaisedBevelBorder());

        botesConstrutor btnsMesas = new botesConstrutor();

        pPanel_Impressora.setLayout(new BorderLayout());
        btn_Impressora = btnsMesas.impressoraButton;
        btn_Impressora.setHorizontalAlignment(SwingConstants.TRAILING);
        btn_Impressora.setVerticalAlignment(SwingConstants.TOP);
        pPanel_Impressora.add(btn_Impressora, BorderLayout.EAST);
        pBox_Comanda.add(pPanel_Impressora);

        pPainel_nomeMesa.setLayout(new BorderLayout());
        lNomeMesa.setFont(new Font("Tahoma", 1, 24));
        lNomeMesa.setHorizontalAlignment(SwingConstants.CENTER);
        lNomeMesa.setText(!Globals.ehDelivery ? "Mesa " + numeroMesa : "Delivery" );
        lNomeMesa.setPreferredSize(null);
        pPainel_nomeMesa.add(lNomeMesa, BorderLayout.CENTER);
        pBox_Comanda.add(pPainel_nomeMesa);

        lNumeroComanda.setForeground(new Color(0, 102, 255));
        int identificadorComanda = Globals.numeroPedido;
        lNumeroComanda.setText("(Pedido: " + String.format("%08d", Globals.ehDelivery ? Globals.pedidoAtual : identificadorComanda) + ")");
        lNumeroComanda.setPreferredSize(null);
        pPanel_NumeroComanda.add(lNumeroComanda);

        pBox_Comanda.add(pPanel_NumeroComanda);

        pBox_Comanda.add(Box.createRigidArea(new Dimension(0, 50)));

        lTituloComanda.setBackground(new Color(255, 204, 0));
        lTituloComanda.setText("Comanda");
        pPanel_tituloComanda.add(lTituloComanda);
        pBox_Comanda.add(pPanel_tituloComanda);

        painelItensDaComanda.setLayout(new BoxLayout(painelItensDaComanda, BoxLayout.PAGE_AXIS));
        painelItensDaComanda.setMaximumSize(new Dimension(390, painelItensDaComanda.getMinimumSize().height));
        painelItensDaComanda.setBackground(Color.white);

        pBox_Comanda.add(painelItensDaComanda);

        pBox_Comanda.add(Box.createRigidArea(new Dimension(0, 50)));

        lTotalGeral.setFont(new Font("Microsoft Tai Le", 1, 18)); // NOI18N
        lTotalGeral.setHorizontalAlignment(SwingConstants.LEFT);
        lTotalGeral.setText("Total Geral:         R$");
        lTotalGeral.setAlignmentX(-110.0F);
        lTotalGeral.setAlignmentY(0.0F);
        lTotalGeral.setHorizontalTextPosition(SwingConstants.LEADING);
        lTotalGeral.setVerifyInputWhenFocusTarget(false);
        pPanel_TotalGeral.add(lTotalGeral);
        pBox_Comanda.add(pPanel_TotalGeral);

        pBox_Comanda.add(Box.createRigidArea(new Dimension(0, 50)));

        pPanel_botaoSalvar.setMaximumSize(new Dimension(400, 50));
        pPanel_botaoSalvar.setLayout(new BorderLayout());
        btn_Salvar.setText("Salvar");
        pPanel_botaoSalvar.add(btn_Salvar, BorderLayout.CENTER);

        fit_Redimen_Heigth(pPanel_botaoSalvar);
        fit_Redimen_Heigth(pPanel_TotalGeral);
        fit_Redimen_Heigth(painelItensDaComanda);
        fit_Redimen_Heigth(pPanel_tituloComanda);
        fit_Redimen_Heigth(pPanel_NumeroComanda);
        fit_Redimen_Heigth(pPanel_Impressora);
        fit_Redimen_Heigth(pPainel_nomeMesa);
        fit_Redimen_Heigth(pBox_Comanda);
        btn_Impressora.setMaximumSize(new Dimension(Integer.MAX_VALUE, btn_Impressora.getMinimumSize().height));
        btn_Salvar.setMaximumSize(new Dimension(Integer.MAX_VALUE, btn_Salvar.getMinimumSize().height));

        btn_Salvar.addActionListener(this);
        pPanel_DentroEspacoDireito.add(scrollComanda);
        pPanel_DentroEspacoDireito.add(pPanel_botaoSalvar);

        pPanel_EspacoDireito.add(pPanel_DentroEspacoDireito);

        //
    }

    public void fit_Redimen_Heigth(JPanel jpanel) {
        jpanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, jpanel.getMinimumSize().height));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_Salvar) {
            
            try {
                new Botao_SalvarComanda().GravarComanda(list_ItensDoAtendimento, numeroMesaAtual, list_RemoverItensAtendimento);

                if(!Globals.ehAtendimentoAntigo)
                    new Painel_MesaAtendIniciado(Globals.objMesaAtual,false);
                    
            } catch (InterruptedException | ExecutionException | IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }


        }

    }
}
