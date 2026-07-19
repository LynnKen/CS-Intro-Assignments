public class Assignment2 {

    // task 1.1
    // No input assumptions
    // Checks if the given matrix is a valid instance of the Big Trip Problem
    public static boolean isLegalInstance(boolean[][] matrix) {
        boolean result = false; // default return value
        // ---------------write your code BELOW this line only! ------------------
        if (matrix == null)
            throw new IllegalArgumentException();
        if (matrix.length > 0) {
            result = isSymmetricMatrix(matrix) && isSquareMatrix(matrix) && isAntiReflexiveMatrix(matrix);
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 1.2
    // Assumes matrix is not null
    // Checks if the matrix is square.
    public static boolean isSquareMatrix(boolean[][] matrix) {
        boolean result = true; // default return value
        // ---------------write your code BELOW this line only! ------------------
        if (matrix == null)
            throw new IllegalArgumentException();
        int nLength = matrix.length;
        if (nLength < 0)
            result = false;
        else {
            for (int i = 0; i < nLength; i++) {
                if (matrix[i] == null)
                    throw new IllegalArgumentException();
                if (matrix[i].length != nLength) //מה קורה אם המערך ריק? להריץ בדיקה
                    result = false;
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }
    
    // task 1.3
    // Assumes matrix is a non-null, square boolean matrix.
    // Checks if the matrix is symmetric.
    public static boolean isSymmetricMatrix(boolean[][] matrix) {
        boolean result = true; // default return value
        // ---------------write your code BELOW this line only! ------------------
        if (matrix==null || !(isSquareMatrix(matrix)) )
            throw new IllegalArgumentException();
        for (int i = 0; i < matrix.length ; i++) { //הורדתי בדיקת NULL במקום הI כי כבר קורה בהאם ריבועית
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != matrix[j][i])
                    result = false;
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 1.4
    // Assumes matrix is a non-null, square boolean matrix.
    // Checks if the matrix is anti-reflexive (no self-loops).
    public static boolean isAntiReflexiveMatrix(boolean[][] matrix) {
        boolean result = true; // default return value
        // ---------------write your code BELOW this line only! ------------------
        if (matrix == null || !(isSquareMatrix(matrix)))
            throw new IllegalArgumentException();
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] == true)
                result = false;
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 1.5
    // Assumes flights is a boolean matrix representing valid flights
    // and tour is an array of integers matching the size of flights.
    // Validates if the given tour is a correct solution for the flight's matrix.
    public static boolean isValidSolution(boolean[][] flights, int[] tour) {
        boolean result = true; // default return value
        // ---------------write your code BELOW this line only! ------------------
        if (!isLegalInstance(flights) || tour == null) //if flights is null:throw Illegal in the function
            throw new IllegalArgumentException();
        if (flights.length < 1 || tour.length != flights.length)
            throw new IllegalArgumentException();
        if (tour[0] != 0 || !isPermutation(tour) || !areStepsLegal(flights, tour))
            result = false;
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 1.6
    // Assumes array is not null
    // Checks if the array is a permutation of numbers from 0 to array.length-1.
    public static boolean isPermutation(int[] array) {
        boolean result = true; // default return value, CHANGED IT TO TRUE.
        // ---------------write your code BELOW this line only! ------------------
        if (array == null)
            throw new IllegalArgumentException();

        for (int numToCheck = 0; result && numToCheck < array.length; numToCheck++) {
            int count = 0;
            for (int i = 0; i < array.length && count <= 2; i++) {
                if (array[i] == numToCheck)
                    count++;
            }
            if (count != 1)
                result = false;
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 1.7
    // Assumes flights is a valid instance matrix and tour only includes valid city indices
    // Checks if there are legal flights between consecutive cities in the tour.
    public static boolean areStepsLegal(boolean[][] flights, int[] tour) {
        boolean result = true;
        // ---------------write your code BELOW this line only! ------------------
        if (!isLegalInstance(flights) || flights.length<1)
            throw new IllegalArgumentException();
        for (int i = 0; i < tour.length; i++) {
            int tourVal = tour[i];
            int followUpVal = tour[(i + 1) % tour.length]; //in order to go back to 0
            if (!flights[tourVal][followUpVal])
                result = false;
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    ///////////////////////////////////
    /////// Part 1 ends here ////////
    ///////////////////////////////////

    // Assumes n is a non-negative integer.
    // Creates an array of integers from 0 to n-1.
    public static int[] createRange(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i;
        }
        return res;
    }

    // Assumes source and destination arrays are of the same length.
    // Copies the contents of source array into destination array.
    public static void copyArray(int[] source, int[] destination) {
        if (source == null || destination == null || source.length != destination.length) {
            throw new IllegalArgumentException("Source and null must be initialized arrays of the same length.");
        }
        for (int i = 0; i < source.length; i++) {
            destination[i] = source[i];
        }
    }

    // Assumes n is a non-negative integer.
    // Computes the factorial of n.
    public static int factorial(int n) {
        if (n<0) {
            throw new IllegalArgumentException("n must be non-negative.");
        }
        int res = 1;
        for(; n > 1; n--) {
            res = res * n;
        }
        return res;
    }

    // task 2.1
    // Assumes n is a positive integer.
    // Generates all permutations of numbers from 0 to n-1 using the Johnson-Trotter algorithm.
    public static int[][] generatePermutations(int n) {
        int[][] result = null; // default return value
        // ---------------write your code BELOW this line only! ------------------
        if (n<1)
            throw new IllegalArgumentException(); //if n is not positive
        int[] permutation=createRange(n);
        int[] direction=new int[n];
        for (int i=0; i<n ;i++){
            direction[i]=-1;
        }
        result=new int[factorial(n)][n]; //אתחול
        copyArray(permutation,result[0]); //איך אני יודעת שקיים RESULT]0[?

        int mobileIndex = findMobileIndex(permutation,direction);
        int counter = 1; //result restarted already in [0]
        while (mobileIndex !=-1) { //mobileIndex<n, no need to check counter

            int mobileElement=permutation[mobileIndex];
            swap(permutation,direction,mobileIndex);
            reverseDirections(permutation,direction,mobileElement);
            copyArray(permutation,result[counter]);

            counter++;
            mobileIndex = findMobileIndex(permutation, direction);
        }

        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 2.2
    // Assumes permutation and directions are arrays of the same length.
    // Swaps elements in permutation and directions based on the mobile index.
    public static void swap(int[] permutation, int[] directions, int mobileIndex) {
        // ---------------write your code BELOW this line only! ------------------
        if (!(mobileIndex < permutation.length) || mobileIndex<0) {
            throw new IllegalArgumentException();
        }

        int toSwap=mobileIndex+directions[mobileIndex];
        if (toSwap>=0 && toSwap<permutation.length) {
            int rememberVal=permutation[mobileIndex];
            int rememberDir=directions[mobileIndex];
            permutation[mobileIndex] = permutation[toSwap];
            permutation[toSwap] = rememberVal;
            directions[mobileIndex] = directions[toSwap];
            directions[toSwap] = rememberDir;
        }

        // ---------------write your code ABOVE this line only! ------------------
    }

    // task 2.3
    // Assumes permutation and directions are arrays of the same length.
    // Reverses the directions of elements greater than the given mobile element.
    public static void reverseDirections(int[] permutation, int[] directions, int mobileElement) {
        // ---------------write your code BELOW this line only! ------------------
        for (int i=0;i<permutation.length;i++){
            if (permutation[i]>mobileElement) {
                directions[i]= -directions[i];
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
    }

    // task 2.4
    // Assumes permutation and directions are arrays of the same length.
    // Finds and returns the index of the largest mobile element or -1 if none exist.
    public static int findMobileIndex(int[] permutation, int[] directions) {
        int result = -1; // default return value
        // ---------------write your code BELOW this line only! ------------------
        int val=0;
        for (int i=0;i<directions.length;i++) {
            if (directions[i] == -1 && i != 0) {
                if (permutation[i] > permutation[i - 1] && permutation[i]>val){
                    result = i;
                    val=permutation[i];
                }

            }
            else if (directions[i] == 1 && (i + 1 < directions.length)) {
                if (permutation[i] > permutation[i + 1] && permutation[i]>val){
                    result = i;
                    val=permutation[i];
                }
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }


    // task 2.5
    // Assumes flights is a valid problem instance.
    // Finds a valid solution to the Big Trip Problem using exhaustive search.
    public static int[] solveBigTripProblemExhaustive(boolean[][] flights) {
        int[] result = null; // default return value
        // ---------------write your code BELOW this line only! ------------------
        if (!isLegalInstance(flights) || flights.length<1)
            throw new IllegalArgumentException();
        int tours=factorial(flights.length);
        int[][] permutations=generatePermutations(flights.length);
        boolean isExist=false;
        for (int i=0; !isExist && i<tours ;i++){
            if (isValidSolution(flights,permutations[i])){
                result=permutations[i];
                isExist=true;
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    ///////////////////////////////////
    /////// Part 2 ends here ////////
    ///////////////////////////////////

    // Assumes flights is a valid instance of the Big Trip Problem.
    // Solves the Big Trip Problem using reduction
    public static int[] solveBigTripProblemReduction(boolean[][] flights) {
        if (!isLegalInstance(flights)) {
            throw new IllegalArgumentException("Flights instance must be valid.");
        }
        boolean[][] encodedFlights = encoder(flights);
        int[] hamiltonianPath = HamiltonianPathSolver.solve(encodedFlights);
        return decoder(hamiltonianPath);
    }

    // task 3.1
    // Assumes flights is a valid matrix.
    // Adds a dummy city to the matrix and returns the new matrix.
    public static boolean[][] encoder(boolean[][] flights) {
        boolean[][] result = null; // default return value
        // ---------------write your code BELOW this line only! ------------------
        int flightLen = flights.length;
        result = new boolean[flightLen + 1][flightLen + 1];
        for (int i = 0; i < flightLen; i++) { //copying all the filled arrayes
            for (int j = 0; j < flights[i].length; j++) {
                result[i][j] = flights[i][j];
            }
        }
        for (int i = 0; i < flightLen; i++) { //duplicating the first and last array - Dummy
            result[flightLen][i] = result[0][i];
            result[i][flightLen] = result[i][0];
        }
        result[flightLen][flightLen] = false; //determinating the last cell (flights[n][n]=false)
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 3.2
    // Assumes hamiltonianPath is a valid Hamiltonian path or null.
    // Converts the Hamiltonian path back to the original Big Trip Problem solution.
    public static int[] decoder(int[] hamiltonianPath) {
        int[] result = null; // default return value
        // ---------------write your code BELOW this line only! ------------------
        if (hamiltonianPath!=null) {
            result = new int[hamiltonianPath.length - 1];
            for (int i = 0; i < hamiltonianPath.length - 1; i++) {
                result[i] = hamiltonianPath[i];
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

}
