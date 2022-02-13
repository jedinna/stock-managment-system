package controllers.stock_managmnent;


public class ITEM {

    int ID,AMOUNT,PRICE;
    String NAME;



  /* public ITEM(int id, String name, int amount, int price) {
        this.ID = id;
        this.NAME = name;
        this.AMOUNT = amount;
        this.PRICE = price;
    }

   public ITEM(int id, double name, int amount, int price) {
   }*/
  public int getID() {
      return ID;
  }

    public int getAMOUNT() {
        return AMOUNT;
    }

    public int getPRICE() {
        return PRICE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setID(int ID){
        this.ID=ID;
    }
    public void setAMOUNT(int AMOUNT){
        this.AMOUNT=AMOUNT;
    }
    public void setPRICE(int PRICE){
        this.PRICE=PRICE;
    }

    public ITEM(int ID, int AMOUNT, int PRICE, String NAME) {
        this.ID = ID;
        this.AMOUNT = AMOUNT;
        this.PRICE = PRICE;
        this.NAME = NAME;
    }

    public void setNAME(String NAME){
        this.NAME=NAME;
    }



}

