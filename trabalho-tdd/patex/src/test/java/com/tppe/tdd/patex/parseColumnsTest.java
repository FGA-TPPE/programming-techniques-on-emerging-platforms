package com.tppe.tdd.patex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Test;

public class parseColumnsTest extends ChooseFile {
    private File testFile;

    parseColumnsTest(){
        super();
        this.testFile = new File("outputTest/OutputColmunsFormat.txt");
    }

    @Test()
    void testWriteToOutputFile() throws Exception {
        this.patexapp = new Patex("../analysisTime.out", ";");
        this.patexapp.userOutputFormatChoice = "Columns";
        this.patexapp.outputPath = this.testFile.getAbsolutePath();
        this.patexapp.readChosenFile();
        assertEquals(true, this.patexapp.writeToOutputFile());
    }
}
