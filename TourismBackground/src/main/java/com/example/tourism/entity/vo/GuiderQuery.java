package com.example.tourism.entity.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * com.example.tourism.entity.vo
 *
 * @author xzwnp
 * 2022/3/6
 * 14:05
 * Steps：
 */
@Getter
@Setter
public class GuiderQuery {
    private String name;
    private int title;
    private int minWorkYears;
    private int maxWorkYears;
}
