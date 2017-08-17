package vishnu.android.pinlogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;

public class PinLoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnShwPassFirst,btnShwPassSecond, btnShwPassThird, btnShwPassFourth;
    private int counter = 0;
    private Button[] btnArray ;
    private Button[] btnOthersArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_login);
        Button btnKeyPadOne, btnKeyPadTwo, btnKeyPadThree,
                btnKeyPadFour, btnKeyPadFive, btnKeyPadSix,
                btnKeyPadSeven, btnKeyPadEight, btnKeyPadNine,
                btnKeyPadZero, btnKeyPadBack, btnKeyPadClearAll;

        btnShwPassFirst     = (Button) findViewById(R.id.btn_pswrd_one);
        btnShwPassSecond    = (Button) findViewById(R.id.btn_pswrd_two);
        btnShwPassThird     = (Button) findViewById(R.id.btn_pswrd_three);
        btnShwPassFourth    = (Button) findViewById(R.id.btn_pswrd_four);

        btnKeyPadOne    = (Button) findViewById(R.id.btn_keypad_one);
        btnKeyPadTwo    = (Button) findViewById(R.id.btn_keypad_two);
        btnKeyPadThree  = (Button) findViewById(R.id.btn_keypad_three);
        btnKeyPadFour   = (Button) findViewById(R.id.btn_keypad_four);
        btnKeyPadFive   = (Button) findViewById(R.id.btn_keypad_five);
        btnKeyPadSix    = (Button) findViewById(R.id.btn_keypad_six);
        btnKeyPadSeven  = (Button) findViewById(R.id.btn_keypad_seven);
        btnKeyPadEight  = (Button) findViewById(R.id.btn_keypad_eight);
        btnKeyPadNine   = (Button) findViewById(R.id.btn_keypad_nine);
        btnKeyPadZero   = (Button) findViewById(R.id.btn_keypad_zero);

        btnKeyPadClearAll   = (Button) findViewById(R.id.btn_keypad_clear_all);
        btnKeyPadBack       = (Button) findViewById(R.id.btn_keypad_back);

        btnArray    =  new Button[]{btnKeyPadOne, btnKeyPadTwo, btnKeyPadThree,
                btnKeyPadFour, btnKeyPadFive, btnKeyPadSix,
                btnKeyPadSeven, btnKeyPadEight, btnKeyPadNine, btnKeyPadZero};

        btnOthersArray = new Button[]{btnKeyPadClearAll, btnKeyPadBack};

        for (Button btn: btnArray      ) {
            btn.setOnClickListener(this);
        }
        for (Button btn: btnOthersArray      ) {
            btn.setOnClickListener(this);
        }


    }

    @Override
    public void onClick(View view){

        Button btn = (Button) view;
        if (Arrays.asList(btnArray).contains(btn)){
            if (counter > 3)
                return;
            counter++;
            switch (counter){
                case 1:
                    btnShwPassFirst.setBackgroundResource(R.drawable.show_pwd_btn);
                    break;
                case 2:
                    btnShwPassSecond.setBackgroundResource(R.drawable.show_pwd_btn);
                    break;
                case 3:
                    btnShwPassThird.setBackgroundResource(R.drawable.show_pwd_btn);
                    break;
                case  4:
                    btnShwPassFourth.setBackgroundResource(R.drawable.show_pwd_btn);
                    break;
            }
        }
        else if (Arrays.asList(btnOthersArray).contains(btn)){
            int id = view.getId();
            switch (id){
                case R.id.btn_keypad_clear_all:
                    counter = 0;
                    btnShwPassFirst.setBackgroundResource(R.drawable.empty_password);
                    btnShwPassSecond.setBackgroundResource(R.drawable.empty_password);
                    btnShwPassThird.setBackgroundResource(R.drawable.empty_password);
                    btnShwPassFourth.setBackgroundResource(R.drawable.empty_password);
                    break;
                case R.id.btn_keypad_back:
                    counter--;
                    switch (counter){
                        case 3:
                            btnShwPassFirst.setBackgroundResource(R.drawable.show_pwd_btn);
                            btnShwPassSecond.setBackgroundResource(R.drawable.show_pwd_btn);
                            btnShwPassThird.setBackgroundResource(R.drawable.show_pwd_btn);
                            btnShwPassFourth.setBackgroundResource(R.drawable.empty_password);
                            break;
                        case 2:
                            btnShwPassFirst.setBackgroundResource(R.drawable.show_pwd_btn);
                            btnShwPassSecond.setBackgroundResource(R.drawable.show_pwd_btn);
                            btnShwPassThird.setBackgroundResource(R.drawable.empty_password);
                            btnShwPassFourth.setBackgroundResource(R.drawable.empty_password);
                            break;
                        case 1:
                            btnShwPassFirst.setBackgroundResource(R.drawable.show_pwd_btn);
                            btnShwPassSecond.setBackgroundResource(R.drawable.empty_password);
                            btnShwPassThird.setBackgroundResource(R.drawable.empty_password);
                            btnShwPassFourth.setBackgroundResource(R.drawable.empty_password);
                            break;
                        case 0:
                            btnShwPassFirst.setBackgroundResource(R.drawable.empty_password);
                            btnShwPassSecond.setBackgroundResource(R.drawable.empty_password);
                            btnShwPassThird.setBackgroundResource(R.drawable.empty_password);
                            btnShwPassFourth.setBackgroundResource(R.drawable.empty_password);

                    }

            }
        }
    }
}
