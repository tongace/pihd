package com.dxc.toyota.application.pihd.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.springframework.web.servlet.View;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SystemParameterModel {
    @JsonView(View.class)
    private String id;
    @JsonView(View.class)
    private String category;
    @JsonView(View.class)
    private String cd;
    @JsonView(View.class)
    private String value;
    @JsonView(View.class)
    private String remark;
    @JsonView(View.class)
    private String status;
    @JsonView(View.class)
    private String createdBy;
    @JsonView(View.class)
    private Date createdDt;
    @JsonView(View.class)
    private String modifiedBy;
    @JsonView(View.class)
    private Date modifiedDt;
}
