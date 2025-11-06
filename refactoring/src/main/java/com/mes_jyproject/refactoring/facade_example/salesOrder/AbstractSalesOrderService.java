package com.mes_jyproject.refactoring.facade_example.salesOrder;



import com.mes_jyproject.refactoring.facade_example.salesOrder.dto.MtDeleteDto;
import com.mes_jyproject.refactoring.facade_example.salesOrder.dto.MtDeleteListDto;
import com.mes_jyproject.refactoring.facade_example.salesOrder.dto.SearchDtDto;
import com.mes_jyproject.refactoring.facade_example.salesOrder.dto.SearchDto;

import java.util.List;
import java.util.Map;

public abstract class AbstractSalesOrderService implements ISalesOrderService {

    protected abstract SalesOrderErpMapper mapper();
    protected abstract SalesOrderTransactionService transactionService();

    public void save(){
        postProcess();
        doSave();
    }

    public Response getMainList(SearchDto params) {
        List<Map<String, Object>> list = mapper().getMainList(params);
        return Response.builder("ok", 200)
                .data(list)
                .total(TransUtils.transGetTotalByList(list))
                .build();
    }

    public Response getSubList(SearchDtDto params) {
        List<Map<String, Object>> list = mapper().getSubList(params);
        return Response.builder("ok", 200)
                .data(list)
                .build();
    }


    public Response updateMtDelete(MtDeleteListDto params, String name) {

        List<MtDeleteDto> deleteListData = params.getDeleteListData();

        if (deleteListData == null || deleteListData.size() == 0) {
            throw new CustomResponseException("해당 수주 삭제 정보가 존재하지 않습니다.", 405);
        }

        StringBuilder resultMessage = new StringBuilder();
        int count = 0;
        for (MtDeleteDto deleteListDatum : deleteListData) {
            try {
                deleteListDatum.setName(name);
                count += transactionService().updateMtDelete(deleteListDatum);
            } catch (CustomResponseException e) {
                resultMessage.append(" 실패 : ");
                resultMessage.append(e.getResponse().getMessage());
                resultMessage.append(" \n ");
            }
        }

        resultMessage.append(count);
        resultMessage.append(" 건 삭제 처리 되었습니다.\n");

        return Response.builder(resultMessage.toString(), 200).build();
    }



    protected void postProcess() {}
    protected void doSave() { /* CUST 로직 */ }
}
