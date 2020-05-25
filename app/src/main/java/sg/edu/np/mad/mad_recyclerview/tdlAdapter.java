package sg.edu.np.mad.mad_recyclerview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class tdlAdapter extends RecyclerView.Adapter<tdlViewHolder> {

    ArrayList<ToDoTask> data;
    TextView deleteTxtMsg;

    public tdlAdapter(ArrayList<ToDoTask> input, MainActivity mainActivity){
        data = input;
    }

    @NonNull
    @Override
    public tdlViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_to_do_task,parent,false);
        return new tdlViewHolder(v);
    }

    @Override
    public void onBindViewHolder(tdlViewHolder holder, final int position) {
        ToDoTask info = data.get(position);
        holder.txt.setText(info.Task);
        final String taskName = holder.txt.getText().toString().trim();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder deleteMsg = new AlertDialog.Builder(v.getContext());
                deleteMsg.setTitle("Delete");
                LayoutInflater inflater = LayoutInflater.from(v.getContext());
                View view = inflater.inflate(R.layout.dialog,null,false);
                deleteMsg.setView(view);



                deleteMsg.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                deleteMsg.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        data.remove(position);
                        notifyItemChanged(position);
                    }
                });
                deleteTxtMsg = view.findViewById(R.id.textView_delete_msg);
                deleteTxtMsg.setText("'"+taskName+"' ?");
                deleteMsg.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
