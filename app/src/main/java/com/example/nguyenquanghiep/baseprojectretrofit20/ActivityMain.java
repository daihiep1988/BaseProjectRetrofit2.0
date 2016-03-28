package com.example.nguyenquanghiep.baseprojectretrofit20;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import Respond.BookingMyTiketRespond;
import Respond.DanhSachVe;
import Respond.GetSetting;
import request.BookingMyTicketRequest;
import request.GetSettingRequest;

/**
 * Created by Nguyen Quang Hiep on 10/19/2015.
 */
public class ActivityMain extends Activity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_api);
        textView = (TextView) findViewById(R.id.textView);
//        BookingMyTicketRequest bookingMyTicketRequest = new BookingMyTicketRequest();
//        bookingMyTicketRequest.setBookingMyTicketRequestOnResult(new BookingMyTicketRequest.BookingMyTicketRequestOnResult() {
//            @Override
//            public void onBookingMyTicketRequestOnResult(DanhSachVe bookingMyTiketRespond, Throwable throwable) {
//                if (bookingMyTiketRespond != null)
//                {  Log.e("Hiepnq", "vao");
//                    for (BookingMyTiketRespond respond : bookingMyTiketRespond.DSVe) {
//                      textView.setText(respond.Id+"");
//                    }}
//                else
//                    Toast.makeText(getApplicationContext(), "Loi", Toast.LENGTH_LONG).show();
//            }
//        });
//        bookingMyTicketRequest.execute();
        GetSettingRequest getSettingRequest=new GetSettingRequest();
        getSettingRequest.setGetSettingRequestOnresult(new GetSettingRequest.GetSettingRequestOnresult() {
            @Override
            public void onGetSettingRequestOnresult(GetSetting getSetting, Throwable t) {
                if (getSetting!=null)
                    Toast.makeText(getApplicationContext(),"vaoday",Toast.LENGTH_LONG).show();
            }
        });
        getSettingRequest.execute();
    }
}
