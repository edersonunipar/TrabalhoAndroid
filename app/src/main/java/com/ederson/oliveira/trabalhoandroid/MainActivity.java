package com.ederson.oliveira.trabalhoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.ederson.oliveira.trabalhoandroid.models.AdapterCourse;
import com.ederson.oliveira.trabalhoandroid.models.Course;
import com.ederson.oliveira.trabalhoandroid.models.Instructor;
import com.ederson.oliveira.trabalhoandroid.models.UdacityCatalog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ListView listViewCursos;


    private static final String TAG = "erro0101010110";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      Retrofit retrofit = new Retrofit.Builder()
              .baseUrl(UdacityService.BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .build();

      UdacityService service = retrofit.create(UdacityService.class);
      Call<UdacityCatalog> requestCatalog = service.listCatalog();

      requestCatalog.enqueue (new Callback<UdacityCatalog>() {

          @Override
          public void onResponse(Call<UdacityCatalog> call, Response<UdacityCatalog> response) {
              UdacityCatalog catalog = response.body();

//esse aplicativo ira revolucionar o mundo

              AdapterCourse adapterCourse = new AdapterCourse(MainActivity.this, catalog.courses);
              listViewCursos = (ListView) findViewById(R.id.listViewCursos);
              listViewCursos.setAdapter(adapterCourse);

//              AdapterCourse adapter = new AdapterCourse(this, catalog.courses);
//              listViewCursos.setAdapter(adapter);

              if (!response.isSuccessful()) {
                  Log.i("TAG", "erro" + response.code());
              } else {

                  for (Course c : catalog.courses) {
                      Log.i(TAG, String.format("%s: %s", c.title, c.subtitle));

                      for (Instructor i : c.instructors) {
                          Log.i("TAG", i.name);
                      }
                      Log.i("TAG", "-----------------");
                  }

                  for (Course c : catalog.courses) {
                      Log.i("TAG", String.format("%s: %s", c.title, c.subtitle));
                  }
              }
          }

          @Override
          public void onFailure(Call<UdacityCatalog> call, Throwable t) {
              Log.e(TAG, "Erro" + t.getMessage());
          }


      });
    }
}
