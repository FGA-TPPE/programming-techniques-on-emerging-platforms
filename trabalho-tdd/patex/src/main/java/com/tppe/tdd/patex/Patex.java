package com.tppe.tdd.patex;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Patex {
    private JFileChooser fc;

    Patex(){
        this.fc = new JFileChooser();
    }

    void start(){
        this.fc.setDialogTitle("Choose the file you want to parse");
        this.fc.setApproveButtonText("Choose");
        int approve = this.fc.showOpenDialog(null);

        if(approve == this.fc.APPROVE_OPTION){
            File chosenFile = this.fc.getSelectedFile();

            JOptionPane.showMessageDialog(null, "Chosen file: \n" +
                chosenFile.getAbsolutePath());

        }
    }

    void stop(){
        JOptionPane.showMessageDialog(null, "Thank you for using Patex !");
    }
}
