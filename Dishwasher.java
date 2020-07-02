package ru;

public class Dishwasher {
    Dishwasher MyDW = new Dishwasher(30);


    public static void main(String[] args) {

        Dishwasher MyDW = new Dishwasher(30);
    }

    int capacity;

    int numberOfDish;

    Status state;

    /**
     * Constructor of the class Dishwasher
     * @param cnt maximum number of dishes
     * @return
     */
    public Dishwasher(int cnt){

        if(cnt>0){
            capacity = cnt;
            state = Status.READY;
            numberOfDish = 0;
        }else{
            throw new ArithmeticException("Capacity must be more than 0");
        }

    }

    /**
     * Puts one dish to Dishwasher
     * @param
     * @return numberOfDish current number of dishes in Dishwasher
     */
    public int putInOneDish(){
        if(state == Status.READY && numberOfDish < capacity){
            ++numberOfDish;
        }
        return numberOfDish;
    }

    /**
     * Gets out all dishes of Dishwasher
     * @param
     * @return
     */
    public void getDishes(){
        if(state == Status.STOPPED){
            numberOfDish = 0;
            state = Status.READY;
        }
    }

    /**
     * Starts Dishwasher
     * @param
     * @return
     */
    public void start() throws DishwasherIsBusyException{
        if(numberOfDish != 0 && state == Status.READY){
            state = Status.BUSY;
        } else{
            throw new DishwasherIsBusyException("Dishwasher can not be started! It is already busy");
        }
    }


    /**
     * Stops Dishwasher
     * @param
     * @return
     */
    public void stop(){
        if(state == Status.BUSY){
            state = Status.STOPPED;
        }
    }
}

