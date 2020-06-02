package edu.udel.mattsch.BasketCase;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;

public class EndOfGameDialog implements DialogInterface.OnClickListener {
    private BasketCaseGameActivity activity;
    private EditText input;
    private BasketCaseGameRecord lastRecord;
    private boolean topTen;

    public EndOfGameDialog(BasketCaseGameActivity activity) {
        this.activity = activity;
    }
    
    public void onClick(DialogInterface dialog, int whichButton) {
        if (topTen) {
            // format value to only valid letters, and only the first 3, uppercase
            String value = String.format("%3s", 
                this.input.getText().toString().replaceAll("[^a-zA-Z]", "")).substring(0,3).toUpperCase();
    
            lastRecord.setPlayer(value);
            
            // insert record to database
            activity.getDatabase().insertGameRecord(lastRecord);
        }
        
        activity.setAppView("Splash");
    }
    
    /**
     * Gets the last initials entered.  Will return "" if none entered yet.
     * 
     * @return
     */
    public String getName() {
        String lastInitials = "";
        if (this.lastRecord != null) {
            lastInitials = lastRecord.getPlayer();
        }
        return lastInitials;
    }

    
    public void show() {
        // pop up a dialog box telling them to enter name
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        int score = activity.getCurrentGame().getScore();
        
        lastRecord = new BasketCaseGameRecord(getName(), score, System.currentTimeMillis());

        topTen = activity.getDatabase().isTopTenScore(lastRecord); 
        if (topTen) {
            alert.setTitle("Congratulations!");
            alert.setMessage("New top ten score of " + score + "!\nPlease enter your initials:");
            
            String name = getName();
            this.input = new EditText(activity);
            this.input.setText(name);
            
            
            alert.setView(this.input);
        }
        else {
            alert.setTitle("Game Over");
            alert.setMessage("Score of " + score + ".");
        }

        
        alert.setPositiveButton("Ok", this);
        alert.show();

    }
    
}

