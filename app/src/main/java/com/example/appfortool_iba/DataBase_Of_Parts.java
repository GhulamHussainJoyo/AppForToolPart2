package com.example.appfortool_iba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class DataBase_Of_Parts extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME="parts.db";

    private static final String TABLE_NAME_REORDS_OF_PARTS="record_of_parts_table";

    private final String col_1="Name_Of_parts";

    private final String col_2="Sell_price";

    private final String col_3="Purchase_price";

    private final String col_4="Sold_items";

    private final String col_5="Number_Of_items";

    private final String col_6="profit";

    private final String col_7="loss";

    /***********    ************************************      data for user data  *****************/






    private final String TABLE_NAME_USER_DATA="USER_DATA";

    private final String full_name_col_1="Full_Name";

    private final String email_col_2="Email";

    private final String pasword_clo_3="Password";

    private final String create_table_userData="create table USER_DATA(id primary key AUTOINCREMENT not null,Full_Name text not null," +
            "Email text not null,Password text not null)";














    public DataBase_Of_Parts(@Nullable Context context)
    {
        super(context,DATABASE_NAME, null,1 );
        SQLiteDatabase db=this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL("create table USER_DATA(" +

                "Id INTEGER primary key AUTOINCREMENT not null," +

                "Full_Name text not null," +

                "Email text not null," +

                "Password text not null)");


    }
    public void createTableRecordsOfParts(SQLiteDatabase db,String TABLE_NAME)
    {
        db.execSQL("create table "+ TABLE_NAME +

                "(Id INTEGER PRIMARY KEY AUTOINCREMENT, " +

                "Name_Of_Parts TEXT," +

                "Purchase_Price INTEGER," +

                "Sell_Price INTEGER," +


                "Number_Of_Items INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(String.format("DROP TABLE IF EXISTS%s", TABLE_NAME_USER_DATA));
        onCreate(db);

    }

    public boolean InsertData(String table_name , String part_name,
                              String purchase_price,
                              String sell_price,
                              String totall_items)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_1,part_name);
        contentValues.put(col_2,sell_price);
        contentValues.put(col_3,purchase_price);
        contentValues.put(col_5,totall_items);


        long result =db.insert(table_name,null,contentValues);

        if (result == -1)
        {
            return true;
        }
        else return false;


    }


    public boolean InsertDataLogin(String name,String Email,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put(full_name_col_1,name);
        contentValues.put(email_col_2,Email);
        contentValues.put(pasword_clo_3,password);
        long result = db.insert(TABLE_NAME_USER_DATA,null,contentValues);

        if (result == -1)
        {
            return true;
        }
        else return false;

    }




    public boolean InserLoss(String loss)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_6,loss);
        Long result =db.insert(TABLE_NAME_REORDS_OF_PARTS,null,contentValues);

        if (result == -1)
        {
            return true;
        }
        else return false;

    }



    public Cursor ShowAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+ TABLE_NAME_REORDS_OF_PARTS,null);
        return res;

    }

    public Cursor ShowAllDataLogin()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from USER_DATA",null);
        return res;

    }


    public Cursor getPassword(String mail)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from USER_DATA where Email ='" +mail+"';",null);

        return res;
    }


    public boolean isEmpty(){

        SQLiteDatabase database = this.getReadableDatabase();
        int NoOfRows = (int) DatabaseUtils.queryNumEntries(database,TABLE_NAME_REORDS_OF_PARTS);

        if (NoOfRows == 0){
            return true;
        }else {
            return false;
        }
    }

    public boolean isEmptyUserData(){

        SQLiteDatabase database = this.getReadableDatabase();
        int NoOfRows = (int) DatabaseUtils.queryNumEntries(database,TABLE_NAME_USER_DATA);

        if (NoOfRows == 0){
            return true;
        }else {
            return false;
        }
    }






    public Cursor getName(EditText mail)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res = db.rawQuery("select Full_Name from USERDATA where Email =" +mail,null);
        return res;

    }


    public boolean checkIfMyMailExists(String Email) {

        String Query = "Select Email from " + TABLE_NAME_USER_DATA + " where Email = '" + Email + "' ;";
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor = db.rawQuery(Query, null);

        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }

        cursor.close();

        return true;
    }



}
