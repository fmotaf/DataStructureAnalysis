package test;

import main.CSVReader;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TestCSVReader {

    @Test
    void testReadCSV() throws IOException {
        File tempFile = File.createTempFile("test", ".csv");
        try (PrintWriter pw = new PrintWriter(tempFile)) {
            pw.println("a,b,c");
            pw.println("1,2,3");
        }

        List<String[]> data = CSVReader.readCSV(tempFile.getAbsolutePath(), 10);

        assertEquals(2, data.size());
        assertArrayEquals(new String[]{"a", "b", "c"}, data.get(0));
        assertArrayEquals(new String[]{"1", "2", "3"}, data.get(1));

        tempFile.delete();
    }
}