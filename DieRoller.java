import java.util.*;

public class SimpleNumberGuesser
{
	public static void main( String[] args )
	{
		Scanner kbd = new Scanner(System.in);
		int secretNumber = (int) (Math.random() * 11 + 1);

		System.out.println( "I have chosen a number between 1 and 10. Try to guess it" );
		System.out.print( "Your guess: " );
		int userGuess = kbd.nextInt();

		while (   userGuess != secretNumber    )
		{
			System.out.println("That is incorrect. Try again.");
			userGuess = kbd.nextInt();
		}
		System.out.print("That's right! You're a good guesser");
	}
}


