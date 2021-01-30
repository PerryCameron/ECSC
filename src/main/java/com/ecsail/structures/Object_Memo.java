package com.ecsail.structures;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Object_Memo {
	
	private IntegerProperty memo_id;
	private IntegerProperty msid;
	private StringProperty memo_date;
	private StringProperty memo;
	private IntegerProperty money_id;
	private StringProperty catagory;
	
	public Object_Memo(Integer memo_id, Integer msid, String memo_date,
			String memo, Integer money_id, String catagory) {
		super();
		this.memo_id = new SimpleIntegerProperty(memo_id);
		this.msid = new SimpleIntegerProperty(msid);
		this.memo_date = new SimpleStringProperty(memo_date);
		this.memo = new SimpleStringProperty(memo);
		this.money_id = new SimpleIntegerProperty(money_id);
		this.catagory = new SimpleStringProperty(catagory);
	}

	public final IntegerProperty memo_idProperty() {
		return this.memo_id;
	}
	

	public final int getMemo_id() {
		return this.memo_idProperty().get();
	}
	

	public final void setMemo_id(final int memo_id) {
		this.memo_idProperty().set(memo_id);
	}
	

	public final IntegerProperty msidProperty() {
		return this.msid;
	}
	

	public final int getMsid() {
		return this.msidProperty().get();
	}
	

	public final void setMsid(final int msid) {
		this.msidProperty().set(msid);
	}
	

	public final StringProperty memo_dateProperty() {
		return this.memo_date;
	}
	

	public final String getMemo_date() {
		return this.memo_dateProperty().get();
	}
	

	public final void setMemo_date(final String memo_date) {
		this.memo_dateProperty().set(memo_date);
	}
	

	public final StringProperty memoProperty() {
		return this.memo;
	}
	

	public final String getMemo() {
		return this.memoProperty().get();
	}
	

	public final void setMemo(final String memo) {
		this.memoProperty().set(memo);
	}
	

	public final IntegerProperty money_idProperty() {
		return this.money_id;
	}
	

	public final int getMoney_id() {
		return this.money_idProperty().get();
	}
	

	public final void setMoney_id(final int money_id) {
		this.money_idProperty().set(money_id);
	}
	

	public final StringProperty catagoryProperty() {
		return this.catagory;
	}
	

	public final String getCatagory() {
		return this.catagoryProperty().get();
	}
	

	public final void setCatagory(final String catagory) {
		this.catagoryProperty().set(catagory);
	}

}
