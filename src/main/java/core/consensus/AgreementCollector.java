package core.consensus;

import chainUtil.ChainUtil;
import core.blockchain.Block;

import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.ArrayList;

public class AgreementCollector {

    long id;
    Block block;
    ArrayList<String> agreedNodes;

    public AgreementCollector(Block block) throws NoSuchAlgorithmException {
        id = generateAgreementCollectorId(block);
        this.block = block;
        agreedNodes = new ArrayList<>();
    }

    public Block getBlock() {
        return block;
    }

    public boolean addAgreedNode(String agreedNode) {
        if(!agreedNodes.contains(agreedNode)){
            agreedNodes.add(agreedNode);
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<String> getAgreedNodes() {
        return agreedNodes;
    }

    public static long generateAgreementCollectorId(Block block) throws NoSuchAlgorithmException {
        return block.getHeader().getBlockNumber();
    }

    public long getId() {
        return id;
    }

    public int getAgreedNodesCount() {
        return agreedNodes.size();
    }

}
