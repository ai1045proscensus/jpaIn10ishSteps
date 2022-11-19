package com.ai2045.springboot.jpain10ishsteps.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * 
 * @author ai1045
 *
 */

@Entity(name = "Course") // mapping von diesem bean zur tabelle course, use this mapping for crud operations
// man kann hier unten unten bei spalten attribut name in klammern weglassen,
// da attribut und spaltennamen gleich sind (bzw bean und tabellenname)
public class Course {
	
	@Id // Specifies the primary key of an entity
	long id;
	
	@Column(name = "name") // mappe attribut name zur spalte "name"
	String name;
	
	@Column(name = "author")
	String author;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	

}
