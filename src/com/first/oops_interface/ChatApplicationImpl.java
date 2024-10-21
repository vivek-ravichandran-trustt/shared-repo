package com.first.oops_interface;
import java.util.ArrayList;

import java.util.List;

public class ChatApplicationImpl implements InterfaceChatApplication {

	    private String username;
	    private List<String> messageHistory = new ArrayList<>();

	    @Override
	    public void connect(String username) {
	        this.username = username;
	        System.out.println(username + " connected to the chat.");
	    }

	    @Override
	    public void disconnect() {
	        System.out.println(username + " disconnected from the chat.");
	    }

	    @Override
	    public void sendMessage(String message) {
	        String fullMessage = username + ": " + message;
	        messageHistory.add(fullMessage);
	        System.out.println(fullMessage);
	        // Here you would add code to send the message to the server
	    }

	    @Override
	    public void receiveMessage(String message) {
	        messageHistory.add(message);
	        System.out.println("Received: " + message);
	   }

}



