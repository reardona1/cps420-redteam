package project3a;

public class Client {
	public static void main(String[] args) {
		
		// Create an Air Shipping Order
		processShippingOrder(new AirShippingOrderFactory(), "ORD001" , 150.0 , "New York");
		
		// Create a Sea Shipping Order
		processShippingOrder(new SeaShippingOrderFactory(), "ORD002" , 5000.0 , "London");
		
		// Create a Land Shipping Order
		processShippingOrder(new LandShippingOrderFactory(), "ORD003" , 200.0 , "Los Angeles");

	}
	
	//For each shipping order, this function will run all necessary functions in order to prepare, calculate, and document the process
    public static void processShippingOrder(ShippingOrderFactory factory, String orderID, double weight, String destination) {

        ShippingOrder order = factory.createShippingOrder(orderID, weight, destination);

        order.prepareShipment();
        order.calculateCost();
        order.generateDocumentation();
    }
}

