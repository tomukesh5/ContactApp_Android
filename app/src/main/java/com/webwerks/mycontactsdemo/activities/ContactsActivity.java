package com.webwerks.mycontactsdemo.activities;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.webwerks.mycontactsdemo.Model.ContactsList;
import com.webwerks.mycontactsdemo.R;
import com.webwerks.mycontactsdemo.adapter.ContactListAdapter;
import com.webwerks.mycontactsdemo.comman.CoreLog;
import com.webwerks.mycontactsdemo.utils.ContactSingleton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by webwerks on 24/01/18.
 */

public class ContactsActivity extends AppCompatActivity {


//    @BindView(R.id.recyclerview_contacts)
    private RecyclerView mRecyclerViewContact;

    LinearLayoutManager mLayoutManager;
    ContactListAdapter contactListAdapter;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

//        ButterKnife.bind(this);

        mRecyclerViewContact = (RecyclerView) findViewById(R.id.recyclerview_contacts);
        fetchContact();
        mContext = this;

    }

    public void fetchContact(){

        ContactSingleton.instance().callToFetchContact(CALLBACK_CONTACTLIST);
    }

    //method to load RecyclerView
    public void manageRecyclerView(List<ContactsList> contactsList){

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerViewContact.setLayoutManager(mLayoutManager);
        contactListAdapter = new ContactListAdapter(mContext,contactsList);
        mRecyclerViewContact.setAdapter(contactListAdapter);

    }

    Callback<List<ContactsList>> CALLBACK_CONTACTLIST = new Callback<List<ContactsList>>() {
        @Override
        public void onResponse(Call<List<ContactsList>> call, Response<List<ContactsList>> response) {

            List<ContactsList> contactsList = response.body();
            manageRecyclerView(contactsList);
        }

        @Override
        public void onFailure(Call<List<ContactsList>> call, Throwable t) {
            CoreLog.e("onFailure",""+t.getMessage());
        }
    };
}
