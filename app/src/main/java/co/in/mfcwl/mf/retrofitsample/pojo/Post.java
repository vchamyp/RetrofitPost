package co.in.mfcwl.mf.retrofitsample.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by HP 240 G5 on 21-02-2018.
 */

public class Post {


    @SerializedName("")
    @Expose
    private String username;

    @SerializedName("")
    @Expose
    private String mobile;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }



    @Override
    public String toString() {
        return "Post{" +
                "username='" + username + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
