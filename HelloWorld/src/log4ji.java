
import org.apache.log4j.Logger;
/**
 *@author linbingwen
 *@2015��5��18��9:14:21
 */
public class log4ji {
	private static Logger logger = Logger.getLogger(log4ji.class);  
 
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // System.out.println("This is println message.");  
 
        // ��¼debug�������Ϣ  
        logger.debug("This is debug message.");  
        // ��¼info�������Ϣ  
        logger.info("This is info message.");  
        // ��¼error�������Ϣ  
        logger.error("This is error message.");  
    }  
}