package com.main.core.wifi.internal;

import android.content.Context;
import android.net.wifi.WifiManager;

import com.main.core.wifi.IWifiService;

public class WifiService implements IWifiService {

	public void putWifi(boolean status, Context context) {

		WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		wifiManager.setWifiEnabled(status);
	}
}
