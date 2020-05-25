package sg.edu.np.mad.mad_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addBtn;
    EditText editTask;
    RecyclerView rv;
    tdlAdapter adapter;
    ArrayList<ToDoTask> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBtn = findViewById(R.id.btn_add);
        editTask = findViewById(R.id.editText_task);
        rv = findViewById(R.id.recyclerView);

        data = new ArrayList<>();
        ToDoTask task = new ToDoTask();
        data.add(task);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Task = editTask.getText().toString().trim();
                showNewEntry(rv, data);
                addToList(data, Task, adapter);
            }
        });

        adapter = new tdlAdapter(data, MainActivity.this);
        rv.setAdapter(adapter);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setLayoutManager(layout);
        rv.setItemAnimator(new DefaultItemAnimator());
    }

    /**
     * Upon calling this method, the keyboard will retract
     * and the recyclerview will scroll to the last item
     *
     * @param rv RecyclerView for scrolling to
     * @param data ArrayList that was passed into RecyclerView
     */
    private void showNewEntry(RecyclerView rv, ArrayList data){
        //scroll to the last item of the recyclerview
        rv.scrollToPosition(data.size() - 1);

        //auto hide keyboard after entry
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(rv.getWindowToken(), 0);
        editTask.setText("");
    }

    private void addToList(ArrayList<ToDoTask> data, String Task,tdlAdapter adapter){
        ToDoTask task = new ToDoTask();
        task.Task = Task;
        data.add(task);
    }
}
