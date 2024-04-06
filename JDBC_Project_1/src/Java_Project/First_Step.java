package Java_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class First_Step {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/DataBase?createDatabaseIfNotExist=true", "root", "root");
				
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.println("choose options");
			System.out.println("1.create");
			System.out.println("2.insert");
			System.out.println("3.update");
			System.out.println("4.delete");
			System.out.println("5.Exit");
			
			int i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("create the table");
				String s =sc.next();
				String str = 
						"create table Student_Details(id int(12), name varchar(54), gmail varchar(76), phone int(10),address varchar(45))";
				
				PreparedStatement ps = c.prepareStatement(str);
				ps.executeUpdate(str);
				System.out.println("table created");
				break;
			case 2:

				 System.out.println("ID:");
                 int id = sc.nextInt();
                 System.out.println("Name: ");
                 String name = sc.next();
                 System.out.println("Gmail:");
                 String gmail = sc.next();
                 System.out.println("Phone Number");
                 long phone = sc.nextLong();
                 System.out.println("Enter the Address");
                 String address= sc.next();
String s2 = "insert into Student_Details(id, name, gmail, phone,address) values(?, ?, ?, ?,?)";
				PreparedStatement ps1 = c.prepareStatement(s2);
				ps1.setInt(1, id);
                ps1.setString(2, name);
                ps1.setString(3, gmail);
                ps1.setLong(4,phone );
                ps1.setString(5, address);
                ps1.execute();
				System.out.println("data created");
				break;
			case 3:
				System.out.println("Update the Id");
				int ide = sc.nextInt();
				System.out.println("update the Name");
				String nameUpdate = sc.next();
				System.out.println("update the gmail");
				String gmailUpdate=sc.next();
				System.out.println("update the PhoneNumber");
				long phoneUpdate= sc.nextLong();
				System.out.println("update the address");
				String addressUpdate=sc.next();


				String s3 = "update Student_details set nameUpdate=?,gmailUpdate=?,phoneUpdate=?,addressUpdate=? where id=?;";
				
				PreparedStatement ps2 = c.prepareStatement(s3);
				ps2.setInt(1, ide);
				ps2.setString(2, nameUpdate);
				ps2.setString(3, gmailUpdate);
				ps2.setLong(4, phoneUpdate);
				ps2.setString(5, addressUpdate);
				int ps22=ps2.executeUpdate();
				if (ps22>0) {
					System.out.println("updated successfully.....");
				}else {
					System.out.println("no record found....");
				}
			
				//System.out.println("data updated ");
				break;
				
			case 4:
				System.out.println("delete the data");
				int del = sc.nextInt();
				String newDel = sc.next();
				String s4 = "delete from new_table where id=;"+del;
				PreparedStatement ps3 = c.prepareStatement(s4);
				System.out.println("data deleted ");
				break;
			case 5:
				System.out.println("Exit");
				break;
				
			default:
				System.out.println("Invalid");
				break;
			}
		
		}
		
	}

}