package edu.udel.mattsch.BasketCase;

public class Rock extends Enemy {
	public Rock() {
		super( -25, 0);
	}
	public Rock(Position position){
		super(position, -25, 0);
	}
}