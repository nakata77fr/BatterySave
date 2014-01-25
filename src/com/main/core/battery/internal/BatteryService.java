package com.main.core.battery.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

import com.main.core.battery.IBatteryService;
import com.main.core.battery.model.Battery;

public class BatteryService implements IBatteryService {

	@Override
	public Battery getBatteryInfo(Context context, Intent intent) {
		IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		Intent batteryStatus = context.registerReceiver(null, ifilter);

		// Are we charging / charged?
		int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
		boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL;

		// How are we charging?
		int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
		boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
		boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
		int life = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);

		return new Battery(status, isCharging, chargePlug, usbCharge, acCharge, life);
	}
}
