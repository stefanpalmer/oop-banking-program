package edu.du.ict4315;

import edu.du.ict4315.Address;

public class User implements java.io.Serializable {
	private String userID;
	private String firstName;
	private String lastName;
	private Address address;
	
	public User(String userID, String firstName, String lastName, Address address) 
	{
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getUserInfo() {
		try 
		{
			return "<" + userID + ">, <" + firstName + "<" + lastName + ">, <" +
					address.getMailingAddress() + ">";
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
