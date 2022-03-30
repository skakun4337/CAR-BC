package core.consensus;

import core.blockchain.Block;
import core.blockchain.Transaction;

//remove this class
public class Agreement {

    Transaction transaction;
    Boolean agreed;

    public Agreement(Transaction transaction) {
        this.transaction = transaction;
        agreed = false;
    }

    public void setAgreed(Boolean agreed) {
        this.agreed = agreed;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Boolean getAgreed() {
        return agreed;
    }
}
