package de.billfront.assignment.compute;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.billfront.assignment.model.Result;
import de.billfront.assignment.util.Constants;

/**
 * Class to handle operations on invoice
 * 
 * @author Sai Krishna Sowmith Sanakkayala
 */
public class InvoiceComputation extends Constants {

	/**
	 * 
	 * Computes invoice amount, financed amount and remaining credit limit of a customer
	 * @param invoiceJsonElement
	 * @param creditLimitJsonElement
	 * @return {@link Result}
	 */
	public Result compute(JsonElement invoiceJsonElement, JsonElement creditLimitJsonElement){
		
		Map<String, BigDecimal> finalInvoice = new LinkedHashMap<String, BigDecimal>();
		BigDecimal financedAmount = new BigDecimal(0);
		
		// credit limit of the customer
		BigDecimal creditLimit = creditLimitJsonElement.getAsJsonObject().get("customer").getAsBigDecimal();
		
		// invoice of the customer
		JsonArray invoiceJsonArray = invoiceJsonElement.getAsJsonArray();
		 
		for(JsonElement invoiceElement : invoiceJsonArray){
			 
			JsonObject invoiceJsonObject = invoiceElement.getAsJsonObject();
			BigDecimal invoiceAmount = invoiceJsonObject.get(INVOICE_AMOUNT).getAsBigDecimal();
			
			if(creditLimit.equals(BigDecimal.ZERO)){
				finalInvoice.put(invoiceJsonObject.get(INVOICE_NUMBER).getAsString(), BigDecimal.ZERO);
			}else{
				// credit limit is greater than or equal to invoice amount
				if(creditLimit.compareTo(invoiceAmount) == 0 || creditLimit.compareTo(invoiceAmount) == 1){
					finalInvoice.put(invoiceJsonObject.get(INVOICE_NUMBER).getAsString(), invoiceAmount);
					financedAmount = financedAmount.add(invoiceAmount);
					creditLimit = creditLimit.subtract(invoiceAmount);
										
				} 
				// credit limit is less than invoice amount
				else if(creditLimit.compareTo(invoiceAmount) == -1){
					finalInvoice.put(invoiceJsonObject.get(INVOICE_NUMBER).getAsString(), creditLimit);
					financedAmount = financedAmount.add(creditLimit);
					creditLimit = BigDecimal.ZERO;
				}
			}
		}
		
		return new Result(financedAmount, finalInvoice, creditLimit);
	}
}
