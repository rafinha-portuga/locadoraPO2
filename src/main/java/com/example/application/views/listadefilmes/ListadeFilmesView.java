package com.example.application.views.listadefilmes;

import com.example.application.Filme;
import com.example.application.data.dao.FilmeDAO;
import com.example.application.data.entity.SamplePerson;
import com.example.application.data.service.SamplePersonService;
import com.example.application.views.MainLayout;
import com.example.application.views.cadastrodefilmes.CadastroDeFilmesView;
import com.example.application.views.cadastrodefilmes.EditarDeFilmesView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;


import java.util.List;
import java.util.Set;

@PageTitle("Lista de Filmes")
@Route(value = "ListaFilmes", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class ListadeFilmesView extends Composite<VerticalLayout> {

    private int idFilmeSelected;
    private String nomeFilmeSelected;
    private int faixaEtariaSelected;
    private String DT_Lanc;
    private String Genero;
    private String Tag;
    private int MinutosDuracao;
    private int Quantidade;
    private double Preco;

    public ListadeFilmesView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        Button buttonPrimary = new Button();
        Button buttonPrimary2 = new Button();
        Button buttonPrimary3 = new Button();
        Grid basicGrid = new Grid(Filme.class);
        getContent().setHeightFull();
        getContent().setWidthFull();
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        buttonPrimary.setText("Incluir");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary2.setText("Deletar");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary3.setText("Editar");
        buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        setGridSampleData(basicGrid);
        getContent().add(layoutRow);
        layoutRow.add(buttonPrimary);
        layoutRow.add(buttonPrimary2);
        layoutRow.add(buttonPrimary3);
        getContent().add(basicGrid);

        buttonPrimary.addClickListener(e ->
                buttonPrimary.getUI().ifPresent(ui ->
                        ui.navigate("CadastroFilme"))
        );

        buttonPrimary2.addClickListener(e -> {
            if (nomeFilmeSelected != null && faixaEtariaSelected != 0) {
                FilmeDAO.DeleteFilmes(idFilmeSelected);
                basicGrid.setItems(FilmeDAO.SelectFilmes());
            }
        });

        buttonPrimary3.addClickListener(e ->
                buttonPrimary.getUI().ifPresent(ui ->
                        ui.navigate("EdicaoFilme"))
        );

    }

    private void setGridSampleData(Grid grid) {
        List<Filme> filmes = FilmeDAO.SelectFilmes();
        grid.setItems(filmes);
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid.addSelectionListener(event -> {
            Set<Filme> selectedItems = event.getAllSelectedItems();
            for (Filme selectedItem : selectedItems) {
                idFilmeSelected = selectedItem.getIdFilme();
                nomeFilmeSelected = selectedItem.getNomeFilme();
                faixaEtariaSelected = selectedItem.getFaixaEtaria();
                DT_Lanc = selectedItem.getDT_Lanc();
                Genero = selectedItem.getGenero();
                MinutosDuracao = selectedItem.getMinutosDuracao();
            }
        });
    }

    private SamplePersonService samplePersonService;
}
