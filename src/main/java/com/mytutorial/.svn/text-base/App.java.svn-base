package com.mytutorial;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.uky.cepis.domain.IPAddress;
import edu.uky.cepis.domain.LastLogin;
import edu.uky.cepis.domain.Role;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.WorkingSet;
import edu.uky.cepis.service.IPAddressService;
import edu.uky.cepis.service.LastLoginService;
import edu.uky.cepis.service.RoleService;
import edu.uky.cepis.service.UserService;
import edu.uky.cepis.service.WorkingSetService;

public class App extends HibernateDaoSupport {

	public static void main(String[] args) {
		App app = new App();
		/*
		 * /* Properties props = new Properties(); props.put("mail.smtp.user",
		 * d_email); props.put("mail.smtp.host", d_host);
		 * props.put("mail.smtp.port", d_port);
		 * props.put("mail.smtp.starttls.enable","true"); // just in case, but
		 * not currently necessary, oddly enough props.put("mail.smtp.auth",
		 * "true"); //props.put("mail.smtp.debug", "true");
		 * props.put("mail.smtp.socketFactory.port", d_port);
		 * props.put("mail.smtp.socketFactory.class",
		 * "javax.net.ssl.SSLSocketFactory");
		 * props.put("mail.smtp.socketFactory.fallback", "false");
		 * 
		 * 
		 * JavaMailSenderImpl sender = new JavaMailSenderImpl();
		 * 
		 * sender.setUsername(d_email); sender.setPassword(d_password);
		 * sender.setJavaMailProperties(props);
		 * 
		 * MimeMessage message = sender.createMimeMessage(); MimeMessageHelper
		 * helper = new MimeMessageHelper(message); try { helper.setFrom(new
		 * InternetAddress(m_from)); helper.setTo(new InternetAddress(d_email));
		 * helper.setSubject(m_subject);
		 * helper.setText("Thank you for ordering!");
		 * 
		 * sender.send(message); } catch (MessagingException e) {
		 * System.err.println(e.getMessage()); }
		 */

		/*
		 * SimpleMailMessage msg = new SimpleMailMessage();
		 * org.springframework.mail.javamail.JavaMailSenderImpl mailSender = new
		 * org.springframework.mail.javamail.JavaMailSenderImpl();
		 * mailSender.setHost("smtp.gmail.com"); mailSender.setPort(465);
		 * msg.setFrom("keerthi166@gmail.com");
		 * mailSender.setUsername("keerthi166");
		 * mailSender.setPassword("XXXXXXX");
		 * 
		 * msg.setTo("keerthi166@gmail.com"); msg.setText( "Dear " +
		 * ", thank you for placing order. Your order number is "); try{
		 * mailSender.send(msg); } catch(MailException ex) { // simply log it
		 * and go on... System.err.println(ex.getMessage()); }
		 */
		/*
		 * String[] configLocation = { "userContext.xml",
		 * "lastLoginContext.xml", "ipAddressContext.xml",
		 * "workingSetContext.xml", "roleContext.xml" }; ApplicationContext ctx
		 * = new ClassPathXmlApplicationContext( configLocation);
		 * 
		 * UserService service = (UserService) ctx.getBean("userService");
		 * LastLoginService lastloginservice = (LastLoginService) ctx
		 * .getBean("lastLoginService"); IPAddressService ipaddressservice =
		 * (IPAddressService) ctx .getBean("ipAddressService");
		 * WorkingSetService workingsetservice = (WorkingSetService) ctx
		 * .getBean("workingSetService"); RoleService roleservice =
		 * (RoleService) ctx.getBean("roleService");
		 * 
		 * User user = service.findByUsername("kmu222");
		 * 
		 * if (user != null) { System.out.println(user.getUsername());
		 * List<LastLogin> lastLogins = user.getLastlogins();
		 * 
		 * if (lastLogins != null) {
		 * System.out.println("Last login info found"); LastLogin lastLogin =
		 * new LastLogin(new Date()); IPAddress ipAddr = new
		 * IPAddress("127.0.0.1:localhost", "Mozilla Firefox");
		 * 
		 * // Add Recent login info
		 * lastloginservice.addLastLoginToUserAccount(lastLogin, user);
		 * 
		 * // Add Recent IPAddress info
		 * ipaddressservice.addIPAddressToUserAccount(ipAddr, user);
		 * 
		 * // Get recent login info // lastLogin =
		 * service.getRecentUserLastLoginInfo(user);
		 * 
		 * // Get recent ip Address info ipAddr =
		 * ipaddressservice.getRecentUserIPAddressInfo(user);
		 * 
		 * System.out.println(lastLogin); System.out.println(ipAddr);
		 * 
		 * List<User> users = lastloginservice
		 * .getUserLastLoginStatistics(lastLogin); User user1 = null; User user2
		 * = null; User user3 = null; User user4 = null; User user5 = null; /*if
		 * (users != null) { user1 = (User) users.toArray()[0];
		 * System.out.println(user1.getUsername()); }
		 */

		/*
		 * users = ipaddressservice.getUserIPAddressStatistics(ipAddr); /*if
		 * (users != null) { user1 = (User) users.toArray()[0];
		 * System.out.println(user1.getUsername()); }
		 */

		/*
		 * WorkingSet ws = workingsetservice.createWorkingSet(user, "WSTEST5");
		 * if (ws != null) {
		 * System.out.println("WorkingSet Created successfully"); } user1 =
		 * service.findByUsername("abbr211"); user2 =
		 * service.findByUsername("zsgrah2"); user3 =
		 * service.findByUsername("kmu222"); user4 =
		 * service.findByUsername("vdna222"); boolean status = false; // status
		 * = service.addUserToWorkingSet(ws, user1); if (status) {
		 * System.out.println("Working Set - User added successfully"); } users
		 * = new ArrayList<User>(0); users.add(user1); users.add(user2);
		 * users.add(user3); users.add(user4); status =
		 * workingsetservice.addUsersToWorkingSet(ws, users); if (status) {
		 * System.out .println("Working Set - Users added successfully"); if
		 * (workingsetservice.deleteUserFromWorkingSet(ws, user3)) { System.out
		 * .println("Working Set - User deleted successfully"); } }
		 * workingsetservice.deleteWorkingSet(user, ws); WorkingSet ws1 =
		 * workingsetservice.createWorkingSet(user, "merge11"); if (ws1 != null)
		 * { System.out.println("WorkingSet1 Created successfully"); } status =
		 * workingsetservice.addUsersToWorkingSet(ws1, users); if (status) {
		 * System.out .println("Working Set - Users 1 added successfully"); }
		 * 
		 * user5 = service.findByUsername("wsosbo2"); users = new
		 * ArrayList<User>(0); users.add(user3); users.add(user5); WorkingSet
		 * ws2 = workingsetservice.createWorkingSet(user, "merge21delete"); if
		 * (ws2 != null) {
		 * System.out.println("WorkingSet2 Created successfully"); } status =
		 * workingsetservice.addUserToWorkingSet(ws2, user5); if (status) {
		 * System.out .println("Working Set - Users 2 added successfully"); }
		 * workingsetservice.mergeWorkingSets(user, ws1, ws2); Role role1 =
		 * roleservice
		 * .createRole("ROLE_DEVELOPER","Role dedicated for Developers",
		 * "See logs, debug info"); Role role2 =
		 * roleservice.createRole("ROLE_ADMINISTRATOR",
		 * "Role dedicated for Administrators",
		 * "See statistical info, modify total portal settings"); List<Role>
		 * roles = new ArrayList<Role>(0); roles.add(role1); roles.add(role2);
		 * roleservice.addRolesToUserAccount(user3, roles); Role role3 =
		 * roleservice.findByName("ROLE_DEVELOPER").get(0); users =
		 * roleservice.getUserRoleStatistics(role3);
		 * System.out.println(users.iterator().next().getUsername());
		 * 
		 * Map<Long, String> wsmap = workingsetservice .getWorkingSetMap(user3);
		 * Set<Entry<Long, String>> ent = wsmap.entrySet(); Iterator<Entry<Long,
		 * String>> iter = ent.iterator(); Entry<Long, String> entry = null;
		 * while (iter.hasNext()) { entry = iter.next();
		 * System.out.println(entry.getKey() + "---->" + entry.getValue()); }
		 * 
		 * } else { System.out.println("No Last login info found"); } } else {
		 * System.out.println("User is null"); } }
		 */
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
