package com.display.doorframe.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.display.doorframe.R;
import com.display.doorframe.ui.activity.CategoryActivity;

/**
 * Created by Jun on 2015/4/15.
 */
public class CategoryFragment extends Fragment {

    private ListView sortLv;
    private View view;

    private String[] value = new String[]{
            "门框","门"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sort,container,false);

        sortLv = (ListView) view.findViewById(R.id.sort_lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_list_item_1, value);
        sortLv.setAdapter(adapter);

        sortLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intentDoorFrame = new Intent(view.getContext(), CategoryActivity.class);
                        intentDoorFrame.putExtra("category","frame");
                        startActivity(intentDoorFrame);
                        break;
                    case 1:
                        Intent intentDoor = new Intent(view.getContext(), CategoryActivity.class);
                        intentDoor.putExtra("category","door");
                        startActivity(intentDoor);
                        break;
                }
            }
        });

        return view;
    }
}
