package com.mes_jyproject.refactoring.facade_example.salesOrder;



import java.util.LinkedHashMap;
import java.util.Map;

import static com.mes_jyproject.refactoring.facade_example.salesOrder.MEPM_DTO.MEPM_TBL_TYPE_DT;
import static com.mes_jyproject.refactoring.facade_example.salesOrder.MEPM_DTO.MEPM_TBL_TYPE_MT;

class CreatingMesToErpDtoService {

    static MEPM_DTO deleteBySalsMngToMepmDtoCreate(Map<String, Object> salsMngDtMap , String name , String type) {
        LinkedHashMap<String, Object> resultKeyMap = new LinkedHashMap<>();
        LinkedHashMap<String, Object> resultDataMap = new LinkedHashMap<>();
        if (type.equals("MT")) {

            resultKeyMap.put("so_no", salsMngDtMap.get("SAMD_SO_NBR")); // 수주 번호
            resultDataMap.put("so_no", salsMngDtMap.get("SAMD_SO_NBR")); // 수주 번호

            return MEPM_DTO.builder()
                    .MEPM_TRS_CD("DE")
                    .MEPM_TBL_CD("SDB100")
                    .MEPM_GROUP_KEY(resultKeyMap)
                    .MEPM_GROUP_DATA(resultDataMap)
                    .MEPM_RST_CD("00")
                    .MEPM_REG_USER(name)
                    .MEPM_RST_MSG("")
                    .MEPM_TBL_TYPE(MEPM_TBL_TYPE_MT)
                    .build();
        } else if (type.equals("DT")) {

            resultKeyMap.put("so_no", salsMngDtMap.get("SAMD_SO_NBR")); // 수주 번호
            resultKeyMap.put("so_sq", salsMngDtMap.get("SAMD_SO_LN"));

            resultDataMap.put("so_no", salsMngDtMap.get("SAMD_SO_NBR")); // 수주 번호
            resultDataMap.put("so_sq", salsMngDtMap.get("SAMD_SO_LN")); // 수주 연번

            return MEPM_DTO.builder()
                    .MEPM_TRS_CD("DE")
                    .MEPM_TBL_CD("SDB150")
                    .MEPM_GROUP_KEY(resultKeyMap)
                    .MEPM_GROUP_DATA(resultDataMap)
                    .MEPM_RST_CD("00")
                    .MEPM_REG_USER(name)
                    .MEPM_RST_MSG("")
                    .MEPM_TBL_TYPE(MEPM_TBL_TYPE_DT)
                    .build();
        } else
            return null;
    }
}
