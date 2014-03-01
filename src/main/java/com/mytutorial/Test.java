package com.mytutorial;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import edu.uky.cepis.domain.EmailAddress;

public class Test {
	public static void main(String a[]) {
		double params[]= {0,0.05,0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,0.95,1.0};
		for(int i=0;i<params.length;i++){
			System.out.println(params[i]);
		}
		/*GregorianCalendar gc = new GregorianCalendar();

		// Todays date

		System.out.println(gc.get(Calendar.DATE) + "/"
				+ (gc.get(Calendar.MONTH) + 1) + "/" + gc.get(Calendar.YEAR));

		// Two days ago

		gc.add(Calendar.DATE, -2);

		System.out.println(gc.get(Calendar.DATE) + "/"
				+ (gc.get(Calendar.MONTH) + 1) + "/" + gc.get(Calendar.YEAR));

		Properties props = System.getProperties();

		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "pop.coe.uky.edu");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		Session session = Session.getInstance(props);

		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress("root@coesis.coe.uky.edu"));
		
		msg
				.setRecipients(
						Message.RecipientType.TO,
						InternetAddress
								.parse("kmu222@uky.edu",
										false));
		msg.setSubject("CEPIS Advising Module Feedback ");
		msg.setText("Test");
		msg.setSentDate(new Date());

		Transport.send(msg);

		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
