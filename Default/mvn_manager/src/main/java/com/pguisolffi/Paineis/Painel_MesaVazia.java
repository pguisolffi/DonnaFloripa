package com.pguisolffi.Paineis;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;

import com.pguisolffi.Objetos.Objeto_Mesa;
import com.pguisolffi.Utilidades.Formatacoes;
import com.pguisolffi.Utilidades.botesConstrutor;

public class Painel_MesaVazia {

    public Objeto_Mesa Painel_MesaVazia(int indice){

        botesConstrutor btnsMesas = new botesConstrutor();

        Objeto_Mesa mesaModel = new Objeto_Mesa(0,0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

        mesaModel.btnPlay = btnsMesas.ConfirmButton;
        mesaModel.btnEye = btnsMesas.EyeButton;
        mesaModel.btnAdd = btnsMesas.PlayButton;
        mesaModel.numero = indice;
        mesaModel.corStatus = new JPanel();
        mesaModel.interiorMesa = new JPanel(new GridBagLayout());
        mesaModel.lduracao = new JLabel();
        mesaModel.lentrada = new JLabel();
        mesaModel.lnomeMesa = new JLabel("Mesa " + indice);
        mesaModel.mesa = new JPanel(new GridBagLayout());
        new Formatacoes().Formatar_ObjetoMesa(mesaModel);
        mesaModel.mesa.add(mesaModel.corStatus, BorderLayout.PAGE_START);
        mesaModel.interiorMesa.add(mesaModel.lnomeMesa, BorderLayout.PAGE_START);
        mesaModel.interiorMesa.add(mesaModel.btnAdd, BorderLayout.CENTER);
        mesaModel.mesa.add(mesaModel.interiorMesa, BorderLayout.CENTER);

        return mesaModel;

    }
    
}
