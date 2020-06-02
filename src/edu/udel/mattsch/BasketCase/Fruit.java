package edu.udel.mattsch.BasketCase;

public class Fruit {
	public Position position;
	public int value;
	public boolean legal;
	public boolean inPlay;
	
	public Fruit(int value, boolean legal){
		super();
		this.position = new Position(((int)(Math.random()*BasketCaseGame.GAMEBOARD_WIDTH)), 0);
		this.value = value;
		this.legal = legal;
		this.inPlay = false;
	}
	
	public Fruit(Position position, int value, boolean legal){
		super();
		this.position = position;
		this.value = value;
		this.legal = legal;
		this.inPlay = false;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isLegal() {
		return legal;
	}
	
	public boolean isinPlay(){
		return inPlay;
	}

	public void setLegal(boolean legal) {
		this.legal = legal;
	}
	
	public void setinPlay(boolean inPlay){
		this.inPlay = inPlay;
	}
	
	public void onTick(BasketCaseGame game) {
		
		if(this.getPosition().blockDistance(game.getPlayer().getPosition()) == 0){
			if (this.legal) {
				game.score(this.getValue());
				this.setinPlay(false);
				this.setPosition(new Position((int) (Math.random()*BasketCaseGame.GAMEBOARD_WIDTH),0));
			}
			else {
				game.score(this.getValue()*-1);
				this.setinPlay(false);
				this.setPosition(new Position((int) (Math.random()*BasketCaseGame.GAMEBOARD_WIDTH),0));
			}
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
