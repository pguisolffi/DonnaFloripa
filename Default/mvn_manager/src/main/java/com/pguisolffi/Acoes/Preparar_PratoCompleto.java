package com.pguisolffi.Acoes;

import java.util.List;
import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Utilidades.Formatacoes;

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

        //ALMOÇO
        for (int x = 0; x < list_Atend.size(); x++) {
            if (list_Atend.get(x).sTipo.equals("Almoco") || list_Atend.get(x).sTipo.equals("Sanduiches") ) {
                new Formatacoes().Formatar_Labels_Comanda(list_Atend.get(x));
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = coluna;
                c.gridy = linha;
                c.ipadx = 1;
                c.weightx = 1f;
                gridItens.add(list_Atend.get(x).lDescricao, c);
                c.fill = GridBagConstraints.HORIZONTAL;
                coluna = coluna + 1;
                c.gridx = coluna;
                c.gridy = linha;
                c.weightx = 0f;
                // c.weightx = 1;
                c.anchor = GridBagConstraints.EAST;
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

        //ÍTENS ADICIONAIS
        for (int z = 0; z < list_Atend.size(); z++) {
            if (list_Atend.get(z).sTipo.equals("Itens Adicionais")|| list_Atend.get(z).sTipo.equals("Adicionais Sanduiches")) {
                new Formatacoes().Formatar_Labels_Comanda(list_Atend.get(z));
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = coluna;
                c.gridy = linha;
                c.ipadx = 1;
                c.weightx = 1f;
                gridItens.add(list_Atend.get(z).lDescricao, c);
                c.fill = GridBagConstraints.HORIZONTAL;
                coluna = coluna + 1;
                c.gridx = coluna;
                c.weightx = 0f;
                c.gridy = linha;
                c.anchor = GridBagConstraints.EAST;
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

        //OBSERVAÇÃO
        for (int y = 0; y < list_Atend.size(); y++) {
            if (list_Atend.get(y).sTipo.equals("Observacao") && !list_Atend.get(y).sDescricao.equals("")) {
                new Formatacoes().Formatar_Labels_Comanda(list_Atend.get(y));
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

        //BEBIDAS
        for (int x = 0; x < list_Atend.size(); x++) {
            if (list_Atend.get(x).sTipo.equals("Bebidas")) {
                new Formatacoes().Formatar_Labels_Comanda(list_Atend.get(x));
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = coluna;
                c.gridy = linha;
                c.ipadx = 1;
                c.weightx = 1f;
                // c.anchor = GridBagConstraints.FIRST_LINE_START;
                gridItens.add(list_Atend.get(x).lDescricao, c);
                c.fill = GridBagConstraints.HORIZONTAL;
                coluna = coluna + 1;
                c.gridx = coluna;
                c.gridy = linha;
                c.weightx = 0f;
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

        //Cafes Quentes
        for (int x = 0; x < list_Atend.size(); x++) {
            if (list_Atend.get(x).sTipo.equals("Cafes Quentes")) {
                new Formatacoes().Formatar_Labels_Comanda(list_Atend.get(x));
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = coluna;
                c.gridy = linha;
                c.ipadx = 1;
                c.weightx = 1f;
                // c.anchor = GridBagConstraints.FIRST_LINE_START;
                gridItens.add(list_Atend.get(x).lDescricao, c);
                c.fill = GridBagConstraints.HORIZONTAL;
                coluna = coluna + 1;
                c.gridx = coluna;
                c.gridy = linha;
                c.weightx = 0f;
                c.anchor = GridBagConstraints.EAST;
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

        //Cafes Gelados
        for (int x = 0; x < list_Atend.size(); x++) {
            if (list_Atend.get(x).sTipo.equals("Cafes Gelados")) {
                new Formatacoes().Formatar_Labels_Comanda(list_Atend.get(x));
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = coluna;
                c.gridy = linha;
                c.ipadx = 1;
                c.weightx = 1f;
                gridItens.add(list_Atend.get(x).lDescricao, c);
                c.fill = GridBagConstraints.HORIZONTAL;
                coluna = coluna + 1;
                c.gridx = coluna;
                c.gridy = linha;
                c.weightx = 0f;
                c.anchor = GridBagConstraints.EAST;
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

        return pratoCompleto;

    }

    public void RedimensionarAltura(JPanel jpanel) {
        jpanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, jpanel.getMinimumSize().height));
    }
}
