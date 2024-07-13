package project;
import java.util.Scanner;
public class finalproject {
		public static void main(String[] args) {
			int size = 1000;
			String[] names = new String[size];
			String[] phoneNumbers = new String[size];
			String[] addresses = new String[size];
			int numOfUsersInTheSystem = 0;
			menu(names, phoneNumbers, addresses, numOfUsersInTheSystem, size);
		}

		public static int add(String[] names, String[] phoneNumbers, String[] addresses, int numOfUsersInTheSystem,
				int size) {
			Scanner input = new Scanner(System.in);
			int position = size - numOfUsersInTheSystem;

			System.out.print("Enter The Name : ");
			String name = validationOfTheName(input);
			names[size - position] = name;

			System.out.print("Enter The Phone Number : ");
			String phoneNumber = validationOfNumbers(input);
			phoneNumbers[size - position] = phoneNumber;

			System.out.print("Enter The Address : ");
			String address = validationOfTheAddress(input);
			addresses[size - position] = address;

			return 1;
		}

		public static int search(String[] names, String[] phoneNumbers, String[] addresses, int numOfUsersInTheSystem) {
			Scanner input = new Scanner(System.in);

			System.out.print("Enter The Name Of the User : ");
			String name = input.nextLine();
			for (int i = 0; i < numOfUsersInTheSystem; i++) {
				if (name.equalsIgnoreCase(names[i])) {
					System.out.println("Name " + names[i]);
					System.out.println("Phone Number " + phoneNumbers[i]);
					System.out.println("Address is " + addresses[i]);
					System.out.println();

					return i;
				}

			}
			System.out.println("Can't find the name");
			return -1;
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
			System.out.print("enter the name of user you want to edit  : ");
			String name = input.nextLine();
			for (int i = 0; i < numOfUsersInTheSystem; i++) {
				if (name.equals(names[i])) {
					System.out.print("enter the new name : ");
					String NewName = validationOfTheName(input);
					names[i] = NewName;
					System.out.print("enter the new Phone Number : ");
					String NewPhoneNumber = validationOfNumbers(input);
					phoneNumbers[i] = NewPhoneNumber;
					System.out.print("enter the New Address : ");
					String NewAddress = validationOfTheAddress(input);
					addresses[i] = NewAddress;
				}
			}
		}

		public static void menu(String[] names, String[] phoneNumbers, String[] addresses, int numOfUsersInTheSystem,
				int size) {
			Scanner input = new Scanner(System.in);
			System.out.println("-------------------- Phone Number Book --------------------");
			System.out.println();
			System.out.println("1) Add New Contact. ");
			System.out.println("2) Search.");
			System.out.println("3) Edit Contact.");
			System.out.println("4) Show All Contacts.");
			System.out.println("5) Delete contact.");
			System.out.println("6) Exit.");
			System.out.println();
			System.out.print("Enter Your Choice : ");
			String choice = input.next();

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
			} else if (choice.equals("5")) {
				System.out.println("-------------------- Delete --------------------");
				System.out.println();
				numOfUsersInTheSystem -= delete(names, phoneNumbers, addresses, numOfUsersInTheSystem);
				menu(names, phoneNumbers, addresses, numOfUsersInTheSystem, size);

			} else if (choice.equalsIgnoreCase("exit") || choice.equals("6")) {
				System.out.println("* Thanks for using our App *");
			} else {
				System.out.println("InValid Choice. ");
				menu(names, phoneNumbers, addresses, numOfUsersInTheSystem, size);
			}
		}

		public static String validationOfTheName(Scanner input) {
			String name = input.nextLine();

			boolean flag = false;
			for (int i = 0; i < name.length(); i++) {
				if ((name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z')
						|| name.charAt(i) == ' ') {
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
				String name2 = input.nextLine();

				for (int i = 0; i < name2.length(); i++) {
					if ((name2.charAt(i) >= 'a' && name2.charAt(i) <= 'z')
							|| (name2.charAt(i) >= 'A' && name2.charAt(i) <= 'Z')) {
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

		public static String validationOfNumbers(Scanner input) {
			String number = input.nextLine();

			// count the number of digits
			int digitsOfTheFirstCheck = 0;
			for (int i = 0; i < number.length(); i++) {
				digitsOfTheFirstCheck++;
			}

			boolean flag = false;
			if (((digitsOfTheFirstCheck == 11) && (number.charAt(0) == '0') && (number.charAt(1) == '1')
					&& (number.charAt(2) == '0' || number.charAt(2) == '1' || number.charAt(2) == '2'
							|| number.charAt(2) == '5')
					&& (number.charAt(3) >= '0' && number.charAt(3) <= '9')
					&& (number.charAt(4) >= '0' && number.charAt(4) <= '9')
					&& (number.charAt(5) >= '0' && number.charAt(5) <= '9')
					&& (number.charAt(6) >= '0' && number.charAt(6) <= '9')
					&& (number.charAt(7) >= '0' && number.charAt(7) <= '9')
					&& (number.charAt(8) >= '0' && number.charAt(8) <= '9')
					&& (number.charAt(9) >= '0' && number.charAt(9) <= '9')
					&& (number.charAt(10) >= '0' && number.charAt(10) <= '9'))) {

				flag = true;
			}

			while (flag == false) {
				System.out.print("**You entered wrong mobile number so please enter the mobile again :- ");
				number = input.nextLine();

				// count the number of digits
				int digitsOfTheSecondCheck = 0;
				for (int i = 0; i < number.length(); i++) {
					digitsOfTheSecondCheck++;
				}

				if (((digitsOfTheSecondCheck == 11) && (number.charAt(0) == '0') && (number.charAt(1) == '1')
						&& (number.charAt(2) == '0' || number.charAt(2) == '1' || number.charAt(2) == '2'
								|| number.charAt(2) == '5')
						&& (number.charAt(3) >= '0' && number.charAt(3) <= '9')
						&& (number.charAt(4) >= '0' && number.charAt(4) <= '9')
						&& (number.charAt(5) >= '0' && number.charAt(5) <= '9')
						&& (number.charAt(6) >= '0' && number.charAt(6) <= '9')
						&& (number.charAt(7) >= '0' && number.charAt(7) <= '9')
						&& (number.charAt(8) >= '0' && number.charAt(8) <= '9')
						&& (number.charAt(9) >= '0' && number.charAt(9) <= '9')
						&& (number.charAt(10) >= '0' && number.charAt(10) <= '9'))) {

					flag = true;
					break;
				}
			}
			return number;
		}

		public static String validationOfTheAddress(Scanner input) {
			String Address = input.nextLine();

			boolean flag = false;
			for (int i = 0; i < Address.length(); i++) {
				if ((Address.charAt(i) >= 'a' && Address.charAt(i) <= 'z')
						|| (Address.charAt(i) >= 'A' && Address.charAt(i) <= 'Z') || Address.charAt(i) == ' ') {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				return Address;
			}

			String Address3 = null;
			while (flag == false) {
				System.out.print("**Please enter the Address again :- ");
				String Address2 = input.nextLine();

				for (int i = 0; i < Address2.length(); i++) {
					if ((Address2.charAt(i) >= 'a' && Address2.charAt(i) <= 'z')
							|| (Address2.charAt(i) >= 'A' && Address2.charAt(i) <= 'Z')) {
						flag = true;
					} else {
						flag = false;
						break;
					}
				}
				if (flag == true) {
					Address3 = Address2;
				}
			}
			return Address3;
		}

		public static int delete(String[] names, String[] phoneNumbers, String[] addresses, int numOfUsersInTheSystem) {
			int index = search(names, phoneNumbers, addresses, numOfUsersInTheSystem);
			if (index == -1) {
				return 0;
			}
			for (int i = index; i + 1 < numOfUsersInTheSystem; i++) {
				names[i] = names[i + 1];
				phoneNumbers[i] = phoneNumbers[i + 1];
				addresses[i] = addresses[i + 1];

			}
			names[numOfUsersInTheSystem - 1] = null;
			phoneNumbers[numOfUsersInTheSystem - 1] = null;
			addresses[numOfUsersInTheSystem - 1] = null;

			return 1;

		}

	}
