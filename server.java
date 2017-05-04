
package devices;

import java.io.*;
import java.net.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * A TCP server that runs on port 9090.  When a client connects, it
 * sends the client the current date and time, then closes the
 * connection with that client.  Arguably just about the simplest
 * server you can write.
 */
public class server {

    /**
     * Runs the server.
     */
    public String send(String msg,int port) throws IOException {
    	
    	  ServerSocket listener = new ServerSocket(port);
          try {
              while (true) {
                  Socket socket = listener.accept();
                  try {
                	  
                      PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                     out.println(msg);
                  } finally {
                      socket.close();
                  }
              }
          }
          finally {
              listener.close();
          }
    }
          
          public String recieve() throws IOException { 
          
        	  Socket s = new Socket("localhost",9090);
        	  String msg="";
        	  DataInputStream dIn = new DataInputStream(s.getInputStream());

        	  boolean done = false;
        	  while(!done) {
        	    byte messageType = dIn.readByte();

        	    switch(messageType)
        	    {
        	    case 1: // Type A
        	      msg= dIn.readUTF();
        	      break;
        	   
        	    default:
        	      done = true;
        	    }
        	  }

        	  dIn.close();
          return msg;
          }
          
          
          
    
    public static void main(String[] args) throws IOException {
    	server s=new server();
    	s.send("on", 9090);
    	
    }

}