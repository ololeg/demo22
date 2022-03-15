package com.example.demo;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

//@SpringBootApplication
public class DemoApplication {

	static RestTemplate restTemplate = new RestTemplate();
	static String baseURL = "http://94.198.50.185:7081/api/users/";

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);

		useMetodCreate();
	}

	private static void useMetodCreate() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<User> requestEntity = new HttpEntity<>(headers);

		ResponseEntity<String> responseEntity = restTemplate.exchange(baseURL,
				HttpMethod.GET,
				requestEntity,
				String.class);

		responseEntity.getHeaders().get("Set-Cookie").stream().forEach(System.out::println);

		HttpStatus statusCode = responseEntity.getStatusCode();
		System.out.println("Status Code " + statusCode);

		String user = responseEntity.getBody();
		System.out.println("responce Entity " + user);

		HttpHeaders responseHeaders = responseEntity.getHeaders();
		System.out.println("responce Headers " + responseHeaders);


		User sysUser = new User();
		sysUser.setId(3L);
		sysUser.setName("James");
		sysUser.setLastName("Brown");
		sysUser.setAge((byte) 24);

		requestEntity = new HttpEntity<>(sysUser, headers);

		ResponseEntity<String> responseEntity1 = restTemplate.exchange(baseURL,
				HttpMethod.POST,
				requestEntity,
				String.class);
		HttpStatus statusCode1 = responseEntity1.getStatusCode();
		System.out.println("Status Code " + statusCode1);

		String userCreate = responseEntity1.getBody();
		System.out.println("responce Entity " + userCreate);

		HttpHeaders responseHeaders1 = responseEntity1.getHeaders();
		System.out.println("responce Headers " + responseHeaders1);



//		User upUser = new User();
//		upUser.setId(3L);
//		upUser.setName("Thomas");
//		upUser.setLastName("Shelby");
//		upUser.setAge((byte) 24);
//		requestEntity = new HttpEntity<>(upUser, headers);

//		editUser(requestEntity);

		deliteUser(requestEntity);
	}



	private static void editUser(HttpEntity<User> requestEntity) {
		ResponseEntity<String> responseEntity1 = restTemplate.exchange(baseURL,
				HttpMethod.PUT,
				requestEntity,
				String.class);
		HttpStatus statusCode1 = responseEntity1.getStatusCode();
		System.out.println("Status Code " + statusCode1);

		String userEdit = responseEntity1.getBody();
		System.out.println("responce Entity " + userEdit);

		HttpHeaders responseHeaders1 = responseEntity1.getHeaders();
		System.out.println("responce Headers " + responseHeaders1);
	}

	private static void deliteUser(HttpEntity<User> requestEntity) {
		ResponseEntity<String> responseEntity1 = restTemplate.exchange(baseURL + "3",
				HttpMethod.DELETE,
				requestEntity,
				String.class);
		HttpStatus statusCode1 = responseEntity1.getStatusCode();
		System.out.println("Status Code " + statusCode1);

		String userEdit = responseEntity1.getBody();
		System.out.println("responce Entity " + userEdit);

		HttpHeaders responseHeaders1 = responseEntity1.getHeaders();
		System.out.println("responce Headers " + responseHeaders1);
	}
}
























//
//
//	public static void useExchangeMethodsOfRestTemplate() {
//
//		RestTemplate template = new RestTemplate();
//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<String> entity = new HttpEntity<String>(headers);

//		ResponseEntity<String> forEntity = template.getForEntity(baseURL,
//				HttpMethod.GET,
//				entity,
//				String.class);

//		forEntity.getHeaders().get("Set-Cookie").stream().forEach(System.out::println);
//
//		HttpStatus statusCode = forEntity.getStatusCode();
//		System.out.println("statusCode - " + statusCode);
//		String userDetails = forEntity.getBody();
//		System.out.println("response bode - " + userDetails);
//		HttpHeaders responceHeaders = forEntity.getHeaders();
//		System.out.println("response Headers - " + responceHeaders);
//
//
//
//
//
////		forEntity = new HttpEntity<>(sysUser, headers1);
//
//		RestTemplate restTemplate = new RestTemplate();
//		HttpHeaders headers = new HttpHeaders();
//
//
//		headers.set("Cookie",cookies.stream().collect(Collectors.joining(";")));


//
//
//		restTemplate.exchange(baseURL,
//				HttpMethod.POST,
//				entity,
//				String.class);

//		HttpHeaders headers1 = new HttpHeaders();
//		headers1.setContentType(MediaType.APPLICATION_JSON);
//		String cookie = "JSESSIONID=2422CDE13DB548A03E4B3BD85EAC1840";
//		headers1.set("Set-Cookie", cookie);
//
//		requestEntity = new HttpEntity<>(sysUser, headers1);
//
//		HttpEntity<String> httpEntity = restTemplate.exchange(baseURL,
//				HttpMethod.POST,
//				requestEntity,
//				String.class);
//
//		httpEntity.getHeaders().get("Set-Cookie").stream().forEach(System.out::println);
//		String userDetails1 = responseEntity.getBody();
//		System.out.println("response body - " + userDetails1);

//		addUserByExchangeMethod(requestEntity);

//


//
//		updateUserByExchangeMethod(requestEntity);

//		getListUserByExchangeMethod(requestEntity);


//		deliteUserByExchangeMethod(requestEntity);



//
//	private static void addUserByExchangeMethod(HttpEntity<Object> requestEntity) {
//		RestTemplate restTemplate = new RestTemplate();
//
//		HttpEntity<String> responseEntity = restTemplate.exchange(baseURL,
//				HttpMethod.POST,
//				requestEntity,
//				String.class);
//
//		responseEntity.getHeaders().get("Set-Cookie").stream().forEach(System.out::println);
//		String userDetails = responseEntity.getBody();
//		System.out.println("response body - " + userDetails);
//	}
//
//	private static void updateUserByExchangeMethod(HttpEntity<Object> requestEntity) {
//		RestTemplate restTemplate = new RestTemplate();
//
//		ResponseEntity<String> responseEntity = restTemplate.exchange(baseURL,
//				HttpMethod.PUT,
//				requestEntity,
//				String.class);
//		HttpStatus statusCode = responseEntity.getStatusCode();
//		System.out.println("statusCode - " + statusCode);
//		String userDetails2 = responseEntity.getBody();
//		System.out.println("response bode - " + userDetails2);
//		HttpHeaders responceHeaders = responseEntity.getHeaders();
//		System.out.println("response Headers - " + responceHeaders);
//	}
//
//	private static void deliteUserByExchangeMethod(HttpEntity<Object> requestEntity) {
//		RestTemplate restTemplate = new RestTemplate();
//
//		ResponseEntity<String> responseEntity = restTemplate.exchange(baseURL + "2",
//				HttpMethod.DELETE,
//				requestEntity,
//				String.class);
//		HttpStatus statusCode = responseEntity.getStatusCode();
//		System.out.println("statusCode - " + statusCode);
//		String userDetails = responseEntity.getBody();
//		System.out.println("response bode - " + userDetails);
//		HttpHeaders responceHeaders = responseEntity.getHeaders();
//		System.out.println("response Headers - " + responceHeaders);
//	}
//}
