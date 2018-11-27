package eecs2030.lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.List;

/**
 * A class representing a piggy bank that has an owner. A piggy bank owns a
 * collection (or possibly collections) of coins, but does not own the coins
 * themselves. In other words, the piggy bank and its collection of coins form a
 * composition.
 * 
 * <p>
 * Only the owner of the piggy bank is able to remove coins from the piggy bank.
 * The piggy bank does NOT (later modification) own its owner. In other words,
 * the piggy bank and its owner form an aggregation.
 */
public class OwnedPiggyBank {
	
	//Just testing out boxing and unboxing of the elements 
	//(unrelated to the lab)
	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(42);
		int answer = l.get(0);
		System.out.print(answer);
	}
	
	/*
	 * YOU NEED A FIELD HERE TO HOLD THE COINS OF THIS PIGGY BANK
	 */
	private List<Coin> list;

	/**
	 * The owner of this piggy bank.
	 */
	private Owner owner;

	/**
	 * Initializes this piggy bank so that it has the specified owner and its
	 * collection of coins is empty.
	 * 
	 * @param owner
	 *            the owner of this piggy bank
	 */
	public OwnedPiggyBank(Owner owner) {
		this.owner = owner;
		list = new ArrayList<Coin>();
	}

	/**
	 * Initializes this piggy bank by copying another piggy bank. This piggy bank
	 * will have the same owner and the same number and type of coins as the other
	 * piggy bank.
	 * 
	 * @param other
	 *            the piggy bank to copy
	 */
	public OwnedPiggyBank(OwnedPiggyBank other) {
		this.owner = other.getOwner();
		this.list = new ArrayList<Coin>(other.list);

	}

	/**
	 * Returns the owner of this piggy bank.
	 * 
	 * <p>
	 * This method is present only for testing purposes. Returning the owner of this
	 * piggy bank allows any user to remove coins from the piggy bank (because any
	 * user can get the owner of this piggy bank)!
	 * 
	 * @return the owner of this piggy bank
	 */
	public Owner getOwner() {
		// ALREADY IMPLEMENTED; DO NOT MODIFY
		return this.owner;
	}

	/**
	 * Allows the current owner of this piggy bank to give this piggy bank to a new
	 * owner.
	 * 
	 * @param currentOwner
	 *            the current owner of this piggy bank
	 * @param newOwner
	 *            the new owner of this piggy bank
	 * @throws IllegalArgumentException
	 *             if currentOwner is not the current owner of this piggy bank
	 */
	public void changeOwner(Owner currentOwner, Owner newOwner) {
		if (!currentOwner.equals(this.owner))
			throw new IllegalArgumentException("Current owner is not the actual owner of this piggybank!");

		this.owner = newOwner;

	}

	/**
	 * Adds the specified coins to this piggy bank.
	 * 
	 * @param coins
	 *            a list of coins to add to this piggy bank
	 */
	public void add(List<Coin> coins) {
		for (Coin c : coins) {
			this.list.add(c);
		}
	}

	/**
	 * Returns true if this piggy bank contains the specified coin, and false
	 * otherwise.
	 * 
	 * @param coin
	 *            a coin
	 * @return true if this piggy bank contains the specified coin, and false
	 *         otherwise
	 */
	public boolean contains(Coin coin) {
		boolean found = false;
		int i = 0;
		while (found != true && i < list.size()) {
			if (list.get(i).equals(coin))
				found = true;
			i++;
		}
		return found;

	}

	/**
	 * Allows the owner of this piggy bank to remove a coin equal to the value of
	 * the specified coin from this piggy bank.
	 * 
	 * <p>
	 * If the specified user is not equal to the owner of this piggy bank, then the
	 * coin is not removed from this piggy bank, and null is returned.
	 * 
	 * @param user
	 *            the person trying to remove the coin
	 * @param coin
	 *            a coin
	 * @return a coin equal to the value of the specified coin from this piggy bank,
	 *         or null if user is not the owner of this piggy bank @pre. the piggy
	 *         bank contains a coin equal to the specified coin
	 */
	public Coin remove(Owner user, Coin coin) {
		Coin c = null;
		boolean removed = false;

		if (this.owner.equals(user) && this.contains(coin)) {
			removed = list.remove(coin);
		}
		if (removed)
			c = new Coin(coin);

		return c;

	}

	/**
	 * Allows the owner of this piggy bank to remove the smallest number of coins
	 * whose total value in cents is equal to the specified value in cents from this
	 * piggy bank.
	 * 
	 * <p>
	 * Returns the empty list if the specified user is not equal to the owner of
	 * this piggy bank.
	 * 
	 * @param user
	 *            the person trying to remove coins from this piggy bank
	 * @param value
	 *            a value in cents
	 * @return the smallest number of coins whose total value in cents is equal to
	 *         the specified value in cents from this piggy bank @pre. the piggy
	 *         bank contains a group of coins whose total value is equal to
	 *         specified value
	 */
	public List<Coin> removeCoins(Owner user, int value) {
		List<Coin> result = new ArrayList<Coin>();

		if (this.owner.equals(user)) {
			Coin[] coinArray = new Coin[list.size()];
			coinArray = deepCopy().toArray(coinArray);
			int counter = coinArray.length - 1;
			while (counter >= 0 && value >= 0) {
				int coinVal = coinArray[counter].getValue();
				if (value / coinVal > 0) {
					result.add(coinArray[counter]);
					value -= coinVal;
				}
				counter--;
			}
		}

		return result;
	}

	/**
	 * Returns a deep copy of the coins in this piggy bank. The returned list has
	 * its coins in sorted order (from smallest value to largest value; i.e.,
	 * pennies first, followed by nickels, dimes, quarters, loonies, and toonies).
	 * 
	 * @return a deep copy of the coins in this piggy bank
	 */
	public List<Coin> deepCopy() {
		List<Coin> copy = new ArrayList<Coin>();
		/*
		 * an array that would store the counts of all the different types of coins in
		 * the list for eg: coinsCount[0] is for storing pennies, coinsCount[1] is for
		 * nickels, coinsCount[2] is for dimes,... coinsCount[5] is for storing toonies
		 */
		int[] coinsCount = new int[6];

		for (Coin c : list) {
			switch (c.getValue()) {
			case 1:
				coinsCount[0]++;
				break;
			case 5:
				coinsCount[1]++;
				break;
			case 10:
				coinsCount[2]++;
				break;
			case 25:
				coinsCount[3]++;
				break;
			case 100:
				coinsCount[4]++;
				break;
			case 200:
				coinsCount[5]++;
				break;
			}
		}

		for (int i = 0; i < coinsCount.length; i++) {
			for (int j = 0; j < coinsCount[i]; j++) {
				switch (i) {
				case 0:
					copy.add(new Coin(Coin.PENNY));
					break;
				case 1:
					copy.add(new Coin(Coin.NICKEL));
					break;
				case 2:
					copy.add(new Coin(Coin.DIME));
					break;
				case 3:
					copy.add(new Coin(Coin.QUARTER));
					break;
				case 4:
					copy.add(new Coin(Coin.LOONIE));
					break;
				case 5:
					copy.add(new Coin(Coin.TOONIE));
					break;
				}
			}
		}

		return copy;

	}
}
