package pojo;

public class Products {

    private String product;
    private double dollarsPrice;
    private double poundSterlingPrice;
    private double euroPrice;

    public Products(String _product, double _dollarsPrice, double _poundSterlingPrice, double _euroPrice) {
        this.product = _product;
        this.dollarsPrice = _dollarsPrice;
        this.poundSterlingPrice = _poundSterlingPrice;
        this.euroPrice = _euroPrice;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getDollarsPrice() {
        return dollarsPrice;
    }

    public void setDollarsPrice(double dollarsPrice) {
        this.dollarsPrice = dollarsPrice;
    }

    public double getPoundSterlingPrice() {
        return poundSterlingPrice;
    }

    public void setPoundsSterlingPrice(double poundSterlingPrice) {
        this.poundSterlingPrice = poundSterlingPrice;
    }

    public double getEuroPrice() {
        return euroPrice;
    }

    public void setEuroPrice(double euroPrice) {
        this.euroPrice = euroPrice;
    }
}