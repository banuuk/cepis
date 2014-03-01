package com.mytutorial;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * @author  keerthi
 */
public class JmsSender {
	/**
	 * @uml.property  name="jmsTemplate"
	 */
	private JmsTemplate jmsTemplate;

	/**
	 * @return  the jmsTemplate102
	 * @uml.property  name="jmsTemplate"
	 */
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	/**
	 * @param jmsTemplate102  the jmsTemplate102 to set
	 * @uml.property  name="jmsTemplate"
	 */
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void sendMessage(){
		jmsTemplate.send("cepis.replyQueue",new MessageCreator(){
			public Message createMessage(Session session) throws JMSException{
				return session.createTextMessage("This is a text message");
			}
		});
	}
}
