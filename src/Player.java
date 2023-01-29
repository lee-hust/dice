import java.util.Random;
import java.util.Scanner;

public class Player {
    private String name;
    private int point;

    public Player() {
        setPoint(0);
    }

    public Player(String name) {
        this.name = name;
        setPoint(0);
    }

    public void setPoint(int point) {
        if(point >=0 && point <= 21) this.point = point;
        else if(point > 21) this.point = 0;
        else System.out.println("Invalid point");
    }

    public int getPoint() {
        return this.point;
    }

    public String getName() {
        return this.name;
    }

    public void rollDice(Dice a) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        String c;
        double prob;
        int x = 0;
        prob = rand.nextDouble();
        //System.out.println(prob);
        if(prob < a.getProbability(0)) x=1;
        for(int i =0; i<5;i++) {
            if(prob > a.getProbability(i) && prob < a.getProbability(i+1))
                x = i+2;
        }
        System.out.println("Press any button to roll the dice !");
        c = scan.next();
        System.out.println("you get " + x + " points");
        System.out.println();
        this.setPoint(this.getPoint() + x);
    }

    public boolean isWinner() {
        if(this.point == 21) return true;
        else
            return false;
    }

}

