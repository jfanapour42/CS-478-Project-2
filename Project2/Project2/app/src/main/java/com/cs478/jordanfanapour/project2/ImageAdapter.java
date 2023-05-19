package com.cs478.jordanfanapour.project2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private static final int PADDING = 8;
    private static final int WIDTH = 480;
    private static final int HEIGHT = 645;
    private Context mContext;          // This will have to be passed to the ImageView
    private List<Integer> mThumbIds;   // Adapter must store AdapterView's items

    private List<String> carNames;

    // Save the list of image IDs and the context
    public ImageAdapter(Context c, List<Integer> ids, List<String> names) {
        mContext = c;
        this.mThumbIds = ids;
        this.carNames = names;
    }

    // Now the methods inherited from abstract superclass BaseAdapter

    // Return the number of items in the Adapter
    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    // Return the data item at position
    @Override
    public Object getItem(int position) {
        return mThumbIds.get(position);
    }

    // Will get called to provide the ID that
    // is passed to OnItemClickListener.onItemClick()
    @Override
    public long getItemId(int position) {
        return mThumbIds.get(position);
    }

    // Return an ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater li = LayoutInflater.from(mContext);
            convertView = li.inflate(R.layout.grid_cell,null);
            holder.textView= convertView.findViewById(R.id.text);
            holder.imageView= convertView.findViewById(R.id.image);
            holder.imageView.getLayoutParams().width = WIDTH;
            holder.imageView.getLayoutParams().height = HEIGHT;
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageView.setImageResource(mThumbIds.get(position));
        holder.textView.setText(carNames.get(position));
        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
