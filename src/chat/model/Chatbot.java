package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part * of the project. * 
 * @author Joseph AlAbudi 
 * @version 1.0 10/15/16
 */
public class Chatbot {
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	private String mashing;

	/**
	 * * Creates an instance of the Chatbot with the supplied username. * @param
	 * userName The username for the chatbot.
	 */
	public Chatbot(String userName) 
	{
		this.politicalTopicList = new ArrayList<String>();
		this.memesList = new ArrayList<String>();
		this.userName = new String(userName);
		this.content = new String("My Lord and Savior, Jesus Christ");
		this.buildMemesList();
		buildPoliticalTopicsList();
	}

	private void buildMemesList() 
	{
		
		memesList.add("doge");
		memesList.add("cute animals");
		memesList.add("grumpy cat");
		memesList.add("dat boi");
		memesList.add("willy wonka");
		memesList.add("harambe");
		memesList.add("john cena");
		memesList.add("Lord of the Rings");
		memesList.add("damn daniel");
		memesList.add("yo dawg");
		memesList.add("y u no");
		memesList.add("rick harrison");
		memesList.add("puppy monkey baby");
		memesList.add("just a prank bro");
		memesList.add("karate kyle");
		memesList.add("sloth");
		memesList.add("crazy girlfriend");
		memesList.add("inception");
		memesList.add("Arthur fist");
		
	
		
	}

	private void buildPoliticalTopicsList() 
	{
		
		politicalTopicList.add("election");
		politicalTopicList.add("Democrat");
		politicalTopicList.add("Republican");
		politicalTopicList.add("liberal");
		politicalTopicList.add("conservative");
		politicalTopicList.add("Clinton");
		politicalTopicList.add("Trump");
		politicalTopicList.add("Kaine");
		politicalTopicList.add("Pence");
		politicalTopicList.add("11/8/16");
		politicalTopicList.add("Stein");
		politicalTopicList.add("Johnson");
		politicalTopicList.add("Immigration");
		politicalTopicList.add("Equality");
		politicalTopicList.add("Military");
		politicalTopicList.add("Middle East");
		politicalTopicList.add("debate");
		politicalTopicList.add("campaign");
		politicalTopicList.add("3rd Party");
		politicalTopicList.add("McMullin");
		politicalTopicList.add("Hillary");
		
	}

	public boolean quitChecker(String userInput)
	{
		
	}
	
	
	
	
	/**
	 * * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true. * @param currentInput * @return
	 * A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput) 
	{
		boolean hasLength = false;
		
		if (currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}
		
		return hasLength;
		
	}

	/**
	 * * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether it
	 *            matches the content area.
	 */
	public boolean contentChecker(String currentInput) 
	{
		boolean hasContent = false;
		
		if(currentInput.contains(content))
		{
			hasContent = true;
		}
		
		
		return hasContent;
	}

	/**
	 * * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput) 
	{
		boolean hasPolitics = false;
		
		for(String political: politicalTopicList)
		{
			if(currentInput.contains(political))
			{
				hasPolitics = true;
			}
		}
		
		return hasPolitics;
	}

	/**
	 * * Checks to see that the supplied String value is in the current
	 * memesList variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput) 
	{
		boolean hasMemes = false;
		
		for(String meme: memesList)
		{
			if(currentInput.toLowerCase().contains(meme.toLowerCase()))
			{
				hasMemes = true;
			}
		}
		
		
		
		return hasMemes;
	}

	public boolean keyboardMashChecker(String mashing)
	{
		boolean hasKeyboardMash = false;
		if(mashing.contains(mashing))
		{
			hasKeyboardMash = true;
		}
		
		
		return hasKeyboardMash;
		
	}
	
	/**
	 * * Returns the username of this Chatbot instance. * @return The username
	 * of the Chatbot.
	 */
	public String getKeyboardMashing()
	{
		return mashing;
	}
	
	public String getUserName() 
	{
		return userName;
	}

	/**
	 * * Returns the content area for this Chatbot instance. * @return The
	 * content area for this Chatbot instance.
	 */
	public String getContent() 
	{
		return content;
	}

	/**
	 * * Getter method for the memesList object. * @return The reference to the
	 * meme list.
	 */
	public ArrayList<String> getMemesList() 
	{
		return memesList;
	}

	/**
	 * * Getter method for the politicalTopicList object. * @return The
	 * reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList() 
	{
		return politicalTopicList;
	}

	/**
	 * * Updates the content area for this Chatbot instance. * @param content
	 * The updated value for the content area.
	 */
	public void setMashing(String mashing)
	{
		this.mashing = mashing;
	}
	
	public void setContent(String content) 
	{
		this.content = content;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public void setPoliticalTopicList (ArrayList<String> politicalTopicList)
	{
		this.politicalTopicList = politicalTopicList;
	}
	
	
}
