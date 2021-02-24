package edu.du.ict4315;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import edu.du.ict4315.Address;
import edu.du.ict4315.Bank;
import edu.du.ict4315.Check;
import edu.du.ict4315.User;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		// Scanner object
		Scanner sc = new Scanner(System.in);
		// Variable to store choice
		String choice = new String();
		
		// Give choice for object
		while (true) {
			System.out.println("Choose number to create profile or entry: ");
			System.out.println("1. Bank");
			System.out.println("2. User");
			System.out.println("3. Check");
			System.out.println("4. Entry");
			choice = sc.nextLine();
			if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4"))
			{
				break;
			}
			else
			{
				System.out.println("Please choose a number from 1 to 4");
			}
		}
		
		// Input for bank object
		if (choice.equals("1")) {
			System.out.println("Enter bank ID: ");
			String bankID = sc.nextLine();
			System.out.println("Enter bank name: ");
			String bankName = sc.nextLine();
			System.out.println("Enter bank street address: ");
			String addressStreetOne = sc.nextLine();
			System.out.println("Enter second bank street address (if there is one): ");
			String addressStreetTwo = sc.nextLine();
			System.out.println("Enter bank city: ");
			String addressCity = sc.nextLine();
			System.out.println("Enter bank state: ");
			String addressState = sc.nextLine();
			System.out.println("Enter bank zipcode: ");
			String addressZip = sc.nextLine();
			System.out.println("Enter bank phone number: ");
			String phoneNumber = sc.nextLine();
			// Create address object
			Address address = new Address(addressStreetOne, addressStreetTwo, addressCity, addressState, addressZip);
			// Create bank object
			Bank bank = new Bank(bankID, bankName, address, phoneNumber);
			System.out.println(bank.getBankInfo());
		}
		// Input for user object
		else if (choice.equals("2")) {
			
			System.out.println("Enter user ID: ");
			String userID = sc.nextLine();
			System.out.println("Enter user first name: ");
			String firstName = sc.nextLine();
			System.out.println("Enter user last name: ");
			String lastName = sc.nextLine();
			System.out.println("Enter user street address: ");
			String addressStreet = sc.nextLine();
			System.out.println("Enter user second street address (if there is one): ");
			String addressStreetTwo = sc.nextLine();
			System.out.println("Enter user's city: ");
			String addressCity = sc.nextLine();
			System.out.println("Enter user's state: ");
			String addressState = sc.nextLine();
			System.out.println("Enter user's zipcode: ");
			String addressZip = sc.nextLine();
			
			// Create address object
			Address address = new Address(addressStreet, addressStreetTwo, addressCity, addressState, addressZip);
			// Create user object
			User user = new User(userID, firstName, lastName, address);
			
			// Serialize
			FileOutputStream fileOut = new FileOutputStream("userresult.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(user);
			out.close();
			fileOut.close();
			System.out.println("Serialized data saved.");
			
			// Deserialize
			while(true)
			{
				System.out.println("Do you want to deserialize the object? ");
				System.out.println("1. Yes");
				System.out.println("2. No");
				String deserialize = sc.nextLine();
				if (deserialize.equals("1"))
				{
					FileInputStream fileIn = new FileInputStream("userresult.txt");
					ObjectInputStream in = new ObjectInputStream(fileIn);
					User userOut = (User)in.readObject();
					System.out.println("Deserialized: " + userOut.getUserInfo());
					in.close();
					fileIn.close();
					break;
				}
				else if (deserialize.equals("2"))
				{
					break;
				}
				else
				{
					System.out.println("Please choose 1 for yes or 2 for no.");
				}
			}
		}
		
		// Input for check object
		else if (choice.equals("3")) {
			System.out.println("Enter account ID: ");
			String accountID = sc.nextLine();
			System.out.println("Enter bank ID: ");
			String bankID = sc.nextLine();
			System.out.println("Enter positive integer: ");
			int positiveInteger = Integer.parseInt(sc.nextLine());
			System.out.println("Enter payee: ");
			String payee = sc.nextLine();
			System.out.println("Enter amount: ");
			Double amount = Double.parseDouble(sc.nextLine());
			Date date = new Date();
			Check check = new Check(accountID, bankID, positiveInteger, payee, amount, date);
			check.print();
			System.out.println(check.getCheckInfo());
		}
		// Input for entry object
		else if (choice.equals("4")) {
			// Initialize entry and register
			Entry entry = null;
			Register register = null;
			
			// Store register chosen
			String registerChoice = new String();
			RegisterType registerType = null;
			
			while (true)
			{
				System.out.println("What type of register will you store this entry in?");
				System.out.println("1. Checking");
				System.out.println("2. Savings");
				System.out.println("3. Investment");
				registerChoice = sc.nextLine();
				if (registerChoice.equals("1") || registerChoice.equals("2") || registerChoice.equals("3"))
				{
					break;
				}
				else
				{
					System.out.println("Please choose number 1, 2, or 3");
				}
			}
			
			// Register number
			System.out.println("Enter register number: ");
			int registerNumber = Integer.parseInt(sc.nextLine());
			
			// Bank information
			System.out.println("Bank Information");
			System.out.println("=================");
			System.out.println("Enter bank ID: ");
			String bankID = sc.nextLine();
			System.out.println("Enter bank name: ");
			String bankName = sc.nextLine();
			// Bank Address information
			System.out.println("Bank Address information");
			System.out.println("=========================");
			System.out.println("Enter bank street address: ");
			String addressStreet = sc.nextLine();
			System.out.println("Enter bank second street address (if there is one): ");
			String addressStreetTwo = sc.nextLine();
			System.out.println("Enter bank's city: ");
			String addressCity = sc.nextLine();
			System.out.println("Enter bank's state: ");
			String addressState = sc.nextLine();
			System.out.println("Enter bank's zipcode: ");
			String addressZip = sc.nextLine();
			System.out.println("Enter bank phone number: ");
			String bankPhoneNumber = sc.nextLine();
			
			// Account ID
			System.out.println("Enter account ID: ");
			String accountID = sc.nextLine();
			
			// Balance
			System.out.println("Enter balance: ");
			Double balance = Double.parseDouble(sc.nextLine());
			
			// Check number
			System.out.println("Enter check number: ");
			int checkNumber = Integer.parseInt(sc.nextLine());
			
			// Store address and bank objects
			Address address = new Address(addressStreet, addressStreetTwo, addressCity, 
					addressState, addressZip);
			Bank bank = new Bank(bankID, bankName, address, bankPhoneNumber);
			
			// Create register based on register type
			if (registerChoice.equals("1"))
			{
				register = RegisterFactory.createRegister(registerType.CHECKING, registerNumber, 
						bank, accountID, balance, checkNumber);
			}
			else if (registerChoice.equals("2"))
			{
				register = RegisterFactory.createRegister(registerType.SAVINGS, registerNumber, 
						bank, accountID, balance, checkNumber);
			}
			else if (registerChoice.equals("3"))
			{
				register = RegisterFactory.createRegister(registerType.INVESTMENT, registerNumber, 
						bank, accountID, balance, checkNumber);
			}
			else
			{
				System.out.println("Invalid input.");
			}
			
			System.out.println(register.getRegisterInfo());
			
			while (true) {
				// Choose user or bank entry
				String entryKind = new String();
				while (true) 
				{
					System.out.println("Do you need to enter a user entry or a bank entry?");
					System.out.println("1. User entry");
					System.out.println("2. Bank entry");
					String entryNumber = sc.nextLine();
					if (entryNumber.equals("1")) 
					{
						entryKind = "USER";
						break;
					}
					else if (entryNumber.equals("2"))
					{
						entryKind = "BANK";
						break;
					}
					else
					{
						System.out.println("Please choose between number 1 or 2");
					}
				}
				
				System.out.println(entryKind);
				
				// Enter amount to be stored
				System.out.println("What is the amount you need to enter: ");
				Double amountToEnter = Double.parseDouble(sc.nextLine());
				
				// Get current date
				Date date = new Date();
				System.out.println("The current date is " + date);
				
				// Choose entry type
				while (true) {
					System.out.println("Choose entry type: ");
					System.out.println("1. ATM Deposit");
					System.out.println("2. ATM Withdrawal");
					System.out.println("3. Overdraft fee");
					System.out.println("4. Transaction fee");
					System.out.println("5. Teller withdrawal");
					System.out.println("6. Teller deposit");
					// Initialize variables for choosing entry type
					String numberSelected = sc.nextLine();
					EntryFactory entryFactory = new EntryFactory();
					EntryType entryType = null;
					
					// Create entry based on entry type choice
					if (numberSelected.equals("1"))
					{
						entry = entryFactory.createEntry(entryKind, amountToEnter, date, entryType.ATM_DEPOSIT);
						System.out.println(entry.writeEntry());
						break;
					}
					else if (numberSelected.equals("2"))
					{
						entry = entryFactory.createEntry(entryKind, amountToEnter, date, entryType.ATM_WITHDRAWAL);
						System.out.println(entry.writeEntry());
						break;
					}
					else if (numberSelected.equals("3"))
					{
						entry = entryFactory.createEntry(entryKind, amountToEnter, date, entryType.OVERDRAFT_FEE);
						System.out.println(entry.writeEntry());
						break;
					}
					else if (numberSelected.equals("4"))
					{
						entry = entryFactory.createEntry(entryKind, amountToEnter, date, entryType.TRANSACTION_FEE);
						System.out.println(entry.writeEntry());
						break;
					}
					else if (numberSelected.equals("5"))
					{
						entry = entryFactory.createEntry(entryKind, amountToEnter, date, entryType.TELLER_WITHDRAWAL);
						System.out.println(entry.writeEntry());
						break;
					}
					else if (numberSelected.equals("6"))
					{
						entry = entryFactory.createEntry(entryKind, amountToEnter, date, entryType.TELLER_DEPOSIT);
						System.out.println(entry.writeEntry());
						break;
					}
					else
					{
						System.out.println("Please enter a number between 1 and 6.");
					}
				}
				
				// Add entries to register
				register.addEntry(entry);
				// Print out entries
				System.out.println("Entries in Register: ");
				System.out.println("====================");
				// Output register information
				register.getEntriesInfo();
				
				// Option to add more entries
				String moreEntries = new String();
				while (true)
				{
					System.out.println("Would you like to add more entries?");
					System.out.println("1. Yes");
					System.out.println("2. No");
					moreEntries = sc.nextLine();
					if (moreEntries.equals("1") || moreEntries.equals("2"))
					{
						break;
					}
					else
					{
						System.out.println("Please choose number 1 or 2");
					}
				}
				
				if (moreEntries.equals("2"))
				{
					break;
				}
				else 
				{
					System.out.println("ANOTHER ENTRY");
				}
			}
			
			// Reconcile
			System.out.println(register.reconcile());	
			
		}
			
		// If input is invalid
		else 
		{
			System.out.println("Input is not valid");
		}
		
		// Close scanner
		System.out.println("Transactions complete!");
		sc.close();
	
	}

}
