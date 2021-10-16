package com.tppe.tdd.patex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ReadFileTest extends ChooseFile {
    ReadFileTest(){
        super();
    }

    @Test()
    void testFileWasRead() throws Exception {
        this.patexapp = new Patex("analysisTime.out");
        assertEquals(true, this.patexapp.readChosenFile());
    }
}
