package com.js.core.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.LoggerFactory;

/**
 * MD5工具类
 *
 * @author ken
 */
public class MD5Util {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MD5Util.class);

    public final static String MD5(String s) {
        return DigestUtils.md5Hex(s);
    }

}
