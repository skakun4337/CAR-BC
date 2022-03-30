package network.Listener.Handlers;

import core.communicationHandler.RequestHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import network.Client.RequestMessage;
import network.Protocol.AckMessageCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;

public class CommonListenerHandler extends ChannelInboundHandlerAdapter {
    private final Logger log = LoggerFactory.getLogger(CommonListenerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException, IOException, SignatureException, InvalidKeyException, ParseException, SQLException {
        if(msg instanceof RequestMessage){
            RequestMessage requestMessage = (RequestMessage) msg;
            Map<String, String> headers = requestMessage.readHeaders(); //TODO: Inspect headers
            String data = requestMessage.readData();
//            Handler.getInstance().handle(data, headers);
            RequestHandler.getInstance().handleRequest(headers,data);
            //-------------------------------------------
            // call the workflow methods here after checking the headers
            // can use switch-case and call the methods
            //-----------------------------------------------

            System.out.println("=====================================");
            System.out.println("        at the server side           ");
            System.out.println("=====================================");
            System.out.println("----------headers----------------");
            System.out.println(headers.toString());
            System.out.println("----------data----------------");
            System.out.println(data);

            RequestMessage ackMessage = AckMessageCreator.createAckMessage("Block");
            ackMessage.addHeader("keepActive", "false");
            ChannelFuture f = ctx.writeAndFlush(ackMessage);

            //if the msg we received had the header "keepActive" set to false
            //then close the channel
            if("false".equals(headers.get("keepActive"))) {
                //finish the process
                f.addListener(ChannelFutureListener.CLOSE);
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
