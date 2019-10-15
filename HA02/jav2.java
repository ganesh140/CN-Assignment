
import java.io.*; 
import java.net.*; 
 

import java.util.*; 
  
public class jav2 
{ 
    public static void main(String[] args) throws IOException 
    { 
        // Step 1 : Create a socket to listen at port 50125
	
        // loop while user not enters "bye" 
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter number of routers");
        int n=sc.nextInt();
        for(int i=50025;i<=(50025+(n*100));i+=100)
    	{
        	DatagramSocket ds = new DatagramSocket(i); 
        	byte[] receive = new byte[65535]; 
  
        	DatagramPacket DpReceive = null; 
        	while (true) 
        	{ 
  
            // Step 2 : create a DatgramPacket to receive the data. 
        		DpReceive = new DatagramPacket(receive, receive.length); 
  
            // Step 3 : revieve the data in byte buffer. 
        		ds.receive(DpReceive); 
  
        		System.out.println("Client:-" + data(receive)); 
            
            // Exit the server if the client sends "bye" 
        		break;
  
            // Clear the buffer after every message. 
           
        	} 
    	} 
    }
    // A utility method to convert the byte array 
    // data into a string representation. 
    public static StringBuilder data(byte[] a) 
    { 
        if (a == null) 
            return null; 
        StringBuilder ret = new StringBuilder(); 
        int i = 0; 
        while (a[i] != 0) 
        { 
            ret.append((char) a[i]); 
            i++; 
        } 
        return ret; 
    } 
} 
