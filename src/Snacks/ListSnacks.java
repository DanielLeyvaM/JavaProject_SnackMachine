package Snacks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.ArrayList;

public class ListSnacks {
    private static final String fileName= "ProductStock.txt";
    private static final List <Snack> snacks = new ArrayList<>();

    //--------------- Initializer block ----------
    static {
        Path path= Paths.get(fileName);

        try {
            if (Files.size(path) > 0) {
                List<String> fileLines = Files.readAllLines(path);
                for(String lines : fileLines){
                    String[] elements = lines.split(",");
                    String name = elements[0];
                    double price = Double.parseDouble(elements[1]);

                    Snack snack= new Snack(name,price);
                    snacks.add(snack);
                }
            } else{
                System.out.println("Empty File\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    //--------------- Methods -----------------
    public static void  addSnack(Snack product){
        snacks.add(product);
        Path path = Paths.get(fileName);

        String addToFile = "\n"+product.getName()+","+product.getPrice();
        try {
            Files.write(path, addToFile.getBytes(), StandardOpenOption.APPEND);
            System.out.println("Product added to file");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void removeSnack(int id){
        //snacks.remove(name);
        snacks.removeIf(snack -> snack.getIdSnacks() ==id);
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
