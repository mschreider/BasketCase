package edu.udel.mattsch.BasketCase;


import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;


public class BasketCaseGameHuman implements View.OnTouchListener, View.OnKeyListener {
    private BasketCaseGameActivity activity;

    public BasketCaseGameHuman(BasketCaseGameActivity activity) {
        this.activity = activity;
    }

    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        BasketCaseGame game = activity.getCurrentGame();
        if (game != null) {
            // is the game ended? if so restart it!
            if (game.isEnd()) {
                activity.restartGame();
            }
            else if (action == MotionEvent.ACTION_DOWN) {
                // where did they click on the board?
                int col = (int)((event.getX() / v.getWidth()) * 
                        BasketCaseGame.GAMEBOARD_WIDTH);
                
                // which direction does that indicate?
                int direction = (int)(((col-8)/(9))+1);
                game.perform(new BasketCaseGameAction(direction));
    

            }
        }
        
        // we don't need any more events in this sequence
        return false;
    }
    
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        int direction = activity.getCurrentGame().getPlayer().getDirection();
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
        	if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_LEFT) {
                direction = -1;
            }
            else if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_RIGHT) {
                direction = 1;
            }
            else{
            	direction = 0;
            }
            if(new BasketCaseGameAction(direction).isValid(activity.getCurrentGame())){
            	activity.getCurrentGame().perform(new BasketCaseGameAction(direction));
            }
        }
        
        return false;
    }
}