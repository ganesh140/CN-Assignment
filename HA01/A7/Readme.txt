SMTP programming assignment

This project contains 3 Java files:
1. SMTP.java = contains the actual socket connection and sending mechanism
2. Mail.java  = Is a mail helper to validate and send a mail
3. Greetings.java = Demonstrates the usage of sending mail.

Project can be executed in two ways
1. Using command line arguments
2. Use in any Java programs

Using command line arguments:
Usage: java Mail "Message to be sent" "sender email address" "receiver email address"
Example: java Mail "Hello world" "abc@xyz.com" "def@xyz.com"


Use in any Java programs:
com.network.protocol.Mail.send("Hello world", "abc@xyz.com", "def@xyz.com");
