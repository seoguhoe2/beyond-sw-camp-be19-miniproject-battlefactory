package battlefactory.member;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutput extends ObjectOutputStream {
    protected MyObjectOutput(OutputStream outputStream) throws IOException, SecurityException {
    }

    @Override
    protected void writeStreamHeader() throws IOException {
    }
}
