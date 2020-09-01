package com.ecsail.gui.tabs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ecsail.enums.MemberType;
import com.ecsail.gui.boxes.BoxPerson;
import com.ecsail.gui.boxes.BoxSearch;
import com.ecsail.main.SqlSelect;
import com.ecsail.main.TabLauncher;
import com.ecsail.structures.Object_MembershipList;
import com.ecsail.structures.Object_Person;

import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class TabPeopleList extends Tab {

	//private Object_MembershipList membership;
	public static ObservableList<Object_Person> people;
	private static HBox personHBox = new HBox();
	TableColumn<Object_Person, Integer> Col1;
	TableColumn<Object_Person, Integer> Col2;
	TableColumn<Object_Person, MemberType> Col3;
	static TableColumn<Object_Person, String> Col4;
	static TableColumn<Object_Person, String> Col5;
	TableColumn<Object_Person, String> Col6;
	TableColumn<Object_Person, String> Col8;
	static TableView<Object_Person> personTableView;
	static int pick = 1;

	@SuppressWarnings("unchecked")
	public TabPeopleList(String text) {
		super(text);
		TabPeopleList.people = SqlSelect.getPeople();
		
		VBox vbox1 = new VBox(); // main vbox
		VBox vbox2 = new VBox(); // sepearates box search and box people
		HBox hbox = new HBox();  // main hbox

		vbox1.setId("box-blue");
		hbox.setId("box-pink");
		vbox1.setPadding(new Insets(12,12,15,12));
		hbox.setPadding(new Insets(3,3,5,3));
		vbox1.setAlignment(Pos.TOP_CENTER);
		vbox1.setPrefHeight(768);
		hbox.setSpacing(10);
		vbox2.setSpacing(5);
		
		personTableView = new TableView<>();
		personTableView.setItems(people);
		personTableView.setPrefWidth(518);
		personTableView.setFixedCellSize(30);
		personTableView.setPrefHeight(680);
		
		Col1 = new TableColumn<Object_Person, Integer>("P ID");
		Col1.setCellValueFactory(new PropertyValueFactory<Object_Person, Integer>("p_id"));
		
		Col2 = new TableColumn<Object_Person, Integer>("MSID");
		Col2.setCellValueFactory(new PropertyValueFactory<Object_Person, Integer>("ms_id"));
		
		Col3 = new TableColumn<Object_Person, MemberType>("Member Type");
		Col3.setPrefWidth(120);
		Col3.setEditable(false);
		Col3.setCellValueFactory(new Callback<CellDataFeatures<Object_Person, MemberType>, ObservableValue<MemberType>>() {
			 
	        @Override
	        public ObservableValue<MemberType> call(CellDataFeatures<Object_Person, MemberType> param) {
	        	Object_Person person = param.getValue();
	            int memberCode = person.getMemberType();
	            MemberType keel = MemberType.getByCode(memberCode);
	            return new SimpleObjectProperty<MemberType>(keel);
	        }
	    });
			
		Col4 = new TableColumn<Object_Person, String>("First Name");
		Col4.setCellValueFactory(new PropertyValueFactory<Object_Person, String>("fname"));
		
		Col5 = new TableColumn<Object_Person, String>("Last Name");
		Col5.setCellValueFactory(new PropertyValueFactory<Object_Person, String>("lname"));

		Col6 = new TableColumn<Object_Person, String>("Occupation");
		Col6.setCellValueFactory(new PropertyValueFactory<Object_Person, String>("occupation"));
		
		Col8 = new TableColumn<Object_Person, String>("Active");
		Col8.setCellValueFactory(new PropertyValueFactory<Object_Person, String>("active"));
		
		personTableView.getColumns().addAll(Col1, Col2, Col3, Col4, Col5, Col6, Col8);
		
		personTableView.setRowFactory(tv -> {
	        TableRow<Object_Person> row = new TableRow<>();
	        row.setOnMouseClicked(event -> {
	            if (! row.isEmpty() && event.getButton()==MouseButton.PRIMARY 
	                 && event.getClickCount() == 2) {
	                Object_Person clickedRow = row.getItem();
					createTab(clickedRow.getMs_id());
					System.out.println("clickedrow= " + clickedRow.getMs_id());
	            }
	            if (! row.isEmpty() && event.getButton()==MouseButton.PRIMARY 
		                 && event.getClickCount() == 1) {
		                Object_Person clickedRow = row.getItem();
		                createPersonBox(clickedRow);
						System.out.println("clickedrow= " + clickedRow.getP_id());
		        }
	            
	        });
	        return row ;
	    });
		
		vbox1.getChildren().add(hbox);
		vbox2.getChildren().addAll(new BoxSearch(personTableView), personHBox);
		hbox.getChildren().addAll(personTableView,vbox2);
		setContent(vbox1);
		
	}
	// creates array list of people objects populated from SQL database

	private static void createPersonBox(Object_Person person)  {
		Object_MembershipList membership = SqlSelect.getMembershipFromList(person.getMs_id());
		personHBox.getChildren().clear();  // remove if exists
		System.out.println("cleared the personHBox");
		personHBox.getChildren().add(new BoxPerson(person, membership));
	}

	private static void createTab(int msid)  {
		Object_MembershipList membership = SqlSelect.getMembershipFromList(msid);
		//System.out.println("membership=" + membership);
		TabLauncher.createTab(membership);
	}
	
	public void printPeople() {
	      for (Object_Person num : people) { 		      
	           System.out.println(num); 		
	      }
	}
	
	public Object_Person getPersonByPid(int pid) {
		int index = 0;
		int count = 0;
		for(Object_Person person : people) {
			if(person.getP_id() == pid) {
				System.out.println("Found pid " + pid);
				index = count; 
			}
			count++;
		}
		return people.get(index);  
	}
	
	public static int getIndexByPid(int pid) {
		int index = 0;
		int count = 0;
		for(Object_Person person : people) {
			if(person.getP_id() == pid) {
				System.out.println("Found pid " + pid);
				index = count; 
			}
			count++;
		}
		return index; 
	}
	
	public static void searchLastName(String searchString) {
		int count = 0;
		Pattern p = Pattern.compile("^" +searchString, Pattern.MULTILINE);
		boolean flag = true;
		for (Object_Person o : personTableView.getItems()) {
		Matcher m = p.matcher(o.getLname());
		
			while(m.find()) {
				System.out.println(m.group() + " found on row " + count);
				if(flag) {
					pick = count;
					flag = false;
				}
			}
		count++;
			  //System.out.println(Col5.getCellData(o));
		}
		Platform.runLater(new Runnable()
		{
		    @Override
		    public void run()
		    {
		    	personTableView.requestFocus();
		    	personTableView.getSelectionModel().select(pick);
		    	personTableView.scrollTo(pick);
		    }
		});
	}
}