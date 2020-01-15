package com.example.udamedicalsmirs.network

import com.example.udamedicalsmirs.home._dokter.data.ResultDokter
import com.example.udamedicalsmirs.home._donor.data.ResultDonor
import com.example.udamedicalsmirs.home._donor.data.ResultMemberDonor
import com.example.udamedicalsmirs.home._eticket.data.ResultAddTicket
import com.example.udamedicalsmirs.home._eticket.data.ResultTicket
import com.example.udamedicalsmirs.home._healthy_news.data.ResultNews
import com.example.udamedicalsmirs.home._jenguk.data.ResultPasien
import com.example.udamedicalsmirs.home._ruang.data.ResultRuang
import com.example.udamedicalsmirs.login.data.ResultLogin
import com.example.udamedicalsmirs.profile.data.ResultUpdate
import com.example.udamedicalsmirs.register.data.ResultRegister
import retrofit2.Call
import retrofit2.http.*

interface SmirsService {

    @GET("getNews")
    fun getNews() : Call<ResultNews>

    @FormUrlEncoded
    @POST("getMemberDonor")
    fun getMember(@Field("idmember") nohp: String?) : Call<ResultMemberDonor>

    @FormUrlEncoded
    @POST("newMember")
    fun newMember(@Field("iddonor") iddonor : String?,
                  @Field("idUser") idUser: String?,
                  @Field("goldarah") goldarah : String?,
                  @Field("pointdonor") pointdonor : String?,
                  @Field("donasidonor") donasidonor : String?) : Call<ResultDonor>


    @FormUrlEncoded
    @POST("getTicket")
    fun getTicket(@Field("orderticket") idUser: String?) : Call<ResultTicket>


    @FormUrlEncoded
    @POST("newTicket")
    fun newTicket(@Field("nobooking") nobooking: String?,
                  @Field("orderticket") orderticker: String?,
                  @Field("namapasien") namapasien: String?,
                  @Field("nohp") nohp: String?,
                  @Field("jenisperiksa") jenisperiksa: String?,
                  @Field("namadokter") namadokter: String?) : Call<ResultAddTicket>

    @FormUrlEncoded
    @POST("updateUser")
    fun update(@Field("idUser") idUser : String?,
               @Field ("nama") nama : String?,
               @Field("hp") hp : String?,
               @Field("alamat") alamat : String?,
               @Field("password") password : String?) : Call<ResultUpdate>

    //Login Service
    @FormUrlEncoded
    @POST("loginUser")
    fun login (@Field("email") email : String,
               @Field("nohp") nohp : String,
               @Field("password") password : String) : Call<ResultLogin>

    //Register Service
    @FormUrlEncoded
//    @Headers("content-type","application/x-www-form-urlencoded")
//    @Headers("Cache-Control: max-age=640000")
    @POST("registerUser")
//    @Header({"content-type: application/x-www-form-urlencoded"})
    fun register(@Field("nama") nama : String,
                 @Field("email") email : String,
                 @Field("nohp") nohp : String,
                 @Field("password") password : String) : Call<ResultRegister>

    //Jenguk Pasien (Search)
    @FormUrlEncoded
    @POST("searchPasien")
    fun search(@Field("keyword") keyword : String) : Call<ResultPasien>

    @GET("getPasien")
    fun getPasien() : Call<ResultPasien>

    @GET("getDokter")
    fun getDokter():Call<ResultDokter>

    @GET("getRuang")
    fun getRuang():Call<ResultRuang>
}