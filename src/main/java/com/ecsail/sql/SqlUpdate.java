package com.ecsail.sql;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.time.LocalDate;

import com.ecsail.main.BoxConsole;
import com.ecsail.main.ConnectDatabase;
import com.ecsail.main.Main;
import com.ecsail.main.Paths;
import com.ecsail.structures.Object_MembershipId;
import com.ecsail.structures.Object_MembershipList;
import com.ecsail.structures.Object_Money;
import com.ecsail.structures.Object_Person;
import com.ecsail.structures.Object_Stats;
import com.ecsail.structures.Object_WorkCredit;
import com.ecsail.gui.dialogues.*;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class SqlUpdate {
	
	static Alert alert = new Alert(AlertType.ERROR);

	
	public static final void updateBoat(String field, int boat_id, String attribute) {
		try {			
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			if(attribute == null) 
				stmt.execute(Main.console.setRegexColor(
					"UPDATE boat SET " + field + "=null WHERE boat_id='" + boat_id + "';"));
			else if(attribute.equals("")) 
				stmt.execute(Main.console.setRegexColor(
						"UPDATE boat SET " + field + "=null WHERE boat_id='" + boat_id + "';"));
			else
			stmt.execute(Main.console.setRegexColor(
					"UPDATE boat SET " + field + "=\"" + attribute + "\" WHERE boat_id='" + boat_id + "';"));

			Main.edits.setBoatEdits(Main.edits.getBoatEdits() + 1);  // count number of edits.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static final void updateBoat(int boat_id, Boolean hasTrailer) {
		Statement stmt;
		try {
			stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console
					.setRegexColor("UPDATE boat SET has_trailer=" + hasTrailer + " WHERE boat_id='" + boat_id + "';"));
			Main.edits.setBoatEdits(Main.edits.getBoatEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}

	public static final void updateBoat(int boat_id, String keel) {
		Statement stmt;
		try {
			stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE boat SET keel=\"" + keel + "\" WHERE boat_id='" + boat_id + "';"));
			Main.edits.setBoatEdits(Main.edits.getBoatEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static void updateAddress(String address,Object_MembershipList membership) {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE membership SET address=\"" + address
					+ "\" WHERE ms_id='" + membership.getMsid() + "';"));
			Main.edits.setMembershipEdits(Main.edits.getMembershipEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
		membership.setAddress(address);
	}
	
	public static void updateCity(String city,Object_MembershipList membership) {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE membership SET city=\"" + city
					+ "\" WHERE ms_id='" + membership.getMsid() + "';"));
			Main.edits.setMembershipEdits(Main.edits.getMembershipEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
		membership.setCity(city);
	}
	
	public static void updateState(String state,Object_MembershipList membership) {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE membership SET state=\"" + state
				+ "\" WHERE ms_id='" + membership.getMsid() + "';"));
			membership.setState(state);
			Main.edits.setMembershipEdits(Main.edits.getMembershipEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
		
	}
	
	public static void updateZipcode(String zip,Object_MembershipList membership) {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE membership SET zip=\"" + zip
					+ "\" WHERE ms_id='" + membership.getMsid() + "';"));
			Main.edits.setMembershipEdits(Main.edits.getMembershipEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
		membership.setZip(zip);
	}
	
	public static void updateMembershipPrimary(int ms_id, int pid) {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE membership SET p_id=" + pid
					+ " WHERE ms_id='" + ms_id + "';"));
			Main.edits.setMembershipEdits(Main.edits.getMembershipEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static Boolean updateMembership(String field, int ms_id, String attribute) {
		Boolean noError = true;
		Statement stmt;
		try {
			stmt = ConnectDatabase.sqlConnection.createStatement();
			if(attribute.equals("")) {
			stmt.execute(Main.console.setRegexColor(
						"UPDATE membership SET " + field + "= null WHERE ms_id='" + ms_id + "';"));	
			} else {
			stmt.execute(Main.console.setRegexColor(
					"UPDATE membership SET " + field + "=\"" + attribute + "\" WHERE ms_id='" + ms_id + "';"));
			}
			Main.edits.setMembershipEdits(Main.edits.getMembershipEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			noError = false;
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
		return noError;
	}
	
	public static Boolean updateMembership(int ms_id, String field, LocalDate date) {
		Boolean noError = true;
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor(
					"UPDATE membership SET " + field + "=\"" + date + "\" WHERE ms_id='" + ms_id + "';"));
			Main.edits.setMembershipEdits(Main.edits.getMembershipEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			noError = false;
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
		return noError;
	}
	
	public static Boolean updateDeposit(String field, int deposit_id, LocalDate date) {
		Boolean noError = true;
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor(
					"UPDATE deposit SET " + field + "=\"" + date + "\" WHERE deposit_id='" + deposit_id + "';"));
			Main.edits.setDepositsEdits(Main.edits.getDepositsEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			noError = false;
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
		return noError;
	}
	
	public static void updateListed(String field, int phone_id, Boolean attribute) {
		Statement stmt;
		try {
			stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor(
					"UPDATE phone SET " + field + "=" + attribute + " WHERE phone_id='" + phone_id + "';"));
			Main.edits.setPhoneEdits(Main.edits.getPhoneEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static void updateWaitList(int ms_id, String field, Boolean attribute) {
		Statement stmt;
		try {
			stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor(
					"UPDATE waitlist SET " + field + "=" + attribute + " WHERE ms_id='" + ms_id + "';"));
			Main.edits.setPhoneEdits(Main.edits.getPhoneEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static void updatePhone(String field, int phone_id, String attribute) {
		Statement stmt;
		try {
			stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor(
					"UPDATE phone SET " + field + "=\"" + attribute + "\" WHERE phone_id='" + phone_id + "';"));
			Main.edits.setPhoneEdits(Main.edits.getPhoneEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static void updateEmail(String field, int email_id, Boolean attribute) {  // overload so compact
		Statement stmt;
		try {
			stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor(
					"UPDATE email SET " + field + "=" + attribute + " WHERE email_id='" + email_id + "';"));
			Main.edits.setEmailEdits(Main.edits.getEmailEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static final void updateEmail(int email_id, String email) {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE email SET email=\"" + email + "\" WHERE email_id='" + email_id + "';"));
			Main.edits.setEmailEdits(Main.edits.getEmailEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static void updateOfficer(String field, int officer_id, String attribute) {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE officer SET " + field + "=\"" + attribute + "\" WHERE o_id='" + officer_id + "';"));
			Main.edits.setOfficersEdits(Main.edits.getOfficersEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Duplicate");
			alert.setContentText("Duplicate entry!");
			alert.showAndWait();
		}
	}
	
	public static void updateAward(String field, int awardId, String attribute) {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE awards SET " + field + "=\"" + attribute + "\" WHERE award_id='" + awardId + "';"));
			Main.edits.setOfficersEdits(Main.edits.getOfficersEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Duplicate");
			alert.setContentText("Duplicate entry!");
			alert.showAndWait();
		}
	}
	
	public static void updateBirthday(LocalDate date, Object_Person person) {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE person SET birthday=\"" + date
					+ "\" WHERE p_id='" + person.getP_id() + "';"));
			Main.edits.setPeopleEdits(Main.edits.getPeopleEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static void updateNickName(String nname, Object_Person person) {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE person SET NICK_NAME=\"" + nname
					+ "\" WHERE p_id='" + person.getP_id() + "';"));
			Main.edits.setPeopleEdits(Main.edits.getPeopleEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"Unable to save nickname","");
		}
	}
	
	public static void updateBuisness(String buisness, Object_Person person ) {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE person SET buisness=\"" + buisness
					+ "\" WHERE p_id='" + person.getP_id() + "';"));
			Main.edits.setPeopleEdits(Main.edits.getPeopleEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static void updateOccupation(String occupation, Object_Person person) {	
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE person SET occupation=\"" + occupation
					+ "\" WHERE p_id='" + person.getP_id() + "';"));
			Main.edits.setPeopleEdits(Main.edits.getPeopleEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static void updateLastName(String lname, Object_Person person)  { // Business
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE person SET l_name=\"" + lname
					+ "\" WHERE p_id='" + person.getP_id() + "';"));
			Main.edits.setPeopleEdits(Main.edits.getPeopleEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static void updateFirstName(String fname, Object_Person person) {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE person SET f_name=\"" + fname
					+ "\" WHERE p_id='" + person.getP_id() + "';"));
			Main.edits.setPeopleEdits(Main.edits.getPeopleEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static void updatePerson(String field, int p_id, Boolean attribute) { // updates active/inactive
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE person SET " + field + "=" + attribute + " WHERE p_id='" + p_id + "';"));
			Main.edits.setPeopleEdits(Main.edits.getPeopleEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static void updatePerson(int p_id, String field, int attribute) { // updates active/inactive
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE person SET " + field + "=" + attribute + " WHERE p_id='" + p_id + "';"));
			Main.edits.setPeopleEdits(Main.edits.getPeopleEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static void updateSlip(int ms_id, Object_MembershipList membership) {  // ms_id in this case came from the text field and is converted from membership_id
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("update slip set subleased_to='" + ms_id + "' where ms_id='" + membership.getMsid() + "';"));
			membership.setSubleaser(ms_id);
			Main.edits.setSlipsEdits(Main.edits.getSlipsEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static void releaseSlip(Object_MembershipList membership) {  // this releases the slip using the slip owners ms_id
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("update slip set subleased_to=null where ms_id='" + membership.getMsid() + "';"));
			BoxConsole.setInfoLine("Released sublease for slip owner " + membership.getMsid(), "orange");
			membership.setSubleaser(0);
			Main.edits.setSlipsEdits(Main.edits.getSlipsEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static void subleaserReleaseSlip(int subleasee) {  // this releases the slip using the subleasee ms_id
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("update slip set subleased_to=null where subleased_to='" + subleasee + "';"));
			BoxConsole.setInfoLine("Released sublease for subleaser " + subleasee, "orange");
			Object_MembershipList ownerMembership = Sql_SelectMembership.getMembershipFromList(subleasee, Paths.getYear());
			ownerMembership.setSubleaser(0);
			Main.edits.setSlipsEdits(Main.edits.getSlipsEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static void reAssignSlip(int ms_id, Object_MembershipList membership) {  // this reassignes the slip using the subleasee ms_id (came from text field)
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("update slip set ms_id='" + ms_id + "' where ms_id='" + membership.getMsid() + "';"));
			String slip = membership.getSlip();
			membership.setSlip("0");
			Object_MembershipList newSlipOwnerMembership = Sql_SelectMembership.getMembershipFromList(ms_id, Paths.getYear());
			newSlipOwnerMembership.setSlip(slip);
			Main.edits.setSlipsEdits(Main.edits.getSlipsEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static final void commitFiscalRecord(int money_id, Boolean commit) {
		Statement stmt;
		try {
			stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console
					.setRegexColor("UPDATE money SET commited=" + commit + " WHERE money_id='" + money_id + "';"));
			Main.edits.setMoniesEdits(Main.edits.getMoniesEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static final void updateField(int newValue, String table, String field, ObservableList<Object_Money> fiscals, int rowIndex)  {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE " + table + " SET " + field + "=\"" + newValue
					+ "\" WHERE money_id='" + fiscals.get(rowIndex).getMoney_id() + "';"));
			Main.edits.setMoniesEdits(Main.edits.getMoniesEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static final void updateMoney(Object_Money money) {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE money SET extra_key=" 
					+ money.getExtra_key() 
					+ ",kayak_shed_key=" + money.getKayac_shed_key() 
					+ ",sail_loft_key=" + money.getSail_loft_key()
					+ ",sail_school_loft_key=" + money.getSail_school_loft_key()
					+ ",beach=" + money.getBeach()
					+ ",wet_slip=" + money.getWet_slip()
					+ ",kayak_rack=" + money.getKayac_rack()
					+ ",kayak_shed=" + money.getKayac_shed()
					+ ",sail_loft=" + money.getSail_loft()
					+ ",sail_school_laser_loft=" + money.getSail_school_laser_loft()
					+ ",winter_storage=" + money.getWinter_storage()
					+ ",ysc_donation=" + money.getYsc_donation() 
					+ ",paid=" + money.getPaid()
					+ ",total=" + money.getTotal()
					+ ",credit=" + money.getCredit()
					+ ",balance=" + money.getBalance()
					+ ",dues=" + money.getDues()
					+ ",other=" + money.getOther()
					+ ",initiation=" + money.getInitiation()
					+ " WHERE money_id=" + money.getMoney_id() + ";"));
			Main.edits.setMoniesEdits(Main.edits.getMoniesEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static final void updateWorkCredit(Object_WorkCredit swcy)  {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE work_credit SET racing=" + swcy.getRacing()
					+ ",harbor=" + swcy.getHarbor() + ",social=" + swcy.getSocial() + ",other=" + swcy.getOther() 
					+ " WHERE money_id=" + swcy.getMoney_id() + ";"));
			Main.edits.setWorkCreditsEdits(Main.edits.getWorkCreditsEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static final void updateMoneyBatch(int money_id, int batchNumber) {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE money SET batch=\"" + batchNumber
					+ "\" WHERE money_id='" + money_id + "';"));
			Main.edits.setMoniesEdits(Main.edits.getMoniesEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static final void updateMoneyClosed(int money_id, Boolean closed) {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE money SET closed=" + closed
					+ " WHERE money_id='" + money_id + "';"));
			Main.edits.setMoniesEdits(Main.edits.getMoniesEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static void updateMemo(int memo_id, String field, String attribute)  {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE memo SET " + field + "=\"" + attribute + "\" WHERE memo_id='" + memo_id + "';"));
			Main.edits.setMemosEdits(Main.edits.getMemosEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
	
	public static void updatePayment(int pay_id, String field, String attribute) {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE payment SET " + field + "=\"" + attribute + "\" WHERE pay_id='" + pay_id + "';"));
			Main.edits.setPaymentsEdits(Main.edits.getPaymentsEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
		
	}
	
	public static Boolean updateMembershipId(Object_MembershipId thisId, String field, String attribute) {
		Boolean noError = true;
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE membership_id SET " + field + "=\"" + attribute + "\" WHERE mid=" + thisId.getMid()));
			Main.edits.setIdEdits(Main.edits.getIdEdits() + 1);
		} catch (SQLIntegrityConstraintViolationException IV) {
			Object_Person accountHolder = SqlSelect.getPersonFromMembershipID(thisId.getMembership_id(), thisId.getFiscal_Year());
			String errorMessage = "The entry for the year " + thisId.getFiscal_Year() + " with a membership ID of " + thisId.getMembership_id() 
			+ " already exists for " + accountHolder.getFname() + " " + accountHolder.getLname();
			new Dialogue_CustomErrorMessage(errorMessage);
				noError = false;
		} catch (SQLException e) {
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
				noError = false;
		}
		return noError;
	}
	
	
	public static Boolean updateMembershipId(int ms_id, int year, boolean value) {
		Boolean noError = true;
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("update membership_id set renew=" + value + " where fiscal_year='" + year + "' and ms_id='" + ms_id +"'"));
			Main.edits.setIdEdits(Main.edits.getIdEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
			noError = false;
		}
		return noError;
	}
	
	public static Boolean updateMembershipId(int mid, String field, Boolean attribute) {
		Boolean noError = true;
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE membership_id SET " + field + "=" + attribute + " WHERE mid=" + mid));
			Main.edits.setIdEdits(Main.edits.getIdEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
			noError = false;
		}
		return noError;
	}
	
	
	public static void updateDefinedFee(String year, String field, String attribute) {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE defined_fee SET " + field + "=" + attribute + " WHERE fiscal_year=" + year + ";"));
			Main.edits.setDefinedFeesEdits(Main.edits.getDefinedFeesEdits() + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
		
	}
	
	public static void updateStatRecord(Object_Stats s)  {
		try {
			Statement stmt = ConnectDatabase.sqlConnection.createStatement();
			stmt.execute(Main.console.setRegexColor("UPDATE stats SET " +
			"ACTIVE_MEMBERSHIPS=" + s.getActiveMemberships() + "," +
			"NON_RENEW=" + s.getNonRenewMemberships() + "," +
			"RETURN_MEMBERS=" + s.getReturnMemberships() + "," +
			"NEW_MEMBERS=" + s.getNewMemberships()+ "," +
			"SECONDARY_MEMBERS=" + s.getSecondaryMembers() + "," +
			"DEPENDANTS=" + s.getDependants() + "," +
			"NUMBER_OF_BOATS=" + s.getNumberOfBoats() + "," +
			"FAMILY=" + s.getFamily() + "," +
			"SOCIAL=" + s.getSocial() + "," +
			"LAKEASSOCIATES=" + s.getLakeAssociates() + "," +
			"LIFEMEMBERS=" + s.getLifeMembers() + "," +
			"RACEFELLOWS=" + s.getRaceFellows() + "," +
			"STUDENT=" + s.getStudent() + "," +
			"DEPOSITS=" + s.getDeposits() + "," +
			"INIATION="  + s.getInitiation() + 
			" WHERE FISCAL_YEAR='" + s.getFiscalYear() + "'"));
			Main.edits.setMemosEdits(Main.edits.getMemosEdits() + 1);  // update edits tracking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new Dialogue_ErrorSQL(e,"There was a problem with the Update","");
		}
	}
}
