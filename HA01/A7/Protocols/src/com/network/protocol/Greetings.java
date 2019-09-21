package com.network.protocol;

public class Greetings {

	public static void main(String[] args) throws Exception {
		//This is the IP address of our brave master's server
		SMTP mailProgram = new SMTP(new byte[] {(byte) 202, 62, 79, 36});
		mailProgram.send("Welcome to hte world of programming", "bravo@intelligent.com", "kishorep.shrivatsa@gmail.com");
	}
}
