package com.bulletinboard;
import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BulletinBoardClient{


	public static <collection> void main(String[] args) throws InvalidProtocolBufferException {
        // TODO Auto-generated method stub
       ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",5000).usePlaintext().build();

        BulletinBoardSGrpc.BulletinBoardSBlockingStub stub = BulletinBoardSGrpc.newBlockingStub(channel);

       // stub.post(msg.newBuilder().setTitle("Hello").setBody("This is first message").build());

//    Iterator<confirm> it =  stub.post(com.bulletinboard.msg.newBuilder().setTitle("Title").setBody("This is body").build());
//       int i=1;
//        while(it.hasNext()){
//            System.out.println(i + " " + it.next());
//            i++;
//        }
//	}

        //lets post some notice
        //stub.post(msg.newBuilder().setTitle("1").setTitle("Title 1").build());

        while(true) {
            System.out.println("Input a Command");
            Scanner sn = new Scanner(System.in);
            String str = sn.nextLine();

            System.out.println();
            String[] cmd = str.split("\\s+");

            if (cmd[0].equalsIgnoreCase("post")) {
                confirm response = stub.post(msg.newBuilder().setTitle(cmd[1]).setBody(cmd[2]).build());
                System.out.println(response);
            } else if (cmd[0].equalsIgnoreCase("get")) {
                msg msg = stub.get(confirm.newBuilder().setConfirmation(cmd[1]).build());
                System.out.println(msg.getTitle() + " " + msg.getBody());
            } else if (cmd[0].equalsIgnoreCase("delete")) {
                confirm confirm = stub.delete(com.bulletinboard.confirm.newBuilder().setConfirmation(cmd[1]).build());
                System.out.println(confirm.getConfirmation());

            } else if (cmd[0].equalsIgnoreCase("list")) {
                Iterator<msg> it = stub.list(confirm.newBuilder().setConfirmation("getList").build());
                //System.out.println(it.hasNext());
                while(it.hasNext()){
                   msg msg = it.next();
                    System.out.println(msg.getTitle() + "  " + msg.getBody());
                }


            }
        }


    }
}
