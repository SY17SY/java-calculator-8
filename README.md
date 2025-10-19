# java-calculator-precourse

## 기능 목록

### 1. 빈 문자열 처리 (emptyString_returnsZero)

입력값이 빈 문자열(””)인 경우 0을 반환하기

### 2. 숫자 하나 처리 (singleNumber_returnsItself)

입력값이 숫자 하나인 경우 그 숫자를 반환하기

### 3. 콤마(,), 콜론(:) 구분자 처리 (commaOrColonDelimiters_sumNumbers)

입력값이 “,” 또는 “:”를 포함하는 경우, 입력값을 구분자로 분리하고 그 합을 반환하기

### 4. 커스텀 구분자 처리 (customDelimiter_basic)

입력값이 “//”으로 시작하고 “\n”을 포함하는 경우, 입력값을 //와 \n 사이의 구분자로 분리하고 그 합을 반환하기

### 5. 커스텀 구분자 처리 심화

입력값에 커스텀 구분자와 콤마(,), 콜론(:)이 혼재되는 경우, 입력값을 모든 구분자로 분리하고 그 합을 반환하기
(customDelimiter_mixedWithDefaultDelimiter)
커스텀 구분자를 입력할 때 "\n"이 아닌 Enter 키를 입력할 때, 입력값을 구분자로 분리하고 그 합을 반환하기
(customDelimiter_escapeEnter)

### 6. 예외 처리 (throwsOn~)

입력값이 음수를 포함하는 경우 IllegalArgumentException을 던지기
(throwsOnNegativeNumbers)
입력값이 숫자가 아닌 값을 포함하는 경우 IllegalArgumentException을 던지기
(throwsOnNonNumericToken)
입력값의 구분자 형식이 잘못된 경우 IllegalArgumentException을 던지기
(throwsOnInvalidDelimiterSyntax)

### 7. 출력

반환한 값을 “결과 : {합계}” 형식으로 출력하기

### 8. 입력 처리

콘솔을 통해 입력값을 받는다.