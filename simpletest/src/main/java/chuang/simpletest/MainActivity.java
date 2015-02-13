package chuang.simpletest;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

/**
 *  1.
 */
public class MainActivity extends ActionBarActivity {

    private Fragment mFragmentA;
    private Fragment mFragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentA = new FragmentA();
        mFragmentB = new FragmentB();

        //standard
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.add(R.id.content, mFragmentA, FragmentA.class.getSimpleName());
        fragmentTransaction.commit();


        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //custom

                //1. transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out, android.R.animator.fade_in, android.R.animator.fade_out);
                transaction.setCustomAnimations(R.animator.scalex_enter, R.animator.scalex_exit, R.animator.scalex_enter, R.animator.scalex_exit);

                transaction.replace(R.id.content, mFragmentB, FragmentB.class.getSimpleName());
                transaction.commit();
            }
        });

    }

}
