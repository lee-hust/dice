
public class Dice {
    private int ID;
    private double []probability;

    public Dice(int number) {
        setNumber(number);
        this.probability = new double[6];
        double temp = 0.0f;
        for(int i =0;i<6;i++) {
            if(i != number-1) {
                probability[i] = temp + 0.16;
                temp = probability[i];
            }
            else {
                probability[i] = temp + 0.2;
                temp = probability[i];
            }
        }
    }

    public void setNumber(int number) {
        this.ID = number;
    }

    public double getProbability(int a) {
        if(a<0 || a>=6) return -1;
        else
            return this.probability[a];
    }

    public void probDisplay(){
        for(int i=0;i<6;i++)
            System.out.printf(" %2.2f ",this.probability[i]);
        System.out.println();
    }


}