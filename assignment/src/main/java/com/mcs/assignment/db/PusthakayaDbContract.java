package com.mcs.assignment.db;

import android.provider.BaseColumns;

/**
 * Created by eranga on 6/29/15.
 */
public class PusthakayaDbContract {

    /* Inner class that defines Book table contents */
    public static abstract class Book implements BaseColumns {
        public static final String TABLE_NAME = "book";
        public static final String COLUMN_NAME_ID = "id"; //pk
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_PUBLISHER_NAME = "publisher_name";
    }

    /* Inner class that defines the Publisher table contents */
    public static abstract class Publisher implements BaseColumns {
        public static final String TABLE_NAME = "publisher";
        public static final String COLUMN_NAME_NAME = "name"; //pk
        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_PHONE = "phone";
    }

    /* Inner class that defines the Branch table contents */
    public static abstract class Branch implements BaseColumns {
        public static final String TABLE_NAME = "branch";
        public static final String COLUMN_NAME_ID = "id"; //pk
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_ADDRESS = "address";
    }

    /* Inner class that defines the Member table contents */
    public static abstract class Member implements BaseColumns {
        public static final String TABLE_NAME = "member";
        public static final String COLUMN_NAME_CARD_NO = "card_no";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_PHONE = "phone";
        public static final String COLUMN_UNPAID_DUES = "unpaid_dues";
    }

    /* Inner class that defines the BookAuthor table contents */
    public static abstract class BookAuthor implements BaseColumns {
        public static final String TABLE_NAME = "book_author";
        public static final String COLUMN_NAME_BOOK = "book"; //pk
        public static final String COLUMN_NAME_AUTHOR = "author"; //pk, fk
    }

    /* Inner class that defines the BookCopy table contents */
    public static abstract class BookCopy implements BaseColumns {
        public static final String TABLE_NAME = "book_copy";
        public static final String COLUMN_NAME_BOOK = "book"; //fk
        public static final String COLUMN_NAME_BRANCH = "branch"; // pk, fk
        public static final String COLUMN_NAME_ACCESS_NO = "access_no"; //pk
    }

    /* Inner class that defines the BookLoan table contents */
    public static abstract class BookLoan implements BaseColumns {
        public static final String TABLE_NAME = "book_loan";
        public static final String COLUMN_NAME_ACCESS_NO = "access_no"; //pk, fk
        public static final String COLUMN_NAME_BRANCH = "branch"; //pk, fk
        public static final String COLUMN_NAME_MEMBER = "member"; //pk, fk
        public static final String COLUMN_NAME_DATE_OUT = "date_out"; //pk
        public static final String COLUMN_NAME_DATE_DUE = "date_due";
        public static final String COLUMN_NAME_DATE_RETURN = "date_return";
    }

}
