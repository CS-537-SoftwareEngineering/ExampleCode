package usecase;

public class ModuleBase {
	
	double currTemp;
	
	double minTemp;
	
	double maxTemp;
	
	boolean isHeater;
	
	State heaterState;
	
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
