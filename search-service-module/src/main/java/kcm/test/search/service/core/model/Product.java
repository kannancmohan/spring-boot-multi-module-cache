package kcm.test.search.service.core.model;

import java.io.Serializable;

public interface Product extends Serializable {

    String getId();

    void setId(String id);

    String getName();

    void setName(String name);

}
