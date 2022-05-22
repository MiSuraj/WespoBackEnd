package com.wespobazaar.wespo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

@RestController
@RequestMapping("/s")
public class SMS {
    @RequestMapping("/sms")
    public static void mail() {
        System.out.println("Program started.....");
        String message="THIS IS SURAJ OTP ";
        String number="7786877646";

         try
        {

            String apiKey="DnId30JGpCPKEf5vV6jmhAbqiOBTue9t1oZMUga7XYz2ryxRc8q7Hg5JSpD3PcNAyeZGb1MjU8zl0hLk";
            String sendId="WSPSMS";
            //important step...

            String language="english";
            String otp="9876";
            // otp= URLEncoder.encode(otp, "UTF-8");
            String route="p";



            String myUrl="https://www.fast2sms.com/dev/bulkV2?authorization="+apiKey+"&variables_values=5599&route=otp&numbers=8081044632"; //sending get request using java..


            URL url=new URL(myUrl);

            HttpsURLConnection con=(HttpsURLConnection)url.openConnection();


            con.setRequestMethod("GET");

            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestProperty("cache-control", "no-cache");
            System.out.println("Wait..............");

            int code=con.getResponseCode();

            System.out.println("Response code : "+code);

            StringBuffer response=new StringBuffer();

            BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));

            while(true)
            {
                String line=br.readLine();
                if(line==null)
                {
                    break;
                }
                response.append(line);
            }

            System.out.println(response);


        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }




    }
}

