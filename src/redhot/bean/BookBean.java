package redhot.bean;

import java.io.Serializable;
import java.sql.Date;

public class BookBean implements Serializable{
	private int isbn;
	private String name;
	private int classId;
	private String author;
	private String publisher;
	private java.sql.Date releaseDate;


	public BookBean() {
	}

	public BookBean(int isbn, String name, int classId, String author, String publisher, Date releaseDate) {
		this.isbn = isbn;
		this.name = name;
		this.classId = classId;
		this.author = author;
		this.publisher = publisher;
		this.releaseDate = releaseDate;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public java.sql.Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(java.sql.Date releaseDate) {
		this.releaseDate = releaseDate;
	}



}
