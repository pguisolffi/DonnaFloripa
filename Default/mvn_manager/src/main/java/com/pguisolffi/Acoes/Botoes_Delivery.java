package com.pguisolffi.Acoes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Objetos.Objeto_Delivery;
import com.pguisolffi.Paineis.Painel_Delivery;
import com.pguisolffi.Paineis.Painel_DeliveryAtendimentoIniciado;
import com.pguisolffi.Telas.Tela_AddItens;
import com.pguisolffi.Utilidades.Globals;
import com.pguisolffi.Utilidades.ThreadDelivery;
import com.pguisolffi.Utilidades.botesConstrutor;
import com.pguisolffi.sgbd.Bd_get;
import com.pguisolffi.sgbd.Bd_update;

public class Botoes_Delivery implements ActionListener{


    List<Objeto_Atendimento> list_ObjetosAtendimentos;
    
    public void Botao_Olhar_Delivery(int numeroPedido){
        
        Globals.ehDelivery = true;

        try {
            list_ObjetosAtendimentos = new Bd_get().Get_ItensAtendimentoDelivery(numeroPedido);
        } catch (InterruptedException | ExecutionException | IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        try {
            new Tela_AddItens(0);
        } catch (InterruptedException | ExecutionException | IOException e1) {
            e1.printStackTrace();
        }
        new Carregar_ItensAtendimento(list_ObjetosAtendimentos);

    }
   
    public void Preparando(int numeroPedido) throws InterruptedException, ExecutionException, IOException{

        Objeto_Delivery objeto_Delivery = new Objeto_Delivery(0, null, null, null, null, null, null, null, null, false, null);
        objeto_Delivery.numeroPedido = numeroPedido;
        Globals.objDeliveryAtual = objeto_Delivery;


        if (Globals.ehAtendimentoAntigo)
            new Painel_DeliveryAtendimentoIniciado(objeto_Delivery, true);

        if (!Globals.ehAtendimentoAntigo)
            new Painel_DeliveryAtendimentoIniciado(objeto_Delivery, false);    

        Painel_Delivery.painelPrincipal_Delivery.updateUI();

    }

    public void EmTransito(int index) throws InterruptedException, ExecutionException, IOException{

        botesConstrutor btnsMesas = new botesConstrutor();
        int linhas = Painel_Delivery.painelTransito_Grid.getComponentCount()/4;
        Painel_Delivery.painelTransito_Grid.setLayout(new GridLayout(linhas+1, 4));

        Objeto_Delivery deliveryModel = new Objeto_Delivery(0, null, null, null,
        null, null, null, null, null, false,null);    
        
        deliveryModel.btnPlay = btnsMesas.ConfirmButtonDelivery;
        deliveryModel.horaEntrada = !Globals.ehAtendimentoAntigo ? Painel_Delivery.listPreparando.get(index).horaEntrada : new Bd_get().Get_dataInicioAtendimento(index);
        deliveryModel.numeroPedido = !Globals.ehAtendimentoAntigo ? Painel_Delivery.listPreparando.get(index).numeroPedido : index;
        deliveryModel.btnPlay.setAlignmentX(JButton.CENTER_ALIGNMENT);
        deliveryModel.btnPlay.setIcon(btnsMesas.finishIconDelivery);
        deliveryModel.btnEye = btnsMesas.EyeButtonDelivery;
        deliveryModel.btnEye.setAlignmentX(JButton.CENTER_ALIGNMENT);
        deliveryModel.lduracao = !Globals.ehAtendimentoAntigo ? Painel_Delivery.listPreparando.get(index).lduracao : new JLabel();
        deliveryModel.nPedido = !Globals.ehAtendimentoAntigo ? Painel_Delivery.listPreparando.get(index).nPedido : new JLabel(String.valueOf(index),JLabel.CENTER) ;
        deliveryModel.threadDuracao = !Globals.ehAtendimentoAntigo ? Painel_Delivery.listPreparando.get(index).threadDuracao :  new ThreadDelivery(deliveryModel);
        deliveryModel.nPedido.setHorizontalAlignment(JLabel.CENTER);

        Painel_Delivery.painelTransito_Grid.add(deliveryModel.nPedido);
        Painel_Delivery.painelTransito_Grid.add(deliveryModel.btnPlay);
        Painel_Delivery.painelTransito_Grid.add(deliveryModel.btnEye);
        Painel_Delivery.painelTransito_Grid.add(deliveryModel.lduracao);

        Painel_Delivery.listEmTransito.add(deliveryModel);

        fit_Redimen_Heigth(Painel_Delivery.painelTransito_Grid);




        if (!Globals.ehAtendimentoAntigo){
            Painel_Delivery.painelPreparando_Grid.remove(Painel_Delivery.listPreparando.get(index).nPedido);
            Painel_Delivery.painelPreparando_Grid.remove(Painel_Delivery.listPreparando.get(index).btnPlay);
            Painel_Delivery.painelPreparando_Grid.remove(Painel_Delivery.listPreparando.get(index).btnEye);
            Painel_Delivery.painelPreparando_Grid.remove(Painel_Delivery.listPreparando.get(index).lduracao);
            linhas = Painel_Delivery.painelPreparando_Grid.getComponentCount()/4;
            Painel_Delivery.painelPreparando_Grid.setLayout(new GridLayout(linhas, 4));
            fit_Redimen_Heigth(Painel_Delivery.painelPreparando_Grid);
        }



        deliveryModel.btnPlay.addActionListener(this);
        deliveryModel.btnEye.addActionListener(this);

        Painel_Delivery.painelPrincipal_Delivery.updateUI();

    }

    public void Entregue(int index) throws InterruptedException, ExecutionException, IOException{

        botesConstrutor btnsMesas = new botesConstrutor();
        int linhas = Painel_Delivery.painelEntregas_Grid.getComponentCount()/4;
        Painel_Delivery.painelEntregas_Grid.setLayout(new GridLayout(linhas+1, 4));

        Objeto_Delivery deliveryModel = new Objeto_Delivery(0, null, null, null,
        null, null, null, null, null,false,null);

        Date date = new Date();
        SimpleDateFormat formatoHoraMinuto = new SimpleDateFormat("HH:mm");

        Duration duracao;
        LocalDateTime SegundaData = null;
        if (!Globals.ehAtendimentoAntigo){
            duracao = Duration.between(LocalDateTime.parse(Painel_Delivery.listEmTransito.get(index).horaEntrada), LocalDateTime.now()); 
        }
        else {
            LocalDateTime primeiraData = LocalDateTime.parse(new Bd_get().Get_dataInicioAtendimento(index));
            SegundaData = LocalDateTime.parse(new Bd_get().Get_dataFimAtendimento(index));
            duracao = Duration.between(primeiraData, SegundaData);  
        }
        
        String duracaoFormatada = String.format("%02d:%02d:%02d", duracao.toHours() % 24,duracao.toMinutes() % 60, duracao.toSeconds() % 60);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        deliveryModel.numeroPedido = !Globals.ehAtendimentoAntigo ? Painel_Delivery.listEmTransito.get(index).numeroPedido : index;
        //deliveryModel.threadDuracao = Painel_Delivery.listEmTransito.get(index).threadDuracao;
        deliveryModel.btnEye = btnsMesas.EyeButtonDelivery;
        deliveryModel.btnEye.setAlignmentX(JButton.CENTER_ALIGNMENT);
        deliveryModel.horaEntrega = new JLabel(!Globals.ehAtendimentoAntigo ? formatoHoraMinuto.format(date): SegundaData.format(formatter),JLabel.CENTER) ;
        deliveryModel.lduracao = new JLabel(duracaoFormatada, JLabel.CENTER);
        deliveryModel.nPedido =  !Globals.ehAtendimentoAntigo ? Painel_Delivery.listEmTransito.get(index).nPedido : new JLabel(String.valueOf(index));
        deliveryModel.nPedido.setHorizontalAlignment(JLabel.CENTER);

        Painel_Delivery.painelEntregas_Grid.add(deliveryModel.nPedido);
        Painel_Delivery.painelEntregas_Grid.add(deliveryModel.btnEye);
        Painel_Delivery.painelEntregas_Grid.add(deliveryModel.horaEntrega);
        Painel_Delivery.painelEntregas_Grid.add(deliveryModel.lduracao);

        Painel_Delivery.listUltimasEntregas.add(deliveryModel);

        fit_Redimen_Heigth(Painel_Delivery.painelEntregas_Grid);


        if (!Globals.ehAtendimentoAntigo){
        Painel_Delivery.painelTransito_Grid.remove(Painel_Delivery.listEmTransito.get(index).nPedido);
        Painel_Delivery.painelTransito_Grid.remove(Painel_Delivery.listEmTransito.get(index).btnPlay);
        Painel_Delivery.painelTransito_Grid.remove(Painel_Delivery.listEmTransito.get(index).btnEye);
        Painel_Delivery.painelTransito_Grid.remove(Painel_Delivery.listEmTransito.get(index).lduracao);
        linhas = Painel_Delivery.painelTransito_Grid.getComponentCount()/4;
        Painel_Delivery.painelTransito_Grid.setLayout(new GridLayout(linhas, 4));
        Painel_Delivery.listEmTransito.get(index).threadDuracao.interrupt();
        fit_Redimen_Heigth(Painel_Delivery.painelTransito_Grid);
        }

        deliveryModel.btnEye.addActionListener(this);
        
        Painel_Delivery.painelPrincipal_Delivery.updateUI();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //ENVIA O OBJETO DE "PREPARANDO" PARA "EM TRANSITO"
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
        }

        //ENVIA O OBJETO DE "EM TRANSITO" PARA "ULTIMAS ENTREGAS"
        for (int x = 0; x < Painel_Delivery.listEmTransito.size(); x++) {
            if (e.getSource() == Painel_Delivery.listEmTransito.get(x).btnPlay) {
                try {
                    Globals.ehAtendimentoAntigo = false;
                    new Bd_update().BD_Update_Status_Atend_Delivery(Painel_Delivery.listEmTransito.get(x).numeroPedido, "Entregue");
                    new Bd_update().BD_Update_dtFim_Atendimento(Painel_Delivery.listEmTransito.get(x).numeroPedido, LocalDateTime.now().toString());
                    new Botoes_Delivery().Entregue(x);
                } catch (InterruptedException | ExecutionException | IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } 
            }
        }

        //BOTÃO OLHO - LISTA DOS **PREPARANDO**
        for (int x = 0; x < Painel_Delivery.listPreparando.size(); x++) {
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

        //BOTÃO OLHO - LISTA DOS **EM TRANSITO**
        for (int x = 0; x < Painel_Delivery.listEmTransito.size(); x++) {           
            if (e.getSource() == Painel_Delivery.listEmTransito.get(x).btnEye) {
                    Globals.pedidoAtual = Painel_Delivery.listEmTransito.get(x).numeroPedido;

                    try {
                        Globals.nuseqItemAtual = new Bd_get().get_MaxNuSeq(Painel_Delivery.listEmTransito.get(x).numeroPedido) + 1;
                    } catch (InterruptedException | ExecutionException | IOException e1) {
                        e1.printStackTrace();
                    }
                   

                    new Botoes_Delivery().Botao_Olhar_Delivery(Painel_Delivery.listEmTransito.get(x).numeroPedido);
            }
        }

        //BOTÃO OLHO - LISTA DOS **ÚLTIMAS ENTREGAS**
        for (int x = 0; x < Painel_Delivery.listUltimasEntregas.size(); x++) {    
            if (e.getSource() == Painel_Delivery.listUltimasEntregas.get(x).btnEye) {
                    Globals.pedidoAtual = Painel_Delivery.listUltimasEntregas.get(x).numeroPedido;

                    try {
                        Globals.nuseqItemAtual = new Bd_get().get_MaxNuSeq(Painel_Delivery.listUltimasEntregas.get(x).numeroPedido) + 1;
                    } catch (InterruptedException | ExecutionException | IOException e1) {
                        e1.printStackTrace();
                    }
                   

                    new Botoes_Delivery().Botao_Olhar_Delivery(Painel_Delivery.listUltimasEntregas.get(x).numeroPedido);
            }
        }

    }
    //Resize
    public void fit_Redimen_Heigth(JPanel jpanel) {
        jpanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, jpanel.getMinimumSize().height));
    }
}
