package model.send.receive;

import model.others.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class CategoryInfo {
    private String Type;
    private String name;
    private ArrayList<String> specialProperties;
    private HashMap<String, String> productsNameId;
    private ArrayList<String> subCategories;
    private String mainCategory;

    public CategoryInfo(String name, ArrayList<String> properties) {
        this.name = name;
        this.specialProperties = properties;
        this.productsNameId = new HashMap<>();
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public void addProduct(Product product) {
        this.productsNameId.put(product.getName(), product.getId());
    }

    public void setSubCategories(ArrayList<String> subCategories) {
        this.subCategories = subCategories;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getSpecialProperties() {
        return specialProperties;
    }

    public HashMap<String, String> getProductsNameId() {
        return productsNameId;
    }

    public ArrayList<String> getSubCategories() {
        return subCategories;
    }

    public String getMainCategory() {
        return mainCategory;
    }
}
