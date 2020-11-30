//jdbc program to update salary in existing emp1 database(using try-catch-finally)
//using scanner class for dynamic input
package com.ankupractice.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
public class jdbc4 {
		public static void main(String[] args) {
			Connection con=null;
			Statement st=null;
			Scanner s=null;
			
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				st=con.createStatement();
				s=new Scanner(System.in);
				System.out.print("Bonus Amount: ");
				int bonus=s.nextInt();
				System.out.print("Salary range: ");
				float salrange=s.nextFloat();
				int rowcount=st.executeUpdate("update emp1 set ESAL=ESAL+"+bonus+"where ESAL<"+salrange);
				System.out.print("Employee updated:"+rowcount);
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
				
		

