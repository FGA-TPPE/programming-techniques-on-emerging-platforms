package com.tppe.tdd.patex;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import com.tppe.tdd.patex.Exceptions.EscritaNãoPermitidaException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OutputPathTest {
    
    private Patex patexapp;

    public OutputPathTest() {
        this.patexapp = new Patex();
    }
        
    @Test()
    void testOutputPathChoose(){
        try{
            patexapp.OutputPathChoose();
            assertNotNull(new File(patexapp.returnOutputPath()));

        }catch(IOException exception){

        }catch(EscritaNãoPermitidaException exception){}
    }

    @Test()
    void testDirectoryWritePermission(){
        assertThrows(EscritaNãoPermitidaException.class,() -> patexapp.OutputPathChoose());    
    }

}
