package com.julian.lenguajes.models;

import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "lenguaje")
public class LenguajeModel {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Size(min = 5, max = 50, message = "agregue un nombre")
		private String name;

		@Size(min = 5, max = 50, message = "agregue un creador")
		private String creator;
		 @NotNull
		 @DecimalMin(value = "0.1", message = "agregue una version.")
		private double version;

		@Column(updatable = false)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date createdAt;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date updatedAt;




		public LenguajeModel() {
		
		}

		public LenguajeModel(@Size(min = 5, max = 50, message = "agregue un nombre") String name,
				@Size(min = 5, max = 50, message = "agregue un creador") String creator,
				@Size(min = 1, message = "agregue una version.") double version) {
			
			this.name = name;
			this.creator = creator;
			this.version = version;
		}

		public LenguajeModel(Long id, @Size(min = 5, max = 50, message = "agregue un nombre") String name,
				@Size(min = 5, max = 50, message = "agregue un creador") String creator,
				@Size(min = 1, message = "agregue una version.") double version) {
		
			this.id = id;
			this.name = name;
			this.creator = creator;
			this.version = version;
		}

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

		public String getCreator() {
			return creator;
		}

		public void setCreator(String creator) {
			this.creator = creator;
		}

		public double getVersion() {
			return version;
		}

		public void setVersion(double version) {
			this.version = version;
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

		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}
		
		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
	}

