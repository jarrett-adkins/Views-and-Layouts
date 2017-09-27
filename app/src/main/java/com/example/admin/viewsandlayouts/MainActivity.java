package com.example.admin.viewsandlayouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityLog";
    private EditText etFirstName;
    private EditText etLastName;
    List<Person> personList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
    }

    public void savePerson(View view) {
        //check activity_main.xml

        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();

        Person person = new Person( firstName, lastName );

        boolean isAdded = personList.add( person );

        if( isAdded )
            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show(); //This makes a little text pop up on the screen.
        else
            Toast.makeText(this, "Not Added", Toast.LENGTH_SHORT).show();
    }

    public void printPersons(View view) {
        for(Person p: personList) {
            Log.d(TAG, "printPersons: " + p.toString() );
        }
    }

    public void goToSecond(View view) {
        Intent intent = new Intent(this, SecondActivity.class);

        intent.putExtra("data", "This is the data");

        startActivity( intent );
    }
}
