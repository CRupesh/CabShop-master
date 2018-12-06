package com.cabshop.my.cabshop;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistrationActivity extends AppCompatActivity {

    @BindView(R.id.txt_logintitle)
    TextView txt_logintitle;

    @BindView(R.id.edt_regName)
    EditText edt_regName;

    @BindView(R.id.edt_regMail)
    EditText edt_mailId;

    @BindView(R.id.edt_regMobile_no)
    EditText edt_mobNo;

    @BindView(R.id.edt_RegCabNo)
    EditText edt_cabNo;

    @BindView(R.id.btn_regMe)
    Button btn_Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
        initResources();
    }


    private void initResources(){
        try {
            Typeface face,title_face;
            face = Typeface.createFromAsset(getAssets(), "font.otf");
            title_face = Typeface.createFromAsset(getAssets(), "font1.otf");
            edt_mobNo.setTypeface(face);
            edt_cabNo.setTypeface(face);
            edt_mailId.setTypeface(face);
            edt_regName.setTypeface(face);
            txt_logintitle.setTypeface(title_face);
            btn_Register.setTypeface(title_face);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
