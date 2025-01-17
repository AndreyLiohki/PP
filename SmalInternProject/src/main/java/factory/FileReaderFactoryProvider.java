package factory;

public class FileReaderFactoryProvider {
    public static FileReaderFactory getFactory(String fileExtension) {
        return switch (fileExtension.toLowerCase()) {
            case "json" -> new JsonFileReaderFactory();
            case "xml" -> new XMLFileReaderFactory();
            case "yaml", "yml" -> new YAMLFileReaderFactory();
            case "txt" -> new PlainTextFileReaderFactory();

            case "txt.zip" ->new PlainTextFileReaderFactory();
            case "yaml.zip", "yml.zip" -> new YAMLFileReaderFactory();
            case "xml.zip" -> new XMLFileReaderFactory();
            case "json.zip" -> new JsonFileReaderFactory();

            case "txt.gz" ->new PlainTextFileReaderFactory();
            case "yaml.gz", "yml.gz" -> new YAMLFileReaderFactory();
            case "xml.gz" -> new XMLFileReaderFactory();
            case "json.gz" -> new JsonFileReaderFactory();

            default -> throw new IllegalArgumentException("Unsupported file type: " + fileExtension);
        };
    }
}
