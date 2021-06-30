package Default;

import javax.swing.JPanel;

/*****************************************************
 * CLASSE QUE HERDA OS ATRIBUTOS DA SUPERCLASSE MESA *
 *****************************************************/
public class Objeto_Atendimento {

	public int pedido;
	public int numeroMesa;
	public String statusAtendimento;
	public String horaInicioAtendimento;
	public String duracaoAtendimento;
	public String ehDelivery;

	public Objeto_Atendimento(int _pedido, int _numeroMesa, String _statusAtendimento, String _horaInicioAtendimento,
			String _duracaoAtendimento, String _ehDelivery) {

		this.pedido = _pedido;
		this.numeroMesa = _numeroMesa;
		this.statusAtendimento = _statusAtendimento;
		this.horaInicioAtendimento = _horaInicioAtendimento;
		this.duracaoAtendimento = _duracaoAtendimento;
		this.ehDelivery = _ehDelivery;

	}

	public String tempo_atendimento;

	public void FazAlgumaCoisa() {
		System.out.println("==========================================================================");
		System.out.println("= CHAMANDO UM M�TODO DE DENTRO DA CLASSE ATENDIMENTO PARA FAZER QQ COISA =");
		System.out.println("==========================================================================");
	}

}
