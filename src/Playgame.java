import java.util.Scanner;

public class Playgame {
    private String language;
    Dices dices = new Dices();

    public void startgame() {

        System.out.println(" Welcome to the game! Please choose a language \n " +
                "Velkommen til spillet! Vælg venligst et sprog");

        Scanner scanner = new Scanner(System.in);
        System.out.println(" For English please type 'en' / For dansk skriv venligst 'dk': ");
        language = scanner.next();

        while (!language.equals("en") && !language.equals("dk")) {
            System.out.println("Please choose 'en' or 'dk' ");
            language = scanner.next();
        }
        switch (language) {
            case "en":
                System.out.println("You have choosen english");
                language = "en";
                break;
            case "dk":
                System.out.println("Du har valgt dansk");
                language = "dk";
                break;
            default:
        }

        Player player1 = new Player();
        Player player2 = new Player();
        if (language.equals("dk")) {
            System.out.println(" Indtast venligst spillerens navn for at starte spillet!");
            System.out.println(" Spiller 1:");
            player1.name = scanner.next();
            System.out.println(" Spiller 2:");
            player2.name = scanner.next();
        }
        if (language.equals("en")) {
            System.out.println(" Please enter name of player to start game!");
            System.out.println(" Player 1:");
            player1.name = scanner.next();
            System.out.println(" Player 2:");
            player2.name = scanner.next();
        }
        Player currentplayer = null;

        play(currentplayer, player1, player2);
    }


    public void play(Player currentplayer, Player player1, Player player2) {
        boolean ingame = true;

        while (ingame) {
            Scanner scanner = new Scanner(System.in);
            if (language.equals("en")) {
                System.out.println("Press enter to roll");
            }
            if (language.equals("dk")) {
                System.out.println("Tryk på enter for at rulle");
            }
            currentplayer = findnextplayer(currentplayer, player1, player2);
            currentplayer.getmoreturn = false;
            String key = scanner.nextLine();
            rolldicesandgetresult(currentplayer);
            if (endgame(currentplayer)) {

                    if (language.equals("en")) {
                        System.out.println("Congratulations " + currentplayer.getName() + " wins");
                        ingame = false;
                        break;
                    }
                    if (language.equals("dk")) {
                        System.out.println(" Tillyke" + currentplayer.getName() + " vinder");
                        ingame = false;
                        break;
                    }
                    break;

        }

    }

}

    public static Player findnextplayer(Player currentplayer, Player player1, Player player2) {
        if (currentplayer == null) {
            return player1;
        }
        if (currentplayer.getmoreturn)
            return currentplayer;

        return currentplayer == player1 ? player2 : player1;

    }

    public void rolldicesandgetresult(Player currentplayer) {
        final String TEXT_RESET = "\u001B[0m";
        final String TEXT_RED = "\u001B[31m";
        final String RED_BOLD = "\033[1;91m";
        final String TEXT_BLUE = "\u001B[34m";
        final String BLUE_BOLD = "\033[1;94m";
        final String GREEN_BOLD = "\033[1;92m";

        int Result = dices.roll();
        if (language.equals("en")) {
            System.out.println(TEXT_RESET + " Points is : " + TEXT_RED + Result);
        }
        if (language.equals("dk")) {
            System.out.println(TEXT_RESET + " Points er : " + TEXT_RED + Result);
        }

        switch (Result) {
            case 2:
                currentplayer.setMoney(currentplayer.getMoney() + 250);
                if (language.equals("en")) {
                    System.out.println("Congrats you entered the tower and earn 250");
                    System.out.println(TEXT_RESET + "Current money of " + GREEN_BOLD + currentplayer.getName() + TEXT_RESET + " is " + TEXT_BLUE + currentplayer.getMoney());
                }
                if (language.equals("dk")) {
                    System.out.println("Tillykke du kom en tur i tårnet og tjente 250");
                    System.out.println(GREEN_BOLD + currentplayer.getName() + TEXT_RESET + "s nuværende beløb er " + TEXT_BLUE + currentplayer.getMoney());
                }
                break;
            case 3:
                currentplayer.setMoney(currentplayer.getMoney() - 100);
                if (language.equals("en")) {
                    System.out.println("You fell in the Crater and lost 100");
                    System.out.println(TEXT_RESET + "Current money of " + GREEN_BOLD + currentplayer.getName() + TEXT_RESET + " is " + TEXT_BLUE + currentplayer.getMoney());
                }
                if (language.equals("dk")) {
                    System.out.println("Du faldt i Crater og taber 100");
                    System.out.println(GREEN_BOLD + currentplayer.getName() + TEXT_RESET + "s nuværende beløb er " + TEXT_BLUE + currentplayer.getMoney());
                }

                break;
            case 4:
                currentplayer.setMoney(currentplayer.getMoney() + 100);
                if (language.equals("en")) {
                    System.out.println("You arrived to the Palace gates and earned 100");
                    System.out.println(TEXT_RESET + "Current money of " + GREEN_BOLD + currentplayer.getName() + TEXT_RESET + " is " + TEXT_BLUE + currentplayer.getMoney());

                }
                if (language.equals("dk")) {
                    System.out.println("Du ankom til portene ved Paladset og tjente 100");
                    System.out.println(GREEN_BOLD + currentplayer.getName() + TEXT_RESET + "s nuværende beløb er " + TEXT_BLUE + currentplayer.getMoney());
                }

                break;
            case 5:
                currentplayer.setMoney(currentplayer.getMoney() - 20);
                if (language.equals("en")) {
                    System.out.println("You arrived to the Cold dessert you lost 20");
                    System.out.println(TEXT_RESET + "Current money of " + GREEN_BOLD + currentplayer.getName() + TEXT_RESET + " is " + TEXT_BLUE + currentplayer.getMoney());
                }
                if (language.equals("dk")) {
                    System.out.println("Du ankom til den kolde ørken og tabte 20");
                    System.out.println(GREEN_BOLD + currentplayer.getName() + TEXT_RESET + "s nuværende beløb er " + TEXT_BLUE + currentplayer.getMoney());
                }

                break;
            case 6:
                currentplayer.setMoney(currentplayer.getMoney() + 180);
                if (language.equals("en")) {
                    System.out.println("You arrive to the Walled city and recieve 180");
                    System.out.println(TEXT_RESET + "Current money of " + GREEN_BOLD + currentplayer.getName() + TEXT_RESET + " is " + TEXT_BLUE + currentplayer.getMoney());
                }
                if (language.equals("dk")) {
                    System.out.println("Du ankom til den befæstede by og modtager 180");
                    System.out.println(GREEN_BOLD + currentplayer.getName() + TEXT_RESET + "s nuværende beløb er " + TEXT_BLUE + currentplayer.getMoney());
                }

                break;
            case 7:
                if (language.equals("en")) {
                    System.out.println("You arrived to the Monastery and get to sleep for free");
                    System.out.println(TEXT_RESET + "Current money of " + GREEN_BOLD + currentplayer.getName() + TEXT_RESET + " is " + TEXT_BLUE + currentplayer.getMoney());
                }
                if (language.equals("dk")) {
                    System.out.println("Du ankommer til klosteret og du får lov at overnatte gratis");
                    System.out.println(GREEN_BOLD + currentplayer.getName() + TEXT_RESET + "s nuværende beløb er " + TEXT_BLUE + currentplayer.getMoney());
                }

                break;
            case 8:
                currentplayer.setMoney(currentplayer.getMoney() - 70);
                if (language.equals("en")) {
                    System.out.println("You hit the black cave and lost 70");
                    System.out.println(TEXT_RESET + "Current money of " + GREEN_BOLD + currentplayer.getName() + TEXT_RESET + " is " + TEXT_BLUE + currentplayer.getMoney());
                }
                if (language.equals("dk")) {
                    System.out.println("Du faldt i den sorte hule og tabte 70");
                    System.out.println(GREEN_BOLD + currentplayer.getName() + TEXT_RESET + "s nuværende beløb er " + TEXT_BLUE + currentplayer.getMoney());
                }

                break;
            case 9:
                currentplayer.setMoney(currentplayer.getMoney() + 60);
                if (language.equals("en")) {
                    System.out.println("You arrive for the huts in the mountains and recieve 60");
                    System.out.println(TEXT_RESET + "Current money of " + GREEN_BOLD + currentplayer.getName() + TEXT_RESET + " is " + TEXT_BLUE + currentplayer.getMoney());
                }
                if (language.equals("dk")) {
                    System.out.println("Du ankom til hytten på bjerget og modtager 60");
                    System.out.println(GREEN_BOLD + currentplayer.getName() + TEXT_RESET + "s nuværende beløb er " + TEXT_BLUE + currentplayer.getMoney());
                }

                break;
            case 10:
                currentplayer.setMoney(currentplayer.getMoney() - 80);
                currentplayer.getmoreturn = true;
                if (language.equals("en")) {
                    System.out.println("You arrived to the werewolf wall, and lost 80, but you get a extra roll");
                    System.out.println(TEXT_RESET + "Current money of " + GREEN_BOLD + currentplayer.getName() + TEXT_RESET + " is " + TEXT_BLUE + currentplayer.getMoney());
                }
                if (language.equals("dk")) {
                    System.out.println("du ankom til vareulve væggen og taber 80, men du får et ekstra slag.");
                    System.out.println(GREEN_BOLD + currentplayer.getName() + TEXT_RESET + "s nuværende beløb er " + TEXT_BLUE + currentplayer.getMoney());
                }


            case 11:
                currentplayer.setMoney(currentplayer.getMoney() - 50);
                if (language.equals("en")) {
                    System.out.println("You arrive at the pit and lose 50");
                    System.out.println(TEXT_RESET + "Current money of " + GREEN_BOLD + currentplayer.getName() + TEXT_RESET + " is " + TEXT_BLUE + currentplayer.getMoney());
                }
                if (language.equals("dk")) {
                    System.out.println("Du ankom til hullet og taber 50");
                    System.out.println(GREEN_BOLD + currentplayer.getName() + TEXT_RESET + "s nuværende beløb er " + TEXT_BLUE + currentplayer.getMoney());
                }

                break;
            case 12:
                currentplayer.setMoney(currentplayer.getMoney() + 650);
                if (language.equals("en")) {
                    System.out.println("You just landed on the goldmine, congrats you are rich! +650 for you");
                    System.out.println(TEXT_RESET + "Current money of " + GREEN_BOLD + currentplayer.getName() + TEXT_RESET + " is " + TEXT_BLUE + currentplayer.getMoney());
                }
                if (language.equals("dk")) {
                    System.out.println("Tillykke! Du er lige blevet rig, du landede på guldminen og tjente 650");
                    System.out.println(GREEN_BOLD + currentplayer.getName() + TEXT_RESET + "s nuværende beløb er " + TEXT_BLUE + currentplayer.getMoney());
                }

                break;

        }


    }

    public static boolean endgame(Player currentplayer) {

        if (currentplayer.getMoney() >= 3000) {
            return true;
        }
        if (currentplayer.getMoney() <= 0) {
            return true;
        }
        return false;
    }
}


