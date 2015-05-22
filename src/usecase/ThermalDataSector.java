package usecase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *  ThermalDataSector implements Rover module with their temperature detail and creates list Map of temperature chart.
 *  @author Mohammad Yazdani
 * 
 */
public class ThermalDataSector {
	
	private static ThermalDataSector tempDataSector;
	
	private Map<Modules, ModuleBase> moduleMap;
	
	/** tempChart map holds 1480 temperatures indicating a sol temp in Mars
	key is minute from 10 to 1480 increments by 10 (ex: 10, 20, 30, ... , 1480) */
	private Map<Integer, Float> tempChart;
	
	public ThermalDataSector(){
		
	  setModuleMap(new HashMap<Modules, ModuleBase>());
	  //populateModuleMap();
		init();
	}
	
	private void init(){
		initMap();
		initTempChart();
	}
	
	/** Creates a new <b>Map</b> of temperatures by reading all the temps list from JSON file 
	 * "E:\data\temperatures.json" */
	private void initTempChart(){
	  
	  System.out.println("initTempChart() caled");
	  
	  this.tempChart = new TreeMap<Integer, Float>();
	  
	  String jsonFile = "E:\\data\\temperatures.json";
	  
	  // JSONParser is used to parse the data
	  JSONParser parser = new JSONParser();  
	  
      try
      {
    	//parsing all the objects to the Object and then to JSONObject.
	    Object tempObjects = parser.parse(new FileReader(jsonFile));
	    JSONObject jsonObjects = (JSONObject) tempObjects;
	    
	    //from the JSONObject create the array of temperature
	    JSONArray tempArray = (JSONArray) jsonObjects.get("temps");

	    for(Object o: tempArray)
		{
		  JSONObject jo = (JSONObject) o;
		  
		  tempChart.put(new Integer( Integer.parseInt(jo.get("minute").toString())), 
			  new Float(Float.parseFloat(jo.get("temp").toString())));
		}
	    
	    
      } catch (ParseException e1)
      {
	    e1.printStackTrace();
      } catch (FileNotFoundException e)
      {
	    e.printStackTrace();
      } catch (IOException e)
      {
	    e.printStackTrace();
      } 
      
      System.out.println("Map tempChart created with " + tempChart.size() + " Objects");
	 
	}
	
	public static ThermalDataSector getTempDataSector(){
	  
	  System.out.println("getTempDataSector() caled");
	  
		if(tempDataSector == null){
			tempDataSector = new ThermalDataSector();
		}
		return tempDataSector;
	}

	public Map<Modules, ModuleBase> getModuleMap() {
		return moduleMap;
	}
	
	
	/** Creates the tempRange for each available module that is being fetched from ModuleBase Enum
	 * the tempRange and module name is being added to the modeuleMap. Refer to moduleMap object to
	 * get all the modules with their temperature range. */
	private void initMap(){
		
	  System.out.println("initMap() caled");
		
	  //Modules is Enum holding all the rover's modules name
		for(Modules mod:Modules.values()){
			ModuleBase moduleBase = new ModuleBase();
			
			setTempRange(mod, moduleBase);
			moduleMap.put(mod, moduleBase);
			//System.out.println(mod);
		}
		
		System.out.println("Map moduleMap is created with " + moduleMap.size() + " Objects.");
	}
	
	//set the temp range of each module by reading it from JSON file
	public void setTempRange(Modules mod, ModuleBase moduleBase){
		
	}

	public void setModuleMap(Map<Modules, ModuleBase> hashMap) {
		this.moduleMap = hashMap;
		
	}
	
	// we need to have class of sensor which is going to read data every few seconds from instrument surrounding.
	
	//create a method which takes current temp from sensor with the instrument name
	//compare the current temperature with MaxTemp and MinTemp of the instrument and send the
	//data if heater needed to be ON of OFF
	
	//we need to update the heater status (ON/OFF) if status of the heater changes.

	
}
