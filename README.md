# Phone Book System

## Overview

This project is part of the Structured Programming Course (CSE 014) at Al Alamein International University (AIU). The Phone Book System is a Java-based application designed to create and maintain a database of contacts, each entry including a name, phone number, and address. The application allows users to add, search, sort, edit, and delete contacts.

## Features

- **Add New Contact**: Prompts the user to enter a name, phone number, and address to add a new contact.
- **Search Contact**: Allows the user to search for contacts by name. The search results include all contacts that start with the provided name.
- **Sort and Print Contacts**: Displays all contacts sorted alphabetically by name.
- **Edit Contact**: Enables the user to edit the details of an existing contact.
- **Delete Contact**: Allows the user to delete a contact by name.
- **Validation**: Ensures that the entered data for names, phone numbers, and addresses are valid.

## Requirements

- Java Development Kit (JDK) 8 or later
- A text editor or Integrated Development Environment (IDE) for Java development

## Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/phone-book-system.git
    ```
2. **Navigate to the project directory**:
    ```bash
    cd phone-book-system
    ```

## Usage

1. **Compile the program**:
    ```bash
    javac -d bin src/project/finalproject.java
    ```

2. **Run the program**:
    ```bash
    java -cp bin project.finalproject
    ```

## Code Structure

- `finalproject.java`: The main file containing the application's logic.
- **Methods**:
  - `main(String[] args)`: The entry point of the application.
  - `menu(String[] names, String[] phoneNumbers, String[] addresses, int numOfUsersInTheSystem, int size)`: Displays the main menu and handles user input.
  - `add(String[] names, String[] phoneNumbers, String[] addresses, int numOfUsersInTheSystem, int size)`: Adds a new contact.
  - `search(String[] names, String[] phoneNumbers, String[] addresses, int numOfUsersInTheSystem)`: Searches for contacts by name.
  - `print(String[] names, String[] phoneNumbers, String[] addresses, int numOfUsersInTheSystem)`: Displays all contacts.
  - `edit(String[] names, String[] phoneNumbers, String[] addresses, int numOfUsersInTheSystem)`: Edits an existing contact.
  - `delete(String[] names, String[] phoneNumbers, String[] addresses, int numOfUsersInTheSystem)`: Deletes a contact by name.
  - `validationOfTheName(Scanner input)`: Validates and inputs a contact name.
  - `validationOfNumbers(Scanner input)`: Validates and inputs a phone number.
  - `validationOfTheAddress(Scanner input)`: Validates and inputs an address.

## Validation Methods

- **validationOfTheName(Scanner input)**: Ensures the name contains only letters and spaces.
- **validationOfNumbers(Scanner input)**: Ensures the phone number follows a specific format.
- **validationOfTheAddress(Scanner input)**: Ensures the address contains only letters and spaces.


## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

