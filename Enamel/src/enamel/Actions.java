package enamel;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({ "unlikely-arg-type", "unused" })
/**
 * 
 * @author Nisha Class for different actions added to buttons in scenario
 *
 */
public class Actions {
	/*
	 * Private fields
	 */
	private ArrayList<Card> actionsList;
	private Map<Integer, Card> actionsMap;

	/**
	 * Constructor Creates an empty list or hash map of actions
	 */
	public Actions() {
		this.actionsList = new ArrayList<>();// new ArrayList<Action>();
		this.actionsMap = new HashMap<>();// new HashMap<Integer, Action>();
	}

	/**
	 * 
	 * @param a
	 *            object of type Card
	 * @param i
	 *            object of type Integer
	 */
	public Actions(Card a, Integer i) {
		actionsList.add(i, a);
		actionsMap.put(i, a);
	}

	/**
	 * Method to rearrange list of actions
	 * 
	 * @param a
	 *            Card on which list will be rearranged
	 * @param currKey
	 *            current index of the card
	 * @param newKey
	 *            new index of the card
	 */
	public void rearrange(Card a, int currKey, int newKey) {
		if (this.actionsMap.get(currKey) == a) {// check if the action exists at
												// location
			if (this.actionsMap.containsKey(newKey)) { // check if new index has
														// a value
				Card currAct = actionsMap.get(newKey);// if object at new index
														// keep a copy
				this.actionsMap.remove(currKey, a);
				this.actionsMap.put(newKey, a);
			}

		}
	}

	/**
	 * Method to add a new action
	 * 
	 * @param i
	 *            Index id of action to be added
	 * @param a
	 *            Card
	 */
	public void addAction(Integer i, Card a) {
		this.actionsMap.put(i, a);
	}

	/**
	 * Method to delete an action
	 * 
	 * @param i
	 *            index id of the action to be deleted
	 */
	public void deleteAction(Integer i) {
		this.actionsMap.remove(i);
	}

	/**
	 * Method to delete an Card Action
	 * 
	 * @param a
	 *            Card
	 */
	public void deleteAction(Card a) {
		this.actionsMap.remove(this.actionsMap.get(a));
	}
}
