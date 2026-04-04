# [level 4] 그룹별 조건에 맞는 식당 목록 출력하기 - 131124 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131124) 

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > JOIN

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2026년 04월 04일 11:43:08

### 문제 설명

<p style="user-select: auto !important;">다음은 고객의 정보를 담은 <code style="user-select: auto !important;">MEMBER_PROFILE</code>테이블과 식당의 리뷰 정보를 담은  <code style="user-select: auto !important;">REST_REVIEW</code> 테이블입니다. <code style="user-select: auto !important;">MEMBER_PROFILE</code> 테이블은 다음과 같으며 <code style="user-select: auto !important;">MEMBER_ID</code>, <code style="user-select: auto !important;">MEMBER_NAME</code>, <code style="user-select: auto !important;">TLNO</code>, <code style="user-select: auto !important;">GENDER</code>, <code style="user-select: auto !important;">DATE_OF_BIRTH</code>는 회원 ID, 회원 이름, 회원 연락처, 성별, 생년월일을 의미합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">Column name</th>
<th style="user-select: auto !important;">Type</th>
<th style="user-select: auto !important;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">MEMBER_ID</td>
<td style="user-select: auto !important;">VARCHAR(100)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">MEMBER_NAME</td>
<td style="user-select: auto !important;">VARCHAR(50)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">TLNO</td>
<td style="user-select: auto !important;">VARCHAR(50)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">GENDER</td>
<td style="user-select: auto !important;">VARCHAR(1)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">DATE_OF_BIRTH</td>
<td style="user-select: auto !important;">DATE</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">REST_REVIEW</code> 테이블은 다음과 같으며 <code style="user-select: auto !important;">REVIEW_ID</code>, <code style="user-select: auto !important;">REST_ID</code>, <code style="user-select: auto !important;">MEMBER_ID</code>, <code style="user-select: auto !important;">REVIEW_SCORE</code>, <code style="user-select: auto !important;">REVIEW_TEXT</code>,<code style="user-select: auto !important;">REVIEW_DATE</code>는 각각 리뷰 ID, 식당 ID, 회원 ID, 점수, 리뷰 텍스트, 리뷰 작성일을 의미합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">Column name</th>
<th style="user-select: auto !important;">Type</th>
<th style="user-select: auto !important;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">REVIEW_ID</td>
<td style="user-select: auto !important;">VARCHAR(10)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">REST_ID</td>
<td style="user-select: auto !important;">VARCHAR(10)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">MEMBER_ID</td>
<td style="user-select: auto !important;">VARCHAR(100)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">REVIEW_SCORE</td>
<td style="user-select: auto !important;">NUMBER</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">REVIEW_TEXT</td>
<td style="user-select: auto !important;">VARCHAR(1000)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">REVIEW_DATE</td>
<td style="user-select: auto !important;">DATE</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">문제</h5>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">MEMBER_PROFILE</code>와 <code style="user-select: auto !important;">REST_REVIEW</code> 테이블에서 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회하는 SQL문을 작성해주세요. 회원 이름, 리뷰 텍스트, 리뷰 작성일이 출력되도록 작성해주시고, 결과는 리뷰 작성일을 기준으로 오름차순, 리뷰 작성일이 같다면 리뷰 텍스트를 기준으로 오름차순 정렬해주세요.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">예시</h5>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">MEMBER_PROFILE</code> 테이블이 다음과 같고</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">MEMBER_ID</th>
<th style="user-select: auto !important;">MEMBER_NAME</th>
<th style="user-select: auto !important;">TLNO</th>
<th style="user-select: auto !important;">GENDER</th>
<th style="user-select: auto !important;">DATE_OF_BIRTH</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;"><code style="user-select: auto !important;">jiho92@naver.com</code></td>
<td style="user-select: auto !important;">이지호</td>
<td style="user-select: auto !important;">01076432111</td>
<td style="user-select: auto !important;">W</td>
<td style="user-select: auto !important;">1992-02-12</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;"><code style="user-select: auto !important;">jiyoon22@hotmail.com</code></td>
<td style="user-select: auto !important;">김지윤</td>
<td style="user-select: auto !important;">01032324117</td>
<td style="user-select: auto !important;">W</td>
<td style="user-select: auto !important;">1992-02-22</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;"><code style="user-select: auto !important;">jihoon93@hanmail.net</code></td>
<td style="user-select: auto !important;">김지훈</td>
<td style="user-select: auto !important;">01023258688</td>
<td style="user-select: auto !important;">M</td>
<td style="user-select: auto !important;">1993-02-23</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;"><code style="user-select: auto !important;">seoyeons@naver.com</code></td>
<td style="user-select: auto !important;">박서연</td>
<td style="user-select: auto !important;">01076482209</td>
<td style="user-select: auto !important;">W</td>
<td style="user-select: auto !important;">1993-03-16</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;"><code style="user-select: auto !important;">yelin1130@gmail.com</code></td>
<td style="user-select: auto !important;">조예린</td>
<td style="user-select: auto !important;">01017626711</td>
<td style="user-select: auto !important;">W</td>
<td style="user-select: auto !important;">1990-11-30</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">REST_REVIEW</code> 테이블이 다음과 같을 때</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">REVIEW_ID</th>
<th style="user-select: auto !important;">REST_ID</th>
<th style="user-select: auto !important;">MEMBER_ID</th>
<th style="user-select: auto !important;">REVIEW_SCORE</th>
<th style="user-select: auto !important;">REVIEW_TEXT</th>
<th style="user-select: auto !important;">REVIEW_DATE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">R000000065</td>
<td style="user-select: auto !important;">00028</td>
<td style="user-select: auto !important;"><code style="user-select: auto !important;">soobin97@naver.com</code></td>
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">부찌 국물에서 샤브샤브 맛이나고 깔끔</td>
<td style="user-select: auto !important;">2022-04-12</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">R000000066</td>
<td style="user-select: auto !important;">00039</td>
<td style="user-select: auto !important;"><code style="user-select: auto !important;">yelin1130@gmail.com</code></td>
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">김치찌개 최곱니다.</td>
<td style="user-select: auto !important;">2022-02-12</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">R000000067</td>
<td style="user-select: auto !important;">00028</td>
<td style="user-select: auto !important;"><code style="user-select: auto !important;">yelin1130@gmail.com</code></td>
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">햄이 많아서 좋아요</td>
<td style="user-select: auto !important;">2022-02-22</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">R000000068</td>
<td style="user-select: auto !important;">00035</td>
<td style="user-select: auto !important;"><code style="user-select: auto !important;">ksyi0316@gmail.com</code></td>
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">숙성회가 끝내줍니다.</td>
<td style="user-select: auto !important;">2022-02-15</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">R000000069</td>
<td style="user-select: auto !important;">00035</td>
<td style="user-select: auto !important;"><code style="user-select: auto !important;">yoonsy95@naver.com</code></td>
<td style="user-select: auto !important;">4</td>
<td style="user-select: auto !important;">비린내가 전혀없어요.</td>
<td style="user-select: auto !important;">2022-04-16</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">MEMBER_NAME</th>
<th style="user-select: auto !important;">REVIEW_TEXT</th>
<th style="user-select: auto !important;">REVIEW_DATE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">조예린</td>
<td style="user-select: auto !important;">김치찌개 최곱니다.</td>
<td style="user-select: auto !important;">2022-02-12</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">조예린</td>
<td style="user-select: auto !important;">햄이 많아서 좋아요</td>
<td style="user-select: auto !important;">2022-02-22</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">주의사항</h5>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">REVIEW_DATE</code>의 데이트 포맷이 예시와 동일해야 정답처리 됩니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges