package com.macro.emc.portal;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

@Slf4j
public class RSAEncrypt {

    private static String PRIVATE_KEY =
        "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIZ5dwlI8l3EAzjmDPeyS5Rg6xhqpL9I0sB1/nloE1M/Qx+uVbCnNpJtl5b72NkMDDCDbCpykC13THXYheS94/tkokEpB+Ki/J4jALW2VFWLXWVAAYEoo7uF9msFOWKjN9QYXe45x/cim0f39VfRxxaNgQkOe5nlcS0NlUbeB+NBAgMBAAECgYB78CMn6ZWHmgqmPFEjUa6a+KB1BoUEz6d+PsHlP2jgRuQkpNbRU6vWVS9rtn5rvNDXPalJjgEYBmXwDzmIUwN04GCDjCN9j2ASghNMkxh7nFWmGlh9J5584dCw+iUk9T4Y7hFulJW987I8eow8GW+HV2qeK/4EpLqzV2OEP268aQJBAPmpgANnolsBtWLkgyN7zkHdw3h61ODfawfjdNq3gJJh78so6AspabrfaFE52yR3shfhuxhNQsnqsRckMJY+bAMCQQCJ42KsVKzwMtireHhtV1N3b6KGfdWErBydYTaxxFn2/G8ULOjLOwS/sbN33vvpSIGUsoxLqFt8mfiz+2Z5EuprAkEAi9S1kDKhKlugngziriMPeLCeZIJXbMN1jOuGbWHNry8PQTheDrJZN4MdSDEhXiF0LBAP3CKZv8GlAhMQ63V2xQJAB0Tsi8c/Ar67e3azaphC9zX0bICvw/nK3GUmnAKM959hP8AKWcR3wJ9epcAkqay/4BX1nXt3rz7yxJJJWbKslwJAVFfq1SI+Glb3jVK5Ev79hVWBPIlwHy08MnH4bxhbzDG4o/DDsScRimJU1J/tv3r/FV7iz3swW37S9SII4CmcJA==";

    private static String PUBLIC_KEY =
        "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCGeXcJSPJdxAM45gz3skuUYOsYaqS/SNLAdf55aBNTP0MfrlWwpzaSbZeW+9jZDAwwg2wqcpAtd0x12IXkveP7ZKJBKQfiovyeIwC1tlRVi11lQAGBKKO7hfZrBTliozfUGF3uOcf3IptH9/VX0ccWjYEJDnuZ5XEtDZVG3gfjQQIDAQAB";

    /**
     * RSA公钥加密
     *
     * @param str 加密字符串
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public static String encrypt(String str) {
        try {
            // base64编码的公钥
            byte[] decoded = Base64.decodeBase64(PUBLIC_KEY);
            RSAPublicKey pubKey =
                (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
            // RSA加密
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
            return outStr;
        } catch (Exception e) {
            log.error("[RSA加密]RSA加密失败 str:{} e:{}", str, e);
            e.printStackTrace();
        }
        return "";
    }

    /**
     * RSA私钥解密
     *
     * @param str 加密字符串
     * @return 铭文
     * @throws Exception 解密过程中的异常信息
     */
    public static String decrypt(String str) {
        return decrypt(PRIVATE_KEY, str);
    }

    /**
     * RSA私钥解密
     *
     * @param key 秘钥
     * @param str 加密字符串
     * @return 铭文
     * @throws Exception 解密过程中的异常信息
     */
    public static String decrypt(String key, String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            // 64位解码加密后的字符串
            byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
            // base64编码的私钥
            byte[] decoded = Base64.decodeBase64(key);
            RSAPrivateKey priKey =
                (RSAPrivateKey)KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
            // RSA解密
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            String outStr = new String(cipher.doFinal(inputByte));
            return outStr;
        } catch (Exception e) {
            log.error("[RSA解密]RSA解密失败 str:{} e:{}", str, e);
        }
        return "";
    }

}
