/**
 * 동영상 재생기
 * https://school.programmers.co.kr/learn/courses/30/lessons/340213
 */

const video_len = "10:55"; // 동영상 길이
const pos = "00:05"; // 기능 수행 직전의 재생위치
const op_start = "00:15"; // 오프닝 시작 시각
const op_end = "06:55"; // 오프닝 종료 시간
const commands = ["prev", "next", "next"]; // 사용자의 입력
// 예상 결과: 06:55

function solution(video_len, pos, op_start, op_end, commands) {
	const videoLenSec = getSec(video_len);
	const posSec = getSec(pos);
	const opStartSec = getSec(op_start);
	const opEndSec = getSec(op_end);

	let result = posSec;


	if (opStartSec <= result && opEndSec >= result) { // 오프닝 구간인지 확인
		result = opEndSec;
	}

	for (let command of commands) {
		switch (command) {
			case "next":
				if (result + 10 > videoLenSec) { // 영상 길이보다 값이 커진 경우
					result = videoLenSec;
				} else { // 영상 길이 이내인 경우
					result += 10;
				}
				break;
			case "prev":
			{
				if (result - 10 < 0) { // 영상 길이 이내인 경우
					result = 0;
				} else { // 00:00 보다 값이 작아진 경우
					result -= 10;
				}
				break;
			}
		}

		if (opStartSec <= result && opEndSec >= result) { // 오프닝 구간인지 확인
			result = opEndSec;
		}
	}

	return formatTime(result);
}

function getSec(timeStr) {
	const m = +timeStr.split(":")[0];
	const s = +timeStr.split(":")[1];

	return m * 60 + s;
}

function formatTime(sec) {
	const m = Math.floor(sec / 60);
	const s = sec % 60;

	return `${String(m).padStart(2, "0")}:${String(s).padStart(2, "0")}`;
}