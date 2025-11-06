package com.mes_jyproject.refactoring.facade_example.salesOrder.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lnk.doobo.util.ValidationGroups;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class MtDeleteDto {

    @JsonProperty("SAUM_IDX")
    @NotNull(groups = ValidationGroups.UpdateGroup.class, message = "해당 수주에 대한 정보가 없습니다. 관리자에게 문의하세요.")
    @Min(groups = ValidationGroups.UpdateGroup.class, value = 1, message = "해당 수주에 대한 정보가 없습니다. 관리자에게 문의하세요.")
    private Long SAUM_IDX;

    @JsonProperty("SAUM_SO_NBR")
    @NotBlank(groups = {ValidationGroups.UpdateGroup.class , ValidationGroups.CreateGroup.class }, message = "요청 수주번호가 올바르지 않습니다. 수주번호를 다시 입력해주세요.")
    private String SAUM_SO_NBR;

    private String name;

}
