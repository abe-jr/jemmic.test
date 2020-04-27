package br.com.xxxxx.addressbook.bussines;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class RemoveContactService {

	public void remove(Path filePath) {
		System.out.println("Remove Contact");
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Name: ");
		String name = keyboard.next();
		FileUtils fileUtils = new FileUtils();
		try {
			filePath = fileUtils.remove(name, filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error remove");
		}
		MenuService menuService = new MenuService();
		menuService.menu(filePath);
	}

}