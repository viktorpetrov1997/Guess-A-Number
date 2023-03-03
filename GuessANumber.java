package data.types.additional.projects;

import java.util.Random;
import java.util.Scanner;

public class GuessANumber
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Random randomNumber = new Random();
        int computerNumber = randomNumber.nextInt(100);

        int level = 1;
        int levelRange = 100;
        boolean isPlay = true;

        while(true)
        {
            System.out.print("Choose difficulty: ");
            String difficulty = scanner.nextLine();
            int numberOfTries = 0;
            int countTries = 0;
            if(difficulty.equals("Easy"))
            {
                numberOfTries = 20;
            }
            else if(difficulty.equals("Medium"))
            {
                numberOfTries = 15;
            }
            else if(difficulty.equals("Hard"))
            {
                numberOfTries = 10;
            }
            else
            {
                System.out.println("Invalid input.");
                continue;
            }

            while(true)
            {
                if(countTries == 0 && level == 1)
                {
                    System.out.println("Level #1");
                }
                else if(countTries == 0 && level > 1)
                {
                    System.out.printf("\nLevel #%d\n",level);
                }
                System.out.printf("Guess a number (1-%d): ",levelRange);
                String playerInput = scanner.nextLine();
                int playerNumber;
                boolean isValid = true;

                for(int i=0;i<playerInput.length();i++)
                {
                    if(playerInput.charAt(i) < 48 || playerInput.charAt(i) > 57)
                    {
                        isValid = false;
                        break;
                    }
                }

                if(isValid)
                {
                    playerNumber = Integer.parseInt(playerInput);
                    if(playerNumber == computerNumber)
                    {
                        System.out.println("You guessed it!\n");
                        ++level;
                        levelRange += 50;
                        countTries = 0;
                        computerNumber = randomNumber.nextInt(levelRange);
                        System.out.print("Do you want to play again? ");
                        String playAgain = scanner.nextLine();
                        if(playAgain.equals("Yes"))
                        {
                            continue;
                        }
                        else
                        {
                            isPlay = false;
                            break;
                        }
                    }
                    else if(playerNumber > computerNumber)
                    {
                        ++countTries;
                        System.out.println("Too High");
                    }
                    else
                    {
                        ++countTries;
                        System.out.println("Too Low");
                    }
                }
                else
                {
                    System.out.println("Invalid input.");
                }
                if(countTries == numberOfTries)
                {
                    System.out.println("\nYou've reached the maximum number of tries.\nGame Over!\n");
                    System.out.print("Do you want to play again? ");
                    String playAgain = scanner.nextLine();
                    System.out.println();
                    if(playAgain.equals("Yes"))
                    {
                        countTries = 0;
                        continue;
                    }
                    else
                    {
                        isPlay = false;
                        break;
                    }
                }
            }
            if(!isPlay) break;
        }
    }
}
