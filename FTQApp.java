
import java.util.*;
import java.io.*;

public class FTQApp{
    public static void main (String [] args) throws Exception {
        Scanner in = new Scanner (System.in);
        Queue foodTruckQ = new Queue();
        Queue tempQ = new Queue();
        Queue KuantanQ = new Queue();
        Queue DungunQ = new Queue();
        Queue GeorgeTownQ = new Queue();
        
        Scanner inputText=new Scanner(System.in);
        Scanner inputNum=new Scanner(System.in);
        
        //1. Insertion - data from input file 
        //read file
        try {
            File fn = new File("FoodTruckList.txt");
            FileReader fr = new FileReader(fn);
            BufferedReader br = new BufferedReader(fr);
            String foodTruckID, foodTruckCat, location;
            double sales;
            
            String str = br.readLine();
            
            while(str!= null) {
                StringTokenizer parse = new StringTokenizer(str, ";");
                foodTruckID = parse.nextToken();
                foodTruckCat= parse.nextToken();
                location = parse.nextToken();
                sales = Double.parseDouble(parse.nextToken());
                
                
                FoodTruck ft = new FoodTruck(foodTruckID,foodTruckCat,location,sales);
                foodTruckQ.enqueue(ft);
                str=br.readLine();
                
            }
            
            br.close();
            fr.close();
        }
        catch (Exception x) {
            System.out.println (x.getMessage());
        }
        
        System.out.println("-------------------------------------------------------------");
        System.out.println("       "+"=== Welcome to Food Truck Directories ==="+"     ");
        System.out.println("--------------------------------------------------------------");
        
        //Display data
        while (!foodTruckQ.isEmpty()){
            //System.out.println(ft.toString());
            FoodTruck ft=(FoodTruck)foodTruckQ.dequeue();
            System.out.println(ft.toString());
            tempQ.enqueue(ft);    
        }
        
        //2. Searching – display the detail of food truck based on id input by user
        boolean Found = false;
        System.out.println("\nEnter FoodTruck ID:");
        String foodTruckID = in.next();
            
            
        while(!tempQ.isEmpty()){
            FoodTruck ft=(FoodTruck)tempQ.dequeue();
            if(ft.getFoodTruckID().equals(foodTruckID)){
                    System.out.println(ft.toString());
                    Found = true;
                } 
            foodTruckQ.enqueue(ft);
        }
            
        if (!Found) {
            System.out.println("NOT FOUND");
        }
            
        //3. Traversing - display the average sales for all food trucks   
        System.out.println("\nDo you want the system display average sales for all foodtruck (Yes/No)");
        String answer = inputText.nextLine();
        
        if (answer.equalsIgnoreCase("Yes")){
        
        double totalSales=0.00;
        int count = 0;
        while (!foodTruckQ.isEmpty()) {
            FoodTruck ft=(FoodTruck)foodTruckQ.dequeue();
            
            totalSales=totalSales+ft.getSales();//sum
            count++;
            tempQ.enqueue(ft);
        }
        
        System.out.println("\n+--------------------------------------------------+");
        System.out.println("|  Average Sale for All FoodTruck is : RM "+(totalSales/count)+"  |");
        System.out.println("+--------------------------------------------------+");  
    }
        //4. Update sales for foodtruck FT010 
        System.out.println("Do you want to display updated sales for foodtruck FT010(Yes/No):");
        String input = inputText.nextLine();
        if(input.equalsIgnoreCase("Yes")){
        while (!tempQ.isEmpty()) {
            FoodTruck ft =(FoodTruck)tempQ.dequeue();
            if (ft.getFoodTruckID().equalsIgnoreCase("FT010")) {
                ft.setSales(1300.00);
                System.out.println("\n=====================================");
                System.out.println("The Updated Sales for FoodTruck FT010 ");
                System.out.println("=====================================");
                System.out.println(ft.toString());
            }   
            foodTruckQ.enqueue(ft);
        }
    }
            
        //5. Removal - remove a data into , KuantanFoodtruckList, DungunFoodTruckList and
        //GeorgeTownFoodtruckList for a data that the location is “Dungun” move the
        //data into DungunFoodTruckList and if the location is “Kuantan” move the data
        //into KuantanFoodtruckList or otherwise into GeorgeTownFoodtruckList
        
        System.out.println("\nDo you want to display Foodtruck based on location  (Yes/No)");
        String ans = inputText.nextLine();
        
        if (ans.equalsIgnoreCase("Yes")){
        System.out.println("\n+----------------------------------------------+");
        System.out.println("|        FOODTRUCK LIST BASED ON LOCATION        |");
        System.out.println("+------------------------------------------------+");            
        while (!foodTruckQ.isEmpty()) {
            FoodTruck ft=(FoodTruck)foodTruckQ.dequeue();
            if (ft.getLocation().equalsIgnoreCase("Kuantan")) {
                KuantanQ.addFirst(ft);
            } else if (ft.getLocation().equalsIgnoreCase("Dungun")) {
                DungunQ.addFirst(ft);
            } else if (ft.getLocation().equalsIgnoreCase("GeorgeTown")) {
                GeorgeTownQ.addFirst(ft);
            }
            tempQ.enqueue(ft);
        }
    }
        System.out.println("\n---------------------------");
        System.out.println("| "+"KUANTAN FOODTRUCK LISTS "+"|");
        System.out.println("---------------------------");
        while (!KuantanQ.isEmpty()) {
            FoodTruck ft=(FoodTruck)KuantanQ.dequeue();
            System.out.println(ft);
            tempQ.enqueue(ft);
        }
        
        System.out.println("\n--------------------------");
        System.out.println("|"+" DUNGUN FOODTRUCK LISTS "+"|");
        System.out.println("--------------------------");
        while (!DungunQ.isEmpty()) {
            FoodTruck ft=(FoodTruck)DungunQ.dequeue();
            System.out.println(ft);
            tempQ.enqueue(ft);
        }
        
        System.out.println("\n------------------------------");
        System.out.println("|"+" GEORGETOWN FOODTRUCK LISTS "+"|");
        System.out.println("------------------------------");
        while (!GeorgeTownQ.isEmpty()) {
            FoodTruck ft=(FoodTruck)GeorgeTownQ.dequeue();
            System.out.println(ft);
            tempQ.enqueue(ft);
        }   
    }
  }


    


