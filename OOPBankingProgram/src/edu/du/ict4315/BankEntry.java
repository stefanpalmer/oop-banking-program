package edu.du.ict4315;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public class BankEntry implements Entry {
	
	// Declare attributes
	private String entryKind;
	private Double entryAmount;
	private Date entryDate;
	private EntryType entryType;
	
	// Formatters for output file and date
	private Formatter formatter;
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
	// Constructor
	public BankEntry(String entryKind, Double entryAmount, Date entryDate, EntryType entryType) {
		this.entryKind = entryKind;
		this.entryAmount = entryAmount;
		this.entryDate = entryDate;
		this.entryType = entryType;
	}
	
	// Getters and Setters
	public String getEntryKind() {
		return this.entryKind;
	}
	
	public void setEntryKind(String entryKind) {
		this.entryKind = entryKind;
	}
	
	public Double getEntryAmount() {
		return this.entryAmount;
	}
	
	public void setEntryAmount(Double entryAmount) {
		this.entryAmount = entryAmount;
	}
	
	public Date getEntryDate() {
		return this.entryDate;
	}
	
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
	public EntryType getEntryType() {
		return this.entryType;
	}
	
	public void setEntryType(EntryType entryType) {
		this.entryType = entryType;
	}

	// Create entry method
	@Override
	public String writeEntry() {
		try {
			return "<" + entryKind + ">, <$" + entryAmount + ">, <" + entryDate + ">, <" + entryType + ">";
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
			formatter = new Formatter("bankEntries.txt");
			formatter.format("Entry Amount: $%s Entry Date: %s  Entry Type: %s", 
					entryAmount, sdf.format(entryDate), entryType);
			formatter.close();
		}
		catch (Exception e) {
			System.out.println("There is an error.");
		}
		
	}



}
