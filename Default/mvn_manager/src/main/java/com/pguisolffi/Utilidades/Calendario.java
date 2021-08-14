package com.pguisolffi.Utilidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JPanel;
import org.jdesktop.swingx.JXDatePicker;

public class Calendario {

    public  Calendario(){
        
    }

    public JPanel calendario(){

        JPanel panel = new JPanel();

        JXDatePicker picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        panel.add(picker);

        // JFormattedTextField editor = picker.getEditor();
        // Date dateInDatePicker = (Date) editor.getValue();
        
        return panel;

    }

}
    
