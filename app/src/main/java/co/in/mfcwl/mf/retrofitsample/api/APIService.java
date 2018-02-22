package co.in.mfcwl.mf.retrofitsample.api;

import co.in.mfcwl.mf.retrofitsample.pojo.Post;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by HP 240 G5 on 21-02-2018.
 */

public interface APIService {

        @FormUrlEncoded
        @POST("")
        Call<Post> savePost(@Field("") String username,
                            @Field("") String password,
                            @Field("") String mobile,
                            @Field("") String device_token);


    }

