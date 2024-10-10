package com.jskno.mobile.lines.utils;

import com.jskno.mobile.lines.exception.MobileLineException;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollectors {

    public static <T> Collector<T, ?, T> toSingleton() {
        return Collectors.collectingAndThen(
            Collectors.toList(),
            list -> {
                if (list.size() != 1) {
                    throw new MobileLineException("There are more that one users with that login");
                }
                return list.getFirst();
            }
        );
    }

}
