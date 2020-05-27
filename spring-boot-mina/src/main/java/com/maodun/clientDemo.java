package com.maodun;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author tongjian
 * @date 2020/5/27 9:32
 */
public class clientDemo {
    public static void main(String[] args) throws IOException {
        int serverPort = 8888;
        Socket socket = new Socket("localhost", serverPort);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("haha".getBytes("UTF-8"));
        outputStream.flush();

        outputStream.close();
        socket.close();
    }
}
