package com.tppe.tdd.patex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Test;

public class WriteToOutuputFileTest extends ChooseFile {
    private File testFile;

    WriteToOutuputFileTest(){
        super();
        this.testFile = new File("../outputTest/testFile.txt");
    }

    @Test()
    void testWriteToOutputFile() throws Exception {
        this.patexapp.outputPath = this.testFile.getAbsolutePath();
        assertEquals(true, this.patexapp.writeToOutputFile());
    }
}
