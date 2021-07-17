package com.pguisolffi.Acoes;

import com.pguisolffi.Objetos.Objeto_Atendimento;

import java.awt.Component;
import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JPanel;

import com.pguisolffi.Paineis.Painel_Comanda;
import com.pguisolffi.sgbd.Bd_Delete;

public class Remover_ItemAtendimento {

    String idPrato;
    NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());

    public Remover_ItemAtendimento(Objeto_Atendimento objeto_Atendimento) {

        idPrato = objeto_Atendimento.idPratoCompleto;

        for (int x = 0; x < Adicionar_ItemAtendimento.List_PratosCompletos.get(0).getParent()
                .getComponentCount(); x++) {

            Component[] components = Adicionar_ItemAtendimento.List_PratosCompletos.get(0).getParent().getComponents();
            JPanel panelPratoCompleto = (JPanel) components[x];
            components = panelPratoCompleto.getComponents();
            panelPratoCompleto = (JPanel) components[0];

            if (Arrays.asList(panelPratoCompleto.getComponents()).contains(objeto_Atendimento.btn_remover)) {

                switch (objeto_Atendimento.sTipo) {
                    case "Almoco":
                        panelPratoCompleto.removeAll();
                        break;
                    case "Observacao":
                        panelPratoCompleto.remove(objeto_Atendimento.textObservacao);
                        panelPratoCompleto.remove(objeto_Atendimento.btn_remover);
                        break;
                    default:
                        panelPratoCompleto.remove(objeto_Atendimento.lDescricao);
                        panelPratoCompleto.remove(objeto_Atendimento.lValorItem);
                        panelPratoCompleto.remove(objeto_Atendimento.btn_remover);
                }
                RedimensionarAltura(Painel_Comanda.painelItensDaComanda);
            }
        }

        for (int y = 0; y < Painel_Comanda.listModel_Atendimento.size(); y++) {
            if (objeto_Atendimento.btn_remover.equals(Painel_Comanda.listModel_Atendimento.get(y).btn_remover)) {

                if (Painel_Comanda.listModel_Atendimento.get(y).sTipo.equals("Almoco")) {

                    for (int f = 0; f < Painel_Comanda.listModel_Atendimento.size(); f++) {

                        if (Painel_Comanda.listModel_Atendimento
                                .get(f).idPratoCompleto == objeto_Atendimento.idPratoCompleto) {

                            Painel_Comanda.listModel_Atendimento.remove(Painel_Comanda.listModel_Atendimento.get(f));

                            Bd_Delete bd_delete = new Bd_Delete();
                            bd_delete.delete_AtendimentoItem(
                                    String.valueOf(Painel_Comanda.listModel_Atendimento.get(f).pedido + "Sq"
                                            + Painel_Comanda.listModel_Atendimento.get(f).nuSeqItem));
                        }
                    }
                }

                else {

                    Painel_Comanda.listModel_Atendimento.remove(Painel_Comanda.listModel_Atendimento.get(y));

                    Bd_Delete bd_delete = new Bd_Delete();
                    bd_delete.delete_AtendimentoItem(String.valueOf(Painel_Comanda.listModel_Atendimento.get(y).pedido
                            + "Sq" + Painel_Comanda.listModel_Atendimento.get(y).nuSeqItem));
                }
            }

        }

        // Painel_Comanda.painelItensDaComanda.remove(objeto_Atendimento.lDescricao);
        // Painel_Comanda.painelItensDaComanda.remove(objeto_Atendimento.lValorItem);
        // Painel_Comanda.painelItensDaComanda.remove(objeto_Atendimento.btn_remover);

        Stream<Objeto_Atendimento> filtered = Painel_Comanda.listModel_Atendimento.stream()
                .filter(o -> o.fValorItem > 0);
        double soma = filtered.collect(Collectors.summingDouble(o -> o.fValorItem));

        Painel_Comanda.lTotalGeral.setText("Total Geral:  " + format.format(soma));

        Painel_Comanda.pPanel_EspacoDireito.updateUI();
    }

    public void RedimensionarAltura(JPanel jpanel) {
        jpanel.setMaximumSize(new Dimension(370, jpanel.getMinimumSize().height));
    }
}
