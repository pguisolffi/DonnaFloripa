package com.pguisolffi.Acoes;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import org.apache.commons.lang3.RandomStringUtils;

import com.pguisolffi.Paineis.Painel_Comanda;
import com.pguisolffi.Paineis.Painel_Itens;
import com.pguisolffi.Utilidades.Globals;
import com.pguisolffi.Utilidades.botesConstrutor;
import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Objetos.Objeto_Item;

public class Carregar_Botoes implements ActionListener,MouseListener {

    JButton btn_Pratos,btn_Sanduiches, btn_ItensAdicionais, btn_Enviar, btn_bebidas,btn_CafesQuentes,btn_CafesGelados,btn_ItensAdicionaisSanduiches;
    JScrollPane scrollItemsAlmocos,scrollItemsSanduiches, scrollItemsAdicionais,scrollBebidas,ScrollCafesQuentes,scrollCafesGelados,scrollItemsAdicionaisSanduiches;
    JPanel pPanel_BotaoEnviar;
    String idPrato;

    public List<Objeto_Atendimento> list_ItensSelecionados;
    public List<Objeto_Item> list_PratosAlmocos = new ArrayList<Objeto_Item>();
    public List<Objeto_Item> list_Bebidas = new ArrayList<Objeto_Item>();
    public List<Objeto_Item> list_CafesQuentes = new ArrayList<Objeto_Item>();
    public List<Objeto_Item> list_CafesGelados = new ArrayList<Objeto_Item>();
    public List<Objeto_Item> List_itensAdicionais = new ArrayList<Objeto_Item>();
    public List<Objeto_Item> List_BotoesEnviar = new ArrayList<Objeto_Item>();
    public List<Objeto_Item> List_Sanduiches = new ArrayList<Objeto_Item>();
    public List<Objeto_Item> List_itensAdicionaisSanduiches = new ArrayList<Objeto_Item>();
    Objeto_Atendimento ModelItens;



    public Carregar_Botoes() {
        idPrato = RandomStringUtils.randomAlphanumeric(8);
    }

    public void CarregarPratos() {

        for (Objeto_Item obj_item : Painel_Itens.listModel_Produtos){
            if(obj_item.sTipo.equals("Almoco"))
                list_PratosAlmocos.add(obj_item);
        }

        list_ItensSelecionados = new ArrayList<Objeto_Atendimento>();

        JPanel grid_Pratos = new JPanel(new GridLayout(0, 2, 10, 10));
        scrollItemsAlmocos = new JScrollPane(grid_Pratos);
        scrollItemsAlmocos.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        scrollItemsAlmocos.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
        scrollItemsAlmocos.setPreferredSize(new Dimension(400, 200));
        scrollItemsAlmocos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollItemsAlmocos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        for (int y = 0; y < list_PratosAlmocos.size(); y++) {

            btn_Pratos = new JButton(list_PratosAlmocos.get(y).sDescricao);
            list_PratosAlmocos.get(y).btn_item = btn_Pratos;
            list_PratosAlmocos.get(y).btn_item.setFont(new Font("book Antiqua", Font.BOLD, 14));
            list_PratosAlmocos.get(y).btn_item.setPreferredSize(new Dimension(btn_Pratos.getMaximumSize().width, 40));
            list_PratosAlmocos.get(y).btn_item.setBackground(Color.orange);
            list_PratosAlmocos.get(y).btn_item.setMargin(new Insets(0, 0, 0, 0));
            list_PratosAlmocos.get(y).btn_item.setBorder(null);
            grid_Pratos.add(list_PratosAlmocos.get(y).btn_item);
            list_PratosAlmocos.get(y).btn_item.addActionListener(this);
        }

        Painel_Itens.pPainelItens.add(scrollItemsAlmocos);
        scrollItemsAlmocos.setBorder(null);
        Painel_Itens.pPainel_SecundarioPratos.add(Painel_Itens.pPainelItens);
    }

    public void CarregarAdicionais() {

        for (Objeto_Item obj_item : Painel_Itens.listModel_Produtos){
            if(obj_item.sTipo.equals("Itens Adicionais"))
                List_itensAdicionais.add(obj_item);
        }

        scrollItemsAdicionais = new JScrollPane(Painel_Itens.pPanel_ItensAdicionais);
        scrollItemsAdicionais.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        scrollItemsAdicionais.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
        scrollItemsAdicionais.setPreferredSize(new Dimension(400, 150));
        scrollItemsAdicionais.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollItemsAdicionais.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollItemsAdicionais.setBorder(null);

        for (int x = 0; x < List_itensAdicionais.size(); x++) {

            btn_ItensAdicionais = new JButton(List_itensAdicionais.get(x).sDescricao);
            List_itensAdicionais.get(x).btn_item = btn_ItensAdicionais;
            List_itensAdicionais.get(x).btn_item.setFont(new Font("book Antiqua", Font.BOLD, 12));
            List_itensAdicionais.get(x).btn_item.setPreferredSize(new Dimension(btn_ItensAdicionais.getMaximumSize().width, 20));
            List_itensAdicionais.get(x).btn_item.setBackground(new Color(255, 238, 180));
            List_itensAdicionais.get(x).btn_item.setMargin(new Insets(0, 0, 0, 0));
            List_itensAdicionais.get(x).btn_item.setBorder(null);
            Painel_Itens.pPanel_ItensAdicionais.add(List_itensAdicionais.get(x).btn_item);
            Painel_Itens.pPanel_ItensAdicionais.setPreferredSize(new Dimension(400, 140));

            List_itensAdicionais.get(x).btn_item.addActionListener(this);
        }
        Painel_Itens.pPainel_SecundarioPratos.add(scrollItemsAdicionais);
    }

    public void CarregarSanduiches() {

        for (Objeto_Item obj_item : Painel_Itens.listModel_Produtos){
            if(obj_item.sTipo.equals("Sanduiches"))
                List_Sanduiches.add(obj_item);
        }

        list_ItensSelecionados = new ArrayList<Objeto_Atendimento>();

        JPanel grid_Sanduiches = new JPanel(new GridLayout(0, 2, 10, 10));
        scrollItemsSanduiches = new JScrollPane(grid_Sanduiches);
        scrollItemsSanduiches.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        scrollItemsSanduiches.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
        scrollItemsSanduiches.setPreferredSize(new Dimension(400, 350));
        scrollItemsSanduiches.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollItemsSanduiches.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        for (int y = 0; y < List_Sanduiches.size(); y++) {

            btn_Sanduiches = new JButton(List_Sanduiches.get(y).sDescricao);
            List_Sanduiches.get(y).btn_item = btn_Sanduiches;
            List_Sanduiches.get(y).btn_item.setFont(new Font("book Antiqua", Font.BOLD, 14));
            List_Sanduiches.get(y).btn_item.setPreferredSize(new Dimension(btn_Sanduiches.getMaximumSize().width, 30));
            List_Sanduiches.get(y).btn_item.setBackground(Color.orange);
            List_Sanduiches.get(y).btn_item.setMargin(new Insets(0, 0, 0, 0));
            List_Sanduiches.get(y).btn_item.setBorder(null);
            grid_Sanduiches.add(List_Sanduiches.get(y).btn_item);
            List_Sanduiches.get(y).btn_item.addActionListener(this);
        }

        Painel_Itens.pPainelItensSanduiche.add(scrollItemsSanduiches);
        scrollItemsSanduiches.setBorder(null);
        Painel_Itens.pPainel_SecundarioSanduiche.add(Painel_Itens.pPainelItensSanduiche);
    }

    public void CarregarAdicionaisSanduiches() {

        for (Objeto_Item obj_item : Painel_Itens.listModel_Produtos){
            if(obj_item.sTipo.equals("Adicionais Sanduiches"))
                List_itensAdicionaisSanduiches.add(obj_item);
        }

        scrollItemsAdicionaisSanduiches = new JScrollPane(Painel_Itens.pPanel_ItensAdicionaisSanduiche);
        scrollItemsAdicionaisSanduiches.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        scrollItemsAdicionaisSanduiches.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
        scrollItemsAdicionaisSanduiches.setPreferredSize(new Dimension(400, 70));
        scrollItemsAdicionaisSanduiches.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollItemsAdicionaisSanduiches.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollItemsAdicionaisSanduiches.setBorder(null);

        for (int x = 0; x < List_itensAdicionaisSanduiches.size(); x++) {

            btn_ItensAdicionaisSanduiches = new JButton(List_itensAdicionaisSanduiches.get(x).sDescricao);
            List_itensAdicionaisSanduiches.get(x).btn_item = btn_ItensAdicionaisSanduiches;
            List_itensAdicionaisSanduiches.get(x).btn_item.setFont(new Font("book Antiqua", Font.BOLD, 12));
            List_itensAdicionaisSanduiches.get(x).btn_item.setPreferredSize(new Dimension(btn_ItensAdicionaisSanduiches.getMaximumSize().width, 20));
            List_itensAdicionaisSanduiches.get(x).btn_item.setBackground(new Color(255, 238, 180));
            List_itensAdicionaisSanduiches.get(x).btn_item.setMargin(new Insets(0, 0, 0, 0));
            List_itensAdicionaisSanduiches.get(x).btn_item.setBorder(null);
            Painel_Itens.pPanel_ItensAdicionaisSanduiche.add(List_itensAdicionaisSanduiches.get(x).btn_item);
            Painel_Itens.pPanel_ItensAdicionaisSanduiche.setPreferredSize(new Dimension(400, 60));

            List_itensAdicionaisSanduiches.get(x).btn_item.addActionListener(this);
        }
        Painel_Itens.pPainel_SecundarioSanduiche.add(scrollItemsAdicionaisSanduiches);
    }

    public void CarregarBebidas() {

        for (Objeto_Item obj_item : Painel_Itens.listModel_Produtos){
            if(obj_item.sTipo.equals("Bebidas"))
                list_Bebidas.add(obj_item);
        }

        list_ItensSelecionados = new ArrayList<Objeto_Atendimento>();

        JPanel grid_Bebidas = new JPanel(new GridLayout(0, 2, 10, 10));
        scrollBebidas = new JScrollPane(grid_Bebidas);
        scrollBebidas.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        scrollBebidas.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
        scrollBebidas.setPreferredSize(new Dimension(400, 500));
        scrollBebidas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBebidas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        for (int y = 0; y < list_Bebidas.size(); y++) {

            btn_bebidas = new JButton(list_Bebidas.get(y).sDescricao);
            list_Bebidas.get(y).btn_item = btn_bebidas;
            list_Bebidas.get(y).btn_item.setFont(new Font("book Antiqua", Font.BOLD, 14));
            list_Bebidas.get(y).btn_item.setPreferredSize(new Dimension(btn_bebidas.getMaximumSize().width, 40));
            list_Bebidas.get(y).btn_item.setBackground(Color.orange);
            list_Bebidas.get(y).btn_item.setMargin(new Insets(0, 0, 0, 0));
            list_Bebidas.get(y).btn_item.setBorder(null);
            grid_Bebidas.add(list_Bebidas.get(y).btn_item);
            list_Bebidas.get(y).btn_item.addMouseListener(this);
        }

        Painel_Itens.Panel_LadoEsquerdoBebidas.add(scrollBebidas);
        scrollBebidas.setBorder(null);
        Painel_Itens.pPainel_SecundarioBebidas.add(Painel_Itens.Panel_LadoEsquerdoBebidas);
    }

    public void CarregarCafesQuentes() {

        for (Objeto_Item obj_item : Painel_Itens.listModel_Produtos){
            if(obj_item.sTipo.equals("Cafes Quentes"))
            list_CafesQuentes.add(obj_item);
        }

        list_ItensSelecionados = new ArrayList<Objeto_Atendimento>();

        JPanel grid_CafesQuentes = new JPanel(new GridLayout(0, 2, 10, 10));
        ScrollCafesQuentes = new JScrollPane(grid_CafesQuentes);
        ScrollCafesQuentes.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        ScrollCafesQuentes.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
        ScrollCafesQuentes.setPreferredSize(new Dimension(400, 330));
        ScrollCafesQuentes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollCafesQuentes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        for (int y = 0; y < list_CafesQuentes.size(); y++) {

            btn_CafesQuentes = new JButton(list_CafesQuentes.get(y).sDescricao);
            list_CafesQuentes.get(y).btn_item = btn_CafesQuentes;
            list_CafesQuentes.get(y).btn_item.setFont(new Font("book Antiqua", Font.BOLD, 14));
            list_CafesQuentes.get(y).btn_item.setPreferredSize(new Dimension(btn_CafesQuentes.getMaximumSize().width, 30));
            list_CafesQuentes.get(y).btn_item.setBackground(Color.orange);
            list_CafesQuentes.get(y).btn_item.setMargin(new Insets(0, 0, 0, 0));
            list_CafesQuentes.get(y).btn_item.setBorder(null);
            grid_CafesQuentes.add(list_CafesQuentes.get(y).btn_item);
            list_CafesQuentes.get(y).btn_item.addMouseListener(this);
        }

        Painel_Itens.Panel_LadoEsquerdoCafes.add(ScrollCafesQuentes);
        ScrollCafesQuentes.setBorder(null);
        Painel_Itens.pPainel_SecundarioCafes.add(Painel_Itens.Panel_LadoEsquerdoCafes);
    }

    public void CarregarCafesGelados() {

        for (Objeto_Item obj_item : Painel_Itens.listModel_Produtos){
            if(obj_item.sTipo.equals("Cafes Gelados"))
            list_CafesGelados.add(obj_item);
        }

        JPanel grid_CafesGelados = new JPanel(new GridLayout(0, 2, 10, 10));
        scrollCafesGelados = new JScrollPane(grid_CafesGelados);
        scrollCafesGelados.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        scrollCafesGelados.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
        scrollCafesGelados.setPreferredSize(new Dimension(400, 200));
        scrollCafesGelados.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollCafesGelados.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollCafesGelados.setBorder(null);

        for (int x = 0; x < list_CafesGelados.size(); x++) {

            btn_CafesGelados = new JButton(list_CafesGelados.get(x).sDescricao);
            list_CafesGelados.get(x).btn_item = btn_CafesGelados;
            list_CafesGelados.get(x).btn_item.setFont(new Font("book Antiqua", Font.BOLD, 12));
            list_CafesGelados.get(x).btn_item.setPreferredSize(new Dimension(btn_CafesGelados.getMaximumSize().width, 30));
            list_CafesGelados.get(x).btn_item.setBackground(new Color(255, 238, 180));
            list_CafesGelados.get(x).btn_item.setMargin(new Insets(0, 0, 0, 0));
            list_CafesGelados.get(x).btn_item.setBorder(null);
            grid_CafesGelados.add(list_CafesGelados.get(x).btn_item);
            
            list_CafesGelados.get(x).btn_item.addMouseListener(this);
        }
        Painel_Itens.pPainel_SecundarioCafes.add(scrollCafesGelados);
    }

    public void CarregarObservacao(JPanel Panel_CurrentGuia) {

        Objeto_Item objItem = new Objeto_Item(0, 0, null, null, 0, null, null, false);

        botesConstrutor btnsMesas = new botesConstrutor();
        pPanel_BotaoEnviar = new JPanel();

        pPanel_BotaoEnviar.setMaximumSize(new Dimension(80, 25));
        pPanel_BotaoEnviar.setMinimumSize(new Dimension(80, 25));
        pPanel_BotaoEnviar.setPreferredSize(new Dimension(80, 30));
        pPanel_BotaoEnviar.setLayout(new CardLayout());

        objItem.btn_Enviar = btnsMesas.addItemButton;
        List_BotoesEnviar.add(objItem);
        objItem.btn_Enviar.addActionListener(this);
        pPanel_BotaoEnviar.add(objItem.btn_Enviar);
        Panel_CurrentGuia.add(pPanel_BotaoEnviar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //AO CLICAR NO ALMOÇO.
        for (int x = 0; x < list_PratosAlmocos.size(); x++) {

            //Qual prato clicou
            if (e.getSource() == list_PratosAlmocos.get(x).btn_item) {

                if (list_PratosAlmocos.get(x).isSelected == true)
                    list_PratosAlmocos.get(x).isSelected = false;
                else
                    list_PratosAlmocos.get(x).isSelected = true;

                //desabilita cada Ítem diferente do clicado  
                for (int d = 0; d < list_PratosAlmocos.size(); d++) {

                    if (d != x && list_PratosAlmocos.get(x).isSelected) {

                        Desabilitar_Habilitar_Botoes desabilitar = new Desabilitar_Habilitar_Botoes();
                        desabilitar.Desabilitar_BotoesAlmoco(list_PratosAlmocos.get(d));
                    }

                    //Habilita em caso de ter Desmarcado o prato
                    if (d != x && !list_PratosAlmocos.get(x).isSelected) {
                        Desabilitar_Habilitar_Botoes hab_desab = new Desabilitar_Habilitar_Botoes();
                        hab_desab.Habilitar_BotoesAlmoco(list_PratosAlmocos.get(d));
                    }

                    //Insere na lista de itens selecionados
                    if (d == x && list_PratosAlmocos.get(x).isSelected) {
                        Globals.nuseqItemAtual = Globals.nuseqItemAtual + 1;
                        Objeto_Atendimento objetoAtendimento = new Produtos_Disponiveis().Adicionar_Itens(list_PratosAlmocos, x, idPrato, "", "Almoco");
                        list_ItensSelecionados.add(objetoAtendimento);
                        list_PratosAlmocos.get(x).indice_atendimentoItem = list_ItensSelecionados.size();
                    }

                    //Retira da Lista de itens selecionados, quando desmarcar
                    if (d == x && !list_PratosAlmocos.get(x).isSelected) {

                        int index = list_PratosAlmocos.get(x).indice_atendimentoItem - 1;
                        list_ItensSelecionados.remove(list_ItensSelecionados.get(index));
                        //new Remover_ItemAtendimento(Painel_Comanda.list_ItensDoAtendimento.get(index));

                    }

                }

            }
        }

        //AO CLICAR NOS ÍTENS ADICIONAIS DO ALMOÇO
        for (int x = 0; x < List_itensAdicionais.size(); x++) {

            if ( e.getSource() == List_itensAdicionais.get(x).btn_item) {

                if (List_itensAdicionais.get(x).isSelected == true)
                    List_itensAdicionais.get(x).isSelected = false;
                else
                    List_itensAdicionais.get(x).isSelected = true;

                if (List_itensAdicionais.get(x).isSelected) {
                    Globals.nuseqItemAtual = Globals.nuseqItemAtual + 1;
                    Objeto_Atendimento objetoAtendimento = new Produtos_Disponiveis().Adicionar_Itens(List_itensAdicionais, x, idPrato, "", "Itens Adicionais");
                    list_ItensSelecionados.add(objetoAtendimento);
                    List_itensAdicionais.get(x).indice_atendimentoItem = list_ItensSelecionados.size();
                    List_itensAdicionais.get(x).btn_item.setBackground(Color.orange);

                }

                else {
                    int index = List_itensAdicionais.get(x).indice_atendimentoItem - 1;
                    list_ItensSelecionados.remove(list_ItensSelecionados.get(index));
                    List_itensAdicionais.get(x).btn_item.setBackground(new Color(255, 238, 180));
                }

            }
        }

        //AO CLICAR NO SANDUICHE.
        for (int x = 0; x < List_Sanduiches.size(); x++) {

            //Qual prato clicou
            if (e.getSource() == List_Sanduiches.get(x).btn_item) {

                if (List_Sanduiches.get(x).isSelected == true)
                List_Sanduiches.get(x).isSelected = false;
                else
                List_Sanduiches.get(x).isSelected = true;

                //desabilita cada Ítem diferente do clicado  
                for (int d = 0; d < List_Sanduiches.size(); d++) {

                    if (d != x && List_Sanduiches.get(x).isSelected) {

                        Desabilitar_Habilitar_Botoes desabilitar = new Desabilitar_Habilitar_Botoes();
                        desabilitar.Desabilitar_BotoesAlmoco(List_Sanduiches.get(d));
                    }

                    //Habilita em caso de ter Desmarcado o prato
                    if (d != x && !List_Sanduiches.get(x).isSelected) {
                        Desabilitar_Habilitar_Botoes hab_desab = new Desabilitar_Habilitar_Botoes();
                        hab_desab.Habilitar_BotoesAlmoco(List_Sanduiches.get(d));
                    }

                    //Insere na lista de itens selecionados
                    if (d == x && List_Sanduiches.get(x).isSelected) {
                        Globals.nuseqItemAtual = Globals.nuseqItemAtual + 1;
                        Objeto_Atendimento objetoAtendimento = new Produtos_Disponiveis().Adicionar_Itens(List_Sanduiches, x, idPrato, "", "Sanduiches");
                        list_ItensSelecionados.add(objetoAtendimento);
                        List_Sanduiches.get(x).indice_atendimentoItem = list_ItensSelecionados.size();
                    }

                    //Retira da Lista de itens selecionados, quando desmarcar
                    if (d == x && !List_Sanduiches.get(x).isSelected) {

                        int index = List_Sanduiches.get(x).indice_atendimentoItem - 1;
                        list_ItensSelecionados.remove(list_ItensSelecionados.get(index));
                        //new Remover_ItemAtendimento(Painel_Comanda.list_ItensDoAtendimento.get(index));

                    }

                }

            }
        }

        //AO CLICAR NOS ÍTENS ADICIONAIS DO SANDUÍCHE
        for (int x = 0; x < List_itensAdicionaisSanduiches.size(); x++) {

            if ( e.getSource() == List_itensAdicionaisSanduiches.get(x).btn_item) {

                if (List_itensAdicionaisSanduiches.get(x).isSelected == true)
                List_itensAdicionaisSanduiches.get(x).isSelected = false;
                else
                List_itensAdicionaisSanduiches.get(x).isSelected = true;

                if (List_itensAdicionaisSanduiches.get(x).isSelected) {
                    Globals.nuseqItemAtual = Globals.nuseqItemAtual + 1;
                    Objeto_Atendimento objetoAtendimento = new Produtos_Disponiveis().Adicionar_Itens(List_itensAdicionaisSanduiches, x, idPrato, "", "Adicionais Sanduiches");
                    list_ItensSelecionados.add(objetoAtendimento);
                    List_itensAdicionaisSanduiches.get(x).indice_atendimentoItem = list_ItensSelecionados.size();
                    List_itensAdicionaisSanduiches.get(x).btn_item.setBackground(Color.orange);

                }

                else {
                    int index = List_itensAdicionaisSanduiches.get(x).indice_atendimentoItem - 1;
                    list_ItensSelecionados.remove(list_ItensSelecionados.get(index));
                    List_itensAdicionaisSanduiches.get(x).btn_item.setBackground(new Color(255, 238, 180));
                }

            }
        }
        
        //Ao clicar no Enviar (Enviar itens para a Comanda)
        for (int x = 0; x < List_BotoesEnviar.size(); x++) {
            if (e.getSource() == List_BotoesEnviar.get(x).btn_Enviar) {

                String observacao = "";
                
                if (!Painel_Itens.tTextField_Observacoes.getText().isEmpty()){
                     observacao = Painel_Itens.tTextField_Observacoes.getText();
                }

                inserirNaComanda(observacao, "Almoco");

            }
        }

    }

    //Limpar as listas e liberar os botões para adicionar novos pratos
    public void LiberarItemsParaNovoPrato() {
        
        Desabilitar_Habilitar_Botoes hab_desab = new Desabilitar_Habilitar_Botoes();

        for (Objeto_Item itemAdicional : List_itensAdicionais){
            itemAdicional.btn_item.setBackground(new Color(255, 238, 180));
            itemAdicional.isSelected = false;
        }

        for (Objeto_Item itemAlmoco : list_PratosAlmocos){
            hab_desab.Habilitar_BotoesAlmoco(itemAlmoco);
            itemAlmoco.isSelected = false;
        }

        list_ItensSelecionados.clear();
        idPrato = RandomStringUtils.randomAlphanumeric(8);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //AO CLICAR Nas Bebidas
        for (int x = 0; x < list_Bebidas.size(); x++) {

            if (e.getClickCount()==2 &&  e.getSource() == list_Bebidas.get(x).btn_item) {
                Globals.nuseqItemAtual = Globals.nuseqItemAtual + 1;
                Objeto_Atendimento objetoAtendimento = new Produtos_Disponiveis().Adicionar_Itens(list_Bebidas, x, idPrato, "", "Bebidas");
                list_ItensSelecionados.add(objetoAtendimento);

                    inserirNaComanda("", "Bebidas");

            }
        }

        for (int x = 0; x < list_CafesQuentes.size(); x++) {

            if (e.getClickCount()==2 &&  e.getSource() == list_CafesQuentes.get(x).btn_item) {
                Globals.nuseqItemAtual = Globals.nuseqItemAtual + 1;
                Objeto_Atendimento objetoAtendimento = new Produtos_Disponiveis().Adicionar_Itens(list_CafesQuentes, x, idPrato, "", "Cafes Quentes");
                list_ItensSelecionados.add(objetoAtendimento);

                    inserirNaComanda("", "Cafes Quentes");

            }
        }

        for (int x = 0; x < list_CafesGelados.size(); x++) {

            if (e.getClickCount()==2 &&  e.getSource() == list_CafesGelados.get(x).btn_item) {
                Globals.nuseqItemAtual = Globals.nuseqItemAtual + 1;
                Objeto_Atendimento objetoAtendimento = new Produtos_Disponiveis().Adicionar_Itens(list_CafesGelados, x, idPrato, "", "Cafes Gelados");
                list_ItensSelecionados.add(objetoAtendimento);

                    inserirNaComanda("", "Cafes Gelados");

            }
        }



        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    public void inserirNaComanda(String obs, String tipoProduto){


        if (tipoProduto.equals("Almoco") || tipoProduto.equals("Sanduiches")){            
            List<Objeto_Item> objetoItem_Observacao = new ArrayList<Objeto_Item>();
            Globals.nuseqItemAtual = Globals.nuseqItemAtual + 1;
            Objeto_Atendimento objetoAtendimento = new Produtos_Disponiveis().Adicionar_Itens(objetoItem_Observacao, 0, idPrato,obs, "Observacao");
            list_ItensSelecionados.add(objetoAtendimento);      
        }

        for (Objeto_Atendimento itemSelecionado : list_ItensSelecionados) {
            Painel_Comanda.list_ItensDoAtendimento.add(itemSelecionado);
        }

        new Adicionar_ItemAtendimento(list_ItensSelecionados);

        switch (tipoProduto) {
            case "Almoco":
                LiberarItemsParaNovoPrato();
                break;
            case "Sanduiches":
                LiberarItemsParaNovoPrato();
                break;
            default:
                list_ItensSelecionados.clear();
                idPrato = RandomStringUtils.randomAlphanumeric(8);
        }

         new Atualizar_Valor_Comanda();

    }

}
