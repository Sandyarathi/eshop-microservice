package com.email;


import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.codec.binary.Base64;

public class Receiver {

    public void receiveMessage(byte[]  message) throws UnsupportedEncodingException {
        CountDownLatch latch = new CountDownLatch(1);
    	Mail mail = new Mail();
    	String strMessage=new String(message, "UTF-8");
    	System.out.println("THIS IS THE strMESSAGE"+strMessage);
    	byte[] valueDecoded= Base64.decodeBase64(strMessage);
    	System.out.println("Decoded value is " + new String(valueDecoded));    	
    	mail.sendEmail(new String(valueDecoded));
        latch.countDown();
		
    }
  

}
