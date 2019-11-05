package com.example.smartpan_2_11.ui;


import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.smartpan_2_11.R;
import com.example.smartpan_2_11.model.ContactsInterface;
import com.example.smartpan_2_11.model.ContactsPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends Fragment implements ContactsInterface {

    private ListView lv_contacts;
    private ContactsPresenter contactsPresenter;


    public ContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        lv_contacts = view.findViewById(R.id.lv_contacts);
        contactsPresenter = new ContactsPresenter(this, getContext());
        contactsPresenter.getContacts();

        /*Cursor cursor = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null,null, null);
        getActivity().startManagingCursor(cursor);

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
                new SimpleCursorAdapter(getContext(), android.R.layout.simple_list_item_2, cursor, from, to);
        lv_contacts.setAdapter(simpleCursorAdapter);
        lv_contacts.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);*/

        return view;
    }

    @Override
    public void setContacts(SimpleCursorAdapter simpleCursorAdapter) {
        lv_contacts.setAdapter(simpleCursorAdapter);
        lv_contacts.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }
}
