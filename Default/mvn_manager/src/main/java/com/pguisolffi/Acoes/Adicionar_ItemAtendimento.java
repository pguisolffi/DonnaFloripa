package com.pguisolffi.Acoes;

import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Paineis.Painel_Comanda;
import java.awt.GridBagConstraints;

public class Adicionar_ItemAtendimento {
    public Adicionar_ItemAtendimento(Objeto_Atendimento objeto_Atendimento) {

        if (objeto_Atendimento.sTipo == "Observacao") {
            Painel_Comanda.gbc.ipady = 40; // make this component tall
            Painel_Comanda.pGrid_ItensComanda.add(objeto_Atendimento.lDescricao, Painel_Comanda.gbc);
            Painel_Comanda.gbc.ipadx = 50;
            Painel_Comanda.pGrid_ItensComanda.add(objeto_Atendimento.btn_remover, Painel_Comanda.gbc);
            Painel_Comanda.gbc.gridy++;
        } else {

            Painel_Comanda.gbc.ipadx = 100;
            Painel_Comanda.pGrid_ItensComanda.add(objeto_Atendimento.lDescricao, Painel_Comanda.gbc);
            Painel_Comanda.gbc.ipadx = 50;
            Painel_Comanda.pGrid_ItensComanda.add(objeto_Atendimento.lValorItem, Painel_Comanda.gbc);
            Painel_Comanda.gbc.ipadx = 50;
            Painel_Comanda.pGrid_ItensComanda.add(objeto_Atendimento.btn_remover, Painel_Comanda.gbc);
            Painel_Comanda.gbc.gridy++;
        }

        Painel_Comanda.pPanel_EspacoDireito.updateUI();

    }
}
