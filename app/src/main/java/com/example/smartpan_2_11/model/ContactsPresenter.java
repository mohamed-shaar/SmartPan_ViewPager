package com.example.smartpan_2_11.model;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.widget.SimpleCursorAdapter;

public class ContactsPresenter {
    private ContactsInterface contactsInterface;
    private Context context;

    public ContactsPresenter(ContactsInterface contactsInterface, Context context) {
        this.contactsInterface = contactsInterface;
        this.context = context;
    }

    public void getContacts(){
        Cursor cursor = ((Activity) context).getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null,null, null);
        ((Activity) context).startManagingCursor(cursor);

        String[] from = {
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone._ID
        };

        int[] to = {
                android.R.id.text1,
                android.R.id.text2
        };

        SimpleCursorAdapter simpleCursorAdapter =
                new SimpleCursorAdapter(context, android.R.layout.simple_list_item_2, cursor, from, to);
        contactsInterface.setContacts(simpleCursorAdapter);
    }
}
