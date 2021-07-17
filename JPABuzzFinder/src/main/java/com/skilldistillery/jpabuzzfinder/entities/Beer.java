package com.skilldistillery.jpabuzzfinder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Beer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double abv;
	
	private double ibu;
	
	private String name;
	
	private double ounces;
	
	@ManyToOne
	@JoinColumn(name="beer_style_id")
	private BeerStyle beerStyle;
	
//	@Column(name = "brewery_id")
//	private int breweryId;
	
	private Brewery brewery;
	
	@Column(name = "beer_style_id")
	private int beerStyleId;
	
	@Column(name = "image_url")
	private String imageUrl;

	public Beer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAbv() {
		return abv;
	}

	public void setAbv(double abv) {
		this.abv = abv;
	}

	public double getIbu() {
		return ibu;
	}

	public void setIbu(double ibu) {
		this.ibu = ibu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getOunces() {
		return ounces;
	}

	public void setOunces(double ounces) {
		this.ounces = ounces;
	}


	public int getBeerStyleId() {
		return beerStyleId;
	}

	public void setBeerStyleId(int beerStyleId) {
		this.beerStyleId = beerStyleId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Brewery getBrewery() {
		return brewery;
	}

	public void setBrewery(Brewery brewery) {
		this.brewery = brewery;
	}

	@Override
	public String toString() {
		return "Beer [id=" + id + ", abv=" + abv + ", ibu=" + ibu + ", name=" + name + ", ounces=" + ounces
				 + ", beerStyleId=" + beerStyleId + ", imageUrl=" + imageUrl + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beer other = (Beer) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

}
