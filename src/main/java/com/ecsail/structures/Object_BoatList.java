package com.ecsail.structures;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Object_BoatList extends Object_Boat{
	
	private IntegerProperty membership_id;
	private StringProperty lname;
	private StringProperty fname;
	
	public Object_BoatList(Integer boat_id, Integer ms_id, String manufacturer, String manufacture_year,
			String registration_num, String model, String boat_name, String sail_number,
			Boolean hasTrailer, String length, String weight, String keel, String phrf,
			String draft, String beam, String lwl, Integer membership_id, String lname, String fname) {
		
		super(boat_id, ms_id, manufacturer, manufacture_year, registration_num, model, boat_name,
				sail_number, hasTrailer, length, weight, keel, phrf, draft, beam, lwl);
		this.membership_id = new SimpleIntegerProperty(membership_id);
		this.lname = new SimpleStringProperty(lname);
		this.fname = new SimpleStringProperty(fname);
	}

	public final IntegerProperty membership_idProperty() {
		return this.membership_id;
	}
	

	public final int getMembership_id() {
		return this.membership_idProperty().get();
	}
	

	public final void setMembership_id(final int membership_id) {
		this.membership_idProperty().set(membership_id);
	}
	

	public final StringProperty lnameProperty() {
		return this.lname;
	}
	

	public final String getLname() {
		return this.lnameProperty().get();
	}
	

	public final void setLname(final String lname) {
		this.lnameProperty().set(lname);
	}
	

	public final StringProperty fnameProperty() {
		return this.fname;
	}
	

	public final String getFname() {
		return this.fnameProperty().get();
	}
	

	public final void setFname(final String fname) {
		this.fnameProperty().set(fname);
	}
	


}
