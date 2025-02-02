package lesson_tasks.input_output_task_refactor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public interface Writable extends Streamable {


    public static void checkIfSaneOutputFile() throws CustomIOException, IOException,Exception{
        // File outputDirectory = ReadFile.READ_FILE.getInputFile();
        File outputFile = WriteFile.WRITE_FILE.getOutputFile();
        if(!outputFile.exists()){
            if(!outputFile.createNewFile()){
                throw new NonCreatableFileException(outputFile);
            }
        }
        if(!outputFile.isFile()){
            throw new NotAFileExcepion(outputFile);
        }
        if(!outputFile.canWrite()){
            throw new NonReadableFileException(outputFile);
        }
    }
    enum WriteFile{
        WRITE_FILE;

        private  String fileName;
        private String outputFilePath;
        private FileWriter fileWriter =null;
        private File outputFile = null;
//        private int counter = 0;
//        private WriteFile(String fileName){
//            this.fileName = fileName;
//            this.outputFile = DirectoryPath.WORKING_DIR.getDirectoryPath() + File.separator+this.fileName;
//            //this.inputFile = new FileWriter(this.inputFilePath);
//        }

        public void setFileName(String fileName) throws CustomIOException,IOException, Exception {
            this.fileName = fileName;
            this.outputFilePath = DirectoryPath.WORKING_DIR.getDirectoryPath() + File.separator+this.fileName;
            this.outputFile = new File(this.outputFilePath);
            checkIfSaneOutputFile();
            this.fileWriter = new FileWriter(this.outputFile, false);


        }

        public String getFileName(){
            return this.fileName;
        }

        public String getOutputFilePath(){
            return this.outputFilePath;
        }

        public FileWriter getOutputFileWriter(){
            return this.fileWriter;
        }
        public File getOutputFile(){
            return this.outputFile;
        }

    }
}
