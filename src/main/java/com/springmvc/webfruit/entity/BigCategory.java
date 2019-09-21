package com.springmvc.webfruit.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bigcategory")
public class BigCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private Boolean status;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bigCategory")
	  private Set<MediumCategory> listMediumCategory = new HashSet<MediumCategory>();

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

	public Set<MediumCategory> getListSmallCategory() {
		return listMediumCategory;
	}

	public void setListSmallCategory( Set<MediumCategory> listMediumCategory) {
		this.listMediumCategory = listMediumCategory;
	}
	
	
	

}
