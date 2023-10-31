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


	private static void compareBytes(byte[] first, byte[] second)
	{

	}

	//todo: implenent print byte array method with arguments: as hex, as binary, as decimal

	public static void fileInfo(File image) throws FileNotFoundException, IOException //no error handling for now
	{
		byte[] firstTwo = new byte[2];

		var stream = new FileInputStream(image);
		
		stream.read(firstTwo);
		
		for (int i = 0; i < firstTwo.length; i++)
		{
			System.out.print(firstTwo[i]);
			System.out.print(JPEG_START[i] + "\n");
		}

		System.out.println();

		if (firstTwo[0] == JPEG_START[0] && firstTwo[1] == JPEG_START[1]) //replace with compareBytes method
		{
			log("This is a jpeg file");
		}
		else
		{
			log("Nope. Not a jpeg file");
		}
		
		stream.close();
	}

	public static void getHuffman (File image, byte[] bytes) throws FileNotFoundException
	{
		 
		boolean atHuffman = false; 
		short lastTwo = 0;
		var stream = new FileInputStream(image);

		while (atHuffman == false)
		{
			
		}
	}

}

