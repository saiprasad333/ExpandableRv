package krv10.mm.com.sample;

import com.bignerdranch.expandablerecyclerview.model.*;
import com.bignerdranch.expandablerecyclerview.model.Parent;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KRV 10 on 07-03-2018.
 */


public class Model implements Parent<Datum> {

    String ModuleName;
    String ModuleNo;
    @SerializedName("Data")
    List<Datum> data;

    public String getModuleName() {
        return ModuleName;
    }

    public void setModuleName(String moduleName) {
        ModuleName = moduleName;
    }

    public String getModuleNo() {
        return ModuleNo;
    }

    public void setModuleNo(String moduleNo) {
        ModuleNo = moduleNo;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    @Override
    public List<Datum> getChildList() {
        return data;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return true;
    }
}
