package tn.sleam.five.marwen.a5sleam.sqlite.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import tn.sleam.five.marwen.a5sleam.sqlite.entity.Candidate;

import static android.content.ContentValues.TAG;

/**
 * Created by marwen on 28/08/17.
 */

public class LocalStorage extends SQLiteOpenHelper {

    // Database Info
    private static final String DATABASE_NAME = "5SLEAM";
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String CANDIDATE = "candidate";

    // candidate Table Columns
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String POSTE = "poste";


    private static LocalStorage sInstance;


    private LocalStorage(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Singleton
    public static synchronized LocalStorage getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new LocalStorage(context.getApplicationContext());
        }
        return sInstance;
    }

    // Called when the database connection is being configured.
    // Configure database settings for things like foreign key support, write-ahead logging, etc.
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            db.setForeignKeyConstraintsEnabled(true);
        }
    }


    // Called when the database is created for the FIRST time.
    // If a database already exists on disk with the same DATABASE_NAME, this method will NOT be called.
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_CANDIDAT_TABLE = "CREATE TABLE " + CANDIDATE +
                "(" +
                ID + " INTEGER PRIMARY KEY," + // Define a primary key
                NAME + " VARCHAR(50) ," +
                POSTE + " VARCHAR(50)" +
                ")";

        sqLiteDatabase.execSQL(CREATE_CANDIDAT_TABLE);

    }


    // Called when the database needs to be upgraded.
    // This method will only be called if a database already exists on disk with the same DATABASE_NAME,
    // but the DATABASE_VERSION is different than the version of the database that exists on disk.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + CANDIDATE);
            onCreate(db);
        }
    }


    // add new friend
    public Boolean saveCandidate(Candidate candidate) {

        Boolean success;

        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();


        if (!candidateAlreadyExist(candidate.getId())) {
            // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
            // consistency of the database.
            db.beginTransaction();
            try {

                ContentValues values = new ContentValues();
                values.put(NAME, candidate.getNom());
                values.put(POSTE, candidate.getPoste());

                db.insertOrThrow(CANDIDATE, null, values);
                db.setTransactionSuccessful();
                success = true;
            } catch (Exception e) {
                Log.d(TAG, "Error while trying to add to database");
                success = false;
            } finally {
                db.endTransaction();
            }
        } else
            // friend already exists
            success = false;

        return success;
    }


    // find saved player names
    public List<Candidate> getAllCandidate() {

        List<Candidate> candidates = new ArrayList<>();

        String GET_ALL_CANDIDATE_QUERY = new String("SELECT * from " + CANDIDATE);


        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(GET_ALL_CANDIDATE_QUERY, null);


        try {
            while (cursor.moveToNext()) {
                do {
                    Candidate candidate = new Candidate(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID))), cursor.getString(cursor.getColumnIndex(NAME)), cursor.getString(cursor.getColumnIndex(POSTE)));
                    candidates.add(candidate);

                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return candidates;
    }


    // find saved player names
    public Candidate findCandidateByUUID(Integer id) {

        Candidate candidate = new Candidate();

        String FIND_PLAYER_NAME_QUERY = new String("SELECT * from " + CANDIDATE + " WHERE " + ID + "=\"" + id + "%\" ");


        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(FIND_PLAYER_NAME_QUERY, null);


        try {
            if (cursor.moveToFirst()) {
                do {
                    candidate.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID))));
                    candidate.setNom(cursor.getString(cursor.getColumnIndex(NAME)));
                    candidate.setPoste(cursor.getString(cursor.getColumnIndex(POSTE)));

                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return candidate;
    }


    public Boolean candidateAlreadyExist(Integer id) {

        if (findCandidateByUUID(id).getId() == id)
            return true;
        else
            return false;
    }
}
