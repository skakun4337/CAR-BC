package core.blockchain;

public class TransactionInfo {
    private int threshod;
    private String smartContractName;
    private String smartContractSignature;
    private String smartContractMethod;
    private Object[] parameters;
    private String event;
    private String data;
    private String vehicleId;



    public int getThreshod() {
        return threshod;
    }

    public String getSmartContractName() {
        return smartContractName;
    }

    public String getSmartContractSignature() {
        return smartContractSignature;
    }

    public String getSmartContractMethod() {
        return smartContractMethod;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setThreshod(int threshod) {
        this.threshod = threshod;
    }

    public void setSmartContractName(String smartContractName) {
        this.smartContractName = smartContractName;
    }

    public void setSmartContractSignature(String smartContractSignature) {
        this.smartContractSignature = smartContractSignature;
    }

    public void setSmartContractMethod(String smartContractMethod) {
        this.smartContractMethod = smartContractMethod;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

//
//    @Override
//    public String toString(){
//
//        return null;
//    }
}
