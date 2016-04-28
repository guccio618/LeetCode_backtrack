
public class Le_079_Word_Search {
	public boolean exist(char[][] board, String word) {
	       if(board == null || board.length == 0 || board[0].length == 0){
	           if(word == null || word.length() == 0){
	               return true;
	           } else {
	               return false;
	           }
	       }
	       
	       int row = board.length, col = board[0].length;
	       boolean[][] visited = new boolean[row][col];
	       
	       for(int i = 0; i < row; i++){
	           for(int j = 0; j < col; j++){
	               if(backtrack(board, visited, i, j, word, 0) == true){
	                   return true;
	               }
	           }
	       }
	       
	       return false;
	    }
	    
	    public boolean backtrack(char[][] board, boolean[][] visited, int x, int y, String word, int pos){
	        if(visited[x][y] == true){
	            return false;
	        } else if(pos == word.length() - 1 && board[x][y] == word.charAt(pos)){
	            return true;
	        } else if(pos < word.length() && board[x][y] != word.charAt(pos)){
	            return false;
	        }
	        
	        int[] dx = {1, -1, 0 ,0};
	        int[] dy = {0, 0, 1, -1};
	        
	        visited[x][y] = true;
	        for(int i = 0; i < 4; i++){
	            int newX = x + dx[i];
	            int newY = y + dy[i];
	            
	            if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length){
	                if(backtrack(board, visited, newX, newY, word, pos + 1) == true){
	                    return true;
	                }
	            }
	        }
	        visited[x][y] = false;
	        
	        return false;
	    }
}
