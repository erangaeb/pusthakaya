package com.mcs.assignment.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by eranga on 6/29/15.
 */
public class PusthakayaDbHelper extends SQLiteOpenHelper {

    private static final String TAG = PusthakayaDbHelper.class.getName();

    // we use singleton database
    private static PusthakayaDbHelper senzorsDbHelper;

    // If you change the database schema, you must increment the database version
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Pusthakaya.db";

    // queries
    private static final String SQL_CREATE_BOOK =
            "CREATE TABLE " + PusthakayaDbContract.Book.TABLE_NAME + " (" +
                    PusthakayaDbContract.Book.COLUMN_NAME_ID + " TEXT PRIMARY KEY," +
                    PusthakayaDbContract.Book.COLUMN_NAME_TITLE + "TEXT," +
                    PusthakayaDbContract.Book.COLUMN_NAME_PUBLISHER_NAME + "TEXT" +
                    " )";

    private static final String SQL_CREATE_PUBLISHER =
            "CREATE TABLE " + PusthakayaDbContract.Publisher.TABLE_NAME + " (" +
                    PusthakayaDbContract.Publisher.COLUMN_NAME_NAME + " TEXT PRIMARY KEY," +
                    PusthakayaDbContract.Publisher.COLUMN_NAME_ADDRESS + "TEXT," +
                    PusthakayaDbContract.Publisher.COLUMN_NAME_PHONE + "TEXT" +
                    " )";

    private static final String SQL_CREATE_BRANCH =
            "CREATE TABLE " + PusthakayaDbContract.Branch.TABLE_NAME + " (" +
                    PusthakayaDbContract.Branch.COLUMN_NAME_ID + " TEXT PRIMARY KEY," +
                    PusthakayaDbContract.Branch.COLUMN_NAME_NAME + "TEXT," +
                    PusthakayaDbContract.Branch.COLUMN_NAME_ADDRESS + "TEXT" +
                    " )";

    private static final String SQL_CREATE_MEMBER =
            "CREATE TABLE " + PusthakayaDbContract.Member.TABLE_NAME + " (" +
                    PusthakayaDbContract.Member.COLUMN_NAME_CARD_NO + " TEXT PRIMARY KEY," +
                    PusthakayaDbContract.Member.COLUMN_NAME_NAME + "TEXT," +
                    PusthakayaDbContract.Member.COLUMN_NAME_ADDRESS + "TEXT" +
                    PusthakayaDbContract.Member.COLUMN_NAME_PHONE + "TEXT" +
                    PusthakayaDbContract.Member.COLUMN_UNPAID_DUES + "TEXT" +
                    " )";

    private static final String SQL_DELETE_BOOK =
            "DROP TABLE IF EXISTS " + PusthakayaDbContract.Book.TABLE_NAME;
    private static final String SQL_DELETE_PUBLISHER =
            "DROP TABLE IF EXISTS " + PusthakayaDbContract.Publisher.TABLE_NAME;
    private static final String SQL_DELETE_BRANCH =
            "DROP TABLE IF EXISTS " + PusthakayaDbContract.Branch.TABLE_NAME;
    private static final String SQL_DELETE_MEMBER =
            "DROP TABLE IF EXISTS " + PusthakayaDbContract.Member.TABLE_NAME;

    /**
     * Init context
     * Init database
     * @param context application context
     */
    public PusthakayaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * We are reusing one database instance in all over the app for better memory usage
     * @param context application context
     * @return db helper instance
     */
    synchronized static PusthakayaDbHelper getInstance(Context context) {
        if (senzorsDbHelper == null) {
            senzorsDbHelper = new PusthakayaDbHelper(context.getApplicationContext());
        }
        return (senzorsDbHelper);
    }

    /**
     * {@inheritDoc}
     */
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "OnCreate: creating db helper, db version - " + DATABASE_VERSION);
        db.execSQL(SQL_CREATE_BOOK);
        db.execSQL(SQL_CREATE_PUBLISHER);
        db.execSQL(SQL_CREATE_BRANCH);
        db.execSQL(SQL_CREATE_MEMBER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        // enable foreign key constraint here
        Log.d(TAG, "OnConfigure: Enable foreign key constraint");
        //db.setForeignKeyConstraintsEnabled(true);
    }

    /**
     * {@inheritDoc}
     */
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        Log.d(TAG, "OnUpgrade: updating db helper, db version - " + DATABASE_VERSION);
        db.execSQL(SQL_DELETE_BOOK);
        db.execSQL(SQL_DELETE_PUBLISHER);
        db.execSQL(SQL_DELETE_BRANCH);
        db.execSQL(SQL_DELETE_MEMBER);

        onCreate(db);
    }

    /**
     * {@inheritDoc}
     */
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
