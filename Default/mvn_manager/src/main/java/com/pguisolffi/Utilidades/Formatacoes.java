package com.pguisolffi.Utilidades;

//import java.awt.Font;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label;
import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Objetos.Objeto_Mesa;

public class Formatacoes {

    public void Formatar_ObjetoMesa(Objeto_Mesa mesaModel) {
       
        
        RedimensionarComplementos redim = new RedimensionarComplementos();
        int largura_FramePrincipal = redim.Largura_FrameMesas();
        int Altura_FramePrincipal = redim.Altura_FrameMesas();

        mesaModel.lduracao.setFont(new Font("Calibri", Font.BOLD, (int)Math.round(largura_FramePrincipal*0.010667)));
        mesaModel.lduracao.setHorizontalAlignment(JLabel.CENTER);
        mesaModel.lduracao.setVerticalAlignment(JLabel.CENTER);

        mesaModel.lnomeMesa.setFont(new Font("Verdana", 1, (int)Math.round(largura_FramePrincipal*0.010667)));
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

    public void Formatar_Labels_Comanda(Objeto_Atendimento objeto_Atendimento){

        objeto_Atendimento.btn_remover.setHorizontalAlignment(SwingConstants.TRAILING);
        objeto_Atendimento.btn_remover.setVerticalAlignment(SwingConstants.TOP);
        objeto_Atendimento.lDescricao.setFont(new Font("Courier", Font.BOLD,objeto_Atendimento.sTipo.matches("Itens Adicionais|Adicionais Sanduiches") ? 11 : 14 ));
        objeto_Atendimento.lValorItem.setFont(new Font("Courier", Font.BOLD,objeto_Atendimento.sTipo.matches("Itens Adicionais|Adicionais Sanduiches") ? 11 : 14 ));
        objeto_Atendimento.lDescricao.setHorizontalAlignment(JLabel.LEFT);
        objeto_Atendimento.lValorItem.setHorizontalAlignment(JLabel.RIGHT);


    }

}
