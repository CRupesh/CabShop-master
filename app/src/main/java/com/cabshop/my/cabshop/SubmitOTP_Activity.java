package com.cabshop.my.cabshop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class SubmitOTP_Activity extends AppCompatActivity {

    @BindView(R.id.txt_logintitle)
    TextView txt_logintitle;

    @BindViews({R.id.edt_otp1,R.id.edt_otp2,R.id.edt_otp3,R.id.edt_otp4})
    List<EditText> otp_views;

    @BindView(R.id.txt_OtpNote)
    TextView txt_OtpNote;

    @BindView(R.id.OTP_layout)
    LinearLayout OTP_layout;

    @BindView(R.id.btn_submitOtp)
    Button btn_submitOtp;

    @BindView(R.id.btn_resendOtp)
    Button btn_resendOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_otp);
        ButterKnife.bind(this);
        initResources();


        otp_views.get(0).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                otp_views.get(1).requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(otp_views.get(1), InputMethodManager.SHOW_IMPLICIT);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otp_views.get(1).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                otp_views.get(2).requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(otp_views.get(2), InputMethodManager.SHOW_IMPLICIT);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otp_views.get(2).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                otp_views.get(3).requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(otp_views.get(3), InputMethodManager.SHOW_IMPLICIT);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void initResources(){
        try {
            Typeface face,title_face;
            face = Typeface.createFromAsset(getAssets(), "font.otf");
            title_face = Typeface.createFromAsset(getAssets(), "font1.otf");

            otp_views.get(0).setTypeface(face);
            otp_views.get(1).setTypeface(face);
            otp_views.get(2).setTypeface(face);
            otp_views.get(3).setTypeface(face);
            txt_OtpNote.setTypeface(face);

            txt_logintitle.setTypeface(title_face);
            btn_resendOtp.setTypeface(title_face);
            btn_submitOtp.setTypeface(title_face);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void OnSubmitOTP_ClickListner(View view){
        Intent intent = new Intent(SubmitOTP_Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
