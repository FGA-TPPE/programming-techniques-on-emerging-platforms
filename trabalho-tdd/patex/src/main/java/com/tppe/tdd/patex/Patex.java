package com.tppe.tdd.patex;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Patex {
    private JFileChooser fc;
    File chosenFile;

    Patex(){
        this.fc = new JFileChooser();
        this.chosenFile = null;
    }

    Patex(String pathToFile){
        this.fc = new JFileChooser();
        this.chosenFile = new File(pathToFile);
    }

    Boolean isFileChosen(){
        return this.chosenFile != null;
    }

    Boolean isChosenFileReadable() {
        return true;
    }

    void chooseFile() throws FileNotFoundException{
        if(!this.isFileChosen()){
            this.fc.setDialogTitle("Choose the file you want to parse");
            this.fc.setApproveButtonText("Choose");
            int approve = this.fc.showOpenDialog(null);
            if(approve == this.fc.APPROVE_OPTION){
                this.chosenFile = this.fc.getSelectedFile();
            }
            else
                throw new FileNotFoundException("No file was chosen");
        }
    }

    String chooseDelimiter() {
        return ";";
    }

    void start(){
        try {
            this.chooseFile();
            this.chooseDelimiter();
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "You must choose a file to continue");
        } catch (Exception e) {
            System.out.println("Unexpected exception occurred");
        }
    }

    void stop(){
        JOptionPane.showMessageDialog(null, "Thank you for using Patex !");
    }

}
