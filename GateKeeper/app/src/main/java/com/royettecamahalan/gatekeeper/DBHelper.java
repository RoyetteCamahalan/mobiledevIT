package com.royettecamahalan.gatekeeper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RoyetteCamahalan on 3/21/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASENAME="GateKeeper";
    public static final int DATABASEVERSION=1;


    public DBHelper(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create TABLES
        String query="CREATE TABLE Accounts " +
                    "(accountid INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "accountname TEXT, username TEXT, pword TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Alter Table
    }

    public boolean insertaccount(String accountname,String username,
                                 String Password){
        SQLiteDatabase db=getWritableDatabase();
        long rows=0;
        ContentValues values=new ContentValues();
        values.put("accountname",accountname);
        values.put("username",username);
        values.put("pword",Password);
        rows=db.insert("Accounts",null,values);
        return rows>0;
    }

    public boolean updateaccount(String accountid,String accountname,
                                 String username,String Password){
        SQLiteDatabase db=getWritableDatabase();
        long rows=0;
        ContentValues values=new ContentValues();
        values.put("accountname",accountname);
        values.put("username",username);
        values.put("pword",Password);

        String id = accountid + "";

        String whereArgs[] = new String[]{id};
        rows=db.update("Accounts", values, "accountid" + "=?", whereArgs);
        return rows>0;
    }

    public boolean deleteaccount(String accountid){
        SQLiteDatabase db=getWritableDatabase();
        long rows=0;

        String id = accountid + "";

        String whereArgs[] = new String[]{id};
        rows=db.delete("Accounts", "accountid" + "=?", whereArgs);
        return rows>0;
    }

    public ArrayList<HashMap<String,String>> getAccounts(){
        ArrayList<HashMap<String,String>> accounts=new ArrayList();
        SQLiteDatabase db=getWritableDatabase();
        String sql="select accountid,accountname,username,pword from Accounts";
        Cursor cur=db.rawQuery(sql,null);
        while (cur.moveToNext()){
            HashMap<String,String> map=new HashMap();
            map.put("accountname",cur.getString(1));
            map.put("username",cur.getString(2));
            map.put("pword",cur.getString(3));
            accounts.add(map);
        }
        return accounts;
    }


}
