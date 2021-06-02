import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BotoesPainelPrincipal {

    JButton PlayButton1, PlayButton2, PlayButton3, PlayButton4, PlayButton5, PlayButton6, PlayButton7, PlayButton8,
            PlayButton9, PlayButton10, PlayButton11, PlayButton12, EyeButton1, EyeButton2, EyeButton3, EyeButton4,
            EyeButton5, EyeButton6, EyeButton7, EyeButton8, EyeButton9, EyeButton10, EyeButton11, EyeButton12,
            ConfirmButton1, ConfirmButton2, ConfirmButton3, ConfirmButton4, ConfirmButton5, ConfirmButton6,
            ConfirmButton7, ConfirmButton8, ConfirmButton9, ConfirmButton10, ConfirmButton11, ConfirmButton12;

    public BotoesPainelPrincipal() {

        // PainelPrincipal pp = new PainelPrincipal();

        ImageIcon imgeye = new ImageIcon("C:/Projetos/Donna/DonnaFloripa/images/Eye.png");
        Image imgeeyenew = imgeye.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon imgEye = new ImageIcon(imgeeyenew);

        ImageIcon imgadd = new ImageIcon("C:/Projetos/Donna/DonnaFloripa/images/add.png");
        Image imgaddnew = imgadd.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon imgAdd = new ImageIcon(imgaddnew);

        ImageIcon imgconfirm = new ImageIcon("C:/Projetos/Donna/DonnaFloripa/images/confirm.png");
        Image imgconfirmnew = imgconfirm.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon imgConfirm = new ImageIcon(imgconfirmnew);

        // BOTÕES MESA 1
        PlayButton1 = new JButton("");
        PlayButton1.setIcon(imgAdd);
        PlayButton1.setBackground(Color.white);
        PlayButton1.setForeground(new Color(1, 118, 164));
        PlayButton1.setBorderPainted(false);
        PlayButton1.setFont(new Font("Calibri", Font.BOLD, 18));
        PlayButton1.setMargin(new Insets(0, 0, 0, 0));
        EyeButton1 = new JButton("");
        EyeButton1.setIcon(imgEye);
        EyeButton1.setBackground(Color.white);
        EyeButton1.setBorderPainted(false);
        EyeButton1.setMargin(new Insets(0, 0, 0, 0));
        ConfirmButton1 = new JButton("");
        ConfirmButton1.setIcon(imgConfirm);
        ConfirmButton1.setBackground(Color.white);
        ConfirmButton1.setBorderPainted(false);
        ConfirmButton1.setMargin(new Insets(0, 0, 0, 0));

        // AÇÕES BOTOES MESA 1
        PlayButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PainelPrincipal pp = new PainelPrincipal();
                JPanel corStatus1 = pp.pCorStatus1;
                JPanel pM1 = pp.pMesa1;
                corStatus1.setBackground(Color.red);
                pM1.repaint();
            }
        });

        PlayButton2 = new JButton("");
        PlayButton2.setIcon(imgAdd);
        PlayButton2.setBackground(Color.white);
        PlayButton2.setForeground(new Color(1, 118, 164));
        PlayButton2.setBorderPainted(false);
        PlayButton2.setFont(new Font("Calibri", Font.BOLD, 18));
        PlayButton2.setMargin(new Insets(0, 0, 0, 0));
        EyeButton2 = new JButton("");
        EyeButton2.setIcon(imgEye);
        EyeButton2.setBackground(Color.white);
        EyeButton2.setBorderPainted(false);
        EyeButton2.setMargin(new Insets(0, 0, 0, 0));
        ConfirmButton2 = new JButton("");
        ConfirmButton2.setIcon(imgConfirm);
        ConfirmButton2.setBackground(Color.white);
        ConfirmButton2.setBorderPainted(false);
        ConfirmButton2.setMargin(new Insets(0, 0, 0, 0));

        PlayButton3 = new JButton("");
        PlayButton3.setIcon(imgAdd);
        PlayButton3.setBackground(Color.white);
        PlayButton3.setForeground(new Color(1, 118, 164));
        PlayButton3.setBorderPainted(false);
        PlayButton3.setFont(new Font("Calibri", Font.BOLD, 18));
        PlayButton3.setMargin(new Insets(0, 0, 0, 0));
        EyeButton3 = new JButton("");
        EyeButton3.setIcon(imgEye);
        EyeButton3.setBackground(Color.white);
        EyeButton3.setBorderPainted(false);
        EyeButton3.setMargin(new Insets(0, 0, 0, 0));
        ConfirmButton3 = new JButton("");
        ConfirmButton3.setIcon(imgConfirm);
        ConfirmButton3.setBackground(Color.white);
        ConfirmButton3.setBorderPainted(false);
        ConfirmButton3.setMargin(new Insets(0, 0, 0, 0));

        PlayButton4 = new JButton("");
        PlayButton4.setIcon(imgAdd);
        PlayButton4.setBackground(Color.white);
        PlayButton4.setForeground(new Color(1, 118, 164));
        PlayButton4.setBorderPainted(false);
        PlayButton4.setFont(new Font("Calibri", Font.BOLD, 18));
        PlayButton4.setMargin(new Insets(0, 0, 0, 0));
        EyeButton4 = new JButton("");
        EyeButton4.setIcon(imgEye);
        EyeButton4.setBackground(Color.white);
        EyeButton4.setBorderPainted(false);
        EyeButton4.setMargin(new Insets(0, 0, 0, 0));
        ConfirmButton4 = new JButton("");
        ConfirmButton4.setIcon(imgConfirm);
        ConfirmButton4.setBackground(Color.white);
        ConfirmButton4.setBorderPainted(false);
        ConfirmButton4.setMargin(new Insets(0, 0, 0, 0));

        PlayButton5 = new JButton("");
        PlayButton5.setIcon(imgAdd);
        PlayButton5.setBackground(Color.white);
        PlayButton5.setForeground(new Color(1, 118, 164));
        PlayButton5.setBorderPainted(false);
        PlayButton5.setFont(new Font("Calibri", Font.BOLD, 18));
        PlayButton5.setMargin(new Insets(0, 0, 0, 0));
        EyeButton5 = new JButton("");
        EyeButton5.setIcon(imgEye);
        EyeButton5.setBackground(Color.white);
        EyeButton5.setBorderPainted(false);
        EyeButton5.setMargin(new Insets(0, 0, 0, 0));
        ConfirmButton5 = new JButton("");
        ConfirmButton5.setIcon(imgConfirm);
        ConfirmButton5.setBackground(Color.white);
        ConfirmButton5.setBorderPainted(false);
        ConfirmButton5.setMargin(new Insets(0, 0, 0, 0));

        PlayButton6 = new JButton("");
        PlayButton6.setIcon(imgAdd);
        PlayButton6.setBackground(Color.white);
        PlayButton6.setForeground(new Color(1, 118, 164));
        PlayButton6.setBorderPainted(false);
        PlayButton6.setFont(new Font("Calibri", Font.BOLD, 18));
        PlayButton6.setMargin(new Insets(0, 0, 0, 0));
        EyeButton6 = new JButton("");
        EyeButton6.setIcon(imgEye);
        EyeButton6.setBackground(Color.white);
        EyeButton6.setBorderPainted(false);
        EyeButton6.setMargin(new Insets(0, 0, 0, 0));
        ConfirmButton6 = new JButton("");
        ConfirmButton6.setIcon(imgConfirm);
        ConfirmButton6.setBackground(Color.white);
        ConfirmButton6.setBorderPainted(false);
        ConfirmButton6.setMargin(new Insets(0, 0, 0, 0));

        PlayButton7 = new JButton("");
        PlayButton7.setIcon(imgAdd);
        PlayButton7.setBackground(Color.white);
        PlayButton7.setForeground(new Color(1, 118, 164));
        PlayButton7.setBorderPainted(false);
        PlayButton7.setFont(new Font("Calibri", Font.BOLD, 18));
        PlayButton7.setMargin(new Insets(0, 0, 0, 0));
        EyeButton7 = new JButton("");
        EyeButton7.setIcon(imgEye);
        EyeButton7.setBackground(Color.white);
        EyeButton7.setBorderPainted(false);
        EyeButton7.setMargin(new Insets(0, 0, 0, 0));
        ConfirmButton7 = new JButton("");
        ConfirmButton7.setIcon(imgConfirm);
        ConfirmButton7.setBackground(Color.white);
        ConfirmButton7.setBorderPainted(false);
        ConfirmButton7.setMargin(new Insets(0, 0, 0, 0));

        PlayButton8 = new JButton("");
        PlayButton8.setIcon(imgAdd);
        PlayButton8.setBackground(Color.white);
        PlayButton8.setForeground(new Color(1, 118, 164));
        PlayButton8.setBorderPainted(false);
        PlayButton8.setFont(new Font("Calibri", Font.BOLD, 18));
        PlayButton8.setMargin(new Insets(0, 0, 0, 0));
        EyeButton8 = new JButton("");
        EyeButton8.setIcon(imgEye);
        EyeButton8.setBackground(Color.white);
        EyeButton8.setBorderPainted(false);
        EyeButton8.setMargin(new Insets(0, 0, 0, 0));
        ConfirmButton8 = new JButton("");
        ConfirmButton8.setIcon(imgConfirm);
        ConfirmButton8.setBackground(Color.white);
        ConfirmButton8.setBorderPainted(false);
        ConfirmButton8.setMargin(new Insets(0, 0, 0, 0));

        PlayButton9 = new JButton("");
        PlayButton9.setIcon(imgAdd);
        PlayButton9.setBackground(Color.white);
        PlayButton9.setForeground(new Color(1, 118, 164));
        PlayButton9.setBorderPainted(false);
        PlayButton9.setFont(new Font("Calibri", Font.BOLD, 18));
        PlayButton9.setMargin(new Insets(0, 0, 0, 0));
        EyeButton9 = new JButton("");
        EyeButton9.setIcon(imgEye);
        EyeButton9.setBackground(Color.white);
        EyeButton9.setBorderPainted(false);
        EyeButton9.setMargin(new Insets(0, 0, 0, 0));
        ConfirmButton9 = new JButton("");
        ConfirmButton9.setIcon(imgConfirm);
        ConfirmButton9.setBackground(Color.white);
        ConfirmButton9.setBorderPainted(false);
        ConfirmButton9.setMargin(new Insets(0, 0, 0, 0));

        PlayButton10 = new JButton("");
        PlayButton10.setIcon(imgAdd);
        PlayButton10.setBackground(Color.white);
        PlayButton10.setForeground(new Color(1, 118, 164));
        PlayButton10.setBorderPainted(false);
        PlayButton10.setFont(new Font("Calibri", Font.BOLD, 18));
        PlayButton10.setMargin(new Insets(0, 0, 0, 0));
        EyeButton10 = new JButton("");
        EyeButton10.setIcon(imgEye);
        EyeButton10.setBackground(Color.white);
        EyeButton10.setBorderPainted(false);
        EyeButton10.setMargin(new Insets(0, 0, 0, 0));
        ConfirmButton10 = new JButton("");
        ConfirmButton10.setIcon(imgConfirm);
        ConfirmButton10.setBackground(Color.white);
        ConfirmButton10.setBorderPainted(false);
        ConfirmButton10.setMargin(new Insets(0, 0, 0, 0));

        PlayButton11 = new JButton("");
        PlayButton11.setIcon(imgAdd);
        PlayButton11.setBackground(Color.white);
        PlayButton11.setForeground(new Color(1, 118, 164));
        PlayButton11.setBorderPainted(false);
        PlayButton11.setFont(new Font("Calibri", Font.BOLD, 18));
        PlayButton11.setMargin(new Insets(0, 0, 0, 0));
        EyeButton11 = new JButton("");
        EyeButton11.setIcon(imgEye);
        EyeButton11.setBackground(Color.white);
        EyeButton11.setBorderPainted(false);
        EyeButton11.setMargin(new Insets(0, 0, 0, 0));
        ConfirmButton11 = new JButton("");
        ConfirmButton11.setIcon(imgConfirm);
        ConfirmButton11.setBackground(Color.white);
        ConfirmButton11.setBorderPainted(false);
        ConfirmButton11.setMargin(new Insets(0, 0, 0, 0));

        PlayButton12 = new JButton("");
        PlayButton12.setIcon(imgAdd);
        PlayButton12.setBackground(Color.white);
        PlayButton12.setForeground(new Color(1, 128, 164));
        PlayButton12.setBorderPainted(false);
        PlayButton12.setFont(new Font("Calibri", Font.BOLD, 18));
        PlayButton12.setMargin(new Insets(0, 0, 0, 0));
        EyeButton12 = new JButton("");
        EyeButton12.setIcon(imgEye);
        EyeButton12.setBackground(Color.white);
        EyeButton12.setBorderPainted(false);
        EyeButton12.setMargin(new Insets(0, 0, 0, 0));
        ConfirmButton12 = new JButton("");
        ConfirmButton12.setIcon(imgConfirm);
        ConfirmButton12.setBackground(Color.white);
        ConfirmButton12.setBorderPainted(false);
        ConfirmButton12.setMargin(new Insets(0, 0, 0, 0));

    }

}