package com.free4lab.freemonitor.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestResultManager {
	public static String getServiceStatus(List<Integer> interfacesStatus){
	    String status="";
	    int lastinter=-1;
	    for(int i=0;i<interfacesStatus.size();i++)
        {
	        int inter = interfacesStatus.get(i);
	        if ( inter > lastinter)
	        {
    	        if ( inter == 0 )
    	            status = "Normal";
    	        else if ( inter == 1 )
    	            status = "Warning";
    	        else if ( inter == 2 )
                    status = "Error";
    	        lastinter = inter;
	        }
        }
	    return status;
	}
	Date date = new Date();
	Timestamp currentTime = new Timestamp(date.getTime());
}
