package com.main.core.battery;

import android.content.Context;

import com.main.core.battery.model.Battery;

public interface IBatteryService {

	public Battery getBatteryInfo(Context context);
}
