package edu.govschool.govchat.gui;

// We need to import our socket package
import edu.govschool.govchat.socket.*;
// JavaFX imports
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * GUI for the GovChat client.
 * Most of the actual work is handled with <code>GCClientSocket</code>, this
 * provides us with a GUI to work with this socket and the entire client in
 * general.
 * @author Mr. Davis
 */
public class GCClient extends Application
{
    // Our GUI initially is very spartan, consisting of a large text area to
    // display messages sent and received, a entry field to enter messages, a
    // connect button and a send button. At first, we just connect using the
    // default host and port, localhost and 2000, so we don't need any elements
    // to input a custom host and port yet.
    private TextArea msgArea;
    private TextField entryField;
    private Button sendBtn;
    private Button connectBtn;
    
    // We need a client socket, since this is a client GUI
    private GCClientSocket clientSocket;
    
    // This flag will tell us if we're connected or not
    private boolean socketClosed = true;
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage)
    {
        // Initialize our GUI elements
        msgArea = new TextArea();
        entryField = new TextField();
        sendBtn = new Button("Send");
        connectBtn = new Button("Connect to localhost");
        
        // Set some options on our elements
        msgArea.setEditable(false); // Our messages should be read-only
        msgArea.setPrefColumnCount(20);
        msgArea.setPrefRowCount(20); // 20rows x 20characters big
        msgArea.setWrapText(true); // Our text will wrap if it's too big
        entryField.setPrefColumnCount(20); // Entry field is 20 characters wide
        entryField.setPromptText("Enter a message");
        
        // Set our event handlers
        sendBtn.setOnAction(e -> sendBtn_click());
        connectBtn.setOnAction(e -> connectBtn_click());
        
        // Organize our GUI
        HBox entryPane = new HBox(10, entryField, sendBtn);
        VBox pane = new VBox(10, msgArea, entryPane, connectBtn);
        pane.setAlignment(Pos.CENTER);
        
        // Display our GUI
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        
        // Set our window options
        primaryStage.setTitle("GovChat Client");
        primaryStage.setOnCloseRequest(e -> {
            if (clientSocket != null) clientSocket.shutdown();
        });
        primaryStage.show();
    }
    
    private void sendBtn_click()
    {
        
    }
    
    private void connectBtn_click()
    {
    
    }
    
    private class ClientSocketListener implements GCSocketListener
    {
        @Override
        public void onMessage(final String line)
        {
            
        }
        
        @Override
        public void onCloseUpdate(final Boolean isClosed)
        {
            
        }
    }
}
    