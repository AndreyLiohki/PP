package factory;

import filehandler.XMLFileHandler;

public class XMLFileReaderFactory extends FileReaderFactory{
    @Override
    public XMLFileHandler createFileReader(){return new XMLFileHandler();}
}
