package com.pguisolffi.Acoes;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.pguisolffi.Utilidades.Globals;
import com.pguisolffi.Utilidades.botesConstrutor;
import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Paineis.Painel_Comanda;

public class Inserir_Observacao {

    int pedido, numeroMesa, nuSeqItem, cdItem;
    String statusAtendimento, horaInicioAtendimento, horaFimAtendimento, duracaoAtendimento, sTipo, sDescricao;
    Boolean ehDelivery;
    JLabel lDescricao, lValorItem;
    double fValorItem, fValorTotal = 0;
    JButton btn_remover;

    NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());

    public Inserir_Observacao(String obs) {

        Objeto_Atendimento modelAtendimento = new Objeto_Atendimento(pedido, numeroMesa, nuSeqItem, statusAtendimento,
                horaInicioAtendimento, horaFimAtendimento, duracaoAtendimento, ehDelivery, cdItem, sTipo, sDescricao,
                lDescricao, lValorItem, fValorItem, fValorTotal, btn_remover);

        botesConstrutor btnsMesas = new botesConstrutor();

        modelAtendimento.cdItem = 999;
        modelAtendimento.btn_remover = btnsMesas.removeButton;
        modelAtendimento.ehDelivery = Globals.ehDelivery;
        modelAtendimento.fValorItem = 0.00;
        modelAtendimento.horaInicioAtendimento = (new Date()).toString();
        modelAtendimento.sDescricao = obs;
        modelAtendimento.lDescricao = new JLabel(modelAtendimento.sDescricao, JLabel.RIGHT);
        modelAtendimento.lValorItem = new JLabel(format.format(modelAtendimento.fValorItem), JLabel.CENTER);
        modelAtendimento.numeroMesa = Globals.mesaAtual;
        modelAtendimento.pedido = Globals.numeroPedido;
        modelAtendimento.sTipo = "Observacao";
        modelAtendimento.statusAtendimento = "Em Aberto";

        new Adicionar_ItemAtendimento(modelAtendimento);

    }
}
