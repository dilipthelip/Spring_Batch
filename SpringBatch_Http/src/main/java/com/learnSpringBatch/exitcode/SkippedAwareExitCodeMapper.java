package com.learnSpringBatch.exitcode;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.launch.support.ExitCodeMapper;

public class SkippedAwareExitCodeMapper implements ExitCodeMapper {

	public int intValue(String exitCode) {
		// TODO Auto-generated method stub
		 if(ExitStatus.COMPLETED.getExitCode().equals(exitCode)) {
			 System.out.println("SkippedAwareExitCodeMapper completed");
		      return 0;
		    } else if(ExitStatus.FAILED.getExitCode().equals(exitCode)) {
		    	System.out.println("SkippedAwareExitCodeMapper failed");
		      return 1;
		    } else if("COMPLETED WITH SKIPS".equals(exitCode)) {
		    	System.out.println("SkippedAwareExitCodeMapper SKIPS");
		      return 3;
		    } else {
		      return 2;
		    }
	}

}
