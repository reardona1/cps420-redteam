package project3a;

interface ShippingOrderFactory {
	abstract ShippingOrder createShippingOrder(String orderID, double weight, String destination);
}

class AirShippingOrderFactory implements ShippingOrderFactory {
	
    public AirShippingOrder createShippingOrder(String orderID, double weight, String destination) {
        return new AirShippingOrder(orderID, weight, destination);
    }
}

class SeaShippingOrderFactory implements ShippingOrderFactory{

	public SeaShippingOrder createShippingOrder(String orderID, double weight, String destination) {
		return new SeaShippingOrder(orderID, weight, destination);
	}
}

class LandShippingOrderFactory implements ShippingOrderFactory{

	public LandShippingOrder createShippingOrder(String orderID, double weight, String destination) {
		return new LandShippingOrder(orderID, weight, destination);
	}
}
