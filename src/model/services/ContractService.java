package model.services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {
		double value = contract.getTotalValue()/months;
		for(int i = 1; i<=months;i++) {
			LocalDate date = contract.getDate().plusMonths(i);
			double interest = onlinePaymentService.interest(value, i);
			double fee = onlinePaymentService.paymentFee(value + interest);
			double quota = value + interest + fee;	
			
			contract.getInstallments().add(new Installment(date, quota));
			}
	}
}