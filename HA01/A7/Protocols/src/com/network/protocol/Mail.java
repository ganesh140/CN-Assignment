package com.network.protocol;

import java.io.IOException;

public class Mail {
	
	//This is the IP address of our brave master's server
	private static byte[] host = new byte[] {(byte) 202, 62, 79, 36};
	static SMTP smtpMail = new SMTP(host);

	public static void main(String[] args) throws Exception {
		if(args.length < 2) {
			System.err.println("Expecting mandatory inputs: message, from, to");
			System.err.println("Example: java Mail \"Message\" \"from\" \"to\" ");
			System.exit(0);
		}
		
		String message =  args[0];
		String from =  args[1];
		String to =  args[2];
		
		
		if(message == null || message.equals("") ) {
			System.err.println("Please send some message.");
		}
		
		if(from == null || from.equals("") || !isValidEmail(from)) {
			System.err.println("Can't send a mail without a valid sender email address.");
		}
		
		if(to == null || to.equals("") || !isValidEmail(to)) {
			System.err.println("Can't send a mail without a valid receiver email address.");
		}
		
		smtpMail.send(message, from, to);
	}
	
	public static boolean send(String message, String from, String to) throws IOException {
		return smtpMail.send(message, from, to);
	}

	private static boolean isValidEmail(String email) {
		//TODO validate correct email using RegEx
		
		return true;
	}

}
