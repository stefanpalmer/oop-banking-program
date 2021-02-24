package edu.du.ict4315;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public class Check implements Printable {
	
	// Declare attributes
	private String accountID;
	private String bankID;
	private int positiveInteger;
	private String payee;
	private double amount;
	private Date date = new Date();
	
	// Formatters for output file and date
	private Formatter formatter;
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	
	// Constructor
	public Check(String accountID, String bankID, int positiveInteger,
			String payee, double amount, Date date) 
	{
		this.accountID = accountID;
		this.bankID = bankID;
		this.positiveInteger = positiveInteger;
		this.payee = payee;
		this.amount = amount;
		this.date = date;
	}
	
	// Getters and Setters
	public String getAccountID() {
		return accountID;
	}
	
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	
	public String getBankID() {
		return bankID;
	}

	public void setBankID(String bankID) {
		this.bankID = bankID;
	}

	public int getPositiveInteger() {
		return positiveInteger;
	}

	public void setPositiveInteger(int positiveInteger) {
		this.positiveInteger = positiveInteger;
	}
	
	public String getPayee() {
		return payee;
	}
	
	public void setPayee(String payee) {
		this.payee = payee;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	// Get check information method
	public String getCheckInfo() 
	{
		try 
		{
			return "<" + accountID + ">, <"
					+ payee + ">, <" + amount + ">, <" +
					date + ">";
		} 
		catch (NullPointerException ne)
		{
			return "There should be no null values.";
		}
		catch (IllegalArgumentException ie)
		{
			return "Incorrect argument/s passed for method";
		}
		catch (RuntimeException re)
		{
			return "Program crashes when it runs";
		}
		catch (Exception e)
		{
			return "General exception";
		}
		
	}

	// Print method
	@Override
	public void print() {
		try {
			formatter = new Formatter("checks.txt");
			formatter.format("---------------------------------------------"
					+ "%nAccount ID: %s "
					+ "%nPayee: %s  "
					+ "%nAmount: $%s "
					+ "%nDate: %s"
					+ "%n--------------------------------------------", 
					accountID, payee, amount, sdf.format(date));
			formatter.close();
		}
		catch (Exception e) {
			System.out.println("There is an error.");
		}
		
	}
}
