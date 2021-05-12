import javax.swing.*;
import java.awt.*;

class MenuExample {
    JMenu menu, submenu, painel;

    JPanel pMesaLivre, pPreparando, pConsumindo, pDemorando, pDelivery, pMesa1, pMesa2, pMesa3, pMesa4, pMesa5, pMesa6,
            pMesa7, pMesa8, pMesa9, pMesa10, pMesa11, pMesa12;

    JLabel lLegendas, lMesaLivre, lPreparando, lConsumindo, lDemorando, lDelivery, lMesa1, lMesa2, lMesa3, lMesa4,
            lMesa5, lMesa6, lMesa7, lMesa8, lMesa9, lMesa10, lMesa11, lMesa12;

    String status = "Consumindo";

    MenuExample() {
        ImageIcon img = new ImageIcon("C:/Projetos/Donna/images/add.png");
        Image imgnew = img.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);// Xunxo feito para definir o
                                                                                     // tamanho do Icone
        ImageIcon img2 = new ImageIcon(imgnew);
        JFrame f = new JFrame("Donna Floripa");
        JMenuBar mb = new JMenuBar();
        JButton PlayButton = new JButton();
        PlayButton.setBorderPainted(false);
        // PlayButton.setFocusPainted(false);
        // PlayButton.setContentAreaFilled(false); //Congela o Botão :(
        PlayButton.setIcon(img2);
        PlayButton.setMargin(new Insets(0, 0, 0, 0));// Zera as margens do Botão
        lLegendas = new JLabel("Legendas:");
        lLegendas.setFont(new Font("Verdana", 1, 15));
        lLegendas.setBounds(50, 780, 100, 100);
        lMesaLivre = new JLabel("Mesa Livre");
        lMesaLivre.setFont(new Font("Verdana", 1, 15));
        pMesaLivre = new JPanel();
        pMesaLivre.setBackground(Color.GREEN);
        pMesaLivre.setBounds(50, 850, 40, 40);
        lMesaLivre.setBounds(100, 820, 100, 100);
        lPreparando = new JLabel("Preparando");
        lPreparando.setFont(new Font("Verdana", 1, 15));
        pPreparando = new JPanel();
        pPreparando.setBackground(Color.darkGray);
        pPreparando.setBounds(250, 850, 40, 40);
        lPreparando.setBounds(300, 820, 100, 100);
        lConsumindo = new JLabel("Consumindo");
        lConsumindo.setFont(new Font("Verdana", 1, 15));
        pConsumindo = new JPanel();
        pConsumindo.setBackground(Color.blue);
        pConsumindo.setBounds(450, 850, 40, 40);
        lConsumindo.setBounds(500, 820, 100, 100);
        lDemorando = new JLabel("Demorando");
        lDemorando.setFont(new Font("Verdana", 1, 15));
        pDemorando = new JPanel();
        pDemorando.setBackground(Color.RED);
        pDemorando.setBounds(650, 850, 40, 40);
        lDemorando.setBounds(700, 820, 100, 100);
        lDelivery = new JLabel("Delivery");
        lDelivery.setFont(new Font("Verdana", 1, 20));
        lMesa1 = new JLabel("Mesa 1");
        lMesa1.setFont(new Font("Verdana", 1, 20));
        lMesa2 = new JLabel("Mesa 2");
        lMesa2.setFont(new Font("Verdana", 1, 20));
        lMesa3 = new JLabel("Mesa 3");
        lMesa3.setFont(new Font("Verdana", 1, 20));
        lMesa4 = new JLabel("Mesa 4");
        lMesa4.setFont(new Font("Verdana", 1, 20));
        lMesa5 = new JLabel("Mesa 5");
        lMesa5.setFont(new Font("Verdana", 1, 20));
        lMesa6 = new JLabel("Mesa 6");
        lMesa6.setFont(new Font("Verdana", 1, 20));
        lMesa7 = new JLabel("Mesa 7");
        lMesa7.setFont(new Font("Verdana", 1, 20));
        lMesa8 = new JLabel("Mesa 8");
        lMesa8.setFont(new Font("Verdana", 1, 20));
        lMesa9 = new JLabel("Mesa 9");
        lMesa9.setFont(new Font("Verdana", 1, 20));
        lMesa10 = new JLabel("Mesa 10");
        lMesa10.setFont(new Font("Verdana", 1, 20));
        lMesa11 = new JLabel("Mesa 11");
        lMesa11.setFont(new Font("Verdana", 1, 20));
        lMesa12 = new JLabel("Mesa 12");
        lMesa12.setFont(new Font("Verdana", 1, 20));

        pDelivery = new JPanel();
        pMesa1 = new JPanel();
        pMesa2 = new JPanel();
        pMesa3 = new JPanel();
        pMesa4 = new JPanel();
        pMesa5 = new JPanel();
        pMesa6 = new JPanel();
        pMesa7 = new JPanel();
        pMesa8 = new JPanel();
        pMesa9 = new JPanel();
        pMesa10 = new JPanel();
        pMesa11 = new JPanel();
        pMesa12 = new JPanel();
        pDelivery.setBounds(1150, 50, 350, 630);
        pDelivery.setBackground(Color.white);
        pDelivery.add(lDelivery);
        pMesa1.setBounds(40, 50, 300, 150);
        pMesa1.setBackground(Color.white);
        pMesa1.add(lMesa1);
        pMesa1.add(PlayButton, BorderLayout.PAGE_END);
        pMesa2.setBounds(400, 50, 300, 150);
        pMesa2.setBackground(Color.white);
        pMesa2.add(lMesa2);
        pMesa3.setBounds(760, 50, 300, 150);
        pMesa3.setBackground(Color.white);
        pMesa3.add(lMesa3);
        pMesa4.setBounds(40, 210, 300, 150);
        pMesa4.setBackground(Color.white);
        pMesa4.add(lMesa4);
        pMesa5.setBounds(400, 210, 300, 150);
        pMesa5.setBackground(Color.white);
        pMesa5.add(lMesa5);
        pMesa6.setBounds(760, 210, 300, 150);
        pMesa6.setBackground(Color.white);
        pMesa6.add(lMesa6);
        pMesa7.setBounds(40, 370, 300, 150);
        pMesa7.setBackground(Color.white);
        pMesa7.add(lMesa7);
        pMesa8.setBounds(400, 370, 300, 150);
        pMesa8.setBackground(Color.white);
        pMesa8.add(lMesa8);
        pMesa9.setBounds(760, 370, 300, 150);
        pMesa9.setBackground(Color.white);
        pMesa9.add(lMesa9);
        pMesa10.setBounds(40, 530, 300, 150);
        pMesa10.setBackground(Color.white);
        pMesa10.add(lMesa10);
        pMesa11.setBounds(400, 530, 300, 150);
        pMesa11.setBackground(Color.white);
        pMesa11.add(lMesa11);
        pMesa12.setBounds(760, 530, 300, 150);
        pMesa12.setBackground(Color.white);
        pMesa12.add(lMesa12);
        menu = new JMenu("Página Inicial");
        painel = new JMenu("Painel");
        mb.add(menu);
        mb.add(painel);
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
        f.getContentPane().setBackground(Color.ORANGE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setLayout(null);
        f.setVisible(true);

    }

    public static void main(String args[]) {
        new MenuExample();
    }
}