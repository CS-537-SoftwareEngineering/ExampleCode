package usecase;

import generic.RoverThreadHandler;

import java.io.IOException;

public class UseCaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int noOfSensors = 5;
		int port = 9897;

		try {

			UseCaseServer useCaseServer = new UseCaseServer(port);
			Thread server = RoverThreadHandler.getRoverThreadHandler().getNewThread(useCaseServer);

			server.start();
			for (int i = 0; i < noOfSensors; i++) {
				Sensor sensor = new Sensor(port, null, i + 1);
				Thread client = RoverThreadHandler.getRoverThreadHandler().getNewThread(sensor);
				client.start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
