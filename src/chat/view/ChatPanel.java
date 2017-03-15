package chat.view;

import chat.controller.ChatbotController;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatPanel extends JPanel
{
	private ChatbotController baseController;
	private SpringLayout baseLayout;
	private JTextArea chatDisplay;
	private JTextField chatField;
	private JButton chatButton;
	private JButton sendTweetButton;
	private JButton saveButton;
	private JButton loadButton;
	
	
	
	public ChatPanel(ChatbotController baseController)
	{
		super();
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatDisplay = new JTextArea(5, 25);
		chatField = new JTextField(25);
		chatButton = new JButton("Chat with the bot");
		sendTweetButton = new JButton("");
		saveButton = new JButton("save");
		loadButton = new JButton("load");
		
		
		setupLayout();
		setupChatDisplay();
		setupPanel();
		setupListeners();
	}
	
	//Sets up the display
	private void setupChatDisplay()
	{
		chatDisplay.setEditable(false);
		chatDisplay.setEnabled(false);
		chatDisplay.setLineWrap(true);
		chatDisplay.setWrapStyleWord(true);
	}
	
	//Adds the components of the program to the screen
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		this.add(chatDisplay);
		this.add(chatField);
		this.add(chatButton);
		this.add(sendTweetButton);
	}
	
	//Locations of the screen components
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 6, SpringLayout.SOUTH, chatField);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, -148, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatDisplay, -38, SpringLayout.NORTH, chatField);
		baseLayout.putConstraint(SpringLayout.EAST, chatDisplay, 0, SpringLayout.EAST, chatField);
		baseLayout.putConstraint(SpringLayout.NORTH, chatField, 198, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 73, SpringLayout.WEST, this);
	}
	//Listeners for actions
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userWords = chatField.getText();
				String botResponse = baseController.useChatbotCheckers(userWords);
				
				chatDisplay.setText("You said: " + userWords + "\n" + "Chatbot said: " + botResponse);
				chatField.setText("");
			}
		});
		sendTweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.useTwitter(chatField.getText());
			}
	
		});
		
		chatField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent enterPress)
			{
				scrollTextUp();
			}
			
		});
	}
	
	private void scrollTextUp()
	{
		String personWords = chatField.getText();
		String chatbotResponse = baseController.useChatbotCheckers(personWords);
		String currentText = chatDisplay.getText();
		
		chatDisplay.setText("You said: " + personWords + "\n" + "Chatbot says: " + chatbotResponse + "\n" + currentText);
		chatDisplay.setCaretPosition(0);
		
		chatField.setText("");
	}
	private void scrollTextDown()
	{
		String personWords = chatField.getText();
		String chatbotResponse = baseController.useChatbotCheckers(personWords);
		String oldText = chatDisplay.getText();
		
		chatDisplay.setText(oldText + "You said: " + personWords + "\n" + "Chatbot says: " + chatbotResponse);
		chatDisplay.setCaretPosition(chatDisplay.getCaretPosition());

		chatField.setText("");
	}
}
