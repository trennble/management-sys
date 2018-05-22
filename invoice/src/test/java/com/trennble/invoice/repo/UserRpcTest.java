package com.trennble.invoice.repo;

import com.trennble.invoice.InvoiceApplication;
import com.trennble.invoice.rpc.UserRpc;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {InvoiceApplication.class})
public class UserRpcTest {

    @Inject
    private UserRpc userRpc;

    public void user(){
        userRpc.user();
    }
}
