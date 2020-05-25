package sg.edu.np.mad.mad_recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class tdlViewHolder extends RecyclerView.ViewHolder {
    TextView txt;
    TextView deleteTxtMsg;
    ImageView deleteBin;
    public tdlViewHolder(@NonNull View v) {
        super(v);
        txt = v.findViewById(R.id.task);
        //deleteTxtMsg = v.findViewById(R.id.textView_delete_msg);
        //deleteBin = v.findViewById(R.id.imageView_bin);
    }
}
