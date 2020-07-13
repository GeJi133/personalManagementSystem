//package org.csu.personalManageSystem;
//
//import com.aliyuncs.exceptions.ClientException;
//import org.csu.personalManageSystem.domain.*;
//import org.csu.personalManageSystem.persistence.ItemMapper;
//import org.csu.personalManageSystem.service.*;
//import org.junit.jupiter.api.Test;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@SpringBootTest
//@MapperScan("org.csu.personalManageSystem.persistence")
//
//class personalManageSystemApplicationTests {
//
//    @Autowired
//    CatalogService service;
//
//    @Autowired
//    CartService cartService;
//
//    @Autowired
//    AccountService accountService;
//
//    @Autowired
//    OrderService orderService;
//
//    @Autowired
//    ItemMapper itemMapper;
//
//
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    void testProduct(){
//        List<Product> products=service.getProductListByCategory ("BIRDS");
//        System.out.println (products.size ());
//        Product product=service.getProduct ("AV-CB-01");
//        System.out.println (product.getCategoryId ());
//
//    }
//    @Test
////    void testCart(){
////        Account account=accountService.getAccount ("a");
////        Cart cart=cartService.getCart ("a");
////
////      //  cartService.removeCart (account);
////
////    }
//
//    @Test
//    void testOrder(){
//        Order order = orderService.getOrder(1033);
//        System.out.println(order.getUsername() + " " + order.getOrderDate() + " " + order.getBillCity());
//    }
//
//    @Test
//    void testGetOrder(){
//        List<Order> orderList = orderService.getOrdersByUsername("a");
//        System.out.println(orderList);
//    }
//
//    @Test
//    void testInventoryQuantity(){
//        Map<String, Object> param = new HashMap<String, Object> (2);
//        String itemId = "EST-4";
//        int increment = 2;
//        param.put("itemId", itemId);
//        param.put("increment", increment);
//        System.out.println (itemId+"id+incre"+increment);
//        System.out.println ("increment:"+increment);
//        itemMapper.updateInventoryQuantity(param);
//        System.out.println (itemMapper.getInventoryQuantity (itemId));
//    }
//    @Test
//    void testVcode() throws ClientException {
//        accountService.sendMsg("18956778818");
//    }
//
//}
package org.csu.personalManagementSystem;

import org.csu.personalManagementSystem.domain.Employee;
import org.csu.personalManagementSystem.domain.RespPageBean;
import org.csu.personalManagementSystem.domain.Salary;
import org.csu.personalManagementSystem.persistence.EmployeeLanguageMapper;
import org.csu.personalManagementSystem.service.EmployeeService;
import org.csu.personalManagementSystem.service.SalaryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

@SpringBootTest
class personalManageSystemApplicationTests{

    @Autowired
    private DataSource dataSource;
    @Autowired
    private SalaryService salaryService;
    @Test
    void contextLoads(){
        try{
            Connection connection = dataSource.getConnection();
            System.out.println("Text....."+connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void test(){
        Salary salary = new Salary();
        salary.setId("8211180510");
        salary.setBasicsalary(9000);
        salary.setInsurance(1000);
        salary.setAwardmoney(4000);
        salary.setFinedmoney(500);
        Integer i;
        i = salaryService.updateSalary(salary);
        System.out.println(i + "," + "........");
    }

}
