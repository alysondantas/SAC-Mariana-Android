package br.com.alysondantas.sac_mariana;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import br.com.alysondantas.sac_mariana.controller.SACMarianaController;
import br.com.alysondantas.sac_mariana.exceptions.CampoObrigatorioInexistenteException;

public class EditarDoacaoActivity extends AppCompatActivity {
    private SACMarianaController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_doacao);
        controller = SACMarianaController.getInstance();
    }

    public void editardoacao(View view){
        EditText editTextID = (EditText) findViewById(R.id.editTextIDdoacao);
        String iddoacao = editTextID.getText().toString();
        int id = -1;
        try{
            id = Integer.parseInt(iddoacao);
        }catch (NumberFormatException e){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro interno do ID!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
        EditText editTextNumDoador = (EditText) findViewById(R.id.editTextNumCadDoador);
        String numDoador = editTextNumDoador.getText().toString();
        EditText editTextNomeproduto = (EditText) findViewById(R.id.editTextNomeProduto);
        String nomeProduto = editTextNomeproduto.getText().toString();
        EditText editTextDataDoacao = (EditText) findViewById(R.id.editTextDatadoacao);
        String dataDoacao = editTextDataDoacao.getText().toString();
        EditText editTextQuantidade = (EditText) findViewById(R.id.editTextQuantidadee);
        String quantidade = editTextQuantidade.getText().toString();
        int qtd = -1;
        try{
            qtd = Integer.parseInt(quantidade);
        }catch (NumberFormatException e){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Quantidade deve ser numerico!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
        boolean v = false;
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox2);
        if(checkBox.isSelected()){
            v = true;
        }
        boolean b = false;
        try {
            b = controller.alterarDoacao(id,numDoador,nomeProduto,qtd,dataDoacao,v);
        } catch (CampoObrigatorioInexistenteException e) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Campo obrigatorio inexistente!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
        if(b == true){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Doação alterada com sucesso!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }else{
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao alterar doação!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
    }

    public void removeDoacoes(View view){
        EditText editTextID = (EditText) findViewById(R.id.editTextIDdoacao);
        String iddoacao = editTextID.getText().toString();
        int id = -1;
        try{
            id = Integer.parseInt(iddoacao);
        }catch (NumberFormatException e){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro interno do ID!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
        boolean b = controller.removerDoacao(id);
        if(b == true){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Doação removida com sucesso!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }else{
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao remover doação!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
    }
}
