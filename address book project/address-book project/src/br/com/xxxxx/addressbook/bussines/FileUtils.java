package br.com.xxxxx.addressbook.bussines;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import br.com.xxxxx.addressbook.model.Contact;

public class FileUtils {

	public Path create() throws IOException {
		Timestamp localDate = new Timestamp(System.currentTimeMillis());
		String dateFormat = new SimpleDateFormat("MMddyyyyHHmmss").format(localDate);
		Path newFilePath = Paths.get("src/br/com/xxxxx/addressbook/file/AddressbookFile" + dateFormat + ".txt");
		Files.createFile(newFilePath);
		return newFilePath;
	}

	public Path save(Contact contact, Path filePath) throws IOException {
		Path newPath = this.create();
		List<String> lines = Files.readAllLines(filePath);
		lines.add(this.writeLine(contact));
		return createNew(filePath, newPath, lines);
	}

	private String writeLine(Contact contact) {
		String name = contact.getName().toString();
		String surname = contact.getSurname().toString();
		String telephoneNumber = contact.getTelephoneNumber().toString();
		String email = contact.getEmail().toString();
		String categorieId = contact.getCategorie().getCategorieId().toString();
		String categorieDescription = contact.getCategorie().getDescription().toString();
		String age = contact.getAge() != null ? contact.getAge().toString() : " ";
		String hairColor = contact.getAge() != null ? contact.getAge().toString() : " ";
		String line = "";
		return line.concat(name).concat(",").concat(surname).concat(",").concat(telephoneNumber).concat(",")
				.concat(email).concat(",").concat(categorieId).concat(",").concat(categorieDescription).concat(",")
				.concat(age).concat(",").concat(hairColor).concat(",");
	}

	public Path remove(String name, Path filePath) throws IOException {
		Path newPath = this.create();
		List<String> lines = Files.readAllLines(filePath);
		if (!lines.isEmpty()) {
			for (int i = 0; i < lines.size(); i++) {
				String[] parts = lines.get(i).split(",");
				if (parts[0].equalsIgnoreCase(name)) {
					lines.remove(i);
					System.out.println("Contac: " + name + " removed");
				}
			}
		}

		return createNew(filePath, newPath, lines);
	}

	public Path display(Path filePath) throws IOException {
		Path newPath = this.create();
		List<String> lines = Files.readAllLines(filePath);
		List<String> sortLines = new ArrayList<>();
		List<String> surname = new ArrayList<>();
		HashMap<String, String> surnameContact = new HashMap<String, String>();
		for (int i = 0; i < lines.size(); i++) {
			String[] parts = lines.get(i).split(",");
			surname.add(parts[1]);
			surnameContact.put(parts[1], lines.get(i));
		}
		Collections.sort(surname);
		for (int i = 0; i < surname.size(); i++) {
			sortLines.add(surnameContact.get(surname.get(i)));
		}

		System.out.println("Display file : " + filePath.getFileName());
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("");

		for (String line : sortLines) {
			System.out.println(line);
		}
		System.out.println("");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------");
		return createNew(filePath, newPath, sortLines);
	}

	private Path createNew(Path filePath, Path newPath, List<String> lines)
			throws FileNotFoundException, UnsupportedEncodingException, IOException {
		FileOutputStream outputStream = new FileOutputStream(newPath.toFile());
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		for (String line : lines) {
			bufferedWriter.write(line);
			bufferedWriter.newLine();
		}
		bufferedWriter.close();
		filePath.toFile().delete();
		return newPath;
	}

}
