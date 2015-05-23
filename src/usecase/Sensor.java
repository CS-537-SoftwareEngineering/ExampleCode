package usecase;

import generic.RoverClientRunnable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Sensor extends RoverClientRunnable {
	public int ID;
	public float temperature;
	public int waitTime = 2000;
	
	private State state;

	public Sensor(int port, InetAddress host, int ID)
			throws UnknownHostException {
		super(port, host);
		startUp();
		this.ID = ID;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ObjectOutputStream oos = null;
			ObjectInputStream ois = null;
			Thread.sleep(waitTime);
			// while the rover is ON the sensors work
			while (state == State.ON) {
				temperature = randomTemperature();
				
				oos = new ObjectOutputStream(getRoverSocket().getNewSocket()
						.getOutputStream());
				System.out.println("Sensor" + ID + " " + temperature);
				oos.writeObject("Sensor" + ID + " " + temperature);
				
				// read the server response message
				ois = new ObjectInputStream(getRoverSocket().getSocket()
						.getInputStream());
				String message = (String) ois.readObject();
				
				if (message != null);

				// close resources
				ois.close();
				oos.close();
				Thread.sleep(waitTime);
			}
			//if(state == State.OFF)
			closeAll();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (Exception error) {
			System.out.println("Sensor" + ID + ": Error:"
					+ error.getMessage());
		}
	}
	
	public void shutDown(){
		this.state = State.OFF;
	}
	
	public void startUp(){
		this.state = State.ON;
	}
	
	public float randomTemperature(){
		// returns a temperature between 50 and -130
		return (float)Math.random()*(180) - 130;
	}
}
