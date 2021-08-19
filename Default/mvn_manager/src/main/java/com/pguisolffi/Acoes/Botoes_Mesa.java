package com.pguisolffi.Acoes;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.pguisolffi.Objetos.Objeto_Mesa;
import com.pguisolffi.Paineis.Painel_MesaAtendIniciado;
import com.pguisolffi.Paineis.Painel_Mesa;
import com.pguisolffi.Telas.Tela_AddItens;
import com.pguisolffi.Utilidades.Globals;
import com.pguisolffi.sgbd.Bd_update;

public class Botoes_Mesa {
    

    public void Botao_FinalizarAtendimentoMesa(Objeto_Mesa objMesa) throws InterruptedException, ExecutionException, IOException {

        new Bd_update().BD_Update_Status_Atend_Mesa(objMesa.pedido, "Finalizado");

        objMesa.interiorMesa.add(objMesa.btnAdd);
        objMesa.interiorMesa.remove(objMesa.btnPlay);
        objMesa.interiorMesa.remove(objMesa.btnEye);
        objMesa.interiorMesa.remove(objMesa.lentrada);
        objMesa.mesa.remove(objMesa.lduracao);
        objMesa.corStatus.setBackground(Color.green);

        objMesa.isThreadActive = false;
        objMesa.threadDuracao.interrupt();

    }

    public void Botao_IniciarAtendimentoNaMesa(Objeto_Mesa objMesa, int index){

        Globals globals = new Globals();
        globals.ehDelivery = false;
        globals.numeroPedido++;
        globals.pedidoAtual = globals.numeroPedido;
        objMesa.pedido = globals.pedidoAtual;
        objMesa.status = "Preparando";
        
        try {
            new Tela_AddItens(objMesa.numero);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }

}
