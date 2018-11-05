package com.mobitant.bestfood.lib;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.mobitant.bestfood.BestFoodInfoActivity;
import com.mobitant.bestfood.BestFoodRegisterActivity;
import com.mobitant.bestfood.ProfileActivity;

import org.parceler.transfuse.listeners.FragmentMenuComponent;

/**
 * Activity나 Fragment 실행 라이브러리
 */
public class GoLib {
	public final String TAG = GoLib.class.getSimpleName();
	private volatile static GoLib instance;
	
	public static GoLib getInstance() {
		if (instance == null) {
			synchronized (GoLib.class) {
				if (instance == null) {
					instance = new GoLib();
				}
			}
		}
		
		return instance;
	}
	
	/**
	 * Fragment를 보여준다.
	 * @param fragmentManager Fragment Manager
	 * @param containerViewId Fragment를 보여줄 컨테이너 뷰 아이디
	 * @param fragment Fragmetn
	 */
	public void goFragment(FragmentManager fragmentManager, int containerViewId, Fragment fragment) {
		fragmentManager.beginTransaction().replace(containerViewId, fragment).commit();
	}
	
	/**
	 * 뒤로가기를 할 수 있는 Fragment를 보여준다.
	 * @param fragmentManager Fragment Managet
	 * @param containerViewId Fragment를 보여줄 컨터이너 뷰 아이디
	 * @param fragment Fragment
	 */
	public void goFragmentBack(FragmentManager fragmentManager, int containerViewId, Fragment fragment) {
		fragmentManager.beginTransaction().replace(containerViewId,fragment).addToBackStack(null).commit();
	}
	
	/**
	 * 이전 Fragment를 보여준다.
	 * @param fragmentManager Fragment Manager
	 */
	public void goBackFragment(FragmentManager fragmentManager) {
		fragmentManager.popBackStack();
	}
	
	/**
	 * ProfileActivity를 실행한다.
	 * @param context 컨텍스트
	 */
	public void goProfileActivity(Context context) {
		Intent intent = new Intent(context, ProfileActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}
	
	/**
	 * 맛집 정보 등록 Activity를 실행한다.
	 * @param context 컨텍스트
	 */
	public void goBestFoodRegisterActivity(Context context) {
		Intent intent = new Intent(context, BestFoodRegisterActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}
	
	/**
	 * 맛집 정보 Activity를 실행한다.
	 * @param context 컨텍스트
	 * @param infoSeq 맛집 정보 일련번호
	 */
	public void goBestFoodInfoActivity(Context context, int infoSeq) {
		Intent intent = new Intent(context, BestFoodInfoActivity.class);
		intent.putExtra(BestFoodInfoActivity.INFO_SEQ, infoSeq);
		context.startActivity(intent);
	}
}
