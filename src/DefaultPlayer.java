import java.util.Random;

public class DefaultPlayer extends Player {

    public DefaultPlayer() {

    }

    public DefaultPlayer(String name) {
        super(name);
    }

    public void rollDice(Dice a) {
        Random rand = new Random();
        double prob;
        int x = 0;
        prob = rand.nextDouble();
        //System.out.println(prob);
        if(prob < a.getProbability(0)) x=1;
        for(int i =0; i<5;i++) {
            if(prob > a.getProbability(i) && prob < a.getProbability(i+1))
                x = i+2;
        }
        System.out.println(this.getName() + " get " + x + " points");
        System.out.println();
        this.setPoint(this.getPoint() + x);
    }



}
