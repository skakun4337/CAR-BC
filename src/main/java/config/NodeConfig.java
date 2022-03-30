package config;

import network.Neighbour;

import java.util.ArrayList;
import java.util.List;

public class NodeConfig {
    private final Long peerID;
    private int ListenerPort;
    private List<Neighbour> neighbours;


    public NodeConfig(Long peerID) {
        this.peerID = peerID;
        this.neighbours = new ArrayList<>();
    }

    public Long getPeerID() {
        return peerID;
    }

    public final void setListenerPort(int ListenerPort) {
        this.ListenerPort = ListenerPort;
    }

    public int getListenerPort() {
        return ListenerPort;
    }

    public void addNeighbour(Neighbour neighbour) {
        this.neighbours.add(neighbour);
    }

    public List<Neighbour> getNeighbours() {
        return neighbours;
    }
}
