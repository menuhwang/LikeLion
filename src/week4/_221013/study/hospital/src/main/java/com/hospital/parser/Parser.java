package com.hospital.parser;

public interface Parser<T> {
    T parse(String str);
}
