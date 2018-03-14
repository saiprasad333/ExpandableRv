package krv10.mm.com.sample;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ChildViewHolder;

/**
 * Created by KRV 10 on 08-03-2018.
 */

public class CViewHolder extends ChildViewHolder {
    /**
     * Default constructor.
     *
     * @param itemView The {@link View} being hosted in this ViewHolder
     */
    TextView tv;

    public CViewHolder(@NonNull View itemView) {
        super(itemView);
        tv=itemView.findViewById(R.id.tv);
    }
}
