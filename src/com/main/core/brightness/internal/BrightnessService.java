package com.main.core.brightness.internal;

import android.content.ContentResolver;

import com.main.core.brightness.IBrightnessService;

public class BrightnessService implements IBrightnessService {

	public int setBrightnessState(ContentResolver contentResolver, float BackLightValue) {
		int SysBackLightValue = (int) (BackLightValue * 255);
		android.provider.Settings.System.putInt(contentResolver, android.provider.Settings.System.SCREEN_BRIGHTNESS, SysBackLightValue);
		return 0;
	}
}
