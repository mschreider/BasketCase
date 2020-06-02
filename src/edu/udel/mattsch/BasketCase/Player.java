package edu.udel.mattsch.BasketCase;


public class Player {
	public int lives;
	public Position position;
	public int direction;
	
	
	public Player(){
		this.lives = 3;
		this.position = new Position((BasketCaseGame.GAMEBOARD_WIDTH)/2,(BasketCaseGame.GAMEBOARD_HEIGHT)-1);
		this.direction = 0;
		
	}
	
	public Player(int lives, Position position, int direction){
		this.lives = lives;
		this.position = position;
		this.direction = direction;
		
	}
	
	public Position getPosition(){
		return position;
	}
	
	public int getDirection(){
		return direction;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	public void setDirection(int direction){
		this.direction = direction;
	}
	
	/*public void onTick() {
		this.getPosition().setX(this.getPosition().getX() + direction);
	}*/
}
