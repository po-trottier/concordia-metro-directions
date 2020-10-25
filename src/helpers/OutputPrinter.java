package helpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;


/**
 * The type Output printer is used to write both to the console logs and to a file.
 */
public class OutputPrinter
{
    private final PrintStream out;
    private final FileWriter writer;

    /**
     * Instantiates a new Output printer.
     *
     * @param out  the output stream to write to
     * @param file the file to write to
     * @throws IOException the io exception will occur if the file chosen cannot be written to
     */
    public OutputPrinter(PrintStream out, File file) throws IOException {
        this.out = new PrintStream(out);
        this.writer = new FileWriter(file, false);
    }

    /**
     * Clear the logs file.
     *
     * @throws IOException the io exception will occur if the file chosen cannot be written to
     */
    public void clear() throws IOException {
        writer.write("");
    }

    /**
     * Write a new line to both the Output Stream and File.
     *
     * @param text the text to write
     * @throws IOException the io exception will occur if the file chosen cannot be written to
     */
    public void writeln(String text) throws IOException {
        out.println(text);
        writer.append(text).append("\n");
    }

    /**
     * Close the file stream.
     *
     * @throws IOException the io exception will occur if the file chosen cannot be written to
     */
    public void close() throws IOException {
        writer.close();
    }
}
