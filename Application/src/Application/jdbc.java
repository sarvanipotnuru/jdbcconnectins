package Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class jdbc{
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String url ="jdbc:mysql://localhost:3306/";
	private static final String username = "root";
	private static final String password = "root";
public static void main(String args[]) {
		int ch;
		do {
			System.out.println("crud operation :");
			System.out.println("*");
;
			display();
			Scanner sc=new Scanner(System.in);
			System.out.println("eneter your choice: ");
		ch=Integer.parseInt(sc.next());	
			System.out.println("");
			switch(ch){
			case 1:
				createdtabase();
				break;
			case 2:
				dropdatabase();
				break;
			case 3:
				createtable();
				break;
			case 4:
				droptable();
				break;
			case 5:
				Insertion();
				break;
			case 6:
				update();
				break;
			case 7:
				delete();
				break;
			case 8:
				getall();
				break;
			case 9:
				getbyemail();
				break;
			case 0:
				exit();
				break;
			default:
				System.out.println("inavalid choice");
				
			}
		}
	while(ch>0);}
	private static void exit() {
		// TODO Auto-generated method stub
		System.out.println("exit");
		
	}
	private static void getbyemail() {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the database name :");
			String url ="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the table name");
			String name="select * from "+sc.next()+" where email= ? ";
			
			PreparedStatement pmst = conn.prepareStatement(name); 
			System.out.println("enter the email");
			pmst.setString(1, sc.next());
			ResultSet rs = pmst.executeQuery();
			while(rs.next()) {
				System.out.println("*");
				System.out.println("ID : " + rs.getInt("id"));
				System.out.println("NAME : " + rs.getString("name"));
				System.out.println("EMAIL : " + rs.getString("email"));
				System.out.println("*");		
			}
			conn.close();
			pmst.close();

			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static void getall() {
		// TODO Auto-generated method stub

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the database name :");
			String url ="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the table name");
			String name="select * from "+sc.next() ;
			
			PreparedStatement pmst = conn.prepareStatement(name); 
			ResultSet rs = pmst.executeQuery();
			while(rs.next()) {
				System.out.println("*");
				System.out.println("ID : " + rs.getInt("id"));
				System.out.println("NAME : " + rs.getString("name"));
				System.out.println("EMAIL : " + rs.getString("email"));
				System.out.println("*");		
			}
			conn.close();
			pmst.close();

			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static void delete() {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the database name :");
			String url ="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the table name");
			String name="delete from " +sc.next()+" where id =?" ;
			
			PreparedStatement pmst = conn.prepareStatement(name); 
			System.out.println("enter Id");
			pmst.setInt(1, sc.nextInt());

			
			int i = pmst.executeUpdate();
			
			if (i>0) {
				System.out.println("data deleted");
			}
			else {
				System.out.println("data not deleted");
			}
			conn.close();
			pmst.close();

			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static void update() {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the database name :");
			String url ="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the table name");
			String name="update  " +sc.next()+" set name = ?, email =? where id =?" ;
			
			PreparedStatement pmst = conn.prepareStatement(name); 
			System.out.println("enter name");
			pmst.setString(1, sc.next());
			System.out.println("enter email");
			pmst.setString(2, sc.next());
			System.out.println("enter id");
			pmst.setInt(3, sc.nextInt());
			
			int i = pmst.executeUpdate();
			
			if (i>0) {
				System.out.println("data updated");
			}
			else {
				System.out.println("data not updated");
			}
			conn.close();
			pmst.close();

			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static void Insertion() {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the database name :");
			String url ="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the table name");
			String name="insert into " +sc.next()+"(id,name,email) values(?,?,?)" ;
			
			PreparedStatement pmst = conn.prepareStatement(name); 
			System.out.println("enter Id");
			pmst.setInt(1, sc.nextInt());
			System.out.println("enter name");
			pmst.setString(2, sc.next());
			System.out.println("enter email");
			pmst.setString(3, sc.next());
			
			int i = pmst.executeUpdate();
			
			if (i>0) {
				System.out.println("data inserted");
			}
			else {
				System.out.println("data not inserted");
			}
			conn.close();
			pmst.close();

			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static void droptable() {
		// TODO Auto-generated method stub

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the database name :");
			String url ="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the table name");
			String name="drop table " +sc.next() ;
			
			PreparedStatement pmst = conn.prepareStatement(name); 
			
			int i = pmst.executeUpdate();
			
			if (i==0) {
				System.out.println("table deleted");
			}
			else {
				System.out.println("table not deleted");
			}
			conn.close();
			pmst.close();

			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static void createtable() {
		// TODO Auto-generated method stub
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the database name");
			String url ="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the table name");
			String name="Create table " +sc.next() +"(id int, name varchar(20),email varchar(20))";
			
			PreparedStatement pmst = conn.prepareStatement(name); 
			
			int i = pmst.executeUpdate();
			
			if (i==0) {
				System.out.println("table Created");
			}
			else {
				System.out.println("table not created");
			}
			conn.close();
			pmst.close();

			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static void dropdatabase() {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			//load the driver
			//my sql driver name com.mysql.cj.jdbc.Driver : cj is used when sql version is greater than 8
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the databse name");
			String name="drop database " +sc.next();
			
			PreparedStatement pmst = conn.prepareStatement(name);  //connection btwn the connection and statement
			
			int i = pmst.executeUpdate();
			
			if (i==0) {
				System.out.println("Databse deleted");
			}
			else {
				System.out.println("Database not deleted");
			}
			conn.close();
			pmst.close();

			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static void createdtabase() {
		try {
			Scanner sc = new Scanner(System.in);
			//load the driver
			//my sql driver name com.mysql.cj.jdbc.Driver : cj is used when sql version is greater than 8
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the databse name");
			String name="Create database " +sc.next();
			
			PreparedStatement pmst = conn.prepareStatement(name);  //connection btwn the connection and statement
			
			int i = pmst.executeUpdate();
			
			if (i>0) {
				System.out.println("Databse Created");
			}
			else {
				System.out.println("Database not created");
			}
			conn.close();
			pmst.close();

			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	private static void display() {
		System.out.println("\t1.create database");
		System.out.println("\t2.drop database");
		System.out.println("\t3.create table");
		System.out.println("\t4.drop table");
		System.out.println("\t5.Insertion");
		System.out.println("\t6.update");
		System.out.println("\t7.delete");
		System.out.println("\t8.getall");
		System.out.println("\t9.getbyemail");
		System.out.println("\t10.exit");
	
		
	}

}