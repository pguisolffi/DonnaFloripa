package com.pguisolffi.Acoes;

import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Paineis.Painel_Comanda;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Adicionar_ItemAtendimento {

    JPanel pratoCompleto;
    public static List<JPanel> List_Panels_de_PratosCompletos;// = new ArrayList<JPanel>();

    public Adicionar_ItemAtendimento(List<Objeto_Atendimento> List_Atendimentos) {

        //Criar um Panel único com todos os ítens de um prato completo
        //Preparar_PratoCompleto prepararPrato = new Preparar_PratoCompleto();
        pratoCompleto = new Preparar_PratoCompleto().Preparar_PratoInteiro(List_Atendimentos);

        //Adicionar o prato Completo na comanda
        Painel_Comanda.painelItensDaComanda.add(pratoCompleto);
        RedimensionarAltura(pratoCompleto);
        RedimensionarAltura(Painel_Comanda.painelItensDaComanda);       

        Painel_Comanda.pPanel_EspacoDireito.updateUI();

        //Adiciona cada Prato Completo numa lista de pratos completos. Para poder remover o Prato inteiro
        List_Panels_de_PratosCompletos = new ArrayList<JPanel>();
        List_Panels_de_PratosCompletos.add(pratoCompleto);
        
        //Cancelar a Barra de progresso ao carregar todas as informações
        if (BarraCircularDeProgresso_gif.BarraVisivel){
        BarraCircularDeProgresso_gif.janela_loading.setVisible(false);
        }

    }

    public void RedimensionarAltura(JPanel jpanel) {
        jpanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, jpanel.getMinimumSize().height));
    }

}
