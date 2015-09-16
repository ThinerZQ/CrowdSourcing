package com.zhengshouzi.myweb.tools;

import com.zhengshouzi.myweb.entity.DescriptionEntity;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ǿ on 2015/9/15.
 */
public class ArrayToDescriptionCollectionConverter implements Converter<String[], Collection<DescriptionEntity>> {
    @Override
    public Collection<DescriptionEntity> convert(String[] strings) {
        Collection<DescriptionEntity> descriptionEntities = null;


        System.out.println("convert");

        if (strings == null) {
            return null;
        } else {
            descriptionEntities = new ArrayList<>();
            for (int i = 0; i < strings.length; i++) {
                DescriptionEntity descriptionEntity = new DescriptionEntity();
                descriptionEntity.setDescription(strings[i]);
                descriptionEntities.add(descriptionEntity);
            }
            return descriptionEntities;


        }

    }
}
