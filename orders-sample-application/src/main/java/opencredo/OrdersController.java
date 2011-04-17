package opencredo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

@Controller
@RequestMapping("/wibble")
public class OrdersController {

    String location;

    String flag;

    OrderDAO orderDao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView defaultGet() {
        System.out.println("defaultGet");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("helloWorld");
        mav.addObject("command", new Order() );
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView defaultPost(Order order) {
        order.setCreationDate(new Date(System.currentTimeMillis()));
        order.setLocation(location);
        orderDao.insertOrder(order);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("helloWorld");
        mav.addObject("command", new Order());
        mav.addObject("location",location);
        mav.addObject("flag",flag);


        ArrayList orders = orderDao.getOrders();
        Collections.sort(orders);

        mav.addObject("orders", orders);
        return mav;
    }

    public OrderDAO getOrderDAO() {
        return orderDao;
    }

    public void setOrderDAO(OrderDAO orderDao) {
        this.orderDao = orderDao;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
