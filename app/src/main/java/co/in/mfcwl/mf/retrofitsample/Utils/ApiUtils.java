package co.in.mfcwl.mf.retrofitsample.Utils;

import co.in.mfcwl.mf.retrofitsample.api.APIService;
import co.in.mfcwl.mf.retrofitsample.rest.ApiClient;

/**
 * Created by HP 240 G5 on 21-02-2018.
 */

public class ApiUtils {
    private ApiUtils() {}


    public static APIService getAPIService() {


        return ApiClient.getClient().create(APIService.class);
    }
}
