# [Spring] Spring MVC

## 1. Spring MVC ?

- Model, View, Controller 를 분리한 디자인 패턴

```html
- Model 
	: 어플리케이션의 정보나 데이터(Data), 일반적으로 POJO로 구성됨
- View 
	: 모델 데이터를 렌더링해 사용자에게 보여지는 화면, UI를 말합니다. 
		JSP, Tyymeleaf , Groovy 등이 있음
- Controller 
	: Model 과 View 사이의 인터페이스 역할
		Model/View에 대한 사용자 입력 및 요청을 수신하여 그에 따라 적절한 결과를 
		Model에 담아 View에 전달
```

## 2. Spring Framework의 구조

- **DispatcherServlet**
Spring Framework가 제공하는 Servlet 클래스로 front controller의 역할을 수행
애플리케이션으로 들어오는 모든 요청을 핸들링하고 적합한 컨트롤러에 위임
    - DispatcherServlet 동작 과정
    
    [https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbImFbg%2FbtrGzZMTuu2%2FCkY4MiKvl5ivUJPoc5I3zk%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbImFbg%2FbtrGzZMTuu2%2FCkY4MiKvl5ivUJPoc5I3zk%2Fimg.png)
    
    - DispatcherServlet 설정
    
    ```xml
    - web.xml 파일에 설정
    
    <?xml version="1.0" encoding="UTF-8"?>
    <web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
    	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee https://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
    
    	<!-- datasource나 transcation 등도 있을 수 있으므로 별도로 설정 -->
    	<context-param>
    		<param-name>contextConfigLocation</param-name>
    		<param-value>/WEB-INF/spring/root-context.xml</param-value>
    	</context-param>
    	
    	<!-- 서블릿이나 Filter요청 받기 위해 대기하는 객체 -->
    	<listener>
    		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    	</listener>
    
    	<!-- contextLoader가 <param-value>의 위치에 있는 
    									설정 파일을 읽고 appServlet라는 서블릿으로 설정 -->
    	<servlet>
    		<servlet-name>appServlet</servlet-name>
    		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    		<init-param>
    			<param-name>contextConfigLocation</param-name>
    			<param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
    		</init-param>
    		<load-on-startup>1</load-on-startup>
    	</servlet>
    		
    	<servlet-mapping>
    		<servlet-name>appServlet</servlet-name>
    		<url-pattern>/</url-pattern>
    	</servlet-mapping>
    
    </web-app>
    ```
    
- **HandlerMapping**
사용자의 요청을 처리할 요청 url 즉,**@RequestMapping(“/url”)** 에 해당하는 Controller 정보를 저장하는 Table을 통해 매핑함
- **Controller (컨트롤러)**
    
    http request를 개발자가 직접 처리할 수 있게 개발하는 컴포넌트
    
    ```java
    @RequestMapping(value ={ "/login" }, method = RequestMethod.GET)
    	public String login(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {
    
    		List list = masterService.dataList("mapper.admin.AdminMapper", "list", null);
    		model.addAttribute("list", list);
    		
    		return "layout/admin/list";
    	}
    ```
    
- **Service (서비스)**
    
    비즈니스 로직을 수행하는 컴포넌트
    
    ```java
    @Service
    public class BannerService {
    
        @Autowired
        BannerSlaveMapper bannerSlaveMapper;
    
        @Transactional(rollbackFor = Exception.class )
        public List<BannerDAO> bannerList() throws Exception {
    
            List<BannerDAO> bannerList = bannerSlaveMapper.bannerList();
    
            return bannerList;
        }
    
    }
    ```
    
- **DAO (Data Access Object)**
    
    개발자가 직접개발하는 컴포넌트로, MyBatis 사용시 직접적으로 매핑되는 객체
    
- **ViewResolver**
ViewName을 기반으로 어떤 View파일을 사용할 것인지 확인 해주는 컴포넌트
- **View**
개발자가 직접 개발하는 컴포넌트, UI를 의미