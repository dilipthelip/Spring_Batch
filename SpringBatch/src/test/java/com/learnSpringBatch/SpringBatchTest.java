package com.learnSpringBatch;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class SpringBatchTest {
	
    public static void main(String[] args) 
    {
        Calendar calendar = Calendar.getInstance();
       // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/ddhhmmssSS");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:MM:SS");
        
        String[] jobCommand = new String[3];
        jobCommand[0] = new String("/configs/job-configuration.xml");
        jobCommand[1] = new String("importProducts");
        jobCommand[2] = new String("schedule.date(date)="+ dateFormat.format(calendar.getTime()));
        try {
			CommandLineJobRunner.main(jobCommand);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


}
