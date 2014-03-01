package edu.uky.cepis.test;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.uky.cepis.dao.UserDaoImpl;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.service.UserService;

public class SimpleLDAPClient {
	public static void main(String[] args) {
		Hashtable env = new Hashtable();

		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://128.163.16.252:389/o=uky");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, "ou=users,o=uky");
		DirContext ctx = null;
		NamingEnumeration results = null;
		String username = "smwork3";
		String cn = "";
		SearchResult searchResult = null;
		Attributes attributes = null;
		Attribute attr = null;

		try {
			ctx = new InitialDirContext(env);

			SearchControls controls = new SearchControls();
			controls.setSearchScope(SearchControls.SUBTREE_SCOPE);

			System.out.println(username);
			results = ctx.search("", "(cn=" + username + ")", controls);
			while (results.hasMore()) {
				searchResult = (SearchResult) results.next();
				attributes = searchResult.getAttributes();
				attr = attributes.get("sn");
				if (attr != null)
					cn = (String) attr.get();
				else
					cn = null;
				System.out.println(" Last name = " + cn);

				if (cn == null) {
					continue;
				}

				
				attr = attributes.get("generationalqualifier");
				if (attr != null)
					cn = (String) attr.get();
				else
					cn = null;
				System.out.println(" generationalqualifier = " + cn);

				attr = attributes.get("cn");
				cn = (String) attr.get();
				System.out.println(" Person Common Name = " + cn);

				attr = attributes.get("displayname");
				cn = (String) attr.get();
				System.out.println(" displayname  = " + cn);

				attr = attributes.get("jobcode");
				cn = (String) attr.get();
				System.out.println(" jobcode = " + cn);

				attr = attributes.get("passworduniquerequired");
				if (attr != null)
					cn = (String) attr.get();
				else
					cn = "NA";
				System.out.println(" passworduniquerequired = " + cn);

				attr = attributes.get("workforceid");
				cn = (String) attr.get();
				System.out.println(" UID = " + cn);

				attr = attributes.get("givenname");
				cn = (String) attr.get();
				System.out.println(" First name = " + cn);

				attr = attributes.get("initials");
				if (attr != null)
					cn = (String) attr.get();
				else
					cn = "NA";
				System.out.println(" Middle name = " + cn);

				attr = attributes.get("sn");
				if (attr != null)
					cn = (String) attr.get();
				else
					cn = "NA";
				System.out.println(" Last name = " + cn);

				attr = attributes.get("fullname");
				if (attr != null)
					cn = (String) attr.get();
				else
					cn = "NA";
				System.out.println(" Full name = " + cn);

				attr = attributes.get("telephonenumber");
				if (attr != null)
					cn = (String) attr.get();
				else
					cn = "NA";
				System.out.println(" telephonenumber = " + cn);

				attr = attributes.get("mail");
				if (attr != null)
					cn = (String) attr.get();
				else
					cn = "NA";
				System.out.println(" email = " + cn);

				attr = attributes.get("acl");
				if (attr != null)
					cn = (String) attr.get();
				else
					cn = "NA";
				System.out.println(" acl = " + cn);

				attr = attributes.get("userid");
				if (attr != null)
					cn = (String) attr.get();
				else
					cn = "NA";
				System.out.println(" userid = " + cn);

				attr = attributes.get("sasloginsecretkey");
				if (attr != null)
					cn = (String) attr.get();
				else
					cn = "NA";
				System.out.println(" sasloginsecretkey = ******");

				attr = attributes.get("logintime");
				if (attr != null)
					cn = (String) attr.get();
				else
					cn = "NA";
				System.out.println(" logintime = " + cn);

				attr = attributes.get("passworduniquerequired");
				if (attr != null)
					cn = (String) attr.get();
				else
					cn = "NA";
				System.out.println(" passworduniquerequired = " + cn);

				attr = attributes.get("passwordrequired");
				if (attr != null)
					cn = (String) attr.get();
				else
					cn = "NA";
				System.out.println(" passwordrequired = " + cn);

			}

			// //////////////////////////////////////////////////////////
		} catch (NamingException e) {
			throw new RuntimeException(e);
		} finally {
			if (results != null) {
				try {
					results.close();
				} catch (Exception e) {
				}
			}
			if (ctx != null) {
				try {
					ctx.close();
				} catch (Exception e) {
				}
			}
		}
	}
}
