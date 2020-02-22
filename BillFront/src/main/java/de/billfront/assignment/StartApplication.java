package de.billfront.assignment;

import com.google.gson.JsonElement;

import de.billfront.assignment.compute.InvoiceComputation;
import de.billfront.assignment.model.Result;
import de.billfront.assignment.util.CommonUtil;
import de.billfront.assignment.util.Constants;

/**
 * 
 * Starts the application
 * @author Sai Krishna Sowmith Sanakkayala
 *
 */
public class StartApplication {

	public static void main(String[] args){

		// imports invoice json file from resources
 		JsonElement invoiceJsonElement = CommonUtil.loadResourceJsonFile(Constants.INVOICE_JSON_FILE);
 		
 		// imports credit limit json file from resources
		JsonElement creditLimitJsonElement = CommonUtil.loadResourceJsonFile(Constants.CREDIT_LIMIT_JSON_FILE);
		
		InvoiceComputation computation = new InvoiceComputation();
		Result result = computation.compute(invoiceJsonElement, creditLimitJsonElement);
		
		System.out.println(result.toString());
		
	}
}
