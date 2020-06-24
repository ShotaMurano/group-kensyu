package redhot.bean;

import java.io.Serializable;
import java.sql.Date;

public class StockBean implements Serializable{
	private int id;
	private String bookIsbn;
	private java.sql.Date inDate;
	private java.sql.Date outDate;
	private String status;
	private BookBean bean = new BookBean();

	public StockBean() {
	}

	public StockBean(int id, String bookIsbn, Date inDate, Date outDate, String status, BookBean bean) {
		super();
		this.id = id;
		this.bookIsbn = bookIsbn;
		this.inDate = inDate;
		this.outDate = outDate;
		this.status = status;
		this.bean = bean;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public java.sql.Date getInDate() {
		return inDate;
	}

	public void setInDate(java.sql.Date inDate) {
		this.inDate = inDate;
	}

	public java.sql.Date getOutDate() {
		return outDate;
	}

	public void setOutDate(java.sql.Date outDate) {
		this.outDate = outDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BookBean getBean() {
		return bean;
	}

	public void setBean(BookBean bean) {
		this.bean = bean;
	}






}
