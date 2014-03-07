package com.main.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;

import com.main.R;
import com.main.core.battery.IBatteryService;
import com.main.core.battery.internal.BatteryService;
import com.main.core.battery.model.Battery;
import com.main.core.bluetooth.IBluetoothService;
import com.main.core.bluetooth.internal.BluetoothService;
import com.main.core.brightness.IBrightnessService;
import com.main.core.brightness.internal.BrightnessService;
import com.main.core.wifi.IWifiService;
import com.main.core.wifi.internal.WifiService;

public class MainActivity extends Activity {

	private IBatteryService batteryService;

	private IBrightnessService brightnessService;

	private IWifiService wifiService;

	private IBluetoothService bluetoothService;

	/**
	 * Called when the activity is fi!rst created.
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		handledBatteryState();
		handleBrightnessByButton();
		handleBrightnessBySeekBar();
		handleWifiBySwitch();
		handleBluetoothByBtn();
	}

	private void handleBluetoothByBtn() {
		Switch bluetoothSwitch = (Switch) findViewById(R.id.bluetoothSwitch);
		bluetoothSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				bluetoothService = new BluetoothService();
				bluetoothService.setBluetoothState(isChecked);
			}
		});
	}

	private void handleWifiBySwitch() {
		Switch toggle = (Switch) findViewById(R.id.wifi_switch);
		toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				wifiService = new WifiService();
				wifiService.putWifi(isChecked, getApplicationContext());
			}
		});
	}

	private void handledBatteryState() {
		Battery batteryInfo = getBatteryInfo();
		displayBatteryState(batteryInfo);
	}

	private void handleBrightnessByButton() {
		Button UpdateSystemSetting = (Button) findViewById(R.id.updatesystemsetting);

		UpdateSystemSetting.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				brightnessService = new BrightnessService();
				brightnessService.setBrightnessState(getContentResolver(), 0);
				SeekBar BackLightControl = (SeekBar) findViewById(R.id.backlightcontrol);
				BackLightControl.setProgress(0);
			}
		});
	}

	private void handleBrightnessBySeekBar() {
		SeekBar BackLightControl = (SeekBar) findViewById(R.id.backlightcontrol);
		final TextView BackLightSetting = (TextView) findViewById(R.id.backlightsetting);

		BackLightControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				float BackLightValue = (float) arg1 / 100;
				BackLightSetting.setText(String.valueOf(BackLightValue));
				WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
				layoutParams.screenBrightness = BackLightValue;
				getWindow().setAttributes(layoutParams);
			}

			public void onStartTrackingTouch(SeekBar arg0) {
			}

			public void onStopTrackingTouch(SeekBar arg0) {
			}
		});
	}

	private void displayBatteryState(Battery batteryInfo) {
		EditText battery_life = (EditText) findViewById(R.id.battery_life);
		EditText battery_status = (EditText) findViewById(R.id.battery_status);
		EditText battery_is_charging = (EditText) findViewById(R.id.battery_is_charging);
		EditText battery_is_charging_by_plug = (EditText) findViewById(R.id.battery_is_charging_by_plug);
		EditText battery_is_charging_by_usb = (EditText) findViewById(R.id.battery_is_charging_by_usb);
		EditText battery_is_charging_by_ac = (EditText) findViewById(R.id.battery_is_charging_by_ac);
		battery_life.setText("life:" + batteryInfo.getLife());
		battery_status.setText("status" + batteryInfo.getStatus());
		battery_is_charging.setText("charging:" + batteryInfo.isCharging());
		battery_is_charging_by_plug.setText("charging on plug:" + batteryInfo.getChargePlug());
		battery_is_charging_by_usb.setText(String.valueOf("charging on usb:" + batteryInfo.isUsbCharge()));
		battery_is_charging_by_ac.setText(String.valueOf("charging on ac:" + batteryInfo.isAcCharge()));
	}

	private Battery getBatteryInfo() {
		batteryService = new BatteryService();
		return batteryService.getBatteryInfo(getApplicationContext());
	}
}
