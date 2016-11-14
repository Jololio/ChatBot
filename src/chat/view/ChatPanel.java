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
	
	
	
	
	public ChatPanel(ChatbotController baseController)
	{
		super();
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatDisplay = new JTextArea(5, 25);
		chatField = new JTextField(25);
		chatButton = new JButton("Chat with the bot");
		
		
		setupLayout();
		setupChatDisplay();
		setupPanel();
		setupListeners();
	}
	
	private void setupChatDisplay()
	{
		chatDisplay.setEditable(false);
		chatDisplay.setEnabled(false);
		chatDisplay.setLineWrap(true);
		chatDisplay.setWrapStyleWord(true);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		this.add(chatDisplay);
		this.add(chatField);
		this.add(chatButton);
	}
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 6, SpringLayout.SOUTH, chatField);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, -148, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatDisplay, -38, SpringLayout.NORTH, chatField);
		baseLayout.putConstraint(SpringLayout.EAST, chatDisplay, 0, SpringLayout.EAST, chatField);
		baseLayout.putConstraint(SpringLayout.NORTH, chatField, 198, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 73, SpringLayout.WEST, this);
	}
	private void setupListeners()
	{
		
	}
}