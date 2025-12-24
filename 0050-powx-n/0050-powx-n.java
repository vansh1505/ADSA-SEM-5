class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if (n < 0) return 1.0 / myPow(x, -n); // -ve power case
        return x * myPow(x, n - 1);
    }
}