package de.billfront.assignment.test;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import de.billfront.assignment.compute.InvoiceComputation;
import de.billfront.assignment.model.Result;


/**
 * Unit test for InvoiceComputation
 * 
 * @author Sai Krishna Sowmith Sanakkayala
 *
 */
public class InvoiceComputationTest {
	
	private JsonElement invoiceElement;
	private JsonElement creditLimitElement;
	private Map<String, BigDecimal> resultInvoice; 

	@SuppressWarnings("serial")
	@BeforeEach
	public void initializeTestData(){
		
		this.invoiceElement = new JsonParser().parse(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("test_invoices.json")));
		this.creditLimitElement = new JsonParser().parse(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("test_credit_limit.json")));
		this.resultInvoice = new LinkedHashMap<String, BigDecimal>(){{
			put("inv-burger1", BigDecimal.valueOf(15000));
			put("inv-kola2",BigDecimal.valueOf(14000));
		}};
	}
	
	@Test
	public void testComputation(){
		
		InvoiceComputation computation = new InvoiceComputation();
		Result result = computation.compute(invoiceElement, creditLimitElement);
		
		Assertions.assertTrue(BigDecimal.valueOf(29000).equals(result.getFinancedAmount()));
		Assertions.assertTrue(resultInvoice.equals(result.getFinancedInvoice()));
		Assertions.assertTrue(BigDecimal.valueOf(21000).equals(result.getRemainingCredit()));
	}
}
