package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program03 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner imput = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int taxes = imput.nextInt();
		
		for(int i=1; i<=taxes; i++) {
			System.out.println("Tax payer #" + i +" data:");
			System.out.print("Individual or company (i/c)? ");
			char valid = imput.next().charAt(0);
			System.out.print("Name: ");
			imput.nextLine();
			String name = imput.nextLine();
			System.out.print("Anual Income: ");
			double anualIncome = imput.nextDouble();
			if(valid == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = imput.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			}
			else if(valid == 'c') {
				System.out.print("Number of employees: ");
				int numberOfEmployees = imput.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID: ");
		double sum = 0.0;
		for(TaxPayer tax : list) {
			sum += tax.tax();
			System.out.println(tax.getName() + ": $" + String.format("%.2f", tax.tax()));
		}
		System.out.println();
		System.out.printf("TOTAL TAXES %.2f%n", sum);
		
		
		imput.close();
	}

}
