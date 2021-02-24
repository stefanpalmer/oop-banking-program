package edu.du.ict4315;

import edu.du.ict4315.Address;

public class Bank {
	private String bankID;
	private String name;
	private Address address;
	private String phoneNumber;
	
	public Bank (String bankID, String name, Address address, String phoneNumber) 
	{
		this.bankID = bankID;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public String getBankID() {
		return bankID;
	}
	
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getBankInfo() {
		try 
		{
			return "<" + bankID + ">, <" + name + ">, <" + address.getMailingAddress() + ">, <" 
					+ phoneNumber + ">";
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
}
