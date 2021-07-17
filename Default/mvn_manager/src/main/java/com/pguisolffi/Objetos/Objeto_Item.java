package com.pguisolffi.Objetos;

import javax.swing.JButton;

public class Objeto_Item {

    public int cdItem, indice_atendimentoItem;
    public String sTipo, sDescricao;
    public boolean isSelected;
    public double fValorItem;
    public JButton btn_item;

    public Objeto_Item(int _cdItem, int _indice_atendimentoItem, String _sTipo, String _sDescricao, double _fValorItem,
            JButton _btn_item, boolean _isSelected) {
        this.cdItem = _cdItem;
        this.indice_atendimentoItem = _indice_atendimentoItem;
        this.sTipo = _sTipo;
        this.sDescricao = _sDescricao;
        this.fValorItem = _fValorItem;
        this.btn_item = _btn_item;
        this.isSelected = _isSelected;
    }

}
