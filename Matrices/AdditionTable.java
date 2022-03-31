public class AdditionTable {
  public static void main(String[] args) {
    int[][] additionTable =
          { {0, 1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8},
            {4, 5, 6, 7, 8, 9},
            {5, 6, 7, 8, 9, 10} };

    for(int[] row:additionTable){
            for (int num:row){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}