package com.pguisolffi.Paineis;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.time.LocalDateTime;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.pguisolffi.Acoes.Botoes_Delivery;
import com.pguisolffi.Objetos.Objeto_Delivery;
import com.pguisolffi.Utilidades.Globals;
import com.pguisolffi.Utilidades.ThreadDelivery;
import com.pguisolffi.Utilidades.botesConstrutor;
import com.pguisolffi.sgbd.Bd_get;
import com.pguisolffi.sgbd.Bd_update;

public class Painel_DeliveryAtendimentoIniciado implements ActionListener{

    public Painel_DeliveryAtendimentoIniciado(Objeto_Delivery Objeto_Delivery,boolean jaExistiaAtendimento) throws InterruptedException, ExecutionException, IOException{

        botesConstrutor btnsMesas = new botesConstrutor();
        Objeto_Delivery deliveryModel = Objeto_Delivery;

        if (jaExistiaAtendimento)
            deliveryModel.horaEntrada = new Bd_get().get_DataInicioAtendimentoDelivery(deliveryModel.numeroPedido);
        else
            deliveryModel.horaEntrada = LocalDateTime.now().toString();  

        Globals.ehDelivery = true;    

        int linhas = Painel_Delivery.painelPreparando_Grid.getComponentCount()/4;
        Painel_Delivery.painelPreparando_Grid.setLayout(new GridLayout(linhas+1, 4));
        fit_Redimen_Heigth(Painel_Delivery.painelPreparando_Grid);
        
        deliveryModel.numeroPedido = Objeto_Delivery.numeroPedido;
        deliveryModel.btnPlay = btnsMesas.ConfirmButtonDelivery;
        deliveryModel.btnPlay.setAlignmentX(JButton.CENTER_ALIGNMENT);
        deliveryModel.btnEye = btnsMesas.EyeButtonDelivery;
        deliveryModel.btnEye.setAlignmentX(JButton.CENTER_ALIGNMENT);
        deliveryModel.lduracao = new JLabel();
        deliveryModel.lduracao.setHorizontalAlignment(JLabel.CENTER);
        deliveryModel.nPedido = new JLabel(String.valueOf(deliveryModel.numeroPedido));
        deliveryModel.nPedido.setHorizontalAlignment(JLabel.CENTER);

        Painel_Delivery.painelPreparando_Grid.add(deliveryModel.nPedido);
        Painel_Delivery.painelPreparando_Grid.add(deliveryModel.btnPlay);
        Painel_Delivery.painelPreparando_Grid.add(deliveryModel.btnEye);
        Painel_Delivery.painelPreparando_Grid.add(deliveryModel.lduracao);
        Painel_Delivery.listPreparando.add(deliveryModel);
 
        new ThreadDelivery(deliveryModel);

        Painel_Delivery.listPreparando.get(Painel_Delivery.listPreparando.size()-1).btnPlay.addActionListener(this);
        Painel_Delivery.listPreparando.get(Painel_Delivery.listPreparando.size()-1).btnEye.addActionListener(this);
    }

    public void fit_Redimen_Heigth(JPanel jpanel) {
        jpanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, jpanel.getMinimumSize().height));
    }

    @Override
    public void actionPerformed(ActionEvent e) {    
     
        for (int x = 0; x < Painel_Delivery.listPreparando.size(); x++) {
            if (e.getSource() == Painel_Delivery.listPreparando.get(x).btnPlay) {    
                try {
                    Globals.ehAtendimentoAntigo = false;
                    new Bd_update().BD_Update_Status_Atend_Delivery(Painel_Delivery.listPreparando.get(x).numeroPedido, "Em Transito");
                    new Botoes_Delivery().EmTransito(x);
                } catch (InterruptedException | ExecutionException | IOException e1) {
                    e1.printStackTrace();
                }   
            }

            if (e.getSource() == Painel_Delivery.listPreparando.get(x).btnEye) {
                    Globals.pedidoAtual = Painel_Delivery.listPreparando.get(x).numeroPedido;
                    try {
                        Globals.nuseqItemAtual = new Bd_get().get_MaxNuSeq(Painel_Delivery.listPreparando.get(x).numeroPedido) + 1;
                    } catch (InterruptedException | ExecutionException | IOException e1) {
                        e1.printStackTrace();
                    }
                    
                    new Botoes_Delivery().Botao_Olhar_Delivery(Painel_Delivery.listPreparando.get(x).numeroPedido);
            }
            
        }
    }   
}
