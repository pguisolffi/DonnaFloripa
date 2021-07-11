package com.pguisolffi.Acoes;

import java.util.List;

import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Paineis.Painel_Comanda;
import com.pguisolffi.Paineis.Painel_Itens;
import com.pguisolffi.sgbd.Bd_Delete;

public class Remover_ItemAtendimento {

    public Remover_ItemAtendimento(Objeto_Atendimento objeto_Atendimento) {

        Painel_Comanda.pGrid_ItensComanda.remove(objeto_Atendimento.lDescricao);
        Painel_Comanda.pGrid_ItensComanda.remove(objeto_Atendimento.lValorItem);
        Painel_Comanda.pGrid_ItensComanda.remove(objeto_Atendimento.btn_remover);
        Painel_Itens.listModel_Atendimento.remove(objeto_Atendimento);

        Bd_Delete bd_delete = new Bd_Delete();
        bd_delete.delete_AtendimentoItem(
                String.valueOf(objeto_Atendimento.pedido + "Sq" + objeto_Atendimento.nuSeqItem));

        Painel_Comanda.pPanel_EspacoDireito.updateUI();
    }
}
