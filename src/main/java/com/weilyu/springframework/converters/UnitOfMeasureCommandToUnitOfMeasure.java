package com.weilyu.springframework.converters;

import com.weilyu.springframework.commands.UnitOfMeasureCommand;
import com.weilyu.springframework.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized  //Spring does not guarantee thread safety. using lombok keyword @Synchronized will ensure thread safety and allow multi-threading
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        if (source == null) {
            return null;  //null-safe or nullable
        }

        final UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(source.getId());
        uom.setDescription(source.getDescription());
        return uom;
    }
}
