import java.util.ArrayList;

public class Order {
    private int orderNum;
    private String goodsType;
    private String orderData;
    private String orderformat;

    public boolean checkCompany(ArrayList<Company> a, String type){
        for(int i = 0; i < a.size(); i ++) {
            Company c = a.get(i);
            if(type.equals(c.getCompanyType())){
                this.orderformat = c.getCategory();
                return true;
            }
        }
        return false;
    }

    public void transmit(ArrayList<Company> a, int num) {
        for (int i = 0; i < a.size(); i++) {
            Company c = a.get(i);
            if (this.goodsType.equals(c.getCompanyType())) {
                System.out.println(this.goodsType + " company receive order " + num + ":");
                if (c.getCategory().equals("CSV")) {
                    CSVFormatOrder co = new CSVFormatOrder();
                    co.createHeader();
                    co.addData(this.orderData);
                    co.createFooter();
                    co.display();
                }
                else if (c.getCategory().equals("XML")) {
                    XMLFormatOrder xo = new XMLFormatOrder();
                    xo.createHeader();
                    xo.addData(this.orderData);
                    xo.createFooter();
                    xo.display();
                }
                else {
                    CustomObjectOrder oo = new CustomObjectOrder();
                    oo.createHeader();
                    oo.addData(this.orderData);
                    oo.createFooter();
                    oo.display();
                }
            }
        }
    }

    public void setOrderNum(int n) {
        this.orderNum = n;
    }
    public void setGoodsType(String type) {
        this.goodsType = type;
    }
    public void setOrderData(String data){
        this.orderData = data;
    }

    public String getOrderformat() {
        return orderformat;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public String getOrderData() {
        return orderData;
    }
}
