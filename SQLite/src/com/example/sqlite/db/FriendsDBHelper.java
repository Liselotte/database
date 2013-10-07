package com.example.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class FriendsDBHelper extends SQLiteOpenHelper{

	public static int TABLE_VERSION = 1;
	public static String TABLE_NAME = "friends";
	public static String TABLE_KEY_ID = "id";
	public static String TABLE_KEY_FNAME = "fname";
	public static String TABLE_KEY_LNAME = "lname";
	public static String TABLE_KEY_NICKNAME = "nickname";
	public static String TABLE_CREATE_SQL= "CREATE TABLE "+TABLE_NAME+" (" +
											""+TABLE_KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
											""+TABLE_KEY_FNAME+" TEXT(20), "+
											""+TABLE_KEY_LNAME+" TEXT(20), "+
											""+TABLE_KEY_NICKNAME+" TEXT(10) "+")";
	// Constructor
	public FriendsDBHelper(Context context) {
		super(context,TABLE_NAME, null,TABLE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(TABLE_CREATE_SQL);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE"+TABLE_NAME);
		onCreate(db);
		Log.i("Friends DB Helper","Table Upgrade from"+oldVersion+" to"+newVersion);
	}

}
