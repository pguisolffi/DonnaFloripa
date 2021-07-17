package com.pguisolffi.Acoes;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

public class Botoes_Produtos implements ActionListener {

    JButton btnRemover;
    JPanel pItens_comValorEBotoes;

    List<Objeto_Item> listModel_Item_Adicionais;
    List<Objeto_Item> listModel_Item_Almoco;

    NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());

    public Objeto_Atendimento AdicionarItensAdicionais(List<Objeto_Item> listaRecebida, ActionEvent e, int Indice,
            String idPrato) {

        listModel_Item_Adicionais = listaRecebida;

        Objeto_Atendimento modelAtendimento = new Objeto_Atendimento(0, 0, 0, null, null, null, null, null, false, 0,
                null, null, null, null, 0, 0, null, null, null);

        botesConstrutor btnsMesas = new botesConstrutor();
        modelAtendimento.idPratoCompleto = idPrato;
        modelAtendimento.cdItem = listModel_Item_Adicionais.get(Indice).cdItem;
        modelAtendimento.btn_remover = btnsMesas.removeButton;
        modelAtendimento.btn_remover.setHorizontalAlignment(SwingConstants.TRAILING);
        modelAtendimento.btn_remover.setVerticalAlignment(SwingConstants.TOP);
        modelAtendimento.ehDelivery = Globals.ehDelivery;
        modelAtendimento.fValorItem = listModel_Item_Adicionais.get(Indice).fValorItem;
        modelAtendimento.horaInicioAtendimento = (new Date()).toString();
        modelAtendimento.sDescricao = listModel_Item_Adicionais.get(Indice).sDescricao;
        modelAtendimento.lDescricao = new JLabel(modelAtendimento.sDescricao, JLabel.LEFT);
        modelAtendimento.lDescricao.setFont(new Font("Courier", Font.BOLD, 11));
        modelAtendimento.lValorItem = new JLabel(format.format(modelAtendimento.fValorItem), JLabel.CENTER);
        modelAtendimento.lValorItem.setFont(new Font("Courier", Font.BOLD, 11));
        modelAtendimento.numeroMesa = Globals.mesaAtual;
        modelAtendimento.pedido = Globals.numeroPedido;
        modelAtendimento.sTipo = listModel_Item_Adicionais.get(Indice).sTipo;
        modelAtendimento.statusAtendimento = "Em Aberto";

        if (Painel_Comanda.listModel_Atendimento.isEmpty()) {
            modelAtendimento.fValorTotal = modelAtendimento.fValorItem;
            modelAtendimento.nuSeqItem = 1;
        } else {
            modelAtendimento.fValorTotal = modelAtendimento.fValorItem + Painel_Comanda.listModel_Atendimento
                    .get(Painel_Comanda.listModel_Atendimento.size() - 1).fValorTotal;
            modelAtendimento.nuSeqItem = Painel_Comanda.listModel_Atendimento.size() + 1;
        }

        Painel_Comanda.listModel_Atendimento.add(modelAtendimento);

        for (int z = 0; z < Painel_Comanda.listModel_Atendimento.size(); z++) {

            // Painel_Comanda.lTotalGeral
            // .setText("Total Geral: " +
            // format.format(Painel_Comanda.listModel_Atendimento.get(z).fValorTotal));

            btnRemover = new JButton();
            btnRemover = Painel_Comanda.listModel_Atendimento.get(z).btn_remover;
            this.btnRemover.addActionListener(this);

            Painel_Comanda.pPanel_EspacoDireito.updateUI();

        }
        return modelAtendimento;
    }

    public Objeto_Atendimento AdicionarItensAlmoco(List<Objeto_Item> listaRecebida, ActionEvent e, int Indice,
            String idPrato) {

        listModel_Item_Almoco = listaRecebida;

        Objeto_Atendimento modelAtendimento = new Objeto_Atendimento(0, 0, 0, null, null, null, null, null, false, 0,
                null, null, null, null, 0, 0, null, null, null);

        botesConstrutor btnsMesas = new botesConstrutor();

        modelAtendimento.idPratoCompleto = idPrato;
        modelAtendimento.cdItem = listModel_Item_Almoco.get(Indice).cdItem;
        modelAtendimento.btn_remover = btnsMesas.removeButton;
        modelAtendimento.ehDelivery = Globals.ehDelivery;
        modelAtendimento.fValorItem = listModel_Item_Almoco.get(Indice).fValorItem;
        modelAtendimento.horaInicioAtendimento = (new Date()).toString();
        modelAtendimento.sDescricao = listModel_Item_Almoco.get(Indice).sDescricao;
        modelAtendimento.lDescricao = new JLabel(modelAtendimento.sDescricao, JLabel.LEFT);
        modelAtendimento.lDescricao.setFont(new Font("Courier", Font.BOLD, 14));
        modelAtendimento.lValorItem = new JLabel(format.format(modelAtendimento.fValorItem), JLabel.CENTER);
        modelAtendimento.lValorItem.setFont(new Font("Courier", Font.BOLD, 14));
        modelAtendimento.numeroMesa = Globals.mesaAtual;
        modelAtendimento.pedido = Globals.numeroPedido;
        modelAtendimento.sTipo = listModel_Item_Almoco.get(Indice).sTipo;
        modelAtendimento.statusAtendimento = "Em Aberto";

        if (Painel_Comanda.listModel_Atendimento.isEmpty()) {
            modelAtendimento.fValorTotal = modelAtendimento.fValorItem;
            modelAtendimento.nuSeqItem = 1;
        }

        else {
            modelAtendimento.fValorTotal = modelAtendimento.fValorItem + Painel_Comanda.listModel_Atendimento
                    .get(Painel_Comanda.listModel_Atendimento.size() - 1).fValorTotal;
            modelAtendimento.nuSeqItem = Painel_Comanda.listModel_Atendimento.size() + 1;
        }

        Painel_Comanda.listModel_Atendimento.add(modelAtendimento);

        for (int z = 0; z < Painel_Comanda.listModel_Atendimento.size(); z++) {

            // Painel_Comanda.lTotalGeral
            // .setText("Total Geral: " +
            // format.format(Painel_Comanda.listModel_Atendimento.get(z).fValorTotal));

            btnRemover = new JButton();
            btnRemover = Painel_Comanda.listModel_Atendimento.get(z).btn_remover;
            this.btnRemover.addActionListener(this);

            Painel_Comanda.pPanel_EspacoDireito.updateUI();

        }
        return modelAtendimento;
    }

    public Objeto_Atendimento Inserir_Observacao(String obs, String idPrato) {

        Objeto_Atendimento modelAtendimento = new Objeto_Atendimento(0, 0, 0, null, null, null, null, null, false, 0,
                null, null, null, null, 0, 0, null, null, null);

        botesConstrutor btnsMesas = new botesConstrutor();

        modelAtendimento.idPratoCompleto = idPrato;
        modelAtendimento.cdItem = 999;
        modelAtendimento.btn_remover = btnsMesas.removeButton;
        modelAtendimento.ehDelivery = Globals.ehDelivery;
        modelAtendimento.fValorItem = 0.00;
        modelAtendimento.horaInicioAtendimento = (new Date()).toString();
        modelAtendimento.sDescricao = obs;
        modelAtendimento.textObservacao = new JTextArea(modelAtendimento.sDescricao, 25, 25);
        modelAtendimento.textObservacao.setLineWrap(true);
        modelAtendimento.textObservacao.setForeground(Color.BLUE);
        modelAtendimento.lDescricao = new JLabel(modelAtendimento.sDescricao, JLabel.RIGHT);
        modelAtendimento.lValorItem = new JLabel(format.format(modelAtendimento.fValorItem), JLabel.CENTER);
        modelAtendimento.numeroMesa = Globals.mesaAtual;
        modelAtendimento.pedido = Globals.numeroPedido;
        modelAtendimento.sTipo = "Observacao";
        modelAtendimento.statusAtendimento = "Em Aberto";

        if (Painel_Comanda.listModel_Atendimento.isEmpty()) {
            modelAtendimento.nuSeqItem = 1;
        } else {
            modelAtendimento.nuSeqItem = Painel_Comanda.listModel_Atendimento.size() + 1;
        }

        Painel_Comanda.listModel_Atendimento.add(modelAtendimento);

        for (int z = 0; z < Painel_Comanda.listModel_Atendimento.size(); z++) {

            // Painel_Comanda.lTotalGeral
            // .setText("Total Geral: " +
            // format.format(Painel_Comanda.listModel_Atendimento.get(z).fValorTotal));

            btnRemover = new JButton();
            btnRemover = Painel_Comanda.listModel_Atendimento.get(z).btn_remover;
            this.btnRemover.addActionListener(this);

        }

        Stream<Objeto_Atendimento> filtered = Painel_Comanda.listModel_Atendimento.stream()
                .filter(o -> o.fValorItem > 0);
        double soma = filtered.collect(Collectors.summingDouble(o -> o.fValorItem));

        Painel_Comanda.lTotalGeral.setText("Total Geral:  " + format.format(soma));

        Painel_Comanda.pPanel_EspacoDireito.updateUI();

        return modelAtendimento;
    }

    public void actionPerformed(ActionEvent e) {

        for (int x = 0; x < Painel_Comanda.listModel_Atendimento.size(); x++) {

            if (e.getSource() == Painel_Comanda.listModel_Atendimento.get(x).btn_remover) {

                new Remover_ItemAtendimento(Painel_Comanda.listModel_Atendimento.get(x));

            }
        }
    }

}