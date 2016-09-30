package com.example.dima.timetablev03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Dima on 30.09.2016.
 */
public class LessonAdapter extends BaseAdapter {
    public LessonAdapter(Context context, List<Lesson> lessons) {
        this.context = context;
        this.lessons = lessons;
    }

    private Context context;
    private List<Lesson> lessons;


    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return lessons.size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return lessons.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.lesson_item, null);
        final TextView textViewPrepods=(TextView) view.findViewById(R.id.textViewPrepods);
        final TextView textViewKab=(TextView) view.findViewById(R.id.textViewKab);
        final TextView textViewLesson=(TextView) view.findViewById(R.id.textViewLesson);
        final TextView textViewTime=(TextView) view.findViewById(R.id.textViewTime);

        textViewPrepods.setText(lessons.get(position).getTeachers().toString());
        textViewKab.setText(lessons.get(position).getKab().toString());
        textViewLesson.setText(lessons.get(position).getLessonName().toString());
        textViewTime.setText(lessons.get(position).getTimeLesson().toString());
        return view;
    }


}
