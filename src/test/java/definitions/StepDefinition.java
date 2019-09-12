package definitions;




import java.io.IOException;

import org.junit.Ignore;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.integrationTestCase.IntegrationTestCaseApplicationTests;
import com.integrationTestCase.model.Person;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



@Ignore
public class StepDefinition extends IntegrationTestCaseApplicationTests{
	
	private String baseUri = null;
	private String url = null;
	Person person = null;
	String response = null;
	TestRestTemplate testRestTemplate = new TestRestTemplate();
	HttpEntity<Person> request = null;



	@Given("^The endpoint host \"([^\"]*)\"$")
	public void the_endpoint_host(String arg1) throws Throwable {

		this.baseUri = arg1+":"+port+"/";


	}


	@When("^The client make a request at \"([^\"]*)\"$")
	public void the_client_make_a_request_at(String arg1) throws Throwable {

		this.url = buildPath(arg1);
		System.out.println(this.url);
		
	}

	@When("^Sending the required attribute name \"([^\"]*)\"$")
	public void sending_the_required_attribute_name(String arg1) throws Throwable {

		this.person = new Person(arg1,"lastname");
	}

	@Then("^The status response should be (\\d+)$")
	public void the_status_response_should_be(int arg1) throws Throwable {
		
//		RequestBody requestBody = new MultipartBody.Builder()
//	            .setType(MultipartBody.FORM)
//	            .addFormDataPart("name", this.person.getName())
//	            .addFormDataPart("lastname", this.person.getLastname())
//	            .build();
//		
//		OkHttpClient client = new OkHttpClient();
//	    okhttp3.Request request = new okhttp3.Request.Builder()
//	            .url(this.url)
//	            .post(requestBody)
//	            .addHeader("cache-control", "no-cache")
//	            .build();
//	    
//	    client.newCall(request).enqueue(new Callback() {
//	        @Override
//	        public void onFailure(Call call, IOException e) {
//	            e.printStackTrace();
//	        }
//
//	        @Override
//	        public void onResponse(Call call, okhttp3.Response response) throws IOException {
//	            if (response.isSuccessful()) {
//	                final String myResponse = response.body().string();
//	                System.out.println(myResponse);
//
//	            }
//	        }
//	    });
	        
	   
//		request = new HttpEntity<Person>(this.person);
//		ResponseEntity<String> result = testRestTemplate
//				.exchange(this.url, HttpMethod.POST, request, String.class);
//		this.response = result.getBody();
//		System.out.println(result);
		//assertEquals(arg1, result.getStatusCode());

	}

	@Then("^The response message is \"([^\"]*)\"$")
	public void the_response_message_is(String arg1) throws Throwable {

		//assertEquals(Boolean.parseBoolean(arg1), this.response.get("status"));
	}
	
	
	public boolean validatePort(String port) {
		boolean result = false;
		if(port.equals("localhost")) {
			result = true;
		}
		return result;
	}
	
	public String buildPath(String path) {
		String fullPath = this.baseUri+path;
		return fullPath;
	}
	
	public boolean isString(String attribute) {
		boolean result = false;
		if(attribute != null && !attribute.trim().isEmpty()) {
			result = true;
		}
		return result;
	}
}
