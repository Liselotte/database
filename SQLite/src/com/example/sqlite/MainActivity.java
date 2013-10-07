package com.example.sqlite;

import java.util.ArrayList;

import com.example.sqlite.db.FriendsDB;
import com.example.sqlite.entry.FriendEntry;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context context;
	private FriendsDB db;
	private ArrayList<FriendEntry> friends;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		
		//Context
		context = this;
		db = new FriendsDB(context);
		friends = new ArrayList<FriendEntry>();
		showAllFriends();
		//Test Insert
		long recordID = db.insert("WASIN","HAWAREE","BEER");
		Toast.makeText(context,"Inserted Data ("+recordID+")",Toast.LENGTH_SHORT).show();
		if(recordID != -1)
		{
			showAllFriends();
		}
		//Test SelectAll
	}
	
	public void showAllFriends(){
		friends = db.selectAll();
		if(friends.size()==0){
			Toast.makeText(context,"You don't have any friend",Toast.LENGTH_SHORT).show();
		}else{
			for(int i=0;i<friends.size();i++)
			{
				Log.i("Friend Info",friends.get(i).getFname()+"info\n"+friends.get(i).getLname());
			}
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
