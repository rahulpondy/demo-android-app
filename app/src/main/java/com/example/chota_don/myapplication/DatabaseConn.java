package com.example.chota_don.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chota_don on 15-03-02.
 */
public class DatabaseConn extends SQLiteOpenHelper {
    private static final String Db_name="userDB";
    private static final String table_name="userTable";
    private static final String columnId="id";
    private static final String columnUserName="username";
    private static final String columnName="name";
    private static final String columnEmail="email";
    private static final String columnPassword="password";
    public DatabaseConn(Context context){

        super(context,Db_name,null,1);
    }
    public String returnUsername(){
        return columnUserName;
    }

    public String returnemail(){
        return columnEmail;
    }

    public String returnname(){
        return columnName;
    }

    public String returnPassword(){
        return columnPassword;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+table_name+"( username TEXT,name TEXT,email TEXT,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(db);
    }

    public boolean insert(String username,String name,String email,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put(columnUserName,username);
        content.put(columnName,name);
        content.put(columnEmail,email);
        content.put(columnPassword,password);
        db.insert(table_name,null,content);
        return true;
    }

    public String checkLogin(String username){
        String pass="";
        SQLiteDatabase db=this.getReadableDatabase();
            String[] columns=new String[]{columnUserName,columnPassword};
        Cursor cursor=db.query(table_name,columns,null,null,null,null,null);
        int iusername=cursor.getColumnIndex(columnUserName);
        int index=cursor.getColumnIndex(columnPassword);
        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
           // pass=pass+cursor.getString(iusername)+" "+cursor.getString(index);
            if(cursor.getString(iusername).equals(username)){
                pass=cursor.getString(index);
                break;
            }
        }
        return pass;
    }
}

