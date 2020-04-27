package br.com.xxxxx.addressbook;

import br.com.xxxxx.addressbook.bussines.MenuService;

public class AddresBookApplication {
	public static void main(String[] args) {
		MenuService menuService = new MenuService();
		menuService.init();
	}
}
