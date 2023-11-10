package com.java.practisesession;

import java.security.*;
import java.math.*;
import java.net.*;
import java.io.*;
 
public class EncryptAndDecryptExample {          
 
     public static String MD5(String s) throws Exception {
                            
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(s.getBytes(),0,s.length());
        return new BigInteger(1,m.digest()).toString(16);
        
     }
              
     public static String Decrypt(String md5_hash) throws Exception {
                            
          String api_key = "YOUR_VIP_KEY";
          URL md5online = new URL("https://www.md5online.org/api.php?d=1&p="+api_key+"&h="+md5_hash);
          BufferedReader in = new BufferedReader(new InputStreamReader(md5online.openStream()));
                            
          String result = "";
          String inputLine;
          while ((inputLine = in.readLine()) != null)
             result = result+inputLine;
          in.close();
                            
          return result;
    }
              
    public static void main(String args[]) throws Exception {
 
           //Encode
           String md5 = MD5("MD5Online");
           System.out.println("MD5 hash: "+md5);
              
           //Decode
           String word = Decrypt(md5);
           System.out.println("API Result: "+word);
              
    }
} 