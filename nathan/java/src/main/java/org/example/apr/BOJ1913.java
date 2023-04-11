package org.example.apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1913 {

	static int n = 0, m = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		int[][] matrix = new int[n][n];
		int[] now = {n/2, n/2};
		int cnt = 1;
		int d = 0;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int nx = 0, ny = 0;
		int[] result = new int[2];

		for (int i = 0; i < n*n; i++) {
			matrix[now[0]][now[1]] = cnt++;
			if (matrix[now[0]][now[1]] == m) {
				result = new int[]{now[0]+1, now[1]+1};
			}

			for (int j = 0; j < 4; j++) {
				nx = now[0] + dx[d%4];
				ny = now[1] + dy[d%4];
				if (0 > nx || nx >= n || 0 > ny || ny >= n) {
					continue;
				}

				if (matrix[nx][ny] == 0) {
					now[0] = nx;
					now[1] = ny;
					d++;
					break;
				} else {
					now[0] += dx[(d-1)%4];
					now[1] += dy[(d-1)%4];
					break;
				}

			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(matrix[i][j])
					.append(" ");
			}
			sb.append("\n");
		}
		sb.append(result[0])
			.append(" ")
			.append(result[1]);
		System.out.println(sb);
	}

}
