package core.connection;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;

public class SmartContract {
    private String signature;
    private String contractName;
    private String code;
    private String owner;
    private String message;
    private int block_number;
    private Timestamp block_timestamp;
    private String block_hash;

    public SmartContract(){}

    public SmartContract(String signature, String contractName, String code,
                         String owner, String message, int block_number,
                         Timestamp block_timestamp, String block_hash){

        this.setSignature(signature);
        this.setContractName(contractName);
        this.setCode(code);
        this.setOwner(owner);
        this.setMessage(message);
        this.setBlock_number(block_number);
        this.setBlock_timestamp(block_timestamp);
        this.setBlock_hash(block_hash);
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractMethod) {
        this.contractName = contractMethod;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getBlock_number() {
        return block_number;
    }

    public void setBlock_number(int block_number) {
        this.block_number = block_number;
    }

    public Timestamp getBlock_timestamp() {
        return block_timestamp;
    }

    public void setBlock_timestamp(Timestamp block_timestamp) {
        this.block_timestamp = block_timestamp;
    }

    public String getBlock_hash() {
        return block_hash;
    }

    public void setBlock_hash(String block_hash) {
        this.block_hash = block_hash;
    }

    public InputStream getContractInputStream(){
        InputStream stream = new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8));
        return stream;
    }
}
