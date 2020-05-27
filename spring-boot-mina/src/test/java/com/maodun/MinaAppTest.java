package com.maodun;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author tongjian
 * @date 2020/5/27 9:27
 */
@SpringBootTest
class MinaAppTest {
    @Value("${mina.port}")
    private int serverPort;

    @Test
    void testClientInfo() throws IOException {
        Socket socket = new Socket("localhost", serverPort);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        outputStream.write("haha".getBytes("UTF-8"));
        outputStream.flush();
        byte[] byteArray = new byte[1024];
        int length = inputStream.read(byteArray);
        Assertions.assertEquals("haha-haha", new String(byteArray, 0, length, "UTF-8"));

        inputStream.close();
        outputStream.close();
        socket.close();
    }

}