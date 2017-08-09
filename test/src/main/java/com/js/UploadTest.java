/**
 * 
 */
package com.js;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author oa_wenzongyuan
 */
public class UploadTest {

    public static void main(String[] args) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String s = sdf.format(d);
        System.out.println(s);
    }
}
