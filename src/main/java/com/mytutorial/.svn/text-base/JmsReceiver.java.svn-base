package com.mytutorial;


import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;


/**
 * @author  keerthi
 */
public class JmsReceiver {
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
	
	public void processMessage(){
		Message msg = jmsTemplate.receive("cepis.replyQueue");
		try{
			TextMessage textMessage = (TextMessage) msg;
			if(msg!=null){
				System.out.println("RECEIVED:"+textMessage.getText());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
