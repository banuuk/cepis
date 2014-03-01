/**
 * 
 */
package com.mytutorial;

/**
 * @author  keerthi
 */
public class MyJmsServiceImpl implements MyJmsService {

	/**
	 * @uml.property  name="sender"
	 * @uml.associationEnd  
	 */
	private JmsSender sender;

	/**
	 * @return  the sender
	 * @uml.property  name="sender"
	 */
	public JmsSender getSender() {
		return sender;
	}

	/**
	 * @param sender  the sender to set
	 * @uml.property  name="sender"
	 */
	public void setSender(JmsSender sender) {
		this.sender = sender;
	}

	/**
	 * @return  the receiver
	 * @uml.property  name="receiver"
	 */
	public JmsReceiver getReceiver() {
		return receiver;
	}

	/**
	 * @param receiver  the receiver to set
	 * @uml.property  name="receiver"
	 */
	public void setReceiver(JmsReceiver receiver) {
		this.receiver = receiver;
	}

	/**
	 * @uml.property  name="receiver"
	 * @uml.associationEnd  
	 */
	private JmsReceiver receiver;

	@Override
	public void process() {
		sender.sendMessage();
		// sleep for 10 seconds so that you can see the message in
		// the OpenJMS admin console
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException iex) {
		}
		receiver.processMessage();*/

	}

}
