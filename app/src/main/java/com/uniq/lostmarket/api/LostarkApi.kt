package com.uniq.lostmarket.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.uniq.lostmarket.BuildConfig
import com.uniq.lostmarket.api.models.Characters
import com.uniq.lostmarket.api.models.MarketList
import com.uniq.lostmarket.api.models.OpenApiStatus
import com.uniq.lostmarket.api.models.RequestMarketItems
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

const val baseUrl = "https://developer-lostark.game.onstove.com/"
const val JWT = BuildConfig.API_KEY

const val postMarketItemsUrl = "markets/items"
const val apiStatusUrl = "api-status"

interface LostarkApi {

    @GET(apiStatusUrl)
    @Headers("accept: application/json",
        "authorization: bearer $JWT")
    fun getServerStatus(): Call<OpenApiStatus>

    @GET("/characters/{name}/siblings")
    @Headers("accept: application/json",
        "authorization: bearer $JWT")
    fun getCharaInfo(
        @Path("name")charaName: String
    ): Call<List<Characters>>

    @POST(postMarketItemsUrl)
    @Headers("accept: application/json",
        "authorization: bearer $JWT")
    fun postMarketOptions(
        @Body requestMarketItems: RequestMarketItems
    ): Call<MarketList>

    companion object {// Retrofit 객체 초기화
    private const val BASE_URL = baseUrl
        fun create(): LostarkApi {

            val gson : Gson = GsonBuilder().setLenient().create()

            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(LostarkApi::class.java)
        }
    }
}