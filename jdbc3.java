// jdbc program to insert values in db using try-catch-finally
//(by taking dynamic input)

package com.ankupractice.jdbc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc3 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		BufferedReader br=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			st=con.createStatement();
			br=new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.print("Employee number: ");
				int eno=Integer.parseInt(br.readLine());
				System.out.print("Employee name: ");
				String ename=br.readLine();
				System.out.print("Employee salary: ");
				float esal=Float.parseFloat(br.readLine());
				System.out.print("Employee Address: ");
				String eaddr=br.readLine();
				String query="insert into emp1 values("+eno+",'"+ename+"',"+esal+",'"+eaddr+"')";
				st.executeQuery(query);
				System.out.println("Employee created successfully");
				System.out.println("One more employee[YES/NO] :");
				String option=br.readLine();
				if(option.equalsIgnoreCase("yes")) {
					continue;
				}else {
					break;
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				st.close();
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
				
			}
			
		}

	}


