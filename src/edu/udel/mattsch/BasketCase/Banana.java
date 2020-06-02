package edu.udel.mattsch.BasketCase;

public class Banana extends Fruit {
	public Banana() {
		super(3, true);
	}
	public Banana(Position position){
		super(position, 3, true);
	}
}
