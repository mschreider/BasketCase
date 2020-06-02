package edu.udel.mattsch.BasketCase;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SplashScreen extends LinearLayout implements View.OnClickListener, OnItemClickListener {
    private BasketCaseGameActivity activity;
    
    private ImageView imageView;
    private Bitmap splashImage;
    private TextView scores;
    private Button button;
    
    private PopupMenu selectOptions;
    
    
    public SplashScreen(BasketCaseGameActivity activity) {
        super(activity);
        this.activity = activity;
        this.imageView = new ImageView(activity);
        this.scores = new TextView(activity);
        this.button = new Button(activity);
        
        splashImage = BitmapFactory.decodeResource(activity.getResources(), 
            activity.getResources().getIdentifier("player", "drawable", getClass().getPackage().getName()));
        
        init();
    }
    
    private void init() {
        setOrientation(LinearLayout.VERTICAL);
        imageView.setImageBitmap(splashImage);
        imageView.setAdjustViewBounds(true);
        
        
        selectOptions = new PopupMenu(activity, "Basket Case Game",
            new String[]{"Play", "Demo", "Restart", "Quit"},
            this, 24);
        
        scores.setTypeface(Typeface.create(Typeface.MONOSPACE, Typeface.BOLD));
        scores.setGravity(Gravity.TOP | Gravity.LEFT); // set it to the top left using bitwise OR
        
        button.setText("Touch here to play");
        button.setTypeface(Typeface.SANS_SERIF);
        button.setGravity(Gravity.CENTER);
        button.setBackgroundColor(Color.CYAN);
        button.setTextColor(Color.BLACK);
        button.setOnClickListener(this);
        
        // these parameters allow the scores view to fill all remaining space after
        // all components are laid out
        imageView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT));
        scores.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
            LayoutParams.WRAP_CONTENT));
        button.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
            LayoutParams.WRAP_CONTENT));

        addView(imageView);
        addView(scores);
        addView(button);
    }
    
    public void invalidate() {
        if (activity != null) {
            // fill table with current highscores
            StringBuilder text = new StringBuilder();
            for (BasketCaseGameRecord record : activity.getDatabase().selectTopGameRecords(10)) {
                text.append(record.toString());
                text.append('\n'); // end of line between each
            }
            scores.setText(text);
        }
        super.invalidate();
    }

    
    @Override
    public void onClick(View v) {
        if (v == button) {
            selectOptions.show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        activity.selectMenuOption(((TextView)view).getText());
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        return super.onTouchEvent(event);
    }
}
