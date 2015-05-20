package usecase;

import generic.RoverThreadHandler;

import java.io.IOException;

public class UseCaseMain
{

  public static void main(String[] args)
  {

	//Server port
	int port = 9897;

	try
	{
	  UseCaseServer useCaseServer = new UseCaseServer(port);
	  Thread server = RoverThreadHandler.getRoverThreadHandler().getNewThread(useCaseServer);

	  UseCaseClient useCaseClient = new UseCaseClient(port, null);
	  Thread client = RoverThreadHandler.getRoverThreadHandler().getNewThread(useCaseClient);

	  server.start();

	  client.start();

	} catch (IOException e)
	{
	  e.printStackTrace();
	}

  }

}
