package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Meow;
import pl.coderslab.repository.MeowRepository;

public class MeowConverter implements Converter<String, Meow> {

    @Autowired
    MeowRepository meowRepository;

    @Override
    public Meow convert(String s) {
        return meowRepository.findOne(Long.parseLong(s)) ;
    }
}
