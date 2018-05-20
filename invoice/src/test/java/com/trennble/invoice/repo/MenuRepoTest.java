package com.trennble.invoice.repo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trennble.invoice.InvoiceApplication;
import com.trennble.invoice.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {InvoiceApplication.class})
public class MenuRepoTest {

    @Inject
    private MenuRepo menuRepo;

    @Inject
    private MenuService menuService;

    @Test
    public void findByPidIsNull() throws JsonProcessingException {
        List<Map<String, Object>> res = menuService.menuRole();


        System.out.println((new ObjectMapper()).writeValueAsString(res));
    }

    @Test
    public void menuTree() throws JsonProcessingException {

        List<Map<String, Object>> res = menuService.menuTree();
        System.out.println((new ObjectMapper()).writeValueAsString(res));
    }
}
