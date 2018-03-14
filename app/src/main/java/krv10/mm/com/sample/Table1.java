package krv10.mm.com.sample;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KRV 10 on 10-03-2018.
 */

public class Table1 {


    @SerializedName("Table1")
    List<Model> model;

    public List<Model> getModel() {
        return model;
    }

    public void setModel(List<Model> model) {
        this.model = model;
    }
}
