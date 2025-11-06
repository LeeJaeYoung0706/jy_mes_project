package com.mes_jyproject.refactoring.facade_example.salesOrder.dto;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class MtDeleteListDto {

    @Valid
    private List<MtDeleteDto> deleteListData;
}
