package DataTypesAndVariables.AdditionalProjects;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class GuessANumber
{
    public static boolean doesThePlayerWantToPlayAgain()
    {
        Scanner scanner = new Scanner(System.in);
        boolean thePlayerWantsToPlayAgain;
        while(true)
        {
            System.out.print("Do you want to play again? (yes/y or no/n): ");
            String playAgain = scanner.nextLine();
            System.out.println();
            if(playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("y"))
            {
                thePlayerWantsToPlayAgain = true;
                break;
            }
            else if(playAgain.equalsIgnoreCase("no") || playAgain.equalsIgnoreCase("n"))
            {
                thePlayerWantsToPlayAgain = false;
                break;
            }
            else
            {
                System.out.println("Invalid input. Please try again...\n");
                continue;
            }
        }
        return thePlayerWantsToPlayAgain;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Random randomNumber = new Random();

        boolean playAgain = false;

        while(true)
        {
            System.out.print("Choose difficulty (Easy/Medium/Hard): ");
            String difficulty = scanner.nextLine();

            int numberOfTries = 0;
            int level = 1;
            int levelRange = 100;
            int computerNumber = randomNumber.nextInt(100);

            System.out.println();

            if(difficulty.equalsIgnoreCase("Easy"))
            {
                numberOfTries = 20;
            }
            else if(difficulty.equalsIgnoreCase("Medium"))
            {
                numberOfTries = 15;
            }
            else if(difficulty.equalsIgnoreCase("Hard"))
            {
                numberOfTries = 10;
            }
            else
            {
                System.out.println("Invalid input. Please try again...\n");
                continue;
            }

            int initialNumberOfTries = numberOfTries;

            while(true)
            {
                System.out.printf("Level #%d: \n", level);
                System.out.printf("Number of tries left: %d\n", numberOfTries);
                System.out.printf("Guess a number (1-%d): ", levelRange);
                String playerInput = scanner.nextLine();
                System.out.println();
                boolean isPlayerInputValid = true;

                for(int i = 0; i < playerInput.length(); i++)
                {
                    if(playerInput.charAt(i) < 48 || playerInput.charAt(i) > 57)
                    {
                        isPlayerInputValid = false;
                        break;
                    }
                }

                if(isPlayerInputValid)
                {
                    int playerNumber = Integer.parseInt(playerInput);
                    --numberOfTries;

                    if(playerNumber == computerNumber)
                    {
                        System.out.println("You guessed it!\n");
                        ++level;
                        levelRange += 10;
                        computerNumber = randomNumber.nextInt(levelRange);

                        playAgain = doesThePlayerWantToPlayAgain();
                        if(playAgain)
                        {
                            numberOfTries = initialNumberOfTries;
                            continue;
                        }
                        else
                        {
                            return;
                        }
                    }
                    else if(playerNumber > computerNumber)
                    {
                        System.out.println("Too High\n");
                    }
                    else
                    {
                        System.out.println("Too Low\n");
                    }

                    if(numberOfTries == 0)
                    {
                        System.out.println("You've reached the maximum number of tries.\nGame Over!\n");
                        playAgain = doesThePlayerWantToPlayAgain();
                        if(playAgain)
                        {
                            break;
                        }
                        else
                        {
                            return;
                        }
                    }
                }
                else
                {
                    System.out.println("Invalid input. Please try again...\n");
                    continue;
                }
            }
        }
    }
}
