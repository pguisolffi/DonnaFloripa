package com.pguisolffi.Acoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.text.NumberFormat;
import java.awt.*;

import com.pguisolffi.Utilidades.botesConstrutor;
import com.pguisolffi.Objetos.Objeto_Atendimento;

public class Carregar_ItensAtendimento implements ActionListener {

    NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
    JButton btnRemoverItem;
    List<Objeto_Atendimento> list_Models_Atendimentos = new ArrayList<Objeto_Atendimento>();

    public Carregar_ItensAtendimento(List<Objeto_Atendimento> list_AtendimentosModels) {

        // PEGAR A QUANTIDADE DE PRATOS COMPLETOS
        List<String> QtdePratosNoAtendimento = new ArrayList<String>();
        for (int x = 0; x < list_AtendimentosModels.size(); x++) {
            if (x == 0) {
                QtdePratosNoAtendimento.add(list_AtendimentosModels.get(x).idPratoCompleto);
            } else {
                if (!QtdePratosNoAtendimento.contains(list_AtendimentosModels.get(x).idPratoCompleto)) {
                    QtdePratosNoAtendimento.add(list_AtendimentosModels.get(x).idPratoCompleto);
                }
            }
        }

        for (int Y = 0; Y < QtdePratosNoAtendimento.size(); Y++) {
            List<Objeto_Atendimento> pratoCompleto = new ArrayList<Objeto_Atendimento>();
            for (int d = 0; d < list_AtendimentosModels.size(); d++) {
                if (list_AtendimentosModels.get(d).idPratoCompleto.equals(QtdePratosNoAtendimento.get(Y))) {

                    list_AtendimentosModels.get(d).lDescricao = new JLabel(list_AtendimentosModels.get(d).sDescricao,
                            JLabel.RIGHT);

                    if (list_AtendimentosModels.get(d).sDescricao.equals("Almoco")) {
                        list_AtendimentosModels.get(d).lDescricao.setFont(new Font("Courier", Font.BOLD, 14));
                        list_AtendimentosModels.get(d).lValorItem.setFont(new Font("Courier", Font.BOLD, 14));
                    }

                    list_AtendimentosModels.get(d).lValorItem = new JLabel(
                            String.valueOf(list_AtendimentosModels.get(d).fValorItem), JLabel.CENTER);
                    botesConstrutor btnsMesas = new botesConstrutor();

                    list_AtendimentosModels.get(d).textObservacao = list_AtendimentosModels.get(d).sTipo
                            .equals("Observacao") ? new JTextArea(list_AtendimentosModels.get(d).sDescricao) : null;

                    list_AtendimentosModels.get(d).btn_remover = btnsMesas.removeButton;

                    btnRemoverItem = new JButton();
                    btnRemoverItem = list_AtendimentosModels.get(d).btn_remover;
                    btnRemoverItem.addActionListener(this);

                    pratoCompleto.add(list_AtendimentosModels.get(d));
                }
            }
            new Adicionar_ItemAtendimento(pratoCompleto);
        }

    }

    public void actionPerformed(ActionEvent e) {

        for (int x = 0; x < list_Models_Atendimentos.size(); x++) {

            if (e.getSource() == list_Models_Atendimentos.get(x).btn_remover) {

                new Remover_ItemAtendimento(list_Models_Atendimentos.get(x));

            }
        }
    }
}
