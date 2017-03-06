package chat.controller;
import chat.model.Chatbot;
import chat.view.ChatViewer;
import chat.view.ChatFrame;
import chat.model.CTECTwitter;

public class ChatbotController 
{
	private Chatbot stupidBot;
	private ChatViewer chatView;
	private ChatFrame baseFrame;
	private CTECTwitter tweetBot;

	public ChatbotController()
	{
		stupidBot = new Chatbot("Boaty McBoatFace");
		tweetBot = new CTECTwitter(this);
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
	
	//Method to check input for memes, length, and content
	public String useChatbotCheckers(String input)
	{
		String answer = "";
		
		if(!stupidBot.quitChecker(input))
		{
			if(stupidBot.contentChecker(input))
			{
				answer += "\nYou know my special secret\n";
			}
			if(stupidBot.memeChecker(input))
			{
				answer += "\nI can has memes?\n";
			}
			if(!stupidBot.lengthChecker(answer))
			{
				answer += "Sorry, I don't know about " + input;
			}
			
			int canBeRandom = (int) (Math.random() * 7);
			if (canBeRandom % 7 == 0)
			{
				answer += randomTopicGenerator();
			}
		}
		else
		{
			chatView.displayMessage("Thank you for chatting with me :D");
			System.exit(0);
		}
		return answer;
	}

	//Will generate a random topic
	private String randomTopicGenerator()
	{
		String randomTopic = "";
		int random = (int) (Math.random() * 7);
		
		switch (random)
		{
		case 0:
			randomTopic = "Did you hear about the daft punk beastie boys mix?";
			break;
		case 1:
			randomTopic = "Can you bring me sriracha?";
			break;
			
		}
		return randomTopic;
	}
	
	public void useTwitter(String text)
	{
		tweetBot.sendTweet(text);
	}
	
	public void handleErrors(Exception currentException)
	{
		chatView.displayMessage("There has been an error. The next window will provide details");
		chatView.displayMessage(currentException.getMessage());
	}
	
}
