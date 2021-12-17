package pl.pawel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {
    public String loadFile(String filename){
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            StringBuilder sb = new StringBuilder();
            String textLine;
            while ((textLine = br.readLine()) != null) {
                sb.append(textLine);
                sb.append(System.getProperty("line.separator"));
            }
            return sb.toString();
        }catch (IOException ioe){
            System.err.println(ioe.getMessage());
        }
        throw new NullPointerException();
    }
}
