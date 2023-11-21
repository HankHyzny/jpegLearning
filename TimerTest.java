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

	public static void main(String[] args) {
		byte[] testData = new byte[10000];

		for (int i = 0; i < testData.length; i++) {
			testData[i] = (byte) (Math.random()* 256);
		}

		if (args[0].equals("old"))
		time(testData, 16, 'd', JpegData::log);
		else
		time(testData, 16, 'd', JpegData::betterLog);
		
	}


}
