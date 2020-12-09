package com.example.helloworld;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<ChatBubble> {
    private Activity activity;
    private List<ChatBubble> messages;


    public MessageAdapter(Activity context, int resource, List<ChatBubble> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.messages = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        int layoutResource = 0;
        ChatBubble cb = getItem(position);
        if((position % 2) == 0){
            layoutResource = R.layout.right_chat_bubble;
        }
        else {
            layoutResource = R.layout.left_chat_bubble;
        }
        //layoutResource = R.layout.right_chat_bubble;

        if(convertView != null){
            holder = (ViewHolder) convertView.getTag();
        }
        else{
            convertView = inflater.inflate(layoutResource, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        holder.msg.setText(cb.getContent());
        return convertView;
    }

    public int getViewTypeCount () {
        return 2;
    }

    public int getItemViewType (int position) {
        return position % 2;
    }

    private class ViewHolder{
        private TextView msg;
        public ViewHolder(View v) {
            msg = (TextView) v.findViewById(R.id.txt_msg);
        }
    }

}
