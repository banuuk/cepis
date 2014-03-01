package com.mytutorial;

import javax.jms.MessageListener;
import javax.jms.Message;
import javax.jms.TextMessage;


// Message Driven POJO (MDP)
public class MyListener implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		if(msg instanceof TextMessage){
			System.out.println("Received Asynchronously: "+(TextMessage)msg);
		}
		else{
			throw new RuntimeException("The msg should be of type TextMessage");
		}
		
	}
	
}
