package br.com.xxxxx.addressbook.bussines;

import java.io.IOException;
import java.nio.file.Path;

public class DisplayContactService {

	public void show(Path filePath) {
		System.out.println("Show a contac");
		FileUtils fileUtils = new FileUtils();
		try {
			filePath = fileUtils.display(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Display");
		}
		MenuService menuService = new MenuService();
		menuService.menu(filePath);
	}

}
