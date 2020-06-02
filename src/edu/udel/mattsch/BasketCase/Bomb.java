package edu.udel.mattsch.BasketCase;

public class Bomb extends Enemy {
	public Bomb() {
		super(0, -3);
	}
	public Bomb(Position position){
		super(position, 0, -3);
	}
}
