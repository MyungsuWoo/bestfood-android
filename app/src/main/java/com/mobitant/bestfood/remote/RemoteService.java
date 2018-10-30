package com.mobitant.bestfood.remote;

import com.mobitant.bestfood.item.MemberInfoItem;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * 서버에 호출할 메소드를 선언하는 인터페이스
 */
public interface RemoteService {
	String BASE_URL = "http://192.168.1.188:3000";
	String MEMBER_ICON_URL = BASE_URL + "/member/";
	String IMAGE_URL = BASE_URL + "/img/";

	// 사용자 정보
	@GET("/member/{phone}")
	Call<MemberInfoItem> selectMemberInfo(@Path("phone") String phone);

	@POST("/member/info")
	Call<String> insertMemberInfo(@Body MemberInfoItem memberInfoItem);

	@FormUrlEncoded
	@POST("/member/phone")
	Call<String> insertMemberPhone(@Field("phone") String phone);

	@Multipart
	@POST("/member/icon_upload")
	Call<ResponseBody> uploadMemberIcon(@Part("member_seq") RequestBody memberSeq, @Part MultipartBody.Part file);
}