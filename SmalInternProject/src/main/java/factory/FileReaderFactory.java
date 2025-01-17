package factory;

import  filehandler.FileHandler;

public abstract class FileReaderFactory {
    public abstract FileHandler createFileReader();

}
