package com.mesEncheresV2.filRouge.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Photo {

private int id;
@Column(nullable=false, length=10)
	private String fileName;
@Column(nullable=false, length=30)
	private String contentType;
@Column(nullable=true, length=30)
	private long fileSize;
@Column(nullable=false, length=50)
	private String fileHash;


//Instanciation objets métier 

private Product products;

// Getter et setter

@Id @GeneratedValue
public int getId() {
	return id;}
public void setId(int id) {
	this.id = id;}
public String getFileName() {
	return fileName;}
public void setFileName(String fileName) {
	this.fileName = fileName;}
public String getContentType() {
	return contentType;}
public void setContentType(String contentType) {
	this.contentType = contentType;}
public long getFileSize() {
	return fileSize;}
public void setFileSize(long fileSize) {
	this.fileSize = fileSize;}
public String getFileHash() {
	return fileHash;}
public void setFileHash(String fileHash) {
	this.fileHash = fileHash;}

@OneToOne
public Product getProducts() {
	return products;}
public void setProducts(Product products) {
	this.products = products;}

// Constructeurs

public Photo(int id, String fileName, String contentType, long fileSize, String fileHash) {
	super();
	this.id = id;
	this.fileName = fileName;
	this.contentType = contentType;
	this.fileSize = fileSize;
	this.fileHash = fileHash;}

public Photo(){this(0,"","",0,"");}


//Utils 

@Override
public String toString() {
	return "Photo [id=" + id + ", fileName=" + fileName + ", contentType=" + contentType + ", fileSize=" + fileSize
			+ ", fileHash=" + fileHash + ", products=" + products + "]";
}

}