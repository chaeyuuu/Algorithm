# [level 1] 달리기 경주 - 178871 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/178871?language=cpp) 

### 성능 요약

메모리: 101 MB, 시간: 282.59 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2026년 04월 06일 12:59:50

### 문제 설명

<p style="user-select: auto !important;">얀에서는 매년 달리기 경주가 열립니다. 해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다. 예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때, 해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것입니다. 즉 "soe" 선수가 1등, "mumu" 선수가 2등으로 바뀝니다.</p>

<p style="user-select: auto !important;">선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 <code style="user-select: auto !important;">players</code>와 해설진이 부른 이름을 담은 문자열 배열 <code style="user-select: auto !important;">callings</code>가 매개변수로 주어질 때, 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">제한사항</h5>

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">5 ≤ <code style="user-select: auto !important;">players</code>의 길이 ≤ 50,000

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;"><code style="user-select: auto !important;">players[i]</code>는 i번째 선수의 이름을 의미합니다.</li>
<li style="user-select: auto !important;"><code style="user-select: auto !important;">players</code>의 원소들은 알파벳 소문자로만 이루어져 있습니다.</li>
<li style="user-select: auto !important;"><code style="user-select: auto !important;">players</code>에는 중복된 값이 들어가 있지 않습니다.</li>
<li style="user-select: auto !important;">3 ≤ <code style="user-select: auto !important;">players[i]</code>의 길이 ≤ 10</li>
</ul></li>
<li style="user-select: auto !important;">2 ≤ <code style="user-select: auto !important;">callings</code>의 길이 ≤ 1,000,000

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;"><code style="user-select: auto !important;">callings</code>는 <code style="user-select: auto !important;">players</code>의 원소들로만 이루어져 있습니다.</li>
<li style="user-select: auto !important;">경주 진행중 1등인 선수의 이름은 불리지 않습니다.</li>
</ul></li>
</ul>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">입출력 예</h5>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">players</th>
<th style="user-select: auto !important;">callings</th>
<th style="user-select: auto !important;">result</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">["mumu", "soe", "poe", "kai", "mine"]</td>
<td style="user-select: auto !important;">["kai", "kai", "mine", "mine"]</td>
<td style="user-select: auto !important;">["mumu", "kai", "mine", "soe", "poe"]</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">입출력 예 설명</h5>

<p style="user-select: auto !important;">입출력 예 #1</p>

<p style="user-select: auto !important;">4등인 "kai" 선수가 2번 추월하여 2등이 되고 앞서 3등, 2등인 "poe", "soe" 선수는 4등, 3등이 됩니다. 5등인 "mine" 선수가 2번 추월하여 4등, 3등인 "poe", "soe" 선수가 5등, 4등이 되고 경주가 끝납니다. 1등부터 배열에 담으면 ["mumu", "kai", "mine", "soe", "poe"]이 됩니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges