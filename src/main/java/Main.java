import java.util.*;
public class Main {
    public static String determineResult(int playerTotal,int dealerTotal) {
        // TODO 11: Return "wins", "loses", or "push".
        // Player busts lose; dealer busts mean surviving players win; ties push.
         if (playerTotal > 21) {
            return "loses";
        }

        if (dealerTotal > 21 || playerTotal > dealerTotal) {
            return "wins";
        }

        if (playerTotal == dealerTotal) {
            return "push";
        }

        return "loses";
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        // TODO 12: Ask for 1-4 players. Reject invalid input and prompt again.
        // TODO 13: Create one Deck, one Dealer, and the requested Player objects.
        // TODO 14: Deal two cards to every player and the dealer.
        // TODO 15: For each player, print their hand/total and ask "hit or stand?".
        //          Continue until they stand or bust. Handle invalid choices.
        // TODO 16: After all player turns, show the dealer's hand and total.
        // TODO 17: Dealer draws until their total is at least 17.
        // TODO 18: Print results for each player using determineResult().

        int numberOfPlayers;

        while (true) {
            System.out.print("Enter number of players (1-4): ");

            if (!input.hasNextLine()) {
                return;
            }

            try {
                numberOfPlayers = Integer.parseInt(input.nextLine().trim());

                if (numberOfPlayers >= 1 && numberOfPlayers <= 4) {
                    break;
                }
            } catch (NumberFormatException e) {
                // Prompt again for non-integer input.
            }

            System.out.println("Please enter a whole number from 1 to 4.");
        }

        Deck deck = new Deck();
        Dealer dealer = new Dealer();
        Player[] players = new Player[numberOfPlayers];

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }

        for (int round = 0; round < 2; round++) {
            for (Player player : players) {
                player.hit(deck);
            }

            dealer.addCard(deck.dealCard());
        }

        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            int playerNumber = i + 1;

            System.out.println(
                    "Player " + playerNumber + "'s hand: " + player.getHand()
            );
            System.out.println(
                    "Player " + playerNumber + " total: " + player.getHandTotal()
            );

            while (!player.isStanding() && !player.isBust()) {
                System.out.print(
                        "Player " + playerNumber + ", hit or stand? "
                );

                String choice = input.hasNextLine()
                        ? input.nextLine().trim()
                        : "stand";

                if (choice.equalsIgnoreCase("hit")) {
                    player.hit(deck);

                    Card drawn = player.getHand().get(
                            player.getHand().size() - 1
                    );

                    System.out.println(
                            "Player " + playerNumber + " draws: " + drawn
                    );
                    System.out.println(
                            "Player " + playerNumber
                                    + " total: " + player.getHandTotal()
                    );
                } else if (choice.equalsIgnoreCase("stand")) {
                    player.stand();
                } else {
                    System.out.println("Please enter hit or stand.");
                }
            }

            if (player.isBust()) {
                System.out.println("Player " + playerNumber + " busts!");
            }
        }

        System.out.println("Dealer's hand: " + dealer.getHand());
        System.out.println("Dealer total: " + dealer.getHandTotal());

        while (dealer.shouldHit()) {
            System.out.println("Dealer hits...");

            Card drawn = deck.dealCard();
            dealer.addCard(drawn);

            System.out.println("Dealer draws: " + drawn);
            System.out.println("Dealer total: " + dealer.getHandTotal());
        }

        System.out.println(
                dealer.getHandTotal() > 21
                        ? "Dealer busts!"
                        : "Dealer stands."
        );

        System.out.println("Results:");

        for (int i = 0; i < players.length; i++) {
            int total = players[i].getHandTotal();

            System.out.println(
                    "Player " + (i + 1) + " total: " + total + " -> "
                            + determineResult(total, dealer.getHandTotal())
            );
        }

        System.out.println("Dealer total: " + dealer.getHandTotal());
    }
}
   
