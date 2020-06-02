package edu.udel.mattsch.BasketCase;

public class Orange extends Fruit{
	public Orange() {
		super(5, true);
	}
	public Orange(Position position){
		super(position, 5, true);
	}
}
