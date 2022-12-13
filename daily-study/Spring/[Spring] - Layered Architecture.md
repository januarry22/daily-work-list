# [Spring] - Layered Architecture

```html
- ****Layered Architecture 의 개념
- Layered Architecture 의 구조****
```

## 1. ****Layered Architecture 란?****

- 효율적인 유지보수를 위해 어플리케이션을 계층화하여 개발하는 것을 의미
- 한 레이어는 자신의 고유 역할을 수행하고, 인접한 다른 레이어에 행위를 요청하거나 응답함
- 시스템을 레이어로 나눔으로써 시스템 전체를 수정하지 않고도, 특정 레이어의 기능이나 성능을 개선할 수 있음

```html
❓ Layer란 관심사들의 집합을 의미. 관심사별로 층을 많이 나누면 구조가 복잡해지기 때문에 관심사들을
	묶어 계층으로 표현함
	1. 소프트웨어를 만들 때, 관심사를 명확히 알고 Layer에 관심사를 정
	2. 분리하되, 너무 많은 Layer를 생성하지 않음
```

## 2. ****Layered Architecture 의 구조****

![https://sites.google.com/site/telosystutorial/_/rsrc/1468866606851/springmvc-jpa-springdatajpa/presentation/architecture.png](https://sites.google.com/site/telosystutorial/_/rsrc/1468866606851/springmvc-jpa-springdatajpa/presentation/architecture.png)

### **Presentation Layer**

✔️  **사용자와 가장 가까운 계층으로 사용자의 요청을 받고 그에 반응함**

✔️  **Dispatcher Servlet(프론트 컨트롤러), Controller, View, Model** 

```java
@RestController
public class BannerRestController {

	@GetMapping("/api/v1/banner")
	@ApiOperation(value = "배너 리스트")
	public ApiResponse bannerList(HttpServletRequest httpRequest) throws Exception {
      ApiResponse apiRes = new ApiResponse();
      return apiRes;
	}

}
```

- 사용자에게 View를 노출
- 사용자의 특정 요청을 Dispatcher Servlet이 적절한 Controller에 전달 또는 Exeption처리
- 요청을 받은 Controller는 사용자에게 적절한 View또는 응답값을 하위 레이어에 요청하고 전달함
    - Controller는 데이터를 전달할 책임만 있을뿐 접근할 책임이 없으므로 하위 레이어에 접근을 요청
    

### **Service Layer (Business Layer)**

✔️  **비즈니스 로직을 구현함**

✔️  **Transaction 처리**

```java
@Service
public class BannerService {

    @Autowired 
    BannerSlaveMapper bannerSlaveMapper;

    @Transactional(rollbackFor = Exception.class )
    public List<BannerDAO> bannerList() throws Exception {
        List<BannerDAO> bannerList = bannerSlaveMapper.bannerList();
				// 추가적인 작업 로직을 추가 할 수 있음
        return bannerList;
    }

}
```

- 실제 비즈니스 로직을 수행하거나 트랜잭션(@Transactional 어노테이션) 을 수행
- 데이터를 조작하는 로직이 하나의 단위로 수행되어야 할때, 하나의 비즈니스 로직으로 하나의 트랜잭션(ACID)를 수행
    - DB에 직접적으로 접근하지 않고, 데이터 조작은 하위 레이어인 Data Access Layer에 요청
- @Autowired 어노테이션은 DI기능으로 자동으로 의존관계를 맺어줌

### **Repository Layer (Data Access Layer)**

✔️  **내부 저장소 (DB)에 접근하여 데이터의 조작을 담당함**

✔️  **DB에 저장된 값을 가져오기 위해 MyBatis, JPA 등으로 구현한 DAO**

```java
@Mapper
public interface BannerSlaveMapper {
    List<BannerDAO> bannerList();
}
```