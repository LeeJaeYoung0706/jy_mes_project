package com.mes_jyproject.refactoring.facade_example.salesOrder;


import com.mes_jyproject.refactoring.facade_example.salesOrder.dto.MtDeleteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SalesOrderTransactionService {

    private final SalesOrderErpMapper mapper;


    //@Transactional
    public int updateMtDelete(MtDeleteDto deleteListDatum) {

        // 수주 상태 확인
        List<Map<String, Object>> salsMngSoNbrAndSoLnList = checkSalsMngStatus(deleteListDatum);
        // 중간 테이블 확인
        checkMiddleTableStatus(deleteListDatum);

        // ERP 삭제 전송
        for (int i = 0; i < salsMngSoNbrAndSoLnList.size(); i++) {
            if (i == 0) {
                if(mesToErpDeleteInsert(salsMngSoNbrAndSoLnList.get(i), deleteListDatum.getName() , "MT") != 1)
                    throw new CustomResponseException("ERP 전송중 오류 발생 ( DT )" , 500);
            }

            if(mesToErpDeleteInsert(salsMngSoNbrAndSoLnList.get(i), deleteListDatum.getName() , "DT") != 1)
                throw new CustomResponseException("ERP 전송중 오류 발생 ( DT )" , 500);
        }
        // 중간테이블 SDD100 , SDD150 삭제
        deleteMiddleTable(deleteListDatum);
        // SALS ULD 테이블 삭제
        deleteSalsUldTable(deleteListDatum);
        // 잔존 이력 존재하는지 체크
        if (mapper.searchDeleteResult(deleteListDatum) != null)
            throw new CustomResponseException("삭제 중 잔존 이력 존재 관리자에게 문의하세요." , 500);

        return 1;
    }

    /**
     * ERP 삭제 데이터 삽입
     * @param salsMngDtMap
     * @param name
     */
    private int mesToErpDeleteInsert(Map<String, Object> salsMngDtMap , String name , String type) {
        MEPM_DTO mepmDto = CreatingMesToErpDtoService.deleteBySalsMngToMepmDtoCreate(salsMngDtMap , name , type);
        int result = 0;
        if (mepmDto != null)
            result = mapper.erpInsertWithMEPMDto(mepmDto);
        return result;
    }

    /**
     * 중간 테이블 SDD100 , SDD150 삭제
     * @param deleteListDatum
     */
    private void deleteMiddleTable(MtDeleteDto deleteListDatum) {
        mapper.salsUploadDtSDB150Delete(deleteListDatum);
        if (mapper.salsUploadMtSDB100Delete(deleteListDatum) != 1)
            throw new CustomResponseException("중간 테이블 삭제 중 오류 발생" , 500);
    }

    private void deleteSalsUldTable(MtDeleteDto deleteListDatum) {
        mapper.salsUploadDtDelete(deleteListDatum);
        if (mapper.salsUploadMtDelete(deleteListDatum) != 1)
            throw new CustomResponseException("업로드 테이블 삭제 중 오류 발생" , 500);
    }

    /**
     * 수주 중간 테이블과 비교 변경 확인
     * @param deleteListDatum 삭제할 수주 번호 리스트
     */
    private void checkMiddleTableStatus(MtDeleteDto deleteListDatum) {
        List<Map<String, Object>> salSDB150MapList = mapper.selectSalSDB150(deleteListDatum);
        if (salSDB150MapList == null || salSDB150MapList.size() == 0)
            throw new CustomResponseException( deleteListDatum.getSAUM_SO_NBR() + " 중간 정보가 존재하지 않습니다. \n", 405);

        Set<Integer> saudLn = new HashSet<>(salSDB150MapList.size());
        Set<Integer> samdLn = new HashSet<>(salSDB150MapList.size());
        for (Map<String, Object> r : salSDB150MapList) {
            saudLn.add(asInt(r.get("SAUD_SO_LN")));
            samdLn.add(asInt(r.get("SAMD_SO_LN")));
        }

        if (!saudLn.equals(samdLn))
            throw new CustomResponseException( deleteListDatum.getSAUM_SO_NBR() + " 수주 번호의 MES <-> ERP 데이터가 일치하지 않습니다. \n", 405);
    }

    /**
     * 수주 상태 확인
     * @param deleteListDatum 삭제할 수주 번호 리스트
     */
    private List<Map<String, Object>> checkSalsMngStatus(MtDeleteDto deleteListDatum) {

        List<Map<String, Object>> selectSalMngMapList = mapper.selectSalMng(deleteListDatum);

        if (selectSalMngMapList == null || selectSalMngMapList.size() < 1)
            throw new CustomResponseException("수주 정보가 존재하지 않습니다." , 400);

        Map<String, Object> firstMap = selectSalMngMapList.get(0);
        final String PASS_SAMM_PROGS_CD = "SD200100";
        if (firstMap.get("SAMM_PROGS_CD") == null || !String.valueOf(firstMap.get("SAMM_PROGS_CD")).equals(PASS_SAMM_PROGS_CD))
            throw new CustomResponseException( deleteListDatum.getSAUM_SO_NBR() + " 수주 정보는 이미 진행 상태입니다. (등록 상태만 삭제 가능) \n", 405);

        // DT 가 하나라도 진행중으로 변경되었다면
        final String PASS_SAMD_PROGS_CD = "SD201100";
        if (selectSalMngMapList.stream().anyMatch(
                (v) -> !String.valueOf(v.get("SAMD_PROGS_CD")).trim().equals(PASS_SAMD_PROGS_CD)))
            throw new CustomResponseException( deleteListDatum.getSAUM_SO_NBR() + " 수주 품목 상세 정보 중 진행 상태인 것이 존재합니다. (등록 상태만 삭제 가능) \n ", 405);

        return selectSalMngMapList;
    }


    private static int asInt(Object o) {
        if (o == null) throw new IllegalArgumentException("라인값이 null입니다.");
        if (o instanceof Number n) return n.intValue();
        String s = o.toString().trim();
        if (s.isEmpty()) throw new IllegalArgumentException("라인값이 비어있습니다.");
        return Integer.parseInt(s);
    }

}
