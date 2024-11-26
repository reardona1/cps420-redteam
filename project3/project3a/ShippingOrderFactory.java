package project3a;

//the abstract interface to be built upon by the specific factories
interface ShippingOrderFactory {
	abstract ShippingOrder createShippingOrder(String orderID, double weight, String destination);
}

//implements the abstract interface with regards to air shipping
class AirShippingOrderFactory implements ShippingOrderFactory {
	
    public AirShippingOrder createShippingOrder(String orderID, double weight, String destination) {
        return new AirShippingOrder(orderID, weight, destination);
    }
}

//implements the abstract interface with regards to sea shipping
class SeaShippingOrderFactory implements ShippingOrderFactory{

	public SeaShippingOrder createShippingOrder(String orderID, double weight, String destination) {
		return new SeaShippingOrder(orderID, weight, destination);
	}
}

//implements the abstract interface with regards to land shipping
class LandShippingOrderFactory implements ShippingOrderFactory{

	public LandShippingOrder createShippingOrder(String orderID, double weight, String destination) {
		return new LandShippingOrder(orderID, weight, destination);
	}
}
