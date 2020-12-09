package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.PrivateMeow;
import pl.coderslab.repository.PrivateMeowRepository;

public class PrivateMeowConverter implements Converter<String, PrivateMeow> {

    @Autowired
    PrivateMeowRepository privateMeowRepository;

    @Override
    public PrivateMeow convert(String s) {
        return privateMeowRepository.findOne(Long.parseLong(s));
    }
}
