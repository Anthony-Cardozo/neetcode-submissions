class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<Integer, Set<Character>> box = new HashMap<>();
        for(int i = 0; i<9; i++)
        {
            
            row.put(i, new HashSet<Character>());
            col.put(i, new HashSet<Character>());
            box.put(i, new HashSet<Character>());
        }

        for(int i = 0; i<9; i++)
        {
            
            for(int j = 0; j<9; j++)
            {
                
                if(board[i][j]=='.')
                    continue;
            
                if(!row.get(i).add(board[i][j]))
                    return false;
                if(!col.get(j).add(board[i][j]))
                    return false;
                if(!box.get((i/3)*3+(j/3)).add(board[i][j]))
                    return false;

            }
        }
        return true;

    }
}