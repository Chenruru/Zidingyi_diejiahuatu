package test.bwie.com.zidingyi_diejiahuatu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Neifangwaiyuan neifan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //控件是类的名字
       neifan = (Neifangwaiyuan) findViewById(R.id.neifan);
    }
}
