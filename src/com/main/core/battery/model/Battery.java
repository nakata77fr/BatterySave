package com.main.core.battery.model;


public class Battery {

	private int status;

	private boolean isCharging;

	private int chargePlug;

	private boolean usbCharge;

	private boolean acCharge;

	private int life;

	public Battery(int status, boolean isCharging, int chargePlug, boolean usbCharge, boolean acCharge, int life) {
		this.status = status;
		this.isCharging = isCharging;
		this.chargePlug = chargePlug;
		this.usbCharge = usbCharge;
		this.acCharge = acCharge;
		this.life = life;
	}

	public int getStatus() {
		return status;
	}

	public boolean isCharging() {
		return isCharging;
	}

	public int getChargePlug() {
		return chargePlug;
	}

	public boolean isUsbCharge() {
		return usbCharge;
	}

	public boolean isAcCharge() {
		return acCharge;
	}

	public int getLife() {
		return life;
	}
}
