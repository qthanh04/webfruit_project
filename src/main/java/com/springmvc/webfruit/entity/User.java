package com.springmvc.webfruit.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String address;
	
	private String email;
	
	private String img;

	private String name;

	private String phone;
	
	private String role;

    @Column(nullable = false, unique = true,name = "username")
    private String userName;
    
    @Column(nullable = false,name="password")
    private String passWord;

	private Boolean status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Oder> listUser = new HashSet<Oder>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rateUser")
	private Set<Rate> listRateUser = new HashSet<Rate>();

	
	public User() {
	
	}
	
	
	public User(  
			String userName, String passWord, Boolean status) {
		this.userName = userName;
		this.passWord = passWord;
		this.status = status;
	}


	public Integer getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Set<Oder> getListUser() {
		return listUser;
	}

	public void setListUser(Set<Oder> listUser) {
		this.listUser = listUser;
	}

	public Set<Rate> getListRateUser() {
		return listRateUser;
	}

	public void setListRateUser(Set<Rate> listRateUser) {
		this.listRateUser = listRateUser;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

	

}
