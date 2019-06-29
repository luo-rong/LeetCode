package _461_HammingDistance;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int distance = 0;
        int z = x ^ y;
        while (z != 0) {
            distance += z & 1;
            z = z >> 1;
        }
        return distance;
    }
}
