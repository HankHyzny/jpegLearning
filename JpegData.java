//package jpegLearning.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.*; 
import java.util.Scanner;
//The explicitly declared will be what I use, the wildcard is because I forget the
//name of the exceptions

public class JpegData
{
	//This class will be used to retrieve the various types of data inside
	//of JPEG files and provide the byte arrays to other classes and functions
	//
	//This might be a bad design choice, maybe I'll shove all of this into the 
	//Other classes
	//

	private final  static byte[] HUFFMAN_START = new byte[]{ (byte)0xff, (byte)0xc4}; 
	private final static byte[] JPEG_START = new byte[]{ (byte)0xff, (byte)0xd8};


	private static void log(String text) 
	{

		System.out.print(text);

	}
	private static void log(byte[] data, char arg)
	{
		log(data, arg, 8);
	}

	private static void log(byte[] data, char arg, int len)
	{
		arg =  (char) ((int) arg | 0b0000000000100000);			//convert arg to lowercose
		String output = "";

		switch (arg)
		{
			case 'b' :
				for (int i = 0; i < data.length; i ++)
				{
					output += (data[i] & 0b10000000) == 0b10000000 ? "1" : "0";	//inefficient, probably better ways built into the language
					output += (data[i] & 0b01000000) == 0b01000000 ? "1" : "0";	//for example: new string allocated every line
					output += (data[i] & 0b00100000) == 0b00100000 ? "1" : "0"; //String builder? Thats something
					output += (data[i] & 0b00010000) == 0b00010000 ? "1" : "0";
					output += (data[i] & 0b00001000) == 0b00001000 ? "1" : "0";
					output += (data[i] & 0b00000100) == 0b00000100 ? "1" : "0";
					output += (data[i] & 0b00000010) == 0b00000010 ? "1" : "0";
					output += (data[i] & 0b00000001) == 0b00000001 ? "1" : "0";
					
					output += " ";

				}
				break;

			case 'x' :														
																	
					for (int i = 0; i < data.length; i++)
					{
						if ( ( (data[i] & 0xff) >>> 4) < 10)
						{
							output += "" + ( (data[i] & 0xff) >>> 4);
						}
						else
						{
							output += (char) (0b01000000 +((byte) ((data[i] & 0xff) >>> 4) - 9 ) ); //why does java mess with my bytes when byte shifting
						}																			//dont make my bytes an int!!! 
																									//(even though ints are really all computer handle nowadays...
						if ( (data[i] & 0b00001111) < 10)											//and floats. and doubles. Computers are big
							output += "" + (data[i] & 0b00001111);
						else
						{
							output += (char) (0b01000000 + ( (data[i] & 0b00001111) - 9) );
						}

						output += " ";
					}
					break;
					
			case 'd' : 

					for (int i = 0; i < data.length; i++)
					{
						if (data[i] < 0)
							output += "" + (data[i] + 256);
						else
							output += data[i];
						output += " ";
					}

		}

		int width = output.indexOf(" ") + 1; // + 1 because that makes the spacing work
		for (int i = 0; i< (output.length() / (width*len)); i++)
		{
			System.out.println(output.substring( width * i * len, width * (i+1) * len));
		}

			int lastFew = output.length() / (width * len); // this is always perfect I think

			System.out.println(output.substring(lastFew * width * len));

					
	}


	private static boolean compareBytes(byte[] first, byte[] second)
	{

		if (first.length != second.length)
		{
			return false;
		}
		else
		{
			boolean isEqual = true;
			
			for (int i = 0; (i < first.length) && isEqual; i++)
			{
				isEqual = (first[i] == second[i]) && isEqual;

			}
			return isEqual;
		}
	}

	public static boolean isJpeg (File image, boolean verbose) throws FileNotFoundException, IOException //no error handling for now
	{
		byte[] firstTwo = new byte[2];

		var stream = new FileInputStream(image);
		
		stream.read(firstTwo);
		
		System.out.println();

		stream.close();

		if (compareBytes(firstTwo, JPEG_START))
		{
			if (verbose)
				System.out.println("Jpeg File: YES");
			return true;
		}
		else
		{
			if (verbose)
				System.out.println("Jepg File: NO");
			return false;
		}
		
	}

	public static boolean isJpeg (File image) throws FileNotFoundException, IOException
	{
		return isJpeg(image, false); //is there a better way to do verbosity arguments?
									 //Maybe make a log method w/ verbosity parameter
	}
	
	public static int getHuffman (File image, byte[] bytes) throws FileNotFoundException
	{
		 
		boolean atHuffman = false; 
		short lastTwo = 0;
		var stream = new FileInputStream(image);

		while (atHuffman == false)
		{
			
		}

		return 1;
	}

	public static void main(String[] args) // main function for testing
	{

		byte[] test = {(byte) 0xab, (byte) 0xcd, (byte) 0xef, 0, 1, 127, (byte) 128, (byte) 255, (byte) 0x80, (byte) 0x88};

		log(test, 'b' );
		log(test, 'x');
		log(test, 'd');
	}
}

