## 250220 TIL

- JPA 적용
- 간단한 CRUD 로직 완성

## 추가 상세 설명

### 1️⃣ JPA Repository 활용

- `JpaRepository`를 사용하여 기본 CRUD 메서드를 자동으로 제공받음.
- 메서드 네이밍 규칙만으로 JPQL 없이 쿼리를 실행할 수 있어 코드가 간결해짐.
- 기존에 직접 구현했던 `findAll()`, `findById()`, `save()` 등의 메서드가 필요 없어짐.

### 2️⃣ Lombok 적용으로 코드 간소화

- `@Getter`, `@Setter`, `@NoArgsConstructor`, `@AllArgsConstructor`, `@Builder` 등을 적용하여 코드량을 줄이고 가독성을 높임.
- 빌더 패턴을 활용해 객체를 더 쉽게 생성할 수 있어 가독성이 향상됨.

### 3️⃣ JPA 관계 매핑 (`@ManyToOne`) 적용

- 메뉴(`MenuItem`)가 특정 레스토랑(`Restaurant`)에 속하는 관계를 `@ManyToOne`으로 설정.
- 외래 키(`restaurant_id`)를 설정하여 데이터의 무결성을 유지.
- JSON 직렬화 시 순환 참조를 방지하기 위해 `@JsonBackReference`를 적용.

### 4️⃣ 트랜잭션 적용 (`@Transactional`)

- `@Transactional`을 사용하여 데이터 변경 작업을 하나의 트랜잭션으로 묶어 실행.
- 레스토랑을 찾고 메뉴를 추가하는 과정이 원자적으로 실행되도록 보장.
- 중간에 예외가 발생하면 전체 작업이 롤백되어 데이터 정합성이 유지됨.

### 5️⃣ REST API 컨트롤러 적용

- `@RestController`를 활용해 RESTful API를 구현.
- `@PostMapping`, `@GetMapping`, `@PatchMapping`, `@DeleteMapping`을 사용하여 CRUD API를 완성.
- API 요청 시 `restaurantId`를 경로 변수로 받아 특정 레스토랑의 메뉴를 관리할 수 있도록 설계.
