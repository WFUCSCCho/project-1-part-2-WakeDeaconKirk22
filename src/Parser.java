
/***************************************************************************
 @file: Parser.java
 @description: This program implements a parser that reads a series of commands
 line by line while also writing to the file the commands tested for BST.
 @author:  Kennedy Kirk
 @date  September 18,2024

 *******************************************************************************/
import java.io.*;
import java.util.Scanner;

public class Parser {

    // Create a BST tree of your class type (Note: Replace "Object" with your class type)
    public BST<NBAPlayer> myBST = new BST<>();

    public Parser(String filename) throws FileNotFoundException {
        process(new File(filename));
    }

    // Implement the process method
    // Remove redundant spaces for each input command

    public void process(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input); // scan in to read each lne
        //String[] line = new String[2];
        scanner.nextLine();
        while (scanner.hasNext()) { // read each line in file

            String temp = scanner.nextLine();

            if(!temp.isEmpty()) { //checking if the line not empty then do operation

                String[] parts = temp.split(","); // split the string into multiple parts


                //call operate_BST method;
                operate_BST(parts);
            }


        }

    }



    public void operate_BST(String[] command) {

//Calls the NBAPlay object and sets the commands
            NBAPlayer player = new NBAPlayer
                    (

                            Integer.parseInt(command[0]), // id
                            command[1],//name
                            command[2], // team
                            Double.parseDouble(command[3]), // age
                            Double.parseDouble(command[4]), // player height
                            Double.parseDouble(command[5]), // player weight
                            command[6], // college name
                            command[7], // country name
                            command[8], // draft year
                            command[9], // draft round
                            command[10], // draft number
                            command[11], // games played (gp)
                            Double.parseDouble(command[12]), // points
                            Double.parseDouble(command[13]), // rebounds
                            Double.parseDouble(command[14]), // assists
                            Double.parseDouble(command[15]), // net rating
                            Double.parseDouble(command[16]), // offensive rebound percentage
                            Double.parseDouble(command[17]), // defensive rebound percentage
                            Double.parseDouble(command[18]), // usage percentage
                            Double.parseDouble(command[19]), // assist percentage
                            Double.parseDouble(command[20]),
                            command[21]); //seasons
//calls myBST to insert player object and write to the file
            myBST.insert(player);
            writeToFile("Inserted " + player.toString(), "./result.txt");

        }





    // Implement the operate_BST method
    // Determine the incoming command and operate on the BST


    // Implement the writeToFile method
    // Generate the result file
    public void writeToFile(String content, String filePath) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filePath, true))) {
            printWriter.println(content);
        } catch (IOException e) {
            System.out.println("Error found while writing" + e.getMessage());
        }

    }
}




