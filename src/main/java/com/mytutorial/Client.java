/**
 * 
 */
package com.mytutorial;

import java.io.StringReader;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * @author keerthi
 * 
 */

public class Client {
	private static final String MSG = "<simpleRequest><firstname>Keerthiram</firstname><surname>Murugesan</surname></simpleRequest>";
	private static final String URL = "http://localhost:8080/cepisfs_rmi_server/simpleService";

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
		"spring-ws-client.xml");
		WebServiceTemplate template = (WebServiceTemplate) ctx.getBean("webServiceTemplate");
		StreamSource source = new StreamSource(new StringReader(MSG));
		StreamResult result = new StreamResult(System.out);
		template.sendSourceAndReceiveToResult(source, result);
	}
}