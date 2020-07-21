package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Enum.OrderStatus;

public class Order {
	public static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	public static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private OrderStatus status;
	private Client client;

	private List<OrderItem> orderItens = new ArrayList<>();

	public Order() {
		
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItens() {
		return orderItens;
	}
	
	public void addItem(OrderItem orderItem) {
		orderItens.add(orderItem);
	}
	
	public void removeItem(OrderItem orderItem) {
		orderItens.remove(orderItem);
	}
	
	public double total() {
		double sum = 0;
		for (OrderItem p : orderItens) {
			sum += p.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order Sumary:");
		sb.append("\nOrder Moment: " + sdf2.format(moment));
		sb.append("\nOrder Status: " + status);
		sb.append("\n" + client.toString());
		sb.append("\nOrder Items:");
		
		for(OrderItem p : orderItens) {
			sb.append(p.toString());
		}
		return sb.toString();
		
	}
	
	

	
}
