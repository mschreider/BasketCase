package edu.udel.mattsch.BasketCase;


public class Enemy {
	public Position position;
	public int pointValue;
	public int lifeValue;
	public boolean inPlay;
	
	public Enemy(int pointValue, int lifeValue) {
		super();
		this.pointValue = pointValue;
		this.lifeValue = lifeValue;
		this.position = new Position(((int)(Math.random()*BasketCaseGame.GAMEBOARD_WIDTH)), 0);
		this.inPlay = false;
	}
	
	public Enemy(Position position, int pointValue, int lifeValue){
		super();
		this.position = position;
		this.pointValue = pointValue;
		this.lifeValue = lifeValue;
		this.inPlay = false;
	}
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getPointValue() {
		return pointValue;
	}

	public void setPointValue(int pointValue) {
		this.pointValue = pointValue;
	}

	public int getLifeValue() {
		return lifeValue;
	}

	public void setLifeValue(int lifeValue) {
		this.lifeValue = lifeValue;
	}
	
	public void setinPlay(boolean inPlay){
		this.inPlay = inPlay;
	}
	
	public boolean isinPlay(){
		return inPlay;
	}

	public void onTick(BasketCaseGame game) {
		if(this.getPosition().blockDistance(game.getPlayer().getPosition()) == 0){
			game.score(this.getPointValue());
			game.setLives(game.getLives() + this.getLifeValue());
			this.setinPlay(false);
			this.setPosition(new Position((int) (Math.random()*BasketCaseGame.GAMEBOARD_WIDTH),0));
		}
		if(this.inPlay = true){	
			this.getPosition().setY(this.getPosition().getY() + 1);
		}	
		
		if(this.getPosition().getY() == BasketCaseGame.GAMEBOARD_HEIGHT) {
			this.setinPlay(false);
			this.setPosition(new Position((int) (Math.random()*BasketCaseGame.GAMEBOARD_WIDTH),0));
		}
	}
}
