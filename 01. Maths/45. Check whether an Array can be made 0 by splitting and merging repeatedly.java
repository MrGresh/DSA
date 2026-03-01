public class codefile{
    static boolean check(int[]  arr){
        int countOdds = 0;
        for(int x : arr) {
            if(x%2!=0) countOdds++;
        }
        return countOdds%2==0;
    }
}
