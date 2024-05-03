import java.io.*;
import java.util.*;

public class FoodTruckIOFile {
    public static void main(String[] args) {
        try {
            FoodTruck[] foodTruckList = new FoodTruck[26];

            // Reading from the file
            FileReader fr = new FileReader("FoodTruckList.txt");
            BufferedReader br = new BufferedReader(fr);

            int count = 0;
            String dataRow = br.readLine();
            while (dataRow != null && count < 26) {
                StringTokenizer st = new StringTokenizer(dataRow, ";");

                if (st.countTokens() >= 4) {
                    String foodTruckID = st.nextToken();
                    String foodTruckCat = st.nextToken();
                    String location = st.nextToken();
                    double sales = Double.parseDouble(st.nextToken());

                    foodTruckList[count] = new FoodTruck(foodTruckCat, location, foodTruckID, sales);
                    count++;
                }
                dataRow = br.readLine();
            }
            br.close();

            // Writing to a new file to avoid overwriting the original file
            FileWriter fwData = new FileWriter("OutputFoodTruckList.txt");
            BufferedWriter bwData = new BufferedWriter(fwData);
            PrintWriter pwData = new PrintWriter(bwData);

            pwData.println("\nFoodTruck Directories:");
            for (int i = 0; i < count; i++) {
                pwData.println(foodTruckList[i].toString());
            }
            pwData.close();

            // Displaying the contents
            System.out.println("\nFoodTruck Directories:");
            for (int i = 0; i < count; i++) {
                System.out.println(foodTruckList[i].toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Problem: " + e.getMessage());
        } catch (IOException ioe) {
            System.out.println("Problem: " + ioe.getMessage());
        } finally {
            System.out.println("End of program");
        }
    }
}

