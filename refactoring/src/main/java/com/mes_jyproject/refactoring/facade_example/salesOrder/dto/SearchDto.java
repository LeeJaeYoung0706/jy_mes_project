package com.mes_jyproject.refactoring.facade_example.salesOrder.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.lnk.doobo.util.Criteria;
import com.lnk.doobo.util.TransUtils;
import lombok.Data;

import java.util.List;

@Data
public class SearchDto {

    @JsonProperty("SEARCH_SAUM_ORD_DATE_FROM")
    String SEARCH_SAUM_ORD_DATE_FROM;

    @JsonProperty("SEARCH_SAUM_ORD_DATE_TO")
    String SEARCH_SAUM_ORD_DATE_TO;

    @JsonProperty("SEARCH_SAUM_REG_DATE_FROM")
    String SEARCH_SAUM_REG_DATE_FROM;

    @JsonProperty("SEARCH_SAUM_REG_DATE_TO")
    String SEARCH_SAUM_REG_DATE_TO;

    @JsonProperty("SEARCH_SAUM_PROGS_CD_GR")
    String SEARCH_SAUM_PROGS_CD_GR;

    @JsonProperty("SEARCH_SAUM_CUST_CD")
    String SEARCH_SAUM_CUST_CD;

    @JsonProperty("SEARCH_SAUM_DEPT_CD")
    String SEARCH_SAUM_DEPT_CD;

    @JsonProperty("page")
    int page = 1;

    @JsonProperty("perPageNum")
    int perPageNum = 99999;

    List<String> SEARCH_SAUM_PROGS_CD_GR_LIST;

    Criteria cri = new Criteria();

    @JsonSetter("page")
    public void setPage(int page) {
        this.page = page;
        this.cri.setPage(page);
    }

    @JsonSetter("perPageNum")
    public void setPerPageNum(int perPageNum) {
        this.perPageNum = perPageNum;
        this.cri.setPerPageNum(perPageNum);
    }

    @JsonSetter("SEARCH_SAUM_PROGS_CD_GR")
    public void setSEARCH_SAUM_PROGS_CD_GR(String SEARCH_SAUM_PROGS_CD_GR) {
        this.SEARCH_SAUM_PROGS_CD_GR = SEARCH_SAUM_PROGS_CD_GR;
        if (SEARCH_SAUM_PROGS_CD_GR != null && !SEARCH_SAUM_PROGS_CD_GR.trim().equals(""))
            this.SEARCH_SAUM_PROGS_CD_GR_LIST = TransUtils.stringToArraySplitComma(SEARCH_SAUM_PROGS_CD_GR);
    }

}
