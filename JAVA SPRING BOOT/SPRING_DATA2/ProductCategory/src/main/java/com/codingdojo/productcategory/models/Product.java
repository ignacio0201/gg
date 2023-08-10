package com.codingdojo.productcategory.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="products")
public class Product {
	
	//ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 2, max = 70, message = "debe contener entre 2 y 70 caracteres")
    private String name;
    @Size(min = 2, max = 255, message = "debe contener entre 2 y 255 caracteres")
    private String description;
    
    @NotNull(message = "el precio no puede estar vacío")
    private double price;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_products", 
        joinColumns = @JoinColumn(name = "product_id"), 
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;
    
    //----------------------------------------------------------------------------------------------------//
    
    //FECHAS
  	@PrePersist
  	protected void onCreate(){
     	this.createdAt = new Date();
     	this.updatedAt = new Date();
  	}
  	@PreUpdate
  	protected void onUpdate(){
      	this.updatedAt = new Date();
  	}
    
  	//----------------------------------------------------------------------------------------------------//
  	
    //CONSTRUCTORES
    public Product() { 
    }
    public Product(Long id, String name, String description, double price, Date createdAt, Date updatedAt,
			List<Category> categories) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.categories = categories;
	}
    
    //----------------------------------------------------------------------------------------------------//
    
	//GETTERS/SETTERS
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
    
}
