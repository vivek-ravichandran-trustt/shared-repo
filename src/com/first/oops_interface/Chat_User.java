package com.first.oops_interface;

public class Chat_User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfaceChatApplication client = new ChatApplicationImpl();

		client.connect("Alice");
		
		client.sendMessage("Hello, everyone!");
		client.receiveMessage("Bob: Hi, Alice!");
		
		client.disconnect();

	}

}
