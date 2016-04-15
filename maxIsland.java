public class maxIsland{
	public static int m;
	public static int n;
	public static int maxIsland(int[][] matrix){
		if(matrix.length == 0 || matrix[0].length == 0 || matrix == null) return 0;
		m = matrix.length;
		n = matrix[0].length;
		int res = 0;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == 1) res = Math.max(res, helper(matrix, i, j));
			}
		}
		System.out.println(res);
		return res;

	}
	private static int helper(int[][] matrix, int i, int j){
		if(i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] != 1) return 0;
		matrix[i][j] = 0;
		int size = 1;
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		for(int k = 0; k < 4; k++){
			int x = i + dx[k];
			int y = j + dy[k];
			size += helper(matrix, x, y);
		}
		return size;
	}
	public static void main(String[] args){
		int[][] grid = {{0,0,1,1}, {0,1,1,0},{0,1,1,0},{0,0,1,0}};
		maxIsland(grid);
	}
}