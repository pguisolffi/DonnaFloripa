package com.pguisolffi.Objetos;

import java.awt.Font;
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
	public String status, observacao, duracao, entrada;
	public JLabel lduracao, lnomeMesa, lentrada;
	public JPanel mesa, corStatus, interiorMesa;
	public Boolean isThreadActive;
	public JButton btnPlay, btnEye, btnAdd;
	public Thread threadDuracao;

	// CONSTRUTOR QUE RECEBE OS ATRIBUTOS COMO PAR�METROS DO OBJETO MESA
	public Objeto_Mesa(int _numero, String _status, String _observacao, JLabel _lduracao, JPanel _mesa,
			JPanel _corStatus, JPanel _interiorMesa, JButton _btnPlay, JButton _btnEye, JButton _btnAdd,
			JLabel _lnomeMesa, JLabel _lentrada, String _duracao, String _entrada, Boolean _isThreadActive,
			Thread _threadDuracao) {

		this.numero = _numero;
		this.status = _status;
		this.observacao = _observacao;
		this.lduracao = _lduracao;
		this.mesa = _mesa;
		this.corStatus = _corStatus;
		this.interiorMesa = _interiorMesa;
		this.btnPlay = _btnPlay;
		this.btnEye = _btnEye;
		this.btnAdd = _btnAdd;
		this.lnomeMesa = _lnomeMesa;
		this.lentrada = _lentrada;
		this.duracao = _duracao;
		this.entrada = _entrada;
		this.isThreadActive = _isThreadActive;
		this.threadDuracao = _threadDuracao;

	}

	public Map<String, String> map = new HashMap<>();

	// public void FazAlgumaCoisa() {
	// System.out.println("==========================================================================");
	// System.out.println("= CHAMANDO UM M�TODO DE DENTRO DA SUPERCLASSE MESA PARA
	// FAZER QQ COISA ===");
	// System.out.println("==========================================================================");
	// }

}
