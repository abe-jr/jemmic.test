package br.com.xxxxx.addressbook.model;

public class Categorie {

	private Integer categorieId;
	private String description;

	public Categorie(Integer categorieId, String description) {
		super();
		this.categorieId = categorieId;
		this.description = description;
	}

	public Integer getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(Integer categorieId) {
		this.categorieId = categorieId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}