//package jpegLearning.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.*; 
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

	public static void log(byte[] data, char arg)
	{
		log(data, 8, arg);
	}

	public static void log(byte[] data, int len, char arg)
	{

		arg =  (char) ((int) arg | 0b0000000000100000);			//convert arg to lowercose
		char[] output;
		switch (arg)
		{
			case 'b' :
				output = new char[8];
				for (int i = 0; i < data.length; i++)
				{
					output[0] = (data[i] & 0b10000000) == 0b10000000 ? '1' : '0'; //char arrays are much faster than Strings
					output[1] = (data[i] & 0b01000000) == 0b01000000 ? '1' : '0'; //This can go through one meg of random data
					output[2] = (data[i] & 0b00100000) == 0b00100000 ? '1' : '0'; //in like 60 millis without the print statement
					output[3] = (data[i] & 0b00010000) == 0b00010000 ? '1' : '0'; //and like some seconds with the prints
					output[4] = (data[i] & 0b00001000) == 0b00001000 ? '1' : '0'; //its like O(logn) or less
					output[5] = (data[i] & 0b00000100) == 0b00000100 ? '1' : '0'; //but for small n its not that big a difference
					output[6] = (data[i] & 0b00000010) == 0b00000010 ? '1' : '0';
					output[7] = (data[i] & 0b00000001) == 0b00000001 ? '1' : '0';

					System.out.print(String.valueOf(output) + " ");
					if (( i+1) % len == 0)
						System.out.println();
				}
				break;

			case 'x' :														

				output = new char[2];											

				for (int i = 0; i < data.length; i++)
				{
					if ( ( (data[i] & 0xff) >>> 4) < 10)
					{
						output[0] =  (char) (0x30 + ( (data[i] & 0xff) >>> 4));
					}
					else
					{
						output[0] = (char) (0b01000000 +((byte) ((data[i] & 0xff) >>> 4) - 9 ) ); //why does java mess with my bytes when byte shifting
					}																			//dont make my bytes an int!!! 
																								//(even though ints are really all computer handle nowadays...
					if ( (data[i] & 0b00001111) < 10)											//and floats. and doubles. Computers are big
						output[1] = (char) (0x30 + (data[i] & 0b00001111));
					else
					{
						output[1] = (char) (0b01000000 + ( (data[i] & 0b00001111) - 9) );		//I love magic numbers :]
					}

					System.out.print(String.valueOf(output) + " ");
					if (( i+1) % len == 0)
						System.out.println();
				}
				break;
					
			case 'd' : 
					output = new char[3];

					for (int i = 0; i < data.length; i++)
					{
						output[0] =(char) (0x30 + ((data[i]+128) / 100));						//Know what I love more than magic numbers?
						output[1] =(char) (0x30 + (((data[i]+128) / 10) % 10));					//Equivalent but inconsitently represented
						output[2] =(char) (0x30 + ((data[i]+128) % 10));						//magic numbers!
						System.out.print(String.valueOf(output) + " ");
						if ( (i+1) % len == 0)
							System.out.println();
					}
					break;

		}
		
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

}

