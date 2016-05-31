package br.com.alysondantas.sac_mariana;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.com.alysondantas.sac_mariana.controller.SACMarianaController;
import br.com.alysondantas.sac_mariana.exceptions.CampoObrigatorioInexistenteException;
import br.com.alysondantas.sac_mariana.exceptions.ProdutoExistenteException;
import br.com.alysondantas.sac_mariana.model.Produto;

public class CadastrarActivity extends AppCompatActivity {
    private SACMarianaController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        controller = SACMarianaController.getInstance();
    }


    public void onCadastrar(View view){
        String nome;
        String data;
        String tipo;
        EditText editTextNome = (EditText) findViewById(R.id.editTextNome);
        nome = editTextNome.getText().toString();
        EditText editTextData = (EditText) findViewById(R.id.editTextData);
        data = editTextData.getText().toString();
        EditText editTextTipo = (EditText) findViewById(R.id.editTextTipo);
        tipo = editTextTipo.getText().toString();
        boolean p = false;
        try{
            p = controller.cadastrarProduto(nome,tipo,data);
        }catch (CampoObrigatorioInexistenteException e){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Campo Obrigatorio inexistente!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        } catch (ProdutoExistenteException e) {
            AlertDialog.Builder dlg1 = new AlertDialog.Builder(this);
            p=false;
            dlg1.setMessage("Produto ja cadastrado!");
            dlg1.setNeutralButton("OK",null);
            dlg1.show();
        }

        if(p != false){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Cadastrado com sucesso!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }else{
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao cadastrar!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
    }
}
