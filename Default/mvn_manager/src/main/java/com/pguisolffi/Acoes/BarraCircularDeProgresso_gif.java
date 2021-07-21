package com.pguisolffi.Acoes;

import java.awt.Color;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.pguisolffi.Objetos.Objeto_Atendimento;

public class BarraCircularDeProgresso_gif {

    public static JFrame janela_loading;
    public static boolean BarraVisivel = false;

    public BarraCircularDeProgresso_gif(){

        janela_loading = new JFrame("Loader!");
        ImageIcon loading = new ImageIcon("C:/Projetos/Donna/DonnaFloripa/Default/mvn_manager/src/main/java/com/pguisolffi/images/ajax-loader_5.gif");
        janela_loading.add(new JLabel("Carregando... ", loading, JLabel.CENTER));
        //frame.add(new JLabel("", loading, JLabel.CENTER));
                
        janela_loading.setUndecorated(true); //retira a barra de título do JFrame
        janela_loading.setLocationRelativeTo(null);//faz o frame ser exibido no meio da tela
        
        // Deixa o fundo o JFrame transparente
        janela_loading.setUndecorated(true);
        janela_loading.getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        janela_loading.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        // Configurações do JFrame
        janela_loading.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela_loading.setSize(300, 100);
        BarraVisivel = true;
        janela_loading.setVisible(true);
        

        
        // USAR PARA FECHAR A JANELA DO LOADING DEPOIS
        // janela_loading.setVisible(false);
    }
  
  


    
}
