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

- DispatcherServlet
Spring Framework가 제공하는 Servlet 클래스
    
    
- HandlerMapping
사용자의 요청을 처리할 Controller를 찾는다. (Controller URL Mapping)
요청 url에 해당하는 Controller 정보를 저장하는 table을 가진다.
즉, 클래스에 @RequestMapping(“/url”) annotaion을 명시하면 해당 URL에 대한 요청이 들어왔을 때 table에 저장된 정보에 따라 해당 클래스 또는 메서드에 Mapping한다.
- ViewResolver