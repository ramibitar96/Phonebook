package claim2;

import java.util.*;
import java.util.Scanner;


public class Phonebook {
	
	static List<Person> phonebook = new ArrayList<Person>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Phonebook book = new Phonebook();
		String input;
		
		do {
			System.out.println("Please make a selection from the menu below\n");
			System.out.println("1- add new entry");
			System.out.println("2- search by first name");
			System.out.println("3- search by last name");
			System.out.println("4- search by full name");
			System.out.println("5- search by phone number");
			System.out.println("6- search by city");
			System.out.println("7- search by state");
			System.out.println("8- delete record based on phone number");
			System.out.println("9- update record base on phone number");
			System.out.println("10- Print all Records");
			System.out.println("11-To exit");
			input = scanner.nextLine();
			System.out.println();
			switch (input) {
				case "1": 
					System.out.println("Make new entry in the following format: John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375");
					input = scanner.nextLine();
					book.addEntry(input.split(", "));
					break;
				case "2":
					System.out.println("Enter the first name you want to search by");
					input = scanner.nextLine();
					book.searchFirstName(input);
					break;
				case "3":
					System.out.println("Enter the last name you want to search by");
					input = scanner.nextLine();
					book.searchLastName(input);
					break;
				case "4":
					System.out.println("Enter the full name you want to search by");
					input = scanner.nextLine();
					book.searchFullName(input);
					break;
				case "5":
					System.out.println("Enter the phone number you are searching by, format: (562)-859-2375");
					input = scanner.nextLine();
					book.searchPhoneNumber(input);
					break;
				case "6":
					System.out.println("Enter the city you're looking by");
					input = scanner.nextLine();
					book.citySearch(input);
					break;
				case "7": 
					System.out.println("Enter the state you're looking by");
					input = scanner.nextLine();
					book.stateSearch(input);
					break;
				case "8":
					System.out.println("Enter the phone number you want to remove, format: (562)-859-2375");
					input = scanner.nextLine();
					book.removeEntry(input, 0);
					break;
				case "9":
					System.out.println("Enter the phone number to update by");
					input = scanner.nextLine();
					if (book.findNumber(input) > -1) {
						book.removeEntry(input, 1);
						System.out.println("Enter updated entry, example format: John Michael Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375");
						input = scanner.nextLine();
						book.addEntry(input.split(", "));
					} else {
						System.out.println("Number not found");
					}					
					break;
				case "10":
					if (phonebook.size() == 0) {
						System.out.println("Phonebook is empty");
					} else {
						for (int i = 0; i < phonebook.size(); i++) {
							printEntry(i);
						}
					}
					break;
				case "11":
					scanner.close();
					System.exit(0);
				default: 
					break;
			}
			System.out.println();
		} while (true);
		
	}

	public void addEntry(String[] data) {
		if (data.length != 6) {
			System.out.println("Invalid Entry, check syntax");
			return;
		}
			
		StringBuilder sb = new StringBuilder(data[5]);
		sb.insert(0 , '(');
		sb.insert(4, ")-");
		sb.insert(9 , '-');
		boolean copy = false;
		for (int i = 0; i < phonebook.size(); i++) {
			if (phonebook.get(i).getNumber().equals(sb.toString()))
				copy = true;
		}
		if (copy) {
			System.out.println("Entry already exists in the phonebook");
			return;
		}
		String firstName;
		String middleName;
		String lastName;
		String[] name = data[0].split(" ");
		if (name.length == 2) {
			firstName = name[0];
			middleName = "";
			lastName = name[1];
		} else if (name.length == 3) {
			firstName = name[0];
			middleName = name[1];
			lastName = name[2];
		} else {
			firstName = name[0];
			middleName = name[1] + " " + name[2];
			lastName = name[3];
		}

		Person person = new Person(firstName, middleName, lastName, sb.toString(), data[1], data[2], data[3], data[4]);
		phonebook.add(person);
		Collections.sort(phonebook, (Person p1, Person p2) -> p1.fullSortName().toLowerCase().compareTo(p2.fullSortName().toLowerCase()));
		System.out.println("Entry Added!");
	}
		
	public void removeEntry(String phoneNumber, int type) {
		for (int i = 0; i < phonebook.size(); i++) {
			if (phonebook.get(i).getNumber().equals(phoneNumber)) {
				phonebook.remove(i);
				if (type == 0)
					System.out.println("Entry removed");
				return;
			}
		}
	}
	
	public void searchFirstName(String firstName) {
		for (int i = 0; i < phonebook.size(); i++) {
			if (phonebook.get(i).getFirstName().equalsIgnoreCase(firstName))
				printEntry(i);
		}
	}
	
	public void searchLastName(String lastName) {
		for (int i = 0; i < phonebook.size(); i++) {
			if (phonebook.get(i).getLastName().equalsIgnoreCase(lastName))
				printEntry(i);
		}
	}
	
	public void searchFullName(String fullName) {
		for (int i = 0; i < phonebook.size(); i++) {
			if (phonebook.get(i).getFullName().equalsIgnoreCase(fullName))
				printEntry(i);
		}
	}
	
	public int findNumber(String phoneNumber) {
		for (int i = 0; i < phonebook.size(); i++) {
			if (phonebook.get(i).getNumber().equals(phoneNumber))
				return i;
		}
		return -1;
	}
	
	public void searchPhoneNumber(String phoneNumber) {
		for (int i = 0; i < phonebook.size(); i++) {
			if (phonebook.get(i).getNumber().equals(phoneNumber))
				printEntry(i);
		}
	}
	
	public void citySearch(String city) {
		for (int i = 0; i < phonebook.size(); i++) {
			if (phonebook.get(i).getAddress().getCity().equalsIgnoreCase(city))
				printEntry(i);
		}
	}
	
	public void stateSearch(String state) {
		for (int i = 0; i < phonebook.size(); i++) {
			if (phonebook.get(i).getAddress().getState().equalsIgnoreCase(state))
				printEntry(i);
		}
	}
	
	public static void printEntry(int i) {
		System.out.println(phonebook.get(i).getFullName() + " " + phonebook.get(i).getAddress().getAddress() + " " + phonebook.get(i).getNumber());
	}
	
	
	
}
