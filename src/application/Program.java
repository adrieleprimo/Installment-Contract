package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import model.services.ContractService;
import model.services.OnlinePaymentService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		try {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter data contract: ");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = fmt.parse(sc.next());
		System.out.print("Contract value: ");
		double value = sc.nextDouble();
		System.out.print("Enter the number of installments: ");
		int installment = sc.nextInt();
		Contract contract = new Contract(number, date, value);
		ContractService service = new ContractService();
		service.processContract(contract, installment);
		OnlinePaymentService paymentService = new PaypalService();
		paymentService.paymentFee(value);
		paymentService.interest(value, installment);
		System.out.println();
		System.out.println("Installments: ");
		System.out.println(contract.getInstallments());
		sc.close();
		
	}
	catch( ParseException e) {
			System.out.println(e.getMessage());
		}
	catch (RuntimeException e) {
		System.out.println(e.getMessage());
	}

}
}
