package edu.du.ict4315;

import java.util.ArrayList;

public class InvestmentRegister implements Register {
	
	static RegisterType registerType = RegisterType.INVESTMENT;
	private int registerNumber;
	private Bank bank;
	private String accountID;
	private Double balance;
	private int beginningCheckNumber;
	private int endingCheckNumber;
	private ArrayList <Entry> entries = new <Entry> ArrayList();
	
	public InvestmentRegister(int registerNumber, Bank bank, String accountID, Double balance, int beginningCheckNumber)
	{
		this.registerNumber = registerNumber;
		this.bank = bank;
		this.accountID = accountID;
		this.balance = balance;
		this.beginningCheckNumber = beginningCheckNumber;
		this.endingCheckNumber = beginningCheckNumber;
	}
	
	@Override
	public void getEntriesInfo() {
		for (int i=0; i < entries.size(); i++)
		{
			System.out.println(entries.get(i).writeEntry());
		}
	}

	@Override
	public String getRegisterInfo() {
		return "<" + registerNumber + ">, <" + bank.getBankInfo() + ">, <" + accountID + ">, <$" + balance +
				">, <" + beginningCheckNumber + ">, <" + endingCheckNumber + ">";
	}

	@Override
	public void addEntry(Entry entry) {
		entries.add(entry);
		
	}

	@Override
	public String reconcile() {
		Double userBalance = 0.00;
		Double bankBalance = 0.00;
		for (int i=0; i < entries.size(); i++)
		{
			if (entries.get(i).getEntryKind().equals("USER")) 
			{
				userBalance += entries.get(i).getEntryAmount();
			}
			else if (entries.get(i).getEntryKind().contentEquals("BANK"))
			{
				bankBalance += entries.get(i).getEntryAmount();
			}
			else
			{
				System.out.println("Information is not collected correctly.");
			}
		}
		if (userBalance.equals(bankBalance))
		{
			return "The user and bank entries match.";
		}
		else
		{
			Double balanceDifference = userBalance - bankBalance;
			return "The user and bank entries do not match.\nThere is a $" + balanceDifference + 
					" difference in the user balance";
		}
	}

}
