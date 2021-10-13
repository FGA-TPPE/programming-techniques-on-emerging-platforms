package com.tppe.tdd.patex;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.tppe.tdd.patex.Exceptions.DelimitadorInvalidoException;

public class Patex {
    private JFileChooser fc;
    File chosenFile;
    String delimiter;

    Patex(){
        this.fc = new JFileChooser();
        this.chosenFile = null;
        this.delimiter = null;
    }

    Patex(String pathToFile){
        this.fc = new JFileChooser();
        this.chosenFile = new File(pathToFile);
        this.delimiter = null;
    }

    Patex(String pathToFile, String delimiter){
        this.fc = new JFileChooser();
        this.chosenFile = new File(pathToFile);
        this.delimiter = delimiter;
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

    void chooseDelimiter() throws DelimitadorInvalidoException{
        if(this.delimiter == null){
            String result = JOptionPane.showInputDialog("Selecione o Delimitador utilizado entre os valores");
            this.delimiter = result;
        }
        if( this.delimiter.length()>2 ||
            this.delimiter.length() == 2 && !this.delimiter.startsWith("\\")
        )
            throw new DelimitadorInvalidoException("O Delimitador deve ser um caracter ou deve estar precedido do '\\' ");
        System.out.println(this.delimiter.length());
    }

    void start(){
        try {
            this.chooseFile();
            this.chooseDelimiter();
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "You must choose a file to continue");
        } catch (DelimitadorInvalidoException e){
            JOptionPane.showMessageDialog(null, "Invalid delimiter");
        } catch (Exception e) {
            System.out.println("Unexpected exception occurred");
        }
    }

    void stop(){
        JOptionPane.showMessageDialog(null, "Thank you for using Patex !");
    }

}
