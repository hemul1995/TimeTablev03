package com.example.dima.timetablev03;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyTask mt;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase sdb;

    private int isBase(){
        int res = 0;
        try{


            Cursor cursor = sdb.rawQuery("select * from isBase", null);
            while(cursor.moveToNext()){
                res = cursor.getInt(cursor.getColumnIndex("id"));
            }

        }
        catch(Exception er) {
            res = 0;
        }
        finally {
            return res;
        }
        //return res;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //пропуск, ели интернет не включен, или бд уже создана и заполнена
        databaseHelper = new DatabaseHelper(this, "mydatabase.db", null, 2);
        sdb = databaseHelper.getReadableDatabase();


        if(isBase() == 1)
        {

        }
        else{
            mt = new MyTask();
            mt.execute();
        }


        //
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    /*public void onClick6(View view){
        try{
            sdb.execSQL("delete from TimeLessons");
            sdb.execSQL("delete from isBase");
        }
        catch (Exception er){
            Toast.makeText(getApplicationContext(), "w", Toast.LENGTH_SHORT).show();
        }

    }*/

    public void onClick1(View view){
        ListView listView = (ListView) findViewById(R.id.listView);
        String kab, lessonname, teachers, timelesson;
        List<Lesson> lessons = new ArrayList<>();
        Cursor cursor = sdb.rawQuery("select * from TimeLessons " +
                "where day = 'Понедельник' " +
                "order by time;", null);
        while(cursor.moveToNext()){
            kab = cursor.getString(cursor.getColumnIndex("kab"));
            lessonname = cursor.getString(cursor.getColumnIndex("lesson"));
            teachers = cursor.getString(cursor.getColumnIndex("teacher1"));
            teachers += "\n" + cursor.getString(cursor.getColumnIndex("teacher2"));
            timelesson = cursor.getString(cursor.getColumnIndex("time"));
            lessons.add(new Lesson(kab, lessonname, teachers, timelesson));
        }
        listView.setAdapter(new LessonAdapter(this, lessons));
    }

    public void onClick2(View view){
        ListView listView = (ListView) findViewById(R.id.listView);
        String kab, lessonname, teachers, timelesson;
        List<Lesson> lessons = new ArrayList<>();
        Cursor cursor = sdb.rawQuery("select * from TimeLessons " +
                "where day = 'Вторник' " +
                "order by time;", null);
        while(cursor.moveToNext()){
            kab = cursor.getString(cursor.getColumnIndex("kab"));
            lessonname = cursor.getString(cursor.getColumnIndex("lesson"));
            teachers = cursor.getString(cursor.getColumnIndex("teacher1"));
            teachers += "\n" + cursor.getString(cursor.getColumnIndex("teacher2"));
            timelesson = cursor.getString(cursor.getColumnIndex("time"));
            lessons.add(new Lesson(kab, lessonname, teachers, timelesson));
        }
        listView.setAdapter(new LessonAdapter(this, lessons));
    }
    public void onClick3(View view){
        ListView listView = (ListView) findViewById(R.id.listView);
        String kab, lessonname, teachers, timelesson;
        List<Lesson> lessons = new ArrayList<>();
        Cursor cursor = sdb.rawQuery("select * from TimeLessons " +
                "where day = 'Среда' " +
                "order by time;", null);
        while(cursor.moveToNext()){
            kab = cursor.getString(cursor.getColumnIndex("kab"));
            lessonname = cursor.getString(cursor.getColumnIndex("lesson"));
            teachers = cursor.getString(cursor.getColumnIndex("teacher1"));
            teachers += "\n" + cursor.getString(cursor.getColumnIndex("teacher2"));
            timelesson = cursor.getString(cursor.getColumnIndex("time"));
            lessons.add(new Lesson(kab, lessonname, teachers, timelesson));
        }
        listView.setAdapter(new LessonAdapter(this, lessons));
    }
    public void onClick4(View view){
        ListView listView = (ListView) findViewById(R.id.listView);
        String kab, lessonname, teachers, timelesson;
        List<Lesson> lessons = new ArrayList<>();
        Cursor cursor = sdb.rawQuery("select * from TimeLessons " +
                "where day = 'Четверг' " +
                "order by time;", null);
        while(cursor.moveToNext()){
            kab = cursor.getString(cursor.getColumnIndex("kab"));
            lessonname = cursor.getString(cursor.getColumnIndex("lesson"));
            teachers = cursor.getString(cursor.getColumnIndex("teacher1"));
            teachers += "\n" + cursor.getString(cursor.getColumnIndex("teacher2"));
            timelesson = cursor.getString(cursor.getColumnIndex("time"));
            lessons.add(new Lesson(kab, lessonname, teachers, timelesson));
        }
        listView.setAdapter(new LessonAdapter(this, lessons));
    }
    public void onClick5(View view){
        ListView listView = (ListView) findViewById(R.id.listView);
        String kab, lessonname, teachers, timelesson;
        List<Lesson> lessons = new ArrayList<>();
        Cursor cursor = sdb.rawQuery("select * from TimeLessons " +
                "where day = 'Пятница' " +
                "order by time;", null);
        while(cursor.moveToNext()){
            kab = cursor.getString(cursor.getColumnIndex("kab"));
            lessonname = cursor.getString(cursor.getColumnIndex("lesson"));
            teachers = cursor.getString(cursor.getColumnIndex("teacher1"));
            teachers += "\n" + cursor.getString(cursor.getColumnIndex("teacher2"));
            timelesson = cursor.getString(cursor.getColumnIndex("time"));
            lessons.add(new Lesson(kab, lessonname, teachers, timelesson));
        }
        listView.setAdapter(new LessonAdapter(this, lessons));
    }
    public void onClick6(View view){
        ListView listView = (ListView) findViewById(R.id.listView);
        String kab, lessonname, teachers, timelesson;
        List<Lesson> lessons = new ArrayList<>();
        Cursor cursor = sdb.rawQuery("select * from TimeLessons " +
                "where day = 'Суббота' " +
                "order by time;", null);
        while(cursor.moveToNext()){
            kab = cursor.getString(cursor.getColumnIndex("kab"));
            lessonname = cursor.getString(cursor.getColumnIndex("lesson"));
            teachers = cursor.getString(cursor.getColumnIndex("teacher1"));
            teachers += "\n" + cursor.getString(cursor.getColumnIndex("teacher2"));
            timelesson = cursor.getString(cursor.getColumnIndex("time"));
            lessons.add(new Lesson(kab, lessonname, teachers, timelesson));
        }
        listView.setAdapter(new LessonAdapter(this, lessons));
    }

    class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //tvInfo.setText("Begin");
        }

        @Override
        protected Void doInBackground(Void... params) {
            //databaseHelper = new DatabaseHelper(this, "mydatabase.db", null, 1);


            try
            {
                new BDParser(sdb, "http://ciu.nstu.ru/student/time_table_view?idgroup=22329&fk_timetable=28751");
            }
            catch(Exception er)
            {
                Toast.makeText(getApplicationContext(), "w", Toast.LENGTH_SHORT).show();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            //tvInfo.setText("End");
        }
    }
}
