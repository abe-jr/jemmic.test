package br.com.xxxxx.addressbook.bussines;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class MenuService {
	public void init() {
		FileUtils fileUtils = new FileUtils();
		try {
			this.menu(fileUtils.create());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void menu(Path filePath) {
		Integer option;
		do {
			Scanner keyboard = new Scanner(System.in);
			System.out.println("----- Welcome to the Jemmic address book -----");
			System.out.println(" ");
			System.out.println("Choose the option you would like to do:");
			System.out.println(" ");
			System.out.println("1 - Add contacts ");
			System.out.println("2 - Display added contacts  ");
			System.out.println("3 - remove contacts ");
			System.out.println(" ");
			System.out.println("Please choose only options displayed on the menu \nor the application will be restarted");
			option = Integer.parseInt(keyboard.nextLine());
			switch (option) {
			case 1:
				AddContactService addContactService = new AddContactService();
				addContactService.add(filePath);
				break;
			case 2:
				DisplayContactService displayContactService = new DisplayContactService();
				displayContactService.show(filePath);
				break;
			case 3:
				RemoveContactService removeContactService = new RemoveContactService();
				removeContactService.remove(filePath);
				break;
			}
			
		} while (option != 3 && option != 1 && option != 2);
	}
}
