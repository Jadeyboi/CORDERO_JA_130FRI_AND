package com.example.myapplication;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private EditText editText;
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewItems);
        editText = findViewById(R.id.editTextItem);
        items = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.textViewItem, items);

        listView.setAdapter(adapter);

        findViewById(R.id.editTextItem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemText = editText.getText().toString();
                if (!itemText.isEmpty()) {
                    items.add(itemText);
                    editText.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showPopupMenu(view, position);
                return true;
            }
        });
    }

    private void showPopupMenu(View view, final int position) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.context_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.edit:
                    // Handle edit action
                    editText.setText(items.get(position));
                    items.remove(position);
                    adapter.notifyDataSetChanged();
                    return true;
                case R.id.delete:
                    // Handle delete action
                    items.remove(position);
                    adapter.notifyDataSetChanged();
                    return true;
                default:
                    return false;
            }
        });
        popupMenu.show();
    }
}
