package chat.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chat.controller.ChatbotController;
import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class CTECTwitter 
{
	private ChatbotController baseController;
	private Twitter twitterBot;
	private List<Status> searchedTweets;
	private List<String> ignoredWords;
	private List<String> tweetedWords;
	
	
	public CTECTwitter(ChatbotController baseController)
	{
		this.baseController = baseController;
		searchedTweets = new ArrayList<Status>();
		ignoredWords = new ArrayList<String>();
		tweetedWords = new ArrayList<String>();
		twitterBot = TwitterFactory.getSingleton();
	}
	
	public void sendTweet(String textToTweet)
	{
		try
		{
			twitterBot.updateStatus("I Joseph just tweeted from my Java Chatbot program 2017! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen! @ChatbotCTEC");
		}
		catch(TwitterException tweetError)
		{
			baseController.handleErrors(tweetError);
		}
		catch(Exception otherError)
		{
			baseController.handleErrors(otherError);
		}
	}

	private String[] createIgnoredWordList()
	{
		String [] boringWords;
		
		int wordCount = 0;
		Scanner wordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		
		while(wordScanner.hasNextLine())
		{
			wordScanner.nextLine();
			wordCount++;
		}
		boringWords = new String [wordCount];
		wordScanner.close();
		
		wordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		for(int index = 0; index < boringWords.length; index++)
		{
			boringWords[index] = wordScanner.nextLine();
		}
		
		wordScanner.close();
		return boringWords;
	}
	
	private void collectTweets(String username)
	{
		
	}
	
	
	
	private void turnStatusesToWords()
	{
		for(Status currentStatus : searchedTweets)
		{
			String tweetText = currentStatus.getText();
			String [] tweetWords = tweetText.split(" ");
			for(int index = 0; index < tweetWords.length; index++)
			{
				tweetedWords.add(tweetWords[index]);
			}
		}
	}
	
	private void removeAllBoringWords()
	{
		String [] boringWords = createIgnoredWordList();
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			for(int boringIndex = 0; boringIndex < boringWords.length; boringIndex++)
			{
				if(tweetedWords.get(index).equalsIgnoreCase(boringWords[boringIndex]))
				{
					tweetedWords.remove(index);
					index--;
					boringIndex = boringWords.length;
				}
			}
		}
	}
	
	private void removeEmptyText()
	{
		for(int index = tweetedWords.size() - 1; index >= 0; index--)
		{
			if(tweetedWords.get(index).trim().equals(""))
			{
				tweetedWords.remove(index);
			}
		}
	}
	
	private String calculatePopularWordAndCount()
	{
		String information = "";
		String mostPopular = "";
		int popularIndex = -1;
		int popularCount = 0;
		
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			int currentPopularity = 0;
			for(int searched = index + 1; searched < tweetedWords.size(); searched++)
			{
				if(tweetedWords.get(index).equalsIgnoreCase(tweetedWords.get(searched)) && !tweetedWords.get(index).equals(mostPopular))
				{
					currentPopularity++;
				}
			}
			if(currentPopularity > popularCount)
			{
				popularIndex = index;
				popularCount = currentPopularity;
				mostPopular = tweetedWords.get(index);
			}
		}
		information = " the most popular word is: " + mostPopular + ", and it occured " + popularCount + " times out of " + tweetedWords.size() + ", AKA " + (DecimalFormat.getPercentInstance().format(((double) popularCount)/tweetedWords.size()));
		return information;
	}
	
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!:;\"(){}[]^<>-";
		
		String scrubbedString = "";
		for(int i = 0; i < currentString.length(); i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}

	public String getMostPopularWord(String username)
	{
		collectTweets(username);
		turnStatusesToWords();
		removeAllBoringWords();
		removeEmptyText();
		
		String information = "The tweet count is " + searchedTweets.size() + " and " + username + "'s " + calculatePopularWordAndCount();
		return information;
	}
	
	public String restarauntInvestigation()
	{
		String results = "";
		
		Query query = new Query("restaraunts");
		query.setCount(100);
		query.setGeoCode(new GeoLocation(40.587521, -111.869178), 5, Query.KILOMETERS);
		query.setSince("2016-1-1");
		try
		{
			QueryResult result = twitterBot.search(query);
			results += "Count : " + result.getTweets().size() + "\n";
			for(Status tweet : result.getTweets())
			{
				results += "@" + tweet.getUser().getName() + ": " + tweet.getText() + "\n";
			}
		}
		catch(TwitterException error)
		{
			error.printStackTrace();
		}
		return results;
	}

	
}

