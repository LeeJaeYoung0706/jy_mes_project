package com.mes_jyproject.refactoring.facade_example.salesOrder.dto;

import jakarta.validation.Valid;
import lombok.Data;


import java.util.List;

@Data
public class MtDeleteListDto {

    @Valid
    private List<MtDeleteDto> deleteListData;
}
