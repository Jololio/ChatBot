package chat.view;

import javax.swing.JFrame;
import chat.controller.ChatbotController;
import java.awt.Dimension;



public class ChatFrame extends JFrame
{
	private ChatbotController baseController;
	private ChatPanel basePanel;
	
	public ChatFrame(ChatbotController baseController)
	{
		super();
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		
		setupFrame();
	}
	
	//Sets the parameters for the frame
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setTitle("Chat Bot");
		this.setSize(new Dimension(600, 400));
		this.setResizable(false);
		this.setVisible(true);
	}
	
	
}
