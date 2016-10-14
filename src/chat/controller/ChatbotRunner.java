package chat.controller;

import chat.controller.ChatbotController;

public class ChatbotRunner 
{
	public static void main (String [] args)
	{
		ChatbotController chatBotAppController = new ChatbotController();
		chatBotAppController.start();
	}
}

