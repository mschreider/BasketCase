package edu.udel.mattsch.BasketCase;

public class Apple extends Fruit {
	public Apple() {
		super(5, true);
	}
	public Apple(Position position){
		super(position, 5, true);
	}
}
