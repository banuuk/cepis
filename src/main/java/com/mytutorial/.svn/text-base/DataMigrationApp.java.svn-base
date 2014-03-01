package com.mytutorial;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DataMigrationApp {

	public static void main(String[] args) {
		DataMigrationApp app = new DataMigrationApp();
		final String sQryToFind = "SELECT * FROM tblAdvconference " +
		"where ConDate is not null or ConDate > '0000-00-00 00:00:00'";
		try {
            // Connect to the database
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		      String url = "jdbc:mysql://itc5.coe.uky.edu/DataReview";
            Connection con = DriverManager.getConnection(url, "portal", "u$652608");
            // Execute the SQL statement
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(sQryToFind);
            // Loop thru all the rows
            int i =0;
            while( resultSet.next() && i<10) {
                String data1 = resultSet.getString( "UID" );
                String data2 = resultSet.getString( "ConDate" );
                System.out.println("Date: "+data2+"; UID: "+data1);
                i++;
            }
            stmt.close();
        }
        catch( Exception e ) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
		
	}

}
