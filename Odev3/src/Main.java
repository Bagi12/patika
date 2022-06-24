import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.SortedMap;

public class Main   {
    public static void main(String[] args) {

        createFile();

        Main obj = new Main();
        Thread producer = new Thread(new Runnable(){
            public void run() {
                System.out.println("Welcome");
                String score = getUserScore();
                writeFile(score);

            }

        });
        Thread consumer = new Thread(new Runnable(){
            public void run() {
                String result=readFile();
                System.out.println(result);

            }

        });
        producer.start();
        try{

            producer.join();
        }

        catch(Exception ex)
        {
            System.out.println("Exception has " +
                    "been caught" + ex);
        }
        consumer.start();
        try{

            consumer.join();
        }

        catch(Exception ex)
        {
            System.out.println("Exception has " +
                    "been caught" + ex);
        }


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



