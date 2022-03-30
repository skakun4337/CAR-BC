package core.connection;

public class VehicleHistory {
    private String vid;
    private String transaction_id;
    private int block_id;
    private String block_hash;
    private String event;
    private String sender;
    private String validation_array;
    private String data;
    private String smartContractName;
    private String smartContractSignature;
    private String smartContractMethod;
    private Object[] parameters;

    public VehicleHistory(){

    }

    public VehicleHistory(String vid, String transaction_id,int block_id,
                          String block_hash,String event,String sender,
                          String validation_array,String data, String smartContractName,
                          String smartContractSignature, String smartContractMethod,
                          Object[] parameters) {

        this.setVid(vid);
        this.setTransactionId(transaction_id);
        this.setBlockId(block_id);
        this.setBlockHash(block_hash);
        this.setEvent(event);
        this.setSender(sender);
        this.setValidationArray(validation_array);
        this.setData(data);
        this.setSmartContractName(smartContractName);
        this.setSmartContractSignature(smartContractSignature);
        this.setSmartContractMethod(smartContractMethod);
        this.setParameters(parameters);

    }




    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getTransactionId() {
        return transaction_id;
    }

    public void setTransactionId(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getBlockId() {
        return block_id;
    }

    public void setBlockId(int block_id) {
        this.block_id = block_id;
    }

    public String getBlockHash() {
        return block_hash;
    }

    public void setBlockHash(String block_hash) {
        this.block_hash = block_hash;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getValidationArray() {
        return validation_array;
    }

    public void setValidationArray(String validation_array) {
        this.validation_array = validation_array;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSmartContractSignature() {
        return smartContractSignature;
    }

    public void setSmartContractSignature(String smartContractSignature) {
        this.smartContractSignature = smartContractSignature;
    }

    public String getSmartContractMethod() {
        return smartContractMethod;
    }

    public void setSmartContractMethod(String smartContractMethod) {
        this.smartContractMethod = smartContractMethod;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public String getSmartContractName() {
        return smartContractName;
    }

    public void setSmartContractName(String smartContractName) {
        this.smartContractName = smartContractName;
    }

}