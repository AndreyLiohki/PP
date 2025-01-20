package writerfactory;

import filewriter.JSONWriter;
import filewriter.PlainTextWriter;
import filewriter.ResultWriter;
import filewriter.YAMLWriter;

public class ResultWriterFactory {
    public static ResultWriter getWriter(String format) {
        switch (format.toLowerCase()) {
            case "json":
                return new JSONWriter();
            case "txt":
                return new PlainTextWriter();
            case "yaml":
                return new YAMLWriter();
            default:
                throw new IllegalArgumentException("Unsupported format: " + format);
        }
    }
}
