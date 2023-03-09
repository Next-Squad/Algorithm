package org.example.mar;

import java.awt.Point;
import java.util.*;

public class 카드짝맞추기0308 {

	public static void main(String[] args) {
		카드짝맞추기0308 m = new 카드짝맞추기0308();
		int result = m.solution(
			new int[][]{{1, 0, 0, 3},{2, 0, 0, 0},{0, 0, 0, 2},{3, 0, 1, 0}},
			1, 0
		);
		System.out.println(result);
	}

	Set<Integer> numberOfCards = new HashSet<>();
	Queue<Point> queue = new LinkedList<>();
	int answer = Integer.MAX_VALUE;
	int[][] BOARD;
	// 상 하 좌 우
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};

	public int solution(int[][] board, int r, int c) {
		BOARD = board;
		init(r, c);
		bfs();

		return answer;
	}

	void init(int r, int c) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (BOARD[i][j] != 0) {
					numberOfCards.add(BOARD[i][j]);
				}
			}
		}
		queue.add(new Point(r, c, 0, 0, new ArrayList<>()));
	}

	void bfs() {
		int nx, ny;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			if (confirmNow(now)) { // 현재 위치 확인
				continue;
			}
			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (rangeCheck(nx, ny)) {
					queue.add(new Point(
						nx, ny, now.card, now.cmd+1, new ArrayList<>(now.check)
					));
					if (BOARD[nx][ny] > 0) {
						continue;
					}
					searchCard(nx, ny, i, now);
				}

			}

		}
	}

	boolean searchCard(int nx, int ny, int d, Point now) {
		if (d == 0) {
			for (int i = nx-1; i >= 0; i--) {
				if (rangeCheck(i, ny)) {
					if (BOARD[i][ny] > 0) {
						queue.add(new Point(
							i, ny, now.card, now.cmd+1, new ArrayList<>(now.check)
						));
						return true;
					}
				} else {
					return false;
				}
			}
		}

		if (d == 1) {
			for (int i = nx+1; i < 4; i++) {
				if (rangeCheck(i, ny)) {
					if (BOARD[i][ny] > 0) {
						queue.add(new Point(
							i, ny, now.card, now.cmd+1, new ArrayList<>(now.check)
						));
						return true;
					}
				} else {
					return false;
				}
			}
		}

		if (d == 2) {
			for (int i = ny-1; i >= 0; i--) {
				if (rangeCheck(nx, i)) {
					if (BOARD[nx][i] > 0) {
						queue.add(new Point(
							nx, i, now.card, now.cmd+1, new ArrayList<>(now.check)
						));
						return true;
					}
				} else {
					return false;
				}
			}
		}

		if (d == 3) {
			for (int i = ny+1; i < 4; i++) {
				if (rangeCheck(nx, i)) {
					if (BOARD[nx][i] > 0) {
						queue.add(new Point(
							nx, i, now.card, now.cmd+1, new ArrayList<>(now.check)
						));
						return true;
					}
				} else {
					return false;
				}
			}
		}
		return false;
	}

	boolean confirmNow(Point now) {
		if (now.card == 0) { // 아무 카드도 뒤집히지 않은 경우
			if (BOARD[now.x][now.y] > 0) {
				now.cmd++; // ENTER
				now.card = BOARD[now.x][now.y];
				BOARD[now.x][now.y] = (-1) * BOARD[now.x][now.y]; // 방문한건 음수로 변경
			}
		} else {             // 카드가 이미 뒤집혀 있는 경우
			if (BOARD[now.x][now.y] == now.card) {
				now.check.add(now.card);
				now.card = 0;
				BOARD[now.x][now.y] = (-1) * BOARD[now.x][now.y]; // 방문한건 음수로 변경
				now.cmd++; // ENTER
				if (finish(now)) {
					answer = Math.min(answer, now.cmd);
					return true;
				}
			}
		}
		return false;
	}


	boolean finish(Point now) {
		return now.check.size() == numberOfCards.size();
	}

	boolean rangeCheck(int r, int c) {
		return 0 <= r && r < 4 && 0 <= c && c < 4;
	}


	class Point { // 위치, 뒤집은 카드(default 0), 커맨드 횟수
		int x;
		int y;
		int card;
		int cmd;
		List<Integer> check;

		Point(int x, int y, int card, int cmd, List<Integer> check) {
			this.x = x;
			this.y = y;
			this.card = card;
			this.cmd = cmd;
			this.check = check;
		}
	}
}
