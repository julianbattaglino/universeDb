package com.example.julian.universedb.di.modules;


import com.example.julian.universedb.BuildConfig;
import com.example.julian.universedb.global.services.NebulasApiServices;
import com.example.julian.universedb.global.services.PlanetariasApiService;
import com.example.julian.universedb.global.services.PlanetasApiService;
import com.example.julian.universedb.global.services.RandomUserApiServic;
import com.example.julian.universedb.global.services.SatelitesApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Santiago Battaglino.
 */
@Module
public class RetrofitModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    @Provides
    @Singleton
    RandomUserApiServic provideVestaApiService(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient).build();

        return retrofit.create(RandomUserApiServic.class);
    }


    @Provides
    @Singleton
    NebulasApiServices provideNebulasApiServices(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient).build();

        return retrofit.create(NebulasApiServices.class);

    }

    @Provides
    @Singleton
    PlanetariasApiService providePlanetariasApiServices(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient).build();

        return retrofit.create(PlanetariasApiService.class);

    }

    @Provides
    @Singleton
    PlanetasApiService providePlanetasApiServices(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient).build();

        return retrofit.create(PlanetasApiService.class);
    }

    @Provides
    @Singleton
    SatelitesApiService provideSatelitesApiServices(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient).build();

        return retrofit.create(SatelitesApiService.class);
    }
}
