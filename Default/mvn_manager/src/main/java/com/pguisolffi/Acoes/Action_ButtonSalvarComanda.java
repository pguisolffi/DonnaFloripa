package com.pguisolffi.Acoes;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.sgbd.Bd_Set;

public class Action_ButtonSalvarComanda {

    public void GravarComanda(List<Objeto_Atendimento> listModel_Atendimento)
            throws InterruptedException, ExecutionException, IOException {

        Bd_Set bd_set = new Bd_Set();
        bd_set.BD_Set_NovoAtendimento(listModel_Atendimento);

    }

}