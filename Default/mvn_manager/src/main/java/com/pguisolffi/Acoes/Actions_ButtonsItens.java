package com.pguisolffi.Acoes;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Objetos.Objeto_Item;
import com.pguisolffi.Utilidades.Globals;
import com.pguisolffi.Utilidades.botesConstrutor;
import com.pguisolffi.Paineis.Painel_Comanda;
import com.pguisolffi.Paineis.Painel_Itens;
import com.pguisolffi.Acoes.Adicionar_ItemAtendimento;

import javax.swing.Box;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class Actions_ButtonsItens implements ActionListener {

    int pedido, numeroMesa, nuSeqItem, cdItem;
    String statusAtendimento, horaInicioAtendimento, horaFimAtendimento, duracaoAtendimento, sTipo, sDescricao;
    Boolean ehDelivery;
    JLabel lDescricao, lValorItem;
    double fValorItem, fValorTotal = 0;
    JButton btn_remover;

    JButton btnRemover;

    List<Objeto_Item> listModel_Item_Adicionais;
    List<Objeto_Item> listModel_Item_Almoco;

    NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());

    public void AdicionarItensAdicionais(List<Objeto_Item> listaRecebida, ActionEvent e, int Indice) {

        listModel_Item_Adicionais = listaRecebida;

        Objeto_Atendimento modelAtendimento = new Objeto_Atendimento(pedido, numeroMesa, nuSeqItem, statusAtendimento,
                horaInicioAtendimento, horaFimAtendimento, duracaoAtendimento, ehDelivery, cdItem, sTipo, sDescricao,
                lDescricao, lValorItem, fValorItem, fValorTotal, btn_remover);

        botesConstrutor btnsMesas = new botesConstrutor();

        modelAtendimento.cdItem = listModel_Item_Adicionais.get(Indice).cdItem;
        modelAtendimento.btn_remover = btnsMesas.removeButton;
        modelAtendimento.ehDelivery = Globals.ehDelivery;
        modelAtendimento.fValorItem = listModel_Item_Adicionais.get(Indice).fValorItem;
        modelAtendimento.horaInicioAtendimento = (new Date()).toString();
        modelAtendimento.sDescricao = listModel_Item_Adicionais.get(Indice).sDescricao;
        modelAtendimento.lDescricao = new JLabel(modelAtendimento.sDescricao, JLabel.RIGHT);
        modelAtendimento.lValorItem = new JLabel(format.format(modelAtendimento.fValorItem), JLabel.CENTER);
        modelAtendimento.numeroMesa = Globals.mesaAtual;
        modelAtendimento.pedido = Globals.numeroPedido;
        modelAtendimento.sTipo = listModel_Item_Adicionais.get(Indice).sTipo;
        modelAtendimento.statusAtendimento = "Em Aberto";

        if (Painel_Itens.listModel_Atendimento.isEmpty()) {
            modelAtendimento.fValorTotal = modelAtendimento.fValorItem;
            modelAtendimento.nuSeqItem = 1;
        } else {
            modelAtendimento.fValorTotal = modelAtendimento.fValorItem
                    + Painel_Itens.listModel_Atendimento.get(Painel_Itens.listModel_Atendimento.size() - 1).fValorTotal;
            modelAtendimento.nuSeqItem = Painel_Itens.listModel_Atendimento.size() + 1;
        }

        Painel_Itens.listModel_Atendimento.add(modelAtendimento);

        for (int z = 0; z < Painel_Itens.listModel_Atendimento.size(); z++) {

            new Adicionar_ItemAtendimento(Painel_Itens.listModel_Atendimento.get(z));

            RedimensionarAltura(Painel_Comanda.pGrid_ItensComanda);

            Painel_Comanda.lTotalGeral
                    .setText("Total Geral:  " + format.format(Painel_Itens.listModel_Atendimento.get(z).fValorTotal));

            btnRemover = new JButton();
            btnRemover = Painel_Itens.listModel_Atendimento.get(z).btn_remover;
            this.btnRemover.addActionListener(this);

            Painel_Comanda.pPanel_EspacoDireito.updateUI();

        }
    }

    public void AdicionarItensAlmoco(List<Objeto_Item> listaRecebida, ActionEvent e, int Indice) {

        listModel_Item_Almoco = listaRecebida;

        Objeto_Atendimento modelAtendimento = new Objeto_Atendimento(pedido, numeroMesa, nuSeqItem, statusAtendimento,
                horaInicioAtendimento, horaFimAtendimento, duracaoAtendimento, ehDelivery, cdItem, sTipo, sDescricao,
                lDescricao, lValorItem, fValorItem, fValorTotal, btn_remover);

        botesConstrutor btnsMesas = new botesConstrutor();

        modelAtendimento.cdItem = listModel_Item_Almoco.get(Indice).cdItem;
        modelAtendimento.btn_remover = btnsMesas.removeButton;
        modelAtendimento.ehDelivery = Globals.ehDelivery;
        modelAtendimento.fValorItem = listModel_Item_Almoco.get(Indice).fValorItem;
        modelAtendimento.horaInicioAtendimento = (new Date()).toString();
        modelAtendimento.sDescricao = listModel_Item_Almoco.get(Indice).sDescricao;
        modelAtendimento.lDescricao = new JLabel(modelAtendimento.sDescricao, JLabel.RIGHT);
        modelAtendimento.lDescricao.setFont(new Font("Courier", Font.BOLD, 30));
        modelAtendimento.lValorItem = new JLabel(format.format(modelAtendimento.fValorItem), JLabel.CENTER);
        modelAtendimento.lDescricao.setFont(new Font("Courier", Font.BOLD, 30));
        modelAtendimento.numeroMesa = Globals.mesaAtual;
        modelAtendimento.pedido = Globals.numeroPedido;
        modelAtendimento.sTipo = listModel_Item_Almoco.get(Indice).sTipo;
        modelAtendimento.statusAtendimento = "Em Aberto";

        if (Painel_Itens.listModel_Atendimento.isEmpty())
            modelAtendimento.fValorTotal = modelAtendimento.fValorItem;
        else {
            modelAtendimento.fValorTotal = modelAtendimento.fValorItem
                    + Painel_Itens.listModel_Atendimento.get(Painel_Itens.listModel_Atendimento.size() - 1).fValorTotal;
        }

        Painel_Itens.listModel_Atendimento.add(modelAtendimento);

        for (int z = 0; z < Painel_Itens.listModel_Atendimento.size(); z++) {

            new Adicionar_ItemAtendimento(Painel_Itens.listModel_Atendimento.get(z));

            RedimensionarAltura(Painel_Comanda.pGrid_ItensComanda);
            Painel_Comanda.lTotalGeral
                    .setText("Total Geral:  " + format.format(Painel_Itens.listModel_Atendimento.get(z).fValorTotal));

            btnRemover = new JButton();
            btnRemover = Painel_Itens.listModel_Atendimento.get(z).btn_remover;
            this.btnRemover.addActionListener(this);

            Painel_Comanda.pPanel_EspacoDireito.updateUI();

        }
    }

    public void RedimensionarAltura(JPanel jpanel) {
        jpanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, jpanel.getMinimumSize().height));
    }

    public void actionPerformed(ActionEvent e) {

        for (int x = 0; x < Painel_Itens.listModel_Atendimento.size(); x++) {

            if (e.getSource() == Painel_Itens.listModel_Atendimento.get(x).btn_remover) {

                new Remover_ItemAtendimento(Painel_Itens.listModel_Atendimento.get(x));

            }
        }
    }
}