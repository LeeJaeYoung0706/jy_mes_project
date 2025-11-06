package com.mes_jyproject.refactoring.facade_example.salesOrder.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SearchDtDto {

    @JsonProperty("SAUD_SAUM_IDX")
    String SAUD_SAUM_IDX;

}
