package com.example.proharvesting.basiclistviewapplication;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends BaseAdapter  {
    private Activity activity;
    private List<Contact> contactList;
    private static LayoutInflater inflater=null;
    public ContactAdapter(Activity activity, List<Contact> contactList) {
        this.activity = activity;
        this.contactList=contactList;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public int getCount() {
        return contactList.size();
    }
    public Object getItem(int position) {
        return position;
    }
    public long getItemId(int position) {
        return position;
    }
    public static class ViewHolderRowContact{
        public TextView textViewConsID;
        public TextView textViewName;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        ViewHolderRowContact holder;
        if(convertView==null){
            vi = inflater.inflate(R.layout.fragment_contact_adapter, null);
            holder = new ViewHolderRowContact();
            holder.textViewConsID=(TextView)vi.findViewById(R.id.textViewConsID);
            holder.textViewName=(TextView)vi.findViewById(R.id.textViewName);
            vi.setTag( holder );
        }
        else
            holder=(ViewHolderRowContact)vi.getTag();
        holder.textViewConsID.setText(""+contactList.get(position).getIdx());
        holder.textViewName.setText(""+contactList.get(position).getName());
        return vi;
    }
}
