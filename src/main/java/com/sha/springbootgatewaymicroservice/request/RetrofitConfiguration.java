package com.sha.springbootgatewaymicroservice.request;

import com.google.gson.Gson;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

@Configuration
public class RetrofitConfiguration {
    @Value("${retrofit.timeout}")
    private Long TIMEOUT_IN_SECS;

    private OkHttpClient.Builder createDefaultClientBuilder() {
        return new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_IN_SECS, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_IN_SECS, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_IN_SECS, TimeUnit.SECONDS);
    }

    @Bean
    public OkHttpClient secureKeyClient(@Value("${service.security.secure-key-username}") String secureKeyUsername,
                                        @Value("${service.security.secure-key-password}") String secureKeyPassword) {
        return createDefaultClientBuilder()
                .addInterceptor(interceptor -> interceptor.proceed(
                        interceptor.request().newBuilder()
                                .header("Authorization", Credentials.basic(secureKeyUsername, secureKeyPassword))
                                .build()))
                .build();
    }

    @Bean
    public Retrofit.Builder secureKeyBuilder(OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson));
    }
}
