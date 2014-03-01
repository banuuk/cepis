/**
 * 
 */
package com.mytutorial;

import java.sql.*;
import java.util.HashMap;
import com.mysql.jdbc.Driver;

/**
 * @author  keerthi
 */
public class Bhaagya_Graph_Problem {
	/**
	 * @uml.property  name="conn"
	 */
	private static Connection conn = null;
	public HashMap<String, String> idmap_list = new HashMap<String, String>(0);


	public Bhaagya_Graph_Problem() {

	}

	static {
		String username = "kmu222";
		String password = "science16";
		String url = "jdbc:mysql://mysql.cs.uky.edu/kmu222";
		try {
			com.mysql.jdbc.Driver d = (Driver) Class.forName(
					"com.mysql.jdbc.Driver").newInstance();
			// System.out.println(d.getMajorVersion()+":"+d.getMinorVersion());
			try {
				setConn(DriverManager.getConnection(url, username, password));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Database connection created successfully");
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void initialize() {

		// Retrieve the recordset from database
		Statement s = null;
		ResultSet rs = null;
		String com_id;
		String upws;
		String downws;
		String minseq;
		String headwat;
		int i = 0;

		try {
			s = getConn().createStatement();

			/*
			 * s.executeQuery("Select * from subset where rchlev = '4' and headwat = '1'"
			 * ); rs = s.getResultSet(); if (rs.next()) { main_stream_start_id =
			 * rs.getString("com_id");
			 * System.out.println("Main stream source id: " +
			 * main_stream_start_id); }
			 */
			// Populate the Lists
			
			s.executeQuery("Select * from dataset order by downws desc");
			rs = s.getResultSet();
			Object[] args = new Object[] { "com_id", "sec_id", "from", "to","minseq", "from", "to","minseq" };
			System.out.printf("%10s %10s %10s %10s %10s %10s %10s %10s", args);
			System.out.println();
			while (rs.next()) {
				args = null;
				args = new Object[8];
				com_id = rs.getString("com_id");
				downws = rs.getString("downws");
				if (!downws.equals("0")) {
					args[3] = downws;
					idmap_list.put(downws, com_id);
					args[6]=com_id;
				} else {
					continue;
				}
				upws = rs.getString("upws");
				if (!upws.equals("0")) {
					args[1] = upws;
					args[2] = upws;
					if(idmap_list.containsKey(upws)){
						args[0] = idmap_list.get(upws);
						args[5] = args[0];
					}
				} else {
					continue;
				}
				minseq = rs.getString("minseq");
				if (!minseq.equals("0")) {
					args[4] = minseq;
					if(args[4].equals(args[2])){
						args[4]="0";
					}
					if(idmap_list.containsKey(minseq)){
						args[7] = idmap_list.get(minseq);
						if(args[7].equals(args[5])){
							args[7]="0";
						}
					}
				} else {
					continue;
				}

				System.out.printf("%10s %10s %10s %10s %10s %10s %10s %10s", args);
				System.out.println();

			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Bhaagya_Graph_Problem prob = new Bhaagya_Graph_Problem();
			prob.initialize();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getConn() != null) {
				try {
					conn.close();
					System.out
							.println("Database Connection closed successfully");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @param conn  the conn to set
	 * @uml.property  name="conn"
	 */
	public static void setConn(Connection conn) {
		Bhaagya_Graph_Problem.conn = conn;
	}

	/**
	 * @return  the conn
	 * @uml.property  name="conn"
	 */
	public static Connection getConn() {
		return conn;
	}

}
