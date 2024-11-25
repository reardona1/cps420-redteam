package project3;

public class main {

	public static void main(String[] args) {
		ShippingOrderFactory factory ;
		ShippingOrder order ;
		// Create an Air Shipping Order
		factory = new AirShippingOrderFactory ();
		order = factory . createShippingOrder ( "ORD001" , 150.0 , "New York" );
		order . prepareShipment ();
		order . calculateCost ();
		order . generateDocumentation ();
		// Create a Sea Shipping Order
		factory = new SeaShippingOrderFactory ();
		order = factory . createShippingOrder ( "ORD002" , 5000.0 , "London" );
		order . prepareShipment ();
		order . calculateCost ();
		order . generateDocumentation ();
		// Create a Land Shipping Order
		factory = new LandShippingOrderFactory ();
		order = factory . createShippingOrder ( "ORD003" , 200.0 , "Los Angeles" );
		order . prepareShipment ();
		order . calculateCost ();
		order . generateDocumentation ();

	}

}
