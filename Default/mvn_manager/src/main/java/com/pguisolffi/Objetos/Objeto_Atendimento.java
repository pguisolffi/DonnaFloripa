package com.pguisolffi.Objetos;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Objeto_Atendimento {

	public int pedido;
	public int numeroMesa;
	public int nuSeqItem;
	public String idPratoCompleto;
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
	public JPanel pItem;
	public JTextArea textObservacao;

	public Objeto_Atendimento(int _pedido, int _numeroMesa, int _nuSeqItem, String _idPratoCompleto,
			String _statusAtendimento, String _horaInicioAtendimento, String _horaFimAtendimento,
			String _duracaoAtendimento, Boolean _ehDelivery, int _cdItem, String _sTipo, String _sDescricao,
			JLabel _lDescricao, JLabel _lValorItem, double _fValorItem, double _fValorTotal, JButton _btn_remover,
			JPanel _pItem, JTextArea _textObservacao) {

		this.pedido = _pedido;
		this.numeroMesa = _numeroMesa;
		this.nuSeqItem = _nuSeqItem;
		this.idPratoCompleto = _idPratoCompleto;
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
		this.fValorTotal = _fValorTotal;
		this.btn_remover = _btn_remover;
		this.pItem = _pItem;
		this.textObservacao = _textObservacao;

	}

	public String tempo_atendimento;

}
