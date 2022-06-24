package org.example;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.SortedMap;

public class Consumer {
    public static void main(String[] args) {

        String result=readFile();
        System.out.println(result);
    }
    public static String readFile(){
        String data= "asd";
        try {
            File myObj = new File("score.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }
}