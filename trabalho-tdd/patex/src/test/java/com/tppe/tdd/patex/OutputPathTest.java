package com.tppe.tdd.patex;

import org.junit.jupiter.api.Test;
import java.io.File;
import com.tppe.tdd.patex.Exceptions.EscritaNãoPermitidaException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OutputPathTest extends Patex {

    public OutputPathTest() {
        super();
        this.delimiter = ";";
    }


    @Test()
    void testDirectoryWritePermission(){
        /* For this test to work, when the dialog pops up you need to hit
        any button */
        assertThrows(EscritaNãoPermitidaException.class,() -> {
            this.chosenFile = new File("../analysisTime.out");
            this.fc.setCurrentDirectory(new File("/"));
            this.OutputPathChoose();
        });
    }

    @Test()
    void testFileExtension(){
        try{
            this.outputPath = "../analysisMemory.out";
            File file =new File(this.outputPath);
            assertTrue(file.getName().endsWith(".out"));
        }catch(Exception ex){ }

    }

    @Test()
    void testFileNameAnalysisMemoryTab(){
            try{
                this.chosenFile =new File("../analysisMemory.out");
                this.fc.setSelectedFile(this.chosenFile);
                assertEquals("analysisMemory.out", this.returnSelectedFileName() );
            }catch(Exception ex){}
    }
    @Test()
    void testFileNameAnalysisTimeTab(){
        try{
            this.chosenFile =new File("../analysisTime.out");
            this.fc.setSelectedFile(this.chosenFile);
            assertEquals("analysisTime.out", this.returnSelectedFileName() );
        }catch(Exception ex){}
    }
}
