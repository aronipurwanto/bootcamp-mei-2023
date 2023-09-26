package com.ahmadroni.pos.model.response;

import com.ahmadroni.pos.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String code;
    private String name;
    private Double price;
    private Double stock;
    private Long categoryId;
    private String categoryName;
    private Double unitOnOrder;
    private Boolean discontinued;

    public ProductResponse(ProductEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if(entity.getCategory() != null && entity.getCategory().getName() != null){
            this.categoryName = entity.getCategory().getName();
        }else {
            this.categoryName = "-";
        }
    }
}
