package com.springmvc.webfruit.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "smallcategory")
public class SmallCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private Boolean status;
	
	  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JoinTable(name = "smallcategoryproduct", 
	    joinColumns = { @JoinColumn(name = "smallCategoryId") }, 
	    inverseJoinColumns = {@JoinColumn(name = "productId") })
	  private Set<Product> products = new HashSet<Product>();
	  
	  @ManyToOne
	  @JoinColumn(name = "mediumCategoryId", nullable = false)
	  private MediumCategory mediumCategory;
	  

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public MediumCategory getMediumCategory() {
		return mediumCategory;
	}

	public void setMediumCategory(MediumCategory mediumCategory) {
		this.mediumCategory = mediumCategory;
	}
	
}
