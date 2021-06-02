import java.awt.GridBagLayout;
import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PainelPrincipal extends JPanel {

    public static void main(String[] args) {
        new PainelPrincipal();
    }

    public PainelPrincipal() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                JMenu menu, submenu, painel;

                JPanel pMesaLivre, pPreparando, pConsumindo, pDemorando, pDelivery, pMesa1, pMesa2, pMesa3, pMesa4,
                        pMesa5, pMesa6, pMesa7, pMesa8, pMesa9, pMesa10, pMesa11, pMesa12, pMesaLivre1, pMesaLivre2,
                        pMesaLivre3, pMesaLivre4, pMesaLivre5, pMesaLivre6, pMesaLivre7, pMesaLivre8, pMesaLivre9,
                        pMesaLivre10, pMesaLivre11, pMesaLivre12, pAtendIniciado12;

                JLabel lLegendas, lMesaLivre, lPreparando, lConsumindo, lDemorando, lDelivery, lMesa1, lMesa2, lMesa3,
                        lMesa4, lMesa5, lMesa6, lMesa7, lMesa8, lMesa9, lMesa10, lMesa11, lMesa12, lLinhaVazia1,
                        lLinhaVazia2, lLinhaVazia3, lLinhaVazia4, lLinhaVazia5, lLinhaVazia6, lLinhaVazia7,
                        lLinhaVazia8, lLinhaVazia9, lLinhaVazia10, lLinhaVazia11, lLinhaVazia12, lLogo, lEntrada;

                String status = "Consumindo";

                ImageIcon imgdf = new ImageIcon("C:/Projetos/Donna/DonnaFloripa/images/DonnaFloripa.png");
                Image imgedf = imgdf.getImage().getScaledInstance(450, 250, Image.SCALE_DEFAULT);
                ImageIcon imgDonnaFloripa = new ImageIcon(imgedf);

                ImageIcon imgeye = new ImageIcon("C:/Projetos/Donna/DonnaFloripa/images/Eye.png");
                Image imgeeyenew = imgeye.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
                ImageIcon imgEye = new ImageIcon(imgeeyenew);

                ImageIcon imgadd = new ImageIcon("C:/Projetos/Donna/DonnaFloripa/images/add.png");
                Image imgaddnew = imgadd.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
                ImageIcon imgAdd = new ImageIcon(imgaddnew);

                ImageIcon imgconfirm = new ImageIcon("C:/Projetos/Donna/DonnaFloripa/images/confirm.png");
                Image imgconfirmnew = imgconfirm.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
                ImageIcon imgConfirm = new ImageIcon(imgconfirmnew);

                // LEGENDAS
                lLegendas = new JLabel("Legendas:");
                lLegendas.setFont(new Font("Verdana", 1, 15));
                lLegendas.setBounds(50, 780, 100, 100);
                lMesaLivre = new JLabel("Mesa Livre");
                lMesaLivre.setFont(new Font("Verdana", 1, 15));
                pMesaLivre = new JPanel();
                pMesaLivre.setBackground(Color.GREEN);
                pMesaLivre.setBounds(50, 850, 30, 30);
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
                pDelivery.setBounds(1150, 50, 350, 630);
                pDelivery.setBackground(Color.white);
                pDelivery.setBorder(BorderFactory.createLineBorder(Color.black));
                pDelivery.add(lDelivery);

                // LOGO
                lLogo = new JLabel();
                lLogo.setIcon(imgDonnaFloripa);
                lLogo.setBounds(1050, 700, 500, 300);

                // MESA 1
                JButton PlayButton1 = new JButton("Iniciar Atendimento");
                PlayButton1.setIcon(imgAdd);
                PlayButton1.setBackground(Color.white);
                PlayButton1.setForeground(new Color(1, 118, 164));
                PlayButton1.setBorderPainted(false);
                PlayButton1.setFont(new Font("Calibri", Font.BOLD, 18));
                PlayButton1.setMargin(new Insets(0, 0, 0, 0));
                pMesaLivre1 = new JPanel();
                pMesaLivre1.setBackground(Color.GREEN);
                lMesa1 = new JLabel("Mesa 1");
                lMesa1.setHorizontalAlignment(JLabel.CENTER);
                lMesa1.setVerticalAlignment(JLabel.NORTH);
                lMesa1.setFont(new Font("Verdana", 1, 20));
                lLinhaVazia1 = new JLabel(" ");
                pMesa1 = new JPanel(new GridBagLayout());
                pMesa1.setLayout(new BorderLayout());
                pMesa1.setBounds(40, 50, 300, 150);
                pMesa1.setBackground(Color.white);
                pMesa1.setBorder(BorderFactory.createLineBorder(Color.black));
                pMesa1.add(lMesa1, BorderLayout.CENTER);
                pMesa1.add(pMesaLivre1, BorderLayout.PAGE_START);
                pMesa1.add(lLinhaVazia1, BorderLayout.AFTER_LAST_LINE);
                pMesa1.add(PlayButton1, BorderLayout.AFTER_LAST_LINE);

                // MESA 2
                JButton PlayButton2 = new JButton("Iniciar Atendimento");
                PlayButton2.setIcon(imgAdd);
                PlayButton2.setBackground(Color.white);
                PlayButton2.setForeground(new Color(1, 118, 164));
                PlayButton2.setBorderPainted(false);
                PlayButton2.setFont(new Font("Calibri", Font.BOLD, 18));
                PlayButton2.setMargin(new Insets(0, 0, 0, 0));
                pMesaLivre2 = new JPanel();
                pMesaLivre2.setBackground(Color.GREEN);
                lLinhaVazia2 = new JLabel(" ");
                lMesa2 = new JLabel("Mesa 2");
                lMesa2.setHorizontalAlignment(JLabel.CENTER);
                lMesa2.setVerticalAlignment(JLabel.NORTH);
                lMesa2.setFont(new Font("Verdana", 1, 20));
                pMesa2 = new JPanel(new GridBagLayout());
                pMesa2.setLayout(new BorderLayout());
                pMesa2.setBounds(400, 50, 300, 150);
                pMesa2.setBackground(Color.white);
                pMesa2.setBorder(BorderFactory.createLineBorder(Color.black));
                pMesa2.add(pMesaLivre2, BorderLayout.PAGE_START);
                pMesa2.add(lMesa2, BorderLayout.CENTER);
                pMesa2.add(lLinhaVazia2, BorderLayout.AFTER_LAST_LINE);
                pMesa2.add(PlayButton2, BorderLayout.AFTER_LAST_LINE);

                // MESA 3
                JButton PlayButton3 = new JButton("Iniciar Atendimento");
                PlayButton3.setIcon(imgAdd);
                PlayButton3.setBackground(Color.white);
                PlayButton3.setForeground(new Color(1, 118, 164));
                PlayButton3.setBorderPainted(false);
                PlayButton3.setFont(new Font("Calibri", Font.BOLD, 18));
                PlayButton3.setMargin(new Insets(0, 0, 0, 0));
                pMesaLivre3 = new JPanel();
                pMesaLivre3.setBackground(Color.GREEN);
                lLinhaVazia3 = new JLabel(" ");
                lMesa3 = new JLabel("Mesa 3");
                lMesa3.setFont(new Font("Verdana", 1, 20));
                lMesa3.setHorizontalAlignment(JLabel.CENTER);
                lMesa3.setVerticalAlignment(JLabel.NORTH);
                pMesa3 = new JPanel(new GridBagLayout());
                pMesa3.setLayout(new BorderLayout());
                pMesa3.setBounds(760, 50, 300, 150);
                pMesa3.setBackground(Color.white);
                pMesa3.setBorder(BorderFactory.createLineBorder(Color.black));
                pMesa3.add(pMesaLivre3, BorderLayout.PAGE_START);
                pMesa3.add(lMesa3, BorderLayout.CENTER);
                pMesa3.add(lLinhaVazia3, BorderLayout.AFTER_LAST_LINE);
                pMesa3.add(PlayButton3, BorderLayout.AFTER_LAST_LINE);

                // MESA 4
                JButton PlayButton4 = new JButton("Iniciar Atendimento");
                PlayButton4.setIcon(imgAdd);
                PlayButton4.setBackground(Color.white);
                PlayButton4.setForeground(new Color(1, 118, 164));
                PlayButton4.setBorderPainted(false);
                PlayButton4.setFont(new Font("Calibri", Font.BOLD, 18));
                PlayButton4.setMargin(new Insets(0, 0, 0, 0));
                pMesaLivre4 = new JPanel();
                pMesaLivre4.setBackground(Color.GREEN);
                lLinhaVazia4 = new JLabel(" ");
                lMesa4 = new JLabel("Mesa 4");
                lMesa4.setFont(new Font("Verdana", 1, 20));
                lMesa4.setHorizontalAlignment(JLabel.CENTER);
                lMesa4.setVerticalAlignment(JLabel.NORTH);
                pMesa4 = new JPanel(new GridBagLayout());
                pMesa4.setLayout(new BorderLayout());
                pMesa4.setBackground(Color.white);
                pMesa4.setBorder(BorderFactory.createLineBorder(Color.black));
                pMesa4.add(pMesaLivre4, BorderLayout.PAGE_START);
                pMesa4.add(lMesa4, BorderLayout.CENTER);
                pMesa4.add(lLinhaVazia4, BorderLayout.AFTER_LAST_LINE);
                pMesa4.add(PlayButton4, BorderLayout.AFTER_LAST_LINE);
                pMesa4.setBounds(40, 210, 300, 150);

                // MESA 5
                JButton PlayButton5 = new JButton("Iniciar Atendimento");
                PlayButton5.setIcon(imgAdd);
                PlayButton5.setBackground(Color.white);
                PlayButton5.setForeground(new Color(1, 118, 164));
                PlayButton5.setBorderPainted(false);
                PlayButton5.setFont(new Font("Calibri", Font.BOLD, 18));
                PlayButton5.setMargin(new Insets(0, 0, 0, 0));
                pMesaLivre5 = new JPanel();
                pMesaLivre5.setBackground(Color.GREEN);
                lLinhaVazia5 = new JLabel(" ");
                lMesa5 = new JLabel("Mesa 5");
                lMesa5.setFont(new Font("Verdana", 1, 20));
                lMesa5.setHorizontalAlignment(JLabel.CENTER);
                lMesa5.setVerticalAlignment(JLabel.NORTH);
                pMesa5 = new JPanel(new GridBagLayout());
                pMesa5.setLayout(new BorderLayout());
                pMesa5.setBackground(Color.white);
                pMesa5.setBorder(BorderFactory.createLineBorder(Color.black));
                pMesa5.add(pMesaLivre5, BorderLayout.PAGE_START);
                pMesa5.add(lMesa5, BorderLayout.CENTER);
                pMesa5.add(lLinhaVazia5, BorderLayout.AFTER_LAST_LINE);
                pMesa5.add(PlayButton5, BorderLayout.AFTER_LAST_LINE);
                pMesa5.setBounds(400, 210, 300, 150);

                // MESA 6
                JButton PlayButton6 = new JButton("Iniciar Atendimento");
                PlayButton6.setIcon(imgAdd);
                PlayButton6.setBackground(Color.white);
                PlayButton6.setForeground(new Color(1, 118, 164));
                PlayButton6.setBorderPainted(false);
                PlayButton6.setFont(new Font("Calibri", Font.BOLD, 18));
                PlayButton6.setMargin(new Insets(0, 0, 0, 0));
                pMesaLivre6 = new JPanel();
                pMesaLivre6.setBackground(Color.GREEN);
                lLinhaVazia6 = new JLabel(" ");
                lMesa6 = new JLabel("Mesa 6");
                lMesa6.setFont(new Font("Verdana", 1, 20));
                lMesa6.setHorizontalAlignment(JLabel.CENTER);
                lMesa6.setVerticalAlignment(JLabel.NORTH);
                pMesa6 = new JPanel(new GridBagLayout());
                pMesa6.setLayout(new BorderLayout());
                pMesa6.setBackground(Color.white);
                pMesa6.setBorder(BorderFactory.createLineBorder(Color.black));
                pMesa6.add(pMesaLivre6, BorderLayout.PAGE_START);
                pMesa6.add(lMesa6, BorderLayout.CENTER);
                pMesa6.add(lLinhaVazia6, BorderLayout.AFTER_LAST_LINE);
                pMesa6.add(PlayButton6, BorderLayout.AFTER_LAST_LINE);
                pMesa6.setBounds(760, 210, 300, 150);

                // MESA 7
                JButton PlayButton7 = new JButton("Iniciar Atendimento");
                PlayButton7.setIcon(imgAdd);
                PlayButton7.setBackground(Color.white);
                PlayButton7.setForeground(new Color(1, 118, 164));
                PlayButton7.setBorderPainted(false);
                PlayButton7.setFont(new Font("Calibri", Font.BOLD, 18));
                PlayButton7.setMargin(new Insets(0, 0, 0, 0));
                pMesaLivre7 = new JPanel();
                pMesaLivre7.setBackground(Color.GREEN);
                lLinhaVazia7 = new JLabel(" ");
                lMesa7 = new JLabel("Mesa 7");
                lMesa7.setFont(new Font("Verdana", 1, 20));
                lMesa7.setHorizontalAlignment(JLabel.CENTER);
                lMesa7.setVerticalAlignment(JLabel.NORTH);
                pMesa7 = new JPanel(new GridBagLayout());
                pMesa7.setLayout(new BorderLayout());
                pMesa7.setBackground(Color.white);
                pMesa7.setBorder(BorderFactory.createLineBorder(Color.black));
                pMesa7.add(pMesaLivre7, BorderLayout.PAGE_START);
                pMesa7.add(lMesa7, BorderLayout.CENTER);
                pMesa7.add(lLinhaVazia7, BorderLayout.AFTER_LAST_LINE);
                pMesa7.add(PlayButton7, BorderLayout.AFTER_LAST_LINE);
                pMesa7.setBounds(40, 370, 300, 150);

                // MESA 8
                JButton PlayButton8 = new JButton("Iniciar Atendimento");
                PlayButton8.setIcon(imgAdd);
                PlayButton8.setBackground(Color.white);
                PlayButton8.setForeground(new Color(1, 118, 164));
                PlayButton8.setBorderPainted(false);
                PlayButton8.setFont(new Font("Calibri", Font.BOLD, 18));
                PlayButton8.setMargin(new Insets(0, 0, 0, 0));
                pMesaLivre8 = new JPanel();
                pMesaLivre8.setBackground(Color.GREEN);
                lLinhaVazia8 = new JLabel(" ");
                lMesa8 = new JLabel("Mesa 8");
                lMesa8.setFont(new Font("Verdana", 1, 20));
                lMesa8.setHorizontalAlignment(JLabel.CENTER);
                lMesa8.setVerticalAlignment(JLabel.NORTH);
                pMesa8 = new JPanel(new GridBagLayout());
                pMesa8.setLayout(new BorderLayout());
                pMesa8.setBackground(Color.white);
                pMesa8.setBorder(BorderFactory.createLineBorder(Color.black));
                pMesa8.add(pMesaLivre8, BorderLayout.PAGE_START);
                pMesa8.add(lMesa8, BorderLayout.CENTER);
                pMesa8.add(lLinhaVazia8, BorderLayout.AFTER_LAST_LINE);
                pMesa8.add(PlayButton8, BorderLayout.AFTER_LAST_LINE);
                pMesa8.setBounds(400, 370, 300, 150);

                // MESA 9
                JButton PlayButton9 = new JButton("Iniciar Atendimento");
                PlayButton9.setIcon(imgAdd);
                PlayButton9.setBackground(Color.white);
                PlayButton9.setForeground(new Color(1, 118, 164));
                PlayButton9.setBorderPainted(false);
                PlayButton9.setFont(new Font("Calibri", Font.BOLD, 18));
                PlayButton9.setMargin(new Insets(0, 0, 0, 0));
                pMesaLivre9 = new JPanel();
                pMesaLivre9.setBackground(Color.GREEN);
                lLinhaVazia9 = new JLabel(" ");
                lMesa9 = new JLabel("Mesa 9");
                lMesa9.setFont(new Font("Verdana", 1, 20));
                lMesa9.setHorizontalAlignment(JLabel.CENTER);
                lMesa9.setVerticalAlignment(JLabel.NORTH);
                pMesa9 = new JPanel(new GridBagLayout());
                pMesa9.setLayout(new BorderLayout());
                pMesa9.setBackground(Color.white);
                pMesa9.setBorder(BorderFactory.createLineBorder(Color.black));
                pMesa9.add(pMesaLivre9, BorderLayout.PAGE_START);
                pMesa9.add(lMesa9, BorderLayout.CENTER);
                pMesa9.add(lLinhaVazia9, BorderLayout.AFTER_LAST_LINE);
                pMesa9.add(PlayButton9, BorderLayout.AFTER_LAST_LINE);
                pMesa9.setBounds(760, 370, 300, 150);

                // MESA 10
                JButton PlayButton10 = new JButton("Iniciar Atendimento");
                PlayButton10.setIcon(imgAdd);
                PlayButton10.setBackground(Color.white);
                PlayButton10.setForeground(new Color(1, 118, 164));
                PlayButton10.setBorderPainted(false);
                PlayButton10.setFont(new Font("Calibri", Font.BOLD, 18));
                PlayButton10.setMargin(new Insets(0, 0, 0, 0));
                pMesaLivre10 = new JPanel();
                pMesaLivre10.setBackground(Color.GREEN);
                lLinhaVazia10 = new JLabel(" ");
                lMesa10 = new JLabel("Mesa 10");
                lMesa10.setFont(new Font("Verdana", 1, 20));
                lMesa10.setHorizontalAlignment(JLabel.CENTER);
                lMesa10.setVerticalAlignment(JLabel.NORTH);
                pMesa10 = new JPanel(new GridBagLayout());
                pMesa10.setLayout(new BorderLayout());
                pMesa10.setBackground(Color.white);
                pMesa10.setBorder(BorderFactory.createLineBorder(Color.black));
                pMesa10.add(pMesaLivre10, BorderLayout.PAGE_START);
                pMesa10.add(lMesa10, BorderLayout.CENTER);
                pMesa10.add(lLinhaVazia10, BorderLayout.AFTER_LAST_LINE);
                pMesa10.add(PlayButton10, BorderLayout.AFTER_LAST_LINE);
                pMesa10.setBounds(40, 530, 300, 150);

                // MESA 11
                JButton PlayButton11 = new JButton("Iniciar Atendimento");
                PlayButton11.setIcon(imgAdd);
                PlayButton11.setBackground(Color.white);
                PlayButton11.setForeground(new Color(1, 118, 164));
                PlayButton11.setBorderPainted(false);
                PlayButton11.setFont(new Font("Calibri", Font.BOLD, 18));
                PlayButton11.setMargin(new Insets(0, 0, 0, 0));
                pMesaLivre11 = new JPanel();
                pMesaLivre11.setBackground(Color.GREEN);
                lLinhaVazia11 = new JLabel(" ");
                lMesa11 = new JLabel("Mesa 11");
                lMesa11.setFont(new Font("Verdana", 1, 20));
                lMesa11.setHorizontalAlignment(JLabel.CENTER);
                lMesa11.setVerticalAlignment(JLabel.NORTH);
                pMesa11 = new JPanel(new GridBagLayout());
                pMesa11.setLayout(new BorderLayout());
                pMesa11.setBackground(Color.white);
                pMesa11.setBorder(BorderFactory.createLineBorder(Color.black));
                pMesa11.add(pMesaLivre11, BorderLayout.PAGE_START);
                pMesa11.add(lMesa11, BorderLayout.CENTER);
                pMesa11.add(lLinhaVazia11, BorderLayout.AFTER_LAST_LINE);
                pMesa11.add(PlayButton11, BorderLayout.AFTER_LAST_LINE);
                pMesa11.setBounds(400, 530, 300, 150);

                // MESA 12
                JButton PlayButton12 = new JButton("");
                PlayButton12.setIcon(imgAdd);
                PlayButton12.setBackground(Color.white);
                PlayButton12.setForeground(new Color(1, 128, 164));
                PlayButton12.setBorderPainted(false);
                PlayButton12.setFont(new Font("Calibri", Font.BOLD, 18));
                PlayButton12.setMargin(new Insets(0, 0, 0, 0));
                JButton EyeButton12 = new JButton("");
                EyeButton12.setIcon(imgEye);
                EyeButton12.setBackground(Color.white);
                EyeButton12.setBorderPainted(false);
                EyeButton12.setMargin(new Insets(0, 0, 0, 0));
                JButton ConfirmButton = new JButton("");
                ConfirmButton.setIcon(imgConfirm);
                ConfirmButton.setBackground(Color.white);
                ConfirmButton.setBorderPainted(false);
                ConfirmButton.setMargin(new Insets(0, 0, 0, 0));
                pMesaLivre12 = new JPanel();
                pMesaLivre12.setBackground(Color.blue);
                pAtendIniciado12 = new JPanel(new GridBagLayout());
                pAtendIniciado12.setLayout(new BorderLayout());
                pAtendIniciado12.setBackground(Color.white);
                lLinhaVazia12 = new JLabel("Duração: 00:11");
                lEntrada = new JLabel("Entrada: 12:27");
                lLinhaVazia12.setFont(new Font("Calibri", Font.BOLD, 30));
                lLinhaVazia12.setHorizontalAlignment(JLabel.CENTER);
                lLinhaVazia12.setVerticalAlignment(JLabel.CENTER);
                lMesa12 = new JLabel("Mesa 12");
                lMesa12.setFont(new Font("Verdana", 1, 20));
                lMesa12.setHorizontalAlignment(JLabel.CENTER);
                lMesa12.setVerticalAlignment(JLabel.NORTH);
                pMesa12 = new JPanel(new GridBagLayout());
                pMesa12.setLayout(new BorderLayout());
                pMesa12.setBackground(Color.white);
                pMesa12.setBorder(BorderFactory.createLineBorder(Color.black));
                pMesa12.add(pMesaLivre12, BorderLayout.PAGE_START);
                pAtendIniciado12.add(lMesa12, BorderLayout.PAGE_START);
                pAtendIniciado12.add(ConfirmButton, BorderLayout.LINE_START);
                pAtendIniciado12.add(EyeButton12, BorderLayout.CENTER);
                pAtendIniciado12.add(lEntrada, BorderLayout.LINE_END);
                pMesa12.add(pAtendIniciado12, BorderLayout.CENTER);
                pMesa12.add(lLinhaVazia12, BorderLayout.PAGE_END);
                pMesa12.setBounds(760, 530, 300, 150);

                // MENUBAR
                JMenuBar mb = new JMenuBar();
                menu = new JMenu("Página Inicial");
                painel = new JMenu("Painel");
                mb.add(menu);
                mb.add(painel);

                // FRAME
                JFrame f = new JFrame("Donna Floripa");
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
                f.add(pMesaLivre);
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
        });
    }

}