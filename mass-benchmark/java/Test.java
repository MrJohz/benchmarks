/**
 * A very basic server example.  We should use a server to benchmark Java
 * because these days that's where Java recieves the most use.  It would
 * be unfair to benchmark it any other way.
 * 
 * 
 * This code is pretty much all taken from http://www.tutorialspoint.com/java/java_networking.htm
 */

import java.net.*;
import java.io.*;

public class Test extends Thread
{
   private ServerSocket serverSocket;
   
   public Test(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(10000);
   }

   public void run()
   {
      while(true)
      {
         try
         {
            System.out.println("Waiting for client on port " +
            serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            System.out.println("Just connected to "
                  + server.getRemoteSocketAddress());
            DataInputStream in =
                  new DataInputStream(server.getInputStream());
            System.out.println(in.readUTF());
            DataOutputStream out =
                 new DataOutputStream(server.getOutputStream());
            out.writeUTF("Thank you for connecting to "
              + server.getLocalSocketAddress() + "\nGoodbye!");
            server.close();
         }catch(SocketTimeoutException s)
         {
            System.out.println("Socket timed out!");
            break;
         }catch(IOException e)
         {
            e.printStackTrace();
            break;
         }
      }
   }
   public static void main(String [] args)
   {
      int port = Integer.parseInt(args[0]);
      try
      {
         Thread t = new Test(port);
         t.start();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}
