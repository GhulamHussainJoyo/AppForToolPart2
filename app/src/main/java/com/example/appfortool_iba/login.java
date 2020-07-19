package com.example.appfortool_iba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;





import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class login extends AppCompatActivity {

    private final String tableName="USERDATA";

    private DataBase_Of_Parts mDatabase;

   // private LoginButton facebook_button;
    private Button facebook_login_btn_custom,signIN;
    private TextView sign_up_textView;
    private EditText email,password;



    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);






        HashMap<String , Object> map=new HashMap<>();
        map.put("Abbal","Joyo");
        map.put("MyParts","Ready");
        //FirebaseDatabase.getInstance().getReference().child("User").child("Multiple values").updateChildren(map);


        //FirebaseDatabase.getInstance().getReference().child("abbal").child("Anfroid").setValue("ABCD");

         pd=new ProgressDialog(this);


        final String[] loginArray=new String[2];
        final int[] temp=new int[4];




        mDatabase=new DataBase_Of_Parts(this);

        signIN=findViewById(R.id.signIn_btn);

        email=findViewById(R.id.Email);
        password=findViewById(R.id.Password);


        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {





            }

            @Override
            public void afterTextChanged(Editable s) {


                String local=String.valueOf(s);
                loginArray[0]=local;

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

                String local=String.valueOf(s);
                loginArray[1]=local;
            }
        });




        signIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


//                DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
//
//                HashMap<String,String> map=new HashMap();
//                map.put("Abi","almd");
//                myRef.push().setValue(map);

            }
        });





         sign_up_textView=(TextView) findViewById(R.id.signUp_textview);

        sign_up_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),signUp_page.class);
                startActivity(intent);
            }
        });









    }

    public void onClickSIGNUP(View view)
    {
        if(view == sign_up_textView)
        {
            sign_up_textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(getApplicationContext(),signUp_page.class);
                    startActivity(intent);
                }
            });
        }
    }

    public void onClickFacebookButton(View view)
    {
        if(view == facebook_login_btn_custom)
        {
           // facebook_button.performClick();
        }
    }


    public boolean checkEmailValidation(String mail)
    {

        try
        {

            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher matcher = pattern.matcher(mail);
            return matcher.matches();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


    public void loginUser()
    {


    }
}
