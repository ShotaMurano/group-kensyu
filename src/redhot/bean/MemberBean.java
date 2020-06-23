package redhot.bean;

import java.io.Serializable;
import java.sql.Date;

public class MemberBean implements Serializable {
	private int id;
	private String lastName;
	private String firstName;
	private String address;
	private String tellphone;
	private String birthday;
	private String mailAddress;
	private String password;
	private Date inDate;
	private Date outDate;
	private String cerUrl;

	public MemberBean(int id, String lastName, String firstName, String address, String tellphone, String birthday,
			String mailAddress, String password, Date inDate, Date outDate, String cerUrl) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.tellphone = tellphone;
		this.birthday = birthday;
		this.mailAddress = mailAddress;
		this.password = password;
		this.inDate = inDate;
		this.outDate = outDate;
		this.cerUrl = cerUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTellphone() {
		return tellphone;
	}

	public void setTellphone(String tellphone) {
		this.tellphone = tellphone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public String getCerUrl() {
		return cerUrl;
	}

	public void setCerUrl(String cerUrl) {
		this.cerUrl = cerUrl;
	}

}
