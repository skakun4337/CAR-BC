import Exceptions.FileUtilityException;
import chainUtil.ChainUtil;
import chainUtil.KeyGenerator;
import config.CommonConfigHolder;
import constants.Constants;
import core.blockchain.*;
import core.consensus.Consensus;
import network.Client.RequestMessage;
import network.Node;
import network.Protocol.BlockMessageCreator;
import org.json.JSONObject;
import org.slf4j.impl.SimpleLogger;

import java.security.PublicKey;
import java.sql.Timestamp;
import java.util.ArrayList;

public class TestSendBlock {
    public static void main(String[] args) throws FileUtilityException {
        System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "INFO");

        /*
        * Set the main directory as home
        * */
        System.setProperty(Constants.CARBC_HOME, System.getProperty("user.dir"));

        /*
        * At the very beginning
        * A Config common to all: network, blockchain, etc.
        * */
        CommonConfigHolder commonConfigHolder = CommonConfigHolder.getInstance();
        commonConfigHolder.setConfigUsingResource("peer3");

        /*
        * when initializing the network
        * */
        Node node = Node.getInstance();
        node.init();

        /*
        * when we want our node to start listening
        * */
        node.startListening();

        try {
            //block creation
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Validator validator1 = new Validator("val1pubkey", "owner", "true", 3);
            Validator validator2 = new Validator("val2pubkey", "seller", "true", 4);
            ArrayList<Validation> validations = new ArrayList<>();
            validations.add(new Validation(validator1, "3332"));
            validations.add(new Validation(validator2, "3442"));
            BlockHeader blockHeader = new BlockHeader("101", "1234", "",
                    "senderPubkey", 123, true);
            Transaction transaction = new Transaction("senderpubkey", validations, "1456",
                    new TransactionInfo());

            Block block = new Block(blockHeader, transaction);
//            Consensus.getInstance().requestAgreementForBlock(block);
//            Consensus.getInstance().addToAgreementCollectors(block);
//            Consensus.getInstance().agreedTransaction(block.getTransaction());
        }catch (Exception e) {
            e.printStackTrace();
        }


        /*
        * when we want to send a block
        * */
//        JSONObject ourBlock = new JSONObject();
//        ourBlock.put("someField", "someValue");
//        RequestMessage blockMessage = BlockMessageCreator.createBlockMessage(ourBlock);
//        blockMessage.addHeader("keepActive", "false");
//        node.sendMessageToNeighbour(0, blockMessage);
    }
}
