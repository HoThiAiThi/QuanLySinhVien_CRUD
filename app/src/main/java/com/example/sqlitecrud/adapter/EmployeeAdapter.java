package com.example.sqlitecrud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sqlitecrud.R;
import com.example.sqlitecrud.model.Employee;

import java.util.List;

public class EmployeeAdapter extends BaseAdapter {
    private Context context_338;
    private List<Employee> list_338;

    public EmployeeAdapter(Context context_338, List<Employee> list_338) {
        this.context_338 = context_338;
        this.list_338 = list_338;
    }

    @Override
    public int getCount() {
        return list_338.size();
    }

    @Override
    public Object getItem(int iPosition) {
        return list_338.get(iPosition);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context_338).inflate(R.layout.layout_employee_item, null);
        }

        TextView tvName_338 = view.findViewById(R.id.tvName_338);
        TextView tvSalary_338 = view.findViewById(R.id.tvSalary_338);

        Employee emp = list_338.get(i);
        tvName_338.setText(emp.getName_338());
        tvSalary_338.setText("" + emp.getSalary_338());

        return view;
    }
}
