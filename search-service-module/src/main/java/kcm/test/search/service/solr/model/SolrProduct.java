package kcm.test.search.service.solr.model;

import kcm.test.search.service.core.model.Product;
import org.springframework.data.solr.core.mapping.SolrDocument;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;

@SolrDocument(collection = "Product")
public class SolrProduct implements Product {

    @Id
    @Indexed
    private String id;

    @Indexed(name = "name", type = "string")
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
        return "SolrProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
