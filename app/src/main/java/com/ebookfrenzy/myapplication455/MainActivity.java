package com.ebookfrenzy.myapplication455;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements ToolBarFragment.ToolbarListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    public void onButtonClick(int fontsize, String text)
    {
        TextFragment textFragment =
                (TextFragment)
                        getSupportFragmentManager().findFragmentById(R.id.fragment3);

        textFragment.changeTextProperties(fontsize,text);


    }
}
