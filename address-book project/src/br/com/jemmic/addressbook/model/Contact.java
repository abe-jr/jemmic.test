package br.com.xxxxx.addressbook.model;

public class Contact {
	private String name;
	private String surname;
	private Long telephoneNumber;
	private String email;
	private Categorie categorie;
	private Integer age;
	private String hairColor;

	public Contact(String name, String surname, Long telephoneNumber, String email, Categorie categorie) {
		super();
		this.name = name;
		this.surname = surname;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
		this.categorie = categorie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Long getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(Long telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

}
