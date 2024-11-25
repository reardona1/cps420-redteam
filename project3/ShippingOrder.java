package project3;


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


class AirShippingOrder extends ShippingOrder {
	private String airwayBillNumber;
	
    public AirShippingOrder(String orderID, double weight, String destination) {
        super(orderID, weight, destination);
    }

    public void prepareShipment() {
    	airwayBillNumber = orderID + "-AIR";
        System.out.println("Preparing Air Shipment: " + airwayBillNumber);
    }

    public void calculateCost() {
        double cost = weight * 5.0;
        System.out.println("Air Shipping Cost: $" + cost);
    }

   public void generateDocumentation() {
        System.out.println("Shipment #" + airwayBillNumber + ", Desitnation: " + destination + ", Weight: " + weight + ", has been processed\n");
    }
}

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