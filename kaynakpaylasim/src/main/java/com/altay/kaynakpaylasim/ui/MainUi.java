package com.altay.kaynakpaylasim.ui;

import com.altay.kaynakpaylasim.entity.*;
import com.altay.kaynakpaylasim.service.impl.*;
import com.altay.kaynakpaylasim.util.DagitimUtil;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringUI(path = "/api/veriler")

public class MainUi extends UI implements ViewDisplay {

    private final BolumServiceImpl bolumService;
    private final BolumIstekOzellikServiceImpl bolumIstekOzellikService;
    private final KaynakServiceImpl kaynakService;
    private final KaynakOzellikServiceImpl kaynakOzellikService;
    private final DagitimServiceImpl dagitimService;

    @Autowired
    private DagitimUtil dagitimUtil;

    private Panel mainPanel = new Panel();
    private GridLayout gridLayout = new GridLayout(3,3);
    private Grid<Bolum> bolumGrid = new Grid<>(Bolum.class);
    private Grid<BolumIstekOzellik> bolumIstekOzellikGrid = new Grid<>(BolumIstekOzellik.class);
    private Grid<Kaynak> kaynakGrid = new Grid<>(Kaynak.class);
    private Grid<KaynakOzellik> kaynakOzellikGrid = new Grid<>(KaynakOzellik.class);
    private Grid<Dagitim> dagitimGrid = new Grid<>(Dagitim.class);
    private Button button = new Button();

    public MainUi(BolumServiceImpl bolumService, BolumIstekOzellikServiceImpl bolumIstekOzellikService, KaynakServiceImpl kaynakService, KaynakOzellikServiceImpl kaynakOzellikService, DagitimServiceImpl dagitimService) {
        this.bolumService = bolumService;
        this.bolumIstekOzellikService = bolumIstekOzellikService;
        this.kaynakService = kaynakService;
        this.kaynakOzellikService = kaynakOzellikService;
        this.dagitimService = dagitimService;
    }



    @Override
    protected void init(VaadinRequest vaadinRequest) {


        mainPanel.setSizeFull();
        mainPanel.setCaption("Veriler ve Dağtım Sonuçları");

        gridLayout.setSpacing(true);

        gridLayout.setSizeFull();
        gridLayout.setMargin(true);

        bolumGrid.setCaption("Bölüm Bilgileri");
        bolumGrid.setHeight("150px");
        bolumGrid.setWidth("450px");
        List<Bolum> bolumList = bolumService.getAllOrderByOncelik();
        bolumGrid.setItems(bolumList);

        //bolumGrid.removeColumn("id");
        bolumGrid.removeAllColumns();
        bolumGrid.addColumn(Bolum::getName).setCaption("Bölüm Adı").setWidth(250);
        bolumGrid.addColumn(Bolum::getAdet).setCaption("K.Adedi").setWidth(100);
        bolumGrid.addColumn(Bolum::getOncelik).setCaption("Öncelik").setWidth(100);
        bolumGrid.addItemClickListener(itemClick ->
                {
                Bolum b = itemClick.getItem();
                bolumIstekOzellikGrid.setItems(bolumIstekOzellikService.getAllByBolum(b));
            }
        );
        gridLayout.addComponent(bolumGrid,0,1);

        bolumIstekOzellikGrid.setCaption("Bölüm İstek Özellikleri");
        bolumIstekOzellikGrid.removeColumn("id");
        bolumIstekOzellikGrid.removeColumn("ozellikTur");
        bolumIstekOzellikGrid.removeColumn("bolum");
        bolumIstekOzellikGrid.removeColumn("durum");
        bolumIstekOzellikGrid.addColumn(BolumIstekOzellik::getOzellikTur).setCaption("Özellik Adı");
        gridLayout.addComponent(bolumIstekOzellikGrid,0,2);

        List<Kaynak> kaynakList = kaynakService.getAll();
        kaynakGrid.setItems(kaynakList);
        kaynakGrid.setCaption("Kaynaklar");
        kaynakGrid.setHeight("150px");
        kaynakGrid.setWidth("250px");
        kaynakGrid.removeColumn("id");
        kaynakGrid.getColumn("adi").setCaption("Kaynak Adı");
        kaynakGrid.addItemClickListener(itemClick -> {
            Kaynak k = itemClick.getItem();
            kaynakOzellikGrid.setItems(kaynakOzellikService.getAllByKaynak(k));
        });
        gridLayout.addComponent(kaynakGrid,1,1);

        kaynakOzellikGrid.setCaption("Kaynak Özellikleri");
        kaynakOzellikGrid.removeColumn("id");
        kaynakOzellikGrid.removeColumn("kaynak");
        kaynakOzellikGrid.removeColumn("kaynakOzellik");
        kaynakOzellikGrid.removeColumn("durum");
        kaynakOzellikGrid.setWidth("250px");
        kaynakOzellikGrid.addColumn(KaynakOzellik::getKaynakOzellik).setCaption("Özellik Adı");
        gridLayout.addComponent(kaynakOzellikGrid,1,2);

        button.setCaption("Dağıtıma Başla");
        gridLayout.addComponent(button,2,0);

        dagitimGrid.setCaption("Dağıtımı Yapılan Kaynaklar");
        dagitimGrid.removeAllColumns();
        dagitimGrid.addColumn(Dagitim::getBolum).setCaption("Bölüm Adı");
        dagitimGrid.addColumn(Dagitim::getKaynak).setCaption("Kaynak Adı");
        gridLayout.addComponent(dagitimGrid,2,1,2,2);
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                dagitimUtil.dagitimHazirlik();
                dagitimGrid.setItems(dagitimService.getAll());
            }
        });

        mainPanel.setContent(gridLayout);

        setContent(mainPanel);
    }

    @Override
    public void showView(View view) {

    }
}
