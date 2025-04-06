package MultiThread1;

public class ProducerConsumerProblem {
    Store store;
    Producer pro;
    Consumer con;

    public ProducerConsumerProblem() {
        store = new Store();  
        pro = new Producer(store);
        con = new Consumer(store);
        pro.start();
        con.start();
    }

    public static void main(String args[]) {
        new ProducerConsumerProblem();
    }
}