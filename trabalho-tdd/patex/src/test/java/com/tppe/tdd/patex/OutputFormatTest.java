package com.tppe.tdd.patex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OutputFormatTest extends AppTest {
    OutputFormatTest(){
        super();
    }

    @Test()
    void testOutputFormatChoosing() throws Exception{
        assertEquals(true, this.patexapp.choseOutputFormat());
    }
}
