package project3a;

//The base abstract ShippingOrder class
abstract class ShippingOrder {
	protected String orderID;
	protected double weight;
	protected String destination;
	
	public ShippingOrder(String orderID, double weight, String destination) {
        this.orderID = orderID;
        this.weight = weight;
        this.destination = destination;
    }
	
	public abstract void prepareShipment();
	public abstract void calculateCost();
	public abstract void generateDocumentation();
	
}	

//All shipping methods use a similar structure, so all comments apply to subsequent functions
class AirShippingOrder extends ShippingOrder {
	//declare an internal identification number
	private String airwayBillNumber;
	
	//Sets the variables for this object when created by a factory
    public AirShippingOrder(String orderID, double weight, String destination) {
        super(orderID, weight, destination);
    }
    
    //Prepares the shipment by creating a unique internal identification number
    public void prepareShipment() {
    	airwayBillNumber = orderID + "-AIR";
        System.out.println("Preparing Air Shipment: " + airwayBillNumber);
    }
    
    //Calculates the cost of shipping via this method, using simple example calculations
    public void calculateCost() {
        double cost = weight * 5.0;
        System.out.println("Air Shipping Cost: $" + cost);
    }
    
   //Prints out a receipt that confirms all entered information
   public void generateDocumentation() {
        System.out.println("Shipment #" + airwayBillNumber + ", Desitnation: " + destination + ", Weight: " + weight + ", has been processed\n");
    }
}

//identical operation to previous
class SeaShippingOrder extends ShippingOrder {
    private String billOfLanding;

    public SeaShippingOrder(String orderID, double weight, String destination) {
        super(orderID, weight, destination);
    }

    public void prepareShipment() {
        billOfLanding = orderID + "-SEA";
        System.out.println("Preparing Sea Shipment: " + billOfLanding);
    }

    public void calculateCost() {
        double cost = weight * 2.0;
        System.out.println("Sea Shipping Cost: $" + cost);
    }

    public void generateDocumentation() {
        System.out.println("Shipment #" + billOfLanding + ", Desitnation: " + destination + ", Weight: " + weight + ", has been processed\n");
    }
}

//identical operation to previous
class LandShippingOrder extends ShippingOrder {
    private String deliveryTruckID;

    public LandShippingOrder(String orderID, double weight, String destination) {
        super(orderID, weight, destination);
    }

    public void prepareShipment() {
        deliveryTruckID = orderID + "-LAND";
        System.out.println("Preparing Land Shipment: " + deliveryTruckID);
    }

    public void calculateCost() {
        double cost = weight * 1.5;
        System.out.println("Land Shipping Cost: $" + cost);
    }

    public void generateDocumentation() {
    	System.out.println("Shipment #" + deliveryTruckID + ", Desitnation: " + destination + ", Weight: " + weight + ", has been processed\n");
    }
}