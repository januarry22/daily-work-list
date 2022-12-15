# [Spring] - HTTP 통신

> 1.  Server to Server 통신이란?
2. Spring Server to Server 통신 방법
> 

## 1. Server to Server 통신이란 ?

- Cilent가 요청을 보내면 그에 대한 응답을 Server 에서 리턴하는 Client-Server 방식과는 달리 공통기능, 인증/보안 혹은 외부서비스를 서버내부에서 API로 호출 하는것

## 2.  Server to Server 통신 방법

### **URLConnection**

- jdk1.2 버전이상부터 내장되어있는 java 객체
- 사용자 인증이나 보안이 설정 되어 있지 않은 웹서버에 접속할 때 주로 사용

```java
public static void main(String[] args) throws IOException {
       String con = "http://www.google.co.kr";
      
			 try {
					 URL url = new URL(con);
		       URLConnection urlcon = url.openConnection();
		       InputStream is = urlcon.getInputStream();
		       BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		       char[] buff = new char[512];
		       int len = -1; 

				} catch (MalformedURLException e) {
            System.out.println("잘못된 URL입니다.");
      }
}
```

- **getContentEncoding()** : 헤더의 content-encoding에 대한 정보 리턴
- **getContentLength()** : 헤더 필드의 content-length에 대한 값 리턴
- **getInputStream()** : URLConnetion 객체로부터 InputStream 값 리턴
- **getOutputStream()** : URLConnetion 객체로부터 OutputStream 값 리턴
- **getURL()** : URL 필드 리턴

### **HttpURLConnection**

- java.net.HttpURLConnection 클래스는 URLConnection을 구현한 클래스
- 주로 미리 길이를 알지 못하는 스트리밍 데이터를 주고 받는데 사용

```java
public String httpURLCon(String url) throws IOException, ParseException, InterruptedException {
		String connect = url;
	  URL url = new URL(connect);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setDoOutput(true);
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		con.setConnectTimeout(timeOut);
		con.setReadTimeout(timeOut);

		int responseCode = con.getResponseCode();
		BufferedReader br;
		if (responseCode == 200) {
			br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
		} else {
			br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
		}
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		// 리소스 해제 
		br.close();

		/* json String 으로 리턴 */
		String json = response.toString();

		return json;
}
```

- 기본적으로 GET요청 이지만 setRequestMethod()로 메소드 타입 설정 가능
- 리턴 데이터 타입을 별도로 작성해 주어야하고 반복적인 코드 존재함

### **HttpClient**

- Apache HttpComponents로 불리며 HttpURLConnection을 사용할 때보다 조금 더 간결하고 직관적으로 코드로 작성가능
- URLConnection과 달리 Response값을 exeute메서드로 요청해서 EntityUtils.tostring() 문자열로 받아올 수 있음

```java
public String httpURLCon(String url) throws IOException, ClientProtocolException {
	
        CloseableHttpClient httpClient = HttpClients.createDefault();
 
        //get 메서드 post -> HttpPost 사용
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("User-Agent", USER_AGENT);
      
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
 
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                httpResponse.getEntity().getContent()));
 
        String inputLine;
        StringBuffer response = new StringBuffer();
 
        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        
        reader.close();
			  httpClient.close();

				return response.toString();
}
```

- HttpGet, HttpPost 사용하여 더 직관적인 코드 작성가능
- 응답의 컨텐츠 타입에 따라 별도의 로직이 필요

### **RestTemplate**

- Spring 3.0 부터 지원하는 Spring의 HTTP 통신 템플릿
- RestTemplate는 HttpClient를 추상화(HttpEntity의 json, xml 등)해서 제공
- Blocking I/O 기반의 동기방식

```java
public String httpURLCon(String url) throws IOException, ClientProtocolException {
				String jsonInString = "";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);
        
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

        ResponseEntity<?> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Object.class);ObjectMapper objectMapper = new ObjectMapper();
			  jsonInString = mapper.writeValueAsString(resultMap.getBody());

				return jsonInString;
}

// Multipart 파일
public String sendMultiPartRequest(String url, MultiValueMap<String, Object> body , HttpMethod method){
        String jsonInString = "";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        RestTemplate restTemplate = new RestTemplate(factory);

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(body, header);
        ResponseEntity<String> responseMap = restTemplate.exchange(uri.toString(),method, entity, String.class);
      

        result.put("statusCode", responseMap.getStatusCode()); //http status code를 확인
        result.put("header", responseMap.getHeaders()); //헤더 정보 확인
        result.put("body", responseMap.getBody()); //실제 데이터 정보 확인

        String str = responseMap.getBody().toString();
      
        return str;
    }
```

- 다른 Object로 리턴할 경우 예외처리가 필요함
- RestTemplate 동작 원리
    
    [https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FqiN1C%2FbtrqGdmD2km%2FvdvxW3riqM3tjKkFHHWKH1%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FqiN1C%2FbtrqGdmD2km%2FvdvxW3riqM3tjKkFHHWKH1%2Fimg.png)
    
    1. RestTemplate를 생성해 URI, HTTP메소드 등의 헤더를 담아 요청
    2. RestTemplate는 HttpMessageConverter를 사용하여 requestEntity를 요청메세지로 변환
    3. RestTemplate는 ClientHttpRequestFactory로 부터 ClientHttpRequest를 가져와서 요청을 보냄
    4. ClientHttpRequest는 요청메세지를 만들어 HTTP 프로토콜을 통해 서버와 통신
    5. RestTemplate는 ResponseErrorHandler로 오류를 확인하고 처리
    6. ResponseErrorHandler는 오류가 있다면 ClientHttpResponse에서 응답데이터를 가져와서 처리
    7. RestTemplate는 HttpMessageConverter를 이용해서 응답메세지를 java object(class responseType)으로 변환
    8. 어플리케이션에 반환