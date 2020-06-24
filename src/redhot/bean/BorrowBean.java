package redhot.bean;

import java.io.Serializable;
import java.sql.Date;

public class BorrowBean implements Serializable {
	private int id;
	private int stockId;
	private int userId;
	private java.sql.Date borrowDate;
	private java.sql.Date willReturnDate;

	public java.sql.Date getWillReturnDate() {
		return willReturnDate;
	}

	public void setWillReturnDate(java.sql.Date willReturnDate) {
		this.willReturnDate = willReturnDate;
	}

	private java.sql.Date returnDate;

	public BorrowBean() {
	}

	public BorrowBean(int id, int stockId, int userId, Date borrowDate, Date willReturnDate, Date returnDate) {
		super();
		this.id = id;
		this.stockId = stockId;
		this.userId = userId;
		this.borrowDate = borrowDate;
		this.willReturnDate = willReturnDate;
		this.returnDate = returnDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public java.sql.Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(java.sql.Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public java.sql.Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(java.sql.Date returnDate) {
		this.returnDate = returnDate;
	}

}
