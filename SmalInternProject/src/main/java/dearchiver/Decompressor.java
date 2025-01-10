package dearchiver;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Decompressor {
    public byte[] decompressFile(byte[] compressedData) throws IOException {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressedData);
             GZIPInputStream gis = new GZIPInputStream(byteArrayInputStream);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = gis.read(buffer)) > 0) {
                byteArrayOutputStream.write(buffer, 0, length);
            }
            return byteArrayOutputStream.toByteArray();
        }
    }
    public byte[] extractTextFromZip(byte[] zipData) throws IOException {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(zipData);
             ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream)) {

            ZipEntry entry = zipInputStream.getNextEntry();
            if (entry != null && (entry.getName().endsWith(".txt") || entry.getName().endsWith(".json")
                    || entry.getName().endsWith(".xml") || entry.getName().endsWith(".yaml"))) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = zipInputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                return outputStream.toByteArray();
            }
        }

        throw new IOException("No valid text file found in the ZIP archive.");
    }
}
