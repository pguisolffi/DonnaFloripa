package com.pguisolffi.Acoes;

import com.pguisolffi.Paineis.Painel_Comanda;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.text.NumberFormat;
import java.awt.*;

import com.pguisolffi.Utilidades.botesConstrutor;
import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Acoes.Remover_ItemAtendimento;

public class Carregar_ItensAtendimento implements ActionListener {

    NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
    JButton btnRemoverItem;
    List<Objeto_Atendimento> list_Models_Atendimentos = new ArrayList<Objeto_Atendimento>();

    public Carregar_ItensAtendimento(List<Objeto_Atendimento> list_AtendimentosModels) {

        for (int z = 0; z < list_AtendimentosModels.size(); z++) {

            list_AtendimentosModels.get(z).lDescricao = new JLabel(list_AtendimentosModels.get(z).sDescricao,
                    JLabel.RIGHT);
            list_AtendimentosModels.get(z).lValorItem = new JLabel(
                    String.valueOf(list_AtendimentosModels.get(z).fValorItem), JLabel.CENTER);
            botesConstrutor btnsMesas = new botesConstrutor();
            list_AtendimentosModels.get(z).btn_remover = btnsMesas.removeButton;

            Painel_Comanda.pGrid_ItensComanda.setBackground(Color.white);
            Painel_Comanda.pGrid_ItensComanda.add(list_AtendimentosModels.get(z).lDescricao);
            Painel_Comanda.pGrid_ItensComanda.add(list_AtendimentosModels.get(z).lValorItem);
            Painel_Comanda.pGrid_ItensComanda.add(list_AtendimentosModels.get(z).btn_remover);

            RedimensionarAltura(Painel_Comanda.pGrid_ItensComanda);

            Painel_Comanda.lTotalGeral
                    .setText("Total Geral:  " + format.format(list_AtendimentosModels.get(z).fValorTotal));

            list_Models_Atendimentos = list_AtendimentosModels;

            btnRemoverItem = new JButton();
            btnRemoverItem = list_AtendimentosModels.get(z).btn_remover;
            btnRemoverItem.addActionListener(this);

            Painel_Comanda.pPanel_EspacoDireito.updateUI();

        }

    }

    public void RedimensionarAltura(JPanel jpanel) {
        jpanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, jpanel.getMinimumSize().height));
    }

    public void actionPerformed(ActionEvent e) {

        for (int x = 0; x < list_Models_Atendimentos.size(); x++) {

            if (e.getSource() == list_Models_Atendimentos.get(x).btn_remover) {

                new Remover_ItemAtendimento(list_Models_Atendimentos.get(x));

            }
        }
    }
}
