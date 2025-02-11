
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int range = scanRandomRange(scanner);
        int length = scanRandomLength(scanner);

        System.out.println(".... Generating random array ....");
        int [] randomArr = TaskMath.generateRandom(range,length);
        System.out.println(".... Generation successful  ....");
        System.out.println(Arrays.toString(randomArr));

        scanWorkingDirectoryName(scanner);


        System.out.println("Enter the Random File Name ");
        WriteFileClass writer = scanOutFileName(scanner,Arrays.toString(randomArr));
        System.out.println(".... Successfully Written the file ....");

        System.out.println(".... Reading the Random Arr File ....");
        ReadFileClass reader = null;
        try{
             reader = scanInFileName(Writable.WriteFile.WRITE_FILE.getFileName());
        } catch (Exception e) {
            System.out.println("Ooops we have to start all over");
            main(new String[0]);
        }
        if(reader == null){
            System.out.println("Ooops we have to start all over");
            main(new String[0]);
        }

        int [] castRandomArr = castToIntArr(reader);


        System.out.println(".... Successfully read the Random Arr File ....");

        int[] evenArr = TaskMath.returnEvenArr(castRandomArr);
        System.out.println(" Evens are " + Arrays.toString(evenArr));
        System.out.println(".... Writing Even Nums ....");
        System.out.println("Enter Even Num Name");
        WriteFileClass writerEven = scanOutFileName(scanner,Arrays.toString(evenArr));
        System.out.println(".... Successfully wrote Even Arr File ....");

        int [] oddArr = TaskMath.returnOddArr(castRandomArr);
        System.out.println(" Odds are " + Arrays.toString(oddArr));
        System.out.println(".... Writing Odd Nums ....");
        System.out.println("Enter Odd Num Name");
        WriteFileClass writerOdd = scanOutFileName(scanner,Arrays.toString(oddArr));
        System.out.println(".... Successfully wrote Odd Arr File ....");
    }

   private static int scanRandomRange(Scanner scanner){

       System.out.println("Please enter the Range for random generation as integer [2,Integer.max) \n Example: 5 ");
        String inRange = scanner.nextLine().trim();
        int range;
        try {
            range = randomSanityCheckRange(inRange);
        }catch(IllegalArgumentException e){
            System.out.println("You entered an illegal argument with below message");
            System.out.println(e.getMessage());
            System.out.println("Try inputting again");
            range = scanRandomRange( scanner);
        }catch (Exception e){
            System.out.println("This is an unexpected error with below message, contact support");
            e.getMessage();
            System.out.println("Try inputting again");
            range =scanRandomRange( scanner);
        }

        return range;
   }

    private static int scanRandomLength(Scanner scanner){

        System.out.println("Please enter the Length of the random array as integer [2,Integer.max) \n Example: 2 ");
        String inLength = scanner.nextLine().trim();
        int length;
        try {
            length = randomSanityCheckLength(inLength);
        }catch(IllegalArgumentException e){
            System.out.println("You entered an illegal argument with below message");
            System.out.println(e.getMessage());
            System.out.println("Try inputting again");
            length=scanRandomLength( scanner);
        }catch (Exception e){
            System.out.println("This is an unexpected error with below message, contact support");
            e.getMessage();
            System.out.println("Try inputting again");
            length=scanRandomLength( scanner);
        }

        return length;
    }

    private static void scanWorkingDirectoryName(Scanner scanner){
        System.out.println("Please Enter the Working Directory name");
        try {
           String path = scanner.nextLine().trim();
           Streamable.DirectoryPath.WORKING_DIR.setDirectoryPath(path);
       }catch (CustomIOException e){
           System.out.println("Error regarding the folder creation, see message");
           System.out.println(e.getMessage());
           System.out.println("Reenter the folder name");
           scanWorkingDirectoryName(scanner);
       }catch (IOException e){
           System.out.println("Unexpected IOerror, contact support ");
           System.out.println(e.getMessage());
           System.out.println("Reenter the folder name");
           scanWorkingDirectoryName(scanner);
       }catch (Exception e){
           System.out.println("Unexpected non-IO error, contact support ");
           System.out.println(e.getMessage());
           System.out.println("Reenter the folder name");
           scanWorkingDirectoryName(scanner);
       }
        System.out.println("Successfully scanned the Working Dir");
    }

    private static ReadFileClass scanInFileName(String path) throws Exception{

        ReadFileClass reader;
        try{
             reader = new ReadFileClass(path);
        } catch (Exception e){
            System.out.println("Unexpected non-IO error, contact support ");
            System.out.println(e.getMessage());
            System.out.println("We will have to restart :(");
            throw e;
        }
        reader.IOfunction();
        return reader;
    }

    private static WriteFileClass scanOutFileName(Scanner scanner, String content) {
        while (true) {
            String path = scanner.nextLine();
            WriteFileClass writer = null;
            try {
                writer = new WriteFileClass(path, content);
                System.out.println("Success Generating fileObj");
                writer.IOfunction(); // Perform I/O here
                return writer; // Return ONLY if successful
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Let's try again");

            } finally {

                if (writer != null) {
                    try {
                        writer.getFile().close();
                    } catch (IOException e) {
                        System.out.println("Error closing writer: " + e.getMessage());

                    }
                }
            }
        }
    }



    private static int  randomSanityCheckLength (String length) throws IllegalArgumentException,
            Exception{

        int length2;

        try{
            length2 = Integer.parseInt(length);
        }catch(Exception e){
            throw new NonIntegerInputException("\"length\"");
        }

        if(length2<1){
            throw new InvalidIntegerInputSpaceException("\"length\"",
                    1,
                    Integer.MAX_VALUE);
        }

        return length2;

    }
    private static int  randomSanityCheckRange (String range) throws IllegalArgumentException,
            Exception{

        int range2;

        try{
            range2 = Integer.parseInt(range);
        }catch(Exception e){
            throw new NonIntegerInputException("\"range\"");
        }

        if(range2<2){
            throw new InvalidIntegerInputSpaceException("\"range\"",
                    2,
                    Integer.MAX_VALUE);
        }

        return range2;
    }

    private static int [] castToIntArr(ReadFileClass reader){
        String [] readRandomArr = reader.getThingThatWasRead().
                replace("[","").
                replace("]","").
                replace(" ","").
                split(",");

        int [] castRandomArr = new int[readRandomArr.length];
        for(int i = 0; i<castRandomArr.length;i++){
            castRandomArr[i] = Integer.parseInt(readRandomArr[i]);
        }
        return Arrays.copyOf(castRandomArr, castRandomArr.length);
    }
}
