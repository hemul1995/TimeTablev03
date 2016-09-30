package com.example.dima.timetablev03;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dima on 30.09.2016.
 */
public class BDParser {
    public BDParser(SQLiteDatabase db, String URL) throws IOException, ClassNotFoundException, SQLException {
        List<String> days = new ArrayList<>();
        List<String> times = new ArrayList<>();
        List<String> odds = new ArrayList<>();
        List<String> lessons = new ArrayList<>();
        List<String> teacher1 = new ArrayList<>();
        List<String> teacher2 = new ArrayList<>();
        List<String> kabs = new ArrayList<>();
        //Validate.isTrue(args.length == 1, "usage: supply url to fetch");


        Document doc = Jsoup.connect(URL).get();
        Elements links = doc.select("td");
        Elements href = doc.select("a[href]");
//        for(Element e : links1)
//        {
//
//        }
        //href.forEach((Element e) ->  System.out.println(e.attr("abs:href")));
        ///Elements media = doc.select("[src]");
        //Elements imports = doc.select("link[href]");

        int i = 0;
        for (i = 0; i < links.size(); i++)
        {
            if(links.get(i).text().contains("Аудитория"))
            {
                i++;
                break;
            }
        }
        String day = "";
        String time = "";
        String odd = "";
        int k = 0;
        int iday = 0;
        try{
            for (; i < links.size(); i++)
            {
                Pattern p = Pattern.compile("(Понедельник|Вторник|Среда|Четверг|Пятница|Суббота)");
                Matcher m = p.matcher(links.get(i).text());
                if(m.matches() == true)
                {
                    day = links.get(i).text();
                }
                else
                {
                    p = Pattern.compile("\\d\\d:\\d\\d - \\d\\d:\\d\\d");
                    m = p.matcher(links.get(i).text());
                    if(m.matches() == true)
                    {
                        time = links.get(i).text();
                    }
                    else
                    {
                        days.add(day);
                        times.add(time);
                        if(links.get(i).text().length() <=3)
                        {
                            odd = links.get(i).text().toString();
                            odds.add(links.get(i).text());
                        }
                        else
                        {
                            odds.add(odd);
                            i --;
                        }

                        Elements hrefq = links.get(i+1).select("a[href]");
                        //hrefq.forEach((Element e) ->  System.out.print(e.attr("abs:href")));
                        switch(hrefq.size())
                        {
                            case 0: teacher1.add(""); teacher2.add(""); break;
                            case 1: teacher1.add(hrefq.get(0).text()); teacher2.add(""); break;
                            case 2: teacher1.add(hrefq.get(0).text()); teacher2.add(hrefq.get(1).text());
                        }

                        lessons.add(links.get(i+1).ownText());
                        kabs.add(links.get(i+2).text());
                        i+=2;
                    }
                }
            }
        }
        catch(Exception ex){}
        db.execSQL("insert into isBase(id) values(1);");
        for(int j = 0; j < days.size(); j++)
        {
            db.execSQL("insert into " +
                    "TimeLessons" +
                    "(" +
                    "day, time, lesson, teacher1, teacher2, kab, odd" +
                    ")" +
                    "values(" +
                    "'" +
                    days.get(j).toString() +
                    "', " +
                    "'" +
                    times.get(j).toString() +
                    "', " +
                    "'" +
                    lessons.get(j).toString() +
                    "', " +
                    "'" +
                    teacher1.get(j) +
                    "', " +
                    "'" +
                    teacher2.get(j) +
                    "', " +
                    "'" +
                    kabs.get(j) +
                    "', " +
                    "'" +
                    odds.get(j) +
                    "'" +
                    ");");
            //System.out.println("|||" + days.get(j) + "|||" + times.get(j) + "|||" + odds.get(j) + "|||" + lessons.get(j) + "|||" + kabs.get(j) + "|||" + teacher1.get(j) + "|||" + teacher2.get(j) + "|||");
        }


        //
    }

}
