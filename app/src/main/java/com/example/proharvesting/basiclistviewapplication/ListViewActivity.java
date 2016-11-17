package com.example.proharvesting.basiclistviewapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    List<Contact> contacts;
    TextView editTextContactName;
    ListView listViewContacts;
    ContactAdapter contactAdapter;
    int consID=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initComponents();
        contactAdapter = new ContactAdapter(this,contacts);
        listViewContacts.setAdapter(contactAdapter);

    }
    public void initComponents(){
        contacts = new ArrayList<Contact>();
        editTextContactName = (EditText) findViewById(R.id.editTextContactName);
        listViewContacts=(ListView)findViewById(R.id.listViewContacts);

    }

    public void addContact(View view) {
        consID++;
        Contact contact = new Contact();
        contact.setIdx(consID);
        contact.setName(editTextContactName.getText().toString());
        contacts.add(contact);
        contactAdapter = new ContactAdapter(this,contacts);
        listViewContacts.setAdapter(contactAdapter);
        Log.d("Debuging","Contact added!");
    }
}
