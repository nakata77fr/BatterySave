package com.main.core.bluetooth.internal;

import android.bluetooth.BluetoothAdapter;

import com.main.core.bluetooth.IBluetoothService;

public class BluetoothService implements IBluetoothService {

	public void setBluetoothState(boolean enable) {
		BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		boolean isEnabled = bluetoothAdapter.isEnabled();
		if (enable && !isEnabled) {
			bluetoothAdapter.enable();
		} else if (!enable && isEnabled) {
			bluetoothAdapter.disable();
		}

	}
}
