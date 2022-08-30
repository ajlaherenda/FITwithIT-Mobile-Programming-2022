package com.example.fitwithit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HomepageItemAdapter extends BaseAdapter {
    private List<HomepageItem> itemList;
    private Context context;

    public HomepageItemAdapter(List<HomepageItem> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return itemList.indexOf(itemList.get(i));
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater=LayoutInflater.from(context);
        view= inflater.inflate(R.layout.listviewforhomepage,viewGroup,false);
        HomepageItem homepageItem=itemList.get(i);

        ImageView image=view.findViewById(R.id.itemImage);
        TextView title=view.findViewById(R.id.itemTitle);
        TextView description=view.findViewById(R.id.itemDesc);
        image.setImageResource(homepageItem.getImageResID());
        title.setText(homepageItem.getTitle());
        description.setText(homepageItem.getDesc());
        return view;
    }
}
