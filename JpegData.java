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
	
	private String fileName;
	private String filePath;
	private int fileSize;
	private final  static byte[] HUFFMAN_START = new byte[]{ (byte)0xff, (byte)0xc4}; 
	private final static byte[] JPEG_START = new byte[]{ (byte)0xff, (byte)0xd8};


	private static void log(String text) //maybe enhance or replace w/ other
	{
		System.out.print(text);
	}


	private static boolean compareBytes(byte[] first, byte[] second)
	{

		if (first.length != second.length)
		{
			log("ERROR: arrays of unequal size");
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

	//todo: implenent print byte array method with arguments: as hex, as binary, as decimal

	public static boolean isJpeg (File image) throws FileNotFoundException, IOException //no error handling for now
	{
		byte[] firstTwo = new byte[2];

		var stream = new FileInputStream(image);
		
		stream.read(firstTwo);
		
		System.out.println();

		stream.close();

		if (compareBytes(firstTwo, JPEG_START))
		{
			log("This is a jpeg file");
			return true;
		}
		else
		{
			log("Nope. Not a jpeg file");
			return false;
		}
		
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

