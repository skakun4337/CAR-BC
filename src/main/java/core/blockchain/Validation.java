package core.blockchain;

import chainUtil.ChainUtil;

import java.security.PublicKey;

public class Validation {
    private Validator validator;
    private String  signature;


    public Validation(Validator validator, String signature) {
        this.validator = validator;
        this.signature = signature;
    }


    public Validator getValidator() {
        return validator;
    }

    public String getSignature() {
        return signature;
    }


    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

//    @Override
//    public String toString(){
//
//        return "'Validator:'" + this.validator.toString() + "'Signature:'" + ChainUtil.bytesToHex(this.signature);
//    }

}
