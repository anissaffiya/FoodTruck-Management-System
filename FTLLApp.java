
import java.util.*;
import java.io.*;

public class FTLLApp {
    public static void main (String [] args) throws Exception {
        Scanner in = new Scanner (System.in);
        LinkedList foodTruckList = new LinkedList();
        LinkedList KuantanFTList = new LinkedList();
        LinkedList DungunFTList = new LinkedList();
        LinkedList GeorgeTownFTList = new LinkedList();

        Scanner inputText=new Scanner(System.in);
        Scanner inputNum=new Scanner(System.in);
        
        // 1.Insertion data from the file
        
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
                foodTruckList.addLast(ft);
                str=br.readLine();
                
            }
            
            br.close();
            fr.close();
        }
        catch (Exception x) {
            System.out.println (x.getMessage());
        }
        
        System.out.println("-------------------------------------------------------------");
        System.out.println("       "+"=== Welcome to Food Truck Directories ===:"+"     ");
        System.out.println("--------------------------------------------------------------");
        
        //Display data
        FoodTruck ft = (FoodTruck) foodTruckList.getFirst();
        
        while (ft!= null){
            System.out.println(ft.toString());
            ft = (FoodTruck) foodTruckList.getNext();
        }
        
        
        //2.Searching – display the detail of food truck based on id input by user
        boolean Found = false;
        System.out.println("\nEnter FoodTruck ID:");
        String foodTruckID = in.next();
            
            ft = (FoodTruck)foodTruckList.getFirst();
            while(ft!=null){
                if(ft.getFoodTruckID().equals(foodTruckID)){
                    System.out.println(ft.toString());
                    Found = true;
                }
                
                ft = (FoodTruck) foodTruckList.getNext();
            }
            
            if (!Found) {
                System.out.println("NOT FOUND");
            }
            
             //3. Traversing - display the average sales for all food trucks   
            System.out.println("\nDo you want the system display average sales for all foodtruck (Yes/No)");
            String answer = inputText.nextLine();
            
            if(answer.equalsIgnoreCase("Yes")){
              double totalSales=0.00;
              int count = 0;
              ft = (FoodTruck)foodTruckList.getFirst();
              while (ft !=null) {
                totalSales=totalSales+ft.getSales();//sum
                count++;
                ft=(FoodTruck)foodTruckList.getNext();
              }
              System.out.println("\n+--------------------------------------------------+");
              System.out.println("|  Average Sale for All FoodTruck is : RM "+(totalSales/count)+"  |");
              System.out.println("+--------------------------------------------------+");  
            
            }
            
                
           //4.update sales for foodtruck FT010  
           System.out.println("Do you want to display updated sales for foodtruck FT010(Yes/No):");
           String input = inputText.nextLine();
           ft=(FoodTruck)foodTruckList.getFirst();
           if(input.equalsIgnoreCase("Yes")){
            while (ft !=null) {
                if (ft.getFoodTruckID().equalsIgnoreCase("FT010")) {
                    ft.setSales(1300.00);
                    System.out.println("\n=====================================");
                    System.out.println("The Updated Sales for FoodTruck FT010 ");
                    System.out.println("=====================================");
                    System.out.println(ft.toString());
                }   
                ft = (FoodTruck)foodTruckList.getNext();
                
           }
        }
           //5. Removal - remove a data into , KuantanFoodtruckList, DungunFoodTruckList and
           //GeorgeTownFoodtruckList for a data that the location is “Dungun” move the
           //data into DungunFoodTruckList and if the location is “Kuantan” move the data
           //into KuantanFoodtruckList or otherwise into GeorgeTownFoodtruckList 
        System.out.println("\nDo you want to display FoodTruck list based on location  (Yes/No)");  
        String ans = inputText.nextLine();
        if(ans.equalsIgnoreCase("Yes")){
        System.out.println("\n+--------------------------------------------+");
        System.out.println("|        FOODTRUCK LIST BASED ON LOCATION       |");
        System.out.println("+----------------------------------------------+"); 
            while (!foodTruckList.isEmpty()) {
                ft = (FoodTruck) foodTruckList.getFirst();
            if (ft.getLocation().equalsIgnoreCase("Kuantan")) {
                KuantanFTList.addFirst(ft);
            } else if (ft.getLocation().equalsIgnoreCase("Dungun")) {
                DungunFTList.addFirst(ft);
            } else if (ft.getLocation().equalsIgnoreCase("GeorgeTown")) {
                GeorgeTownFTList.addFirst(ft);
            }
                foodTruckList.removeFirst();
        }
        
        System.out.println("\n-------------------------");
        System.out.println("|"+"KUANTAN FOODTRUCK LISTS:"+"|");
        System.out.println("-------------------------");
        FoodTruck ftKuantan = (FoodTruck) KuantanFTList.getFirst();
        while (ftKuantan != null) {
            System.out.println(ftKuantan);
            ftKuantan = (FoodTruck) KuantanFTList.getNext();
        }
        
        System.out.println("\n------------------------");
        System.out.println("|"+"DUNGUN FOODTRUCK LISTS:"+"|");
        System.out.println("------------------------");
        FoodTruck ftDungun = (FoodTruck) DungunFTList.getFirst();
        while (ftDungun != null) {
            System.out.println(ftDungun);
            ftDungun = (FoodTruck) DungunFTList.getNext();
        }
        
        System.out.println("\n----------------------------");
        System.out.println("|"+"GEORGETOWN FOODTRUCK LISTS:"+"|");
        System.out.println("----------------------------");
        FoodTruck ftGeorgetown = (FoodTruck) GeorgeTownFTList.getFirst();
        while (ftGeorgetown != null) {
            System.out.println(ftGeorgetown);
            ftGeorgetown = (FoodTruck) GeorgeTownFTList.getNext();
        }
            
            }
        }
   }
    
        
       




    
        
       



