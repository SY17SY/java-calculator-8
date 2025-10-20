# 우아한테크코스 8기 프리코스

1주차 미션: 문자열 덧셈 계산기

---

## 기능 목록

- [x] 사용자가 빈 문자열을 입력할 경우, 0을 반환한다.
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
- [x] 쉼표를 구분자로 사용해 숫자를 분리하고 합을 반환한다.
- [x] 콜론를 구분자로 사용할 숫자를 분리하고 합을 반환한다.
- [x] 커스텀 구분자를 지원한다.
    - [x] "//"와 "\n" 사이의 문자를 커스텀 구분자로 사용한다.
- [x] 사용자의 입력 요구와 그에 따른 결과를 출력하는 애플리케이션 플로우를 구현한다.
    - [x] 사용자의 입력을 요구하는 문구를 출력한다.
    - [x] 사용자로부터 문자열을 입력받는다.
    - [x] 계산 결과를 출력한다.

---

## 예외 처리 목록

- [x] 음수를 입력할 경우 `IllegalArgumentException`을 발생시킨다.
- [x] 숫자가 아닌 값을 입력할 경우 `IllegalArgumentException`을 발생시킨다.
- [x] 사용자가 정수형 범위 밖의 숫자를 입력할 경우 `IllegalArgumentException`을 발생시킨다.

---

## 개선점

- [x] Separator 클래스의 추상화
    - [x] NumberSeparator 책임 분리
    - [x] StringSeparator 책임 분리
- [x] SeparatorGenerator 클래스의 추상화
    - [x] CustomSeparatorGenerator 책임 분리
    - [x] DefaultSeparatorGenerator 책임 분리
- [x] Validator 클래스 정의
    - [x] 음수 Validator 클래스 정의
- [x] 예외 케이스 추가
    - [x] 구분자가 숫자인 경우
    - [x] 입력 값의 범위가 정수 범위를 벗어나는 경우
    - [x] 구분자를 한글을 입력 받았을 경우