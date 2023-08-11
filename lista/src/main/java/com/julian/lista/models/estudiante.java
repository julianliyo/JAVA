package com.julian.lista.models;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="estudiante")
public class estudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	
	@Min(value=18, message="Debes tener 18 años o mas")
	private int age;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	@OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private  contact contact;

	public estudiante() {
		
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public contact getcontact() {
		return contact;
	}

	public void setcontact(contact contact) {
		this.contact = contact;
	}

	@PrePersist
	protected void createdAt() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void updatedAt() {
		this.updatedAt = new Date();
	}
	
	
}