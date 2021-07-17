package com.pguisolffi.Acoes;

import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Paineis.Painel_Comanda;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Adicionar_ItemAtendimento {

    JPanel pratoCompleto;
    public static List<JPanel> List_PratosCompletos;// = new ArrayList<JPanel>();

    public Adicionar_ItemAtendimento(List<Objeto_Atendimento> List_Atendimentos) {

        Preparar_PratoCompleto prepararPrato = new Preparar_PratoCompleto();
        pratoCompleto = prepararPrato.Preparar_PratoInteiro(List_Atendimentos);

        List_PratosCompletos = new ArrayList<JPanel>();
        List_PratosCompletos.add(pratoCompleto);

        Painel_Comanda.painelItensDaComanda.add(pratoCompleto);
        RedimensionarAltura(pratoCompleto);
        RedimensionarAltura(Painel_Comanda.painelItensDaComanda);

        Painel_Comanda.pPanel_EspacoDireito.updateUI();

    }

    public void RedimensionarAltura(JPanel jpanel) {
        jpanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, jpanel.getMinimumSize().height));
    }

}
