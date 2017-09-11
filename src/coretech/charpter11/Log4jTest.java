package coretech.charpter11;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Try to implement log system. Just one error method and write to file for now.
 */
public class Log4jTest {
    public void error(String message, Throwable e) {
        LogEntity logEntity = new LogEntity(LogLevel.ERROR, message, e);
        String path = "C:\\Users\\i324167\\uiworkspace\\self-learning\\src\\coretech\\charpter11\\testlog.json";
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(path, true);
            FileChannel curChannel = out.getChannel();
            long curPos = curChannel.position();
            if (curPos == 0) {
                String content = "[" + logEntity.toString() + "]";
                curChannel.write(ByteBuffer.wrap(content.getBytes()));
            } else {
                String content = "," + logEntity.toString() + "]";
                curChannel.write(ByteBuffer.wrap(content.getBytes()), curPos - 1);
                /**
                 * This exercise proof that: write with specific position, if the given position is smaller than current
                 * file position, the content in file between the given position and current file end position will be
                 * cover with this written content.
                 */
            }
            // out.getChannel().write(ByteBuffer.wrap(logEntity.toString().getBytes()));
            // out.write(logEntity.toString().getBytes());
            out.flush();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String path = "C:\\Users\\i324167\\uiworkspace\\self-learning\\src\\coretech\\charpter11";
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            Log4jTest log4jTest = new Log4jTest();
            log4jTest.error("just for a test", e);
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                Log4jTest log4jTest = new Log4jTest();
                log4jTest.error("just for a test", e);
            }
        }

    }

}