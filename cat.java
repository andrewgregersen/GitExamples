import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class cat{
	public static void main(String[] args){
		if(args.length==0){ //Check to see if the user has passed a file to the program
			System.out.println("Usage: [file path]");
		}
		//open the file
		try{
			File input = new File(args[0]);
			Scanner fileScanner = new Scanner(input);
			while(fileScanner.hasNextLine()){
				System.out.println(fileScanner.nextLine());
			}
		}catch (IOException ex){
			System.out.println("Something went wrong: " + ex.getMessage());
		}
	}
}
