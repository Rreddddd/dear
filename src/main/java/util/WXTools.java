package util;

import com.alibaba.fastjson.JSONObject;
import entity.MemberEntity;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.codehaus.xfire.util.Base64;
import service.impl.MemberImplService;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;

public interface WXTools {

    static MemberEntity getMemberByJsCode(String encryptedData,String jsCode,String iv){
        return getMemberBySessionKey(encryptedData,ApiTools.getWxSessionKey(jsCode),iv);
    }

    static MemberEntity getMemberBySessionKey(String encryptedData,String sessionKey,String iv){
        try {
            byte[] dataByte = Base64.decode(encryptedData);
            byte[] keyByte = Base64.decode(sessionKey);
            byte[] ivByte = Base64.decode(iv);

            int keyLen = keyByte.length;
            int base = 16;
            if(keyLen%base!=0){
                byte[] temp = new byte[(keyLen/base+1)*base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte,0,temp,0,keyLen);
                keyByte=temp;
            }
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                JSONObject jsonObject = JSONObject.parseObject(new String(resultByte, StandardCharsets.UTF_8));
                MemberEntity result=new MemberEntity();
                result.setName(jsonObject.getString("nickName"));
                result.setHeadImgUrl(jsonObject.getString("avatarUrl"));
                result.setWxOpenId(jsonObject.getString("openId"));
                return SpringBeanTools.getBeanByClassType(MemberImplService.class).syncWXMember(result);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | NoSuchProviderException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException | InvalidParameterSpecException | NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}