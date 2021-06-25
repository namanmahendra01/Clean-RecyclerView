package com.naman.cleanrecyclerview.interfaces;

import android.view.View;

public interface onItemClickListener {
    void onClick(View v,int position,String data);
    void onImageClicked();
}
