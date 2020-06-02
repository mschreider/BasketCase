package edu.udel.mattsch.BasketCase;

import java.util.ArrayList;  
import java.util.List;



/**
 * Player AI uses a basic heuristic that avoids death and otherwise
 * tries to go towards the food.
 * 
 * @author jatlas
 */
public class BasketCaseGameAI extends AI<BasketCaseGame> {
    // Player is single-player, so the AI's identity does not matter 
    public BasketCaseGameAI(BasketCaseGame game) {
        super(game, "AI"); 
    }
    
    /**
     * Returns a list of all valid moves from a given state.
     * 
     * @param state
     * @return
     */
    public List<Action<BasketCaseGame>> getAllValidActions(BasketCaseGame game) {
        List<Action<BasketCaseGame>> validMoves = new ArrayList<Action<BasketCaseGame>>();
        if (!game.isEnd() && new BasketCaseGameAction(-1).isValid(game)) {
          validMoves.add(new BasketCaseGameAction(-1));
        }  
        if (!game.isEnd() && new BasketCaseGameAction(0).isValid(game)) {  
          validMoves.add(new BasketCaseGameAction(0));
        }
        if(!game.isEnd() && new BasketCaseGameAction(1).isValid(game)) {  
          validMoves.add(new BasketCaseGameAction(1));
        }
        return validMoves;
    }

    
    /**
     * @param state
     * @return
     */
    public double getHeuristicScore(Action<BasketCaseGame> action, BasketCaseGame game) {
    	double score = 0;
    	if (((BasketCaseGameAction)action).isValid(game)){
    		for(Fruit fruit : game.unusedFruits){
    			if (fruit.isinPlay()){
    				if(Math.abs(fruit.getPosition().getX() - (game.player.getPosition().getX() + 
    						((BasketCaseGameAction)action).getDirection())) <= 1 && fruit.getPosition().getY() == BasketCaseGame.GAMEBOARD_HEIGHT - 2){
    							score += 100;
    				}
    			}
    		}
    		for(Enemy enemy : game.unusedEnemies){
    			if (enemy.isinPlay()){
    				if(Math.abs(enemy.getPosition().getX() - (game.player.getPosition().getX() + 
    						((BasketCaseGameAction)action).getDirection())) <= 1 && enemy.getPosition().getY() == BasketCaseGame.GAMEBOARD_HEIGHT - 2){
    							score -= 100;
    				}
    			}
    		}
    	}	
    	return score;
    	
    }
}
