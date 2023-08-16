package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import model.services.ContractService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		try {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner (System.in);
		//Contract
		System.out.println("Enter data contract: ");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Contract value: ");
		double value = sc.nextDouble();
		Contract contract = new Contract(number, date, value);
		
		//Installment
		System.out.print("Enter the number of installments: ");
		int installment = sc.nextInt();
		
		//ContractService
		ContractService service = new ContractService(null);
		service.processContract(contract, installment);
		System.out.println();
		System.out.println("Installments: ");
		for(Installment i: contract.getInstallments()) {
			System.out.print(i);
		}
		sc.close();
		
	}
	catch (RuntimeException e) {
		System.out.println(e.getMessage());
	}

}
}