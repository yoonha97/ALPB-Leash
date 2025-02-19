## 250218 TIL

- 스프링부트, 그래들, 어노테이션 기반의 프로젝트 시작함
- 테스트코드 작성방법을 배움(TDD)
- 고객정보 프로젝트 구현해봄

### ✅ **변경 사항 간결 정리**

1. **`CustomerRepository` → 인터페이스로 변경**

   - 기존 클래스에서 인터페이스로 변경하여 유연한 구조 적용
   - 구현체(`CustomerRepositoryImpl`)에서 `@Component`로 스프링 관리

2. **`CustomerController` → `Service` 계층 추가하여 분리**

   - 기존에는 `Controller`에서 `Repository`를 직접 호출
   - `CustomerService`를 추가하여 컨트롤러와 데이터 접근을 분리
   - `@Autowired`로 `Service`를 주입받아 의존성 관리

3. **`CustomerService` 추가 (비즈니스 로직 처리)**

   - 고객 조회 시 **예외 처리 추가** (`ID`가 없으면 오류 발생)
   - `AllergicFoodRepository` 활용하여 고객의 **알레르기 정보 포함**

4. **`AllergicFood` 관련 기능 추가**

   - 고객의 알레르기 정보를 `AllergicFoodRepository`에서 조회하도록 변경
   - `Customer` 객체에 `List<AllergicFood>` 필드 추가

5. **`CustomerRepositoryImpl` 개선**

   - `Stream API` 활용하여 `findById()` 메서드 가독성 향상
   - `@Component` 추가하여 스프링 빈으로 관리

6. **전체적인 아키텍처 개선**
   - **Controller → Service → Repository 구조 적용** (MVC 패턴 유지)
   - 비즈니스 로직(Service)과 데이터 접근(Repository) 명확히 분리
   - 스프링의 **의존성 주입(DI) 활용**하여 코드 개선

📌 **결론:**

- **유지보수성 및 확장성 증가**, **스프링의 구조에 맞게 최적화됨** 🚀
