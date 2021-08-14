package com.pguisolffi.Acoes;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import com.pguisolffi.Telas.Aba_Relatorios;
import com.pguisolffi.Telas.Tela_Principal;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class abasMenu implements MouseListener{

    JMenu PainelMenu,RelatoriosMenu,ConfiguracoesMenu;

    public JPanel panel_relatorio;

    public abasMenu(){

        JMenuBar menuBar = new JMenuBar();
        PainelMenu = new JMenu("Painel");
        RelatoriosMenu = new JMenu("Relatórios");
        ConfiguracoesMenu = new JMenu("Configurações");
        menuBar.add(PainelMenu);
        menuBar.add(RelatoriosMenu);
        menuBar.add(ConfiguracoesMenu);

        Tela_Principal.Frame_TelaPrincipal.setJMenuBar(menuBar);

        PainelMenu.addMouseListener(this);
        RelatoriosMenu.addMouseListener(this);
        ConfiguracoesMenu.addMouseListener(this);
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == PainelMenu){
            panel_relatorio.setVisible(false);
            Tela_Principal.Painel_DeMesas.setVisible(true);
        }

        if (e.getSource() == RelatoriosMenu){

            Aba_Relatorios aba_relatorio = new Aba_Relatorios();
            panel_relatorio = aba_relatorio.Relatorios();

            Tela_Principal.Frame_TelaPrincipal.getContentPane().add(panel_relatorio);
            Tela_Principal.Painel_DeMesas.setVisible(false);
            panel_relatorio.setVisible(true);
        }

        if (e.getSource() == ConfiguracoesMenu){
            System.out.println("Clicou nas Configurações");
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


    
    
}
