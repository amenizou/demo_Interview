package com.covid.demo.entities;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Represents a country
 */
@Entity
@Table(name="country")
public class Country{
	
	@Id
	@Column(name="id_country")
	private String idCountry;
	
	@Column(name="lib_country")
	private String libCountry;

	public String getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(String idCountry) {
		this.idCountry = idCountry;
	}

	public String getLibCountry() {
		return libCountry;
	}

	public void setLibCountry(String libCountry) {
		this.libCountry = libCountry;
	}

	public Country() {
	}

	public Country(String idCountry, String libCountry) {
		this.idCountry = idCountry;
		this.libCountry = libCountry;
	}

	@Override
	public String toString() {
		return "Country [idCountry=" + idCountry + ", libCountry=" + libCountry + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCountry, libCountry);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(idCountry, other.idCountry) && Objects.equals(libCountry, other.libCountry);
	}
	
	
	
	
	
	

}
