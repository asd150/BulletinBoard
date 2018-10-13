package com.bulletinboard;
import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BulletinBoardClient{


	public static <collection> void main(String[] args) throws InvalidProtocolBufferException {
        // TODO Auto-generated method stub
       ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",5000).usePlaintext().build();

        BulletinBoardSGrpc.BulletinBoardSBlockingStub stub = BulletinBoardSGrpc.newBlockingStub(channel);


//    Iterator<confirm> it =  stub.post(com.bulletinboard.msg.newBuilder().setTitle("Title").setBody("This is body").build());
//       int i=1;
//        while(it.hasNext()){
//            System.out.println(i + " " + it.next());
//            i++;
//        }
//	}


    }
}
