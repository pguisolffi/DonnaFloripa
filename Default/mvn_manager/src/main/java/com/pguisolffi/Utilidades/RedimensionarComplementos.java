package com.pguisolffi.Utilidades;

import com.pguisolffi.Telas.Tela_Principal;

public class RedimensionarComplementos {
    
    public int Altura_FrameMesas(){
        int alturaFrame = 0;
        alturaFrame = Tela_Principal.Frame_TelaPrincipal.getHeight();
        return alturaFrame;
    }

    public int Largura_FrameMesas(){
        int larguraFrame = 0;
        larguraFrame = Tela_Principal.Frame_TelaPrincipal.getWidth();
        return larguraFrame;
    }


}
