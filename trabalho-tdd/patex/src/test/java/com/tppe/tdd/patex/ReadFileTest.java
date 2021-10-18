package com.tppe.tdd.patex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ReadFileTest extends ChooseFile {
    ReadFileTest(){
        super();
    }

    @Test()
    void testFileWasRead() throws Exception {
        this.patexapp = new Patex("../analysisMemory.out");
        assertEquals(true, this.patexapp.readChosenFile());
    }

    @Test()
    void testAnotherFileWasRead() throws Exception {
        this.patexapp = new Patex("../analysisTime.out");
        assertEquals(true, this.patexapp.readChosenFile());
    }

    @Test()
    void testExceptionIsThrownWhenFileDoesNotExist() throws Exception {
        this.patexapp = new Patex("../imaginaryFile.txt");
        assertThrows(Exception.class, () -> this.patexapp.readChosenFile());
    }
}
