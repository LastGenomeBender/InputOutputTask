
import java.util.Arrays;
import java.util.Random;
public interface TaskMath {






    private static int [] fillRandomArr(int [] emptyArr, int length,int range){
        Random rand = new Random();
        for (int i =0;i<length;i++){
            emptyArr[i] = rand.nextInt(range);
        }
        return Arrays.copyOf(emptyArr,length);
    }
    public static  int [] generateRandom(int range, int length)
    {
        int [] randArr = fillRandomArr(new int[length],length,range);
        return Arrays.copyOf(randArr,length);
    }
     private static boolean ifOdd(int i){
        if((i%2)!=0){
            return true;
        }
        return false;
     }

     private static boolean ifEven(int i){
         if(((i%2)==0) & i!=0 ){
             return true;
         }
         return false;
     }

    public static int[] returnOddArr(int [] randArr){
        int [] oddArr = Arrays.copyOf(randArr,randArr.length);
        int counter = 0;
        for(int i:randArr){
            if(ifOdd(i)){
                oddArr[counter++] = i;
            }
        }
        return Arrays.copyOf(oddArr, counter);

    }


    public static int[] returnEvenArr(int [] randArr){
        int [] evenArr = Arrays.copyOf(randArr,randArr.length);
        int counter = 0;
        for(int i:evenArr){
            if(ifEven(i)){
                evenArr[counter++] = i;
            }
        }
        return Arrays.copyOf(evenArr, counter);
    }


}
