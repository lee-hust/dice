import java.util.Random;
import java.util.Scanner;

public class Referee {
    private final int MAX_PLAYER = 4;
    private final int NUM_DICE = 4;
    private Dice[] dice_array = new Dice[NUM_DICE + 1];
    private Player[] player_array = new Player[MAX_PLAYER];
    private Player winner;
    public void distributeDices() {
        for(int i=1;i<=NUM_DICE;i++) {
            dice_array[i] = new Dice(i);
        }
    }

    public void generatePlayer() {
        int number_of_players;
        String name;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Input number of players: ");
            number_of_players = scan.nextInt();
        }
        while(number_of_players < 0 || number_of_players > MAX_PLAYER);
        for(int j=1;j<=number_of_players;j++) {
            System.out.println("Input player's " + j + " name");
            name = scan.next();
            player_array[j-1] = new Player(name);
        }
        if(number_of_players < MAX_PLAYER) {
            for(int j=number_of_players+1;j<= MAX_PLAYER;j++) {
                name = "Default Player " + j;
                player_array[j-1] = new DefaultPlayer(name);
            }
        }
    }

    public Dice getDice(int i) {
        return this.dice_array[i];
    }

    public Player getPlayer(int i) {
        return this.player_array[i];
    }

    public void declareWinner(Player a) {
        System.out.println("Player:" + a.getName() +" wins");
    }

    public void startGame() {
        System.out.println("Let the game begin :> ");
        Random rand = new Random();
        int num;
        int i = 1;
        DefaultPlayer tag = new DefaultPlayer();
        while(true) {
            System.out.println("Now is player "+i+"'s turn.");
            num = (rand.nextInt(4)) + 1;
            System.out.println("You picked dice no."+num);
            this.player_array[i-1].rollDice(dice_array[num]);
            if(player_array[i-1].isWinner()) {
                declareWinner(player_array[i-1]);
                break;
            }
            i = (i % MAX_PLAYER) + 1;
            System.out.println();
        }
        winner = player_array[i-1];
        for(i=0;i<MAX_PLAYER;i++) {
            if(player_array[i] != winner && player_array[i] instanceof DefaultPlayer) {
                tag = (DefaultPlayer) player_array[i];
            }
        }

    }

}
