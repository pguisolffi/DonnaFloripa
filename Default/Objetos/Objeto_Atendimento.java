package Default.Objetos;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*****************************************************
 * CLASSE QUE HERDA OS ATRIBUTOS DA SUPERCLASSE MESA *
 *****************************************************/
public class Objeto_Atendimento {

	public int pedido;
	public int numeroMesa;
	public String statusAtendimento;
	public String horaInicioAtendimento;
	public String horaFimAtendimento;
	public String duracaoAtendimento;
	public Boolean ehDelivery;
	public int cdItem;
	public String sTipo, sDescricao;
	public JLabel lDescricao, lValorItem;
	public double fValorItem, fValorTotal;
	public JButton btn_remover;

	public Objeto_Atendimento(int _pedido, int _numeroMesa, String _statusAtendimento, String _horaInicioAtendimento,
			String _horaFimAtendimento, String _duracaoAtendimento, Boolean _ehDelivery, int _cdItem, String _sTipo,
			String _sDescricao, JLabel _lDescricao, JLabel _lValorItem, double _fValorItem, double _fValorTotal,
			JButton _btn_remover) {

		this.pedido = _pedido;
		this.statusAtendimento = _statusAtendimento;
		this.horaInicioAtendimento = _horaInicioAtendimento;
		this.horaFimAtendimento = _horaFimAtendimento;
		this.duracaoAtendimento = _duracaoAtendimento;
		this.ehDelivery = _ehDelivery;
		this.cdItem = _cdItem;
		this.sTipo = _sTipo;
		this.sDescricao = _sDescricao;
		this.lDescricao = _lDescricao;
		this.lValorItem = _lValorItem;
		this.fValorItem = _fValorItem;
		this.fValorItem = _fValorTotal;
		this.btn_remover = _btn_remover;

	}

	public String tempo_atendimento;

	public void FazAlgumaCoisa() {
		// System.out.println("==========================================================================");
		// System.out.println("= CHAMANDO UM M�TODO DE DENTRO DA CLASSE ATENDIMENTO PARA
		// FAZER QQ COISA =");
		// System.out.println("==========================================================================");
	}

}
