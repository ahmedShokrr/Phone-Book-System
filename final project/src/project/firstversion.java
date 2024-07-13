package project;

import java.util.*;

public class firstversion {


	public static void main(String[] args) {
		int size = 1000;
		String[] names = new String[size];
		String[] phoneNumbers = new String[size];
		String[] addresses = new String[size];
		int numOfUsersInTheSystem = 0;
		menu(names, phoneNumbers, addresses, numOfUsersInTheSystem, size);
	}

	public static int add(String[] names, String[] phoneNumbers, String[] addresses, int numOfUsersInTheSystem, int size) {
		Scanner console = new Scanner(System.in);
		int position = size - numOfUsersInTheSystem;

		System.out.print("Enter The Name : ");
		String name = validationOfTheName(console);
		names[size - position] = name;

		System.out.print("Enter The Phone Number : ");
		String phoneNumber = validationOfPhoneNumber(console);
		phoneNumbers[size - position] = phoneNumber;

		System.out.print("Enter The Address : ");
		String address = console.next();
		addresses[size - position] = address;

		return 1;
	}


	public static void search(String[] names, String[] phoneNumbers, String[] addresses, int numOfUsersInTheSystem) {
		Scanner console = new Scanner(System.in);

		System.out.print("Enter The Name Of User that you want to search for : ");
		String name = console.next();
		for (int i = 0; i < numOfUsersInTheSystem; i++) {
			if (name.equalsIgnoreCase(names[i])) {
				System.out.println("Name " + names[i]);
				System.out.println("Phone Number " + phoneNumbers[i]);
				System.out.println("Address is " + addresses[i]);
				System.out.println();
			}
		}
	}

	public static void print(String[] names, String[] phoneNumbers, String[] addresses, int numOfUsersInTheSystem) {
		// Bubble sort Algorithm
		for (int j = 0; j < numOfUsersInTheSystem - 1; j++) {
			for (int k = j; k < numOfUsersInTheSystem; k++) {
				if (names[j].toLowerCase().charAt(0) > names[k].toLowerCase().charAt(0)) {
					String tempName = names[j];
					names[j] = names[k];
					names[k] = tempName;

					String tempPhoneNumber = phoneNumbers[j];
					phoneNumbers[j] = phoneNumbers[k];
					phoneNumbers[k] = tempPhoneNumber;

					String tempAddress = addresses[j];
					addresses[j] = addresses[k];
					addresses[k] = tempAddress;
				}
			}
		}

		for (int i = 0; i < numOfUsersInTheSystem; i++) {
			System.out.println("Name " + names[i]);
			System.out.println("Phone Number " + phoneNumbers[i]);
			System.out.println("Address is " + addresses[i]);
			System.out.println();
		}
	}

	public static void edit(String[] names, String[] phoneNumbers, String[] addresses, int numOfUsersInTheSystem) {
		Scanner input = new Scanner(System.in);
		System.out.print("enter the name of user you want to search for : ");
		String name = input.next();
		for (int i = 0; i < numOfUsersInTheSystem; i++) {
			if (name.equals(names[i])) {
				System.out.print("enter the new name : ");
				String NewName = validationOfPhoneNumber(input);
				names[i] = NewName;
				System.out.print("enter the new Phone Number : ");
				String NewPhoneNumber = validationOfPhoneNumber(input);
				phoneNumbers[i] = NewPhoneNumber;
				System.out.print("enter the New Address : ");
				String NewAddress = input.next();
				addresses[i] = NewAddress;
			}
		}
	}

	public static void menu(String[] names, String[] phoneNumbers, String[] addresses, int numOfUsersInTheSystem, int size) {
		Scanner console = new Scanner(System.in);
		System.out.println("-------------------- Phone Number Book --------------------");
		System.out.println();
		System.out.println("1) Add New Contact. ");
		System.out.println("2) Search.");
		System.out.println("3) Edit Contact.");
		System.out.println("4) Show All Contacts.");
		System.out.println("5) Exit.");
		System.out.println();
		System.out.print("Enter Your Choice : ");
		String choice = console.next();

		if (choice.equals("1")) {
			System.out.println("-------------------- Add New Contact --------------------");
			System.out.println();
			numOfUsersInTheSystem += add(names, phoneNumbers, addresses, numOfUsersInTheSystem, size);
			System.out.println();
			menu(names, phoneNumbers, addresses, numOfUsersInTheSystem, size);
		} else if (choice.equals("2")) {
			System.out.println("-------------------- Search --------------------");
			System.out.println();
			search(names, phoneNumbers, addresses, numOfUsersInTheSystem);
			menu(names, phoneNumbers, addresses, numOfUsersInTheSystem, size);
		} else if (choice.equals("3")) {
			System.out.println("-------------------- Edit --------------------");
			System.out.println();
			edit(names, phoneNumbers, addresses, numOfUsersInTheSystem);
			menu(names, phoneNumbers, addresses, numOfUsersInTheSystem, size);
		} else if (choice.equals("4")) {
			System.out.println("-------------------- Contacts --------------------");
			System.out.println();
			print(names, phoneNumbers, addresses, numOfUsersInTheSystem);
			System.out.println();
			menu(names, phoneNumbers, addresses, numOfUsersInTheSystem, size);
		} else if (choice.equalsIgnoreCase("exit") || choice.equals("5")) {
			System.out.println("* Thank You To Use Our APP *");
		} else {
			System.out.println("InValid Choice. ");
			menu(names, phoneNumbers, addresses, numOfUsersInTheSystem, size);
		}
	}

	// validation
	public static String validationOfTheName(Scanner console) {
			/*in this function the user will enter name and this name will save in string variable to check if the name that the user
			entered contain any numbers or symbols or not if it contain the flag will be false and the program will create new string variable
			called name2 and the user will enter the name and check again. if it not contain any number or symbols the flag will be true and
			the program will save name2 in string name3 and return it*/
		String name = console.next();

		boolean flag = false;
		for (int i = 0; i < name.length(); i++) {
			if ((name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z')) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		if (flag == true) {
			return name;
		}


		String name3 = null;
		while (flag == false) {
			System.out.print("**Please enter the name again :- ");
			String name2 = console.next();

			for (int i = 0; i < name2.length(); i++) {
				if ((name2.charAt(i) >= 'a' && name2.charAt(i) <= 'z') || (name2.charAt(i) >= 'A' && name2.charAt(i) <= 'Z')) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				name3 = name2;
			}
		}
		return name3;
	}

	public static String validationOfPhoneNumber(Scanner console) {
			/* the Egyption mobile number must start with 010 , 011, 012 or 015 and the number of digits must be 11 digits so the program
			will check the number of the digits in the number and the first three digits (if it 010, 011, 012, 015 or not) and last 8 digits
			(if this contain any letter or symbols or not) so if it contain letters or the number of digits less than or more than 11 digit 
			or not start with 010, 011, 012, 015 the program will create new String variable and prompt the user to enter the mobile number
			again and check again and so on...*/
		String number = console.next();

		// count the number of digits
		int digitsOfTheFirstCheck = 0;
		for (int i = 0; i < number.length(); i++) {
			digitsOfTheFirstCheck++;
		}

		boolean flag = false;
		if (((digitsOfTheFirstCheck == 11) && (number.charAt(0) == '0') && (number.charAt(1) == '1') &&
				(number.charAt(2) == '0' || number.charAt(2) == '1' || number.charAt(2) == '2' || number.charAt(2) == '5') &&
				(number.charAt(3) >= '0' && number.charAt(3) <= '9') && (number.charAt(4) >= '0' && number.charAt(4) <= '9') &&
				(number.charAt(5) >= '0' && number.charAt(5) <= '9') && (number.charAt(6) >= '0' && number.charAt(6) <= '9') &&
				(number.charAt(7) >= '0' && number.charAt(7) <= '9') && (number.charAt(8) >= '0' && number.charAt(8) <= '9') &&
				(number.charAt(9) >= '0' && number.charAt(9) <= '9') && (number.charAt(10) >= '0' && number.charAt(10) <= '9'))) {

			flag = true;
		}

		while (flag == false) {
			System.out.print("**You entered wrong mobile number so please enter the mobile again :- ");
			number = console.next();

			// count the number of digits
			int digitsOfTheSecondCheck = 0;
			for (int i = 0; i < number.length(); i++) {
				digitsOfTheSecondCheck++;
			}

			if (((digitsOfTheSecondCheck == 11) && (number.charAt(0) == '0') && (number.charAt(1) == '1') &&
					(number.charAt(2) == '0' || number.charAt(2) == '1' || number.charAt(2) == '2' || number.charAt(2) == '5') &&
					(number.charAt(3) >= '0' && number.charAt(3) <= '9') && (number.charAt(4) >= '0' && number.charAt(4) <= '9') &&
					(number.charAt(5) >= '0' && number.charAt(5) <= '9') && (number.charAt(6) >= '0' && number.charAt(6) <= '9') &&
					(number.charAt(7) >= '0' && number.charAt(7) <= '9') && (number.charAt(8) >= '0' && number.charAt(8) <= '9') &&
					(number.charAt(9) >= '0' && number.charAt(9) <= '9') && (number.charAt(10) >= '0' && number.charAt(10) <= '9'))) {

				flag = true;
				break;
			}
		}
		return number;
	}

	public static String validationOfTheaddress(Scanner console) {
		String addresses = console.next();

		boolean flag = false;
		for (int i = 0; i < addresses.length(); i++) {
			if ((addresses.charAt(i) >= 'a' && addresses.charAt(i) <= 'z') || (addresses.charAt(i) >= 'A' && addresses.charAt(i) <= 'Z')) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		if (flag == true) {
			return addresses;
		} else {
			return null; // Added return statement
		}
	}
}