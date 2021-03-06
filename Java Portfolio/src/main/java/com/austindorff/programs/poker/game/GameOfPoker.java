package com.austindorff.programs.poker.game;

import java.util.ArrayList;
import java.util.Scanner;

import com.austindorff.programs.poker.cards.Card;
import com.austindorff.programs.poker.cards.DeckOfCards;

public class GameOfPoker
{
	
	private int numberOfPlayers = 1;
	
	ArrayList<Card> deckOfCardsToBeUsed;
	ArrayList<Card> playerTempList;
	ArrayList<ArrayList<Card>> playersHand;
	
	
	public GameOfPoker(ArrayList<Card> deckOfCards)
	{
		deckOfCardsToBeUsed = deckOfCards;
		playersHand = new ArrayList<ArrayList<Card>>();
		Scanner scan = new Scanner(System.in);
		while ((numberOfPlayers < 2) || (numberOfPlayers > 10))
		{
			System.out.println("Welcome to the poker simulator." + "\n" + "Please enter the number of players (min of 2, max of 10)");
			numberOfPlayers = scan.nextInt();
		}
		for (int index = 0; index < numberOfPlayers; index++)
		{
			playersHand.add((new ArrayList<Card>()));
		}
		deal();
	}

	public void showCards()
	{
		for (int index = 0; index < numberOfPlayers; index++)
		{
			System.out.println("Player " + (index + 1) + "'s Hand");
//			System.out.println("\t" + "Sorted by Suit:");
//			DeckOfCards.printHand(DeckOfCards.orderHandBySuit(playersHand.get(index)));
			System.out.println("\t" + "Sorted by Number/Type:");
			DeckOfCards.printHand(DeckOfCards.orderHandByType(playersHand.get(index)));
		}
		
	}

	public void deal()
	{
		for (int index = 0; index < 5; index++)
		{
			for (int index2 = 0; index2 < numberOfPlayers; index2++)
			{
				playerTempList = playersHand.get(index2);
				playerTempList.add(deckOfCardsToBeUsed.get(0));
				deckOfCardsToBeUsed.remove(0);
			}
		}
	}
	
	public ArrayList<Card> getBetterHand()
	{
		int tempInt = 0;
		int lowestRank = 1000;
		int[] handRanks = new int[numberOfPlayers];
		for (int index = 0; index < numberOfPlayers; index++)
		{
			playerTempList = playersHand.get(index);
			handRanks[index] = DeckOfCards.rankHand(playerTempList);
		}
		for (int index = 0; index < handRanks.length; index++)
		{
			if (handRanks[index] < lowestRank)
			{
				tempInt = index;
				lowestRank = handRanks[index];
			}
		}
		System.out.println("Player " + (1 + tempInt) + " Won!");
		return playersHand.get(tempInt);
	}
}
