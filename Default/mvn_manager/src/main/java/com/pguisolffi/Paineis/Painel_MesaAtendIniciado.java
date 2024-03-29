package com.pguisolffi.Paineis;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.awt.BorderLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.time.LocalDateTime;

import com.pguisolffi.Objetos.Objeto_Mesa;
import com.pguisolffi.Utilidades.Globals;
import com.pguisolffi.Utilidades.MinhasThreadsMesa;
import com.pguisolffi.Utilidades.RedimensionarComplementos;
import com.pguisolffi.sgbd.Bd_get;

import org.threeten.bp.LocalDate;

public class Painel_MesaAtendIniciado {

    public Painel_MesaAtendIniciado(Objeto_Mesa objMesa,boolean jaExistiaAtendimento) throws InterruptedException, ExecutionException, IOException{

        SimpleDateFormat formatoHoraMinuto = new SimpleDateFormat("HH:mm");

        objMesa.lentrada.setText("    " + formatoHoraMinuto.format(new Date()).toString() + "    ");
        objMesa.entrada = jaExistiaAtendimento ? objMesa.entrada : LocalDateTime.now().toString();
        objMesa.status = jaExistiaAtendimento ? new Bd_get().Get_statusMesa(objMesa.numero) : "Preparando";
        objMesa.corStatus.setBackground(objMesa.status.equals("Preparando") ? Color.orange : Color.blue );
        objMesa.interiorMesa.remove(objMesa.btnAdd);
        objMesa.interiorMesa.add(objMesa.btnPlay,BorderLayout.LINE_START);
        objMesa.interiorMesa.add(objMesa.btnEye,BorderLayout.CENTER);
        objMesa.interiorMesa.add(objMesa.lentrada,BorderLayout.LINE_END);
        objMesa.mesa.add(objMesa.lduracao,BorderLayout.PAGE_END);
        objMesa.isThreadActive = true;
        
        RedimensionarComplementos redim = new RedimensionarComplementos();
        int largura_FramePrincipal = redim.Largura_FrameMesas();
        int Altura_FramePrincipal = redim.Altura_FrameMesas();
        objMesa.mesa.setPreferredSize(new Dimension((int)Math.round(largura_FramePrincipal*0.15),(int)Math.round(Altura_FramePrincipal*0.18)));


        Globals.ehDelivery = false;

        objMesa.threadDuracao = new MinhasThreadsMesa(objMesa);

        if (objMesa.status.equals("Consumindo")){
            new Painel_MesaConsumindo(Globals.ehAtendimentoAntigo ? objMesa : Painel_Mesa.list_ObjetoMesa.get((objMesa.numero)-1));
        }

        Painel_Mesa.painel_mesas_com_scroll.updateUI();      

    }
    
}
