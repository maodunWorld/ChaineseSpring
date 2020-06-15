package com.maodun.handler;

import com.maodun.bean.StringBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tongjian
 * @date 2020/5/27 9:15
 */
@Component
@Slf4j
public class ServerHandler extends IoHandlerAdapter {
//    public static final AtomicInteger atomicInteger = new AtomicInteger(0);
//    public static final FunctionCounter testunit = FunctionCounter.builder("a.test.counter2", atomicInteger, AtomicInteger::get)
//            .baseUnit("testunit")
//            .register(Metrics.globalRegistry);
    @Autowired
    private StringBean stringBean;

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        IoBuffer inBuf = (IoBuffer) message;
        byte[] inbytes = new byte[inBuf.limit()];
        inBuf.get(inbytes, 0, inBuf.limit());
        String result = stringBean.cheng2(new String(inbytes, "UTF-8"));
        log.info(result);
        // 发送到客户端
        byte[] responseByteArray = result.getBytes("UTF-8");
        IoBuffer responseIoBuffer = IoBuffer.allocate(responseByteArray.length);
        responseIoBuffer.put(responseByteArray);
        responseIoBuffer.flip();
        session.write(responseIoBuffer);
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        super.exceptionCaught(session, cause);
    }
}
