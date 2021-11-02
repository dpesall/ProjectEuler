package projecteuler;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;

public class ProjectEuler {
    public static void main(String[] args) {
        long startTime = System.nanoTime();


        numberLetterCount();
        
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("\nDuration: " + duration);
    }
    
    private static void template() {
        
        
        
        System.out.println();
    }

    // If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
    private static void numberLetterCount() {
        
        int n = 1000;
        
        int count = countLetters(n);

        System.out.println(count);
    }
    
    private static int countLetters(int n) {
        if(n == 1000) {
            String thousand = "onethousand";
            return thousand.length() + countLetters(n - 1);
        }
        
        if(n <= 0) {
            return 0;
        }
        
        System.out.println(getWordFor(n) + " : " + getWordFor(n).length());
        
        return getWordFor(n).length() + countLetters(n - 1);
    }
    
    private static String getWordFor(int n) {
        boolean teen = (n % 100) >= 10 && (n % 100) < 20;
        String word = "";
        if(n >= 100) {
            char hundreds = (char) ((n / 100) + '0');
            switch(hundreds) {
                case '1':
                    word += "onehundred";
                    if(n != 100) {
                        word += "and";
                    }
                    break;
                case '2':
                    word += "twohundred";
                    if(n != 200) {
                        word += "and";
                    }
                    break;
                case '3':
                    word += "threehundred";
                    if(n != 300) {
                        word += "and";
                    }
                    break;
                case '4':
                    word += "fourhundred";
                    if(n != 400) {
                        word += "and";
                    }
                    break;
                case '5':
                    word += "fivehundred";
                    if(n != 500) {
                        word += "and";
                    }
                    break;
                case '6':
                    word += "sixhundred";
                    if(n != 600) {
                        word += "and";
                    }
                    break;
                case '7':
                    word += "sevenhundred";
                    if(n != 700) {
                        word += "and";
                    }
                    break;
                case '8':
                    word += "eighthundred";
                    if(n != 800) {
                        word += "and";
                    }
                    break;
                case '9':
                    word += "ninehundred";
                    if(n != 900) {
                        word += "and";
                    }
                    break;
            }
        }
        n %= 100;
        if(n >= 10) {
            char tens = (char) ((n / 10) + '0');
            switch(tens) {
                case '1':
                    char ones = (char) ((n % 10) + '0');
                    switch(ones) {
                        case '0':
                            word += "ten";
                            break;
                        case '1':
                            word += "eleven";
                            break;
                        case '2':
                            word += "twelve";
                            break;
                        case '3':
                            word += "thirteen";
                            break;
                        case '4':
                            word += "fourteen";
                            break;
                        case '5':
                            word += "fifteen";
                            break;
                        case '6':
                            word += "sixteen";
                            break;
                        case '7':
                            word += "seventeen";
                            break;
                        case '8':
                            word += "eighteen";
                            break;
                        case '9':
                            word += "nineteen";
                            break;
                    }
                    break;
                case '2':
                    word += "twenty";
                    break;
                case '3':
                    word += "thirty";
                    break;
                case '4':
                    word += "forty";
                    break;
                case '5':
                    word += "fifty";
                    break;
                case '6':
                    word += "sixty";
                    break;
                case '7':
                    word += "seventy";
                    break;
                case '8':
                    word += "eighty";
                    break;
                case '9':
                    word += "ninety";
                    break;
            }
        }
        if(teen) {
            return word;
        }
        n %= 10;
        char ones = (char) (n + '0');
        switch(ones) {
            case '1':
                word += "one";
                break;
            case '2':
                word += "two";
                break;
            case '3':
                word += "three";
                break;
            case '4':
                word += "four";
                break;
            case '5':
                word += "five";
                break;
            case '6':
                word += "six";
                break;
            case '7':
                word += "seven";
                break;
            case '8':
                word += "eight";
                break;
            case '9':
                word += "nine";
                break;
        }
        
        return word;
    }

    // What is the sum of the digits of the number 2^1000?
    private static void powerDigitSum() {
        
        String base = "2";
        int exponent = 1000; 
        
        BigInteger total = new BigInteger (base);
        total = total.pow(exponent);
        
        System.out.println(total);
        
        String totalString = total.toString();
        
        int sum = 0;
        for(char a : totalString.toCharArray()) {
            sum += a - '0';
        }
        System.out.println(sum);
        
    }
    
    // How many such routes are there through a 20×20 grid?
    private static void latticePaths() {
        
        int gridSize = 20;
        
        int x = gridSize;
        int y = gridSize;
        
        double movesCount = factorial(gridSize * 2, gridSize) / factorial(gridSize, 1);
        System.out.println((long) movesCount);
    }
    
    private static double factorial(double n, int stoppingPoint) {
        if(n == 1 || n == stoppingPoint) {
            return 1;
        }
        
        return n * factorial(n - 1, stoppingPoint);
    }

    private static void longestCollatzSequence() {

        int range = 1000000;
        int maxChain = 0;
        int number = -1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 1; i <= range; i++) {
            int chain = 1;
            long n = i;
            while(n != 1) {
                if(n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = (3 * n) + 1;
                }
                chain++;
            }
            map.put(i, chain);
        }
        
        System.out.println();
        for(int a : map.keySet()) {
            if(maxChain < map.get(a)) {
                maxChain = map.get(a);
                number = a;
            }
        }
        System.out.println(number + " : " + maxChain);
    }

    // Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
    private static void largeSum() {
        String[] large = {
                "37107287533902102798797998220837590246510135740250",                "46376937677490009712648124896970078050417018260538",                "74324986199524741059474233309513058123726617309629",                "91942213363574161572522430563301811072406154908250",
                "23067588207539346171171980310421047513778063246676",                "89261670696623633820136378418383684178734361726757",                "28112879812849979408065481931592621691275889832738",                "44274228917432520321923589422876796487670272189318",
                "47451445736001306439091167216856844588711603153276",                "70386486105843025439939619828917593665686757934951",                "62176457141856560629502157223196586755079324193331",                "64906352462741904929101432445813822663347944758178",
                "92575867718337217661963751590579239728245598838407",                "58203565325359399008402633568948830189458628227828",                "80181199384826282014278194139940567587151170094390",                "35398664372827112653829987240784473053190104293586",
                "86515506006295864861532075273371959191420517255829",                "71693888707715466499115593487603532921714970056938",                "54370070576826684624621495650076471787294438377604",                "53282654108756828443191190634694037855217779295145",
                "36123272525000296071075082563815656710885258350721",                "45876576172410976447339110607218265236877223636045",                "17423706905851860660448207621209813287860733969412",                "81142660418086830619328460811191061556940512689692",
                "51934325451728388641918047049293215058642563049483",                "62467221648435076201727918039944693004732956340691",                "15732444386908125794514089057706229429197107928209",                "55037687525678773091862540744969844508330393682126",
                "18336384825330154686196124348767681297534375946515",                "80386287592878490201521685554828717201219257766954",                "78182833757993103614740356856449095527097864797581",                "16726320100436897842553539920931837441497806860984",
                "48403098129077791799088218795327364475675590848030",                "87086987551392711854517078544161852424320693150332",                "59959406895756536782107074926966537676326235447210",                "69793950679652694742597709739166693763042633987085",
                "41052684708299085211399427365734116182760315001271",                "65378607361501080857009149939512557028198746004375",                "35829035317434717326932123578154982629742552737307",                "94953759765105305946966067683156574377167401875275",
                "88902802571733229619176668713819931811048770190271",                "25267680276078003013678680992525463401061632866526",                "36270218540497705585629946580636237993140746255962",                "24074486908231174977792365466257246923322810917141",
                "91430288197103288597806669760892938638285025333403",                "34413065578016127815921815005561868836468420090470",                "23053081172816430487623791969842487255036638784583",                "11487696932154902810424020138335124462181441773470",
                "63783299490636259666498587618221225225512486764533",                "67720186971698544312419572409913959008952310058822",                "95548255300263520781532296796249481641953868218774",                "76085327132285723110424803456124867697064507995236",
                "37774242535411291684276865538926205024910326572967",                "23701913275725675285653248258265463092207058596522",                "29798860272258331913126375147341994889534765745501",                "18495701454879288984856827726077713721403798879715",
                "38298203783031473527721580348144513491373226651381",                "34829543829199918180278916522431027392251122869539",                "40957953066405232632538044100059654939159879593635",                "29746152185502371307642255121183693803580388584903",
                "41698116222072977186158236678424689157993532961922",                "62467957194401269043877107275048102390895523597457",                "23189706772547915061505504953922979530901129967519",                "86188088225875314529584099251203829009407770775672",
                "11306739708304724483816533873502340845647058077308",                "82959174767140363198008187129011875491310547126581",                "97623331044818386269515456334926366572897563400500",                "42846280183517070527831839425882145521227251250327",
                "55121603546981200581762165212827652751691296897789",                "32238195734329339946437501907836945765883352399886",                "75506164965184775180738168837861091527357929701337",                "62177842752192623401942399639168044983993173312731",
                "32924185707147349566916674687634660915035914677504",                "99518671430235219628894890102423325116913619626622",                "73267460800591547471830798392868535206946944540724",                "76841822524674417161514036427982273348055556214818",
                "97142617910342598647204516893989422179826088076852",                "87783646182799346313767754307809363333018982642090",                "10848802521674670883215120185883543223812876952786",                "71329612474782464538636993009049310363619763878039",
                "62184073572399794223406235393808339651327408011116",                "66627891981488087797941876876144230030984490851411",                "60661826293682836764744779239180335110989069790714",                "85786944089552990653640447425576083659976645795096",
                "66024396409905389607120198219976047599490197230297",                "64913982680032973156037120041377903785566085089252",                "16730939319872750275468906903707539413042652315011",                "94809377245048795150954100921645863754710598436791",
                "78639167021187492431995700641917969777599028300699",                "15368713711936614952811305876380278410754449733078",                "40789923115535562561142322423255033685442488917353",                "44889911501440648020369068063960672322193204149535",
                "41503128880339536053299340368006977710650566631954",                "81234880673210146739058568557934581403627822703280",                "82616570773948327592232845941706525094512325230608",                "22918802058777319719839450180888072429661980811197",
                "77158542502016545090413245809786882778948721859617",                "72107838435069186155435662884062257473692284509516",                "20849603980134001723930671666823555245252804609722",                "53503534226472524250874054075591789781264330331690"
        };
        
        long sum = 0;
        
        for(String a : large) {
            long temp = Long.parseLong(a.substring(0, 13));
            sum += temp;
        }
        String temp = Long.toString(sum);
        String firstTen = temp.substring(0, 10);
        System.out.println(firstTen);
    }
    
    // What is the value of the first triangle number to have over five hundred divisors?
    private static void highlyDivisibleTriangularNumber() {
        
        int factors = 500;
        int triangle = 0;
        int tempMax = 0;
        for(int i = 1; true; i++) {
            int temp = numberOfFactors(triangularNumber(i));
            
            if(temp > factors) {
                triangle = triangularNumber(i);
                break;
            }
            if(tempMax < temp) {
                tempMax = temp;
                System.out.println(tempMax);
            }
        }
        System.out.println();
        System.out.println(triangle);
    }
    
    private static int numberOfFactors(int n) {
        
        if(n <= 1) {
            return 1;
        } else {
            int root = (int) (Math.sqrt(n) + 1);

            Set<Integer> set = new HashSet<Integer>();
            set.add(n);
            for(int i = 1; i < root; i++) {
                if(n % i == 0) {
                    set.add(i);
                    if(n / i != i) {
                        set.add(n / i);
                    }
                }
            }
            return set.size();
        }
    }
    
    private static int triangularNumber(int n) {
        
        if(n <= 1) {
            return 1;
        } else {
            return n + triangularNumber(n - 1);
        }
    }
    
    // What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?
    private static void largestProductInGrid() {

        int[] arr = {
                8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8,
                49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0,
                81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65,
                52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91,
                22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80,
                24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50,
                32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70,
                67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21,
                24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72,
                21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95,
                78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92,
                16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57,
                86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58,
                19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40,
                4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66,
                88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69,
                4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36,
                20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16,
                20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54,
                1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48
        };
        
        long maxProduct = -1;
        
        for(int i = 0; i < arr.length; i++) {

            // Horizontal
            int product = 1;
            for(int k = 0; k < 4 && k + i < arr.length; k++) {
                if(i % 20 >= 17) {
                    break;
                }
                product *= arr[k + i];
            }
            maxProduct = product > maxProduct ? product : maxProduct;

            // Vertical
            product = 1;
            for(int k = 0; k < 4 && k < arr.length; k++) {
                if(i >= 340) {
                    break;
                }
                product *= arr[k * 20];
            }
            
            maxProduct = product > maxProduct ? product : maxProduct;

            // Right Diagonal
            product = 1;
            for(int k = 0; k < 4 && k < arr.length; k++) {
                if(i % 20 >= 17 || i >= 340) {
                    break;
                }
                int index = k * 20 + k + i;
                product *= arr[index];
            }
            maxProduct = product > maxProduct ? product : maxProduct;

            // Left Diagonal
            product = 1;
            for(int k = 0; k < 4 && k < arr.length; k++) {
                if(i % 20 <= 2 || i >= 340) {
                    break;
                }
                int index = k * 20 - k + i;
                product *= arr[index];
            }
            maxProduct = product > maxProduct ? product : maxProduct;
        }

        System.out.println(maxProduct);
    }

    // Find the sum of all the primes below two million.
    private static void summationOfPrimes() {
        int below = 200000;
        
        long sum = 2;
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for(int i = 3; i < below; i++) {
            boolean isPrime = true;
            for(int a : primes) {
                if(i % a == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                primes.add(i);
                sum += i;
            }
        }
        
        System.out.println(sum);
    }
    
    // There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc.
    private static void specialPythagoreanTriplet() {
        
        int sum = 1000;
        int a = 1;
        int b = 2;
        int c = sum - (a + b);
        
        while(Math.pow(a, 2) + Math.pow(b, 2) != Math.pow(c, 2) && c > b) {
            c--;
            for(int k = 0; k < c - b; k++) {
                int tempB = b + k;
                for(int i = 1; i < tempB - a; i++) {
                    int tempA = a + i;
                    if(Math.pow(tempA, 2) + Math.pow(tempB, 2) == Math.pow(c, 2) && tempA + tempB + c == sum) {
                        a = tempA;
                        b = tempB;
                    }
                }
            }
        }

        System.out.println(a + " " + b + " " + c + " ");
        System.out.println(a * b * c);
    }
    
    // Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
    private static void largestProductInSeries() {
        
        String bigNumber = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
        int adjacents = 13;
        
        String sub = "";
        long largestProduct = -1;
        for(int i = 0; i < bigNumber.length() - adjacents + 1; i++) {
            sub = bigNumber.substring(i, i + adjacents);

            long product = 1;
            for(int k = 0; k < sub.length(); k++) {
                product *= Integer.parseInt(String.valueOf(sub.charAt(k)));
            }
            if(product > largestProduct) {
                largestProduct = product;
            }
        }
        
        System.out.println(largestProduct);
    }
    
    // What is the 10 001st prime number?
    private static void nthPrime() {

        int n = 10001;
        
        int nthPrime = 0;
        
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        
        int value = 3;
        while(primes.size() < n) {
            boolean isPrime = true;
            for(int a : primes) {
                if(value % a == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                primes.add(value);
            }
            value++;
        }

        System.out.println(Collections.max(primes));
    }
    
    // Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
    private static void sumSquareDifference() {

        int range = 100;
        
        int sumOfSquares = 0;
        for(int i = 1; i <= range; i++) {
            sumOfSquares += Math.pow(i, 2);
        }
        int squareOfSums = 0;
        for(int i = 1; i <= range; i++) {
            squareOfSums += i;
        }
        squareOfSums = (int) Math.pow(squareOfSums, 2);

        System.out.println(squareOfSums - sumOfSquares);
    }
    
    // What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
    private static void smallestMultiple() {
        int number = 20;
        
        long factorial = factorialOf(number);
        long temp = factorial;
        long smallest = factorial;
        for(int i = number; i > 1; i--) {
            if(temp % i == 0) {
                long divided = temp / i;
                boolean allDivisible = true;
                for(int k = number; k > 1; k--) {
                    if(divided % k != 0) {
                        allDivisible = false;
                    }
                }
                if(allDivisible) {
                    temp = temp / i;
                }
            }
            if(temp < smallest) {
                smallest = temp;
            }
        }
        System.out.println(smallest);
    }
    
    private static long factorialOf(int number) {
        
        if(number == 1) {
            return 1;
        } else {
            return number * factorialOf(number - 1);
        }
    }
    
    // Find the largest palindrome made from the product of two 3-digit numbers.
    private static void largestPalindromeProduct() {
        
        int value1 = 999;
        int value2 = 999;
        int maxPalindrome = -1;
        int max1 = -1;
        int max2 = -1;
        while(value1 > 500) {
            if(isPalindrom(value1 * value2)) {
                int product = value1 * value2;
                if(product > maxPalindrome) {
                    maxPalindrome = product;
                    max1 = value1;
                    max2 = value2;
                }
            }
            if(value2 == 101) {
                value2 = 991;
                value1 -= 1;
            } else {
                value2 -= 1;
            }
        }
        System.out.println(max1 + " " + max2);
        System.out.println(maxPalindrome);
    }
    
    private static boolean isPalindrom(int number) {
        
        String text = Integer.toString(number);
        
        int length = text.length();
        if(length % 2 != 0) {
            String temp = text.substring(0, length / 2) + text.substring(1 + (length / 2), length);
            text = temp;
        }
        char[] arr = text.toCharArray();
        for(int i = 0; i < arr.length / 2; i++) {
            if(arr[i] != arr[(arr.length - 1 - i)]) {
                return false;
            }
        }
        
        return true;
    }
    
    // What is the largest prime factor of the number 600851475143?
    private static void largestPrimeFactor() {

        double number = Long.valueOf(600851475143l);
        
        long root = (long) (Math.sqrt(number) + 1);
        
        long largestFactor = -1;
        
        for(int i = 2; i < root; i++) {
            if(number % i == 0) {
                if(isPrime(i)) {
                    largestFactor = i;
                    long otherFactor = (long) (number / i);
                    if(isPrime(otherFactor) && otherFactor > largestFactor) {
                        largestFactor = otherFactor;
                    }
                }
            }
        }

        System.out.println(largestFactor);
    }
    
    private static boolean isPrime(double number) {
        
        if(number < 2) {
            return false;
        }
        if(number == 2) {
            return true;
        }
        int root = (int) (Math.sqrt(number) + 1);
        
        for(int i = 2; i < root; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        
        return true;
    }

    // By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
    private static void evenFibonacciNumbers() {
        int sum = 0;
        for(int i = 2; i < 400; i++) {
            int value = fibonacci(i);
            if(value < 4000000) {
                if(value % 2 == 0) {
                    sum += value;
                }
                //System.out.print(value + " ");
            } else {
                break;
            }
        }
        
        System.out.println(sum);
    }
    
    private static int fibonacci(int term) {
        if (term < 1) {
            return 0;
        }
        if(term == 1 || term == 2) {
            return 1;
        }
        return fibonacci(term - 1) + fibonacci(term - 2);
    }
    
    // Find the sum of all the multiples of 3 or 5 below 1000.
    private static void multiplesOfThreeOrFive() {
        int sum = 0;
        for(int i = 0; i < 1000; i++) {
            if(i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
    
}
