package com.ecsail.structures;

import javafx.scene.control.Label;

public class Object_MemLabels {
	
	private Label joinDate;
    private Label memberID;
    private Label memberType;
    private Label status;
    
	public Object_MemLabels() {
		this.joinDate = new Label();
		this.memberID = new Label();
		this.memberType = new Label();
		this.status = new Label();
	}
	
	public Label getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Label joinDate) {
		this.joinDate = joinDate;
	}

	public Label getMemberID() {
		return memberID;
	}

	public void setMemberID(Label memberID) {
		this.memberID = memberID;
	}

	public Label getMemberType() {
		return memberType;
	}

	public void setMemberType(Label memberType) {
		this.memberType = memberType;
	}

	public Label getStatus() {
		return status;
	}

	public void setStatus(Label status) {
		this.status = status;
	}

}
