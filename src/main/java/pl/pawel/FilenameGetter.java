package pl.pawel;

import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class FilenameGetter {

    private Scanner sc;


    public String getFilename(FilePurpose purpose){
        if(purpose.equals(FilePurpose.LOAD)){
            System.out.println("Enter file name/path to process:");
        }else if(purpose.equals(FilePurpose.SAVE)){
            System.out.println("Enter file name/path to save results:");
        }
        return sc.next();
    }
}
