package Default;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Default.Paineis.*;

public class botesConstrutor {

    public JButton PlayButton;
    public JButton EyeButton;
    public JButton ConfirmButton;
    public JButton addDeliveryButton;
    public JButton EyeButtonDelivery;
    public JButton ConfirmButtonDelivery;
    public JButton add_Mesa;
    public JButton removeButton;

    public botesConstrutor() {

        ImageIcon imgeye = new ImageIcon("C:/Projetos/Donna/DonnaFloripa/images/Eye.png");
        Image imgeeyenew = imgeye.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon imgEye = new ImageIcon(imgeeyenew);

        ImageIcon imgeyeDelivery = new ImageIcon("C:/Projetos/Donna/DonnaFloripa/images/Eye.png");
        Image imgeeyenewDelivery = imgeyeDelivery.getImage().getScaledInstance(33, 21, Image.SCALE_DEFAULT);
        ImageIcon imgEyeDelivery = new ImageIcon(imgeeyenewDelivery);

        ImageIcon imgadd = new ImageIcon("C:/Projetos/Donna/DonnaFloripa/images/add.png");
        Image imgaddnew = imgadd.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon imgAdd = new ImageIcon(imgaddnew);

        ImageIcon imgconfirm = new ImageIcon("C:/Projetos/Donna/DonnaFloripa/images/confirm.png");
        Image imgconfirmnew = imgconfirm.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon imgConfirm = new ImageIcon(imgconfirmnew);

        ImageIcon addMesa = new ImageIcon("C:/Projetos/Donna/DonnaFloripa/images/addmesa.png");
        Image addMesanew = addMesa.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon add_mesa = new ImageIcon(addMesanew);

        ImageIcon imgconfirmDelivery = new ImageIcon("C:/Projetos/Donna/DonnaFloripa/images/confirm.png");
        Image imgconfirmnewDelivery = imgconfirmDelivery.getImage().getScaledInstance(33, 21, Image.SCALE_DEFAULT);
        ImageIcon imgConfirmDelivery = new ImageIcon(imgconfirmnewDelivery);

        ImageIcon imgAddDelivery = new ImageIcon("C:/Projetos/Donna/DonnaFloripa/images/addDelivery.png");
        Image imgAddDeliveryNew = imgAddDelivery.getImage().getScaledInstance(60, 39, Image.SCALE_DEFAULT);
        ImageIcon imgAdd_Delivery = new ImageIcon(imgAddDeliveryNew);

        ImageIcon imgRemover = new ImageIcon("C:/Projetos/Donna/DonnaFloripa/images/Remove.png");
        Image imgRemoverNew = imgRemover.getImage().getScaledInstance(60, 39, Image.SCALE_DEFAULT);
        ImageIcon imgRemoverItem = new ImageIcon(imgRemoverNew);

        // BOTÕES da MESA
        PlayButton = new JButton("");
        PlayButton.setIcon(imgAdd);
        PlayButton.setBackground(Color.white);
        PlayButton.setForeground(new Color(1, 118, 164));
        PlayButton.setBorderPainted(false);
        PlayButton.setFont(new Font("Calibri", Font.BOLD, 18));
        PlayButton.setMargin(new Insets(0, 0, 0, 0));
        removeButton = new JButton("");
        removeButton.setIcon(imgRemoverItem);
        removeButton.setBackground(Color.WHITE);
        removeButton.setForeground(new Color(1, 118, 164));
        removeButton.setBorderPainted(false);
        removeButton.setFont(new Font("Calibri", Font.BOLD, 18));
        removeButton.setMargin(new Insets(0, 0, 0, 0));
        EyeButton = new JButton("");
        EyeButton.setIcon(imgEye);
        EyeButton.setBackground(Color.white);
        EyeButton.setBorderPainted(false);
        EyeButton.setMargin(new Insets(0, 0, 0, 0));
        EyeButtonDelivery = new JButton("");
        EyeButtonDelivery.setIcon(imgEyeDelivery);
        EyeButtonDelivery.setBackground(Color.white);
        EyeButtonDelivery.setBorderPainted(false);
        EyeButtonDelivery.setMargin(new Insets(0, 0, 0, 0));
        ConfirmButton = new JButton("");
        ConfirmButton.setIcon(imgConfirm);
        ConfirmButton.setBackground(Color.white);
        ConfirmButton.setBorderPainted(false);
        ConfirmButton.setMargin(new Insets(0, 0, 0, 0));
        ConfirmButtonDelivery = new JButton("");
        ConfirmButtonDelivery.setIcon(imgConfirmDelivery);
        ConfirmButtonDelivery.setBackground(Color.white);
        ConfirmButtonDelivery.setBorderPainted(false);
        ConfirmButtonDelivery.setMargin(new Insets(0, 0, 0, 0));
        addDeliveryButton = new JButton("");
        addDeliveryButton.setIcon(imgAdd_Delivery);
        addDeliveryButton.setBackground(Color.white);
        addDeliveryButton.setBorderPainted(false);
        addDeliveryButton.setMargin(new Insets(0, 0, 0, 0));
        add_Mesa = new JButton("");
        add_Mesa.setIcon(add_mesa);
        add_Mesa.setBackground(Color.ORANGE);
        add_Mesa.setBorderPainted(false);
        add_Mesa.setMargin(new Insets(0, 0, 0, 0));
    }

}
