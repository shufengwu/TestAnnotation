package com.example.testannotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.lang.annotation.Documented;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    private TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (TextView)findViewById(R.id.show);
        String clazz = "com.example.testannotation.Demo";
        Method[]  demoMethods = new Method[0];
        try {
            demoMethods =MainActivity.class
                    .getClassLoader().loadClass(clazz).getMethods();
            String res="";
            for (Method method : demoMethods) {
                if (method.isAnnotationPresent(PersonAnnotation.class)) {
                    PersonAnnotation personAnnotation = method.getAnnotation(PersonAnnotation.class);
                    String str = "method: "+ method +"\n"
                            +"name= "+ personAnnotation.name() +
                            " , website= "+ personAnnotation.qq()
                            + " , revision= "+personAnnotation.address()+"\n\n";
                    res += str;
                }
            }
            show.setText(res);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
