package com.mes_jyproject.refactoring.facade_example.salesOrder;



import com.mes_jyproject.refactoring.facade_example.salesOrder.dto.MtDeleteListDto;
import com.mes_jyproject.refactoring.facade_example.salesOrder.dto.SearchDtDto;
import com.mes_jyproject.refactoring.facade_example.salesOrder.dto.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 거래처 기준 업로드
 */
@Service
@RequiredArgsConstructor
public class SaleOrderErpServiceCust extends AbstractSalesOrderService {

    private final SalesOrderErpMapper mapper;
    private final SalesOrderTransactionService transactionService;
    @Override
    public UploadType getType() {
        return UploadType.CUST;
    }

    @Override
    @Transactional
    public void save() {
        super.save();
    }

    @Override
    protected SalesOrderErpMapper mapper() { return mapper; }

    @Override
    protected SalesOrderTransactionService transactionService() {
        return transactionService;
    }

    @Override
    public Response getMainList(SearchDto params) {
        return super.getMainList(params);
    }

    @Override
    public Response getSubList(SearchDtDto params) {
        return super.getSubList(params);
    }

    @Override
    public Response updateMtDelete(MtDeleteListDto params, String name) {
        return super.updateMtDelete(params, name);
    }
}
