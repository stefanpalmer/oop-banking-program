package edu.du.ict4315;

import java.util.Date;

public interface Entry extends Printable {
	
	public String writeEntry();
	public String getEntryKind();
	public Double getEntryAmount();
	
}
