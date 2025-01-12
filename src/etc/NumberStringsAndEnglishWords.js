/**
 * 숫자 문자열과 영단어
 * https://school.programmers.co.kr/learn/courses/30/lessons/81301?language=javascript
 */

const s = "one4seveneight";
console.log(solution(s));

function solution(s) {
	const map = new Map([
		["zero", 0],
		["one", 1],
		["two", 2],
		["three", 3],
		["four", 4],
		["five", 5],
		["six", 6],
		["seven", 7],
		["eight", 8],
		["nine", 9]
	]);

	let number = "";
	let str = "";
	for (let c of s) {
		if (!Number.isNaN(Number(c))) {
			number += c;
		} else {
			str += c;
			if (map.get(str) != null) {
				number += map.get(str);
				str = "";
			}
		}
	}

	return +number;
}