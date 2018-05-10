package jassonrm.a8queens;

class Queens {

    public static int[] queens;
    public static int count = 1;


    /***************************************************************************
     * Return true if queen placement q[n] does not conflict with
     * other queens q[0] through q[n-1]
     ***************************************************************************/
    public static boolean isConsistent(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n]) {
                return false;   // same column
            }
            if ((q[i] - q[n]) == (n - i)) {
                return false;   // same major diagonal
            }
            if ((q[n] - q[i]) == (n - i)) {
                return false;   // same minor diagonal
            }
        }
        return true;
    }

    /***************************************************************************
     * Prints n-by-n placement of queens from permutation q in ASCII.
     ***************************************************************************/
    public static void printQueens(int[] q) {
        int n = q.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j) {
                    System.out.print("Q ");
                } else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }


    /***************************************************************************
     *  Try all permutations using backtracking
     ***************************************************************************/
    public static void enumerate(int n, int board) {

        enumerate(new int[n], 0,board);
    }

    public static boolean enumerate(int[] q, int k, int board) {
        int n = q.length;
        if (k == n) {
            if (count == board){

                queens = q;
                count = 1;
                return true;
            }else{
                count++;
                return false;
            }
        } else {
            for (int i = 0; i < n; i++) {
                q[k] = i;
                if (isConsistent(q, k)) {
                    if (enumerate(q, k+1,board) == true){
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
