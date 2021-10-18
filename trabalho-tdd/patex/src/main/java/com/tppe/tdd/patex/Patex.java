package com.tppe.tdd.patex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.tppe.tdd.patex.Exceptions.EscritaNãoPermitidaException;
import com.tppe.tdd.patex.Exceptions.DelimitadorInvalidoException;

public class Patex {
    private JFileChooser fc;
    File chosenFile;
    String delimiter;
    Object[] outputFormatchoices;
    Object userOutputFormatChoice;
    List<String> chosenFileLines;
    String outputPath;

    Patex(){
        this.fc = new JFileChooser();
        this.chosenFile = null;
        this.delimiter = null;
        this.userOutputFormatChoice = null;
        this.chosenFileLines = null;
        this.outputPath = null;
        this.setOutputFormatchoices();
    }

    Patex(String pathToFile){
        this.fc = new JFileChooser();
        this.chosenFile = new File(pathToFile);
        this.delimiter = null;
        this.userOutputFormatChoice = null;
        this.chosenFileLines = null;
        this.outputPath = null;
        this.setOutputFormatchoices();
    }

    Patex(String pathToFile, String delimiter){
        this.fc = new JFileChooser();
        this.chosenFile = new File(pathToFile);
        this.delimiter = delimiter;
        this.userOutputFormatChoice = null;
        this.chosenFileLines = null;
        this.outputPath = null;
        this.setOutputFormatchoices();
    }

    private void setOutputFormatchoices() {
        Object[] choices = {"Lines", "Columns"};
        this.outputFormatchoices = choices;
        return;
    }

    Boolean isFileChosen(){
        return this.chosenFile != null;
    }

    Boolean isChosenFileReadable() {
        return chosenFile.canRead();
    }

    Boolean readChosenFile() throws Exception {
        if(this.isFileChosen() && this.isChosenFileReadable()){
            this.chosenFileLines = Files.readAllLines(
                this.chosenFile.toPath().toAbsolutePath()
            );
            return true;
        }

        throw new Exception("File was not chosen or is not readable");
    }

    Boolean isOutputPathSet() {
        return this.outputPath != null;
    }

    Boolean isOutputFormatChosen() throws Exception {
        if(this.userOutputFormatChoice != null){
            boolean choiceMatches = false;
            for (Object choice : this.outputFormatchoices) {
                if(choice.toString().equals(
                    this.userOutputFormatChoice.toString()
                )){
                    choiceMatches = true;
                    break;
                }
            }
            if(choiceMatches)
                return true;

            throw new Exception("The chosen output format is invalid");
        }

        return false;
    }

    Boolean wasChosenFileRead() {
        return this.chosenFileLines != null;
    }

    private void parseLines(FileWriter outputFile) throws IOException {
        boolean wordBeforeWasNumber = false;
        outputFile.write("Evolution number" + this.delimiter + "value" + "\n");
        for (String word : this.chosenFileLines) {
            if(word.matches("(-)*[ Eevolucçãaotion]+(.)*")){
                String[] splitted = word.split(" ");
                String evolution = splitted[splitted.length - 2];
                outputFile.write("\n" + evolution + this.delimiter);
                wordBeforeWasNumber = false;
            }
            else if(word.matches("[0-9]+(\\.[0-9]+)?")){
                String sequence = wordBeforeWasNumber ?
                    (this.delimiter + word) : word;
                outputFile.write(sequence);
                wordBeforeWasNumber = true;
            }
        }
        outputFile.close();
        return;
    }

    private void parseColumns(FileWriter outputFile) {
        return;
    }

    Boolean writeToOutputFile() throws Exception {
        if(this.wasChosenFileRead() &&
            this.isOutputFormatChosen() &&
            this.isOutputPathSet()
        ){
            FileWriter outputFile = new FileWriter(this.outputPath, false);
            switch (this.userOutputFormatChoice.toString()) {
                case "Lines":
                    this.parseLines(outputFile);
                    break;

                case "Columns":
                    this.parseColumns(outputFile);
                    break;

                default:
                    break;
            }
            return true;
        }

        throw new Exception(
            "You must choose the path to save the output file before"
        );
    }

    Boolean choseOutputFormat() throws Exception {
        this.userOutputFormatChoice = JOptionPane.showInputDialog(null,
            "How do you want the output format to be like ?",
            "Select the output format",
            JOptionPane.QUESTION_MESSAGE,
            null,
            this.outputFormatchoices,
            this.outputFormatchoices[0]
        );
        if(this.userOutputFormatChoice == null){
            throw new Exception("You must choose an output format. Try again.");
        }

        return true;
    }

    String returnOutputPath() {
        return this.fc.getSelectedFile().getAbsolutePath();
    }
    String returnSelectedFileName() {
        return this.fc.getSelectedFile().getName();
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
            String result = JOptionPane.showInputDialog(
                "Inform the delimiter to separate characters"
            );
            this.delimiter = result;
        }
        if( this.delimiter.length()>2 || this.delimiter.length()<1 ||
            this.delimiter.length() == 2 && !this.delimiter.startsWith("\\")
        )
            throw new DelimitadorInvalidoException(
                "The delimiter must be a single character or\n" +
                "be preceded by '\\' "
            );
    }

    void OutputPathChoose() throws IOException,EscritaNãoPermitidaException {
        this.fc.setDialogTitle("Choose the path to save");
        //Set the filter extensions
        FileFilter filter = new FileNameExtensionFilter("OUT File","out");
        this.fc.setFileFilter(filter);
        //Set the output file name
        // System.out.println(this.chosenFile.getName());
        if(this.chosenFile.getName().equals("analysisMemory.out"))
            this.fc.setSelectedFile(new File("analysisMemoryTab.out"));
        if(this.chosenFile.getName().equals("analysisTime.out"))
            this.fc.setSelectedFile(new File("analysisTimeTab.out"));
        //Open SaveDialog
        this.fc.showSaveDialog(null);
        this.outputPath = this.fc.getSelectedFile().getAbsolutePath();
        if(!this.fc.getCurrentDirectory().canWrite()){
            JOptionPane.showMessageDialog(null,"Directory without write permission");
            throw new EscritaNãoPermitidaException("Directory without write permission") ;
        }
        return;
    }


    void start(){
        try {
            this.chooseFile();
            this.chooseDelimiter();
            this.OutputPathChoose();
            this.choseOutputFormat();
            this.readChosenFile();
            this.writeToOutputFile();
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "You must choose a file to continue");
        } catch (DelimitadorInvalidoException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (EscritaNãoPermitidaException e) {
            JOptionPane.showMessageDialog(null,"Directory without write permission");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Unexpected exception occurred - " + e.getMessage());
        }


    }

    void stop(){
        JOptionPane.showMessageDialog(null, "Thank you for using Patex !");
    }


}
