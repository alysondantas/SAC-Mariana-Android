package br.com.alysondantas.sac_mariana;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.com.alysondantas.sac_mariana.controller.SACMarianaController;
import br.com.alysondantas.sac_mariana.exceptions.CampoObrigatorioInexistenteException;
import br.com.alysondantas.sac_mariana.exceptions.ConflitoException;
import br.com.alysondantas.sac_mariana.exceptions.ProdutoExistenteException;
import br.com.alysondantas.sac_mariana.exceptions.ProdutoInexistenteException;
import br.com.alysondantas.sac_mariana.model.Produto;

public class EditarActivity extends AppCompatActivity {
    private SACMarianaController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        controller = SACMarianaController.getInstance();
    }

    public void editar(View view){
        String nome = null;
        EditText editTextNome = (EditText) findViewById(R.id.editTextNome);
        EditText editTextNovoNome = (EditText) findViewById(R.id.editTextNomeNovo);
        EditText editTextTipo = (EditText) findViewById(R.id.editTextTipo);
        EditText editTextData = (EditText) findViewById(R.id.editTextData);
        nome = editTextNome.getText().toString();
        String novoNome = editTextNovoNome.getText().toString();
        String data = editTextData.getText().toString();
        String tipo = editTextTipo.getText().toString();
        boolean b = false;
        try {
            b = controller.editarProduto(nome,tipo,data);
        } catch (CampoObrigatorioInexistenteException e) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro campo Obrigatorio inexistente!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        } catch (ProdutoExistenteException e) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao obter, não encontrado!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
        if(b==true){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Editado com sucesso!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }else{
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao editar!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
    }

    public void excluir(View view){
        EditText editTextNome = (EditText) findViewById(R.id.editTextNome);
        String nome = editTextNome.getText().toString();
        boolean b = false;
        try {
           b = controller.removerProduto(nome);
        } catch (ConflitoException e) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro conflito ao tentar remover,\n possivel doação vinculada!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        } catch (ProdutoInexistenteException e) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro produto não encontrado!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }

        if(b == true){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Objeto removido!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }else{
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao remover!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
    }

    public void obter(View view){
        String nome = null;
        EditText editTextNome = (EditText) findViewById(R.id.editTextNome);
        EditText editTextNovoNome = (EditText) findViewById(R.id.editTextNomeNovo);
        EditText editTextTipo = (EditText) findViewById(R.id.editTextTipo);
        EditText editTextData = (EditText) findViewById(R.id.editTextData);
        TextView textViewID = (TextView) findViewById(R.id.textViewID);
        nome = editTextNome.getText().toString();
        Produto p;
        p = controller.obProdutoNome(nome);
        if(p==null){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao obter, não encontrado!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }else{
            editTextNovoNome.setText(p.getNome());
            editTextData.setText(p.getDataCadastro());
            editTextTipo.setText(p.getTipo());
            textViewID.setText(p.getId_produto().toString());
        }
    }
}
