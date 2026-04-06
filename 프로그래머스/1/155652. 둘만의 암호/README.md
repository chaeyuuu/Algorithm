# [level 1] 둘만의 암호 - 155652 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/155652?language=java) 

### 성능 요약

메모리: 86.7 MB, 시간: 0.39 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2026년 04월 06일 15:02:53

### 문제 설명

<p style="user-select: auto !important;">두 문자열 <code style="user-select: auto !important;">s</code>와 <code style="user-select: auto !important;">skip</code>, 그리고 자연수 <code style="user-select: auto !important;">index</code>가 주어질 때, 다음 규칙에 따라 문자열을 만들려 합니다. 암호의 규칙은 다음과 같습니다.</p>

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">문자열 <code style="user-select: auto !important;">s</code>의 각 알파벳을 <code style="user-select: auto !important;">index</code>만큼 뒤의 알파벳으로 바꿔줍니다.</li>
<li style="user-select: auto !important;"><code style="user-select: auto !important;">index</code>만큼의 뒤의 알파벳이 <code style="user-select: auto !important;">z</code>를 넘어갈 경우 다시 <code style="user-select: auto !important;">a</code>로 돌아갑니다.</li>
<li style="user-select: auto !important;"><code style="user-select: auto !important;">skip</code>에 있는 알파벳은 제외하고 건너뜁니다.</li>
</ul>

<p style="user-select: auto !important;">예를 들어 <code style="user-select: auto !important;">s</code> = "aukks", <code style="user-select: auto !important;">skip</code> = "wbqd", <code style="user-select: auto !important;">index</code> = 5일 때, a에서 5만큼 뒤에 있는 알파벳은 f지만 [b, c, d, e, f]에서 'b'와 'd'는 <code style="user-select: auto !important;">skip</code>에 포함되므로 세지 않습니다. 따라서 'b', 'd'를 제외하고 'a'에서 5만큼 뒤에 있는 알파벳은 [c, e, f, g, h] 순서에 의해 'h'가 됩니다. 나머지 "ukks" 또한 위 규칙대로 바꾸면 "appy"가 되며 결과는 "happy"가 됩니다.</p>

<p style="user-select: auto !important;">두 문자열 <code style="user-select: auto !important;">s</code>와 <code style="user-select: auto !important;">skip</code>, 그리고 자연수 <code style="user-select: auto !important;">index</code>가 매개변수로 주어질 때 위 규칙대로 <code style="user-select: auto !important;">s</code>를 변환한 결과를 return하도록 solution 함수를 완성해주세요.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">제한사항</h5>

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">5 ≤ <code style="user-select: auto !important;">s</code>의 길이 ≤ 50</li>
<li style="user-select: auto !important;">1 ≤ <code style="user-select: auto !important;">skip</code>의 길이 ≤ 10</li>
<li style="user-select: auto !important;"><code style="user-select: auto !important;">s</code>와 <code style="user-select: auto !important;">skip</code>은 알파벳 소문자로만 이루어져 있습니다.

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;"><code style="user-select: auto !important;">skip</code>에 포함되는 알파벳은 <code style="user-select: auto !important;">s</code>에 포함되지 않습니다.</li>
</ul></li>
<li style="user-select: auto !important;">1 ≤ <code style="user-select: auto !important;">index</code> ≤ 20</li>
</ul>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">입출력 예</h5>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">s</th>
<th style="user-select: auto !important;">skip</th>
<th style="user-select: auto !important;">index</th>
<th style="user-select: auto !important;">result</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">"aukks"</td>
<td style="user-select: auto !important;">"wbqd"</td>
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">"happy"</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">입출력 예 설명</h5>

<p style="user-select: auto !important;">입출력 예 #1<br style="user-select: auto !important;">
본문 내용과 일치합니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges