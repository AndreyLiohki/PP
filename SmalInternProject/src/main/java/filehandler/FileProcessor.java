package filehandler;

import dearchiver.Decompressor;
import decryptor.Decryptor;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileProcessor {
    private Decompressor decompressor;
    private Decryptor decryptor;
    public FileProcessor() {
        this.decompressor = new Decompressor();
        this.decryptor = new Decryptor();
    }
    public FileProcessor(Decompressor decompressor, Decryptor decryptor) {
        this.decompressor = decompressor;
        this.decryptor = decryptor;
    }
    public byte[] processFile(String filePath) throws Exception {
        byte[] fileData = readFile(filePath);
        if (isCompressed(filePath)) {
            try {
                fileData = decompressor.decompressFile(fileData);
            } catch (IOException e) {
                throw new Exception("Failed to decompress file", e);
            }
        }
        if (isEncrypted(filePath)) {
            try {
                String decryptionKey = "my_secret_key";
                fileData = decryptor.decryptFile(fileData, decryptionKey);
            } catch (Exception e) {
                throw new Exception("Failed to decrypt file", e);
            }
        }
        if (isZipFile(fileData)) {
            fileData = decompressor.extractTextFromZip(fileData);
        }
        String content = new String(fileData, StandardCharsets.UTF_8);
        return fileData;
    }
    private byte[] readFile(String filePath) throws IOException {
        return Files.readAllBytes(Paths.get(filePath));
    }
    private boolean isCompressed(String filePath) {
        return filePath.endsWith(".gz");
    }
    private boolean isEncrypted(String filePath) {
        return filePath.endsWith(".enc");
    }
    private boolean isZipFile(byte[] fileData) {
        return fileData[0] == 0x50 && fileData[1] == 0x4B;
    }

}
