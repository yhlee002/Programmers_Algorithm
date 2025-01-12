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
	let result = pos;

	if (op_start.localeCompare(result) <= 0 && op_end.localeCompare(result) >= 0) { // 오프닝 구간인지 확인
		result = op_end;
	}

	for (let command of commands) {
		switch (command) {
			case "next":
				const res = plusTime(result, "00:10");
				if (res.localeCompare(video_len) > 0) { // 영상 길이보다 값이 커진 경우
					result = video_len;
				} else { // 영상 길이 이내인 경우
					result = res;
				}
				break;
			case "prev":
			{
				const res = minusTime(result, "00:10");
				if (res.localeCompare("00:00") >= 0) { // 영상 길이 이내인 경우
					result = res;
				} else { // 00:00 보다 값이 작아진 경우
					result = "00:00";
				}
				break;
			}
		}

		if (op_start.localeCompare(result) <= 0 && op_end.localeCompare(result) >= 0) { // 오프닝 구간인지 확인
			result = op_end;
		}
	}

	return result;
}

function plusTime(time0, time1) {
	const time0Min = +time0.split(":")[0];
	const time0Sec = +time0.split(":")[1];
	const time1Min = +time1.split(":")[0];
	const time1Sec = +time1.split(":")[1];

	let min = time0Min + time1Min;
	let sec = time0Sec + time1Sec;

	if (sec >= 60) {
		min++;
		sec -= 60;
	}
	return `${String(min).padStart(2, "0")}:${String(sec).padStart(2, "0")}`;
}

function minusTime(time0, time1) {
	const time0Min = +time0.split(":")[0];
	const time0Sec = +time0.split(":")[1];
	const time1Min = +time1.split(":")[0];
	const time1Sec = +time1.split(":")[1];

	let min = time0Min - time1Min;
	let sec = time0Sec - time1Sec;

	if (sec < 0) {
		min--;
		sec += 60;
	}
	return `${String(min).padStart(2, "0")}:${String(sec).padStart(2, "0")}`;
}