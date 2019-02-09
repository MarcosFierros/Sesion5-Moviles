package com.iteso.sesion5;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.Arrays;

public class ActivityMain extends AppCompatActivity {

    private Alumno alumno;
    private EditText name_et, phone_et;
    private Spinner escolaridad_spinner;
    private RadioButton fem_rb, mas_rb;
    private AutoCompleteTextView libros_atv;
    private CheckBox sport_cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_et = findViewById(R.id.activity_main_name_et);
        phone_et = findViewById(R.id.activity_main_phone_et);
        escolaridad_spinner = findViewById(R.id.activity_main_escolaridad_spinner);
        fem_rb = findViewById(R.id.activity_main_fem_rb);
        mas_rb = findViewById(R.id.activity_main_mas_rb);
        libros_atv = findViewById(R.id.activity_main_libros_atv);
        sport_cb = findViewById(R.id.activity_main_sport_cb);

        String[] books = getResources().getStringArray(R.array.libros);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, books);
        libros_atv.setAdapter(adapter);
        libros_atv.setThreshold(1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater infalter = getMenuInflater();
        infalter.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_save:
                save();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void cleanButtonAction(View view) {
        clean();
    }

    public void save(){
        if(validate()) {
            alumno = new Alumno(name_et.getText().toString(), phone_et.getText().toString(), escolaridad_spinner.getSelectedItem().toString(),
                getGenero(), libros_atv.getText().toString(), getDeporte());

            Toast toast = Toast.makeText(getApplicationContext(),alumno.toString(),Toast.LENGTH_LONG);
            toast.show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    clean();
                }
            }, 4000);
        }
    }

    private boolean validate(){
        if(!name_et.getText().toString().trim().equalsIgnoreCase("")) {
            if(!phone_et.getText().toString().trim().equalsIgnoreCase(""))
                return true;
            else
                phone_et.setError(getResources().getString(R.string.error_phone_string));
        } else
            name_et.setError(getResources().getString(R.string.error_name_string));

        return false;
    }


    private void clean(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.alert_dialog_message);
        builder.setPositiveButton(R.string.alert_dialog_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                name_et.setText("");
                phone_et.setText("");
                escolaridad_spinner.setSelection(0);
                fem_rb.setChecked(true);
                mas_rb.setChecked(false);
                libros_atv.setText("");
                sport_cb.setChecked(false);
            }
        });
        builder.setNegativeButton(R.string.alert_dialog_cancelar, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private String getGenero(){
        if(fem_rb.isChecked())
            return getResources().getString(R.string.activity_main_fem_string);
        else if(mas_rb.isChecked())
            return getResources().getString(R.string.activity_main_mas_string);
        else
            return "ERROR";
    }

    private String getDeporte(){
        if(sport_cb.isChecked())
            return "Si";
        else
            return "No";
    }

}
