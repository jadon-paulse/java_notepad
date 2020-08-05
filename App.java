package JavaNotepad;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner myInput = new Scanner(System.in);

        System.out.println("Enter a Filename you want too create 'C' or do you want to delete a file 'D': ");

        String choice = myInput.nextLine();

        if(choice.equals("C")) {

             System.out.println("Enter a Filename you want too create: ");
             //User chooses a filename 
            String fileName = myInput.nextLine();

             //Creates the filename
            File myObj = new File(fileName + ".txt");
            try{
            
                //Checks if file already exists
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
            String userInput = myInput.nextLine();

            try{
                FileWriter myWriter = new FileWriter(myObj, true);
                //User enters the text they want to save
                myWriter.write("\n" + userInput);
                myWriter.close();
                //When they are done and hit enter 
                // they will recieve a noitfication saying its saved
                System.out.println("Successfully wrote to the file. ");
            }
            catch (IOException e){
                System.out.println("An error occured");
                e.printStackTrace();
            }
        }
        else {
            //Enter the file you want too delete example: "Java.txt"
            System.out.println("Enter file you want to delete: ");

            String delete = myInput.nextLine();

            try{
                //Checks if the file you want too delete exists
                File f = new File(delete);
                if(f.delete()){
                    System.out.println(f.getName() + " deleted");
                }
                else{
                    System.out.println("Failed to delete");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}