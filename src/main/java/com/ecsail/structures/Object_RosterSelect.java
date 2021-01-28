package com.ecsail.structures;

public class Object_RosterSelect {
	private String year;
	private boolean active;
	private boolean nonRenew;
	private boolean newMembers;
	private boolean newAndReturnd;
	private boolean membership_id;
	private boolean lastName;
	private boolean firstName;
	private boolean joinDate;
	private boolean streetAddress;
	private boolean city;
	private boolean state;
	private boolean zip;
	private boolean memtype;
	private boolean slip;
	private boolean phone;
	private boolean email;
	private boolean subleasedto;
	
	public Object_RosterSelect(String year, boolean active, boolean nonRenew, boolean newMembers, boolean newAndReturnd,
			boolean membership_id, boolean lastName, boolean firstName, boolean joinDate, boolean streetAddress,
			boolean city, boolean state, boolean zip, boolean memtype, boolean slip, boolean phone, boolean email,
			boolean subleasedto) {
		this.year = year;
		this.active = active;
		this.nonRenew = nonRenew;
		this.newMembers = newMembers;
		this.newAndReturnd = newAndReturnd;
		this.membership_id = membership_id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.joinDate = joinDate;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.memtype = memtype;
		this.slip = slip;
		this.phone = phone;
		this.email = email;
		this.subleasedto = subleasedto;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isNonRenew() {
		return nonRenew;
	}

	public void setNonRenew(boolean nonRenew) {
		this.nonRenew = nonRenew;
	}

	public boolean isNewMembers() {
		return newMembers;
	}

	public void setNewMembers(boolean newMembers) {
		this.newMembers = newMembers;
	}

	public boolean isNewAndReturnd() {
		return newAndReturnd;
	}

	public void setNewAndReturnd(boolean newAndReturnd) {
		this.newAndReturnd = newAndReturnd;
	}

	public boolean isMembership_id() {
		return membership_id;
	}

	public void setMembership_id(boolean membership_id) {
		this.membership_id = membership_id;
	}

	public boolean isLastName() {
		return lastName;
	}

	public void setLastName(boolean lastName) {
		this.lastName = lastName;
	}

	public boolean isFirstName() {
		return firstName;
	}

	public void setFirstName(boolean firstName) {
		this.firstName = firstName;
	}

	public boolean isJoinDate() {
		return joinDate;
	}

	public void setJoinDate(boolean joinDate) {
		this.joinDate = joinDate;
	}

	public boolean isStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(boolean streetAddress) {
		this.streetAddress = streetAddress;
	}

	public boolean isCity() {
		return city;
	}

	public void setCity(boolean city) {
		this.city = city;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public boolean isZip() {
		return zip;
	}

	public void setZip(boolean zip) {
		this.zip = zip;
	}

	public boolean isMemtype() {
		return memtype;
	}

	public void setMemtype(boolean memtype) {
		this.memtype = memtype;
	}

	public boolean isSlip() {
		return slip;
	}

	public void setSlip(boolean slip) {
		this.slip = slip;
	}

	public boolean isPhone() {
		return phone;
	}

	public void setPhone(boolean phone) {
		this.phone = phone;
	}

	public boolean isEmail() {
		return email;
	}

	public void setEmail(boolean email) {
		this.email = email;
	}

	public boolean isSubleasedto() {
		return subleasedto;
	}

	public void setSubleasedto(boolean subleasedto) {
		this.subleasedto = subleasedto;
	}

}