package pl.pawel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AppStarter {
    static final int PERMITTED_SIZE = 5242880;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilenameGetter filenameGetter = new FilenameGetter(sc);
        FileLoader fileLoader = new FileLoader();
        String continueApp = "";
        System.out.println("Word counting application");
        while(!continueApp.equalsIgnoreCase("quit")){
            try{
                String filename = filenameGetter.getFilename(FilePurpose.LOAD);
                if(!checkSizeOk(filename)){
                    System.out.println("File is over 5MB!");
                    continue;
                }
                String textLine = fileLoader.loadFile(filename);
                //na ten moment łatwiej mi było użyć listy niż mapy
                List<Map.Entry<String, Integer>> result = WordCounter.countWords(textLine);
                ResultSaver.saveResultsToFile(result, filenameGetter.getFilename(FilePurpose.SAVE));
                System.out.println("Enter any key if you wish to process another file, \"quit\" ends program:");
                continueApp = sc.next();

            }catch (IOException ioe){
                System.err.println(ioe.getMessage());
            }
        }
    }
    public static boolean checkSizeOk(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        return Files.size(path) <= PERMITTED_SIZE;
    }
}
