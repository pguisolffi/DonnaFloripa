package com.pguisolffi.Utilidades;

//import java.awt.Font;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import com.pguisolffi.Objetos.Objeto_Mesa;

public class Formatacoes {

    public void Formatar_ObjetoMesa(Objeto_Mesa mesaModel) {

        mesaModel.lduracao.setFont(new Font("Calibri", Font.BOLD, 22));
        mesaModel.lduracao.setHorizontalAlignment(JLabel.CENTER);
        mesaModel.lduracao.setVerticalAlignment(JLabel.CENTER);

        mesaModel.lnomeMesa.setFont(new Font("Verdana", 1, 20));
        mesaModel.lnomeMesa.setHorizontalAlignment(JLabel.CENTER);
        mesaModel.lnomeMesa.setVerticalAlignment(JLabel.NORTH);

        mesaModel.mesa.setLayout(new BorderLayout());
        mesaModel.mesa.setBackground(Color.white);
        mesaModel.mesa.setBorder(BorderFactory.createRaisedBevelBorder());

        mesaModel.interiorMesa.setLayout(new BorderLayout());
        mesaModel.interiorMesa.setBackground(Color.white);

        mesaModel.corStatus.setBackground(Color.green);

        mesaModel.mesa.setPreferredSize(new Dimension(200, 200));

    }

}
