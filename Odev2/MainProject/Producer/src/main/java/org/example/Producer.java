package org.example;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.SortedMap;

public class Producer {
    public static void main(String[] args) {
        createFile();
        System.out.println("Welcome");
        String score = getUserScore();
        writeFile(score);

        System.out.println("Hello world!");
    }
    public static String getUserScore(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter name of First Team");
        String firstTeam = userInput.nextLine();
        while (firstTeam.isEmpty()) {
            System.out.println("Please enter a string");
            firstTeam=userInput.nextLine();
        }

        System.out.println("Enter score of First Team");
        while (!userInput.hasNextInt()) {
            System.out.println("Please enter a number");
            userInput.next();
        }
        int scoreFirst= userInput.nextInt();
        System.out.println("Enter name of Second Team");
        userInput.nextLine();
        String secondTeam = userInput.nextLine();


        while (secondTeam.isEmpty()) {
            System.out.println("Please enter a string");
            secondTeam=userInput.nextLine();
        }
        System.out.println("Enter score of Second Team");

        while (!userInput.hasNextInt()) {
            System.out.println("Please enter a number");
            userInput.next();
        }
        int scoreSecond= userInput.nextInt();
        String result= firstTeam +" " +String.valueOf(scoreFirst)+"-"+String.valueOf(scoreSecond)+" "+ secondTeam;
        return result;

    }
    public static void createFile() {
        try {
            File myObj = new File("score.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void writeFile(String sentence){
        try {
            FileWriter myWriter = new FileWriter("score.txt");
            myWriter.write(sentence);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
