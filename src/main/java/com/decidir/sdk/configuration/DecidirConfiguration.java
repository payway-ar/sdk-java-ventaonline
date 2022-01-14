package com.decidir.sdk.configuration;

import java.io.IOException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;


import com.decidir.sdk.converters.DecidirConverter;
import com.google.gson.JsonObject;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by biandra on 06/07/16.
 */
public class DecidirConfiguration {

    static private final String version = "2.2";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String MAX_AGE_0 = "max-age=0";
    public static final String USER_AGENT = "User-Agent";
    public static final String DECIDIR_JAVA_SDK_V = "Decidir Java SDK v ";
    public static final String APIKEY = "apikey";
    public static final String GROUPER = "grouper";
    public static final String DEVELOPER = "developer";
    public static final String SDK_JAVA = "SDK-JAVA";
    public static final String SERVICE = "service";


    public static <T> T initRetrofit(final String secretAccessToken, final String apiUrl, final Integer timeOut, final Class<T> serviceClass, final String grouper, final String developer) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .readTimeout(timeOut, TimeUnit.SECONDS)
                .connectTimeout(timeOut, TimeUnit.SECONDS);

        httpClient.networkInterceptors().add(new Interceptor() {

            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {

                Request request = chain.request().newBuilder()
                        .header(CACHE_CONTROL, MAX_AGE_0)
                        .header(APIKEY, secretAccessToken)
                        //.header("X-Consumer-Username", secretAccessToken+"_private")
                        //.header("X-Consumer-Username", secretAccessToken+"_pci")
                        .header("X-Source", getXsource(grouper, developer))
                        .header(USER_AGENT, getUserAgent())
                        .build();

                return chain.proceed(request);
            }
        });

		retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(JacksonConverterFactory.create(new DecidirConverter().getObjectMapper()))
                .client(httpClient.build())
                .build();

        return retrofit.create(serviceClass);
    }

    static private String getUserAgent() {
        return DECIDIR_JAVA_SDK_V + version;
    }
    
    static private String getXsource(String grouper, String developer) {
    	JsonObject source = new JsonObject();
    	source.addProperty(SERVICE, SDK_JAVA);
    	source.addProperty(GROUPER, grouper);
    	source.addProperty(DEVELOPER, developer);
    	String xSourceKey = Base64.getEncoder().encodeToString(source.toString().getBytes());
    	return xSourceKey;
    }

}
