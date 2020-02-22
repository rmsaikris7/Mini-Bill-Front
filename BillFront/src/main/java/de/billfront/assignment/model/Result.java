package de.billfront.assignment.model;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Result class
 * 
 * @author Sai Krishna Sowmith Sanakkayala
 */
public class Result {

	private BigDecimal financedAmount;
	private Map<String, BigDecimal> financedInvoice;
	private BigDecimal remainingCredit;
	
	public Result(BigDecimal financedAmount, Map<String, BigDecimal> financedInvoice, BigDecimal remainingCredit) {
		this.financedAmount = financedAmount;
		this.financedInvoice = financedInvoice;
		this.remainingCredit = remainingCredit;
	}
	
	public BigDecimal getFinancedAmount() {
		return financedAmount;
	}
	public void setFinancedAmount(BigDecimal financedAmount) {
		this.financedAmount = financedAmount;
	}
	public Map<String, BigDecimal> getFinancedInvoice() {
		return financedInvoice;
	}
	public void setFinancedInvoice(Map<String, BigDecimal> financedInvoice) {
		this.financedInvoice = financedInvoice;
	}
	public BigDecimal getRemainingCredit() {
		return remainingCredit;
	}
	public void setRemainingCredit(BigDecimal remainingCredit) {
		this.remainingCredit = remainingCredit;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Financed Amount : ").append(financedAmount);
		builder.append("\nFinanced Invoice : ");
		
		for(String key : financedInvoice.keySet()){
			builder.append("\n\t").append(key).append(" : ").append(financedInvoice.get(key));
		}
		
		builder.append("\nRemaining Credit : ").append(remainingCredit);
		return builder.toString();
	}
	
	
	
}
