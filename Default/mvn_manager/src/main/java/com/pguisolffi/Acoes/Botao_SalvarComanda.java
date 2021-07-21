package com.pguisolffi.Acoes;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Paineis.Painel_Comanda;
import com.pguisolffi.sgbd.Bd_Delete;
import com.pguisolffi.sgbd.Bd_Set;

public class Botao_SalvarComanda {

    public void GravarComanda(List<Objeto_Atendimento> listModel_Atendimento, int numeroMesa,List<Objeto_Atendimento> list_ItensParaRemover)
            throws InterruptedException, ExecutionException, IOException {



        // AO SALVAR - Remover do banco de dados os ítems que foram excluídos da comanda e remover da lista de itens da comanda
        if (!list_ItensParaRemover.isEmpty()) {

            for (int y = 0; y < list_ItensParaRemover.size(); y++) {

                //Remove da Principal lista da Comanda
                Painel_Comanda.list_ItensDoAtendimento.remove(list_ItensParaRemover.get(y));

                //Remove do Banco de Dados
                if (list_ItensParaRemover.get(y).idPratoCompleto.equals(list_ItensParaRemover.get(y).idPratoCompleto)) {

                        Bd_Delete bd_delete = new Bd_Delete();
                        bd_delete.delete_AtendimentoItem(String.valueOf(Painel_Comanda.list_ItensDoAtendimento.get(y)
                        .pedido + "Sq"+ Painel_Comanda.list_ItensDoAtendimento.get(y).nuSeqItem));
                }
            }

        }

        //AO SALVAR - Inserir no Banco de dados os ítens da comanda (Insert/Update Atendimento)  
        new Bd_Set().BD_Set_NovoAtendimento( Painel_Comanda.list_ItensDoAtendimento, numeroMesa);

    }

}