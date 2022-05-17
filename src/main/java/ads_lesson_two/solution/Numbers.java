// Frans Spijkerman, Avans Hogeschool 2022
package ads.solution;

class Numbers {

    int[] numbers;
    int max; // maximum number of values
    int len; // current number of values

    public Numbers(int max) {
        this.max = max;
        numbers = new int[max];
        len = 0;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < len; i++) {
            if (!s.isEmpty()) {
                s += ", ";
            }
            s += numbers[i];
        }
        return s;
    }

    /**
     * Set private pos to index for insertion of number n
     *
     * @param n
     * @return true if number already in array; false otherwise
     */
    private int pos;

    private boolean findPosition(int n) {
        int left = 0;
        int right = len - 1;
        pos = 0;
        int offset = 0;
        while (right >= left) {
            pos = (right + left) / 2;
            if (n > numbers[pos]) {
                left = pos + 1;
                offset = 1;
            } else if (n < numbers[pos]) {
                right = pos - 1;
                offset = 0;
            } else {
                return true;
            }
        }
        pos += offset;
        return false;
    }

    /**
     * Insert number in correct position if necessary, keeping array sorted do
     * not insert if already present in array
     *
     * @param n
     */
    void insertNumber(int n) {
        if (len < max && !findPosition(n)) {
            for (int i = len; i > pos; i--) {
                numbers[i] = numbers[i - 1];
            }
            numbers[pos] = n;
            len++;
        }
    }

    /**
     * Check if number is in array
     *
     * @param n
     * @return true if number is in array; false otherwise
     */
    boolean hasNumber(int n) {
        return findPosition(n);
    }

}
