package JavaNotepad;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner myInput = new Scanner(System.in);
        File myObj = new File("Notes.txt");
        try{
            
            if(myObj.createNewFile()){
                System.out.println("File created: " + myObj.getName());
            }
            else{
                System.out.println("File already exists");
            }
        }
        catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Enter Note");
        String steve = myInput.nextLine();

        try{
            FileWriter myWriter = new FileWriter(myObj, true);
            myWriter.write("\n" + steve);
            myWriter.close();
            System.out.println("Successfully wrote to the file. ");
        }
        catch (IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}