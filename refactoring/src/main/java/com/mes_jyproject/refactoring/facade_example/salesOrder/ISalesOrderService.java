package com.mes_jyproject.refactoring.facade_example.salesOrder;

import com.mes_jyproject.refactoring.facade.UploadType;
import com.mes_jyproject.refactoring.facade_example.salesOrder.dto.MtDeleteListDto;
import com.mes_jyproject.refactoring.facade_example.salesOrder.dto.SearchDtDto;
import com.mes_jyproject.refactoring.facade_example.salesOrder.dto.SearchDto;

public interface ISalesOrderService {

    UploadType getType();
    Response getMainList(SearchDto params);

    Response getSubList(SearchDtDto params);

    Response updateMtDelete(MtDeleteListDto params, String name);
}
