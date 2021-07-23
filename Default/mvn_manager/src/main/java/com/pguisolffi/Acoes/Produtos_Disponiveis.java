package com.pguisolffi.Acoes;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Objetos.Objeto_Item;
import com.pguisolffi.Utilidades.Globals;
import com.pguisolffi.Utilidades.botesConstrutor;
import com.pguisolffi.Paineis.Painel_Comanda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class Produtos_Disponiveis implements ActionListener {

    JButton btnRemover;
    JPanel pItens_comValorEBotoes;

    NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());

    public Objeto_Atendimento Adicionar_Itens(List<Objeto_Item> listaRecebida, ActionEvent e, int Indice,
            String idPrato, String obs, String tipo) {

        Objeto_Atendimento ObjetoAtendimentoPreenchido = Preencher_InformacoesDoObjeto(
                tipo.equals("Observacao") ? null : listaRecebida.get(Indice), idPrato, "", tipo);

        return ObjetoAtendimentoPreenchido;
    }

    public Objeto_Atendimento Preencher_InformacoesDoObjeto(Objeto_Item objeto, String idPrato, String obs,
            String tipo) {

        Objeto_Atendimento modelAtendimento = new Objeto_Atendimento(0, 0, 0, null, null, null, null, null, false, 0,
                null, null, null, null, 0, 0, null, null, null);

        botesConstrutor btnsMesas = new botesConstrutor();
        modelAtendimento.idPratoCompleto = idPrato;
        modelAtendimento.cdItem = tipo.equals("Observacao") ? 999 : objeto.cdItem;
        modelAtendimento.btn_remover = btnsMesas.removeButton;
        modelAtendimento.btn_remover.setHorizontalAlignment(SwingConstants.TRAILING);
        modelAtendimento.btn_remover.setVerticalAlignment(SwingConstants.TOP);
        modelAtendimento.ehDelivery = Globals.ehDelivery;
        modelAtendimento.fValorItem = tipo.equals("Observacao") ? 0.00 : objeto.fValorItem;
        modelAtendimento.horaInicioAtendimento = (new Date()).toString();
        modelAtendimento.sDescricao = tipo.equals("Observacao") ? obs : objeto.sDescricao;
        modelAtendimento.lDescricao = new JLabel(modelAtendimento.sDescricao, JLabel.LEFT);
        modelAtendimento.lDescricao.setFont(new Font("Courier", Font.BOLD, tipo.equals("Almoco") ? 14 : 11));
        modelAtendimento.lValorItem = new JLabel(format.format(modelAtendimento.fValorItem), JLabel.RIGHT);
        modelAtendimento.lValorItem.setFont(new Font("Courier", Font.BOLD, tipo.equals("Almoco") ? 14 : 11));
        modelAtendimento.numeroMesa = Globals.mesaAtual;
        modelAtendimento.pedido = Globals.numeroPedido;
        modelAtendimento.sTipo = tipo;
        modelAtendimento.statusAtendimento = "Em Aberto";

        if (Painel_Comanda.list_ItensDoAtendimento.isEmpty()) {
            modelAtendimento.nuSeqItem = 1;
        }

        else {
            modelAtendimento.nuSeqItem = Painel_Comanda.list_ItensDoAtendimento.size() + 1;
        }

        if (tipo.equals("Observacao")) {

            modelAtendimento.textObservacao = new JTextArea(modelAtendimento.sDescricao, 25, 25);
            modelAtendimento.textObservacao.setLineWrap(true);
            modelAtendimento.textObservacao.setForeground(Color.BLUE);

            new Atualizar_Valor_Comanda();
        }

        Painel_Comanda.list_ItensDoAtendimento.add(modelAtendimento);

        btnRemover = new JButton();
        btnRemover = modelAtendimento.btn_remover;
        this.btnRemover.addActionListener(this);

        return modelAtendimento;
    }

    // AÇÃO DO BOTÃO REMOVER
    public void actionPerformed(ActionEvent e) {

        for (int x = 0; x < Painel_Comanda.list_ItensDoAtendimento.size(); x++) {

            if (e.getSource() == Painel_Comanda.list_ItensDoAtendimento.get(x).btn_remover) {

                Painel_Comanda.list_RemoverItensAtendimento.add(Painel_Comanda.list_ItensDoAtendimento.get(x));

                new Remover_ItemAtendimento(Painel_Comanda.list_ItensDoAtendimento.get(x));

            }
        }
    }

}