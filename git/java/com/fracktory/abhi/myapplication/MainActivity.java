package com.fracktory.abhi.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText_userid;
    private EditText editText_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_userid = (EditText) findViewById(R.id.edittext_userid);
        editText_password = (EditText) findViewById(R.id.edittext_password);
        Button button_login = (Button) findViewById(R.id.button_login);
        Button button_register = (Button) findViewById(R.id.button_register);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
            }
        });
    }

    private void login() {
        String userId=editText_userid.getText().toString();
        String password=editText_password.getText().toString();
        SQLiteDBHelper dbHelper=new SQLiteDBHelper(getApplicationContext());
        SQLiteDatabase db=dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT *FROM "+SQLiteDBHelper.TABLE_NAME+" WHERE "+SQLiteDBHelper.COLUMN_ID+"=? AND" +
                " "+SQLiteDBHelper.COLUMN_PASS+"=?",new String[] {userId,password});
        if(cursor!=null)
        if(cursor.getCount()>0)
        {
            Toast.makeText(getApplicationContext(),"Login Successful!",Toast.LENGTH_SHORT).show();
            cursor.moveToFirst();
            String name=cursor.getString(cursor.getColumnIndex(SQLiteDBHelper.COLUMN_NAME));
            Intent intent=new Intent(getApplicationContext(),Welcome.class);
            intent.putExtra("NAME",name);
            startActivity(intent);
            cursor.close();
            finish();
        }
        else {

            Toast.makeText(getApplicationContext(),"Login Failed!",Toast.LENGTH_SHORT).show();
            cursor.close();
        }

    }
}
