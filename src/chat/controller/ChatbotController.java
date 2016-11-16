package chat.controller;
import chat.model.Chatbot;
import chat.view.ChatViewer;
import chat.view.ChatFrame;

public class ChatbotController 
{
	private Chatbot stupidBot;
	private ChatViewer chatView;
	private ChatFrame baseFrame;
	
	public ChatbotController()
	{
		stupidBot = new Chatbot("Boaty McBoatFace");
		chatView = new ChatViewer();
		baseFrame = new ChatFrame(this);
	}
	
	public void start() 
	{
		String response = chatView.collectResponse("What do you want to talk about today?");
		
		while(stupidBot.lengthChecker(response))
		{
			chatView.displayMessage(useChatbotCheckers(response));
			response = chatView.collectResponse("Oh, you are interested in " + response);
			
		}
		
	}
	
	public String useChatbotCheckers(String input)
	{
		String answer = "";
		
		if(stupidBot.contentChecker(input))
		{
			answer += "\nYou know my special secret\n";
		}
		if(stupidBot.memeChecker(input))
		{
			answer += "\nI can has memes?\n";
		}
		if(stupidBot.lengthChecker(answer))
		{
			answer += "Sorry, I don't know about " + input;
		}
		
		return answer;
	}

	
	
}
