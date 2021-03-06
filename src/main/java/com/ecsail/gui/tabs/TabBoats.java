package com.ecsail.gui.tabs;

import java.util.Arrays;

import com.ecsail.main.Launcher;
import com.ecsail.sql.SqlSelect;
import com.ecsail.structures.Object_Boat;
import com.ecsail.structures.Object_BoatList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TabBoats extends Tab {
	ObservableList<Object_BoatList> boats = FXCollections.observableArrayList();
	
	public TabBoats(String text) {
		super(text);
		this.boats = SqlSelect.getBoatsWithOwners();
		VBox vboxGrey = new VBox();  // this is the vbox for organizing all the widgets
		VBox vboxBlue = new VBox();
		VBox vboxPink = new VBox(); // this creates a pink border around the table
		TableView<Object_BoatList> boatListTableView = new TableView<>();

		
		boatListTableView.setItems(boats);
		boatListTableView.setFixedCellSize(30);
		boatListTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY );
		
		vboxBlue.setId("box-blue");
		vboxBlue.setPadding(new Insets(10,10,10,10));
		vboxPink.setPadding(new Insets(3,3,3,3)); // spacing to make pink from around table
		vboxPink.setId("box-pink");
		
		VBox.setVgrow(vboxGrey, Priority.ALWAYS);
		VBox.setVgrow(vboxPink, Priority.ALWAYS);
		VBox.setVgrow(boatListTableView, Priority.ALWAYS);
		HBox.setHgrow(boatListTableView, Priority.ALWAYS);
		
		TableColumn<Object_BoatList, Integer> Col1 = new TableColumn<Object_BoatList, Integer>("MEM");
		TableColumn<Object_BoatList, String> Col2 = new TableColumn<Object_BoatList, String>("Last Name");
		TableColumn<Object_BoatList, String> Col3 = new TableColumn<Object_BoatList, String>("First Name");
		TableColumn<Object_BoatList, String> Col4 = new TableColumn<Object_BoatList, String>("Model");
		TableColumn<Object_BoatList, String> Col5 = new TableColumn<Object_BoatList, String>("Registration");
		TableColumn<Object_BoatList, String> Col6 = new TableColumn<Object_BoatList, String>("Year");
		TableColumn<Object_BoatList, String> Col7 = new TableColumn<Object_BoatList, String>("Name");
		//TableColumn<Object_BoatList, String> Col8 = new TableColumn<Object_BoatList, String>("City");
		//TableColumn<Object_BoatList, String> Col9 = new TableColumn<Object_BoatList, String>("State");
		//TableColumn<Object_BoatList, String> Col10 = new TableColumn<Object_BoatList, String>("Zip");
		//TableColumn<Object_BoatList, String> Col11 = new TableColumn<Object_BoatList, String>("MSID");
		
		Col1.setCellValueFactory(new PropertyValueFactory<Object_BoatList, Integer>("membership_id"));
		Col2.setCellValueFactory(new PropertyValueFactory<Object_BoatList, String>("lname"));
		Col3.setCellValueFactory(new PropertyValueFactory<Object_BoatList, String>("fname"));
		Col4.setCellValueFactory(new PropertyValueFactory<Object_BoatList, String>("model"));
		Col5.setCellValueFactory(new PropertyValueFactory<Object_BoatList, String>("registration_num"));
		Col6.setCellValueFactory(new PropertyValueFactory<Object_BoatList, String>("manufacture_year"));
		Col7.setCellValueFactory(new PropertyValueFactory<Object_BoatList, String>("boat_name"));
		
		/// sets width of columns by percentage
		Col1.setMaxWidth( 1f * Integer.MAX_VALUE * 10 );  // Membership ID
		Col2.setMaxWidth( 1f * Integer.MAX_VALUE * 15 );  // Last Name
		Col3.setMaxWidth( 1f * Integer.MAX_VALUE * 15 );  // First Name
		Col4.setMaxWidth( 1f * Integer.MAX_VALUE * 20 );  // Model
		Col5.setMaxWidth( 1f * Integer.MAX_VALUE * 15 );  // Registration
		Col6.setMaxWidth( 1f * Integer.MAX_VALUE * 10 );  // Year
		Col7.setMaxWidth( 1f * Integer.MAX_VALUE * 15 );  // Boat Name
		//Col8.setMaxWidth( 1f * Integer.MAX_VALUE * 10 );  // City
		//Col9.setMaxWidth( 1f * Integer.MAX_VALUE * 5 );  // State
		//Col10.setMaxWidth( 1f * Integer.MAX_VALUE * 10 ); // Zip
		//Col11.setMaxWidth( 1f * Integer.MAX_VALUE * 5 ); // MSID
		
		/////////////////// LISTENERS  /////////////////////////
		boatListTableView.setRowFactory(tv -> {
			TableRow<Object_BoatList> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
					// int rowIndex = row.getIndex();
					Object_BoatList clickedRow = row.getItem();
					Object_Boat selectedBoat = SqlSelect.getBoatbyBoatId(clickedRow.getBoat_id());
					Launcher.openBoatViewTab(selectedBoat);
				}
			});
			return row;
		});
		////////////////// SET CONTENT ////////////////////////
		
		boatListTableView.getColumns()
		.addAll(Arrays.asList(Col1, Col2, Col3, Col4, Col5, Col6, Col7)); // , Col8, Col9, Col10, Col11
		
		vboxGrey.getChildren().add(boatListTableView);
		vboxBlue.getChildren().add(vboxPink);
		vboxPink.getChildren().add(vboxGrey);
		setContent(vboxBlue);
		
	}
	
}
