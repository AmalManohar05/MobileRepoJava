package pace.testautomation.apicore.methods;

import java.io.File;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class BrowserStackService {
	/**
	 * Http response object
	 */
	public static HttpResponse responseObject;

	
	/**
	 * Upload application in browser stack using api
	 * 
	 * @return application url
	 * @throws Exception
	 * 
	 * @version 1.0.0
	 * @since 2024-10-07
	 */
	public static String browserStackUploadAppUsingApi() throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost uploadRequest = new HttpPost(System.getProperty("uploadUrl"));
		uploadRequest.addHeader("Authorization", "Basic " + java.util.Base64.getEncoder()
				.encodeToString((System.getProperty("username") + ":" + System.getProperty("accessKey")).getBytes()));
		File appFile = new File(System.getProperty("user.dir") + System.getProperty("filePath"));
		HttpEntity multipartEntity = MultipartEntityBuilder.create().addBinaryBody("file", appFile).build();
		uploadRequest.setEntity(multipartEntity);
		responseObject = httpClient.execute(uploadRequest);
		return responseObject.getEntity().toString();
	}
}