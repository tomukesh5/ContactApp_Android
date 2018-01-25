package com.webwerks.mycontactsdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.webwerks.mycontactsdemo.Model.ContactsList;
import com.webwerks.mycontactsdemo.R;
import com.webwerks.mycontactsdemo.activities.ContactDetailActivity;
import com.webwerks.mycontactsdemo.comman.Constant;

import java.util.List;

/**
 * Created by webwerks on 24/01/18.
 */

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder>  {

    private Context mContext;
    View mView;
    ContactListAdapter.ViewHolder mViewHolder;
    TextView textView;
    String TAG = "ContactListAdapter";

    private List<ContactsList> contactsList;

    public ContactListAdapter(Context context, List<ContactsList> contactsList) {

        this.mContext = context;
        this.contactsList = contactsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.item_addresses_list, parent, false);
        mViewHolder = new ContactListAdapter.ViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (this.contactsList.size() > 0) {

            final ContactsList contact = this.contactsList.get(position);
            holder.mTextViewName.setText(contact.getName());
            holder.mTextViewPhone.setText(contact.getPhone());

            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(mContext, ContactDetailActivity.class);
                    intent.putExtra(Constant.KEYCONTACT_INFO,contact);
                    mContext.startActivity(intent);

                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextViewName;
        public TextView mTextViewPhone;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.card_view);
            mTextViewName = itemView.findViewById(R.id.textView3);
            mTextViewPhone = itemView.findViewById(R.id.textView4);
        }
    }


}
