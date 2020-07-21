package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.Enum.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Scanner sc = new Scanner (System.in);
		
		
		System.out.println("Enter cliente data: \nName: ");
		String clientName = sc.nextLine();
		
		System.out.println("Email: ");
		String clientEmail = sc.next();
		
		System.out.println("Birth Date DD/MM/YYYY: ");
		String clientDate = sc.next();
		Date clientBD = sdf1.parse(clientDate);
		
		Client client = new Client(clientName, clientEmail, clientBD);
		
		
		System.out.println("Enter order data: ");
		System.out.println("How many items to this order?");
		int n = sc.nextInt();
		
		
		//pegando data atual do sistema;
		Date data = new Date(System.currentTimeMillis());
		
		//instanciando novo pedido;
		Order order = new Order(data, OrderStatus.valueOf("PROCESSING"), client);
		
		
		for (int i = 1 ; i <= n; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
	
			//adicionando orderItens ao pedido
			OrderItem oi = new OrderItem(productQuantity, new Product(productName, productPrice));
		
			order.addItem(oi);
		
		}
		
		System.out.println(order.toString());
		System.out.println("TOTAL: " + String.format("%.2f$", order.total()));
		

		sc.close();

	}


}
