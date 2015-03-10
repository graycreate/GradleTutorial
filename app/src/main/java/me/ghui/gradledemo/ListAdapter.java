package me.ghui.gradledemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by jpardogo on 22/03/2014.
 */
public class ListAdapter extends ArrayAdapter<String> implements
        View.OnClickListener {
    private Context mContext;
    private List<String> mItems;

    public ListAdapter(Context context, List<String> items) {
        super(context, 0, items);
        mContext = context;
        mItems = items;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public String getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text.setText( getItem(position));
        holder.text.setOnClickListener(ListAdapter.this);
        return convertView;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(mContext, "onClick", Toast.LENGTH_SHORT).show();
        mContext.startActivity(new Intent(mContext, ImgViewer.class));
    }

    static class ViewHolder {
        @InjectView(R.id.tv_name)
        TextView text;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
