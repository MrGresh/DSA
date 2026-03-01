class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;
        for(int bill: bills) {
            if(bill==5) fives++;
            else if(bill==10) tens++;
            
            if(bill!=5) {
                int req = bill-5;
                if(req==5) {
                    if(fives>0) fives--;
                    else return false;
                } else { // req = 15
                    if(tens>0 && fives>0) {
                        tens--;
                        fives--;
                    } else if(fives>2) {
                        fives -= 3;
                    } else return false;
                }
            }
        }
        return true;
    }
}
