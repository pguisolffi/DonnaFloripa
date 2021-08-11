package com.pguisolffi.Acoes;

import com.pguisolffi.Objetos.Objeto_Atendimento;

import java.awt.Component;
import java.awt.Dimension;
import java.util.Arrays;

import javax.swing.JPanel;

import com.pguisolffi.Paineis.Painel_Comanda;

public class Remover_ItemAtendimento {

 
    public Remover_ItemAtendimento(Objeto_Atendimento objeto_Atendimento) {

        //idPrato = objeto_Atendimento.idPratoCompleto;

        //Contar a quantidade de ìtens no Panel do Prato
        for (int x = 0; x < Adicionar_ItemAtendimento.List_Panels_de_PratosCompletos.get(0).getParent()
                .getComponentCount(); x++) {

            //Pegar o componete Panel_PratoCompleto para poder remover dele os ítens
            Component[] components = Adicionar_ItemAtendimento.List_Panels_de_PratosCompletos.get(0).getParent().getComponents();
            JPanel panelPratoCompleto = (JPanel) components[x];
            components = panelPratoCompleto.getComponents();
            panelPratoCompleto = (JPanel) components[0];

            //Caso No Prato completo tenha o Ítem clicado, ele remove este ítem clicado
            if (Arrays.asList(panelPratoCompleto.getComponents()).contains(objeto_Atendimento.btn_remover)) {

                //Caso seja Almoço, remove todos os ítens desse Panel_PratoCompleto
                switch (objeto_Atendimento.sTipo) {
                    case "Almoco":
                        panelPratoCompleto.removeAll();
                        Insere_Na_ListaDeRemocao(objeto_Atendimento);
                        break;
                    case "Sanduiches":
                        panelPratoCompleto.removeAll();
                        Insere_Na_ListaDeRemocao(objeto_Atendimento);
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
                new Atualizar_Valor_Comanda();
                Painel_Comanda.pPanel_EspacoDireito.updateUI();
                RedimensionarAltura(Painel_Comanda.painelItensDaComanda);
                
            }
        }

        
    }

    public void Insere_Na_ListaDeRemocao(Objeto_Atendimento objeto_Atendimento){

        for (int f = 0; f < Painel_Comanda.list_ItensDoAtendimento.size(); f++) {

            if (Painel_Comanda.list_ItensDoAtendimento.get(f).idPratoCompleto.equals(objeto_Atendimento.idPratoCompleto)) {

                if (!Painel_Comanda.list_RemoverItensAtendimento.contains(Painel_Comanda.list_ItensDoAtendimento.get(f))){
                try {
                    Painel_Comanda.list_RemoverItensAtendimento.add(Painel_Comanda.list_ItensDoAtendimento.get(f));
                } catch (Exception e) {
                    //TODO: handle exception
                }    }
                
            }
            new Atualizar_Valor_Comanda();
        }
    }

    public void RedimensionarAltura(JPanel jpanel) {
        jpanel.setMaximumSize(new Dimension(370, jpanel.getMinimumSize().height));
    }
}
