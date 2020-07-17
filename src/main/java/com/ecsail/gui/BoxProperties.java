package com.ecsail.gui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ecsail.enums.MembershipType;
import com.ecsail.main.SqlUpdate;
import com.ecsail.structures.Object_MemLabels;
import com.ecsail.structures.Object_Membership;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BoxProperties extends HBox {
	private Object_Membership membership;
	private Object_MemLabels labels;
	//private String currentYear;
	public BoxProperties(Object_Membership m, Object_MemLabels l, Tab membershipTab) {
		super();
		this.membership = m;
		this.labels = l;
		//this.currentYear = new SimpleDateFormat("yyyy").format(new Date());
		//////////// OBJECTS ///////////////
		HBox hboxGrey = new HBox();  // this is the vbox for organizing all the widgets
		//VBox vboxPink = new VBox(); // this creates a pink border around the table
		VBox mainVBox = new VBox(); // contains viewable children
        HBox hbox1 = new HBox();  // holds membershipID, Type and Active
        HBox hbox2 = new HBox();  // holds PersonVBoxes (2 instances require a genereic HBox
        HBox hbox3 = new HBox();  // holds address, city, state, zip
        HBox hbox4 = new HBox();

		Button changeIDButton = new Button("Update");
		TextField changeMembershipIDTextField = new TextField();
		CheckBox activeCheckBox = new CheckBox("Membership Active");
		ComboBox<MembershipType> combo_box = new ComboBox<MembershipType>();
		DatePicker joinDatePicker = new DatePicker();
		
		/////////////  ATTRIBUTES /////////////
		changeMembershipIDTextField.setPrefWidth(50);
		changeMembershipIDTextField.setText(membership.getMembershipId() + "");
        hbox1.setSpacing(5);  // membership HBox
        hbox1.setAlignment(Pos.CENTER_LEFT);
        activeCheckBox.setSelected(membership.isActiveMembership());
        hbox2.setSpacing(5);  // membership HBox
        hbox2.setAlignment(Pos.CENTER_LEFT);
        hbox4.setSpacing(5);  // membership HBox
        hbox4.setAlignment(Pos.CENTER_LEFT);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(membership.getJoinDate(), formatter);
        joinDatePicker.setValue(date);
        combo_box.setValue(MembershipType.getByCode(membership.getMemType()));
		hboxGrey.setPadding(new Insets(5, 5, 5, 10));
		hboxGrey.setPrefWidth(942);
		mainVBox.setSpacing(10);
		setPadding(new Insets(5, 5, 5, 5));  // creates space for blue frame
		setId("box-blue");
		hboxGrey.setId("box-grey");
		combo_box.getItems().setAll(MembershipType.values());
		
		///////////// LISTENERS ////////////
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				LocalDate date = joinDatePicker.getValue();
				SqlUpdate.updateMembership("JOIN_DATE", membership.getMsid(), date);
				membership.setJoinDate(joinDatePicker.getValue().toString());
		        labels.getJoinDate().setText(joinDatePicker.getValue().toString());
			}
		};
		joinDatePicker.setOnAction(event);
		
		activeCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            	SqlUpdate.updateMembership(newValue, membership.getMsid());
            	membership.setActiveMembership(newValue);  // update the status in the main object
            	labels.getStatus().setText(getStatus());  // update the Membership status label at top of membership view
            }
        });
		
		changeIDButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	String newID = changeMembershipIDTextField.getText();
            	if(SqlUpdate.updateMembership("MEMBERSHIP_ID", membership.getMsid(), newID))
            	if(!newID.equals("")) membership.setMembershipId(Integer.parseInt(newID));
            	labels.getMemberID().setText(newID);  // sets labels in BoxMembership
            	membershipTab.setText("Membership " + newID);
            }
        });
		
        combo_box.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
        	SqlUpdate.updateMembership("MEM_TYPE", membership.getMsid(), newValue.getCode());
            membership.setMemType(newValue.getCode());
            labels.getMemberType().setText("" + MembershipType.getByCode(newValue.getCode()));
        });
		
		///////////// SET CONTENT ////////////////////
		hbox1.getChildren().addAll(new Label("Change Membership ID:"),changeMembershipIDTextField,changeIDButton);
		hbox2.getChildren().addAll(new Label("Change join date:"),joinDatePicker);
		hbox3.getChildren().addAll(activeCheckBox);
		hbox4.getChildren().addAll(new Label("Membership Type"),combo_box);
		mainVBox.getChildren().addAll(hbox1,hbox2,hbox3,hbox4);
		hboxGrey.getChildren().addAll(mainVBox);
		getChildren().add(hboxGrey);
	}
	
	private String getStatus() {
		String result = "not active";
		if(membership.isActiveMembership()) 
			result = "active";
		return result;
	}
}
