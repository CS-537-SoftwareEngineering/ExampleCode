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

	public boolean isHeater() {
		return isHeater;
	}

	public void setHeater(boolean isHeater) {
		this.isHeater = isHeater;
	}

	public State getHeaterState() {
		return heaterState;
	}

	public void setHeaterState(State heaterState) {
		this.heaterState = heaterState;
	}

	public boolean isCooler() {
		return isCooler;
	}

	public void setCooler(boolean isCooler) {
		this.isCooler = isCooler;
	}

	public State getCoolerState() {
		return coolerState;
	}

	public void setCoolerState(State coolerState) {
		this.coolerState = coolerState;
	}
	
	

}
