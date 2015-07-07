package com.mcs.assignment.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.mcs.assignment.pojos.Book;
import com.mcs.assignment.pojos.Member;
import com.mcs.assignment.pojos.Publisher;

/**
 * Created by eranga on 7/7/15.
 */
public class PusthakayaDbSource  {

    Context context;

    /**
     * Init db helper
     * @param context application context
     */
    public PusthakayaDbSource(Context context) {
        this.context = context;
    }

    /**
     * Insert Book to database
     * @param book book
     */
    public void createBook(Book book) {
        SQLiteDatabase db = PusthakayaDbHelper.getInstance(context).getWritableDatabase();

        // content values to inset
        ContentValues values = new ContentValues();
        values.put(PusthakayaDbContract.Book.COLUMN_NAME_TITLE, book.getTitle());
        values.put(PusthakayaDbContract.Book.COLUMN_NAME_PUBLISHER_NAME, book.getPublisher());

        // Insert the new row, if fails throw an error
        db.insertOrThrow(PusthakayaDbContract.Book.TABLE_NAME, PusthakayaDbContract.Book.COLUMN_NAME_TITLE, values);
        db.close();
    }

    /**
     * Insert Publisher to database
     * @param publisher book publisher
     */
    public void createPublisher(Publisher publisher) {
        SQLiteDatabase db = PusthakayaDbHelper.getInstance(context).getWritableDatabase();

        // content values to inset
        ContentValues values = new ContentValues();
        values.put(PusthakayaDbContract.Publisher.COLUMN_NAME_NAME, publisher.getName());
        values.put(PusthakayaDbContract.Publisher.COLUMN_NAME_ADDRESS, publisher.getAddress());
        values.put(PusthakayaDbContract.Publisher.COLUMN_NAME_PHONE, publisher.getPhone());

        // Insert the new row, if fails throw an error
        db.insertOrThrow(PusthakayaDbContract.Publisher.TABLE_NAME, PusthakayaDbContract.Publisher.COLUMN_NAME_PHONE, values);
        db.close();
    }

    /**
     * Insert Member to database
     * @param member member
     */
    public void createPublisher(Member member) {
        SQLiteDatabase db = PusthakayaDbHelper.getInstance(context).getWritableDatabase();

        // content values to inset
        ContentValues values = new ContentValues();
        values.put(PusthakayaDbContract.Member.COLUMN_NAME_NAME, member.getName());
        values.put(PusthakayaDbContract.Member.COLUMN_NAME_ADDRESS, member.getAddress());
        values.put(PusthakayaDbContract.Member.COLUMN_NAME_PHONE, member.getPhone());

        // Insert the new row, if fails throw an error
        db.insertOrThrow(PusthakayaDbContract.Publisher.TABLE_NAME, PusthakayaDbContract.Member.COLUMN_NAME_PHONE, values);
        db.close();
    }

}
