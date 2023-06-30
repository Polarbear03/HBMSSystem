package com.example.util.fomatter;

import com.example.model.entity.Admin;
import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Locale;

public class AdminFormatter implements Formatter<Admin> {
    @Override
    public Admin parse(String text, Locale locale) throws ParseException {
        Admin admin = null;
        if (StringUtils.hasText(text)) {
            String[] items = text.split(",");
        }
        return null;
    }

    @Override
    public String print(Admin object, Locale locale) {
        return null;
    }
}
