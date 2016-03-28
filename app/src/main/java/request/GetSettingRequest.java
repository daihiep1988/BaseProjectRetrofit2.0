package request;

import java.util.HashMap;
import java.util.Map;

import Respond.GetSetting;
import constant.ApiConstant;
import retrofit.Call;

/**
 * Created by Nguyen Quang Hiep on 10/20/2015.
 */
public class GetSettingRequest extends BaseRequest<GetSetting> {
    @Override
    public String getURL() {
        return ApiConstant.URL_HOST;
    }

    @Override
    public Map<String, String> getParans() {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("ClientTime", "2015-10-20T00:32:00.210798+07:00");
        stringMap.put("CurrentAppVersion", "sample string 2");
        stringMap.put("CurrentDataVersion", "sample string 3");
        stringMap.put("Platform", "sample string 4");
        return stringMap;
    }

    @Override
    public void onRequestSuccess(GetSetting getSetting) {
        if (getSetting != null)
            getSettingRequestOnresult.onGetSettingRequestOnresult(getSetting, null);
    }

    public void setGetSettingRequestOnresult(GetSettingRequestOnresult getSettingRequestOnresult) {
        this.getSettingRequestOnresult = getSettingRequestOnresult;
    }

    @Override
    public void onRequestError(Throwable t) {
        if (t != null)
            getSettingRequestOnresult.onGetSettingRequestOnresult(null, t);
    }

    @Override
    public Call<GetSetting> callApi() {
        return apiRequest.getve(requesParams);
    }

    GetSettingRequestOnresult getSettingRequestOnresult;

    public interface GetSettingRequestOnresult {
        public void onGetSettingRequestOnresult(GetSetting getSetting, Throwable t);
    }
}
