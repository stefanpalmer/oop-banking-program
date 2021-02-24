package edu.du.ict4315;


public class RegisterFactory {
	public static Register createRegister(RegisterType type, int registerNumber, Bank bank, String accountID, Double balance, int beginningCheckNumber ){
	    
        switch (type)
        {
            case CHECKING: 
            	return new CheckingRegister( registerNumber, bank, accountID, balance, beginningCheckNumber );
            case SAVINGS: 
            	return new SavingsRegister( registerNumber, bank, accountID, balance, beginningCheckNumber );
            case INVESTMENT: 
            	return new InvestmentRegister( registerNumber, bank, accountID, balance, beginningCheckNumber );
            default: 
            	return null;
        }
    }

}
