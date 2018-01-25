package com.webwerks.mycontactsdemo.utils;


import com.webwerks.mycontactsdemo.Model.ContactsList;
import com.webwerks.mycontactsdemo.app.ContactApp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by webwerks on 24/01/18.
 */

public class ContactSingleton {

    private static ContactSingleton instance;

    private ContactSingleton(){}

    public static ContactSingleton instance()
    {
        if(instance == null){
            instance = new ContactSingleton();
        }
        return instance;
    }

    public void callToFetchContact(Callback callback){
        Call<List<ContactsList>> call= ContactApp.instance().getApi().fetchContact();
        call.enqueue(callback);
    }

}
