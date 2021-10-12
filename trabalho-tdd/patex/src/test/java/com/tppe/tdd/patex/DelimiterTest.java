package com.tppe.tdd.patex;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DelimiterTest {
    
    private Patex patexapp;

    public DelimiterTest() {
        this.patexapp = new Patex();
    }
    
    @Test()
    void testDelimiterChoosing() throws FileNotFoundException {
        
        assertEquals(";",this.patexapp.chooseDelimiter());
    }
    
}
