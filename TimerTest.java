import java.io.FileInputStream;
import java.io.*;
import java.util.*;

interface TimeTest {
	void run(byte[] data, int len, char arg);
}

public class TimerTest
{

	public static void time(byte[] data, int len, char arg, TimeTest function)
	{
		long start = System.currentTimeMillis();
		function.run(data, len, arg);
		long end = System.currentTimeMillis();

		System.out.println("Time elapsed: " + (end - start));
	}

	public static void main(String[] args) throws FileNotFoundException, IOException{

		var file = new File(args[0]);

		var stream = new FileInputStream(file);
		
		byte[] bytes = new byte[(int)file.length()];

		stream.read(bytes);

		time(bytes, Integer.decode(args[1]), args[2].toCharArray()[0], JpegData::log);
		System.out.println("File is: " + file.length() + " bytes");
		stream.close();
	}


}
