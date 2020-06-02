package edu.udel.mattsch.BasketCase;

import java.util.ArrayList;

import junit.framework.TestCase;

public class BasketCaseTest extends TestCase{
	 public static BasketCaseGame createStartGame() {
		 BasketCaseGame game = new BasketCaseGame();   
		 return game;
	 }
	 
	 public static BasketCaseGame createEndGame() {
	     BasketCaseGame game = new BasketCaseGame(new Player(0, new Position(5,23), 0));
	     return game;
	 }
	    
	 public static BasketCaseGame createMidGame() {
		 BasketCaseGame midGame = createStartGame();
	     midGame.getPlayer().setLives(2);
	     midGame.score(50);
	     midGame.player.position.setX(midGame.player.position.getX() +1);
	     Fruit apple = new Apple();
	     Position position = new Position(2,22);
	     apple.setPosition(position);
	     midGame.unusedFruits.add(2,apple);
	     apple.setinPlay(true);
	     return midGame;
	 }
	 
	 public static BasketCaseGame createMidGame1() {
		 BasketCaseGame midGame = createStartGame();
	     midGame.player.lives += -1;
	     midGame.score(50);
	     midGame.player.position.setX(midGame.player.position.getX() +1);
	     Fruit apple = new Apple();
	     Position position = new Position(9,22);
	     apple.setPosition(position);
	     midGame.unusedFruits.add(50,apple);
	     apple.setinPlay(true);
	     return midGame;
	 }
	 
	 public void test_OnTick_scoring() {
		 BasketCaseGame game = createMidGame1();
		 game.onTick();
		 assertEquals(55, game.getScore());
		 
	 }
	 
	 public void test_OnTick() {
		 BasketCaseGame game = createMidGame();
		 game.onTick();
		 assertEquals(game.unusedFruits.get(2).getPosition(), new Position(2,23));
		 game.onTick();
		 assertEquals(0, (int) game.unusedFruits.get(2).getPosition().getY());
		 assertFalse(game.unusedFruits.get(2).isinPlay());
	 }
	 
	 public void test_AI_getAllValidActions() {
		 BasketCaseGame game = createMidGame();
		 BasketCaseGameAI ai = new BasketCaseGameAI(game);
		 ArrayList<Action<BasketCaseGame>> actions = (ArrayList<Action<BasketCaseGame>>) ai.getAllValidActions(game);
		 ArrayList<Action<BasketCaseGame>> actions1 = new ArrayList<Action<BasketCaseGame>>();
		 actions1.add(new BasketCaseGameAction(-1));
		 actions1.add(new BasketCaseGameAction(0));
		 actions1.add(new BasketCaseGameAction(1));
		 assertEquals(actions1, actions);
	 }
	 
	 
	 
	 
	 public static void main(String[] args) {
		 System.out.println(createStartGame());
		 System.out.println(createEndGame());
		 System.out.println(createMidGame());
		 
		 System.out.println(new BasketCaseGameAction(-1));
	     System.out.println(new BasketCaseGameAction(0));
	     System.out.println(new BasketCaseGameAction(1));
	 }
	 
	 
}
