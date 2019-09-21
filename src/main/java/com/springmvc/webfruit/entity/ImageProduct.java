
package com.springmvc.webfruit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "imageproduct")
public class ImageProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String url;
	
	private Boolean status;
	
	 @ManyToOne
	  @JoinColumn(name = "productId", nullable = false)
	  private Product imageProduct;
	 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Product getImageProduct() {
		return imageProduct;
	}

	public void setImageProduct(Product imageProduct) {
		this.imageProduct = imageProduct;
	}


	 
	 
	
	

}
