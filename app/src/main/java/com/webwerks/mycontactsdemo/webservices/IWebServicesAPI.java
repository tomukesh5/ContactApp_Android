package com.webwerks.mycontactsdemo.webservices;

import com.webwerks.mycontactsdemo.Model.ContactsList;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by webwerks on 24/01/18.
 */

public interface IWebServicesAPI {

    @GET("users")
    Call<List<ContactsList>> fetchContact();
}
