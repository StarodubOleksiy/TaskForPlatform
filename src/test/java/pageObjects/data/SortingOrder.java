package pageObjects.data;

public enum SortingOrder {

    Up("Up"),
    Down("Down");


    private final String order;

    private SortingOrder(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }



}
