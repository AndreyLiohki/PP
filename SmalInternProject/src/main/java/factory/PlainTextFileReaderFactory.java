package factory;

import filehandler.PlainTextReader;

public class PlainTextFileReaderFactory extends FileReaderFactory{
    @Override
    public PlainTextReader createFileReader(){return new PlainTextReader();}
}
