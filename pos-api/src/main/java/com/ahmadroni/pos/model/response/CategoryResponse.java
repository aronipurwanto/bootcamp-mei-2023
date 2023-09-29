package com.ahmadroni.pos.model.response;

import com.ahmadroni.pos.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private Long id;
    private String code;
    private String name;

    public CategoryResponse(CategoryEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
