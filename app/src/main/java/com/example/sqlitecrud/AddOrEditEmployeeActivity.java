package com.example.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitecrud.model.Employee;
import com.example.sqlitecrud.sqlite.EmployeeDao;

public class AddOrEditEmployeeActivity extends AppCompatActivity
        implements View.OnClickListener {
    private EditText etEmployeeId_338, etName_338, etSalary_338;
    private Button btnSave_338;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or_edit_employee);

        etEmployeeId_338 = findViewById(R.id.etEmployeeId_338);
        etName_338 = findViewById(R.id.etName_338);
        etSalary_338 = findViewById(R.id.etSalary_338);

       btnSave_338 = findViewById(R.id.btnSave_338);
       btnSave_338.setOnClickListener(this);

       findViewById(R.id.btnListEmployees_338).setOnClickListener(this);

        readEmployee();
    }
    private void readEmployee(){
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        if(bundle == null){
            return;
        }
        String id = bundle.getString("id");

        EmployeeDao dao = new EmployeeDao(this);
        Employee emp =  dao.getById(id);

        etEmployeeId_338.setText(emp.getId_338());
        etName_338.setText(emp.getName_338());
        etSalary_338.setText("" + emp.getSalary_338());

        btnSave_338.setText("Update");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSave_338:
                EmployeeDao dao  = new EmployeeDao(this);
                Employee emp = new Employee();

                emp.setId_338(etEmployeeId_338.getText().toString());
                emp.setName_338(etName_338.getText().toString());
                emp.setSalary_338(Float.parseFloat(etSalary_338.getText().toString()));

                if(btnSave_338.getText().equals("Save")) {
                    dao.insert(emp);
                }else{
                    dao.update(emp);
                }
                Toast.makeText(this, "New employees has been saved!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}