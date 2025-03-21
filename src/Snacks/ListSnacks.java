package Snacks;

import java.util.List;
import java.util.ArrayList;

public class ListSnacks {
    private static final List <Snack> snacks;

    //--------------- Initializer block ----------
    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Chocolate",20.2));
        snacks.add(new Snack("Soda",16.5));
    }

    //--------------- Methods -----------------
    public static void  addSnack(Snack product){
        snacks.add(product);
    }

    public static void removeSnack(int id){
        //snacks.remove(name);
        snacks.removeIf(snack -> snack.idSnacks==id);
    }

    public static void showSnacks(){
        String content= "\n------------ Snacks in machine ------------\n";
        if (snacks.isEmpty()){
            System.out.println(content+"Empty List");
        } else{
             for(Object product: snacks){
                 content= content + product.toString()+"\n";
             }
            System.out.println(content);
        }
    }

    public static List<Snack> getList(){
        return snacks;
    }
}
