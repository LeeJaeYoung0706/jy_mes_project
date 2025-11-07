package com.mes_jyproject.refactoring.facade_example.salesOrder;



import com.mes_jyproject.refactoring.facade_example.salesOrder.dto.MtDeleteDto;
import com.mes_jyproject.refactoring.facade_example.salesOrder.dto.SearchDtDto;
import com.mes_jyproject.refactoring.facade_example.salesOrder.dto.SearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SalesOrderErpMapper {

    List<Map<String ,Object>> getMainList(SearchDto searchDto);

    List<Map<String ,Object>> getSubList(SearchDtDto searchDtDto);

    int salsUploadMtSDB100Delete(MtDeleteDto deleteListDatum);

    int salsUploadDtSDB150Delete(MtDeleteDto deleteListDatum);

    int salsUploadDtDelete(MtDeleteDto deleteListDatum);

    int salsUploadMtDelete(MtDeleteDto deleteListDatum);

    List<Map<String, Object>> selectSalMng(MtDeleteDto deleteListDatum);

    List<Map<String, Object>> selectSalSDB150(MtDeleteDto deleteListDatum);

    //int erpInsertWithMEPMDto(MEPM_DTO dto);

    Map<String , Object> searchDeleteResult(MtDeleteDto deleteListDatum);


    int erpInsertWithMEPMDto(MEPM_DTO mepmDto);
}
