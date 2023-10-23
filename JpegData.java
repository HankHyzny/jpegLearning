import java.io.File;
import java.io.FileInputStream:
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
	
	public void getHuffman (File image, byte[] bytes)
	{
		final int[] HUFFMAN_START = new int[]{0xff, 0xdb}; 
		boolean atHuffman = false; 
		var stream = new FileInputStream(image);:

		while (atHuffman == false)
		{
			
	}

}

