package Snacks;

public class Snack {
    //------------ Attributes ------------
    int idSnacks;
    static int counterSnacks=1;

    private String name;
    private double price;

    //------------- Methods ------------
    public Snack(){
        this.idSnacks= counterSnacks++;
    }

    public Snack(String name, double price){
        this.idSnacks= counterSnacks++;         //this();
        this.name=name;
        this.price=price;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price){
        this.price=price;
    }

    public int getIdSnacks() {
        return idSnacks;
    }

    public String getName() {
        return name;
    }
    public double getPrice(){
        return price;
    }

   @Override
   public String toString(){
        return "Snack: {ID: "+this.idSnacks+", Name: "+this.name+", Price: $"+this.price+" }";
   }
}
