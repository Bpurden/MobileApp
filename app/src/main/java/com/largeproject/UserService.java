package com.largeproject;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface UserService
{

    @POST("login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest );

    @POST("register")
    Call<RegisterResponse> userRegister(@Body RegisterRequest registerRequest);

    @POST("addTeam")
    Call<TeamResponse> addTeam(@Body TeamRequest teamRequest);

    @POST("statusHistory")
    Call<HistoryResponse> statusHistory(@Body HistoryRequest historyRequest);

}
