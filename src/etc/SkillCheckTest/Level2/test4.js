/**
문제 설명
H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.

어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.

어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

제한사항
과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
입출력 예
citations	return
[3, 0, 6, 1, 5]	3
 */

const citations = [8, 6, 5, 2, 1]; // [3, 0, 6, 1, 5];
console.log(solution(citations));

function solution(citations) {
	let hIdx = -1;
	// 시간 복잡도 높음
	// for (let i = 0; i < citations.length; i++) {
	// 		const upper = citations.filter(c => c >= i + 1);
	// 		if (upper.length >= i + 1) {
	// 			hIdx = Math.max(hIdx, i + 1);
	// 		}
	// }

	// 개선 결과
	citations.sort((a, b) => b - a); // desc
	for (let i = 0; i < citations.length; i++) { // 아무리 개별 요소의 값(인용 횟수)가 커도, 결국 'h개 이상인 값'은 배열의 크기를 벗어나지 못하므로 배열의 크기 내에서 찾음
		// 조건: 인용된 횟수가 h 이상인 값이 h개 이상일 때
		// -> citations[0] ~ citations[i]의 숫자들(인용된 횟수이자, 나열된 순서, 비교하려는 인용 횟수 값의 개수. 즉, i + 1개의 수)가 i + 1 이상일 때
		if (citations[i] >= i + 1) {
			hIdx = Math.max(hIdx, i + 1);
		}
	}

	return hIdx;
}