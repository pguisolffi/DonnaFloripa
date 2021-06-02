import java.awt.GridBagLayout;
import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PainelPrincipal extends JPanel {
    JFrame f;
    JMenu menu, submenu, painel;

    JMenuBar mb;

    JPanel pCorStatus, pPreparando, pConsumindo, pDemorando, pDelivery, pMesa1, pMesa2, pMesa3, pMesa4, pMesa5, pMesa6,
            pMesa7, pMesa8, pMesa9, pMesa10, pMesa11, pMesa12, pCorStatus1, pCorStatus2, pCorStatus3, pCorStatus4,
            pCorStatus5, pCorStatus6, pCorStatus7, pCorStatus8, pCorStatus9, pCorStatus10, pCorStatus11, pCorStatus12,
            pAtendIniciado1, pAtendIniciado2, pAtendIniciado3, pAtendIniciado4, pAtendIniciado5, pAtendIniciado6,
            pAtendIniciado7, pAtendIniciado8, pAtendIniciado9, pAtendIniciado10, pAtendIniciado11, pAtendIniciado12;

    JLabel lLegendas, lMesaLivre, lPreparando, lConsumindo, lDemorando, lDelivery, lMesa1, lMesa2, lMesa3, lMesa4,
            lMesa5, lMesa6, lMesa7, lMesa8, lMesa9, lMesa10, lMesa11, lMesa12, lDuracao1, lDuracao2, lDuracao3,
            lDuracao4, lDuracao5, lDuracao6, lDuracao7, lDuracao8, lDuracao9, lDuracao10, lDuracao11, lDuracao12, lLogo,
            lEntrada;

    String status = "Consumindo";

    public PainelPrincipal() {

        ImageIcon imgdf = new ImageIcon("C:/Projetos/Donna/DonnaFloripa/images/DonnaFloripa.png");
        Image imgedf = imgdf.getImage().getScaledInstance(450, 250, Image.SCALE_DEFAULT);
        ImageIcon imgDonnaFloripa = new ImageIcon(imgedf);

        // LEGENDAS
        lLegendas = new JLabel("Legendas:");
        lLegendas.setFont(new Font("Verdana", 1, 15));
        lLegendas.setBounds(50, 780, 100, 100);
        lMesaLivre = new JLabel("Mesa Livre");
        lMesaLivre.setFont(new Font("Verdana", 1, 15));
        pCorStatus = new JPanel();
        pCorStatus.setBackground(Color.GREEN);
        pCorStatus.setBounds(50, 850, 30, 30);
        lMesaLivre.setBounds(100, 820, 100, 100);
        lPreparando = new JLabel("Preparando");
        lPreparando.setFont(new Font("Verdana", 1, 15));
        pPreparando = new JPanel();
        pPreparando.setBackground(Color.darkGray);
        pPreparando.setBounds(250, 850, 30, 30);
        lPreparando.setBounds(300, 820, 100, 100);
        lConsumindo = new JLabel("Consumindo");
        lConsumindo.setFont(new Font("Verdana", 1, 15));
        pConsumindo = new JPanel();
        pConsumindo.setBackground(Color.blue);
        pConsumindo.setBounds(450, 850, 30, 30);
        lConsumindo.setBounds(500, 820, 100, 100);
        lDemorando = new JLabel("Demorando");
        lDemorando.setFont(new Font("Verdana", 1, 15));
        pDemorando = new JPanel();
        pDemorando.setBackground(Color.RED);
        pDemorando.setBounds(650, 850, 30, 30);
        lDemorando.setBounds(700, 820, 100, 100);

        // DELIVERY
        lDelivery = new JLabel("Delivery");
        lDelivery.setFont(new Font("Verdana", 1, 20));
        lDelivery.setHorizontalAlignment(JLabel.CENTER);
        lDelivery.setVerticalAlignment(JLabel.NORTH);
        pDelivery = new JPanel(new GridBagLayout());
        pDelivery.setLayout(new BorderLayout());
        pDelivery.setBounds(1150, 50, 350, 630);
        pDelivery.setBackground(Color.white);
        pDelivery.setBorder(BorderFactory.createLineBorder(Color.black));
        pDelivery.add(lDelivery);

        // LOGO
        lLogo = new JLabel();
        lLogo.setIcon(imgDonnaFloripa);
        lLogo.setBounds(1050, 700, 500, 300);

        BotoesPainelPrincipal btnPainelPrinc = new BotoesPainelPrincipal();

        // MESA 1
        pCorStatus1 = new JPanel();
        pCorStatus1.setBackground(Color.green);
        pAtendIniciado1 = new JPanel(new GridBagLayout());
        pAtendIniciado1.setLayout(new BorderLayout());
        pAtendIniciado1.setBackground(Color.white);
        lDuracao1 = new JLabel("Duração: 00:11");
        lEntrada = new JLabel("Entrada: 12:27");
        lDuracao1.setFont(new Font("Calibri", Font.BOLD, 30));
        lDuracao1.setHorizontalAlignment(JLabel.CENTER);
        lDuracao1.setVerticalAlignment(JLabel.CENTER);
        lMesa1 = new JLabel("Mesa 1");
        lMesa1.setFont(new Font("Verdana", 1, 20));
        lMesa1.setHorizontalAlignment(JLabel.CENTER);
        lMesa1.setVerticalAlignment(JLabel.NORTH);
        pMesa1 = new JPanel(new GridBagLayout());
        pMesa1.setLayout(new BorderLayout());
        pMesa1.setBackground(Color.white);
        pMesa1.setBorder(BorderFactory.createLineBorder(Color.black));
        pMesa1.add(pCorStatus1, BorderLayout.PAGE_START);
        pAtendIniciado1.add(lMesa1, BorderLayout.PAGE_START);
        // pAtendIniciado1.add(ConfirmButton1, BorderLayout.LINE_START);
        pAtendIniciado1.add(btnPainelPrinc.PlayButton1, BorderLayout.CENTER);
        // pAtendIniciado1.add(lEntrada, BorderLayout.LINE_END);
        pMesa1.add(pAtendIniciado1, BorderLayout.CENTER);
        // pMesa1.add(lDuracao1, BorderLayout.PAGE_END);
        pMesa1.setBounds(40, 50, 300, 150);

        // MESA 2
        pCorStatus2 = new JPanel();
        pCorStatus2.setBackground(Color.green);
        pAtendIniciado2 = new JPanel(new GridBagLayout());
        pAtendIniciado2.setLayout(new BorderLayout());
        pAtendIniciado2.setBackground(Color.white);
        lDuracao2 = new JLabel("Duração: 00:11");
        lEntrada = new JLabel("Entrada: 12:27");
        lDuracao2.setFont(new Font("Calibri", Font.BOLD, 30));
        lDuracao2.setHorizontalAlignment(JLabel.CENTER);
        lDuracao2.setVerticalAlignment(JLabel.CENTER);
        lMesa2 = new JLabel("Mesa 2");
        lMesa2.setFont(new Font("Verdana", 1, 20));
        lMesa2.setHorizontalAlignment(JLabel.CENTER);
        lMesa2.setVerticalAlignment(JLabel.NORTH);
        pMesa2 = new JPanel(new GridBagLayout());
        pMesa2.setLayout(new BorderLayout());
        pMesa2.setBackground(Color.white);
        pMesa2.setBorder(BorderFactory.createLineBorder(Color.black));
        pMesa2.add(pCorStatus2, BorderLayout.PAGE_START);
        pAtendIniciado2.add(lMesa2, BorderLayout.PAGE_START);
        // pAtendIniciado2.add(ConfirmButton2, BorderLayout.LINE_START);
        pAtendIniciado2.add(btnPainelPrinc.PlayButton2, BorderLayout.CENTER);
        // pAtendIniciado2.add(lEntrada, BorderLayout.LINE_END);
        pMesa2.add(pAtendIniciado2, BorderLayout.CENTER);
        // pMesa2.add(lDuracao2, BorderLayout.PAGE_END);
        pMesa2.setBounds(400, 50, 300, 150);

        // MESA 3
        pCorStatus3 = new JPanel();
        pCorStatus3.setBackground(Color.green);
        pAtendIniciado3 = new JPanel(new GridBagLayout());
        pAtendIniciado3.setLayout(new BorderLayout());
        pAtendIniciado3.setBackground(Color.white);
        lDuracao3 = new JLabel("Duração: 00:11");
        lEntrada = new JLabel("Entrada: 12:27");
        lDuracao3.setFont(new Font("Calibri", Font.BOLD, 30));
        lDuracao3.setHorizontalAlignment(JLabel.CENTER);
        lDuracao3.setVerticalAlignment(JLabel.CENTER);
        lMesa3 = new JLabel("Mesa 3");
        lMesa3.setFont(new Font("Verdana", 1, 20));
        lMesa3.setHorizontalAlignment(JLabel.CENTER);
        lMesa3.setVerticalAlignment(JLabel.NORTH);
        pMesa3 = new JPanel(new GridBagLayout());
        pMesa3.setLayout(new BorderLayout());
        pMesa3.setBackground(Color.white);
        pMesa3.setBorder(BorderFactory.createLineBorder(Color.black));
        pMesa3.add(pCorStatus3, BorderLayout.PAGE_START);
        pAtendIniciado3.add(lMesa3, BorderLayout.PAGE_START);
        // pAtendIniciado3.add(ConfirmButton3, BorderLayout.LINE_START);
        pAtendIniciado3.add(btnPainelPrinc.PlayButton3, BorderLayout.CENTER);
        // pAtendIniciado3.add(lEntrada, BorderLayout.LINE_END);
        pMesa3.add(pAtendIniciado3, BorderLayout.CENTER);
        // pMesa3.add(lDuracao3, BorderLayout.PAGE_END);
        pMesa3.setBounds(760, 50, 300, 150);

        // MESA 4
        pCorStatus4 = new JPanel();
        pCorStatus4.setBackground(Color.green);
        pAtendIniciado4 = new JPanel(new GridBagLayout());
        pAtendIniciado4.setLayout(new BorderLayout());
        pAtendIniciado4.setBackground(Color.white);
        lDuracao4 = new JLabel("Duração: 00:11");
        lEntrada = new JLabel("Entrada: 12:27");
        lDuracao4.setFont(new Font("Calibri", Font.BOLD, 30));
        lDuracao4.setHorizontalAlignment(JLabel.CENTER);
        lDuracao4.setVerticalAlignment(JLabel.CENTER);
        lMesa4 = new JLabel("Mesa 4");
        lMesa4.setFont(new Font("Verdana", 1, 20));
        lMesa4.setHorizontalAlignment(JLabel.CENTER);
        lMesa4.setVerticalAlignment(JLabel.NORTH);
        pMesa4 = new JPanel(new GridBagLayout());
        pMesa4.setLayout(new BorderLayout());
        pMesa4.setBackground(Color.white);
        pMesa4.setBorder(BorderFactory.createLineBorder(Color.black));
        pMesa4.add(pCorStatus4, BorderLayout.PAGE_START);
        pAtendIniciado4.add(lMesa4, BorderLayout.PAGE_START);
        // pAtendIniciado4.add(ConfirmButton4, BorderLayout.LINE_START);
        pAtendIniciado4.add(btnPainelPrinc.PlayButton4, BorderLayout.CENTER);
        // pAtendIniciado4.add(lEntrada, BorderLayout.LINE_END);
        pMesa4.add(pAtendIniciado4, BorderLayout.CENTER);
        // pMesa4.add(lDuracao4, BorderLayout.PAGE_END);
        pMesa4.setBounds(40, 210, 300, 150);

        // MESA 5
        pCorStatus5 = new JPanel();
        pCorStatus5.setBackground(Color.green);
        pAtendIniciado5 = new JPanel(new GridBagLayout());
        pAtendIniciado5.setLayout(new BorderLayout());
        pAtendIniciado5.setBackground(Color.white);
        lDuracao5 = new JLabel("Duração: 00:11");
        lEntrada = new JLabel("Entrada: 12:27");
        lDuracao5.setFont(new Font("Calibri", Font.BOLD, 30));
        lDuracao5.setHorizontalAlignment(JLabel.CENTER);
        lDuracao5.setVerticalAlignment(JLabel.CENTER);
        lMesa5 = new JLabel("Mesa 5");
        lMesa5.setFont(new Font("Verdana", 1, 20));
        lMesa5.setHorizontalAlignment(JLabel.CENTER);
        lMesa5.setVerticalAlignment(JLabel.NORTH);
        pMesa5 = new JPanel(new GridBagLayout());
        pMesa5.setLayout(new BorderLayout());
        pMesa5.setBackground(Color.white);
        pMesa5.setBorder(BorderFactory.createLineBorder(Color.black));
        pMesa5.add(pCorStatus5, BorderLayout.PAGE_START);
        pAtendIniciado5.add(lMesa5, BorderLayout.PAGE_START);
        // pAtendIniciado5.add(ConfirmButton5, BorderLayout.LINE_START);
        pAtendIniciado5.add(btnPainelPrinc.PlayButton5, BorderLayout.CENTER);
        // pAtendIniciado5.add(lEntrada, BorderLayout.LINE_END);
        pMesa5.add(pAtendIniciado5, BorderLayout.CENTER);
        // pMesa5.add(lDuracao5, BorderLayout.PAGE_END);
        pMesa5.setBounds(400, 210, 300, 150);

        // MESA 6
        pCorStatus6 = new JPanel();
        pCorStatus6.setBackground(Color.green);
        pAtendIniciado6 = new JPanel(new GridBagLayout());
        pAtendIniciado6.setLayout(new BorderLayout());
        pAtendIniciado6.setBackground(Color.white);
        lDuracao6 = new JLabel("Duração: 00:11");
        lEntrada = new JLabel("Entrada: 12:27");
        lDuracao6.setFont(new Font("Calibri", Font.BOLD, 30));
        lDuracao6.setHorizontalAlignment(JLabel.CENTER);
        lDuracao6.setVerticalAlignment(JLabel.CENTER);
        lMesa6 = new JLabel("Mesa 6");
        lMesa6.setFont(new Font("Verdana", 1, 20));
        lMesa6.setHorizontalAlignment(JLabel.CENTER);
        lMesa6.setVerticalAlignment(JLabel.NORTH);
        pMesa6 = new JPanel(new GridBagLayout());
        pMesa6.setLayout(new BorderLayout());
        pMesa6.setBackground(Color.white);
        pMesa6.setBorder(BorderFactory.createLineBorder(Color.black));
        pMesa6.add(pCorStatus6, BorderLayout.PAGE_START);
        pAtendIniciado6.add(lMesa6, BorderLayout.PAGE_START);
        // pAtendIniciado6.add(ConfirmButton6, BorderLayout.LINE_START);
        pAtendIniciado6.add(btnPainelPrinc.PlayButton6, BorderLayout.CENTER);
        // pAtendIniciado6.add(lEntrada, BorderLayout.LINE_END);
        pMesa6.add(pAtendIniciado6, BorderLayout.CENTER);
        // pMesa6.add(lDuracao6, BorderLayout.PAGE_END);
        pMesa6.setBounds(760, 210, 300, 150);

        // MESA 7
        pCorStatus7 = new JPanel();
        pCorStatus7.setBackground(Color.green);
        pAtendIniciado7 = new JPanel(new GridBagLayout());
        pAtendIniciado7.setLayout(new BorderLayout());
        pAtendIniciado7.setBackground(Color.white);
        lDuracao7 = new JLabel("Duração: 00:11");
        lEntrada = new JLabel("Entrada: 12:27");
        lDuracao7.setFont(new Font("Calibri", Font.BOLD, 30));
        lDuracao7.setHorizontalAlignment(JLabel.CENTER);
        lDuracao7.setVerticalAlignment(JLabel.CENTER);
        lMesa7 = new JLabel("Mesa 7");
        lMesa7.setFont(new Font("Verdana", 1, 20));
        lMesa7.setHorizontalAlignment(JLabel.CENTER);
        lMesa7.setVerticalAlignment(JLabel.NORTH);
        pMesa7 = new JPanel(new GridBagLayout());
        pMesa7.setLayout(new BorderLayout());
        pMesa7.setBackground(Color.white);
        pMesa7.setBorder(BorderFactory.createLineBorder(Color.black));
        pMesa7.add(pCorStatus7, BorderLayout.PAGE_START);
        pAtendIniciado7.add(lMesa7, BorderLayout.PAGE_START);
        // pAtendIniciado7.add(ConfirmButton7, BorderLayout.LINE_START);
        pAtendIniciado7.add(btnPainelPrinc.PlayButton7, BorderLayout.CENTER);
        // pAtendIniciado7.add(lEntrada, BorderLayout.LINE_END);
        pMesa7.add(pAtendIniciado7, BorderLayout.CENTER);
        // pMesa7.add(lDuracao7, BorderLayout.PAGE_END);
        pMesa7.setBounds(40, 370, 300, 150);

        // MESA 8
        pCorStatus8 = new JPanel();
        pCorStatus8.setBackground(Color.green);
        pAtendIniciado8 = new JPanel(new GridBagLayout());
        pAtendIniciado8.setLayout(new BorderLayout());
        pAtendIniciado8.setBackground(Color.white);
        lDuracao8 = new JLabel("Duração: 00:11");
        lEntrada = new JLabel("Entrada: 12:27");
        lDuracao8.setFont(new Font("Calibri", Font.BOLD, 30));
        lDuracao8.setHorizontalAlignment(JLabel.CENTER);
        lDuracao8.setVerticalAlignment(JLabel.CENTER);
        lMesa8 = new JLabel("Mesa 8");
        lMesa8.setFont(new Font("Verdana", 1, 20));
        lMesa8.setHorizontalAlignment(JLabel.CENTER);
        lMesa8.setVerticalAlignment(JLabel.NORTH);
        pMesa8 = new JPanel(new GridBagLayout());
        pMesa8.setLayout(new BorderLayout());
        pMesa8.setBackground(Color.white);
        pMesa8.setBorder(BorderFactory.createLineBorder(Color.black));
        pMesa8.add(pCorStatus8, BorderLayout.PAGE_START);
        pAtendIniciado8.add(lMesa8, BorderLayout.PAGE_START);
        // pAtendIniciado8.add(ConfirmButton8, BorderLayout.LINE_START);
        pAtendIniciado8.add(btnPainelPrinc.PlayButton8, BorderLayout.CENTER);
        // pAtendIniciado8.add(lEntrada, BorderLayout.LINE_END);
        pMesa8.add(pAtendIniciado8, BorderLayout.CENTER);
        // pMesa8.add(lDuracao8, BorderLayout.PAGE_END);
        pMesa8.setBounds(400, 370, 300, 150);

        // MESA 9
        pCorStatus9 = new JPanel();
        pCorStatus9.setBackground(Color.green);
        pAtendIniciado9 = new JPanel(new GridBagLayout());
        pAtendIniciado9.setLayout(new BorderLayout());
        pAtendIniciado9.setBackground(Color.white);
        lDuracao9 = new JLabel("Duração: 00:11");
        lEntrada = new JLabel("Entrada: 12:27");
        lDuracao9.setFont(new Font("Calibri", Font.BOLD, 30));
        lDuracao9.setHorizontalAlignment(JLabel.CENTER);
        lDuracao9.setVerticalAlignment(JLabel.CENTER);
        lMesa9 = new JLabel("Mesa 9");
        lMesa9.setFont(new Font("Verdana", 1, 20));
        lMesa9.setHorizontalAlignment(JLabel.CENTER);
        lMesa9.setVerticalAlignment(JLabel.NORTH);
        pMesa9 = new JPanel(new GridBagLayout());
        pMesa9.setLayout(new BorderLayout());
        pMesa9.setBackground(Color.white);
        pMesa9.setBorder(BorderFactory.createLineBorder(Color.black));
        pMesa9.add(pCorStatus9, BorderLayout.PAGE_START);
        pAtendIniciado9.add(lMesa9, BorderLayout.PAGE_START);
        // pAtendIniciado9.add(ConfirmButton9, BorderLayout.LINE_START);
        pAtendIniciado9.add(btnPainelPrinc.PlayButton9, BorderLayout.CENTER);
        // pAtendIniciado9.add(lEntrada, BorderLayout.LINE_END);
        pMesa9.add(pAtendIniciado9, BorderLayout.CENTER);
        // pMesa9.add(lDuracao9, BorderLayout.PAGE_END);
        pMesa9.setBounds(760, 370, 300, 150);

        // MESA 8
        pCorStatus10 = new JPanel();
        pCorStatus10.setBackground(Color.green);
        pAtendIniciado10 = new JPanel(new GridBagLayout());
        pAtendIniciado10.setLayout(new BorderLayout());
        pAtendIniciado10.setBackground(Color.white);
        lDuracao10 = new JLabel("Duração: 00:11");
        lEntrada = new JLabel("Entrada: 12:27");
        lDuracao10.setFont(new Font("Calibri", Font.BOLD, 30));
        lDuracao10.setHorizontalAlignment(JLabel.CENTER);
        lDuracao10.setVerticalAlignment(JLabel.CENTER);
        lMesa10 = new JLabel("Mesa 10");
        lMesa10.setFont(new Font("Verdana", 1, 20));
        lMesa10.setHorizontalAlignment(JLabel.CENTER);
        lMesa10.setVerticalAlignment(JLabel.NORTH);
        pMesa10 = new JPanel(new GridBagLayout());
        pMesa10.setLayout(new BorderLayout());
        pMesa10.setBackground(Color.white);
        pMesa10.setBorder(BorderFactory.createLineBorder(Color.black));
        pMesa10.add(pCorStatus10, BorderLayout.PAGE_START);
        pAtendIniciado10.add(lMesa10, BorderLayout.PAGE_START);
        // pAtendIniciado10.add(ConfirmButton10, BorderLayout.LINE_START);
        pAtendIniciado10.add(btnPainelPrinc.PlayButton10, BorderLayout.CENTER);
        // pAtendIniciado10.add(lEntrada, BorderLayout.LINE_END);
        pMesa10.add(pAtendIniciado10, BorderLayout.CENTER);
        // pMesa10.add(lDuracao10, BorderLayout.PAGE_END);
        pMesa10.setBounds(40, 530, 300, 150);

        // MESA 11
        pCorStatus11 = new JPanel();
        pCorStatus11.setBackground(Color.green);
        pAtendIniciado11 = new JPanel(new GridBagLayout());
        pAtendIniciado11.setLayout(new BorderLayout());
        pAtendIniciado11.setBackground(Color.white);
        lDuracao11 = new JLabel("Duração: 00:11");
        lEntrada = new JLabel("Entrada: 11:27");
        lDuracao11.setFont(new Font("Calibri", Font.BOLD, 30));
        lDuracao11.setHorizontalAlignment(JLabel.CENTER);
        lDuracao11.setVerticalAlignment(JLabel.CENTER);
        lMesa11 = new JLabel("Mesa 11");
        lMesa11.setFont(new Font("Verdana", 1, 20));
        lMesa11.setHorizontalAlignment(JLabel.CENTER);
        lMesa11.setVerticalAlignment(JLabel.NORTH);
        pMesa11 = new JPanel(new GridBagLayout());
        pMesa11.setLayout(new BorderLayout());
        pMesa11.setBackground(Color.white);
        pMesa11.setBorder(BorderFactory.createLineBorder(Color.black));
        pMesa11.add(pCorStatus11, BorderLayout.PAGE_START);
        pAtendIniciado11.add(lMesa11, BorderLayout.PAGE_START);
        // pAtendIniciado11.add(ConfirmButton11, BorderLayout.LINE_START);
        pAtendIniciado11.add(btnPainelPrinc.PlayButton11, BorderLayout.CENTER);
        // pAtendIniciado11.add(lEntrada, BorderLayout.LINE_END);
        pMesa11.add(pAtendIniciado11, BorderLayout.CENTER);
        // pMesa11.add(lDuracao11, BorderLayout.PAGE_END);
        pMesa11.setBounds(400, 530, 300, 150);

        // MESA 12
        pCorStatus12 = new JPanel();
        pCorStatus12.setBackground(Color.blue);
        pAtendIniciado12 = new JPanel(new GridBagLayout());
        pAtendIniciado12.setLayout(new BorderLayout());
        pAtendIniciado12.setBackground(Color.white);
        lDuracao12 = new JLabel("Duração: 00:11");
        lEntrada = new JLabel("Entrada: 12:27");
        lDuracao12.setFont(new Font("Calibri", Font.BOLD, 30));
        lDuracao12.setHorizontalAlignment(JLabel.CENTER);
        lDuracao12.setVerticalAlignment(JLabel.CENTER);
        lMesa12 = new JLabel("Mesa 12");
        lMesa12.setFont(new Font("Verdana", 1, 20));
        lMesa12.setHorizontalAlignment(JLabel.CENTER);
        lMesa12.setVerticalAlignment(JLabel.NORTH);
        pMesa12 = new JPanel(new GridBagLayout());
        pMesa12.setLayout(new BorderLayout());
        pMesa12.setBackground(Color.white);
        pMesa12.setBorder(BorderFactory.createLineBorder(Color.black));
        pMesa12.add(pCorStatus12, BorderLayout.PAGE_START);
        pAtendIniciado12.add(lMesa12, BorderLayout.PAGE_START);
        pAtendIniciado12.add(btnPainelPrinc.ConfirmButton12, BorderLayout.LINE_START);
        pAtendIniciado12.add(btnPainelPrinc.EyeButton12, BorderLayout.CENTER);
        pAtendIniciado12.add(lEntrada, BorderLayout.LINE_END);
        pMesa12.add(pAtendIniciado12, BorderLayout.CENTER);
        pMesa12.add(lDuracao12, BorderLayout.PAGE_END);
        pMesa12.setBounds(760, 530, 300, 150);

        // MENUBAR
        JMenuBar mb = new JMenuBar();
        menu = new JMenu("Página Inicial");
        painel = new JMenu("Painel");
        mb.add(menu);
        mb.add(painel);

        f = new JFrame("Donna Floripa");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setJMenuBar(mb);
        f.add(pMesa1);
        f.add(pMesa2);
        f.add(pMesa3);
        f.add(pMesa4);
        f.add(pMesa5);
        f.add(pMesa6);
        f.add(pMesa7);
        f.add(pMesa8);
        f.add(pMesa9);
        f.add(pMesa10);
        f.add(pMesa11);
        f.add(pMesa12);
        f.add(pDelivery);
        f.add(lLegendas);
        f.add(lMesaLivre);
        f.add(lPreparando);
        f.add(lConsumindo);
        f.add(lDemorando);
        f.add(pCorStatus);
        f.add(pPreparando);
        f.add(pConsumindo);
        f.add(pDemorando);
        f.add(lLogo);
        f.setIconImage(imgdf.getImage());
        f.getContentPane().setBackground(Color.ORANGE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setLayout(null);
        f.setVisible(true);

    }

}