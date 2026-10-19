import java.util.Scanner;
import java.util.Random;

public class CrapsGame {
    static void main()
    {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        int die1 = 0;
        int die2 = 0;
        int crapsRoll = 0;
        int point = 0;

        String playAgain = "";
        boolean done = false;
        boolean gameOver = false;

        do{
            die1 = rnd.nextInt(6) + 1;
            die2 = rnd.nextInt(6) + 1;
            crapsRoll = die1 + die2;

            IO.println("\nDie 1: " + die1);
            IO.println("Die 2: " + die2);
            IO.println("Sum: " + crapsRoll);

            if(crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12)
            {
                IO.println("Craps! You crapped out and lost.");
            }
            else if(crapsRoll == 7 || crapsRoll == 11)
            {
                IO.println("Natural! You won!");
            }
            else
            {
                point = crapsRoll;
                gameOver = false;

                IO.println("The point is: " + point);

                while(!gameOver)
                {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    crapsRoll = die1 + die2;

                    IO.println("\nDie 1: " + die1);
                    IO.println("Die 2: " + die2);
                    IO.println("Sum: " + crapsRoll);

                    if(crapsRoll == point)
                    {
                        IO.println("Made point and won!");
                        gameOver = true;
                    }
                    else if(crapsRoll == 7)
                    {
                        IO.println("Got a seven and lost!");
                        gameOver = true;
                    }
                    else
                    {
                        IO.println("Trying for point..");
                    }
                }
            }

            done = false;

            do{
                IO.print("\nWould you like to play again? (Y/N): ");
                playAgain = in.nextLine();

                if(playAgain.equalsIgnoreCase("Y") || playAgain.equalsIgnoreCase("N"))
                {
                    done = true;
                }
                else
                {
                    IO.println("You must enter Y or N, not: " + playAgain + "\nTry again!");
                }
            }while(!done);

        }while(playAgain.equalsIgnoreCase("Y"));

        IO.println("Thanks for playing!");
    }
}
