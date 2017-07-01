package com.example.srijanrana.librarymanagement;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBHandler extends SQLiteOpenHelper {

    private static final int Database_version=1;
    private static final String Database_name="Library.dp";
    public static final String Table1="Student";
    public static final String Table2="Faculty";
    public static final String Table3="Book";
    public static final String Column_Reg="_reg";
    public static final String Column_Studentname="_Studentname";
    public static final String Column_SBookList="_SBookList";
    public static final String Column_ID="_ID";
    public static final String Column_Facultyname="_Facultyname";
    public static final String Column_FBookList="_FBookList";
    public static final String Column_Ref="_ref";
    public static final String Column_Bookname="_Bookname";
    public static final String Column_Status="_Status";


    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Database_name, factory, Database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1= "CREATE TABLE "+Table1+"("+
                Column_Reg+" TEXT PRIMARY KEY, "+
                Column_Studentname+" TEXT, "+
                Column_SBookList+" ARRAY "+
                ");";
        String query2= "CREATE TABLE "+Table2+"("+
                Column_ID+" INTEGER PRIMARY KEY, "+
                Column_Facultyname+" TEXT, "+
                Column_FBookList+" ARRAY "+
                ");";
        String query3= "CREATE TABLE "+Table3+"("+
                Column_Ref+" INTEGER PRIMARY KEY, "+
                Column_Bookname+" TEXT, "+
                Column_Status+" TEXT "+
                ");";
        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);

//        db.execSQL("INSERT INTO "+Table3+"VALUES(1,\"A WALK TO REMEMBER\",AVAILABLE)");
//        db.execSQL("INSERT INTO "+Table3+"VALUES(2,\"THE NOTEBOOK\",AVAILABLE)");
//        db.execSQL("INSERT INTO "+Table3+"VALUES(3,\"DIGITAL FORTRESS\",AVAILABLE)");
//        db.execSQL("INSERT INTO "+Table3+"VALUES(4,\"AS YOU LIKE IT\",AVAILABLE)");
//        db.execSQL("INSERT INTO "+Table3+"VALUES(5,\"MACBETH\",AVAILABLE)");
//        db.execSQL("INSERT INTO "+Table3+"VALUES(6,\"THE LOST SYMBOL\",AVAILABLE)");
//        db.execSQL("INSERT INTO "+Table3+"VALUES(7,\"ANGELS AND DEMONS\",AVAILABLE)");
//        db.execSQL("INSERT INTO "+Table3+"VALUES(8,\"MECHANT OF VENICE\",AVAILABLE)");
//        db.execSQL("INSERT INTO "+Table3+"VALUES(9,\"INFERNO\",AVAILABLE)");
//        db.execSQL("INSERT INTO "+Table3+"VALUES(10,\"THE DA VINCI CODE\",AVAILABLE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table1);
        db.execSQL("DROP TABLE IF EXISTS " + Table2);
        db.execSQL("DROP TABLE IF EXISTS " + Table3);
        onCreate(db);
    }

    public void sadd(Student stud)
    {
        Log.d("check", stud.get_name() + " " + stud.get_reg());
        ContentValues values=new ContentValues();
        values.put(Column_Studentname, stud.get_name());
        values.put(Column_Reg, stud.get_reg());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(Table1, null, values);
        db.close();
    }

// to add a book;

  /*  public void badd(Book book)
    {
        ContentValues values=new ContentValues();
        values.put(Column_Bookname, book.get_name());
        values.put(Column_Ref,book.get_ref());
        values.put(Column_Status,book.get_Status());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(Table3, null, values);
        db.close();
    }
*/
    public void fadd(Faculty fac)
    {
        ContentValues values=new ContentValues();
        values.put(Column_Facultyname,fac.get_name());
        values.put(Column_ID,fac.get_id());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(Table2, null, values);
        db.close();
    }

    public int checks(String nam,String rno)
    {
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM STUDENT";
        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            String name=c.getString(c.getColumnIndex("_Studentname"));
            String regno=c.getString(c.getColumnIndex("_reg"));
            if((name.equals(nam))&&(regno.equals(rno)))
            {
                return 1;
            }
            c.moveToNext();
        }
        return 0;
    }
    public int checkf(String nam,String rno)
    {
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM FACULTY";
        Cursor c=db.rawQuery(query, null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            String name=c.getString(c.getColumnIndex("_Facultyname"));
            String regno=c.getString(c.getColumnIndex("_ID"));
            if((name.equals(nam))&&(regno.equals(rno)))
            {
                return 1;
            }
            c.moveToNext();
        }
        return 0;
    }


    public String getsblist(String r){
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT "+Column_SBookList+","+Column_Reg+" FROM STUDENT";
        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();
        String blist="";
        while(!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex(Column_Reg)).equals(r))
            {
                blist+=c.getString(c.getColumnIndex(Column_SBookList));
                blist+="/n";
                return blist;

            }
        }
        return " ";
    }

    public String getfblist(String r){
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT "+Column_FBookList+","+Column_ID+" FROM FACULTY";
        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();
        String blist="";
        while(!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex(Column_ID)).equals(r))
            {
                blist+=c.getString(c.getColumnIndex(Column_FBookList));
                blist+="/n";
                return blist;

            }
        }
        return " ";
    }

}
