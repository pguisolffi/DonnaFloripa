package com.pguisolffi.Paineis;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.BorderLayout;

import com.pguisolffi.Acoes.Botoes_Mesa;
import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Objetos.Objeto_Mesa;
import com.pguisolffi.Utilidades.Globals;
import com.pguisolffi.Utilidades.RedimensionarComplementos;
import com.pguisolffi.Utilidades.botesConstrutor;
import com.pguisolffi.Telas.Tela_AddItens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Painel_MesaConsumindo implements ActionListener {
    
    int indice = 0;

    public Painel_MesaConsumindo(Objeto_Mesa objMesa) {

        botesConstrutor btns = new botesConstrutor();
        objMesa.interiorMesa.remove(objMesa.btnPlay);
        objMesa.btnPlay = btns.finishAtendButton;
        objMesa.interiorMesa.add(objMesa.btnPlay,BorderLayout.LINE_START);
        objMesa.corStatus.setBackground(Color.blue);
        objMesa.btnPlay.addActionListener(this);

        RedimensionarComplementos redim = new RedimensionarComplementos();
        int largura_FramePrincipal = redim.Largura_FrameMesas();
        int Altura_FramePrincipal = redim.Altura_FrameMesas();
        objMesa.mesa.setPreferredSize(new Dimension((int)Math.round(largura_FramePrincipal*0.15),(int)Math.round(Altura_FramePrincipal*0.18)));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int x=0;x<Painel_Mesa.list_ObjetoMesa.size();x++)    {

            //AO FINALIZAR O ATENDIMENTO
            if (e.getSource() == Painel_Mesa.list_ObjetoMesa.get(x).btnPlay){
                    try {
                        new Botoes_Mesa().Botao_FinalizarAtendimentoMesa(Painel_Mesa.list_ObjetoMesa.get(x));
                    } catch (InterruptedException | ExecutionException | IOException e1) {
                        e1.printStackTrace();
                    }
            }

        }       
    } 

}
