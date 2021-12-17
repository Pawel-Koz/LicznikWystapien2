package pl.pawel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ResultSaver {
    public static void saveResultsToFile(List<Map.Entry<String, Integer>> result , String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, Integer> entry : result) {
                bw.write(entry.getKey() + " - " + entry.getValue() + ",");
                bw.newLine();
            }
            System.out.println(String.format("Dane zapisane w " + fileName));
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

    }
}
