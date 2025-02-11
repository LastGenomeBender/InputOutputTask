

import java.io.File;
import java.io.IOException;

public interface Streamable {
     void  IOfunction() throws IOException;
    public static void checkIfSaneFolder() throws CustomIOException,IOException,Exception{
        File outputDirectory = DirectoryPath.WORKING_DIR.getOutputDirectory();
        //File outputDirectory = DirectoryPath.WORKING_DIR.outputDirectory();
        if(!outputDirectory.exists()){
            if(!outputDirectory.mkdir()){
                throw new NonCreatableDirectoryException(outputDirectory);
            }
        }
        if(!outputDirectory.isDirectory()){
            throw new NotADirectoryException(outputDirectory);
        }
        if(!outputDirectory.canRead()){
            throw new NonReadableDirectoryException(outputDirectory);
        }
        if(!outputDirectory.canWrite()){
            throw new NonWritableDirectoryException(outputDirectory);
        }
    }
     enum DirectoryPath{

         WORKING_DIR;
         private String directoryPath;
         private File outputDirectory;

         public  void setDirectoryPath(String directoryPath )throws CustomIOException,IOException,Exception{
             this.directoryPath = directoryPath;
             this.outputDirectory = new File(this.directoryPath);

             checkIfSaneFolder();
         }



         public File getOutputDirectory( ){
             return outputDirectory;
         }

         public String getDirectoryPath( ){
             return directoryPath;
         }






    }

}
