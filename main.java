import java.io.*;
import java.util.*;

public class Main 
{ 
	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a file name in this directory or absolute file path: ");
		String userFile = input.nextLine();


		File image = new File(userFile);
		System.out.println("Can Read File: " + image.canRead());
		JpegData.fileInfo(image);
	}
}
