import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class grep{
	public static void main(String[]  args){
		if(args.length<2){
			System.out.println("Usage: [document] document to search, [characters/word] tearch term, [-s] Case Sensitive");
		}
		try{
			File input = new File(args[0]); //import the file
			Scanner fileReader = new Scanner(input); //these could be one line but it looks cleaner this way
			String temp = null;
			while(fileReader.hasNextLine()){
				if(args.length>2 && args[2].toLowerCase().equals("-s")){ //the user has set the -s: Case Sensitive Flag
					temp = fileReader.nextLine();
					if(temp.contains(args[1])){
						System.out.println(temp);
					}
				}else if(args.length==2){ //The user did not set the flag
						temp = fileReader.nextLine();
						if(temp.toLowerCase().contains(args[1].toLowerCase()))
							System.out.println(temp);
				}else{//The user passed in something that the program is not expecting, thow an exception.
					throw new IllegalArgumentException("Usage: [Document] Path to document, [char/word] search term, [-s] Case Sensitive\nSearches a document for occurances of a given search term");
				}

			}
		}catch (IOException ex){
			System.out.println("Something went wrong: " + ex.getMessage());
		}catch (IllegalArgumentException ex){
			System.out.println(ex.getMessage());
		}
	}
}
