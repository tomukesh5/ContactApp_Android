package com.webwerks.mycontactsdemo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.webwerks.mycontactsdemo.Model.ContactsList;
import com.webwerks.mycontactsdemo.R;
import com.webwerks.mycontactsdemo.comman.Constant;

import butterknife.BindView;


/**
 * Created by webwerks on 24/01/18.
 */

public class ContactDetailActivity extends AppCompatActivity {

    private TextView mTextViewEmail;
    private TextView mTextViewStreet;
    private TextView mTextViewCity;

    private ContactsList contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        mTextViewEmail = (TextView) findViewById(R.id.textView);
        mTextViewStreet = (TextView) findViewById(R.id.textView2);
        mTextViewCity = (TextView) findViewById(R.id.textView5);

        contact = (ContactsList) getIntent().getSerializableExtra(Constant.KEYCONTACT_INFO);

        mTextViewEmail.setText(contact.getName());
        mTextViewStreet.setText(contact.getEmail());
        mTextViewCity.setText(contact.getAddress().getCity());
    }
}
