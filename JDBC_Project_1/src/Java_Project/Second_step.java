package Java_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Second_step 
{

	public static void main(String[] args) throws Exception, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bittu","root","root");
		Scanner sc = new Scanner(System.in);
		while (true) {
			
			System.out.println("Choose the options");
			System.out.println("1.CREATE");
			System.out.println("2.INSERT");
			System.out.println("3.UPDATE");
			System.out.println("4.DELETE");
			System.out.println("5.EXIT");
			int i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("Create the table");
				String s= sc.next();
				String str="create table Customer(id int(12),name varchar(54),"
						+ "gmail varchar(54),age int(23))";
				PreparedStatement  ps = c.prepareStatement(str);
				ps.execute(str);
				System.out.println("Table Created successfully.........");
				break;
			case 2:
				System.out.println("Enter Id:");
			int id=	sc.nextInt();
			System.out.println("Enter Name:");
			String name = sc.next();
			System.out.println("Enter gmail:");
			String gmail = sc.next();
			System.out.println("Enter age");
			int age = sc.nextInt();
			String s2="insert into Customer(id,name,gmail,age) values(?,?,?,?);";
			PreparedStatement  ps1 = c.prepareStatement(s2);
			ps1.setInt(1, id);
			ps1.setString(2, name);
			ps1.setString(3, gmail);
			ps1.setInt(4, age);
			ps1.execute();
			System.out.println("Values inserted successfully...........");
			break;
			case 3:
				System.out.println("Enter the id to update");
				int ide= sc.nextInt();
				System.out.println("Enter new name");
				String newData=sc.next();
				System.out.println("Enter new gmail");
				String newData2=sc.next();
				System.out.println("Enter new age");
				int  newData3 = sc.nextInt();
				String s3 = "update Customer set name=?,gmail=?,age=? where id=?";
				PreparedStatement  ps2= c.prepareStatement(s3);
				ps2.setString(1, newData);
				ps2.setString(2, newData2);
				ps2.setInt(3, newData3);
				ps2.setInt(4, ide);
			int rowsaffected=ps2.executeUpdate();
			if (rowsaffected>0) {
				System.out.println("Data updated");
				
			}else {
				System.out.println("No record found");
			}
				break;
			case 4:
				System.out.println("Enter the id that you want to delete");
				int del=sc.nextInt();
				
				String s4= " delete from customer where id=?;";
				PreparedStatement  ps3= c.prepareStatement(s4);
				ps3.setInt(1, del);
				int newAgain = ps3.executeUpdate();
				if (newAgain>0) {
					System.out.println("Deleted successfully.......");
				}else {
					System.out.println("No Records found");
				}
				break;
			case 5:
				System.out.println("Exit");
				c.close();

			default:
				System.out.println("Invalid");
				break;
			}
				
			
		
			}
			
		}



	

}
