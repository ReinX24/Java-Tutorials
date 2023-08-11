
public class Main {

	public static void main(String[] args) {

	}

	// Linear time O(n), as the amount of data increases, the time it takes also
	// increases
	// If n is equal to 1,000,000 it will then equal to 1,000,000 steps
	public int addUpLinear(int n) {
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			sum += 1;
		}
		return sum;
	}

	// Constant time O(1), as the amount of data increases, amount of time does not
	// increase
	public int addUpConstant(int n) {
		int sum = n * (n + 1) / 2;
		return sum;
	}

}
