package myapplication.app1.todolist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by admin on 2/11/2018.
 */

public class Database extends SQLiteOpenHelper{


    static final private String Db_Name = "ToDoList";
    static final private String Db_Table1 = "Task";
    static final private String Db_Table2 = "Event";
    static final private String Db_Table3 = "Meeting";
    static final private int Db_ver =1;
    Context context1;
    Toast toast;
    SQLiteDatabase Todo;
    private  static final String var1 = ("create table "+Db_Table2+"(Event text,Time text,Description text);");
    private  static final String var2 = ("create table "+Db_Table3+"(Venue text,Time text,Description text);");

    public Database(Context context) {
        super(context,Db_Name, null,Db_ver);
        context1=context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+Db_Table1+"(Title text,Description text);");
        //sqLiteDatabase.execSQL("create table "+Db_Table2+"(Event text,Time text,Description text);");
        sqLiteDatabase.execSQL(var1);
        sqLiteDatabase.execSQL(var2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertTaskData(String s1,String s2)
    {
        Todo = getWritableDatabase();
        Todo.execSQL("insert into "+Db_Table1+" (Title,Description) values('"+s1+"','"+s2+"');");
        toast.makeText(context1,"Task Created",Toast.LENGTH_LONG).show();
    }

    public void insertEventData(String s1,String s2,String s3)
    {
        Todo = getWritableDatabase();
        Todo.execSQL("insert into "+Db_Table2+" (Event,Time,Description) values('"+s1+"','"+s2+"','"+s3+"');");
        toast.makeText(context1,"Event Created",Toast.LENGTH_LONG).show();
    }


    public void insertMeetingData(String s1,String s2,String s3)
    {
        Todo = getWritableDatabase();
        Todo.execSQL("insert into "+Db_Table3+" (Venue,Time,Description) values('"+s1+"','"+s2+"','"+s3+"');");
        toast.makeText(context1,"Meeting Created",Toast.LENGTH_LONG).show();
    }

    public StringBuilder getData()
    {
        Todo=getReadableDatabase();
        Cursor cr = Todo.rawQuery("Select * from "+Db_Table1,null);
        StringBuilder str = new StringBuilder();
        while(cr.moveToNext())
        {
            String s1 = cr.getString(0);
            String s2 = cr.getString(1);
            str.append(s1+"\n"+s2+"\n");
        }
        toast.makeText(context1,str.toString(),Toast.LENGTH_LONG).show();
        return str;
    }
}


