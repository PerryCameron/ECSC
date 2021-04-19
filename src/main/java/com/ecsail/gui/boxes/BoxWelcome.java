package com.ecsail.gui.boxes;

import com.ecsail.main.CreateMembership;
import com.ecsail.main.Launcher;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
// this is the contents inside tabWelcome() launched from ConnectDatabase() about line 229
public class BoxWelcome extends HBox {
	
	public BoxWelcome() {
		Charts.populateCharts();
		int width = 400;
		int height = 70;
		VBox vboxLeft = new VBox();
		VBox vboxRight = new VBox();
		//Pane mainPane = new Pane();
		Button peopleListButton = new Button("People");
		Button slipListButton = new Button("Slips");
		Button bodButton = new Button("Board of Directors");
		Button newButton = new Button("Create New Membership");
		Button batchesButton = new Button("Deposits");
		Button rosterButton = new Button("Rosters");
		Button boatsButton = new Button("Boats");
		Button notesButton = new Button("Notes");
		
		////////////////  ATTRIBUTES //////////////////////////////
		
		
		vboxLeft.setPrefWidth(570);
		notesButton.setId("bigbuttontext");
		boatsButton.setId("bigbuttontext");
		newButton.setId("bigbuttontext");
		bodButton.setId("bigbuttontext");
		peopleListButton.setId("bigbuttontext");
		slipListButton.setId("bigbuttontext");
		batchesButton.setId("bigbuttontext");
		rosterButton.setId("bigbuttontext");
		vboxRight.setSpacing(10);
		vboxRight.setPadding(new Insets(30,0,0,0));
		notesButton.setPrefSize(width, height);
		boatsButton.setPrefSize(width, height);
		peopleListButton.setPrefSize(width, height);
		slipListButton.setPrefSize(width, height);
		bodButton.setPrefSize(width, height);
		newButton.setPrefSize(width, height);
		batchesButton.setPrefSize(width, height);
		rosterButton.setPrefSize(width, height);
		
		///////////////// LISTENERS  /////////////////////////

		
		boatsButton.setOnAction((event) -> Launcher.openBoatsTab());
		notesButton.setOnAction((event) -> Launcher.openNotesTab());
		rosterButton.setOnAction((event) -> Launcher.openRosterTab());
		peopleListButton.setOnAction((event) -> Launcher.openPeopleTab());
		slipListButton.setOnAction((event) -> Launcher.openSlipsTab());
		bodButton.setOnAction((event) -> Launcher.openBoardTab());
		newButton.setOnAction((event) -> CreateMembership.Create());
		batchesButton.setOnAction((event) -> Launcher.openTabBatchedPaidDues());

		////////////////  SET CONTENT ////////////////////////
		vboxRight.getChildren().addAll(rosterButton,peopleListButton,slipListButton,bodButton,newButton,batchesButton,boatsButton,notesButton);
		vboxLeft.getChildren().addAll(Charts.getStackedBarChart(),Charts.getLineChart());
		//vboxLeft.getChildren().addAll(Charts.getLineChart());
		getChildren().addAll(vboxLeft,vboxRight);
	}

}
