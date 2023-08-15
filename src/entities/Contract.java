package entities;

import java.util.Date;

public class Contract {
	private Integer number;
	private Date date;
	private Double totalValue;
	
	public Installment installments;

	public Contract(Integer number, Date date, Double totalValue, Installment installments) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
		this.installments = installments;
	}	
}