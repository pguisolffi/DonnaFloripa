package com.pguisolffi.Acoes;

import java.awt.Color;

import com.pguisolffi.Objetos.Objeto_Item;

public class Desabilitar_Habilitar_Botoes {

    public void Desabilitar_BotoesAlmoco(Objeto_Item botoes_Almoco) {

        botoes_Almoco.btn_item.setEnabled(false);
        botoes_Almoco.btn_item.setBackground(Color.LIGHT_GRAY);

    }

    public void Habilitar_BotoesAlmoco(Objeto_Item botoes_Almoco) {
        botoes_Almoco.btn_item.setEnabled(true);
        botoes_Almoco.btn_item.setBackground(Color.ORANGE);
    }

}
