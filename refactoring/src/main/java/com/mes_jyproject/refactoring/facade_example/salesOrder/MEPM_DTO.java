package com.mes_jyproject.refactoring.facade_example.salesOrder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Map;

@Data
public class MEPM_DTO {

    public static String MEPM_TBL_TYPE_DT = "DT";
    public static String MEPM_TBL_TYPE_MT = "MT";

    // 상태코드 CR : 생성 , UP : 수정 , DE : 삭제 , ST : 상태변경
    private String MEPM_TRS_CD;
    // 테이블 키 값
    private String MEPM_TBL_CD;
    // 테이블 타입 MT , DT
    private String MEPM_TBL_TYPE;
    // json 타입 데이터값
    private String MEPM_GROUP_DATA;
    // json 타입 키값
    private String MEPM_GROUP_KEY;
    // 생성자
    private String MEPM_REG_USER;
    // 메세지
    private String MEPM_RST_MSG;
    private String MEPM_RST_CD;
    // 등록일
    private LocalDateTime MEPM_REG_DATE;

    private MEPM_DTO(Builder b) {
        this.MEPM_TRS_CD    = b.MEPM_TRS_CD;
        this.MEPM_TBL_CD    = b.MEPM_TBL_CD;
        this.MEPM_TBL_TYPE  = b.MEPM_TBL_TYPE;
        this.MEPM_GROUP_DATA= b.MEPM_GROUP_DATA;
        this.MEPM_GROUP_KEY = b.MEPM_GROUP_KEY;
        this.MEPM_REG_USER  = b.MEPM_REG_USER;
        this.MEPM_RST_MSG   = b.MEPM_RST_MSG != null ? b.MEPM_RST_MSG : "";
        this.MEPM_RST_CD = b.MEPM_RST_CD;
        this.MEPM_REG_DATE  = b.MEPM_REG_DATE != null
                ? b.MEPM_REG_DATE
                : ZonedDateTime.now(ZoneId.of("Asia/Seoul")).toLocalDateTime();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String MEPM_TRS_CD;
        private String MEPM_TBL_CD;
        private String MEPM_TBL_TYPE;
        private String MEPM_GROUP_DATA;
        private String MEPM_GROUP_KEY;
        private String MEPM_REG_USER;
        private String MEPM_RST_MSG;
        private String MEPM_RST_CD;
        private LocalDateTime MEPM_REG_DATE;

        public Builder MEPM_TRS_CD(String MEPM_TRS_CD) {
            this.MEPM_TRS_CD = MEPM_TRS_CD;
            return this;
        }
        public Builder MEPM_TBL_CD(String MEPM_TBL_CD) {
            this.MEPM_TBL_CD = MEPM_TBL_CD;
            return this;
        }
        public Builder MEPM_TBL_TYPE(String MEPM_TBL_TYPE) {
            this.MEPM_TBL_TYPE = MEPM_TBL_TYPE;
            return this;
        }
        public Builder MEPM_GROUP_DATA(String MEPM_GROUP_DATA) {
            this.MEPM_GROUP_DATA = MEPM_GROUP_DATA;
            return this;
        }
        public Builder MEPM_GROUP_KEY(String MEPM_GROUP_KEY) {
            this.MEPM_GROUP_KEY = MEPM_GROUP_KEY;
            return this;
        }
        public Builder MEPM_REG_USER(String MEPM_REG_USER) {
            this.MEPM_REG_USER = MEPM_REG_USER;
            return this;
        }
        public Builder MEPM_RST_MSG(String MEPM_RST_MSG) {
            this.MEPM_RST_MSG = MEPM_RST_MSG;
            return this;
        }

        public Builder MEPM_RST_CD(String MEPM_RST_CD) {
            this.MEPM_RST_CD = MEPM_RST_CD;
            return this;
        }

        public Builder MEPM_REG_DATE(LocalDateTime MEPM_REG_DATE) {
            this.MEPM_REG_DATE = MEPM_REG_DATE;
            return this;
        }

        public Builder MEPM_GROUP_DATA(Map<String, ?> dataMap) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                String json = mapper.writeValueAsString(Collections.singletonList(dataMap));
                this.MEPM_GROUP_DATA = json;
                return this;
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException("Map → GROUP_DATA JSON 변환 실패", e);
            }
        }

        public Builder MEPM_GROUP_KEY(Map<String, ?> dataMap) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                String json = mapper.writeValueAsString(Collections.singletonList(dataMap));
                this.MEPM_GROUP_KEY = json;
                return this;
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException("Map → GROUP_KEY JSON 변환 실패", e);
            }
        }

        public MEPM_DTO build() {
            return new MEPM_DTO(this);
        }
    }


}
