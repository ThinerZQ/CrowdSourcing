package com.zhengshouzi.myweb.tools;

import com.zhengshouzi.myweb.entity.DescriptionEntity;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ǿ on 2015/9/15.
 */
public class ArrayToDescriptionCollectionConverter implements Converter<String, Set<DescriptionEntity>> {
    @Override
    public Set<DescriptionEntity> convert(String strings) {
        Set<DescriptionEntity> descriptionEntities = null;


        System.out.println("convert Collection<DescriptionEntity> ");

        if (strings == null) {
            return null;
        } else {
            descriptionEntities = new HashSet<>();
            DescriptionEntity descriptionEntity = new DescriptionEntity();
            descriptionEntity.setDescription(strings);
            descriptionEntities.add(descriptionEntity);
        }
        return descriptionEntities;


    }
}
