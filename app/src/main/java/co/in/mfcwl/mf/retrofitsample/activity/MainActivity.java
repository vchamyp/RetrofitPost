package co.in.mfcwl.mf.retrofitsample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import co.in.mfcwl.mf.retrofitsample.R;
import co.in.mfcwl.mf.retrofitsample.Utils.ApiUtils;
import co.in.mfcwl.mf.retrofitsample.api.APIService;
import co.in.mfcwl.mf.retrofitsample.pojo.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editUN)
    EditText editUN;
    @BindView(R.id.editNum)
    EditText editNum;
    @BindView(R.id.editPW)
    EditText editPW;

    Unbinder unbinder;

     APIService apiService;
    Post post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        post =new Post();
         /*apiService =
                ApiClient.getClient().create(APIService.class);*/



        apiService = ApiUtils.getAPIService();

    }

    @OnClick(R.id.btnSignIn)
    public void onButtonClick(View v) {
        Toast.makeText(getApplicationContext(), "You have entered: " ,
                Toast.LENGTH_SHORT).show();

        sendPost(editUN.getText().toString(),editPW.getText().toString(),editNum.getText().toString(),"token");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public void sendPost(String username, String password, String mobile,String token) {


        Log.e("retrofit ","username "+username);

        apiService.savePost(username, password, mobile,token).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.e("retrofit", "post submitted to API." + response.body().getMobile());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("retrofit", "Unable to submit post to API.");
            }
        });


    }

    public void showResponse(String response) {
        /*if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }*/
       // mResponseTv.setText(response);
        Log.e("retrofit", "response. "+response);

    }
}
