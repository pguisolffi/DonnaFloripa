package com.pguisolffi.Utilidades;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.pguisolffi.Objetos.Objeto_Delivery;
import com.pguisolffi.Paineis.Painel_Delivery;
import com.pguisolffi.Paineis.Painel_Mesa;

public class ThreadDelivery extends Thread {

    private String name;
    public String dataInicio;
    private JLabel labelDuracao;
    Boolean isThreadAtivada;
    private int contador = 0;


    public Thread threadDuracao;

    Objeto_Delivery deliverymodel = new Objeto_Delivery(0, null, null, null, null, null, null, null, null, false, null);

    public ThreadDelivery(Objeto_Delivery objeto_Delivey) {

        deliverymodel = objeto_Delivey;
        dataInicio = deliverymodel.horaEntrada;
        this.labelDuracao = new JLabel("", JLabel.CENTER);
        this.labelDuracao = deliverymodel.lduracao;
        this.labelDuracao.setHorizontalAlignment(JLabel.CENTER);
        this.isThreadAtivada = deliverymodel.isThreadActive;
        Thread.currentThread().setName(String.valueOf(objeto_Delivey.numeroPedido));
        deliverymodel.threadDuracao = Thread.currentThread();
        start();
        String estado = (deliverymodel.threadDuracao.getState()).toString();
        String nome = deliverymodel.threadDuracao.getName();

    }

    

    public void run() {

        LocalDateTime dtIncio = LocalDateTime.parse(dataInicio);

        while (deliverymodel.threadDuracao.getState().toString() == "WAITING"
                || deliverymodel.threadDuracao.getState().toString() == "RUNNABLE") {

            String estado = (deliverymodel.threadDuracao.getState()).toString();

            LocalDateTime dtFim = LocalDateTime.now();
            Duration duracao = Duration.between(dtIncio, dtFim);    
            String duracaoFormatada = String.format("%02d:%02d:%02d", duracao.toHours() % 24,
            duracao.toMinutes() % 60, duracao.toSeconds() % 60);

            labelDuracao.setText(duracaoFormatada);

            Painel_Mesa.painel_mesas.updateUI();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}