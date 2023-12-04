import java.io.FileInputStream;
import java.io.*;
import java.util.*;

interface TimeTest {
	void run(byte[] bytes, int len, char arg);
}

public class TimerTest
{

	public static void time(TimeTest function, Object... args)
	{
		

		long start = System.currentTimeMillis();
		function.run((byte[]) args[0], (Integer) args[1], (Character) args[2]);
		long end = System.currentTimeMillis();

		System.out.println("Time elapsed: " + (end - start));
	}

	public static void main(String[] args) throws FileNotFoundException, IOException{

		var file = new File(args[0]);

		var stream = new FileInputStream(file);

		byte[] bytes = new byte[(int)file.length()];

		stream.read(bytes);

		Object[] defaultArgs = {bytes, 16, 'x'};

		if (args.length == 3)
		{
			defaultArgs[0] = bytes;
			defaultArgs[1] = Integer.decode(args[1]);
			defaultArgs[2] = args[2].toCharArray()[0];
		}

		time(JpegData::log, defaultArgs);
		System.out.println("File is: " + file.length() + " bytes");
		stream.close();
	}


}
