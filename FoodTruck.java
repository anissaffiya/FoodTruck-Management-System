public class FoodTruck {
    // Attributes
    private String foodTruckID;
    private String foodTruckCat;
    private String location;
    private double sales;

    // Default constructor
    public FoodTruck() {
        this.foodTruckCat = "";
        this.location = "";
        this.foodTruckID = "";
        this.sales = 0.0;
    }

    // Parameterized constructor
    public FoodTruck(String foodTruckID,String foodTruckCat , String location, double sales) {
        this.foodTruckCat = foodTruckCat;
        this.location = location;
        this.foodTruckID = foodTruckID;
        this.sales = sales;
    }

    // Accessor methods
    public String getFoodTruckID() {
        return foodTruckID;
    }

    public String getFoodTruckCat() {
        return foodTruckCat;
    }

    public String getLocation() {
        return location;
    }

    public double getSales() {
        return sales;
    }

    // Mutator methods
    public void setFoodTruckID(String foodTruckID) {
        this.foodTruckID = foodTruckID;
    }

    public void setMenu(String foodTruckCat) {
        this.foodTruckCat = foodTruckCat;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    // toString method

    public String toString() {
        return "\nFoodTruckID: " + foodTruckID + "\nfoodTruckCat:" +foodTruckCat + "\nFoodTruck location: " +location
                 + "\nSales: " +sales;
    }

    // Processor methods 
    //Processor methods 

    public double calcTotSales()  

    { 

    double totSales = 0; 

    totSales = totSales+sales ; 

    return totSales;  

   }     

   /*** public double calcAvgSales()  

   { 

    double avgSales; 

    avgSales = calcTotSales()/25; 

    return avgSales;  

  } ***/
}
