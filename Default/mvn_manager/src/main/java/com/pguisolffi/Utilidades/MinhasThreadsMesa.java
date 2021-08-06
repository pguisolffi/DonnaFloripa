package com.pguisolffi.Utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.Date;

import com.pguisolffi.Objetos.Objeto_Mesa;
import com.pguisolffi.Paineis.Painel_Mesa;

import org.threeten.bp.DateTimeUtils;

public class MinhasThreadsMesa extends Thread {

    private String name;
    public String dataInicio;
    private JLabel labelDuracao;
    Boolean isThreadAtivada;
    int indice;
    private int contador = 0;


    public Thread threadDuracao;

    Objeto_Mesa mesaModel = new Objeto_Mesa(0,0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

    public MinhasThreadsMesa(Objeto_Mesa objeto_Mesa) {

        mesaModel = objeto_Mesa;
        dataInicio = objeto_Mesa.entrada;
        this.labelDuracao = new JLabel();
        this.labelDuracao = mesaModel.lduracao;
        this.isThreadAtivada = mesaModel.isThreadActive;
        Thread.currentThread().setName(String.valueOf(objeto_Mesa.numero));
        objeto_Mesa.threadDuracao = Thread.currentThread();
        start();
        String estado = (mesaModel.threadDuracao.getState()).toString();
        String nome = objeto_Mesa.threadDuracao.getName();

    }

    

    public void run() {

        LocalDateTime dtIncio = LocalDateTime.parse(dataInicio);

        while (mesaModel.threadDuracao.getState().toString() == "WAITING"
                || mesaModel.threadDuracao.getState().toString() == "RUNNABLE") {

            String estado = (mesaModel.threadDuracao.getState()).toString();

            LocalDateTime dtFim = LocalDateTime.now();
            Duration duracao = Duration.between(dtIncio, dtFim);    
            String duracaoFormatada = String.format("%02d:%02d:%02d", duracao.toHours() % 24,
            duracao.toMinutes() % 60, duracao.toSeconds() % 60);
      
            // contador++;
            // int seg = contador % 60;
            // int min = contador / 60;
            // int hora = min / 60;
            // min %= 60;

            labelDuracao.setText("Duração: "+ duracaoFormatada);

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