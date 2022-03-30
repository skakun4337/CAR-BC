package core.blockchain;

public class SigningObject {
    private String sender;
    private TransactionInfo transactionInfo;

    public SigningObject(String sender, TransactionInfo transactionInfo) {
        this.sender = sender;
        this.transactionInfo = transactionInfo;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public TransactionInfo getTransactionInfo() {
        return transactionInfo;
    }

    public void setTransactionInfo(TransactionInfo transactionInfo) {
        this.transactionInfo = transactionInfo;
    }
}
