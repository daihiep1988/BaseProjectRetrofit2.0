package request;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import Respond.BookingMyTiketRespond;
import Respond.DanhSachVe;
import constant.ApiConstant;
import constant.ApiParams;
import retrofit.Call;

/**
 * Created by Nguyen Quang Hiep on 10/19/2015.
 */
public class BookingMyTicketRequest extends BaseRequest<DanhSachVe> {
    @Override
    public String getURL() {
        return ApiConstant.URL_HOST;
    }

    BookingMyTicketRequestOnResult bookingMyTicketRequestOnResult;

    public void setBookingMyTicketRequestOnResult(BookingMyTicketRequestOnResult bookingMyTicketRequestOnResult) {
        this.bookingMyTicketRequestOnResult = bookingMyTicketRequestOnResult;
    }

    @Override
    public Map<String, String> getParans() {
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put(ApiParams.MOBILE, "0989923368");

        return stringStringMap;
    }

    @Override
    public void onRequestSuccess(DanhSachVe bookingMyTiketRespond) {
        if (bookingMyTiketRespond != null)
            bookingMyTicketRequestOnResult.onBookingMyTicketRequestOnResult(bookingMyTiketRespond, null);
    }

    @Override
    public void onRequestError(Throwable t) {
        if (t != null)
            bookingMyTicketRequestOnResult.onBookingMyTicketRequestOnResult(null, t);
    }

    @Override
    public Call<DanhSachVe> callApi() {
        return apiRequest.someEndpoint(getParans());
    }

//    @Override
//    public void callApi(Call<DanhSachVe> tCall, Map<String, String> requesParams) {
//        tCall = apiRequest.someEndpoint(requesParams);
//        tCall.enqueue(this);
//    }

    public interface BookingMyTicketRequestOnResult {
        public void onBookingMyTicketRequestOnResult(DanhSachVe bookingMyTiketRespond, Throwable throwable);
    }
}
