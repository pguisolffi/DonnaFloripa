package com.pguisolffi.Acoes;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.util.ArrayList;
import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.commons.lang3.RandomStringUtils;

import com.pguisolffi.Paineis.Painel_Comanda;
import com.pguisolffi.Paineis.Painel_Itens;
import com.pguisolffi.Utilidades.botesConstrutor;
import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Objetos.Objeto_Item;

public class Carregar_Botoes implements ActionListener {

    JButton btn_Pratos, btn_ItensAdicionais, btn_Enviar;
    JScrollPane scrollItemsAlmocos, scrollItemsAdicionais;
    JPanel pPanel_BotaoEnviar;
    String idPrato;

    public List<Objeto_Atendimento> list_ModelAtendimentos;
    Objeto_Atendimento ModelItens;

    public Carregar_Botoes() {
        idPrato = RandomStringUtils.randomAlphanumeric(8);
    }

    public void CarregarPratos() {
        list_ModelAtendimentos = new ArrayList<Objeto_Atendimento>();

        JPanel grid_Pratos = new JPanel(new GridLayout(0, 2, 10, 10));
        scrollItemsAlmocos = new JScrollPane(grid_Pratos);
        scrollItemsAlmocos.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        scrollItemsAlmocos.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
        scrollItemsAlmocos.setPreferredSize(new Dimension(400, 200));
        scrollItemsAlmocos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollItemsAlmocos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        for (int y = 0; y < Painel_Itens.listModel_Item_Almoco.size(); y++) {

            btn_Pratos = new JButton(Painel_Itens.listModel_Item_Almoco.get(y).sDescricao);
            Painel_Itens.listModel_Item_Almoco.get(y).btn_item = btn_Pratos;
            Painel_Itens.listModel_Item_Almoco.get(y).btn_item.setFont(new Font("book Antiqua", Font.BOLD, 14));
            Painel_Itens.listModel_Item_Almoco.get(y).btn_item.setPreferredSize(new Dimension(btn_Pratos.getMaximumSize().width, 40));
            Painel_Itens.listModel_Item_Almoco.get(y).btn_item.setBackground(Color.orange);
            Painel_Itens.listModel_Item_Almoco.get(y).btn_item.setMargin(new Insets(0, 0, 0, 0));
            Painel_Itens.listModel_Item_Almoco.get(y).btn_item.setBorder(null);
            grid_Pratos.add(Painel_Itens.listModel_Item_Almoco.get(y).btn_item);
            Painel_Itens.listModel_Item_Almoco.get(y).btn_item.addActionListener(this);
        }

        Painel_Itens.pPainelItens.add(scrollItemsAlmocos);
        scrollItemsAlmocos.setBorder(null);
        Painel_Itens.pPainel_SecundarioPratos.add(Painel_Itens.pPainelItens);
    }

    public void CarregarAdicionais() {
        scrollItemsAdicionais = new JScrollPane(Painel_Itens.pPanel_ItensAdicionais);
        scrollItemsAdicionais.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        scrollItemsAdicionais.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
        scrollItemsAdicionais.setPreferredSize(new Dimension(400, 150));
        scrollItemsAdicionais.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollItemsAdicionais.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollItemsAdicionais.setBorder(null);

        for (int x = 0; x < Painel_Itens.listModel_Item_ItensAdicionais.size(); x++) {

            btn_ItensAdicionais = new JButton(Painel_Itens.listModel_Item_ItensAdicionais.get(x).sDescricao);
            Painel_Itens.listModel_Item_ItensAdicionais.get(x).btn_item = btn_ItensAdicionais;
            Painel_Itens.listModel_Item_ItensAdicionais.get(x).btn_item.setFont(new Font("book Antiqua", Font.BOLD, 12));
            Painel_Itens.listModel_Item_ItensAdicionais.get(x).btn_item.setPreferredSize(new Dimension(btn_ItensAdicionais.getMaximumSize().width, 20));
            Painel_Itens.listModel_Item_ItensAdicionais.get(x).btn_item.setBackground(new Color(255, 238, 180));
            Painel_Itens.listModel_Item_ItensAdicionais.get(x).btn_item.setMargin(new Insets(0, 0, 0, 0));
            Painel_Itens.listModel_Item_ItensAdicionais.get(x).btn_item.setBorder(null);
            Painel_Itens.pPanel_ItensAdicionais.add(Painel_Itens.listModel_Item_ItensAdicionais.get(x).btn_item);
            Painel_Itens.pPanel_ItensAdicionais.setPreferredSize(new Dimension(400, 140));

            Painel_Itens.listModel_Item_ItensAdicionais.get(x).btn_item.addActionListener(this);
        }
        Painel_Itens.pPainel_SecundarioPratos.add(scrollItemsAdicionais);
    }

    public void CarregarObservacao() {

        botesConstrutor btnsMesas = new botesConstrutor();
        pPanel_BotaoEnviar = new JPanel();

        pPanel_BotaoEnviar.setMaximumSize(new Dimension(80, 25));
        pPanel_BotaoEnviar.setMinimumSize(new Dimension(80, 25));
        pPanel_BotaoEnviar.setPreferredSize(new Dimension(50, 25));
        pPanel_BotaoEnviar.setLayout(new CardLayout());

        btn_Enviar = btnsMesas.addItemButton;
        btn_Enviar.addActionListener(this);
        pPanel_BotaoEnviar.add(btn_Enviar);
        Painel_Itens.pPainel_SecundarioPratos.add(pPanel_BotaoEnviar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // AÇÃO DOS BOTOES DO PRATOS.
        for (int x = 0; x < Painel_Itens.listModel_Item_Almoco.size(); x++) {

            if (e.getSource() == Painel_Itens.listModel_Item_Almoco.get(x).btn_item) {

                if (Painel_Itens.listModel_Item_Almoco.get(x).isSelected == true)
                    Painel_Itens.listModel_Item_Almoco.get(x).isSelected = false;
                else
                    Painel_Itens.listModel_Item_Almoco.get(x).isSelected = true;

                for (int d = 0; d < Painel_Itens.listModel_Item_Almoco.size(); d++) {

                    if (d != x && Painel_Itens.listModel_Item_Almoco.get(x).isSelected) {

                        Desabilitar_Habilitar_Botoes desabilitar = new Desabilitar_Habilitar_Botoes();
                        desabilitar.Desabilitar_BotoesAlmoco(Painel_Itens.listModel_Item_Almoco.get(d));
                    }

                    if (d != x && !Painel_Itens.listModel_Item_Almoco.get(x).isSelected) {

                        Desabilitar_Habilitar_Botoes desabilitar = new Desabilitar_Habilitar_Botoes();
                        desabilitar.Habilitar_BotoesAlmoco(Painel_Itens.listModel_Item_Almoco.get(d));

                    }

                    if (d == x && Painel_Itens.listModel_Item_Almoco.get(x).isSelected) {

                        Objeto_Atendimento objetoAtendimento = new Produtos_Disponiveis().Adicionar_Itens(Painel_Itens.listModel_Item_Almoco, e, x, idPrato, "", "Almoco");
                        list_ModelAtendimentos.add(objetoAtendimento);
                        Painel_Itens.listModel_Item_Almoco.get(x).indice_atendimentoItem = list_ModelAtendimentos.size();

                    }

                    if (d == x && !Painel_Itens.listModel_Item_Almoco.get(x).isSelected) {

                        int index = Painel_Itens.listModel_Item_Almoco.get(x).indice_atendimentoItem - 1;
                        list_ModelAtendimentos.remove(Painel_Comanda.list_ItensDoAtendimento.get(index));
                        new Remover_ItemAtendimento(Painel_Comanda.list_ItensDoAtendimento.get(index));
                    }

                }

            }
        }

        for (int x = 0; x < Painel_Itens.listModel_Item_ItensAdicionais.size(); x++) {

            if (e.getSource() == Painel_Itens.listModel_Item_ItensAdicionais.get(x).btn_item) {

                if (Painel_Itens.listModel_Item_ItensAdicionais.get(x).isSelected == true)
                    Painel_Itens.listModel_Item_ItensAdicionais.get(x).isSelected = false;
                else
                    Painel_Itens.listModel_Item_ItensAdicionais.get(x).isSelected = true;

                if (Painel_Itens.listModel_Item_ItensAdicionais.get(x).isSelected) {
                    Objeto_Atendimento objetoAtendimento = new Produtos_Disponiveis().Adicionar_Itens(Painel_Itens.listModel_Item_ItensAdicionais, e, x, idPrato, "", "Itens Adicionais");

                    list_ModelAtendimentos.add(objetoAtendimento);
                    Painel_Itens.listModel_Item_ItensAdicionais.get(x).indice_atendimentoItem = list_ModelAtendimentos.size();
                    Painel_Itens.listModel_Item_ItensAdicionais.get(x).btn_item.setBackground(Color.orange);

                }

                else {
                    int index = Painel_Itens.listModel_Item_ItensAdicionais.get(x).indice_atendimentoItem - 1;
                    list_ModelAtendimentos.remove(list_ModelAtendimentos.get(index));
                    Painel_Itens.listModel_Item_ItensAdicionais.get(x).btn_item.setBackground(new Color(255, 238, 180));
                }

            }
        }

        if (e.getSource() == btn_Enviar) {

            String observacao = Painel_Itens.tTextField_Observacoes.getText();
            
            List<Objeto_Item> objetoItem_Observacao = new ArrayList<Objeto_Item>();

            Objeto_Atendimento objetoAtendimento = new Produtos_Disponiveis().Adicionar_Itens(objetoItem_Observacao, e, 0, idPrato,observacao, "Observacao");

            list_ModelAtendimentos.add(objetoAtendimento);

            new Adicionar_ItemAtendimento(list_ModelAtendimentos);

            LiberarItemsParaNovoPrato();

        }

    }

    public void LiberarItemsParaNovoPrato() {

        for (int x = 0; x < Painel_Itens.listModel_Item_ItensAdicionais.size(); x++) {

            Painel_Itens.listModel_Item_ItensAdicionais.get(x).btn_item.setBackground(new Color(255, 238, 180));
            Painel_Itens.listModel_Item_ItensAdicionais.get(x).isSelected = false;

        }

        for (int x = 0; x < Painel_Itens.listModel_Item_Almoco.size(); x++) {

            Desabilitar_Habilitar_Botoes desabilitar = new Desabilitar_Habilitar_Botoes();
            desabilitar.Habilitar_BotoesAlmoco(Painel_Itens.listModel_Item_Almoco.get(x));
            Painel_Itens.listModel_Item_Almoco.get(x).isSelected = false;

        }

        list_ModelAtendimentos.clear();
        idPrato = RandomStringUtils.randomAlphanumeric(8);

    }

}
