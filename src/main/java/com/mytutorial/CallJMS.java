package com.mytutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CallJMS {
	public static void main(String s[]) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"activemq_jms_context.xml");
		MyJmsService service = (MyJmsService) ctx.getBean("myJmsService");
		
		service.process();
		//System.out.println("sdfsdfsdfsdf");
	}

}
