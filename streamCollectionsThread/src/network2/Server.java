package network2;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame {
   private JTextField enter;
   private JTextArea display;
   ObjectOutputStream output;
   ObjectInputStream input;

   public Server(){
      super( "Server" );
      Container c = getContentPane();
      enter = new JTextField();
      enter.setEnabled( false );
      enter.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e ){
               sendData( e.getActionCommand() );
            }
         }
      );

      c.add( enter, BorderLayout.NORTH );
      display = new JTextArea();
      c.add( new JScrollPane( display ),
             BorderLayout.CENTER );
      setSize( 300, 150 );
      show();
   }

   public void runServer(){
      ServerSocket server;
      Socket connection;
      int counter = 1;
      try {
         // Step 1: Create a ServerSocket.
         server = new ServerSocket( 5050, 100 );
         while ( true ) {
            // Step 2: Wait for a connection.
            display.setText( "Waiting for connection\n" );
            connection = server.accept();
            display.append( "Connection " + counter + " received from: " +
               connection.getInetAddress().getHostName() );

            // Step 3: Get input and output streams.
            output = new ObjectOutputStream(connection.getOutputStream() );
            output.flush();

            input = new ObjectInputStream(connection.getInputStream() );
            display.append( "\nGot I/O streams\n" );

            // Step 4: Process connection.
            String message = "SERVER>>> Connection successful";
            output.writeObject( message );
            output.flush();
            enter.setEnabled( true );

            do {
               try {
                  message = (String) input.readObject();
                  display.append( "\n" + message );
                  display.setCaretPosition(display.getText().length() );
               }catch ( ClassNotFoundException cnfex ) {
                  display.append("\nUnknown object type received" );
               }
            } while ( !message.equals( "CLIENT>>> TERMINATE" ) );

            // Step 5: Close connection.
            display.append( "\nUser terminated connection" );
            enter.setEnabled( false );
            output.close();
            input.close();
            connection.close();
            ++counter;
         }
      }catch ( EOFException eof ) {
         System.out.println( "Client terminated connection" );
      }catch ( IOException io ) {
         io.printStackTrace();
      }
   }

   private void sendData( String s ){
      try {
         output.writeObject( "SERVER>>> " + s );
         output.flush();
         display.append( "\nSERVER>>>" + s );
      }catch ( IOException cnfex ) {
         display.append("\nError writing object" );
      }
   }

   public static void main( String args[] ){
      Server app = new Server();
      app.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e ){
               System.exit( 0 );
            }
         }
      );

      app.runServer();
   }
}