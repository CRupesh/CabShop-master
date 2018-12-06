package com.cabshop.my.cabshop;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemListAdapter extends BaseAdapter {

    Context context;
    List<RowItem> rowItems;

    public ItemListAdapter(Context context, List<RowItem> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }

    private class ViewHolder {
        ImageView item_image;
        TextView itemTitle;
        TextView itemPrice;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();
            holder.itemPrice = (TextView) convertView.findViewById(R.id.item_price);
            holder.itemTitle = (TextView) convertView.findViewById(R.id.item_title);
            holder.item_image = (ImageView) convertView.findViewById(R.id.item_image);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        RowItem rowItem = (RowItem) getItem(position);

        Typeface title_face;
        title_face = Typeface.createFromAsset(context.getAssets(), "font1.otf");
        holder.itemTitle.setTypeface(title_face);
        holder.itemPrice.setTypeface(title_face);

        holder.itemTitle.setText(rowItem.getTitle());
        holder.itemPrice.setText(rowItem.getPrice());
        holder.item_image.setImageResource(rowItem.getImageId());

        return convertView;

    }
}
