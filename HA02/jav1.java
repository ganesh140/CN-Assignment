
import java.io.*; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.*; 
  
public class jav1 
{ 
    public static void main(String args[]) throws IOException 
    { 
        Scanner sc = new Scanner(System.in); 
  
        // Step 1:Create the socket object for 
        // carrying the data. 
        DatagramSocket ds = new DatagramSocket(); 
  
        InetAddress ip = InetAddress.getLocalHost(); 
        byte buf[] = null; 
  		        // loop while user not enters "bye" 
        System.out.println("Enter number of routers");
        int n=sc.nextInt();
        for(int i=50025;i<=(50025+(n*100));i+=100)
        {
        	
        	while (true) 
        	{ 
        		String inp = sc.nextLine(); 
  
            // convert the String input into the byte array. 
        		buf = inp.getBytes(); 
  
            // Step 2 : Create the datagramPacket for sending 
            // the data. 
        		DatagramPacket DpSend = 
                  new DatagramPacket(buf, buf.length, ip, i); 
  
            // Step 3 : invoke the send call to actually send 
            // the data. 
        		ds.send(DpSend); 
  
            // break the loop if user enters "bye" 
    
        		break; 
        	}
        } 
    } 
}
