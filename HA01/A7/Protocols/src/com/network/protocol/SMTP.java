package com.network.protocol;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.SocketFactory;

public class SMTP {
	byte[] host;
	int port = 25;
	
	public SMTP(byte[] host) {
		this.host = host;
	}
	
	public boolean send(String message, String from, String to) throws UnknownHostException, IOException {
		Socket socket = SocketFactory.getDefault().createSocket(InetAddress.getByAddress(this.host), port);
		if(socket == null) {
			return false;
		}
		OutputStream outStream = socket.getOutputStream();
		
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
		
		
		return true;
	}

}
