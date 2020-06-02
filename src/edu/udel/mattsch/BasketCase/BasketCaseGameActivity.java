package edu.udel.mattsch.BasketCase;

import java.io.IOException; 
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity; 
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BasketCaseGameActivity extends Activity implements GameListener<BasketCaseGame> {
    private Map<String, View> appViews;
    
	private TextView status;
    private TextView legalView;
    private BasketCaseGameView gameView;
    private BasketCaseGame game;
    private BasketCaseGameDatabase database;
    public EndOfGameDialog dialog;
    //private ColorAnimation anim;
    //private TextView animationView;
    
    
    private static final int GAMETYPE_AI = 0;
    private static final int GAMETYPE_HUMAN = 1;
    
    private int gameType;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appViews = new HashMap<String, View>();
        
        status = new TextView(this);
        gameView = new BasketCaseGameView(this);
        legalView = new TextView(this);
        dialog = new EndOfGameDialog(this);
        database = new BasketCaseGameDatabase(this);
        
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.addView(status);
        ll.addView(legalView);
        ll.addView(gameView);
        
        
        appViews.put("Game", ll);
        appViews.put("Splash", new SplashScreen(this));
        
        setAppView("Splash");
        //startGame();
        //setContentView(ll);
    }
    
    

    public BasketCaseGame getCurrentGame() {
        return game;
    }
    
    private void startGame() {
        game = BasketCaseGame.makeStartGame();
        game.addGameListener(this);

        if (gameType == GAMETYPE_AI) {
            game.addGameListener(new BasketCaseGameAI(game));
        }
        
        game.start();
        BasketCaseGameHuman human = new BasketCaseGameHuman(this);
        gameView.setOnTouchListener(human);
        gameView.setOnKeyListener(human);
        
        setAppView("Game");
    }
    
    public void restartGame() {
        if (game != null && game.isEnd()) {
            game.end();
        }
        startGame();
    }
    
    @Override
    public void onPerformActionEvent(Action<BasketCaseGame> action, BasketCaseGame game) {
        updateViews();
    }

    @Override
    public void onTickEvent(BasketCaseGame game) {
        updateViews();
        
    }

    @Override
    public void onStartEvent(BasketCaseGame game) {
        updateViews();
    }

    @Override
    public void onEndEvent(BasketCaseGame game) {
        updateViews();
        if (gameType == GAMETYPE_HUMAN && !isFinishing()) {
            dialog.show();
        }
        else {
            setAppView("Splash");
        }
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        finish();
        if (game != null) {
            game.end();
        }
    }

    @Override
    public void onEvent(String event, BasketCaseGame game) {
        updateViews();
        
    }
    
    
    
    public void updateViews() {
    	gameView.invalidate();
        status.setText(game.getStatus());
        
    }
    
    public BasketCaseGameDatabase getDatabase() {
    	return database;
    }

    
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add("Demo");
        menu.add("Play Game");
        menu.add("Restart");
        menu.add("Quit");
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
    	selectMenuOption(item.getTitle());
        return true;
    }
    
    public void setAppView(String viewName) {
    	View view = appViews.get(viewName);
    	setContentView(view);
    	view.invalidate();
    }
    	
    	
   public void selectMenuOption(CharSequence title){
        if (title.equals("Demo")) {
            gameType = GAMETYPE_AI;
            restartGame();
        }
        else if (title.equals("Play")) {
            gameType = GAMETYPE_HUMAN;
            restartGame();
        }
        else if (title.equals("Restart")) {
            // start a new game with the same players as previous game
            restartGame();
        }
        else if (title.equals("Quit")) {
            finish();
        }
    }

}



