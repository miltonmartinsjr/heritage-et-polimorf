package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program02 {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner imput = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int prod = imput.nextInt();
		
		for(int i=1; i<=prod; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used, imported (c/u/i)? ");
			char valid = imput.next().charAt(0);
			System.out.print("Name: ");
			imput.nextLine();
			String name = imput.nextLine();
			System.out.print("Price: ");
			double price = imput.nextDouble();
			if (valid == 'i'){
				System.out.print("Customs fee: ");
				double customsFee = imput.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
			else if(valid == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(imput.next());
				list.add(new UsedProduct(name, price, date));
			}
			else {
				list.add(new Product(name, price));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product obj: list) {
			System.out.println(obj.priceTag());
		}
		
		
		imput.close();
	}

}
