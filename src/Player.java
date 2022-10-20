public class Player {
    String name;
    int money = 1000;
    boolean getmoreturn = true;


    public void setName(String name) {

        this.name = name;
    }
    public  String getName(){
        return name;
    }

    public void setMoney (int money) {

        this.money = money;
    }
    public int getMoney() {
        return money;
    }

}
