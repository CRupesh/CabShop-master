package com.cabshop.my.cabshop;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edt_mobile_no)
    EditText edt_mobNo;

    @BindView(R.id.txt_countryCode)
    TextView txt_countryCode;

    @BindView(R.id.txt_logintitle)
    TextView txt_logintitle;

    @BindView(R.id.btn_OTP)
    Button btn_OTP;

    @BindView(R.id.btn_Register)
    Button btn_Register;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initResources();



    }


    private void initResources(){
        try {
            Typeface face,title_face;
            face = Typeface.createFromAsset(getAssets(), "font.otf");
            title_face = Typeface.createFromAsset(getAssets(), "font1.otf");
            edt_mobNo.setTypeface(face);
            txt_countryCode.setTypeface(face);
            txt_logintitle.setTypeface(title_face);
            btn_OTP.setTypeface(title_face);
            btn_Register.setTypeface(title_face);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
