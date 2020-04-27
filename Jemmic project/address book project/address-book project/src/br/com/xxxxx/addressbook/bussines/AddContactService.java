package br.com.xxxxx.addressbook.bussines;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import br.com.xxxxx.addressbook.model.Categorie;
import br.com.xxxxx.addressbook.model.Contact;

public class AddContactService {
	public void add(Path filePath) {
		System.out.println("Adding a contact");
		Scanner keyboard = new Scanner(System.in);
		String choice;
		String description;
		System.out.println("");
		System.out.print("Name: ");
		String name = keyboard.nextLine();

		System.out.print("Surname: ");
		String surname = keyboard.nextLine();

		System.out.print("Telephone Number: ");
		Long telephoneNumber = keyboard.nextLong();
		
		System.out.print("Email: ");
		String email = keyboard.next();

		System.out.println("Categorie of contact: ");
		System.out.println(" ");
		System.out.println("1- Friends");
		System.out.println("2- Family");
		System.out.println("3- Acquaintance");
		Integer categorieId = keyboard.nextInt();
		switch (categorieId) {
		case 1:
			System.out.print("How many years of friendship? ");
			description = keyboard.next();
			break;
		case 2:
			System.out.print("Family relationship (parent, granparent, son/daughter, aunt/uncle)? ");
			description = keyboard.next();
			break;
		default:
			description = "";
			break;
		}
		Categorie categorie = new Categorie(categorieId, description);

		Contact contact = new Contact(name, surname, telephoneNumber, email, categorie);

		do {
			System.out.print("Would you like to add age? (reply yes / no)");
			choice = keyboard.next();
			if (choice.equalsIgnoreCase("yes")) {
				System.out.print("Age: ");
				Integer age = keyboard.nextInt();
				contact.setAge(age);
			}

			if (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")) {

				System.out.println("");

				System.out.println("Please type only yes / no");
			}

		} while (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no"));

		do {
			System.out.print("Would you to add the hair color? (reply yes / no)");
			choice = keyboard.next();
			if (choice.equalsIgnoreCase("yes")) {
				System.out.print("Hair color: ");
				String hairColor = keyboard.next();
				contact.setHairColor(hairColor);
			}
			if (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")) {

				System.out.println("Please type only yes / no");

			}

		} while (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no"));

		FileUtils fileUtils = new FileUtils();
		try {
			filePath = fileUtils.save(contact, filePath);
		} catch (IOException e) {
			System.out.println("ERROR ADD");
		}
		MenuService menuService = new MenuService();
		menuService.menu(filePath);
	}

}