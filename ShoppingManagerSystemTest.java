package study.month07.day16.homework.extension;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @author shkstart
 * @create 2021-07-16-1:22 PM
 */
/*
    购物管理系统
 */

//管理员
class Admin{

    //管理员用户名和密码
    private String adminName = "ALin";
    private String adminPassword = "ALin";

    public Admin() {

    }

    public Admin(String adminName, String adminPassword) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    //获取管理员个人信息
    @Override
    public String toString() {
        return "Admin{" +
                "adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
}

//客户类
class Customer{

    Scanner sc = new Scanner(System.in);

    //客户信息
    private String customerBirth;
    private int customer_ID;
    private int customerIntegral;
    //private boolean isVIP;

    //用于存储客户信息
    ArrayList<Integer> customer_ID_Count = new ArrayList<>();
    ArrayList<Integer> customer_Integral_Count = new ArrayList<>();
    ArrayList<String> customer_Birth_Count = new ArrayList<>();

    //写入默认已存在的客户信息
    public void existingCustomerInformationByDefault(){

        //录入客户会员号
        customer_ID_Count.add(1111);
        customer_ID_Count.add(2222);
        customer_ID_Count.add(3333);
        customer_ID_Count.add(4444);
        customer_ID_Count.add(5555);

        //录入客户生日
        customer_Birth_Count.add("08/05");
        customer_Birth_Count.add("07/13");
        customer_Birth_Count.add("06/26");
        customer_Birth_Count.add("04/08");
        customer_Birth_Count.add("08/16");

        //录入客户积分
        customer_Integral_Count.add(2000);
        customer_Integral_Count.add(4000);
        customer_Integral_Count.add(5000);
        customer_Integral_Count.add(2200);
        customer_Integral_Count.add(1000);


    }

    public Customer() {
    }

    public Customer(String customerBirth, int customer_ID, int customerIntegral) {
        this.customerBirth = customerBirth;
        this.customer_ID = customer_ID;
        this.customerIntegral = customerIntegral;
    }

    public String getCustomerBirth() {
        return customerBirth;
    }

    public void setCustomerBirth(String customerBirth) {
        this.customerBirth = customerBirth;
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public int getCustomerIntegral() {
        return customerIntegral;
    }

    public void setCustomerIntegral(int customerIntegral) {
        this.customerIntegral = customerIntegral;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerBirth='" + customerBirth + '\'' +
                ", customer_ID=" + customer_ID +
                ", customerIntegral=" + customerIntegral +
                '}';
    }


    //客户信息管理
    public void getInformationManager() {

        boolean flag = true;

        //键盘输入序号
        String keyBoardInputNumber = "";
        try {
            //调用存储数据
            this.existingCustomerInformationByDefault();
            while (flag) {
                String  inCustomerInformationDirect = ShoppingManagerSystemTest.pageDirectory("双鼷购物管理系统","客户信息管理");
                System.out.println(inCustomerInformationDirect);
                ShoppingManagerSystemTest.laceStar();
                System.out.println("\t\t\t\t\t1. 显 示 所 有 客 户 信 息");
                ShoppingManagerSystemTest.laceMid();
                System.out.println("\t\t\t\t\t2. 添 加 客 户 信 息 " ) ;
                ShoppingManagerSystemTest.laceMid();
                System.out.println("\t\t\t\t\t3. 修 改 客 户 信 息 " ) ;
                ShoppingManagerSystemTest.laceMid();
                System.out.println("\t\t\t\t\t4. 查 询 客 户 信 息 " ) ;
                ShoppingManagerSystemTest.laceMid();
                System.out.println("\t\t\t\t\t5. 删  客 户 信 息 " ) ;
                ShoppingManagerSystemTest.laceBottom();
                System.out.print("或者按'n'返回上一级菜单:");
                keyBoardInputNumber = sc.next();

                //逻辑判断键盘输入的序号
                if ("1".equals(keyBoardInputNumber)){
                    System.out.println("正在为您显示所有客户信息....");
                    this.showAllCustomerInformation();
                } else if ("2".equals(keyBoardInputNumber)){
                    System.out.println("正在跳转添加页面....");
                    this.addCustomerInformation();
                } else if ("3".equals(keyBoardInputNumber)){
                    System.out.println("正在跳转修改页面....");
                    this.alterCustomerInformation();
                } else if ("4".equals(keyBoardInputNumber)){
                    System.out.println("正在跳转查询页面....");
                    this.queryCustomerInformation();
                } else if ("5".equals(keyBoardInputNumber)){
                    System.out.println("正在跳转删除页面....");
                    this.deleteCustomerInformation();
                } else if ("n".equals(keyBoardInputNumber)){
                    System.out.println("正在返回上一页");
                    break;
                } else {
                    System.out.println("您输入的序号有误! 请重新输入.");
                }


            }
        } catch (InputMismatchException e) {
            System.out.println("您输入的序号有误!请重新输入");
            getInformationManager();
        }
    }

    //1.1-1.1客户信息管理的序号1.显示所有的客户信息
    public void showAllCustomerInformation(){
        String showDire = ShoppingManagerSystemTest.pageDirectory("双鼷购物管理系统", ShoppingManagerSystemTest.pageDirectory("客户信息管理", "显示所有的客户信息"));
        System.out.println(showDire);
        Scanner sc = new Scanner(System.in);
        String insertInput;

        while(true){
            System.out.println("\t会员号\t\t\t生日\t\t\t\t积分");
            System.out.println("-----------|--------------------|-----------------");

            // System.out.println(customer_ID_Count.size());
            for (int i = 0; i < customer_ID_Count.size(); i++) {

                System.out.println("\t" + customer_ID_Count.get(i) + "\t\t\t" + customer_Birth_Count.get(i) + "\t\t\t" + customer_Integral_Count.get(i));
            }

            System.out.print("请按'n'返回上一级菜单:");
            insertInput = sc.next();
            try {
                if ("n".equals(insertInput)){
                    System.out.println("正在返回....");
                    Thread.sleep(500);
                    break;
                } else {
                    System.out.println("您输入有误,正在为您返回上一级菜单");
                    Thread.sleep(500);
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    //1.1-1.2客户信息管理的序号2.添加客户信息
    public void addCustomerInformation(){

        String addInput = "";
        String backInput = "";
        String  inCustomerInformationDirect = ShoppingManagerSystemTest.pageDirectory("双鼷购物管理系统",ShoppingManagerSystemTest.pageDirectory("客户信息管理","添加客户信息"));
        System.out.println(inCustomerInformationDirect);
        ShoppingManagerSystemTest.laceMid();
        while (true) {
            System.out.print("请输入您要添加的客户的会员号(<四位整数>): ");
            this.customer_ID_Count.add(sc.nextInt());
            System.out.print("请输入会员生日(月/日<用两位表示>):");
            this.customer_Birth_Count.add(sc.next());
            System.out.print("请输入积分: ");
            this.customer_Integral_Count.add(sc.nextInt());
            System.out.println("新会员添加成功!");
            System.out.println("是否继续添加会员?(y/n)");
            addInput = sc.next();
            if ("n".equals(addInput)){
                System.out.print("请输入'n'返回上一级菜单: ");
                backInput = sc.next();
                if ("n".equals(backInput)){
                    break;
                }
            }
            ShoppingManagerSystemTest.laceMid();


        }

    }

    //1.1-1.3客户信息管理的序号3.修改客户信息
    public void alterCustomerInformation(){
        int alInput = 0;
        String  alCustomerInformationDirect = ShoppingManagerSystemTest.pageDirectory("双鼷购物管理系统",ShoppingManagerSystemTest.pageDirectory("客户信息管理","修改客户信息"));
        System.out.println(alCustomerInformationDirect);
        int i = 0;
        while (true) {

            System.out.print("请输入您要修改的客户会员名: ");
            alInput = sc.nextInt();
            if (alInput == customer_ID_Count.get(i)){
                System.out.println("\t会员号\t\t\t生日\t\t\t\t积分");
                System.out.println("-----------|--------------------|-----------------");
                System.out.println("\t" + customer_ID_Count.get(i) + "\t\t\t" + customer_Birth_Count.get(i) + "\t\t\t" + customer_Integral_Count.get(i));
                System.out.println("\t\t\t1. 修 改 会 员 积 分 ");
                System.out.println("\t\t\t2. 修 改 会 员 生 日");
                System.out.print("请输入序号: ");
                int num = sc.nextInt();
                if (num == 1){
                    System.out.println("请输入您要修改的积分数: ");
                    this.customer_Integral_Count.add(i,sc.nextInt());
                    System.out.println("会员积分已经修改!");
                    System.out.println("是否修改其他属性(y/n)?");
                    String tNP = sc.next();
                    if ("n".equals(tNP)){
                        System.out.print("请按'n'返回上一级菜单");
                        String n = sc.next();
                        if ("n".equals(n)){
                            System.out.println("正在为您跳转");
                            break;
                        }
                    } else if ("y".equals(tNP)){
                        System.out.println("正在为您跳转");
                        continue;
                    }
                } else if (num == 2){
                    System.out.print("请输入您要修改的生日日期: ");
                    this.customer_Birth_Count.add(i,sc.next());
                    System.out.println("是否修改其他属性(y/n)?");
                    String tNB = sc.next();
                    if ("n".equals(tNB)){
                        System.out.print("请按'n'返回上一级菜单");
                        String n = sc.next();
                        if ("n".equals(n)){

                            break;
                        }
                    } else if ("y".equals(tNB)){

                        continue;
                    }
                }

            } else if (alInput != customer_ID_Count.get(i) && i > customer_ID_Count.size()) {
                System.out.println("\t会员号\t\t\t生日\t\t\t\t积分");
                System.out.println("-----------|--------------------|-----------------");
                System.out.println("抱歉,没有查询到的会员!");
                ShoppingManagerSystemTest.laceMid();


                System.out.print("是否继续?(y/n)");
                String tN = sc.next();
                if ("n".equals(tN)){

                    System.out.print("请按'n'返回上一级菜单");
                    String n = sc.next();
                    if ("n".equals(n)){
                        System.out.println("正在为您跳转");
                        break;
                    }
                } else if ("y".equals(tN)){
                    continue;
                }

            }
            System.out.println("请再次尝试!");
            i++;


        }

    }

    //1.1-1.4客户信息管理的序号4.查询客户信息
    public void queryCustomerInformation(){

        int checkID = 0;
        String ansCon = "";
        this.existingCustomerInformationByDefault();
        while (true){
            System.out.print("请输入您要查询的会员的会员号:");
            checkID = sc.nextInt();
            for (int i = 0; i < customer_ID_Count.size(); i++) {
                if (checkID == customer_ID_Count.get(i)){
                    System.out.println("\t会员号\t\t\t生日\t\t\t\t积分");
                    System.out.println("-----------|--------------------|-----------------");
                    System.out.println("\t" + customer_ID_Count.get(i) + "\t\t\t" + customer_Birth_Count.get(i) + "\t\t\t" + customer_Integral_Count.get(i));
                    break;
                }
            }
            System.out.print("您要继续查吗?(y/n)");
            ansCon = sc.next();
            if ("y".equals(ansCon)){
                continue;
            } else if ("n".equals(ansCon)){
                String n = "";
                System.out.print("请输入'n'返回上一级菜单");
                n = sc.next();
                if ("n".equals(n)){
                    break;
                }
            }
        }
    }

    //1.1-1.5客户信息管理的序号5.删除客户信息
    public void deleteCustomerInformation(){

    }

}

//商品类
class commodity{

    Scanner sc = new Scanner(System.in);
    Customer customer = new Customer();

    //存储商品名称
    private ArrayList<String> commodityName = new ArrayList<>();

    //存储商品编号
    private ArrayList<Integer> commodity_ID = new ArrayList<>();
    //存储商品价格
    private ArrayList<Double> commodityPrice = new ArrayList<>();
    //存储商品数量(商品id,商品数量)
    private HashMap<Integer,Integer> commodityQuantity = new HashMap<>();

    //商品总价格
    private HashMap<Integer,Double> commodityCountPrice = new HashMap<>();

    //获取每个商品购买数量的总价格
    public HashMap<Integer, Double> getCommodityCountPrice() {


        return commodityCountPrice;
    }

    public void setCommodityCountPrice(HashMap<Integer, Double> commodityCountPrice) {

        this.commodityCountPrice = commodityCountPrice;
    }
    //原始数据

    //会员折扣
    private double discount = 0.85;

    //获取折扣
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public commodity() {
    }

    public commodity(ArrayList<String> commodityName, ArrayList<Integer> commodity_ID, ArrayList<Double> commodityPrice, HashMap<Integer,Integer> commodityQuantity) {
        this.commodityName = commodityName;
        this.commodity_ID = commodity_ID;
        this.commodityPrice = commodityPrice;
        this.commodityQuantity = commodityQuantity;
    }


    public void setCommodityName(ArrayList<String> commodityName) {

        this.commodityName = commodityName;

    }

    //获取每个商品名称
    public ArrayList<String> getCommodityName() {

        return commodityName;
    }

    public void setCommodity_ID(ArrayList<Integer> commodity_ID) {

        this.commodity_ID = commodity_ID;
    }
    //获取商品编号
    public ArrayList<Integer> getCommodity_ID() {

        return commodity_ID;
    }

    public void setCommodityPrice(ArrayList<Double> commodityPrice) {

        this.commodityPrice = commodityPrice;
    }
    //获取每个商品的单价
    public ArrayList<Double> getCommodityPrice() {

        return commodityPrice;
    }


    //获取每个商品的数量
    public HashMap<Integer,Integer> getCommodityQuantity() {

        return commodityQuantity;
    }

    public void setCommodityQuantity(HashMap<Integer,Integer> commodityQuantity) {

        this.commodityQuantity = commodityQuantity;
    }

    @Override
    public String toString() {
        return "commodity{" +
                "commodityName=" + commodityName +
                ", commodity_ID=" + commodity_ID +
                ", commodityPrice=" + commodityPrice +
                ", commodityQuantity=" + commodityQuantity +
                '}';
    }

    //商品结算
    public void settlement(){



    }
}

//登录系统
class Login {
    Scanner sc = new Scanner(System.in);
    Admin admin = new Admin();
    Customer customer = new Customer();
    commodity commodity = new commodity();

    //1.登录系统
    public void login(){
        boolean flag = true;
        //获取管理员的用户名和密码
        String adminName = admin.getAdminName();
        String adminPassword = admin.getAdminPassword();

        //设置当前输入的用户密码
        String currentName = "";
        String currentPassword = "";

        //管理员用户名和密码输入视图
        while (flag){
            System.out.print("请输入用户名: ");
            currentName = sc.next();
            System.out.print("请输入密码:");
            currentPassword = sc.next();

            if (currentName.equals(adminName) && currentPassword.equals(adminPassword)){
                landingPage();

                break;
            } else {
                System.out.println("用户名和密码不匹配,请重新输入: ");
            }
        }
    }

    //1.1着陆页
    public void landingPage() {

        boolean flag = true;
        //获取客户类信息
        int customer_ID ;
        String customerBirth ;
        int customerIntegral ;

        //当前页面输入的客户信息

        //当前页面的键盘输入序号
        int landingPageKeyBoardInputNumber = 0;

        try {
            while (flag){
                ShoppingManagerSystemTest.laceMid();
                ShoppingManagerSystemTest.laceTop();
                System.out.println("\t\t\t\t\t1. 客 户 信 息 管 理");
                ShoppingManagerSystemTest.laceMid();
                System.out.println("\t\t\t\t\t2. 购 物 结 算");
                ShoppingManagerSystemTest.laceMid();
                System.out.println("\t\t\t\t\t3. 真 情 回 馈");
                ShoppingManagerSystemTest.laceMid();
                System.out.println("\t\t\t\t\t4. 注 销");
                ShoppingManagerSystemTest.laceBottom();
                landingPageKeyBoardInputNumber = sc.nextInt();

                //逻辑判断键盘输入序号
                if (landingPageKeyBoardInputNumber == 1){
                    //客户信息管理
                    customer.getInformationManager();
                } else if (landingPageKeyBoardInputNumber == 2){

                    /**
                     * 购物结算
                     * CALL BY 1.1-2
                     */
                    this.shoppingSettlement();

                } else if (landingPageKeyBoardInputNumber == 3){

                    /**
                     * 真情回馈
                     * CALL BY 1.1-3
                     */
                    this.trueFeedback();

                } else if (landingPageKeyBoardInputNumber == 4){

                    /**
                     * 注销
                     * CALL BY 1.1-4
                     */
                    try {
                        this.cancellation();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                } else {
                    System.out.println("您输入的序号有误!请重新输入");
                }

            }
        } catch (InputMismatchException e) {
            System.out.println("您输入的序号有误!请重新输入");
            landingPage();
        }


    }

    //1.1-2着陆页的序号2.购物结算
    public void shoppingSettlement(){
        DecimalFormat df = new DecimalFormat("#.0");
        Scanner sc = new Scanner(System.in);

        int VIP_ID = 0;
        int commodity_ID = 0;
        int commodityQuantity = 0;
        //所有商品总和价格包括折扣后
        double sumCommodityPrice = 0;

        //实际付款
        double actualCost = 0;
        String ans = "";
        //设置商品名称
        commodity.getCommodityName().add("Adidas运动鞋");
        commodity.getCommodityName().add("Kappa网球裙");
        commodity.getCommodityName().add("网球拍");
        commodity.getCommodityName().add("AdidasT恤");
        commodity.getCommodityName().add("Nike运动鞋");
        commodity.getCommodityName().add("Kappa网球");
        commodity.getCommodityName().add("KappaT恤");

        //设置商品ID
        for (int i = 0; i < 7; i++) {
            commodity.getCommodity_ID().add(i + 1);
        }

        //设置商品价格
        commodity.getCommodityPrice().add(880.0);
        commodity.getCommodityPrice().add(200.0);
        commodity.getCommodityPrice().add(365.0);
        commodity.getCommodityPrice().add(399.9);
        commodity.getCommodityPrice().add(231.5);
        commodity.getCommodityPrice().add(79.0);
        commodity.getCommodityPrice().add(431.0);

        //设置每个的商品数量
        for (int i = 0; i < commodity.getCommodity_ID().size(); i++) {
            commodity.getCommodityQuantity().put(i,0);
        }


        //获取客户VIP号
        customer.existingCustomerInformationByDefault();
        //System.out.println(customer.customer_ID_Count);
        //System.out.println("商品id数量: " + commodity.getCommodity_ID().size());

        while (true) {
            String shopSettlementDirect = ShoppingManagerSystemTest.pageDirectory("双鼷购物管理系统","购物清算");
            System.out.println(shopSettlementDirect);
            System.out.println("************************");
            System.out.println("请选择购买的商品编号: ");
            for (int i = 0; i < commodity.getCommodityPrice().size(); i++) {
                System.out.println(commodity.getCommodity_ID().get(i) + ": " + commodity.getCommodityName().get(i));
            }
            System.out.print("请输入会员号: ");
            VIP_ID = sc.nextInt();
            //键盘输入的会员与存储的会员号进行判断,找到后继续结算
            //System.out.println("0: " + customer.customer_ID_Count.get(0));
            //System.out.println("4: " + customer.customer_ID_Count.get(4));
            //System.out.println("5: " + customer.customer_ID_Count.get(5));
            for (int i = 0; i < customer.customer_ID_Count.size(); i++) {
                //System.out.println(i + ": " + customer.customer_ID_Count.get(i));
                 if (VIP_ID ==  customer.customer_ID_Count.get(i)){

                     VIP_ID = customer.customer_ID_Count.get(i);
                    break;
                } else if (VIP_ID != customer.customer_ID_Count.get(0) && VIP_ID != customer.customer_ID_Count.get(1) && VIP_ID != customer.customer_ID_Count.get(2) &&
                         VIP_ID != customer.customer_ID_Count.get(3) && VIP_ID != customer.customer_ID_Count.get(4)){
                     System.out.println("您输入的会员号不存在!请重新输入: ");
                     shoppingSettlement();
                 }

            }
            System.out.print("请输入商品编号: ");
            commodity_ID = sc.nextInt();
            //键盘输入的商品编号与存储的商品编号进行判断,找到后继续结算
            for (int i = 0; i < commodity.getCommodity_ID().size(); i++) {
                if ((commodity_ID - 1) == commodity.getCommodity_ID().get(i)){
                    break;
                }
            }
            System.out.println("请输入数目: ");
            commodityQuantity = sc.nextInt();
            for (int i = 0; i < commodity.getCommodity_ID().size(); i++) {
                if (commodity.getCommodity_ID().get(i) == commodity_ID ){
                    commodity.getCommodityQuantity().put(i,commodityQuantity);
                    break;
                }
            }
            //System.out.println("输入的商品id: " + commodity_ID);
            //System.out.println("存储在集合里的第一位商品id: " + commodity.getCommodity_ID().get(0));
            //System.out.println("存储在集合里的第一位商品的数量: " + commodity.getCommodityQuantity().get(0));
            //设置每个商品购买的总价格
            /*for (int i = 0; i < commodity.getCommodity_ID().size() ;i++) {
                commodity.setCommodityCountPrice();
            }*/
            for (int i = 0; i < commodity.getCommodity_ID().size(); i++) {
                /*commodity.getCommodityCountPrice().put(commodity.getCommodity_ID().get(i),
                        commodity.getCommodityQuantity().get(i) * commodity.getCommodityPrice().get(i) * commodity.getDiscount());*/
                if (commodity.getCommodity_ID().get(i) == commodity_ID){
                    commodity.getCommodityCountPrice().put(i,
                            commodity.getCommodityQuantity().get(i) * commodity.getCommodityPrice().get(i) * commodity.getDiscount());
                }
            }
            //System.out.println("各商品的数量: " + commodity.getCommodityQuantity());
            //System.out.println("各商品的总价 " + commodity.getCommodityCountPrice());
            System.out.println("是否继续?(y/n)");
            ans = sc.next();
            if ("n".equals(ans)){
                System.out.println("************************");
                ShoppingManagerSystemTest.laceMid();
                System.out.println("******************************消费清单******************************");
                System.out.println("物品" + "\t\t\t\t单价" + "\t\t\t\t个数" + "\t\t\t\t金额");
                for (int i = 0; i < commodity.getCommodity_ID().size(); i++) {
                    if (commodity.getCommodityQuantity().get(i) != 0){
                        System.out.println(commodity.getCommodityName().get(i) +
                                "\t\t" + commodity.getCommodityPrice().get(i) +
                                "\t\t\t" + commodity.getCommodityQuantity().get(i) +
                                "\t\t\t" + (commodity.getCommodityQuantity().get(i) * commodity.getCommodityPrice().get(i)));
                    }
                }
                System.out.println();
                System.out.println("折扣: " + commodity.getDiscount());
                for (int i = 0; i < commodity.getCommodity_ID().size(); i++) {
                    if (commodity.getCommodityQuantity().get(i) != 0){
                        sumCommodityPrice += commodity.getCommodityCountPrice().get(i);
                    }
                }
                System.out.println("金额总计: " + sumCommodityPrice);
                System.out.print("实际交费: ");
                actualCost = sc.nextInt();
                if (actualCost < sumCommodityPrice){
                    System.out.println("您的金额不足以支付商品,请重新选择商品!");
                    break;
                }
                System.out.println("找钱: " + df.format((actualCost - sumCommodityPrice)));
                //用了多少钱 = 获得多少积分
                System.out.println("本次购物获得的积分是: " + sumCommodityPrice);
                for (int i = 0; i < customer.customer_ID_Count.size(); i++) {
                    //System.out.println(i + ": " + customer.customer_ID_Count.get(i));
                    if (VIP_ID ==  customer.customer_ID_Count.get(i)){
                         customer.customer_Integral_Count.add(i,(int)(sumCommodityPrice + customer.customer_Integral_Count.get(i)));
                        System.out.println( customer.customer_ID_Count.get(i) + "会员号的积分增加后是: " + customer.customer_Integral_Count.get(i));
                        break;
                    }
                }
                //customer.customer_Integral_Count.get()
            }  else if ("y".equals(ans)){
                System.out.println("正在调整...");
            } else {
                System.out.println("您输入有误!正在为您跳转继续购买....");
            }


            System.out.println("************************");
            ShoppingManagerSystemTest.laceMid();
            System.out.println("返回上一级菜单,请按'n'");
            String n = "";
            n = sc.next();
            if ("n".equals(n)){
                break;
            }
        }


    }

    //1.1-2.1


    //1.1-3着陆页的序号3.真情回馈
    public void trueFeedback(){

        String input = "";
        String insideInput = "";
        //获取会员们的积分信息
        customer.existingCustomerInformationByDefault();

        String showDir = ShoppingManagerSystemTest.pageDirectory("双鼷购物管理系统","真情回馈");
        System.out.println(showDir);
        while (true) {
            ShoppingManagerSystemTest.laceStar();
            System.out.println("\t\t\t1.幸 运 大 放 送");
            ShoppingManagerSystemTest.laceMid();
            System.out.println("\t\t\t2.幸 运 抽 奖");
            ShoppingManagerSystemTest.laceMid();
            System.out.println("\t\t\t3.生 日 问 候");
            ShoppingManagerSystemTest.laceStar();

            System.out.print("请选择,输入数字或者输入'n'返回上一级菜单:");
            input = sc.next();
            if ("1".equals(input)){
                //幸运大放送
                ShoppingManagerSystemTest.pageDirectory("双鼷购物管理系统",ShoppingManagerSystemTest.pageDirectory("真情回馈","幸运大放送"));
                //判断谁的积分最大
                int max2 = customer.customer_Integral_Count.get(0) > customer.customer_Integral_Count.get(1) ? customer.customer_Integral_Count.get(0) : customer.customer_Integral_Count.get(1);
                int max3 = max2 > customer.customer_Integral_Count.get(2) ? max2 : customer.customer_Integral_Count.get(2);
                int max4 = max3 >  customer.customer_Integral_Count.get(3) ? max3 : customer.customer_Integral_Count.get(3);
                int max5 = max4 > customer.customer_Integral_Count.get(4) ? max4 :  customer.customer_Integral_Count.get(4);
                System.out.println("积分最高为: " + max5  +",其拥有者: " + customer.customer_ID_Count.get(2) + "\t\t" + customer.customer_Birth_Count.get(2));
                ShoppingManagerSystemTest.laceMid();
                System.out.println("恭喜!获得礼品:  一个价值￥12000.0的苹果笔记本电脑");
                System.out.print("请输入'n'返回上一级菜单:");
                insideInput = sc.next();
                if ("n".equals(insideInput)){
                    continue;
                }
            } else if ("2".equals(input)){
                //幸运抽奖
                ShoppingManagerSystemTest.pageDirectory("双鼷购物管理系统",ShoppingManagerSystemTest.pageDirectory("真情回馈","幸运抽奖"));

            } else if ("3".equals(input)){
                //生日问候
                ShoppingManagerSystemTest.pageDirectory("双鼷购物管理系统",ShoppingManagerSystemTest.pageDirectory("真情回馈","生日问候"));
                System.out.print("请输入今天的日期(月/日<用两位表示>): ");
                insideInput = sc.next();
                for (int i = 0; i < customer.customer_Birth_Count.size() ; i++) {
                    if (insideInput.equals(customer.customer_Birth_Count.get(i))){
                        System.out.println(customer.customer_ID_Count.get(i) + "会员,祝您今天生日快乐!");
                        System.out.println(customer.customer_Birth_Count.get(i));
                        System.out.println("恭喜您获得MP3一个!");

                        System.out.print("请输入'n'返回上一级菜单:");
                        String insideITInput = sc.next();
                        if ("n".equals(insideITInput)){
                            break;
                        }
                    } else if(!insideInput.equals(customer.customer_Birth_Count.get(0)) &&
                            !insideInput.equals(customer.customer_Birth_Count.get(1)) &&
                            !insideInput.equals(customer.customer_Birth_Count.get(2)) &&
                            !insideInput.equals(customer.customer_Birth_Count.get(3)) &&
                            !insideInput.equals(customer.customer_Birth_Count.get(4))){
                        System.out.println("今天没有过生日的会员!");
                        System.out.print("请输入'n'返回上一级菜单:");
                        String insideIBInput = sc.next();
                        if ("n".equals(insideIBInput)){
                            break;
                        }
                    }
                }
            } else if ("n".equals(input)){
                break;
            }
        }


    }

    //1.1-4着陆页的序号4.注销
    public void cancellation() throws InterruptedException {
        System.out.println("正在注销....");
        Thread.sleep(500);
    }

    //2.更改管理员密码
    public void alterAdminPassword() {
        //键盘输入管理员用户名和密码
        String adminName = "";
        String adminPassword = "";
        while (true){

            System.out.print("请输入用户名: ");
            adminName = sc.next();
            System.out.print("请输入密码: ");
            adminPassword = sc.next();
            if (adminName.equals(admin.getAdminName()) && adminPassword.equals(admin.getAdminPassword())){
                System.out.print("请输入新的用户名: ");
                admin.setAdminName(sc.next());
                System.out.print("请输入新密码: ");
                admin.setAdminPassword(sc.next());
                System.out.println("修改成功!");
                System.out.println("用户名: " + admin.getAdminName());
                System.out.println("密码: " + admin.getAdminPassword());
                break;
            } else {
                System.out.println("用户名或密码输入错误!请重新输入");
            }
        }
    }

    //3.退出
    public void endLogin(){
        System.out.println("感谢您的使用!");
    }
    public void show(){
       boolean flag =  true;
       int loginOperation = 0;
        try {
            while (flag){
                ShoppingManagerSystemTest.laceMid();
                System.out.println("\t\t\t\t\t欢迎使用双鼷购物管理系统");
                ShoppingManagerSystemTest.laceMid();
                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
                System.out.println("\t\t\t\t\t1.登 录 系 统");
                ShoppingManagerSystemTest.laceMid();
                System.out.println("\t\t\t\t\t2.更 改 管 理 员 密 码");
                ShoppingManagerSystemTest.laceMid();
                System.out.println("\t\t\t\t\t3.退 出");
                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
                ShoppingManagerSystemTest.laceMid();
                System.out.print("请选择序号,进行操作: ");
                loginOperation = sc.nextInt();
                if (loginOperation == 1){
                    this.login();
                } else if (loginOperation == 2){
                    this.alterAdminPassword();
                } else if(loginOperation == 3){
                    this.endLogin();
                    flag = false;
                } else {
                    System.out.println("您输入的序号有误!请重新输入 ");
                }

            }
        } catch (InputMismatchException e) {
            System.out.println("您输入的序号有误!请重新输入");
            show();
        }
    }



}


public class ShoppingManagerSystemTest {



    //花边方法
    public static void laceTop(){
        System.out.println("\t\t\t\t\t欢迎使用双鼷购物管理系统");
        laceMid();
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
        laceMid();
    }
    public static void laceBottom(){
        laceMid();
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
        laceMid();
        System.out.println("请选择序号,进行操作: ");
    }
    public static void laceMid(){System.out.println("\n");}
    public static void laceStar(){
        laceMid();
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
        laceMid();
    }

    //页面目录
    public static String pageDirectory(String preDirect,String currentDirect){
        return preDirect + " > " + currentDirect;
    }


    //创建测试
    public static void main(String[] args) {

        /*commodity commodity = new commodity();
        System.out.println(commodity.getCommodity_ID());
        System.out.println(commodity.getCommodityName());
        System.out.println(commodity.getCommodityPrice());*/
        Login login = new Login();
        login.show();

    }

}
