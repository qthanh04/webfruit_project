package com.springmvc.webfruit.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mediumcategory")
public class MediumCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private Boolean status;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mediumCategory")
	  private Set<SmallCategory> listSmallCategory = new HashSet<SmallCategory>();
	
	 @ManyToOne
	  @JoinColumn(name = "bigCategoryId", nullable = false)
	  private BigCategory bigCategory;

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

	public Set<SmallCategory> getListSmallCategory() {
		return listSmallCategory;
	}

	public void setListSmallCategory(Set<SmallCategory> listSmallCategory) {
		this.listSmallCategory = listSmallCategory;
	}

	public BigCategory getBigCategory() {
		return bigCategory;
	}

	public void setBigCategory(BigCategory bigCategory) {
		this.bigCategory = bigCategory;
	}
	
	

}
