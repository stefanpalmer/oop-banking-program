package edu.du.ict4315;

import java.util.Date;

public interface Register {
	
	public void getEntriesInfo();
	public String getRegisterInfo();
	public void addEntry(Entry entry);
	public String reconcile();

}
