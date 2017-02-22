package com.ebookfrenzy.myapplication455;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

/**
 * Created by sergio on 2/22/2017.
 */

public class ToolBarFragment extends android.support.v4.app.Fragment implements SeekBar.OnSeekBarChangeListener
{
    private static int seekvalue=10;
    private static EditText edittext;

    ToolbarListener activityCallBack;

    public interface ToolbarListener
    {
        public void onButtonClick(int position, String text);
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try {
            activityCallBack=(ToolbarListener)activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "Must implemet ToolBarListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.toolbar_fragment,container,false);

        edittext = (EditText)view.findViewById(R.id.editText1);
        final SeekBar seekbar = (SeekBar) view.findViewById(R.id.seekBar1);
        seekbar.setOnSeekBarChangeListener(this);

        final Button button = (Button) view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                buttonClicked(v);

            }
        });


        return view;
    }

    public void buttonClicked(View view)
    {
        activityCallBack.onButtonClick(seekvalue,edittext.getText().toString());
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        seekvalue=progress;
    }
    @Override
    public void onStartTrackingTouch(SeekBar arg0){

    }
    @Override
    public void onStopTrackingTouch(SeekBar arg0){

    }

}
