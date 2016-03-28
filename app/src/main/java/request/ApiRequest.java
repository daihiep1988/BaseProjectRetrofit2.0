package request;

import java.util.Map;
import java.util.Objects;

import Respond.BookingMyTiketRespond;
import Respond.DanhSachVe;
import Respond.GetSetting;
import constant.ApiConstant;
import retrofit.Call;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Nguyen Quang Hiep on 10/19/2015.
 */
public interface ApiRequest {
    @FormUrlEncoded
    @POST(ApiConstant.API_GET_MY_BOOKING_TICKET)
    Call<DanhSachVe> someEndpoint(@FieldMap Map<String, String> names);

    @POST(ApiConstant.API_GET_SETTING)
    Call<GetSetting> getve(@FieldMap Map<String, String> name);
}
