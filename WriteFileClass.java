package lesson_tasks.input_output_task_refactor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileClass implements Writable {


    private String directoryPath = DirectoryPath.WORKING_DIR.getDirectoryPath();
    private String fileName;
    private String thingToWrite;


    public WriteFileClass(String fileName,
                          String thingToWrite) throws CustomIOException,
            IOException,
            Exception {
        this.fileName = fileName;
        this.thingToWrite =thingToWrite;

        WriteFile.WRITE_FILE.setFileName(this.fileName);

    }

    public FileWriter getFile() {
        return WriteFile.WRITE_FILE.getOutputFileWriter();
    }

    @Override
    public void IOfunction() throws IOException {
        try(BufferedWriter bufferedWriter = new BufferedWriter(WriteFile.WRITE_FILE.getOutputFileWriter())){
            bufferedWriter.write(thingToWrite + "\n");
        }
    }

}
