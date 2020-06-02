package edu.udel.mattsch.BasketCase;


public class BasketCaseGameAction implements Action<BasketCaseGame>{
	public int direction;//direction will be -1, 0, or 1 and
	//while the game is continuing, the column number of the player's
	//position will change by the direction value.
	
	public BasketCaseGameAction(int direction){
		this.direction = direction;
		
	}
	
	//all moves are valid 
	public boolean isValid(BasketCaseGame game){
		if(game.player.position.getX() + direction < 0 || game.player.position.getX() + direction >= BasketCaseGame.GAMEBOARD_WIDTH){
			return false;
		}
		return true;
	}
	
	public void update(BasketCaseGame game){
		
		game.player.getPosition().setX(game.player.getPosition().getX() + direction);
	}
	
	public int getDirection(){
		return direction;
	}
	
	public String toString(){
		if(direction == -1){
			return "Moves Left";
		}
		if(direction == 0){
			return "Is Stationary";
		}
		if(direction == 1){
			return "Moves Right";
		}
		return null;
	}
	
	public boolean equals(Object other){
		if(this.direction == ((BasketCaseGameAction)other).direction){
			return true;
		}
		else{
			return false;
		}
	}
}
