# BDDictionary

## 미션 소개

미션 목표 : Java로 사전 프로그램을 만들어보며 객체 지향 소프트웨어 설계해보기

참고 권장 도서 : 오브젝트

## 미션 스택

- jdk 17
- Java
- H2 DB
- JPA (No Spring Data JPA, 순수 JPA)

## 주요 요구사항

1. 회원 종류를 입력 받는 기능을 구현한다.

    ```
    안녕하세요! BDDictionary 입니다. 어떤 회원으로 이용하시겠어요?
    
    1. 비회원
    2. BDD 회원
    3. 회원 가입
    ```

2. ID/PW를 입력받는 기능을 구현한다.

    ```
    ID/PW를 입력해주세요!
    ```

    - BDD 회원일 경우 ID/PW를 입력 받는다. (틀렸다면 예외 처리한다.)

        ```
        ID 또는 PW가 틀렸습니다! 다시 입력해주세요.
        ```

3. 회원 가입 기능을 구현한다.

    ```
    ID를 입력해주세요.
    > asdf
    PW를 입력해주세요.
    > asdf
    PW를 다시 한번 입력해주세요.
    > asdf
    ```

    - ID 중복 유효성 검사를 한다.
    - PW를 두번 입력받아 동일한 PW로 가입했는지 확인한다.
4. 이용할 기능을 입력받는 기능을 구현한다.

    ```
    이용하실 기능을 선택해주세요.
    
    1. 한영 사전
    2. 영한 사전
    3. BDD 사전
    4. 종료
    ```

    - 비회원은 한영, 영한 사전만 이용할 수 있다.
    - BDD 회원은 모든 사전을 이용할 수 있다.
    - 접근 권한이 없는 회원이 해당 기능을 사용할 경우 예외처리한다.

        ```
        비회원은 [BDD 사전]에 접근할 권한이 없습니다. 회원 가입을 해주세요.
        ```

    - 기능의 한 사이클 이용이 끝나면, 다시 이용할 사전을 묻는다.
    - 단, 4번 종료를 선택했을 경우 프로그램은 종료한다.
5. 한영 사전 기능을 구현한다.

    ```
    단어를 입력해주세요.
    ```

    - 한영 사전은 한글을 입력받고, 그것에 대응하는 영어 단어를 반환하는 사전이다.
    - 등록된 단어가 없다면, 사용자에게 새로운 단어를 등록할 것인지 묻는다.

        ```
        > 사과
        [사과] : 단어는 등록되어 있지 않습니다. 새로운 단어를 등록하시겠어요? (yes/no로 대답해주세요.)
        > yes
        한글 : 영어 형식으로 입력해주세요.
        > 사과 : apple
        [사과 : apple] 등록되었습니다.
        ```

    - 문장 형태의 입력에 대해서도 응답을 할 수 있다. 단, 저장되어 있지 않은 단어가 포함되어 있다면 예외처리 한다.

        ```
        > 사과 하나 주세요
        apple one please
        > 사과 맛있다
        [맛있다] : 단어는 등록되어 있지 않습니다. 새로운 단어를 등록하시겠어요? (yes/no로 대답해주세요.)
        ```

6. 영한 사전 기능을 구현한다.

    ```
    단어를 입력해주세요.
    ```

    - 영한 사전은 영어를 입력받고, 그것에 대응하는 한글 단어를 반환하는 사전이다.
    - 등록된 단어가 없다면, 사용자에게 새로운 단어를 등록할 것인지 묻는다.

        ```
        [apple] : 단어는 등록되어 있지 않습니다. 새로운 단어를 등록하시겠어요? (yes/no로 대답해주세요.)
        ```

        ```
        > yes
        영어 : 한글 형식으로 입력해주세요.
        > apple : 사과
        [apple : 사과] 등록되었습니다.
        ```

7. BDD 사전 기능을 구현한다.

    ```
    단어를 입력해주세요.
    > hello
    [hello] : 단어는 등록되어 있지 않습니다. 새로운 단어를 등록하시겠어요? (yes/no로 대답해주세요.)
    > yes
    단어 : BDD 언어 형식으로 입력해주세요.
    > hello : ddd
    [ddd]는 BDD 언어 규칙에 맞지 않습니다. BDD 언어의 규칙은 다음과 같습니다.
    - B(b), D(d), 비, 디 만 사용할 수 있다.
    - 공백은 포함될 수 없다.
    - 모든 단어는 B(b) 또는 비로 시작하고 연속된 두개의 D(d) 또는 디로 끝난다.
    > hello : bdd
    [bdd]는 이미 존재하는 BDD 언어입니다.
    > hello : bdbdd
    [hello : bdbdd] 등록되었습니다.
    ```

    - BDD에는 BDD 회원들이 쓰는 BDD 언어가 있다. 특정 단어를 입력하면, 대응하는 BDD 언어를 반환하는 BDD 사전을 구현한다.
    - **새로운 BDD 언어 등록 기능을 구현한다.**
        - BDD 언어 규칙
            - `B(b)`, `D(d)`, `비`, `디` 만 사용한다.
            - 공백 입력은 할 수 없다.
            - 모든 단어는 `B(b, 비)`로 시작하고 연속된 두개의 `D(d, 디)`로 끝난다.
        - 이미 존재하는 BDD 언어는 새로 등록할 수 없다.

8. 단어들은 H2 DB에 저장하고, 불러올 수 있어야 한다.

### 미션 요구사항

- 구현하기 전에 객체를 먼저 설계하도록 하고, 객체 설계도를 함께 제출하라.
- 기능 명세서를 먼저 작성하고, 구현하면서 명세서를 수정해 나가도록 하라.
- 모든 테스트 코드가 통과해야 한다.
- 순수 JPA를 사용한다.
- 데이터들은 H2 DB에 저장하고, 조회할 수 있어야 한다.

### 미션 권장 사항

- 하나의 함수가 하나의 작업만 수행하도록 구성하라.
- 하나의 객체가 하나의 역할만을 책임지도록 설계하라.
- 새로운 사전이 유연하게 추가될 수 있도록 설계하라.
- 디미터의 법칙을 따르라. Java의 관점에서, 오직 하나의 도트만을 사용하라. (단, 도트로 인해 객체의 내부 구조가 외부로 노출되지 않는다면 가능하다.)

    ```java
    Ticket ticket = ticketSeller.getTicketOffice().getTicket();
    audience.getBag().minusAmount(ticket.getFee());
    ```

    ```java
    IntStream.of(1, 15, 20, 3, 9).filter(x -> x > 10).distinct().count();
    ```
