package com.pguisolffi.Paineis;

import javax.swing.JOptionPane;

public class Impressora {

	public Impressora() 
	{
		
		int iRetorno;
        bemajava.BemaInteger ACK, ST1, ST2, ST3;
        ACK = new bemajava.BemaInteger();
        ST1 = new bemajava.BemaInteger();
        ST2 = new bemajava.BemaInteger();
        ST3 = new bemajava.BemaInteger();        
        
        // Habilitando o retorno estendido da impressora MFD
        iRetorno = bemajava.Bematech.HabilitaDesabilitaRetornoEstendidoMFD( "1" );
        
        // Emitindo uma Leitura X
        iRetorno = bemajava.Bematech.LeituraX();
      
        // Pegando o retorno da impressora MFD
        iRetorno = bemajava.Bematech.RetornoImpressoraMFD( ACK, ST1, ST2, ST3 );
        
        String 
        retorno  = "ACK: "   + ACK.number;
        retorno += "\nST1: " + ST1.number;
        retorno += "\nST2: " + ST2.number;
        retorno += "\nST3: " + ST3.number;
        System.out.println( "Retorno Impressora MFD: \n" + retorno );    


        if (iRetorno == 0) 
        {
	        JOptionPane.showMessageDialog(null, "Erro= Nº" + iRetorno + " - Erro de Comunicação"); 	        
	     }
        if (iRetorno == 1) 
        {
	        JOptionPane.showMessageDialog(null, "Erro= Nº" + iRetorno + " - OK"); 	        
	     }
        if (iRetorno == -4)
        {
	        JOptionPane.showMessageDialog(null, "Erro= Nº" + iRetorno + " - O arquivo de inicialização BemaFI32.ini não foi encontrado no diretório de sistema do Windows."); 	        
	     }
        if (iRetorno == -5) 
        {
	        JOptionPane.showMessageDialog(null, "Erro= Nº" + iRetorno + " - Erro ao abrir a porta de comunicação.");
	        
	     }
        if (iRetorno == -8) 
        {
	        JOptionPane.showMessageDialog(null, "Erro= Nº" + iRetorno + " - Erro ao criar ou gravar no arquivo STATUS.TXT ou RETORNO.TXT.");
	        
	     }
        if (iRetorno == -27) 
        {
	        JOptionPane.showMessageDialog(null, "Erro= Nº" + iRetorno + " - Status da impressora diferente de 6,0,0 (ACK, ST1 e ST2).");
	        
	     }else
	     {
	        JOptionPane.showMessageDialog(null, "Erro= Nº" + iRetorno + " - Erro não tratado!");
	     }
	}
	

}