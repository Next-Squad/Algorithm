package org.example.mar;

import java.util.*;

public class 퍼즐조각채우기_0314 {

	int N;
	int PN;
	int[][] gameBoard;
	int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	List<List<Integer>> permutations = new ArrayList<>();
	List<List<int[]>> places = new ArrayList<>();

	public int solution(int[][] game_board, int[][] table) {
		int answer = 0;

		N = gameBoard.length;
		gameBoard = new int[3*N-2][3*N-2];
		for (int i = N; i < 2*N; i++) {
			for (int j = N; j < 2*N; j++) {
				gameBoard[i][j] = game_board[N-i][N-j];
			}
		}
		// init(gameBoard, 0, places); // 빈 지역을 리스트에 추가
		// PN = places.size(); // 빈지역 리스트의 원소 개수만큼 순열 만들기
		// backTracking(new ArrayList<>(), new boolean[PN]);

//
//		for (int i = 0; i < 4; i++) {
//			gameBoard = rotate(gameBoard);
//			for (int i = 0; i < 3*N - 2; i++) {
//				for (int j = 0; j < 3*N - 2; j++) {
//
//				}
//			}
//
//		}



		return answer;
	}



	int[][] rotate(int[][] table) {
		int[][] newTable = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newTable[j][N-1-i] = table[i][j];
			}
		}

		return newTable;
	}


	void init(int[][] board, int diff, List<List<int[]>> arr) { // diff : board일 때 0, block일 때 1
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == diff && !visited[i][j]) {
					List<int[]> place = new ArrayList<>();
					visited[i][j] = true;
					place.add(new int[]{i, j});
					diff += 1;
					diff %= 2;
					dfs(i, j, place, board, diff, visited);
					arr.add(place);
				}
			}
		}
	}

	void dfs(int x, int y, List<int[]> place, int[][] board, int diff, boolean[][] visited) {
		int nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = x + d[i][0];
			ny = y + d[i][1];
			if (checkRange(nx, ny)) {
				if (board[nx][ny] == diff && !visited[nx][ny]) {
					visited[nx][ny] = true;
					place.add(new int[]{nx, ny});
					dfs(nx, ny, place, board, diff, visited);
				}
			}
		}
	}

	boolean checkRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	void backTracking(List<Integer> arr, boolean[] visited) {
		if (arr.size() == PN) {
			permutations.add(arr);
			return;
		}

		for (int i = 0; i < PN; i++) {
			if (!visited[i]) {
				visited[i] = true;
				List<Integer> tmp = new ArrayList<>(arr);
				tmp.add(i);
				backTracking(tmp, visited);
				visited[i] = false;
			}
		}
	}
}
