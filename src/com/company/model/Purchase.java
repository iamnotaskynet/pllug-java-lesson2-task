package com.company.model;


//Purchase is kind of transaction
//so it should be quite safe to use it
//It is study task, don't use it in real life
// for commercial, because it can trouble you
public class Purchase {
    //unique id must be for each purchase transaction
    private static int purhcaseIdCounting = 0;

    private int purhcaseId;

    private Person customer;
    private int customerId;

    private Person seller;
    private int sellerId;

    //Maybe we should have ID of goods/products/stuff
    //to be shure about what is selling/buying and count of it

    private String goodieName;
    private long goodiePrice; //long - to avoid problems with float/double in homework task
    private long goodieAmount;
    private long purchaseCommission; // 5 percentages
    private long purchaseTotalPrice; // with 5 percent of commission

    private Purchase() throws Exception {
        throw new Exception("CAN'T USE THIS METHOD, IT SHOULD BE WITH PARAMETERS ONLY");
    }

    public Purchase(Person customer,
                    int customerId,
                    Person seller,
                    int sellerId,
                    String goodieName,
                    long goodiePrice,
                    long goodieAmount
                    ) throws Exception {
        ++purhcaseIdCounting;
        this.purhcaseId = purhcaseIdCounting;

        if(customer.getUuId() == customerId) {
            this.customer = customer;
            this.customerId = customerId;
        } else {
            throw new Exception("NOT VALID CUSTOMER, SOMETHING VERY WRONG!");
        }

        if(seller.getUuId() == sellerId) {
            this.seller = seller;
            this.sellerId = sellerId;
        } else {
            throw new Exception("NOT VALID SELLER, SOMETHING VERY WRONG!");
        }

        this.goodieName = goodieName;
        this.goodiePrice = goodiePrice;
        this.goodieAmount = goodieAmount;
        double fivePercenteges = ((double) goodiePrice * goodieAmount ) / 20.0 ;
        //smartless downcasting for customer profit
        //because of this of type of downcasting
        //it does NOT return exactly a FIVE percentage
        //it return LESS
        this.purchaseCommission = (long) fivePercenteges;
        this.purchaseTotalPrice = this.purchaseCommission + goodiePrice * goodieAmount;

    }

    public int getPurhcaseId() {return this.purhcaseId;}
    public long getPurchaseTotalPrice() {return this.purchaseTotalPrice;}
    public long getPurchaseCommission() {return this.purchaseCommission;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append("\t ID: ");
        sb.append(this.purhcaseId);
        sb.append("\n\t CUSTOMER_ID: ");
        sb.append(this.customerId);
        sb.append("\n\t SELLER_ID: ");
        sb.append(this.sellerId);
        sb.append("\n\t GOODIE_NAME_&_COUNT: ");
        sb.append(this.goodieName);
        sb.append(" x ");
        sb.append(this.goodieAmount);
        sb.append("\n\t TOTAL_PRICE: ");
        sb.append(this.purchaseTotalPrice);
        sb.append("\n\t COMMISSION: ");
        sb.append(this.purchaseCommission);

        return sb.toString();
    }
}
