package MainProject;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Library2 extends Library1 {

	// Librarian login credentials are pre-defined here
	Scanner sc = new Scanner(System.in);
	String username = "Admin";
	String password = "admin1234";

	public void liLogin() {
		// Method for login by the librarian
		// Librarian can able enter login credentials and can able dashboard
		System.out.println("------------------------------------------");
		System.out.println("Enter the Login Credentials: ");
		System.out.println("Enter ID: ");
		username1 = sc.next();
		System.out.println("Enter Password: ");
		password1 = sc.next();
		System.out.println("------------------------------------------");

	}

	public void liCheck() {
//Validating the credentials entered by the Librarian
		if (username1.equals(username) && password1.equals(password)) {
			System.out.println("Welcome to LibraryManagementSystem");
			System.out.println("");
			// Displaying dashboard
			System.out.println("Dashboard:");
			System.out.println(" Enter 1 to Add Book ");
			System.out.println(" Enter 2 to Issue a Book ");
			System.out.println(" Enter 3 to Show Books ");
			System.out.println(" Enter 4 to View issued Books ");
			System.out.println(" Enter 5 to Return Books");
			System.out.println(" Enter 6 to Logout");

			setNum(sc.nextInt());

			if (getNum() > 6) {
				System.out.println("Invalid Entry");
				liCheck();
			}
		} else {    // Dsiplaying error message
			System.out.println("Invalid Login");

		}
	}

	public void liadd() throws SQLException {
		// Librarian can able to add the books
		if (getNum() == 1) {
			System.out.println("-----------------------------");
			System.out.println("");
			System.out.println("Enter Book Details: ");
			System.out.println("Set Book Number: ");
			setBookNo(sc.nextInt());

			System.out.println("Enter the Book Name: ");
			setName(sc.nextLine());
			setName(sc.nextLine());

			// Displaying the books that are entered
			System.out.println("-----------------------------");
			System.out.println("Details:");
			System.out.println("  Book ID: " + getBookNo());
			System.out.println("  Name of Book: " + getName());
			System.out.println("-----------------------------");

			// Inserting the book details into data base
			String query = "INSERT INTO library.book_details values (?,?);";
			PreparedStatement stem = conn.prepareStatement(query);
			stem.setInt(1, getBookNo());
			stem.setString(2, getName());
			stem.execute();

			System.out.println("-----------------------------------------");

			// Asking Librarian to choose next option
			System.out.println("You want to select next option Yes/No");

			setDes1(sc.next());
			if (getDes1().equalsIgnoreCase("Yes")) {
				liCheck();
			} else if (getDes1().equalsIgnoreCase("No")) {

			}

		}
	}

}
