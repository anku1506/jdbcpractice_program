//Program to create a database table in oracle from jdbc application
package com.ankupractice.jdbc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc1 {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		Statement st=con.createStatement();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter table name");
		String tname=br.readLine();
		String query="create table "+tname+"(Eno number(3) primary key,Ename varchar2(10),Esal float(5),Eaddr varchar2(15))";
		st.executeUpdate(query);
		System.out.println("Table"+tname +"is created successfully");
		st.close();
		con.close();
		
		}

}








	