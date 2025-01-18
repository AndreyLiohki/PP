import dearchiver.Decompressor;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

public class DecompressorTest {
    private final Decompressor decompressor = new Decompressor();

    @Test
    public void testDecompressGzip() throws Exception {
        String originalText = "Hello, World!";
        byte[] compressedData;

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream)) {
            gzipOutputStream.write(originalText.getBytes());
            gzipOutputStream.finish();
            compressedData = byteArrayOutputStream.toByteArray();
        }

        byte[] result = decompressor.decompressFile(compressedData);

        assertArrayEquals(originalText.getBytes(), result);
    }

    @Test
    public void testExtractTextFromZip() throws Exception {
        String fileName = "test.txt";
        String fileContent = "This is a test file.";
        byte[] zipData;

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream)) {
            ZipEntry zipEntry = new ZipEntry(fileName);
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.write(fileContent.getBytes());
            zipOutputStream.closeEntry();
            zipOutputStream.finish();
            zipData = byteArrayOutputStream.toByteArray();
        }

        byte[] result = decompressor.extractTextFromZip(zipData);

        assertArrayEquals(fileContent.getBytes(), result);
    }

    @Test
    public void testExtractTextFromZipNoValidFile() {
        byte[] zipData = new byte[0];

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream)) {
            ZipEntry zipEntry = new ZipEntry("test.pdf"); // Неподдерживаемый формат
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.write("This is a PDF file.".getBytes());
            zipOutputStream.closeEntry();
            zipOutputStream.finish();
            zipData = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            fail("Failed to create test ZIP archive.");
        }
        try {
            decompressor.extractTextFromZip(zipData);
            fail("Expected IOException was not thrown.");
        } catch (IOException e) {
        }
    }
}