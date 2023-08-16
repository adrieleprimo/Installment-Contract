package model.services;

import entities.Contract;

public class ContractService {

	
	public void processContract(Contract contract, int months) {
		for (int i = 0; i < months; i++) {
			contract.getDate().setDate(i);
		}
		return;
	}

}