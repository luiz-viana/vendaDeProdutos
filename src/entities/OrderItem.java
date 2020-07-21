package entities;

public class OrderItem {
	
	private Integer quantity;
	private Product product;
	
	public OrderItem() {
		
	}
	
	public OrderItem(Integer quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double subTotal() {
		return product.getPrice() * quantity;
	}

	@Override
	public String toString() {
		return "\nProduct: " + product.getName() + ", Quantity: " + quantity + ", Price: " + String.format("%.2f $", product.getPrice()) + ", Subtotal: " + String.format("%.2f $", subTotal()); 
	}
	
	

}