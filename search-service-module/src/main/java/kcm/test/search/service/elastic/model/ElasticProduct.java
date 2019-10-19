package kcm.test.search.service.elastic.model;

import kcm.test.search.service.core.model.Product;

public class ElasticProduct implements Product {

    private String id;

    private String name;

    //private List<String> categories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }*/

    @Override
    public String toString() {
        return "ElasticProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
