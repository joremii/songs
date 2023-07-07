package sg.edu.rp.c346.id22022505.songs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VER = 1;
    private static final String DATABASE_NAME = "Songs.db";
    private static final String TABLE_SONG = "song";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_SINGERS = "singers";
    private static final String COLUMN_YEAR = "year";
    private static final String COLUMN_STARS = "stars";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + TABLE_SONG + "("
                + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TITLE + "TEXT,"
                + COLUMN_SINGERS + "TEXT,"
                + COLUMN_YEAR + "INTEGER,"
                + COLUMN_STARS + "INTEGER)";
        db.execSQL(createTableSql);
        Log.i("info", "created tables");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SONG);
        onCreate(db);
    }

    public void insertSong(String title, String singer, int year) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_SINGERS, singer);
        values.put(COLUMN_YEAR, year);
        values.put(COLUMN_STARS, star);
        db.insert(TABLE_SONG, null, values);
        db.close();
    }

    public ArrayList<Songs> getSongsContent() {
        ArrayList<Songs> song= new ArrayList<Songs>();
        SQLiteDatabase db= this.getReadableDatabase();
        String[] columns= {COLUMN_ID, COLUMN_TITLE, COLUMN_SINGERS, COLUMN_YEAR, COLUMN_STARS};
        Cursor cursor= db.query(TABLE_SONG, columns, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id= cursor.getInt(0);
                String title= cursor.getString(1);
                String singer= cursor.getString(2);
                int year= cursor.getInt(3);
                int star= cursor.getInt(4);

                Songs newSong= new Songs(id, title, singer, year, star);
                Songs.add(newSong);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return song;
    }

    public ArrayList<Songs> getSongs() {
        ArrayList<Songs> songs = new ArrayList<Songs>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID, COLUMN_TITLE, COLUMN_SINGERS, COLUMN_YEAR, COLUMN_STARS};
        Cursor cursor = db.query(TABLE_SONG, columns, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id= cursor.getInt(0);
                String title= cursor.getString(1);
                String singer= cursor.getString(2);
                int year= cursor.getInt(3);
                int star= cursor.getInt(4);

                Songs newSong= new Songs(id, title, singer, year, star);
                Songs.add(newSong);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return songs;
    }
}
