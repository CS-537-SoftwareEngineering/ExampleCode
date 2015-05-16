package usecase;

import java.util.HashMap;
import java.util.Map;

public class ThermalDataSector {
	
	private static ThermalDataSector tempDataSector;
	
	private Map<Modules, ModuleBase> moduleMap;
	
	private ThermalDataSector(){
		setModuleMap(new HashMap<Modules, ModuleBase>());
		
		init();
	}
	
	private void init(){
		initMap();
		initTempChart();
	}
	
	private void initTempChart(){
		
	}
	
	public static ThermalDataSector getTempDataSector(){
		if(tempDataSector == null){
			tempDataSector = new ThermalDataSector();
		}
		return tempDataSector;
	}

	public Map<Modules, ModuleBase> getModuleMap() {
		return moduleMap;
	}
	
	private void initMap(){
		
		for(Modules mod:Modules.values()){
			ModuleBase moduleBase = new ModuleBase();
			setTempRange(mod, moduleBase);
			moduleMap.put(mod, moduleBase);
		}
		
	}
	
	public void setTempRange(Modules mod, ModuleBase moduleBase){
		
	}

	public void setModuleMap(Map<Modules, ModuleBase> hashMap) {
		this.moduleMap = hashMap;
	}
}
