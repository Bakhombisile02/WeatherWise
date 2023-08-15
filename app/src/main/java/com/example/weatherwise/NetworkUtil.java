package com.example.weatherwise;

import android.net.Uri;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtil
{
    public static final String TAG = "ourURL";
    // This constant holds the base URL for the AccuWeather API endpoint that provides 5-day forecasts.
    public static final String BASE_URL = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/306633";

    // This constant indicates that the metric measurements should be used.
    // This value is used as a query parameter when making API requests.
    public static final String METRIC_VALUE = "true";

    // This constant represents the name of the query parameter used to specify metric or imperial units.
    public static final String METRIC_PARAM = "metric";

    // This constant holds the API key that is required to authenticate your app when making API requests.
    public static final String API_KEY = "U5QKjcMeLSzkqu0gAnBKVLTdAABUZYfd";

    // This constant represents the name of the query parameter used to send your API key with each request.
    public static final String API_PARAM = "apikey";

    //Method to convert uri to url
    //uri is information to be retrived and url is how we retrive it/directions to retrive it.
    public static URL buildURLForWeather()
    {
        Uri uri = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(API_PARAM, API_KEY)
                .appendQueryParameter(METRIC_PARAM, METRIC_VALUE)
                .build();

        URL url =null;

        try
        {
            url = new URL(uri.toString());
        }
        catch (MalformedURLException e)
        {
            throw new RuntimeException(e);
        }

        Log.i(TAG, "buildURLForWeather: "+url);

        return url;
    }
}
