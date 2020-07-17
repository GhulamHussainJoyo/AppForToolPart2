package com.example.appfortool_iba;


/***
 *
 * **********************          AUTHER OF APPLICATION       **********************
 * *******************           MR. GHULAM HUSSAIN JOYO       *******************
 * ****************            Contact No: 03068237508         *****************
 *
 *
 */


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.GridView;

import java.util.LinkedList;

public class main_layout_for_action extends AppCompatActivity
{
    public static DataBase_Of_Parts mDataBase;
    private int count=1;

    static GridView gridView;
  //  AlertController.RecycleListView
    static LinkedList<String[]> parts_list=new LinkedList<String[]>();
    static PartsAdapter partsAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout_for_action);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDataBase=new DataBase_Of_Parts(this);



        String[] temp=new String[4];
        temp[0]="head Lights";
        temp[1]="120";
        temp[2]="130";
        temp[3]="5";
       // temp[4]= String.valueOf(count);
        parts_list.add(temp);

       boolean check= mDataBase.isEmpty();


         Cursor cursor = mDataBase.ShowAllData();
          if (cursor.getCount() == 0)
          {
              showMessage("Error","Emty DataBasse");

          }
          else
          {


              while (cursor.moveToNext())
              {
                  parts_list.add(new String[4]);
                  parts_list.get(count)[0]=cursor.getString(1); //parts Name
                  parts_list.get(count)[1]=cursor.getString(2); //purchase
                  parts_list.get(count)[2]=cursor.getString(3); //sell
                  parts_list.get(count)[3]=cursor.getString(4); // total
                  count++;
              }
//              partsAdapter.notifyDataSetChanged();
//              gridView.setAdapter(partsAdapter);

          }




       // num 1 index of Table is  Name Of parts
        // num 2 index of Table is  sell price
        // num 3 index of Table is  purchase price
        // num 4 index of Table is  sold Items
        // num 5 index of Table is  Number of items

        // num 1 index of array is  Name Of parts
        // num 2 index of array is  sell price
        // num 3 index of array is  Number of items




            gridView=(GridView) findViewById(R.id.gridview);
            //recycleListView=(RecycleListView) findViewById(R.id.gridview);
            partsAdapter=new PartsAdapter(this,parts_list);
            gridView.setAdapter(partsAdapter);


        FloatingActionButton fab2 =findViewById(R.id.show_all);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=mDataBase.ShowAllData();
                if (res.getCount()==0)
                {
                    showMessage("Error","Nothing Found");
                    return;
                }
                else
                {
                    StringBuffer stringBuffer=new StringBuffer();
                    while (res.moveToNext())
                    {
                        stringBuffer.append("id : "+ res.getString(0)+"\n");
                        stringBuffer.append("name of parts : "+ res.getString(1)+"\n");
                        stringBuffer.append("purchase price : "+ res.getString(2)+"\n");
                        stringBuffer.append("sell price : "+ res.getString(3)+"\n");
                        stringBuffer.append("number of items : "+ res.getString(4)+"\n\n");
                    }

                    showMessage("Data",stringBuffer.toString());
                }
            }
        });




        FloatingActionButton fab = findViewById(R.id.fab_btn_Of_main_activity);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)

            {



                String[] temp=new String[4];
                parts_list.add(temp);
                Intent intent=new  Intent(getApplicationContext(),add_Items_For_Parts.class);
                intent.putExtra("parts_list_id",parts_list.size()-1);
                startActivity(intent);
            }
        });
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}
