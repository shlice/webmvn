package org.eu.slice.service;

import org.eu.slice.util.HttpRequest;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YunJob implements Job {
	private static Logger logger = LoggerFactory.getLogger(YunJob.class);

	public YunJob() {

	}

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		logger.info("do job");

		String url = "http://www.baiduyun.me/plugin.php?id=dsu_amupper&ppersubmit=true&formhash=83577b21&infloat=yes&handlekey=dsu_amupper&inajax=1&ajaxtarget=fwin_content_dsu_amupper";
        String params = "";
        String cookie = "__cfduid=d517647bd38e649a4c765fc18376004c01433481600; bdshare_firstime=1433481563769; NO6v_8a3b_saltkey=KSxc4fPN; NO6v_8a3b_lastvisit=1433665993; NO6v_8a3b_visitedfid=37; NO6v_8a3b_seccodeSAI068930=1407Psj3oRHMw5SHXXPYdFRhEBxk96OUXiEJAofCR9KXH1IdBniHLcY2OXmnk74JFq3a7Vbc2ZAk3ZlUj2%2Fl; NO6v_8a3b_ulastactivity=3601n%2BGAVo87HaAP2FjYFST4J5bDlukXIxQF2nBddXiSRAekng72; NO6v_8a3b_auth=1609ma%2FMkCxCAK2PizVGKdrRVUavLxHsov%2BP9sbQyOtuwuowXW2qLRfhRc4tlETWYQ0PkbTokxRb0iFe5cuBEPzlIEU; NO6v_8a3b_lastcheckfeed=253223%7C1433669709; NO6v_8a3b_security_cookiereport=95a9M7ZStXaWOZpwNZWEwS3kfQuFqlcWKQ%2BUeH%2Ffzs0APKPqKEtX; NO6v_8a3b_study_baiduconnect_band=1314; NO6v_8a3b_viewid=tid_161440; NO6v_8a3b_sid=K4P5RY; NO6v_8a3b_lip=115.239.235.188%2C1433677670; NO6v_8a3b_lastact=1433677807%09plugin.php%09; NO6v_8a3b_connect_is_bind=0; NO6v_8a3b_dsu_amuppered=253223; NO6v_8a3b_dsu_amupper=DQo8c3R5bGU%2BDQoucHBlcndibSB7cGFkZGluZzo2cHggMTJweDtib3JkZXI6MXB4IHNvbGlkICNDRENEQ0Q7YmFja2dyb3VuZDojRjJGMkYyO2xpbmUtaGVpZ2h0OjEuOGVtO2NvbG9yOiMwMDMzMDA7d2lkdGg6MjAwcHg7b3ZlcmZsb3c6aGlkZGVufQ0KLnBwZXJ3Ym0gLnRpbWVze2NvbG9yOiNmZjk5MDA7fQ0KLnBwZXJ3Ym0gIGF7ZmxvYXQ6cmlnaHQ7Y29sb3I6I2ZmMzMwMDt0ZXh0LWRlY29yYXRpb246bm9uZX0NCjwvc3R5bGU%2BDQoNCjxkaXYgY2xhc3M9InBwZXJ3Ym0iIGlkPSJwcGVyd2JfbWVudSIgc3R5bGU9ImRpc3BsYXk6IG5vbmUiID4NCg0KPHN0cm9uZz7A27zGx6m1vTxzcGFuIGNsYXNzPSJ0aW1lcyI%2BMjQ8L3NwYW4%2BtM48L3N0cm9uZz48YnI%2BDQoNCjxBIEhSRUY9ImZvcnVtLnBocD9tb2Q9dmlld3RocmVhZCZhbXA7dGlkPTE2MTQ0MCZhbXA7YXV0aG9yaWQ9MjUzMjIzIiB0YXJnZXQ9Il9ibGFuayI%2Bsum%2FtMeptb272Mz7PC9BPg0KDQo8c3Ryb25nPsGs0PjHqbW9PHNwYW4gY2xhc3M9InRpbWVzIj43PC9zcGFuPrTOPC9zdHJvbmc%2BPGJyPg0KDQo8c3Ryb25nPsnPtM7HqbW9OiA8c3BhbiBjbGFzcz0idGltZXMiPjIwMTUtMDYtMDcgMTA6Mjc6NDg8L3NwYW4%2BPC9zdHJvbmc%2BDQo8L2Rpdj4NCg%3D%3D";
        String content = new HttpRequest().sendGet(url, params, cookie, null);// 并发


		if (content.isEmpty())
			logger.warn("Empty!");
		else if (!content.contains("您已签到"))
		{
			logger.info(content);
			logger.info("=====签到成功=====");
		}
		else{
			logger.info(content);
		}
			
	}
}
