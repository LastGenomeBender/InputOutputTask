


import java.io.File;
import java.io.IOException;

class NonIntegerInputException extends IllegalArgumentException {
    NonIntegerInputException(String varName) {
        super("The input " + varName + " have to be an integer");
    }

}

class InvalidIntegerInputSpaceException extends IllegalArgumentException {
    InvalidIntegerInputSpaceException(String varName,
                               int inclusiveStart,
                               int exclusiveEnd){
        super(String.format("The variable %s have to be in the range [ %d, %d )",
                varName,
                inclusiveStart,
                exclusiveEnd));
    }
}

class CustomIOException extends IOException{
    CustomIOException(String s){
        super(s);
    }
}

class NonCreatableDirectoryException extends CustomIOException{
    NonCreatableDirectoryException(File file){
        super("cannot create the path "+file.getAbsolutePath()+
                " Check if it is a proper folder name");

    }
}

class NonReadableDirectoryException extends CustomIOException{
    NonReadableDirectoryException(File file){
        super("cannot read the directory "+file.getAbsolutePath());

    }
}

class NotADirectoryException extends CustomIOException{
    NotADirectoryException(File file){
        super("Input path : "+file.getAbsolutePath()+" is not a directory");

    }
}

class NonWritableDirectoryException extends CustomIOException{
    NonWritableDirectoryException(File file){
        super("cannot write to the directory "+file.getAbsolutePath());

    }
}

class NonExistentFileReadException extends CustomIOException{
    NonExistentFileReadException(File file){
        super("The file "+file.getPath()+ " does not exist hence cannot be read");
    }
}

 class NotAFileExcepion extends CustomIOException {
    NotAFileExcepion(File file){
        super("Given path " + file.getPath() + " is not a file path," +
                " check if it is a directory or contains the parent path");
    }


}

class NonReadableFileException extends CustomIOException{
    NonReadableFileException(File file){
        super("Given file " + file.getPath() + " is not readable, please check permission" );
    }
}

class NonCreatableFileException extends CustomIOException{
    NonCreatableFileException(File file){
        super("Given file " + file.getPath() + "does not exist and cannot be created, " +
                "please check permission or correct naming");
    }
}

class NonWritableFileException extends CustomIOException{
    NonWritableFileException(File file){
        super("Given file " + file.getPath() + "cannot be written to" +
                "please check permissions");
    }
}


