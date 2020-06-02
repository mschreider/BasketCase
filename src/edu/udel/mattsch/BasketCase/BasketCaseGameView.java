package edu.udel.mattsch.BasketCase;

import java.util.Iterator; 
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
 

public class BasketCaseGameView extends View {
    
	// the activity
    protected BasketCaseGameActivity activity;
    
    //--- BEGIN - these properties can be saved so we don't need to recompute ----
    // the width and height of the current game view
    private int width;
    private int height;
    
    // the scale of the game board grid, how many pixels per col (x) and row (y)
    private float scale_x;
    private float scale_y;
    //--- END -----
    
    // the loaded bitmaps of images used to draw the game
    private Bitmap playerImage;
    private Bitmap appleImage;
    private Bitmap bananaImage;
    private Bitmap orangeImage;
    private Bitmap strawberryImage;
    private Bitmap watermelonImage;
    private Bitmap beehiveImage;
    private Bitmap bombImage;
    private Bitmap rockImage;
    private Bitmap backgroundImage;
        
    public BasketCaseGameView(BasketCaseGameActivity context) {
        super(context);
        activity = context;
        
        backgroundImage = BitmapFactory.decodeResource(activity.getResources(), activity.getResources().getIdentifier("tree", "drawable", getClass().getPackage().getName()));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(backgroundImage);
        this.setBackgroundDrawable(bitmapDrawable);
        
        
        setFocusable(true);
        setFocusableInTouchMode(true);
        playerImage = loadImage("player");
        appleImage = loadImage("apple");
        bananaImage = loadImage("banana");
        orangeImage = loadImage("orange");
        strawberryImage = loadImage("strawberry");
        watermelonImage = loadImage("watermelon");
        beehiveImage = loadImage("beehive");
        bombImage = loadImage("bomb");
        rockImage = loadImage("rock");
        backgroundImage = loadImage("tree");
        		

    }
    
    
    
    private Bitmap loadImage(String name) {
        return BitmapFactory.decodeResource(activity.getResources(), 
            activity.getResources().getIdentifier(name, "drawable", getClass().getPackage().getName()));
    }
    
    

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
      
        drawFruit(canvas);
        
        drawEnemies(canvas);
        
        drawPlayer(canvas);
        
    }
        
    
    RectF rectF = new RectF();
    private void setRectFromPosition(Position position) {
        float left = scale_x * position.getColumn();
        float top = scale_y * position.getRow();
        float right = left + scale_x;
        float bottom = top + scale_y;
        rectF.set(left, top, right, bottom);
    }
    
    
    public void drawFruit(Canvas canvas) {
    	for (Fruit fruit : activity.getCurrentGame().unusedFruits) {
            if(fruit.isinPlay()) {
                setRectFromPosition(fruit.getPosition());
                if(fruit instanceof Apple){
                	canvas.drawBitmap(appleImage, null, rectF, null);
                }
                else if(fruit instanceof Banana){
                	canvas.drawBitmap(bananaImage, null, rectF, null);
                }
                else if(fruit instanceof Orange){
                	canvas.drawBitmap(orangeImage, null, rectF, null);
                }
                else if(fruit instanceof Strawberry){
                	canvas.drawBitmap(strawberryImage, null, rectF, null);
                }
                else if(fruit instanceof Watermelon){
                	canvas.drawBitmap(watermelonImage, null, rectF, null);
                }
            }
        }
        
    }
    
    public void drawEnemies(Canvas canvas) {
    	for (Enemy enemy : activity.getCurrentGame().unusedEnemies) {
            if(enemy.isinPlay()) {
                setRectFromPosition(enemy.getPosition());
                if(enemy instanceof BeeHive){
                	canvas.drawBitmap(beehiveImage, null, rectF, null);
                }
                else if(enemy instanceof Bomb){
                	canvas.drawBitmap(bombImage, null, rectF, null);
                }
                else if(enemy instanceof Rock){
                	canvas.drawBitmap(rockImage, null, rectF, null);
                }
            }
        }
    }
    
    public void drawPlayer(Canvas canvas) {
        BasketCaseGame BasketCaseGame = activity.getCurrentGame();
        
        setRectFromPosition(BasketCaseGame.getPlayer().position);
        
        Bitmap image = playerImage;
        
        canvas.drawBitmap(image, null, rectF, null);
        
        Paint textPaint = new Paint();
        textPaint.setTextSize(15);
        textPaint.setTextScaleX(1.5f);
        textPaint.setTypeface(Typeface.SERIF);
        canvas.drawText("Scaled", 0, 0, textPaint);
    }
    
    /**
     * This method is called by the Android platform when the app window size changes.
     * We store the initial setting of these so that we can compute the exact locations
     * to draw the components of our View.
     */
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        width = w;
        height = h;
        
        updateScaling();
    }
    
    private void updateScaling() {
        if (activity.getCurrentGame() != null) {
            scale_x = (float)width / (float)BasketCaseGame.GAMEBOARD_WIDTH;
            scale_y = (float)height / (float)BasketCaseGame.GAMEBOARD_HEIGHT;
        }
    }
}

