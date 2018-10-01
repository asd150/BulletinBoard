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
    static class object{
         String key = null;
         String value = null;

        object(String key,String value){
            this.key = key;
            this.value = value;
        }
    }
	public static <collection> void main(String[] args) throws InvalidProtocolBufferException {
		// TODO Auto-generated method stub
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",5000).usePlaintext().build();
//        BulletinBoardvGrpc.BulletinBoardvBlockingStub stub = BulletinBoardvGrpc.newBlockingStub(channel);


    }

}
