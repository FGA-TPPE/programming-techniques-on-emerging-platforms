package com.tppe.tdd.patex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Test;

public class WriteToOutuputFileTest extends ChooseFile {
    private File testFile;

    WriteToOutuputFileTest(){
        super();
        this.testFile = new File("outputTest/testFile.txt");
    }

    @Test()
    void testWriteToOutputFile() throws Exception {
        this.patexapp = new Patex("../analysisTime.out", ";");
        this.patexapp.userOutputFormatChoice = "Lines";
        this.patexapp.outputPath = this.testFile.getAbsolutePath();
        this.patexapp.readChosenFile();
        assertEquals(true, this.patexapp.writeToOutputFile());
    }

    @Test()
    void testWriteToOutputFile_2() throws Exception {
        this.patexapp = new Patex("../analysisMemory.out", ";");
        this.patexapp.userOutputFormatChoice = "Lines";
        this.patexapp.outputPath = this.testFile.getAbsolutePath();
        this.patexapp.readChosenFile();
        assertEquals(true, this.patexapp.writeToOutputFile());
    }
}
