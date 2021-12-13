package com.p3solutions.archon_mongodb_persistence.controller;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class ResponseBean {
    private List data;
}
