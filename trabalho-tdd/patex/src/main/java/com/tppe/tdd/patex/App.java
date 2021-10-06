package com.tppe.tdd.patex;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        final JFileChooser fc = new JFileChooser();

        fc.setApproveButtonText("Choose");
        int approve = fc.showOpenDialog(null);

        if(approve == fc.APPROVE_OPTION){
            File chosenFile = fc.getSelectedFile();

            JOptionPane.showMessageDialog(null, "Arquivo escolhido: \n" +
                chosenFile.getAbsolutePath());

        }
    }
}
