package com.pguisolffi.Objetos;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Objeto_Item {

    // ATRIBUTOS DA MESA
    public int cdItem;
    public String sTipo, sDescricao;
    public double fValorItem;
    public JButton btn_item;

    // CONSTRUTOR QUE RECEBE OS ATRIBUTOS COMO PAR�METROS DO OBJETO MESA
    public Objeto_Item(int _cdItem, String _sTipo, String _sDescricao, double _fValorItem, JButton _btn_item) {
        this.cdItem = _cdItem;
        this.sTipo = _sTipo;
        this.sDescricao = _sDescricao;
        this.fValorItem = _fValorItem;
        this.btn_item = _btn_item;
    }

    /*
     * public void FazAlgumaCoisa() { System.out.println(
     * "==========================================================================")
     * ; System.out.
     * println("= CHAMANDO UM M�TODO DE DENTRO DA SUPERCLASSE MESA PARA FAZER QQ COISA ==="
     * ); System.out.println(
     * "==========================================================================")
     * ; }
     */

}
