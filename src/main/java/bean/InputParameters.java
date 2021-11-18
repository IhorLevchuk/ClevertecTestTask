package bean;

import java.util.*;

public class InputParameters {
    private Map<Integer, Integer> params;
    private Integer cardNumber;
    private String cardFile;
    private String productFile;
    private String email;

    public InputParameters() {
        params = new HashMap<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addParam(Integer key, Integer value) {
        params.put(key, value);
    }

    public List<Integer> getIdProducts() {
        return new ArrayList<>(params.keySet());
    }

    public Map<Integer, Integer> getParams() {
        return params;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getProductFile() {
        return productFile;
    }

    public void setProductFile(String productFile) {
        this.productFile = productFile;
    }

    public String getCardFile() {
        return cardFile;
    }

    public void setCardFile(String cardFile) {
        this.cardFile = cardFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputParameters that = (InputParameters) o;
        return Objects.equals(params, that.params) && Objects.equals(cardNumber, that.cardNumber) && Objects.equals(cardFile, that.cardFile) && Objects.equals(productFile, that.productFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(params, cardNumber, cardFile, productFile);
    }

    @Override
    public String toString() {
        return "InputParameters{" +
                "params=" + params +
                ", cardNumber=" + cardNumber +
                ", cardFile='" + cardFile + '\'' +
                ", productFile='" + productFile + '\'' +
                '}';
    }
}
