package core.smartContract;

import chainUtil.ChainUtil;

import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class VehicleContract {

    public boolean registerVehicle(String [][] validations, String data) throws NoSuchAlgorithmException, IOException, SignatureException, NoSuchProviderException, InvalidKeyException, InvalidKeySpecException {
        if(!checkValidityOfValidation(validations, data)){
            return false;
        }
        return true;
    }

    public boolean changeOwnership(String [][] validations, String data) throws NoSuchAlgorithmException, IOException, SignatureException, NoSuchProviderException, InvalidKeyException, InvalidKeySpecException {

        System.out.println("hello from the other side");
        if(!checkValidityOfValidation(validations, data)){
            return false;
        }
        return true;
    }

    public boolean checkTrueOwnership(){
        return true;
    }

    public boolean addMaintenanceRecords(){
        return true;
    }

    public boolean insureVehicle(){
        return true;
    }

    public boolean checkValidityOfValidation(String [][] validations, String data)
            throws NoSuchAlgorithmException, InvalidKeySpecException,
            NoSuchProviderException, IOException, SignatureException, InvalidKeyException {
        for (int i = 0; i<validations.length;i++){
            PublicKey pubk = getPublicKey(validations[i][0]);
            byte[] signature = ChainUtil.hexStringToByteArray(validations[i][1]);

            if (!verify(pubk, signature, data)){
                return false;
            }
        }
        return true;
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public PublicKey getPublicKey(String hexvalue) throws InvalidKeySpecException, NoSuchAlgorithmException, IOException, NoSuchProviderException {
        byte[] encodedPublicKey = hexStringToByteArray(hexvalue);
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedPublicKey);
        return keyFactory.generatePublic(publicKeySpec);
    }

    public static boolean verify(PublicKey publicKey, byte[] signature, String data) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature sig = Signature.getInstance("SHA1withDSA", "SUN");
        sig.initVerify(publicKey);
        sig.update(data.getBytes(),0,data.getBytes().length);
        return sig.verify(signature);
    }

}
