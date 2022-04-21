/**
 * 
 */
package application.model;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * This class enables the creation of an ObjectiveCard which extends the card
 * card class with the exception of three new fields: int goal, int progress,
 * and String stat.
 * 
 * @author Colby Bailey, Ahmet Bilici, Jack Huerta, Hezron Perez, Antonio
 *         Valenciana
 */
public class ObjectiveCard extends Card {

	private int goal;
	private int progress;
	private String stat;

	/**
	 * @param n
	 * @param d
	 * @param p
	 * @param s
	 * @param c
	 */
	public ObjectiveCard(String n, String d, Image p, String s, Color c, int goal, String stat) {
		super(n, d, p, s, c);
		this.setDescription("RP " + Integer.valueOf(d));
		this.setGoal(goal);
		this.setProgress(0); // Sets progress to 0
		this.setStat(stat);
	}

	/**
	 * @return the goal
	 */
	private int getGoal() {
		return goal;
	}

	/**
	 * @param goal the goal to set
	 */
	private void setGoal(int goal) {
		this.goal = goal;
	}

	/**
	 * @return the progress
	 */
	private int getProgress() {
		return progress;
	}

	/**
	 * @param progress the progress to set
	 */
	private void setProgress(int progress) {
		this.progress = progress;
	}

	/**
	 * @return the stat
	 */
	private String getStat() {
		return stat;
	}

	/**
	 * @param stat the stat to set
	 */
	private void setStat(String stat) {
		this.stat = stat;
	}
	
	/** 
	 * @param cardDesc 
	 * This method parses a card description and increases/decreases if this.stat is in the description
	 * */
	public void updateProgress(String cardDesc) {
		
		String parseArray[] = cardDesc.split("&");
        
        for(String parse: parseArray){
            String space[] = parse.split(" ");
            
            if(stat.equalsIgnoreCase(space[0])){
            	if(stat.equalsIgnoreCase("rp")) {
            		if(!(space[0].startsWith("-"))) {
            			progress += Integer.valueOf(space[1]);
            		}
            	} else {
            		progress += Integer.valueOf(space[1]);
            	}
                
            }
            if(stat.equalsIgnoreCase("xp")) {
            	progress += Integer.valueOf(space[1]);
            }
        }
		
	}

}
