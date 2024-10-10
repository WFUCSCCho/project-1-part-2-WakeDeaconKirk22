/***************************************************************************
 @file: Proj1.java
 @description: This program is the main function.
 @author:  Kennedy Kirk
 @date  September 18,2024
// hello
 *******************************************************************************/
import java.io.FileNotFoundException;

public class Proj1 {
    public static void main(String[] args) throws FileNotFoundException{
        if(args.length != 1){
            System.err.println("Argument count is invalid: " + args.length);
            System.exit(0);
        }
        new Parser(args[0]);
    }
}