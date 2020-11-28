//program2: jdbc program to create table and its column dynamically(By taking user input)
package com.ankupractice.jdbc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc2 {

	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		Statement st=con.createStatement();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter table name: ");
		String tname=br.readLine();
		String query="create table "+tname+"(";
		String primarykeys=" ";
		int primarykeycount=0;
		while(true) {
			System.out.print("Column name: ");
			String colname=br.readLine();
			System.out.print("col data type: ");
			String coltype=br.readLine();
			System.out.print("col size");
			int colsize=Integer.parseInt(br.readLine());
			query=query+colname+" "+coltype+"("+colsize+")";
			System.out.print("Is primary key[yes/No]: ");
			String primarykeyoption=br.readLine();
			if(primarykeyoption.equalsIgnoreCase("yes")) {
				if(primarykeycount==0) {
					primarykeys=primarykeys+colname;
					primarykeycount=primarykeycount+1;
				}else {
					primarykeys=primarykeys+","+colname;
					
					}
			}
			System.out.print("one more col[yes/no]: ");
			String columnoption=br.readLine();
			if(columnoption.equalsIgnoreCase("yes")) {
				query=query+",";
				continue;
			}else {
				query=query+"," + "primary key("+primarykeys+"))";
				break;
			}
			
			
		}	
		//System.out.println(query); // it will print executed query
		st.executeUpdate(query);
		System.out.println("Table "+tname+" created successfully");
		st.close();
		con.close();
		
	}

}






	