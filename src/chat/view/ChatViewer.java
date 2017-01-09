package chat.view;
import javax.swing.JOptionPane;

public class ChatViewer 
{
	//Will grab the response from the user
	public String collectResponse(String question)
	{
		String response = "";
		
		response = JOptionPane.showInputDialog(null, question);
		
		return response;
	}
	
	//Will grab the user choice
	public int collectUserOption(String question)
	{
		int response = 0;
		
		response = JOptionPane.showConfirmDialog(null, question);
		
		return response;
	}
	
	//Will show a message
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}
}
