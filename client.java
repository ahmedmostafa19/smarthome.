package devices;

import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;
public class client {

      void send()throws IOException{
      
        Socket s = new Socket("localhost",9090);
        
        BufferedReader input =
            new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();
    	  tv t=new tv();
      	  String msg=t.excecute(answer);
      	DataOutputStream dOut = new DataOutputStream(s.getOutputStream());

     // Send first message
     dOut.writeByte(1);
     dOut.writeUTF(msg);
     dOut.flush();
     
     
     dOut.writeByte(-1);
     dOut.flush();
     dOut.close();
      //s.close();
      	//System.exit(0);
       // return msg;
       
    }
      public static void main(String[] args) throws IOException {
    	  server s=new server();
    	  System.out.println(s.recieve());
      }
}