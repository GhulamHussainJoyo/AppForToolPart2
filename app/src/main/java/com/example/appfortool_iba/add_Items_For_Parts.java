package com.example.appfortool_iba;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import static com.example.appfortool_iba.main_layout_for_action.gridView;
import static com.example.appfortool_iba.main_layout_for_action.partsAdapter;
import static com.example.appfortool_iba.main_layout_for_action.parts_list;


public class add_Items_For_Parts extends AppCompatActivity
{
    private int parts_list_id;
    private EditText nameOfPartsForInput1,nameOfPartsForInput2,nameOfPartsForInput3,nameOfPartsForInput4;


    String[] temp=new String[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__items__for__parts);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent i=getIntent();
        parts_list_id=i.getIntExtra("parts_list_id",-1);

        nameOfPartsForInput1= findViewById(R.id.nameOfPartsForInput1);
        nameOfPartsForInput2= findViewById(R.id.nameOfPartsForInput2);
        nameOfPartsForInput3= findViewById(R.id.nameOfPartsForInput3);
        nameOfPartsForInput4= findViewById(R.id.nameOfPartsForInput4);


        if (parts_list_id!= -1) {


            nameOfPartsForInput1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                    String local = String.valueOf(charSequence);
                    temp[0]=local;
                    parts_list.get(parts_list_id)[0]=local;
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            nameOfPartsForInput2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                    String local=String.valueOf(charSequence);
                    temp[1]=local;
                    parts_list.get(parts_list_id)[1]=local;
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            nameOfPartsForInput3.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                    String local=String.valueOf(charSequence);
                    temp[2]=local;
                    parts_list.get(parts_list_id)[2]=local;
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            nameOfPartsForInput4.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                    String local=String.valueOf(charSequence);
                    temp[3]=local;
                    parts_list.get(parts_list_id)[3]=local;
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

        }
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //main_layout_for_action.mDataBase.InsertData(temp[0],temp[1],temp[2],temp[3]);

                partsAdapter.notifyDataSetChanged();
                gridView.setAdapter(partsAdapter);
               // Intent intent=new Intent(new Intent(getApplicationContext(),main_layout_for_action.class));
                finish();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

}
