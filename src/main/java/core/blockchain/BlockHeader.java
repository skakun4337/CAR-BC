package core.blockchain;

public class BlockHeader {
    private String version;
    private String previoushash;
    private String hash;
    private String timestamp;
    //private int txCount;
    private String signer;
    private long blockNumber;
    private boolean isApproved;


    //constructor


    public BlockHeader(String version, String previoushash, String timestamp, String signer, long blockNumber, boolean isApproved) {
        this.version = version;
        this.previoushash = previoushash;
        this.setTimestamp(timestamp);
        this.signer = signer;
        this.blockNumber = blockNumber;
        this.isApproved = false;
    }




    // getters

    public String getVersion() {
        return version;
    }

    public String getPrevioushash() {
        return previoushash;
    }



    public String getSigner() {
        return signer;
    }

    public long getBlockNumber() {
        return blockNumber;
    }

    public String getHash() {
        return hash;
    }

    public boolean isApproved() {
        return isApproved;
    }

    //setters


    public void setVersion(String version) {
        this.version = version;
    }

    public void setPrevioushash(String previoushash) {
        this.previoushash = previoushash;
    }


    public void setSigner(String signer) {
        this.signer = signer;
    }

    public void setBlockNumber(long blockNumber) {
        this.blockNumber = blockNumber;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
