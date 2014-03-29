package com.main.core.localisation.internal;

import android.content.Context;
import android.content.Intent;

import com.main.core.localisation.ILocalisationService;

public class LocalisationService implements ILocalisationService {

	public void startLocalisation(Context context, boolean state) {
		Intent intent = new Intent("android.location.GPS_ENABLED_CHANGE");
		intent.putExtra("enabled", state);
		context.sendBroadcast(intent);

	}

	//	public void turnGPSOn(Context context) {
	//		Intent intent = new Intent("android.location.GPS_ENABLED_CHANGE");
	//		intent.putExtra("enabled", true);
	//		context.sendBroadcast(intent);
	//
	//		String provider = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
	//		if (!provider.contains("gps")) {
	//			//if gps is disabled
	//			final Intent intentGps = new Intent();
	//			intentGps.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
	//			intentGps.addCategory(Intent.CATEGORY_ALTERNATIVE);
	//			intentGps.setData(Uri.parse("3"));
	//			context.sendBroadcast(intentGps);
	//		}
	//	}
	//
	//	public void turnGPSOff(Context context) {
	//		String provider = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
	//		if (provider.contains("gps")) { //if gps is enabled
	//			final Intent poke = new Intent();
	//			poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
	//			poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
	//			poke.setData(Uri.parse("3"));
	//			context.sendBroadcast(poke);
	//		}
	//	}

}
