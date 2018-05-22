package com.trennble.invoice.util;

import com.trennble.invoice.rpc.UserRpc;

import javax.inject.Inject;
import java.util.HashMap;

public class ServiceUtil {

    @Inject
    private static UserRpc userRpc;

    public static Integer getUserId(){

        return (Integer) ((HashMap) userRpc.user().get("principal")).get("id");
    }
}
