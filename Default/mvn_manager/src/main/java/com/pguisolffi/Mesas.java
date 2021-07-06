package com.pguisolffi;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.pguisolffi.Paineis.Painel_Mesa;

public class Mesas extends JPanel implements ActionListener {
	public static int indice;
	// public static JLabel label;
	public static JPanel mesa;

	int qtde_mesas = Configuracoes.qtde_mesas;

	public Mesas() {
		// VARIÁVEIS LOCAIS
		indice = 0;

		// INSTANCIAR OBJETOS
		mesa = new JPanel();

		// ADICIONA O PAINEL DE CADA MESA NO PAINEL DAS MESAS
		for (int i = 0; i < qtde_mesas; i++) {
			indice++;
			mesa = new JPanel();

			// mesa.setAlignmentX(Component.LEFT_ALIGNMENT);
			mesa.setPreferredSize(new Dimension(450, 150));
			mesa.setBorder(BorderFactory.createTitledBorder("MESA " + indice));

			Painel_Mesa.painel_mesas.add(mesa);
			Painel_Mesa.lista_mesas_painel.add(mesa);

		}

		Painel_Mesa.painel_mesas_com_scroll.updateUI();

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
