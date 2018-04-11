public class CodingBat {

    public static int bunnyEars2(int bunnies) {

	int ears = 0;
	int sum = 0;

	if (bunnies == 0) {
	    return ears;
	}

	if (bunnies % 2 == 0 ) {
	    ears = 3;
	}

	else {
	    ears = 2;
	}

	sum = ears + bunnyEars2(bunnies - 1);
	return sum;
    }

    public static void main(String[] args) {
	System.out.println(bunnyEars2(0));
	System.out.println(bunnyEars2(1));
	System.out.println(bunnyEars2(10));
	System.out.println(bunnyEars2(6));
    }






} 
