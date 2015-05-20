package json;
/**
 * This class represents the daily temperature of Mars.
 * @author Mohammad Yazdani
 *
 */
public class DailyTemp
{
  private int minute;
  private float temp;
  
  public DailyTemp()
  {  }
  
  public DailyTemp(int minute , float temp)
  {
	this.minute = minute;
	this.temp = temp;
  }
  
  public int getMinute()
  {
    return minute;
  }
  public void setMinute(int minute)
  {
    this.minute = minute;
  }
  public float getTemp()
  {
    return temp;
  }
  public void setTemp(float temp)
  {
    this.temp = temp;
  }
  public String  toString()
  {
	return "Minute: " + minute + ",  Temp: "+ temp;
  }
}
