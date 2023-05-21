package Ex12_5;

public class Grains {
	public static long getTotalGrains(int k, long grains) {
        if (k == 1) {
            return grains;
        } else {
            return grains + getTotalGrains(k - 1, grains * 2);
        }
    }
}
