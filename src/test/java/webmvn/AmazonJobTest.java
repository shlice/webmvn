package webmvn;

import org.eu.slice.service.AmazonJob;
import org.junit.Test;
import org.quartz.JobExecutionException;

public class AmazonJobTest {

	@Test
	public void Test() {
		AmazonJob job = new AmazonJob();
		try {
			job.execute(null);
		} catch (JobExecutionException e) {
			e.printStackTrace();
		}
	}
}
