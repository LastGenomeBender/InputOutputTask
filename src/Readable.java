

import java.io.File;
import java.io.IOException;

public interface Readable extends Streamable {
    public static void checkIfSaneInputFile() throws CustomIOException, IOException,Exception{
       // File outputDirectory = ReadFile.READ_FILE.getInputFile();
        File inputFile = ReadFile.READ_FILE.getInputFile();
        if(!inputFile.exists()){
            throw new NonExistentFileReadException(inputFile);
        }
        if(!inputFile.isFile()){
            throw new NotAFileExcepion(inputFile);
        }
        if(!inputFile.canRead()){
            throw new NonReadableFileException(inputFile);
        }
    }
    enum ReadFile{
        READ_FILE;

        private String fileName;
        private String inputFilePath;
        private File inputFile;

//        private ReadFile(String fileName){
//            this.fileName = fileName;
//            this.inputFilePath = DirectoryPath.WORKING_DIR.getDirectoryPath() + File.separator+this.fileName;
//            this.inputFile = new File(this.inputFilePath);
//        }

        public void setFileName(String fileName) throws CustomIOException,IOException,Exception {
            this.fileName = fileName;
            this.inputFilePath = DirectoryPath.WORKING_DIR.getDirectoryPath() + File.separator+this.fileName;
            this.inputFile = new File(this.inputFilePath);
            checkIfSaneInputFile();
        }

        public String getFileName(){
            return this.fileName;
        }

        public String getInputFilePath(){
            return this.inputFilePath;
        }

        public File getInputFile(){
            return this.inputFile;
        }


    }


}
