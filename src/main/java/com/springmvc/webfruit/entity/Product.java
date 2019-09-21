package com.springmvc.webfruit.entity;
import java.sql.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String supplier;
	
	private Double price;
	
	private Double priceSaled;
	
	private String description;
	
	private String saleCode;

	private Boolean status;
	
	private Double salePercent;
	
	private Date expiryDate;
	
	private Date manufacturingDate ;
		
	private Double avaiable;
	
	private String imageProduct;
	
	 
	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JoinTable(name = "oderdetail", 
	    joinColumns = { @JoinColumn(name = "productId") }, 
	    inverseJoinColumns = {@JoinColumn(name = "oderId") })
	  private Set<Oder> oder = new HashSet<Oder>();
	 
	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JoinTable(name = "smallcategoryproduct", 
	    joinColumns = { @JoinColumn(name = "productId") }, 
	    inverseJoinColumns = {@JoinColumn(name = "smallcategoryId") })
	  private Set<SmallCategory> smallcategory = new HashSet<SmallCategory>();
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "imageProduct")
	  private Set<ImageProduct> listImageProduct = new HashSet<ImageProduct>();
	 
	 
	 
	 @ManyToOne
	  @JoinColumn(name = "shoppingCartId", nullable = false)
	 //@Fetch(FetchMode.JOIN)
	  private ShoppingCart shoppingCart;
	 
	 
	 

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public String getImageProduct() {
		return imageProduct;
	}


	public void setImageProduct(String imageProduct) {
		this.imageProduct = imageProduct;
	}


	public Set<SmallCategory> getSmallcategory() {
		return smallcategory;
	}

	public void setSmallcategory(Set<SmallCategory> smallcategory) {
		this.smallcategory = smallcategory;
	}

	public Set<Oder> getOder() {
		return oder;
	}


	public void setOder(Set<Oder> oder) {
		this.oder = oder;
	}



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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}



	public Double getAvaiable() {
		return avaiable;
	}


	public void setAvaiable(Double avaiable) {
		this.avaiable = avaiable;
	}


	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSaleCode() {
		return saleCode;
	}

	public void setSaleCode(String saleCode) {
		this.saleCode = saleCode;
	}

	public Double getSalePercent() {
		return salePercent;
	}

	public void setSalePercent(Double salePercent) {
		this.salePercent = salePercent;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}


	public Date getManufacturingDate() {
		return manufacturingDate;
	}


	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Date calendar) {
		this.expiryDate = calendar;
	}


	public Set<ImageProduct> getListImageProduct() {
		return listImageProduct;
	}


	public void setListImageProduct(Set<ImageProduct> listImageProduct) {
		this.listImageProduct = listImageProduct;
	}


	public Double getPriceSaled() {
		return priceSaled;
	}


	public void setPriceSaled(Double priceSaled) {
		this.priceSaled = priceSaled;
	}

	

	
}
