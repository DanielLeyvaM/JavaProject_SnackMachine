package Snacks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void SnacksMachine() {
        List <Snack> buyList =new ArrayList<>();        //Volatile Buy Product List
        Scanner sc= new Scanner(System.in);
        boolean repeat=true;

        while(repeat){
            ListSnacks.showSnacks();
            System.out.printf("1. Add product to machine\n2. Add product to buy list"+
                        "\n3. Remove product in buy list\n4. Show ticket \n5. Exit\n");
            System.out.print("Select an option: ");
            int opcion= Integer.parseInt(sc.nextLine());
                try {
                        switch (opcion) {
                            case 1 -> addToMachine(sc);
                            case 2 -> addToList(buyList,sc);
                            case 3 -> removeToList(buyList,sc);
                            case 4 -> showTicket(buyList);
                            case 5 -> repeat=exitMenu(buyList);
                            default -> System.out.println("Invalid option");
                        }
                } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
        }


    public static void addToMachine(Scanner sc){
        System.out.println(" --------- Insert a new product --------- ");
        ListSnacks.showSnacks();
        System.out.print("Name: ");
        String name= sc.nextLine();
        System.out.print("Price: ");
        double price= sc.nextDouble();
        sc.nextLine();
        ListSnacks.addSnack(new Snack(name,price));
    }

//    public static void deleteToMachine(Scanner sc){
//        System.out.println(" --------- Delete a product --------- ");
//        ListSnacks.showSnacks();
//        System.out.println("Insert id: ");
//        int id= Integer.parseInt(sc.nextLine());
//        ListSnacks.removeSnack(id);
//    }

    public static void addToList(List<Snack> buyList, Scanner sc){
        System.out.println(" --------- Selected products --------- ");
        String list="";
        for(Snack s1: buyList){
            list+="Product: "+s1.getName()+" "+s1.getPrice()+"\n";
        }
        System.out.println(list);
        System.out.println("Insert id: ");
        int id= Integer.parseInt(sc.nextLine());
        for(Snack s1: ListSnacks.getList()){
            if(id == s1.getIdSnacks()){
                buyList.add(s1);
                System.out.println("Product added to BuyList");
                break;
            }
        }
    }

    public static void removeToList(List<Snack> buyList,Scanner sc){
        System.out.println(" --------- Remove a product --------- ");
        String list="";
        for(Snack s1: buyList){
            list+="Product: "+s1.getName()+" "+s1.getPrice()+"\n";
        }
        System.out.println(list);
        System.out.println("Insert name: ");
        String name= sc.nextLine();
        buyList.removeIf(snack -> snack.getName().equals(name));
    }

    public static void showTicket(List<Snack> buyList){
        String list="";
        double total=0.0;

        for(Snack s1: buyList){
            list+="Product: "+s1.getName()+" "+s1.getPrice()+"\n";
            total+= s1.getPrice();
        }
        list= "--------- Selected products ---------\n"+list+"\nTotal: "+total;
        System.out.println(list);

        System.out.print("\nConfirm order Y/N: ");
        Scanner sc =new Scanner(System.in);
        String option= sc.next().toUpperCase();
        if(option.compareTo("Y") ==0){
            //Creating order ticket to Save Buy List
            Path path = Paths.get("Ticket Order.txt");

            String text = list;
            try {
                Files.write(path, text.getBytes());
                System.out.println("Order ticket has been created");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("Returning to menu...");
        }
    }

    public static boolean exitMenu(List<Snack> buyList){
        return false;
    }

}
