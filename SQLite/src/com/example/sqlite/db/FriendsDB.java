package com.example.sqlite.db;

import java.util.ArrayList;

import com.example.sqlite.entry.FriendEntry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class FriendsDB {

	private FriendsDBHelper helper;
	private SQLiteDatabase db;
	
	public FriendsDB(Context context){
		helper = new FriendsDBHelper(context);
		db = helper.getWritableDatabase();
	}
	
	//Insert
	public long insert(String fname,String lname,String nickname){
		ContentValues values = new ContentValues();
		values.put(FriendsDBHelper.TABLE_KEY_FNAME, fname);
		values.put(FriendsDBHelper.TABLE_KEY_LNAME, lname);
		values.put(FriendsDBHelper.TABLE_KEY_NICKNAME, nickname);
		return db.insert(FriendsDBHelper.TABLE_NAME, null, values);
		
	}
	
	//Select All
	public ArrayList<FriendEntry> selectAll(){
		ArrayList<FriendEntry> friends = new ArrayList<FriendEntry>();
		Cursor cursor = db.rawQuery("SELECT * FROM "+FriendsDBHelper.TABLE_NAME+" WHERE id != ?",new String[]{Integer.toString(0)});
		
		cursor.moveToFirst();
		
		if(cursor.getCount() !=0){
			do{
				FriendEntry friend = new FriendEntry();
				friend.setId(cursor.getInt(cursor.getColumnIndex(FriendsDBHelper.TABLE_KEY_ID)));
				friend.setFname(cursor.getString(cursor.getColumnIndex(FriendsDBHelper.TABLE_KEY_FNAME)));
				friend.setLname(cursor.getString(cursor.getColumnIndex(FriendsDBHelper.TABLE_KEY_LNAME)));
				friend.setNickname(cursor.getString(cursor.getColumnIndex(FriendsDBHelper.TABLE_KEY_NICKNAME)));
				friends.add(friend);
			}while(cursor.moveToNext());
		}
	return friends;
	}
}
