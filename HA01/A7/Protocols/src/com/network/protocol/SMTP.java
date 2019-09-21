package com.network.protocol;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.net.SocketFactory;

public class SMTP {
	byte[] host;
	int port = 25;
	
	public SMTP(byte[] host) {
		this.host = host;
		
		/*
		 * 	config.action_mailer.delivery_method = :smtp
			config.action_mailer.smtp_settings = {
			  :user_name => '83a6a0c550d2cd',
			  :password => 'c8175f8adcf5bf',
			  :address => 'smtp.mailtrap.io',
			  :domain => 'smtp.mailtrap.io',
			  :port => '2525',
			  :authentication => :cram_md5
			}
		 */
	}
	
	public boolean send(String message, String from, String to) throws IOException {
		Socket socket = null;
		OutputStream outStream = null;
		
		try {
			socket = SocketFactory.getDefault().createSocket(InetAddress.getByAddress(this.host), port);
			if(socket == null) {
				return false;
			}
			outStream = socket.getOutputStream();
			
			if(outStream == null) {
				System.out.println("Failed to open output stream");
			}
			
			System.out.println("HELO " + InetAddress.getLocalHost());
			outStream.write(InetAddress.getLocalHost().getAddress());
			
			System.out.println("Welcome guest to send a mail!");
			System.out.println("From: " + from);
			outStream.write(from.getBytes());
			
			System.out.println("Recepient: " + to);
			outStream.write(to.getBytes());
			
			System.out.println("Mail content: \n" + message);
			outStream.write(message.getBytes());
			
		} finally {
			outStream.close();
			socket.close();
		}		
		
		return true;
	}

}
