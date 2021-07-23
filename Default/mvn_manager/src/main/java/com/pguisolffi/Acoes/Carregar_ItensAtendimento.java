package com.pguisolffi.Acoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.NumberFormat;
import java.awt.*;

import com.pguisolffi.Utilidades.botesConstrutor;
import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Paineis.Painel_Comanda;

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


        //Criar uma Lista de cada Prato Completo
        for (int Y = 0; Y < QtdePratosNoAtendimento.size(); Y++) {

            List<Objeto_Atendimento> pratoCompleto = new ArrayList<Objeto_Atendimento>();

            for (int d = 0; d < list_AtendimentosModels.size(); d++) {
                
                if ((QtdePratosNoAtendimento.get(Y).contains(list_AtendimentosModels.get(d).idPratoCompleto))) {

                    botesConstrutor btnsMesas = new botesConstrutor();

                    list_AtendimentosModels.get(d).lDescricao = new JLabel(list_AtendimentosModels.get(d).sDescricao,JLabel.RIGHT);
                    list_AtendimentosModels.get(d).lValorItem = new JLabel(format.format(list_AtendimentosModels.get(d).fValorItem), JLabel.CENTER);
                    list_AtendimentosModels.get(d).textObservacao = list_AtendimentosModels.get(d).sTipo.equals("Observacao") ? new JTextArea(list_AtendimentosModels.get(d).sDescricao) : null;
                    list_AtendimentosModels.get(d).btn_remover = btnsMesas.removeButton;
                    list_AtendimentosModels.get(d).lDescricao.setFont(new Font("Courier", Font.BOLD,list_AtendimentosModels.get(d).sDescricao.equals("Almoco") ? 14 : 11));
                    list_AtendimentosModels.get(d).lValorItem.setFont(new Font("Courier", Font.BOLD,list_AtendimentosModels.get(d).sDescricao.equals("Almoco") ? 14 : 11));

                    Painel_Comanda.list_ItensDoAtendimento.add(list_AtendimentosModels.get(d));

                    btnRemoverItem = new JButton();
                    btnRemoverItem = list_AtendimentosModels.get(d).btn_remover;
                    btnRemoverItem.addActionListener(this);

                    pratoCompleto.add(list_AtendimentosModels.get(d));
                }
            }

            //Enviar o Prato Completo para a comanda.
            new Adicionar_ItemAtendimento(pratoCompleto);
        }

        new Atualizar_Valor_Comanda();

    }

    // AÇÃO DO BOTÃO REMOVER
    public void actionPerformed(ActionEvent e) {

        for (int x = 0; x < Painel_Comanda.list_ItensDoAtendimento.size(); x++) {

            if (e.getSource() == Painel_Comanda.list_ItensDoAtendimento.get(x).btn_remover) {

                Painel_Comanda.list_RemoverItensAtendimento.add(Painel_Comanda.list_ItensDoAtendimento.get(x));
                new Atualizar_Valor_Comanda();

                new Remover_ItemAtendimento(Painel_Comanda.list_ItensDoAtendimento.get(x));

            }
        }
    }
}
