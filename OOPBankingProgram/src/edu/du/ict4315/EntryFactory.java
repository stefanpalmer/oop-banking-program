package edu.du.ict4315;

import java.util.Date;


public class EntryFactory {

	 public static Entry createEntry(String entryKind, double amount, Date date, EntryType entryType){
		 if (entryKind.equals("USER")) 
			 return new UserEntry(entryKind, amount, date, entryType);
	     else if (entryKind.equals("BANK")) 
	         return new BankEntry(entryKind, amount, date, entryType);
	     else
	        return null;
	 }
}
