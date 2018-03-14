package krv10.mm.com.sample;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ParentViewHolder;

/**
 * Created by KRV 10 on 08-03-2018.
 */

public class PViewHolder extends ParentViewHolder {
    /**
     * Default constructor.
     *
     * @param itemView The {@link View} being hosted in this ViewHolder
     */

    TextView modulename;

    public PViewHolder(@NonNull View itemView) {
        super(itemView);

        modulename=itemView.findViewById(R.id.tv_modulename);
    }
}
