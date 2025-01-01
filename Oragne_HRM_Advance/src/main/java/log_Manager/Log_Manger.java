package log_Manager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log_Manger 


{

	//INITIALIZING THE LOGGER 
	
	private static final Logger logger = LogManager.getLogger(Log_Manger .class);
	
	public static void main(String[] args)
	
	{
		logger.debug("This is the Debug");
		logger.info("This is Infor");
		logger.warn("This is war");
		logger.fatal("Tghis is fatal");
		logger.error("Tghis is error");
	}
	
}

