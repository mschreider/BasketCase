//Matthew Schreider & Joshua Culver
package edu.udel.mattsch.BasketCase;

import java.util.ArrayList;
import java.util.List;

import android.widget.Toast;




public class BasketCaseGame extends Game implements Tickable{
	public Player player;
	public int lives;
	public ArrayList<Fruit> inplayFruits;
	public ArrayList<Enemy> inplayEnemies;
	public int counter;
	public int counter2;
	public ArrayList<Fruit> unusedFruits;
	public ArrayList<Enemy> unusedEnemies;
	public int score;
	public static final int GAMEBOARD_HEIGHT = 18; //hypothetical value
	public static final int GAMEBOARD_WIDTH = 12; //hypothetical value

	@Override 
	public boolean isEnd() {
		if (lives <= 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public int getScore(){
		return score;
	}
	
	public int getLives(){
		return lives;
	}
	
	public void setLives(int life){
		this.lives = life;
	}
	public String toString(){
		return "Score:" + score + "\n" + "Lives:"
	+ getLives() + "\n" + "Position:" + player.position
	;

	}
	
	public void score(int points){
		score += points;
	}
	
	public BasketCaseGame() {
		Player player = new Player();
		this.player = player;
		this.unusedFruits = fillWithFruit(new ArrayList<Fruit>());
		this.unusedEnemies = fillWithEnemy(new ArrayList<Enemy>());
		this.counter = 0;
		this.counter2 = 0;
		this.lives = 3;
		this.score = 0;
	}
	
	public ArrayList<Fruit> fillWithFruit(ArrayList<Fruit> fruitlist){
		Apple apple1 = new Apple();
		fruitlist.add(apple1);
		Apple apple2 = new Apple();
		fruitlist.add(apple2);
		Apple apple3 = new Apple();
		fruitlist.add(apple3);
		Apple apple4 = new Apple();
		fruitlist.add(apple4);
		Apple apple5 = new Apple();
		fruitlist.add(apple5);
		Apple apple6 = new Apple();
		fruitlist.add(apple6);
		Apple apple7 = new Apple();
		fruitlist.add(apple7);
		Apple apple8 = new Apple();
		fruitlist.add(apple8);
		Apple apple9 = new Apple();
		fruitlist.add(apple9);
		Apple apple10 = new Apple();
		fruitlist.add(apple10);
		Apple apple11 = new Apple();
		fruitlist.add(apple11);
		Apple apple12 = new Apple();
		fruitlist.add(apple12);
		Apple apple13 = new Apple();
		fruitlist.add(apple13);
		Apple apple14 = new Apple();
		fruitlist.add(apple14);
		Apple apple15 = new Apple();
		fruitlist.add(apple15);
		Apple apple16 = new Apple();
		fruitlist.add(apple16);
		Apple apple17 = new Apple();
		fruitlist.add(apple17);
		Apple apple18 = new Apple();
		fruitlist.add(apple18);
		Apple apple19 = new Apple();
		fruitlist.add(apple19);
		Apple apple20 = new Apple();
		fruitlist.add(apple20);
		Banana banana1 = new Banana();
		fruitlist.add(banana1);
		Banana banana2 = new Banana();
		fruitlist.add(banana2);
		Banana banana3 = new Banana();
		fruitlist.add(banana3);
		Banana banana4 = new Banana();
		fruitlist.add(banana4);
		Banana banana5 = new Banana();
		fruitlist.add(banana5);
		Banana banana6 = new Banana();
		fruitlist.add(banana6);
		Banana banana7 = new Banana();
		fruitlist.add(banana7);
		Banana banana8 = new Banana();
		fruitlist.add(banana8);
		Banana banana9 = new Banana();
		fruitlist.add(banana9);
		Banana banana10 = new Banana();
		fruitlist.add(banana10);
		Banana banana11 = new Banana();
		fruitlist.add(banana11);
		Banana banana12 = new Banana();
		fruitlist.add(banana12);
		Banana banana13 = new Banana();
		fruitlist.add(banana13);
		Banana banana14 = new Banana();
		fruitlist.add(banana14);
		Banana banana15 = new Banana();
		fruitlist.add(banana15);
		Banana banana16 = new Banana();
		fruitlist.add(banana16);
		Banana banana17 = new Banana();
		fruitlist.add(banana17);
		Banana banana18 = new Banana();
		fruitlist.add(banana18);
		Banana banana19 = new Banana();
		fruitlist.add(banana19);
		Banana banana20 = new Banana();
		fruitlist.add(banana20);
		Orange orange1 = new Orange();
		fruitlist.add(orange1);
		Orange orange2 = new Orange();
		fruitlist.add(orange2);
		Orange orange3 = new Orange();
		fruitlist.add(orange3);
		Orange orange4 = new Orange();
		fruitlist.add(orange4);
		Orange orange5 = new Orange();
		fruitlist.add(orange5);
		Orange orange6 = new Orange();
		fruitlist.add(orange6);
		Orange orange7 = new Orange();
		fruitlist.add(orange7);
		Orange orange8 = new Orange();
		fruitlist.add(orange8);
		Orange orange9 = new Orange();
		fruitlist.add(orange9);
		Orange orange10 = new Orange();
		fruitlist.add(orange10);
		Orange orange11 = new Orange();
		fruitlist.add(orange11);
		Orange orange12 = new Orange();
		fruitlist.add(orange12);
		Orange orange13 = new Orange();
		fruitlist.add(orange13);
		Orange orange14 = new Orange();
		fruitlist.add(orange14);
		Orange orange15 = new Orange();
		fruitlist.add(orange15);
		Orange orange16 = new Orange();
		fruitlist.add(orange16);
		Orange orange17 = new Orange();
		fruitlist.add(orange17);
		Orange orange18 = new Orange();
		fruitlist.add(orange18);
		Orange orange19 = new Orange();
		fruitlist.add(orange19);
		Orange orange20 = new Orange();
		fruitlist.add(orange20);
		Strawberry strawberry1 = new Strawberry();
		fruitlist.add(strawberry1);
		Strawberry strawberry2 = new Strawberry();
		fruitlist.add(strawberry2);
		Strawberry strawberry3 = new Strawberry();
		fruitlist.add(strawberry3);
		Strawberry strawberry4 = new Strawberry();
		fruitlist.add(strawberry4);
		Strawberry strawberry5 = new Strawberry();
		fruitlist.add(strawberry5);
		Strawberry strawberry6 = new Strawberry();
		fruitlist.add(strawberry6);
		Strawberry strawberry7 = new Strawberry();
		fruitlist.add(strawberry7);
		Strawberry strawberry8 = new Strawberry();
		fruitlist.add(strawberry8);
		Strawberry strawberry9 = new Strawberry();
		fruitlist.add(strawberry9);
		Strawberry strawberry10 = new Strawberry();
		fruitlist.add(strawberry10);
		Strawberry strawberry11 = new Strawberry();
		fruitlist.add(strawberry11);
		Strawberry strawberry12 = new Strawberry();
		fruitlist.add(strawberry12);
		Strawberry strawberry13 = new Strawberry();
		fruitlist.add(strawberry13);
		Strawberry strawberry14 = new Strawberry();
		fruitlist.add(strawberry14);
		Strawberry strawberry15 = new Strawberry();
		fruitlist.add(strawberry15);
		Strawberry strawberry16 = new Strawberry();
		fruitlist.add(strawberry16);
		Strawberry strawberry17 = new Strawberry();
		fruitlist.add(strawberry17);
		Strawberry strawberry18 = new Strawberry();
		fruitlist.add(strawberry18);
		Strawberry strawberry19 = new Strawberry();
		fruitlist.add(strawberry19);
		Strawberry strawberry20 = new Strawberry();
		fruitlist.add(strawberry20);
		Watermelon watermelon1 = new Watermelon();
		fruitlist.add(watermelon1);
		Watermelon watermelon2 = new Watermelon();
		fruitlist.add(watermelon2);
		Watermelon watermelon3 = new Watermelon();
		fruitlist.add(watermelon3);
		Watermelon watermelon4 = new Watermelon();
		fruitlist.add(watermelon4);
		Watermelon watermelon5 = new Watermelon();
		fruitlist.add(watermelon5);
		Watermelon watermelon6 = new Watermelon();
		fruitlist.add(watermelon6);
		Watermelon watermelon7 = new Watermelon();
		fruitlist.add(watermelon7);
		Watermelon watermelon8 = new Watermelon();
		fruitlist.add(watermelon8);
		Watermelon watermelon9 = new Watermelon();
		fruitlist.add(watermelon9);
		Watermelon watermelon10 = new Watermelon();
		fruitlist.add(watermelon10);
		Watermelon watermelon11 = new Watermelon();
		fruitlist.add(watermelon11);
		Watermelon watermelon12 = new Watermelon();
		fruitlist.add(watermelon12);
		Watermelon watermelon13 = new Watermelon();
		fruitlist.add(watermelon13);
		Watermelon watermelon14 = new Watermelon();
		fruitlist.add(watermelon14);
		Watermelon watermelon15 = new Watermelon();
		fruitlist.add(watermelon15);
		Watermelon watermelon16 = new Watermelon();
		fruitlist.add(watermelon16);
		Watermelon watermelon17 = new Watermelon();
		fruitlist.add(watermelon17);
		Watermelon watermelon18 = new Watermelon();
		fruitlist.add(watermelon18);
		Watermelon watermelon19 = new Watermelon();
		fruitlist.add(watermelon19);
		Watermelon watermelon20 = new Watermelon();
		fruitlist.add(watermelon20);
		return fruitlist;
	}
	
	public ArrayList<Enemy> fillWithEnemy(ArrayList<Enemy> enemylist) {
		BeeHive beehive1 = new BeeHive();
		enemylist.add(beehive1);
		BeeHive beehive2 = new BeeHive();
		enemylist.add(beehive2);
		BeeHive beehive3 = new BeeHive();
		enemylist.add(beehive3);
		BeeHive beehive4 = new BeeHive();
		enemylist.add(beehive4);
		BeeHive beehive5 = new BeeHive();
		enemylist.add(beehive5);
		BeeHive beehive6 = new BeeHive();
		enemylist.add(beehive6);
		BeeHive beehive7 = new BeeHive();
		enemylist.add(beehive7);
		BeeHive beehive8 = new BeeHive();
		enemylist.add(beehive8);
		BeeHive beehive9 = new BeeHive();
		enemylist.add(beehive9);
		BeeHive beehive10 = new BeeHive();
		enemylist.add(beehive10);
		BeeHive beehive11 = new BeeHive();
		enemylist.add(beehive11);
		BeeHive beehive12 = new BeeHive();
		enemylist.add(beehive12);
		BeeHive beehive13 = new BeeHive();
		enemylist.add(beehive13);
		BeeHive beehive14 = new BeeHive();
		enemylist.add(beehive14);
		BeeHive beehive15 = new BeeHive();
		enemylist.add(beehive15);
		BeeHive beehive16 = new BeeHive();
		enemylist.add(beehive16);
		BeeHive beehive17 = new BeeHive();
		enemylist.add(beehive17);
		BeeHive beehive18 = new BeeHive();
		enemylist.add(beehive18);
		BeeHive beehive19 = new BeeHive();
		enemylist.add(beehive19);
		BeeHive beehive20 = new BeeHive();
		enemylist.add(beehive20);
		Rock rock1 = new Rock();
		enemylist.add(rock1);
		Rock rock2 = new Rock();
		enemylist.add(rock2);
		Rock rock3 = new Rock();
		enemylist.add(rock3);
		Rock rock4 = new Rock();
		enemylist.add(rock4);
		Rock rock5 = new Rock();
		enemylist.add(rock5);
		Rock rock6 = new Rock();
		enemylist.add(rock6);
		Rock rock7 = new Rock();
		enemylist.add(rock7);
		Rock rock8 = new Rock();
		enemylist.add(rock8);
		Rock rock9 = new Rock();
		enemylist.add(rock9);
		Rock rock10 = new Rock();
		enemylist.add(rock10);
		Rock rock11 = new Rock();
		enemylist.add(rock11);
		Rock rock12 = new Rock();
		enemylist.add(rock12);
		Rock rock13 = new Rock();
		enemylist.add(rock13);
		Rock rock14 = new Rock();
		enemylist.add(rock14);
		Rock rock15 = new Rock();
		enemylist.add(rock15);
		Rock rock16 = new Rock();
		enemylist.add(rock16);
		Rock rock17 = new Rock();
		enemylist.add(rock17);
		Rock rock18 = new Rock();
		enemylist.add(rock18);
		Rock rock19 = new Rock();
		enemylist.add(rock19);
		Rock rock20 = new Rock();
		enemylist.add(rock20);
		Bomb bomb1 = new Bomb();
		enemylist.add(bomb1);
		Bomb bomb2 = new Bomb();
		enemylist.add(bomb2);
		Bomb bomb3 = new Bomb();
		enemylist.add(bomb3);
		Bomb bomb4 = new Bomb();
		enemylist.add(bomb4);
		Bomb bomb5 = new Bomb();
		enemylist.add(bomb5);
		Bomb bomb6 = new Bomb();
		enemylist.add(bomb6);
		Bomb bomb7 = new Bomb();
		enemylist.add(bomb7);
		Bomb bomb8 = new Bomb();
		enemylist.add(bomb8);
		Bomb bomb9 = new Bomb();
		enemylist.add(bomb9);
		Bomb bomb10 = new Bomb();
		enemylist.add(bomb10);
		Bomb bomb11 = new Bomb();
		enemylist.add(bomb11);
		Bomb bomb12 = new Bomb();
		enemylist.add(bomb12);
		Bomb bomb13 = new Bomb();
		enemylist.add(bomb13);
		Bomb bomb14 = new Bomb();
		enemylist.add(bomb14);
		Bomb bomb15 = new Bomb();
		enemylist.add(bomb15);
		Bomb bomb16 = new Bomb();
		enemylist.add(bomb16);
		Bomb bomb17 = new Bomb();
		enemylist.add(bomb17);
		Bomb bomb18 = new Bomb();
		enemylist.add(bomb18);
		Bomb bomb19 = new Bomb();
		enemylist.add(bomb19);
		Bomb bomb20 = new Bomb();
		enemylist.add(bomb20);
		return enemylist;
	}
	
	
	public BasketCaseGame(Player player) {
		this.player = player;
	}
	
	public static BasketCaseGame makeStartGame(){
		return new BasketCaseGame();
	}
	
	public List<String> getLegalFruits(){
		ArrayList<String> legalFruits = new ArrayList<String>();
		if(unusedFruits.get(0).isLegal()){
			legalFruits.add("Apple ");
		}
		if(unusedFruits.get(20).isLegal()){
			legalFruits.add("Banana ");
		}
		if(unusedFruits.get(40).isLegal()){
			legalFruits.add("Orange "); 
		}
		if(unusedFruits.get(60).isLegal()){
			legalFruits.add("Strawberry "); 
		}
		if(unusedFruits.get(80).isLegal()){
			legalFruits.add("Watermelon");
		}
		return legalFruits;
	}
		
	
	public String getStatus() {
        return "Lives " + getLives() + "  Score " + getScore() + " Legal Fruits: " + getLegalFruits();
    }
	
	public void perform(BasketCaseGameAction move) {
		move.update(this);
	}
	
	public void onTick() {
		counter++;
		counter2++;
		if(counter >= 10 - ((int)counter/20)){
			int randNum = (int) (Math.random() * 2);
			if (randNum == 0) {
				unusedFruits.get(((int)(Math.random()*unusedFruits.size()))).setinPlay(true);
			}
			else{
				unusedEnemies.get(((int)(Math.random()*unusedEnemies.size()))).setinPlay(true);
			}
		}
		if(counter2 >= 35 - counter/100){
			Enemy targetEnemy = unusedEnemies.get(((int)(Math.random()*unusedEnemies.size())));
			if(!targetEnemy.isinPlay()){
				targetEnemy.setPosition(new Position(((int)(Math.random()*BasketCaseGame.GAMEBOARD_WIDTH)),0));
				targetEnemy.setinPlay(true);
				counter2 = 0;
			}
		}
		
		if(counter%100 == 0){
			for (Fruit fruit : unusedFruits){
				fruit.setLegal(true);
			}
			int n1 = ((int) (Math.random()*5));
			int n2 = ((int) (Math.random()*9));
			int n3 = ((int) (Math.random()*5)) + ((int) (Math.random()* (400/counter)));
			if(n1==0||n2==0||n3==0){
				for (Fruit fruit : unusedFruits){
					if (fruit instanceof Apple){
						fruit.setLegal(false);
					}
				}
			}
			if(n1==1||n2==1||n3==1){
				for (Fruit fruit : unusedFruits){
					if (fruit instanceof Banana){
						fruit.setLegal(false);
					}
				}
			}
			if(n1==2||n2==2||n3==2){
				for (Fruit fruit : unusedFruits){
					if (fruit instanceof Orange){
						fruit.setLegal(false);
					}
				}
			}
			if(n1==3||n2==3||n3==3){
				for (Fruit fruit : unusedFruits){
					if (fruit instanceof Strawberry){
						fruit.setLegal(false);
					}
				}
			}
			if(n1==4||n2==4||n3==4){
				for (Fruit fruit : unusedFruits){
					if (fruit instanceof Watermelon){
						fruit.setLegal(false);
					}
				}
			}
			
		}
		
		
		for (Enemy enemy : unusedEnemies) {
			if(enemy.inPlay){
				enemy.onTick(this);
			}	
		}
		for (Fruit fruit : unusedFruits) {
			if(fruit.inPlay){
				fruit.onTick(this);
			}
		}
		
	}

	public static void main(String[] args) {
        BasketCaseGame game = new BasketCaseGame();
        game.addGameListener(new ConsoleListener());
        game.addGameListener(new BasketCaseGameAI(game));
        game.start();
    }

	@Override
	public long getRealTimeTickLength() {
		return 200;
	}
}
