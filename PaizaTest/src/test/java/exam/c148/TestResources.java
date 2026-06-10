package exam.c148;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

final class TestResources {
    private TestResources() {}

    static String readResourceText(final String resourcePath) {
        final InputStream resourceStream = openResourceStream(resourcePath);
        try (InputStream is = resourceStream) {
            return readAllUtf8(is);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read resource: " + resourcePath, e);
        }
    }

    private static InputStream openResourceStream(final String resourcePath) {
        Class<?> clazz = TestResources.class;
        final ClassLoader loader = clazz.getClassLoader();
        final InputStream result = loader.getResourceAsStream(resourcePath);
        if (result == null) throw new IllegalArgumentException("Resource not found: " + resourcePath);
        return result;
    }

    private static String readAllUtf8(final InputStream inputStream) throws IOException {
        final byte[] bytes = inputStream.readAllBytes();
        return new String(bytes, StandardCharsets.UTF_8);
    }

    private static final class UncheckedIOException extends RuntimeException {
        private UncheckedIOException(final String message, final IOException cause) {
            super(message, cause);
            }
    }
    
}
