package network;

import config.CommonConfigHolder;
import config.NodeConfig;
import network.Client.Client;
import network.Client.RequestMessage;
import network.Listener.Listener;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public final class Node {
    private final Logger log = LoggerFactory.getLogger(Node.class);
    private static final Node instance = new Node();

    Listener listener;
    Client client;

    private NodeConfig nodeConfig;

    private Node() {}

    public static Node getInstance() {
        return instance;
    }

    public void init() {

        /* Set config and its parameters */
        Random random = new Random();
        long peerID = random.nextLong();

        //Create config
        this.nodeConfig = new NodeConfig(peerID);

        //Set port to listen on
        JSONObject commonConfig = CommonConfigHolder.getInstance().getConfigJson();
        nodeConfig.setListenerPort(commonConfig.getInt("listener_port"));

        //Add neighbours list
        JSONArray neighbours = commonConfig.getJSONArray("neighbours");
        for (int i = 0; i < neighbours.length(); i++) {
            JSONObject neighbourJson = neighbours.getJSONObject(i);
            String neightbourIP = neighbourJson.getString("ip");
            int neightbourPort = neighbourJson.getInt("port");
            Neighbour neighbour = new Neighbour(neightbourIP, neightbourPort);
            nodeConfig.addNeighbour(neighbour);
        }

        log.info("Initializing Node:{}", peerID);

    }

    public void startListening() {
        this.listener = new Listener();
        this.listener.init(nodeConfig.getListenerPort());
        this.listener.start();
        log.info("Initialized listener");
    }

    public void sendMessageToNeighbour(int neighnourIndex, RequestMessage requestMessage) {
        Client client = new Client();
        Neighbour neighbour1 = nodeConfig.getNeighbours().get(neighnourIndex);
        client.init(neighbour1, requestMessage);
        client.start();
        log.info("Initialized client");
    }

}
