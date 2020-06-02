package edu.udel.mattsch.BasketCase;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import edu.udel.mattsch.BasketCase.BasketCaseGameRecord;

public class BasketCaseGameDatabase {
    public static final String DATABASE_NAME = "BasketCaseGame";
    public static final String TABLE_NAME = "Game_Records";

    private SQLiteDatabase database;
    
    
    public BasketCaseGameDatabase(Context context) {
        this.database = context.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);

        createGameRecordsTable();
        try {
            selectTopGameRecords(1);
        }
        catch (Exception e) {
            // this will only happen if the table was created incorrectly in some previous run
            // or if one of the columns was changed.  To prevent this from crashing our program,
            // we will delete all records now
            System.err.println("BasketCaseGameDatabase was in an invalid state so the data has been cleared");
            deleteGameRecords();
            createGameRecordsTable();
        }
        
    }
    
    public void close() {
        if (this.database != null) {
            this.database.close();
        }
    }
    
    /**
     * Creates a table in the database if it does not exist already.
     */
    private void createGameRecordsTable() {
        database.execSQL("CREATE TABLE IF NOT EXISTS "
                        + TABLE_NAME
                        + " (Name TEXT, "
                        + " Score INTEGER, Date INTEGER);");
    }
    
    /**
     * Resets the database table to empty by deleting all rows.
     */
    public void deleteGameRecords() {
        database.execSQL("DROP TABLE " + TABLE_NAME);
        createGameRecordsTable();
    }
    
    /**
     * Inserts a single record (row) into the database table.
     * 
     * @param record
     */
    public void insertGameRecord(BasketCaseGameRecord record) {
        database.execSQL("INSERT INTO "
                        + TABLE_NAME
                        + " (Name, Score, Date)"
                        + " VALUES ('" + record.getPlayer() 
                        + "', " + record.getScore()
                        + ", " + record.getDate() + ");");       
    }

    /**
     * Gets the current top scores by querying the table for high scores ordered
     * by the score (descending) and date (ascending) so that the first person to
     * score a specific high score appears first.  Returns only the first
     * number of these.
     * 
     * @return
     */
    public List<BasketCaseGameRecord> selectTopGameRecords(int number) {
        Cursor c = database.rawQuery("SELECT Name, Score, Date" +
                                    " FROM " + TABLE_NAME 
                                    + " ORDER BY Score DESC, Date ASC"
                                    + " LIMIT 0, " + number,
                                    null);
        /* Get the indices of the Columns we will need */
        int nameColumn = c.getColumnIndex("Name");
        int scoreColumn = c.getColumnIndex("Score");
        int dateColumn = c.getColumnIndex("Date");
        
        List<BasketCaseGameRecord> highScores = new ArrayList<BasketCaseGameRecord>(number);
        if (c.moveToFirst()) {
//            while (true) {
                
//            }
            do {
                BasketCaseGameRecord record = new BasketCaseGameRecord(
                    c.getString(nameColumn),
                    c.getInt(scoreColumn),
                    c.getLong(dateColumn));
                highScores.add(record);
//                if (!c.moveToNext()) {
//                    break;
//                }
            }
            while (c.moveToNext());
        }
        
        return highScores;
    }
    
    public boolean isTopTenScore(BasketCaseGameRecord record) {
        List<BasketCaseGameRecord> top = selectTopGameRecords(10);
        return top.size() < 10 || top.get(top.size()-1).getScore() < record.getScore();
    }
}
