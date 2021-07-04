package Default.Objetos;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Objeto_Item {

    // ATRIBUTOS DA MESA
    public int cdItem;
    public String sTipo, sDescricao;
    public JLabel lDescricao, lValorItem;
    public double fValorItem;
    public JButton btn_item, btn_remover;

    // CONSTRUTOR QUE RECEBE OS ATRIBUTOS COMO PAR�METROS DO OBJETO MESA
    public Objeto_Item(int _cdItem, String _sTipo, String _sDescricao, JLabel _lDescricao, JLabel _lValorItem,
            double _fValorItem, JButton _btn_item, JButton _btn_remover) {
        this.cdItem = _cdItem;
        this.sTipo = _sTipo;
        this.sDescricao = _sDescricao;
        this.lDescricao = _lDescricao;
        this.lValorItem = _lValorItem;
        this.fValorItem = _fValorItem;
        this.btn_item = _btn_item;
        this.btn_remover = _btn_remover;
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
