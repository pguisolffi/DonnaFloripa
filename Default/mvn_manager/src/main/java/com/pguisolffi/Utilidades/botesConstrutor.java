package com.pguisolffi.Utilidades;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.pguisolffi.Paineis.*;

public class botesConstrutor {

        public JButton PlayButton;
        public JButton EyeButton;
        public JButton ConfirmButton;
        public JButton addDeliveryButton;
        public JButton EyeButtonDelivery;
        public JButton ConfirmButtonDelivery;
        public JButton add_Mesa;
        public JButton removeButton;
        public JButton impressoraButton;
        public JButton addItemButton;
        public JButton finishAtendButton;

        public static ImageIcon finishIcon;
        public static ImageIcon finishIconDelivery;

        public botesConstrutor() {

                RedimensionarComplementos redim = new RedimensionarComplementos();
                int largura_FramePrincipal = redim.Largura_FrameMesas();
                int Altura_FramePrincipal = redim.Altura_FrameMesas();

                ImageIcon imgeye = new ImageIcon(
                                "C:/Projetos/Donna/DonnaFloripa/Default/mvn_manager/src/main/java/com/pguisolffi/images/Eye.png");
                Image imgeeyenew = imgeye.getImage().getScaledInstance((int)Math.round(largura_FramePrincipal*0.024), (int)Math.round(Altura_FramePrincipal*0.042667), Image.SCALE_DEFAULT);
                ImageIcon imgEye = new ImageIcon(imgeeyenew);

                ImageIcon imgeyeDelivery = new ImageIcon(
                                "C:/Projetos/Donna/DonnaFloripa/Default/mvn_manager/src/main/java/com/pguisolffi/images/Eye.png");
                Image imgeeyenewDelivery = imgeyeDelivery.getImage().getScaledInstance((int)Math.round(largura_FramePrincipal*0.008533), (int)Math.round(Altura_FramePrincipal*0.0128), Image.SCALE_DEFAULT);
                ImageIcon imgEyeDelivery = new ImageIcon(imgeeyenewDelivery);

                ImageIcon imgadd = new ImageIcon(
                                "C:/Projetos/Donna/DonnaFloripa/Default/mvn_manager/src/main/java/com/pguisolffi/images/add.png");
                Image imgaddnew = imgadd.getImage().getScaledInstance((int)Math.round(largura_FramePrincipal*0.024), (int)Math.round(Altura_FramePrincipal*0.042667), Image.SCALE_DEFAULT);
                ImageIcon imgAdd = new ImageIcon(imgaddnew);

                ImageIcon imgconfirm = new ImageIcon(
                                "C:/Projetos/Donna/DonnaFloripa/Default/mvn_manager/src/main/java/com/pguisolffi/images/confirm.png");
                Image imgconfirmnew = imgconfirm.getImage().getScaledInstance((int)Math.round(largura_FramePrincipal*0.024), (int)Math.round(Altura_FramePrincipal*0.042667), Image.SCALE_DEFAULT);
                ImageIcon imgConfirm = new ImageIcon(imgconfirmnew);

                ImageIcon addMesa = new ImageIcon(
                                "C:/Projetos/Donna/DonnaFloripa/Default/mvn_manager/src/main/java/com/pguisolffi/images/addmesa.png");
                Image addMesanew = addMesa.getImage().getScaledInstance((int)Math.round(largura_FramePrincipal*0.024), (int)Math.round(Altura_FramePrincipal*0.042667), Image.SCALE_DEFAULT);
                ImageIcon add_mesa = new ImageIcon(addMesanew);

                ImageIcon imgconfirmDelivery = new ImageIcon(
                                "C:/Projetos/Donna/DonnaFloripa/Default/mvn_manager/src/main/java/com/pguisolffi/images/confirm.png");
                Image imgconfirmnewDelivery = imgconfirmDelivery.getImage().getScaledInstance((int)Math.round(largura_FramePrincipal*0.010133), (int)Math.round(Altura_FramePrincipal*0.011378),Image.SCALE_DEFAULT);
                ImageIcon imgConfirmDelivery = new ImageIcon(imgconfirmnewDelivery);

                ImageIcon imgAddDelivery = new ImageIcon(
                                "C:/Projetos/Donna/DonnaFloripa/Default/mvn_manager/src/main/java/com/pguisolffi/images/addDelivery.png");
                Image imgAddDeliveryNew = imgAddDelivery.getImage().getScaledInstance((int)Math.round(largura_FramePrincipal*0.033067), (int)Math.round(Altura_FramePrincipal*0.033422), Image.SCALE_DEFAULT);
                ImageIcon imgAdd_Delivery = new ImageIcon(imgAddDeliveryNew);

                ImageIcon imgRemover = new ImageIcon(
                                "C:/Projetos/Donna/DonnaFloripa/Default/mvn_manager/src/main/java/com/pguisolffi/images/Remove.png");
                Image imgRemoverNew = imgRemover.getImage().getScaledInstance((int)Math.round(largura_FramePrincipal*0.003733), (int)Math.round(Altura_FramePrincipal*0.009244), Image.SCALE_DEFAULT);
                ImageIcon imgRemoverItem = new ImageIcon(imgRemoverNew);

                ImageIcon imgImpressao = new ImageIcon(
                                "C:/Projetos/Donna/DonnaFloripa/Default/mvn_manager/src/main/java/com/pguisolffi/images/printer.png");
                Image imgImpressaonew = imgImpressao.getImage().getScaledInstance((int)Math.round(largura_FramePrincipal*0.0096), (int)Math.round(Altura_FramePrincipal*0.02133), Image.SCALE_DEFAULT);
                ImageIcon imgImpressora = new ImageIcon(imgImpressaonew);

                ImageIcon imgFoward = new ImageIcon(
                                "C:/Projetos/Donna/DonnaFloripa/Default/mvn_manager/src/main/java/com/pguisolffi/images/transfer.png");
                Image imgFowardnew = imgFoward.getImage().getScaledInstance((int)Math.round(largura_FramePrincipal*0.018667),(int)Math.round(Altura_FramePrincipal*0.024889), Image.SCALE_DEFAULT);
                ImageIcon transferIcon = new ImageIcon(imgFowardnew);

                ImageIcon imgFinish = new ImageIcon(
                "C:/Projetos/Donna/DonnaFloripa/Default/mvn_manager/src/main/java/com/pguisolffi/images/finish.png");
                Image imgFinishnew = imgFinish.getImage().getScaledInstance((int)Math.round(largura_FramePrincipal*0.016), (int)Math.round(Altura_FramePrincipal*0.02844), Image.SCALE_DEFAULT);
                finishIcon = new ImageIcon(imgFinishnew);

                Image imgFinishnewDelivey = imgFinish.getImage().getScaledInstance((int)Math.round(largura_FramePrincipal*0.007467), (int)Math.round(Altura_FramePrincipal*0.0128), Image.SCALE_DEFAULT);
                finishIconDelivery = new ImageIcon(imgFinishnewDelivey);


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
                impressoraButton = new JButton("");
                impressoraButton.setIcon(imgImpressora);
                impressoraButton.setBackground(Color.ORANGE);
                impressoraButton.setBorderPainted(false);
                impressoraButton.setMargin(new Insets(0, 0, 0, 0));
                addItemButton = new JButton("");
                addItemButton.setIcon(transferIcon);
                addItemButton.setBackground(Color.LIGHT_GRAY);
                addItemButton.setBorderPainted(false);
                addItemButton.setMargin(new Insets(0, 0, 0, 0));
                finishAtendButton = new JButton("");
                finishAtendButton.setIcon(finishIcon);
                finishAtendButton.setBackground(Color.white);
                finishAtendButton.setBorderPainted(false);
                finishAtendButton.setMargin(new Insets(0, 0, 0, 0));

        }

}
