package factory;

import filehandler.JSONFileHandler;

public class JsonFileReaderFactory extends FileReaderFactory{
    @Override
    public JSONFileHandler createFileReader(){return new JSONFileHandler();}
}
