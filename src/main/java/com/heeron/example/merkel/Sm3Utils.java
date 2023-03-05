package com.heeron.example.merkel;

import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.Arrays;

import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

public class Sm3Utils {
  private static final String ENCODING = "UTF-8";

  static {
    Security.addProvider(new BouncyCastleProvider());
  }

  public static String encrypt(String str) {
    String result = "";
    try {
      byte[] src = str.getBytes(ENCODING);
      byte[] res = hash(src);

      result = ByteUtils.toHexString(res);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    return result;
  }

  public static byte[] hash(byte[] src) {
    SM3Digest d = new SM3Digest();
    d.update(src, 0, src.length);
    byte[] hash = new byte[d.getDigestSize()];
    d.doFinal(hash, 0);
    return hash;
  }

  public static boolean verify(String srcStr, String sm3HexString) {
    boolean flag = false;
    try {
        byte[] srcData = srcStr.getBytes(ENCODING);
        byte[] sm3Hash = ByteUtils.fromHexString(sm3HexString);
        byte[] newHash = hash(srcData);
        if (Arrays.equals(newHash, sm3Hash)) {
            flag = true;
        }
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
    return flag;
  }
}
