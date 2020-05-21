package com.lz.d_livedata.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class NameViewModel extends AndroidViewModel {

    private MutableLiveData<String> currentName;

    public NameViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getCurrentName() {
        if (currentName == null) {
            currentName = new MutableLiveData<String>();
        }
        return currentName;
    }





}
