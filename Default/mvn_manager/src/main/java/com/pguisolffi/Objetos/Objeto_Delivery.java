package com.pguisolffi.Objetos;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Objeto_Delivery {

    public int numeroPedido;
    public String duracao, horaEntrada;
    public JLabel lduracao, nPedido, horaEntrega;
    public JButton btnPlay, btnEye, btnAdd;

    public Objeto_Delivery(int _numeroPedido, String _duracao, String _horaEntrada, JLabel _lduracao, JLabel _nPedido,
            JLabel _horaEntrega, JButton _btnPlay, JButton _btnEye, JButton _btnAdd) {
        this.numeroPedido = _numeroPedido;
        this.duracao = _duracao;
        this.horaEntrada = _horaEntrada;
        this.lduracao = _lduracao;
        this.nPedido = _nPedido;
        this.horaEntrega = _horaEntrega;
        this.btnPlay = _btnPlay;
        this.btnEye = _btnEye;
        this.btnAdd = _btnAdd;

    }

}
