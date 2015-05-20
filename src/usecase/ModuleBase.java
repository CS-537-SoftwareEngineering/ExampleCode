package usecase;

public class ModuleBase {
	
	double currTemp;
	
	double minTemp;
	
	double maxTemp;
	
	//will be true if the module is having heater
	boolean isHeater;
	
	State heaterState;
	
	//will be true if the module is having cooler
	boolean isCooler;
	
	State coolerState;
	
	public ModuleBase(){
		
	}

	public double getCurrTemp() {
		return currTemp;
	}

	public void setCurrTemp(double currTemp) {
		this.currTemp = currTemp;
	}

	public double getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}

	public double getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}

}
