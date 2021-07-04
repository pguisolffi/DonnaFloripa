package Default.Objetos;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/********************
 * SUPERCLASSE MESA *
 ********************/
public class Objeto_Delivery {
    // ATRIBUTOS DA MESA
    public int numeroPedido;
    public String duracao, horaEntrada;
    public JLabel lduracao, nPedido, horaEntrega;
    public JButton btnPlay, btnEye, btnAdd;

    // CONSTRUTOR QUE RECEBE OS ATRIBUTOS COMO PAR�METROS DO OBJETO MESA
    public Objeto_Delivery(int _numeroPedido, String _duracao, String _horaEntrada, JLabel _lduracao, JLabel _nPedido,
            JLabel _horaEntrega, JButton _btnPlay, JButton _btnEye, JButton _btnAdd) {
        this.numeroPedido = _numeroPedido;
        this.duracao = _duracao;
        this.horaEntrada = _horaEntrada;
        this.lduracao = _lduracao;
        this.nPedido = _nPedido;
        this.horaEntrega = _horaEntrega;
        this.btnPlay = _btnPlay;
        this.btnEye = _btnEye;
        this.btnAdd = _btnAdd;

    }

    /*
     * public Map<String, String> map = new HashMap<>();
     * 
     * public void FazAlgumaCoisa() { System.out.println(
     * "==========================================================================")
     * ; System.out.
     * println("= CHAMANDO UM M�TODO DE DENTRO DA SUPERCLASSE MESA PARA FAZER QQ COISA ==="
     * ); System.out.println(
     * "==========================================================================")
     * ; }
     */

}
