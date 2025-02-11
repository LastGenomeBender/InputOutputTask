

import java.io.IOException;
import java.util.Scanner;

public class ReadFileClass implements Readable {
    private String directoryPath = DirectoryPath.WORKING_DIR.getDirectoryPath();
    private String fileName;
    private String thingThatWasRead;


//    public ReadFileClass(String directoryPath,
//                         String fileName) {
//        this.directoryPath = directoryPath;
//        this.fileName = fileName;
//
//
//        DirectoryPath.WORKING_DIR.setDirectoryPath(this.directoryPath);
//        ReadFile.READ_FILE.setFileName(this.fileName);
//
//    }

    public ReadFileClass(String fileName) throws CustomIOException,IOException,Exception {
        this.fileName = fileName;
        ReadFile.READ_FILE.setFileName(this.fileName);

    }

    public String getThingThatWasRead() {
        return thingThatWasRead;
    }
    //public void check
    @Override
    public void IOfunction() throws IOException {
        try (Scanner scanner = new Scanner(ReadFile.READ_FILE.getInputFile())) {
            while (scanner.hasNextLine()) {
                this.thingThatWasRead = scanner.nextLine();
            }
        }
    }
}
