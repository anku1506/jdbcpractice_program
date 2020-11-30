//jdbc program to delete a record whose salary is less than sal in existing emp1 database(using try-catch-finally)
//using scanner class for dynamic input
package com.ankupractice.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
public class jdbc5 {
		public static void main(String[] args) {
			Connection con=null;
			Statement st=null;
			Scanner s=null;
			
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				st=con.createStatement();
				s=new Scanner(System.in);
				System.out.print("Salary range: ");
				float salrange=s.nextFloat();
				int rowcount=st.executeUpdate("delete from emp1 where ESAL<"+salrange);
				System.out.print("no of Employee deleted:"+rowcount);
			}
			catch(Exception e) {
			  e.printStackTrace();	
			}finally {
			 try {
				 
				 s.close();
				 st.close();
				 con.close();
			 }catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
				
		


