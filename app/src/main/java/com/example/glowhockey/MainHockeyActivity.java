package com.example.glowhockey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainHockeyActivity extends AppCompatActivity {

    LinearLayout player_ball;
    TextView x;
    TextView y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hockey);

        x=findViewById(R.id.xsign);
        y=findViewById(R.id.ysign);

        player_ball= findViewById(R.id.playerBall);

        player_ball.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                float xDown=0, yDown=0;
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_UP:
                        xDown = event.getX();
                        yDown = event.getY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        float movedX, movedY;
                        movedX = event.getX();
                        movedY = event.getY();

                        float distanceX = player_ball.getX() + movedX - xDown-60;
                        float distanceY = player_ball.getY()+movedY - yDown-60;
                        float currentX = (
                                distanceX >= 32.95 && distanceX<=1196.50
                                )?distanceX
                                :(distanceX<32.95)?(float) 32.95: (float) 1196.50;

                        float currentY = (
                                distanceY >= 11 && distanceY<=810.50
                                )?distanceY
                                :(distanceY<11)?(float) 11: (float) 810.50;


                        x.setText("X:-  "+currentX);
                        y.setText("Y:-  "+currentY);

                        player_ball.setX(currentX);
                        player_ball.setY(currentY);

                        xDown=movedX;
                        yDown=movedY;
                        break;
                }

                return true;
            }
        });
    }
}