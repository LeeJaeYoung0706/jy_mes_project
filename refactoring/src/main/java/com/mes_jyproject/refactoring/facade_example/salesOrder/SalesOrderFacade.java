package com.mes_jyproject.refactoring.facade_example.salesOrder;


import com.mes_jyproject.refactoring.facade_example.salesOrder.dto.MtDeleteListDto;
import com.mes_jyproject.refactoring.facade_example.salesOrder.dto.SearchDtDto;
import com.mes_jyproject.refactoring.facade_example.salesOrder.dto.SearchDto;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class SalesOrderFacade {

    private final Map<UploadType, ISalesOrderService> registry = new EnumMap<>(UploadType.class);

    @Autowired
    public SalesOrderFacade(List<ISalesOrderService> strategies) {
        strategies.forEach(s -> registry.put(s.getType(), s));
    }

    @PostConstruct
    void afterInit() {
        System.out.println(" registry = " + registry.keySet());
    }

    public Response getMainList(SearchDto params) {
        return registry.values().stream()
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .getMainList(params);
    }

    public Response getSubList(SearchDtDto params) {
        return registry.values().stream()
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .getSubList(params);
    }

    public Response updateMtDelete(MtDeleteListDto params, String name) {
        return registry.values().stream()
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .updateMtDelete(params , name);
    }
}
