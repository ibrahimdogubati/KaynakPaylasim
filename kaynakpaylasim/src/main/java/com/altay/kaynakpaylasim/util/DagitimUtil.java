package com.altay.kaynakpaylasim.util;

import com.altay.kaynakpaylasim.entity.*;
import com.altay.kaynakpaylasim.matris.BolumMatris;
import com.altay.kaynakpaylasim.matris.KaynakMatris;
import com.altay.kaynakpaylasim.service.impl.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DagitimUtil {

    /*
        Bölümlerin isteklerine göre kaynakların özellikleri kontrol edilerek dağıtım tablosunu dolduruyor.
        kontrolKaynakByBolum yordamında %100 uyum kontrol edilmiştir.
     */
    private final BolumIstekOzellikServiceImpl ozellikService;
    private final KaynakOzellikServiceImpl kaynakOzellikService;
    private final BolumServiceImpl bolumService;
    private final DagitimServiceImpl dagitimService;
    private final KaynakServiceImpl kaynakService;


    public DagitimUtil(BolumIstekOzellikServiceImpl ozellikService, KaynakOzellikServiceImpl kaynakOzellikService, KaynakServiceImpl kaynakService, BolumServiceImpl bolumService, DagitimServiceImpl dagitimService) {
        this.ozellikService = ozellikService;
        this.kaynakOzellikService = kaynakOzellikService;
        this.kaynakService = kaynakService;
        this.bolumService = bolumService;
        this.dagitimService = dagitimService;
    }

    public void dagitimHazirlik() {


        List<Bolum> bolumList = bolumService.getAllOrderByOncelik();
        for (Bolum b : bolumList) {
                List<Long> bolumMatrisList = new ArrayList<Long>();
                List<BolumIstekOzellik> bolumIstekOzellikList = ozellikService.getAllByBolum(b);
                for (BolumIstekOzellik bIO : bolumIstekOzellikList) {
                    BolumMatris bM = new BolumMatris(bIO.getOzellikTur().getId());
                    bolumMatrisList.add(bIO.getOzellikTur().getId());
                }
                List<Kaynak> kaynakList = kaynakService.getAllKaynakNotExistsDagitim();
                for (Kaynak k : kaynakList) {
                    List<Long> kaynakMatrisList = new ArrayList<Long>();
                    List<KaynakOzellik> kaynakOzellikList = kaynakOzellikService.getAllByKaynak(k);
                    for (KaynakOzellik kO : kaynakOzellikList) {
                        KaynakMatris kM = new KaynakMatris(kO.getKaynakOzellik().getId());
                        kaynakMatrisList.add(kO.getKaynakOzellik().getId());
                    }
                    if (kontrolKaynakByBolum(kaynakMatrisList, bolumMatrisList)) {
                        Dagitim dagitim = new Dagitim();
                        dagitim.setBolum(b);
                        dagitim.setKaynak(k);
                        dagitimService.save(dagitim);
                    }
                }
        }


    }
/*
    Daha sonra %100 uyum harici durumların kontrolü için farklı yordam olarak düzenlendi.
 */

    private Boolean kontrolKaynakByBolum(List<Long> kML, List<Long> bML) {
        return kML.equals(bML);
    }
}
