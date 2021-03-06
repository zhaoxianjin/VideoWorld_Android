package com.lxw.videoworld.app.api;


import com.lxw.videoworld.app.model.ConfigModel;
import com.lxw.videoworld.app.model.SearchResultModel;
import com.lxw.videoworld.app.model.SourceDetailModel;
import com.lxw.videoworld.app.model.SourceListModel;
import com.lxw.videoworld.framework.http.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by lxw9047 on 2016/10/20.
 */

public interface HttpService {
    @FormUrlEncoded
    @POST("config")
    Observable<BaseResponse<ConfigModel>> getConfig(@Field("id") String id);
 
    @FormUrlEncoded
    @POST("list")
    Observable<BaseResponse<SourceListModel>> getList(@Field("sourceType") String sourceType, @Field("category") String category,
      @Field("type") String type, @Field("start") String start, @Field("limit") String limit);

    @FormUrlEncoded
    @POST("search")
    Observable<BaseResponse<String>> getSearch(@Field("uid") String uid, @Field("url") String url, @Field("keyword") String keyword, @Field("searchType") String searchType);

    @FormUrlEncoded
    @POST("searchResult")
    Observable<BaseResponse<SearchResultModel>> getSearchResult(@Field("uid") String uid, @Field("url") String url);

    @FormUrlEncoded
    @POST("feedback")
    Observable<BaseResponse<String>> addFeedback(@Field("uid") String uid, @Field("feedback") String feedback);

    @FormUrlEncoded
    @POST("detail")
    Observable<BaseResponse<SourceDetailModel>> getDetail(@Field("url") String url, @Field("sourceType") String sourceType);

    @FormUrlEncoded
    @POST("userInfo")
    Observable<BaseResponse<String>> addUserInfo(@Field("uid") String uid, @Field("sms") String sms, @Field("contact") String contact, @Field("address") String address, @Field("history") String history);
}
