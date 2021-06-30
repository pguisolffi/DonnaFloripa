package Default;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/********************
 * SUPERCLASSE MESA *
 ********************/
public class Objeto_Mesa {
	// ATRIBUTOS DA MESA
	public int numero;
	public String status, observacao;
	public JLabel duracao, nomeMesa, entrada;
	public JPanel mesa, corStatus, interiorMesa;
	public JButton btnPlay, btnEye, btnAdd;

	// CONSTRUTOR QUE RECEBE OS ATRIBUTOS COMO PAR�METROS DO OBJETO MESA
	public Objeto_Mesa(int _numero, String _status, String _observacao, JLabel _duracao, JPanel _mesa,
			JPanel _corStatus, JPanel _interiorMesa, JButton _btnPlay, JButton _btnEye, JButton _btnAdd,
			JLabel _nomeMesa, JLabel _entrada) {
		this.numero = _numero;
		this.status = _status;
		this.observacao = _observacao;
		this.duracao = _duracao;
		this.mesa = _mesa;
		this.corStatus = _corStatus;
		this.interiorMesa = _interiorMesa;
		this.btnPlay = _btnPlay;
		this.btnEye = _btnEye;
		this.btnAdd = _btnAdd;
		this.nomeMesa = _nomeMesa;
		this.entrada = _entrada;

	}

	public Map<String, String> map = new HashMap<>();

	public void FazAlgumaCoisa() {
		System.out.println("==========================================================================");
		System.out.println("= CHAMANDO UM M�TODO DE DENTRO DA SUPERCLASSE MESA PARA FAZER QQ COISA ===");
		System.out.println("==========================================================================");
	}

}
