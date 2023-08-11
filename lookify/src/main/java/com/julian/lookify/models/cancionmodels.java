package com.julian.lookify.models;


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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "canciones")
public class cancionmodels {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Size(min = 5, max = 50, message = "agregue un titulo")
		private String titulo;

		@Size(min = 5, max = 50, message = "agregue un/los artista/s")
		private String artista;
		

		@Min(value = 1, message="calificacion del 1 al 10")
		@Max(value = 10, message="calificacion del 1 al 10")
				private Integer calificacion;

		@Column(updatable = false)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date createdAt;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date updatedAt;
		
		
		
		
		public cancionmodels() {
		}
		
		
		

		public cancionmodels(@Size(min = 5, max = 50, message = "agregue un titulo") String titulo,
				@Size(min = 5, max = 50, message = "agregue un/los artista/s") String artista,
				@Min(value = 1, message = "calificacion del 1 al 10") @Max(value = 10, message = "calificacion del 1 al 10") Integer calificacion) {
			super();
			this.titulo = titulo;
			this.artista = artista;
			this.calificacion = calificacion;
		}
		




		public cancionmodels(Long id, @Size(min = 5, max = 50, message = "agregue un titulo") String titulo,
				@Size(min = 5, max = 50, message = "agregue un/los artista/s") String artista,
				@Min(value = 1, message = "calificacion del 1 al 10") @Max(value = 10, message = "calificacion del 1 al 10") Integer calificacion) {
			super();
			this.id = id;
			this.titulo = titulo;
			this.artista = artista;
			this.calificacion = calificacion;
		}

		
		



		public Long getId() {
			return id;
		}




		public void setId(Long id) {
			this.id = id;
		}




		public String getTitulo() {
			return titulo;
		}




		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}




		public String getArtista() {
			return artista;
		}




		public void setArtista(String artista) {
			this.artista = artista;
		}




		public Integer getCalificacion() {
			return calificacion;
		}




		public void setCalificacion(Integer calificacion) {
			this.calificacion = calificacion;
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
