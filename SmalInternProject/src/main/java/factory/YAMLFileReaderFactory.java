package factory;

import filehandler.YAMLFileHandler;

public class YAMLFileReaderFactory extends FileReaderFactory{
    @Override
    public YAMLFileHandler createFileReader(){return new YAMLFileHandler();}
}
