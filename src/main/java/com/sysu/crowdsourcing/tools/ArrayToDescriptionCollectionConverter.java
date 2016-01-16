package com.sysu.crowdsourcing.tools;

import com.sysu.crowdsourcing.entity.DescriptionEntity;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ǿ on 2015/9/15.
 */
public class ArrayToDescriptionCollectionConverter implements Converter<String, Set<DescriptionEntity>> {

    public Set<DescriptionEntity> convert(String strings) {
        Set<DescriptionEntity> descriptionEntities = new HashSet<DescriptionEntity>();


        System.out.println("convert Collection<DescriptionEntity> ");

        if (strings == null) {
            return null;
        } else {
            DescriptionEntity descriptionEntity = new DescriptionEntity();
            descriptionEntity.setDescription(strings);
            descriptionEntities.add(descriptionEntity);
        }
        return descriptionEntities;


    }
}
