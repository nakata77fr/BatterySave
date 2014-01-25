package com.main.view;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.EditText;

import com.main.R;
import com.main.core.battery.IBatteryService;
import com.main.core.battery.internal.BatteryService;
import com.main.core.battery.model.Battery;

public class MainActivity extends Activity {

	private IBatteryService batteryService;

	/**
	 * Called when the activity is fi!rst created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Battery battery = getBatteryInfo();
		mapToEditText(battery);

	}

	private void mapToEditText(Battery battery) {
		EditText battery_life = (EditText) findViewById(R.id.battery_life);
		EditText battery_status = (EditText) findViewById(R.id.battery_status);
		EditText battery_is_charging = (EditText) findViewById(R.id.battery_is_charging);
		EditText battery_is_charging_by_plug = (EditText) findViewById(R.id.battery_is_charging_by_plug);
		EditText battery_is_charging_by_usb = (EditText) findViewById(R.id.battery_is_charging_by_usb);
		EditText battery_is_charging_by_ac = (EditText) findViewById(R.id.battery_is_charging_by_ac);
		battery_life.setText("life:" + String.valueOf(battery.getLife()));
		battery_status.setText("status" + String.valueOf(battery.getStatus()));
		battery_is_charging.setText("charging:" + String.valueOf(battery.isCharging()));
		battery_is_charging_by_plug.setText("charging on plug:" + String.valueOf(battery.getChargePlug()));
		battery_is_charging_by_usb.setText(String.valueOf("charging on usb:" + battery.isUsbCharge()));
		battery_is_charging_by_ac.setText(String.valueOf("charging on ac:" + battery.isAcCharge()));
	}

	private Battery getBatteryInfo() {
		batteryService = new BatteryService();
		IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		Intent batteryStatus = registerReceiver(null, ifilter);
		return batteryService.getBatteryInfo(getApplicationContext(), batteryStatus);
	}
}
