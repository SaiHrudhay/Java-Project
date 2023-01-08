package MainProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Library3 extends Library2 {
	
	public void liissue() throws SQLException {
		if (getNum() == 2) {
			//Issuing books that are present in database
			System.out.println("-------------------------------");

			System.out.println("Enter the person name who is taking the Book: ");
			sc.nextLine();
			setName1(sc.nextLine());

			System.out.println("Enter the Book Name: ");
			setName(sc.nextLine());

			System.out.println("Enter the Book ID: ");
			setId(sc.nextInt());


			
			Date thisdate = new Date();
			SimpleDateFormat dateForm = new SimpleDateFormat("DD/MM/Y");
			
			
			//Verifying that entered book id is present in database or not
			String sql ="select * from library.book_details where bookid="+ getId();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			

			if(rs.next()) {
			
			System.out.println("-------------------------------");

			System.out.println("Book taken by:" + getName1());
			System.out.println("Book: " + getName());
			System.out.println("ID: " + getId());
			System.out.println("Issue date: " + dateForm.format(thisdate));

			//Inserting the book details that are issued into database
			String query = "INSERT INTO library.issue_details values (?,?,?,?);";
			PreparedStatement stem = conn.prepareStatement(query);
			stem.setInt(1, getId());
			stem.setString(2, getName1());
			stem.setString(3, getName());
			stem.setString(4, dateForm.format(thisdate));
			stem.execute();

			
			String query1 = "delete from library.book_details where bookid=" + getId();
			PreparedStatement stem1 = conn.prepareStatement(query1);
			stem1.executeUpdate();
			}
			
			else { System.out.println("Invalid Book Id");}
			
			System.out.println("-------------------------------");
			// Asking Librarian to choose next option
			System.out.println("You want to select next option Yes/No");
			sc.nextLine();
			setDes1(sc.nextLine());
			if (getDes1().equalsIgnoreCase("Yes")) {
				liCheck();}
			 else if (getDes1().equalsIgnoreCase("No")) {
				 
			 }
	}}

	

	public void displaybooks() throws SQLException{
		if (getNum() == 3) {
            //Displaying books that are present in database
			System.out.println("-------------------------------");

			String query = "select * from library.book_details";
			PreparedStatement stem = conn.prepareStatement(query);

			ResultSet rs = stem.executeQuery(query);
			while (rs.next()) {

				System.out.println("Book ID " + rs.getInt(1));
				System.out.println("Book Name: " + rs.getString(2));
				System.out.println("-------------------------------");
			}
			// Asking Librarian to choose next option
		System.out.println("You want to select next option Yes/No");
		sc.nextLine();
		setDes1(sc.nextLine());
		if (getDes1().equalsIgnoreCase("Yes")) {
			liCheck();}
		 else if (getDes1().equalsIgnoreCase("No")) {
			 
		 }

		}}
	

	
	public void showIssueBooks() throws SQLException{ 
		if (getNum() == 4) {
			//Displaying the books that are present in database
			System.out.println("-------------------------");
			
			String query = "select * from library.issue_details";
			PreparedStatement stem = conn.prepareStatement(query);

			ResultSet rs = stem.executeQuery(query);
			while (rs.next()) {

				System.out.println("Book ID: " + rs.getInt(1));
				System.out.println("Book taken by:"+rs.getString(2));
				System.out.println("Book Name: " + rs.getString(3));
				System.out.println("Issued date: "+rs.getString(4));
				System.out.println("-------------------------------");
			
			}

		System.out.println("-------------------------------");
		// Asking Librarian to choose next option
		System.out.println("You want to select next option Yes/No");
		sc.nextLine();
		setDes1(sc.nextLine());
		if (getDes1().equalsIgnoreCase("Yes")) {
			liCheck();}
		 else if (getDes1().equalsIgnoreCase("No")) {
			 
		 }

		
	}}

	public void returnbooks() throws SQLException{ 
		
		if(getNum()==5) {
			//Returning the books that are taken by customers
			System.out.println("---------------------");
			System.out.println("Book is returned by: ");
			sc.nextLine();
			setName3(sc.nextLine());
			System.out.println("Enter Book ID: ");
			setId2(sc.nextInt());
			System.out.println("Enter Book name:");
			sc.nextLine();
			setName4(sc.nextLine());
			
			Date thisdate = new Date();
			SimpleDateFormat dateForm = new SimpleDateFormat("DD/MM/Y");
			
			
		    String sql ="select * from library.issue_details where bookid="+ getId2();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				String query = "INSERT INTO library.book_details values (?,?);";
				PreparedStatement stem = conn.prepareStatement(query);
				stem.setInt(1, getId2());
				stem.setString(2, getName4());
				stem.execute();
				
				
				System.out.println("-------------------------------");

				System.out.println("Book taken by:" + getName3());
				System.out.println("Book: " + getName4());
				System.out.println("ID: " + getId());
				System.out.println("Return date: " + dateForm.format(thisdate));

				String query1 = "delete from library.issue_details where bookid=" + getId2();
				PreparedStatement stem1 = conn.prepareStatement(query1);
				stem1.executeUpdate();}else {System.out.println("Invalid Book ID");}
			
			System.out.println("-------------------------------");
			// Asking Librarian to choose next option
			System.out.println("You want to select next option Yes/No");
			setDes1(sc.nextLine());
			if (getDes1().equalsIgnoreCase("Yes")) {
				liCheck();}
			 else if (getDes1().equalsIgnoreCase("No")) {
				 
			 }
				 
			 
	}
	}
				
				
				
				
		
		
	
	public void liExit() {
		//Librarian can able to logout from application
		if (getNum() == 6) {
			System.out.println("-------------------------------");

			System.out.println("Are you sure you want to LogOut");
			sc.nextLine();
			setDes1(sc.nextLine());

			if (getDes1().equalsIgnoreCase("Yes")) {
				System.out.println("-------------------------------");
				liLogin();
				liCheck();}
			 else if (getDes1().equalsIgnoreCase("No")) {
			 }}
			 }

		
		
	


	public static void main(String[] args) throws Exception {
		//executing the methods
		createConnection();
		Library3 lib = new Library3();
		lib.liLogin();
		lib.liCheck();
		lib.liadd();
		lib.liissue();
		lib.displaybooks();
		lib.showIssueBooks();
		lib.returnbooks();
		lib.liExit();
		
	}
}

