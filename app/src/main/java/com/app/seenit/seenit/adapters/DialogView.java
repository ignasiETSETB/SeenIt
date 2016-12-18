package com.app.seenit.seenit.adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import com.app.seenit.seenit.beans.SeenItBean;
import com.app.seenit.seenit.beans.SerieBean;
import com.app.seenit.seenit.com.app.seenit.seenit.activity.TitleScreen;
import com.app.seenit.seenit.utils.Utils;
import com.app.seenit.seenit.utils.VariableShare;

import java.util.ArrayList;

/**
 * Created by Isangi on 18/12/2016.
 */

public class DialogView extends DialogFragment {

    final CharSequence[] items={"Edit","Delete"};
    String selection;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        builder.setTitle("What you want to do?").setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                switch(i){
                    case 0://Edit

                        break;

                    case 1://Delete
                        ArrayList<SerieBean> seenItBeanArray= SeenItBean.getInstance().getSerieArray();
                        seenItBeanArray.remove(VariableShare.getInstance().getClickedItemOptions());
                        SeenItBean.getInstance().setSerieArray(seenItBeanArray);
                        Utils.saveData();
                        TitleScreen.refreshAdapter();
                        break;
                }

            }
        });


        return builder.create();
    }
}
