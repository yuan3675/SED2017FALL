import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Online_Shopping_Site {
    private Map<Integer, Order> orderList = new HashMap<>();

    public void createOrder(ArrayList<Company> a, int orderNum, String goodsType, String orderData) {
        Order o = new Order();
        boolean check = o.checkCompany(a, goodsType);
        if (!check) {
            System.out.println("no company can fulfill such order!");
        }
        else {
            o.setOrderNum(orderNum);
            o.setGoodsType(goodsType);
            o.setOrderData(orderData);
            orderList.put(orderNum, o);
            System.out.println("order " + orderNum + ": " + goodsType + " order created in " + o.getOrderformat() + " format");
        }
    }

    public  void orderTransmit(ArrayList<Company> a,int num) {
        if (orderList.get(num) != null) {
            Order o = orderList.get(num);
            o.transmit(a, num);
        }
        else {
            System.out.println("no such order!");
        }
    }
}
