package com.example.application.views.cadastrodefilmes;

import com.example.application.Filme;
import com.example.application.data.dao.FilmeDAO;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.Date;

@PageTitle("Edição De Filmes")
@Route(value = "EdicaoFilme", layout = MainLayout.class)
@Uses(Icon.class)
public class EditarDeFilmesView extends Composite<VerticalLayout> {


    public int idFilme ;
    public String nomeFilme ;
    public int quantidade;
    public String DT_Lanc;
    public double preco;
    public int faixaEtaria;
    public String Genero ;
    public int MinutosDuracao ;

    public EditarDeFilmesView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        IntegerField ID = new IntegerField();
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        NumberField numberField = new NumberField();
        DatePicker datePicker = new DatePicker();
        NumberField numberField2 = new NumberField();
        NumberField numberField3 = new NumberField();
        NumberField numberField4 = new NumberField();
        getContent().setHeightFull();
        getContent().setWidthFull();
        layoutColumn2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn3.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutColumn3);
        ID.setLabel("ID do Filme");
        textField.setLabel("Nome do Filme");
        textField2.setLabel("Genero do Filme");
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, ID);
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, textField);
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, textField2);
        numberField.setLabel("Quantidade");
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, numberField);
        datePicker.setLabel("Data de Lançamento");
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, datePicker);
        numberField2.setLabel("Preço");
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, numberField2);
        numberField3.setLabel("Faixa etária mínima");
        numberField4.setLabel("Minutos de Duracao");
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, numberField3);
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, numberField4);
        getContent().add(layoutColumn2);
        layoutColumn2.add(layoutColumn3);
        layoutColumn3.add(ID);
        layoutColumn3.add(textField);
        layoutColumn3.add(textField2);
        layoutColumn3.add(numberField);
        layoutColumn3.add(datePicker);
        layoutColumn3.add(numberField2);
        layoutColumn3.add(numberField3);
        layoutColumn3.add(numberField4);
        Button ButtonSubmit = new Button();
        ButtonSubmit.setText("Enviar");
        ButtonSubmit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutColumn2.add(ButtonSubmit);


        ButtonSubmit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        ButtonSubmit.addClickListener(event -> {
            idFilme = ID.getValue();
            nomeFilme = textField.getValue();
            quantidade = numberField.getValue().intValue();
            DT_Lanc = String.valueOf(datePicker.getValue());
            preco = numberField2.getValue();
            faixaEtaria = numberField3.getValue().intValue();
            Genero = textField2.getValue();
            MinutosDuracao = numberField3.getValue().intValue();

            FilmeDAO filmeDAO = new FilmeDAO();

            Filme t = new Filme(idFilme, nomeFilme, faixaEtaria, DT_Lanc, Genero, MinutosDuracao, quantidade, preco);
            filmeDAO.UpdateFilmes(t);

            ButtonSubmit.getUI().ifPresent(ui ->
                    ui.navigate("ListaFilmes"));
        });
    }
}