package enamel;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Nisha
 * Class for different actions added to scenario
 *
 */
public class Actions {
	private ArrayList<Card> actionsList;
	private Map<Integer, Card> actionsMap;
	/*
	 * Constructor
	 * Creates an empty list or hash map of actions 
	 */
	public Actions(){
		this.actionsList = new ArrayList<>();//new ArrayList<Action>();
		this.actionsMap = new HashMap<>();//new HashMap<Integer, Action>();
	}
	
	public Actions(Card a, Integer i){
		actionsList.add(i, a);
		actionsMap.put(i, a);
	}
	
	/*
	 * Method to rearrange list of actions
	 */
	public void rearrange(Card a, int currKey, int newKey){
		if(this.actionsMap.get(currKey) == a){// check if the action exists at location
		if(this.actionsMap.containsKey(newKey)){ //check if new index has a value
			Card currAct = actionsMap.get(newKey);//if object at new index keep a copy
			this.actionsMap.remove(currKey, a);
			this.actionsMap.put(newKey,a);
		}
		
		}
	}
	
	/*
	 * Method to add a new action
	 */
	public void addAction(Integer i, Card a){
		this.actionsMap.put(i, a);
	}
	
	/*
	 * Method to delete an action
	 */
	public void deleteAction(Integer i){
		this.actionsMap.remove(i);
	}
	/*
	 * Method to delete an action
	 */
	public void deleteAction(Card a){
		this.actionsMap.remove(this.actionsMap.get(a));
	}
}
