package core.blockchain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class TempResponsePool {
    private static  HashMap<String,ArrayList<TransactionResponse>> responsePool;
    private static TempResponsePool tempResponsePool;
    //private String proposalID;


    private TempResponsePool() {
        this.responsePool = new HashMap<String,ArrayList<TransactionResponse>>();
    }


    public static TempResponsePool getTempResponsePool() {
        if (tempResponsePool==null){
            tempResponsePool = new TempResponsePool();
        }
        return tempResponsePool;
    }



    public static HashMap<String, ArrayList<TransactionResponse>> getResponsePool() {
        if (responsePool==null){
            responsePool = new HashMap<String, ArrayList<TransactionResponse>>();
        }
        return responsePool;
    }

    public static void setResponsePool(HashMap<String, ArrayList<TransactionResponse>> responsePool) {
        TempResponsePool.responsePool = responsePool;
    }

    public ArrayList getResponses(String proposalID){
        ArrayList <TransactionResponse> signedProposals = responsePool.get(proposalID);
        return signedProposals;
    }

}
