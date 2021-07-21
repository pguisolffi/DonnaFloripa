package com.pguisolffi.Utilidades;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.pguisolffi.Objetos.Objeto_Mesa;
import com.pguisolffi.Paineis.Painel_Mesa;

public class MinhasThreads extends Thread {

    private String name;
    private JLabel labelDuracao;
    Boolean isThreadAtivada;
    int indice;
    private int contador = 0;

    public int numero;
    public String status, observacao, duracao, entrada;
    public JLabel lduracao, lnomeMesa, lentrada;
    public JPanel mesa, corStatus, interiorMesa;
    public Boolean isThreadActive;
    public JButton btnPlay, btnEye, btnAdd;
    public Thread threadDuracao;

    Objeto_Mesa mesaModel = new Objeto_Mesa(numero, status, observacao, lduracao, mesa, corStatus, interiorMesa,
            btnPlay, btnEye, btnAdd, lnomeMesa, lentrada, duracao, entrada, isThreadActive, threadDuracao);

    public MinhasThreads(Objeto_Mesa objeto_Mesa, int indice) {

        mesaModel = objeto_Mesa;
        this.labelDuracao = new JLabel();
        this.labelDuracao = mesaModel.lduracao;
        this.isThreadAtivada = mesaModel.isThreadActive;
        this.indice = indice;
        Thread.currentThread().setName(String.valueOf(indice));
        Painel_Mesa.list_ObjetoMesa.get(indice).threadDuracao = Thread.currentThread();
        start();
        String estado = (mesaModel.threadDuracao.getState()).toString();
        String nome = Painel_Mesa.list_ObjetoMesa.get(indice).threadDuracao.getName();

    }

    public void run() {

        while (mesaModel.threadDuracao.getState().toString() == "WAITING"
                || mesaModel.threadDuracao.getState().toString() == "RUNNABLE") {

            String estado = (mesaModel.threadDuracao.getState()).toString();

            contador++;
            int seg = contador % 60;
            int min = contador / 60;
            int hora = min / 60;
            min %= 60;

            labelDuracao.setText("Duração: " + String.format("%02d:%02d:%02d", hora, min, seg));
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