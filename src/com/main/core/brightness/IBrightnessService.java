package com.main.core.brightness;

import android.content.ContentResolver;

public interface IBrightnessService {

	public int setBrightnessState(ContentResolver contentResolver, float BackLightValue);
}
