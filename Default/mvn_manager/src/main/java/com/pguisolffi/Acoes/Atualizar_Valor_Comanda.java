package com.pguisolffi.Acoes;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Paineis.Painel_Comanda;

public class Atualizar_Valor_Comanda {

    NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());

    public Atualizar_Valor_Comanda(){

        //Total do Valor da Lista do Painel
        Stream<Objeto_Atendimento> filtroSoma_Itens_ListaDoPainel = Painel_Comanda.list_ItensDoAtendimento.stream().filter(o -> o.fValorItem > 0);
        double soma_ItensPainel = filtroSoma_Itens_ListaDoPainel.collect(Collectors.summingDouble(o -> o.fValorItem));

        //Total do Valor da Lista de a Remover
        Stream<Objeto_Atendimento> aRemover = Painel_Comanda.list_RemoverItensAtendimento.stream().filter(o -> o.fValorItem > 0);
        double soma_ItensARemover = aRemover.collect(Collectors.summingDouble(o -> o.fValorItem));

        Painel_Comanda.lTotalGeral.setText("Total Geral:  " + format.format(soma_ItensPainel - soma_ItensARemover));

        Painel_Comanda.pPanel_EspacoDireito.updateUI();

    } 
    
}
