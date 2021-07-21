package com.pguisolffi.Acoes;

import java.util.List;
import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.pguisolffi.Objetos.Objeto_Atendimento;

public class Preparar_PratoCompleto {

    JPanel pratoCompleto;
    JPanel gridItens;

    int coluna = 0;
    int linha = 0;

    public JPanel Preparar_PratoInteiro(List<Objeto_Atendimento> list_Atend) {

        pratoCompleto = new JPanel();
        pratoCompleto.setLayout(new BoxLayout(pratoCompleto, BoxLayout.PAGE_AXIS));
        pratoCompleto.setBackground(Color.white);

        gridItens = new JPanel(new GridBagLayout());
        gridItens.setMaximumSize(new Dimension(370, Integer.MAX_VALUE));
        gridItens.setBackground(Color.white);
        GridBagConstraints c = new GridBagConstraints();

        for (int x = 0; x < list_Atend.size(); x++) {
            if (list_Atend.get(x).sTipo.equals("Almoco")) {
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = coluna;
                c.gridy = linha;
                c.ipadx = 1;
                c.weightx = 0.2;
                // c.anchor = GridBagConstraints.FIRST_LINE_START;
                gridItens.add(list_Atend.get(x).lDescricao, c);
                c.fill = GridBagConstraints.HORIZONTAL;
                coluna = coluna + 1;
                c.gridx = coluna;
                c.gridy = linha;
                // c.weightx = 1;
                c.anchor = GridBagConstraints.BELOW_BASELINE_TRAILING;
                gridItens.add(list_Atend.get(x).lValorItem, c);
                c.fill = GridBagConstraints.HORIZONTAL;
                coluna = coluna + 1;
                c.gridx = coluna;
                c.gridy = linha;
                // c.weightx = 1;
                // c.anchor = GridBagConstraints.FIRST_LINE_END;
                gridItens.add(list_Atend.get(x).btn_remover, c);
                pratoCompleto.add(gridItens);

                linha = linha + 1;
                c.gridy = linha;
                coluna = 0;

            }
        }

        for (int z = 0; z < list_Atend.size(); z++) {
            if (list_Atend.get(z).sTipo.equals("Itens Adicionais")) {
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = coluna;
                c.gridy = linha;
                c.ipadx = 1;
                c.weightx = 0.2;
                // c.anchor = GridBagConstraints.FIRST_LINE_START;
                gridItens.add(list_Atend.get(z).lDescricao, c);
                c.fill = GridBagConstraints.HORIZONTAL;
                coluna = coluna + 1;
                c.gridx = coluna;
                // c.gridwidth = 50;
                c.gridy = linha;
                c.anchor = GridBagConstraints.LINE_START;
                gridItens.add(list_Atend.get(z).lValorItem, c);
                c.fill = GridBagConstraints.HORIZONTAL;
                coluna = coluna + 1;
                c.gridx = coluna;
                c.gridy = linha;
                // c.weightx = 1;
                // c.anchor = GridBagConstraints.FIRST_LINE_END;
                gridItens.add(list_Atend.get(z).btn_remover, c);

                // RedimensionarAltura(gridItens);
                pratoCompleto.add(gridItens);

                linha = linha + 1;
                c.gridy = linha;
                coluna = 0;

            }
        }

        for (int y = 0; y < list_Atend.size(); y++) {
            if (list_Atend.get(y).sTipo.equals("Observacao") && !list_Atend.get(y).sDescricao.equals("")) {
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = coluna;
                c.gridy = linha;
                c.gridwidth = 2;
                gridItens.add(list_Atend.get(y).textObservacao, c);
                coluna = coluna + 2;
                c.gridx = coluna;
                c.gridy = linha;
                gridItens.add(list_Atend.get(y).btn_remover, c);
                pratoCompleto.add(gridItens);
                RedimensionarAltura(pratoCompleto);
            }
        }

        return pratoCompleto;

    }

    public void RedimensionarAltura(JPanel jpanel) {
        jpanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, jpanel.getMinimumSize().height));
    }
}
