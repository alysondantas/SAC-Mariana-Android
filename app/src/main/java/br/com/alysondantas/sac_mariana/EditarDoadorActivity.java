package br.com.alysondantas.sac_mariana;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.alysondantas.sac_mariana.controller.SACMarianaController;
import br.com.alysondantas.sac_mariana.exceptions.CampoObrigatorioInexistenteException;
import br.com.alysondantas.sac_mariana.exceptions.ConflitoException;
import br.com.alysondantas.sac_mariana.exceptions.DoadorInexistenteException;
import br.com.alysondantas.sac_mariana.exceptions.ProdutoInexistenteException;
import br.com.alysondantas.sac_mariana.model.Doador;
import br.com.alysondantas.sac_mariana.model.Endereco;

public class EditarDoadorActivity extends AppCompatActivity {
    private SACMarianaController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_doador);
        controller = SACMarianaController.getInstance();
    }

    public void editarDoador1(View view){
        EditText editTextNome = (EditText) findViewById(R.id.editText);
        String nome = editTextNome.getText().toString();
        EditText editTextNumCad = (EditText) findViewById(R.id.editText2);
        String numCad = editTextNumCad.getText().toString();
        EditText editTextdataNasc = (EditText) findViewById(R.id.editText12);
        String dataNasc = editTextdataNasc.getText().toString();
        EditText editTextTipo = (EditText) findViewById(R.id.editText4);
        String tipo = editTextTipo.getText().toString();
        EditText editTextPais = (EditText) findViewById(R.id.editText5);
        String pais = editTextPais.getText().toString();
        EditText editTextuf = (EditText) findViewById(R.id.editText6);
        String uf = editTextuf.getText().toString();
        EditText editTextcidade = (EditText) findViewById(R.id.editText7);
        String cidade = editTextcidade.getText().toString();
        EditText editTextNum = (EditText) findViewById(R.id.editText8);
        String num1 = editTextNum.getText().toString();
        int num = -1;
        try{
            num = Integer.parseInt(num1);
        }catch (NumberFormatException e){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Campo Num foi ignorado!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
        EditText editTextRua = (EditText) findViewById(R.id.editText9);
        String rua = editTextRua.getText().toString();
        EditText editTextBairro = (EditText) findViewById(R.id.editText11);
        String bairro = editTextBairro.getText().toString();
        EditText editTextCEP = (EditText) findViewById(R.id.editText10);
        String cep = editTextCEP.getText().toString();
        boolean b = false;
        try {
            b = controller.editarDoador(numCad,nome,dataNasc,rua,num,bairro,cep,cidade,uf,pais,tipo);
        } catch (CampoObrigatorioInexistenteException e) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro campo obrigatorio inexistente!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        } catch (DoadorInexistenteException e) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro doador não encontrador!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
        if(b != false){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Editado com sucesso!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }else{
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao Editar!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
    }

    public void obterDoador1(View view){
        EditText editTextNome = (EditText) findViewById(R.id.editText);
        EditText editTextNumCad = (EditText) findViewById(R.id.editText2);
        String numCad = editTextNumCad.getText().toString();
        EditText editTextdataNasc = (EditText) findViewById(R.id.editText12);
        EditText editTextTipo = (EditText) findViewById(R.id.editText4);
        EditText editTextPais = (EditText) findViewById(R.id.editText5);
        EditText editTextuf = (EditText) findViewById(R.id.editText6);
        EditText editTextcidade = (EditText) findViewById(R.id.editText7);
        EditText editTextNum = (EditText) findViewById(R.id.editText8);
        EditText editTextRua = (EditText) findViewById(R.id.editText9);
        EditText editTextBairro = (EditText) findViewById(R.id.editText11);
        EditText editTextCEP = (EditText) findViewById(R.id.editText10);
        Doador doador = controller.obterDoador(numCad);
        if(doador != null){
            editTextNome.setText(doador.getNome());
            editTextdataNasc.setText(doador.getDt_Nascimento());
            editTextTipo.setText(doador.getTipo());
            Endereco end = doador.getEndereco();
            editTextPais.setText(end.getPais());
            editTextuf.setText(end.getUf());
            editTextcidade.setText(end.getCidade());
            int numero = end.getNumero();
            String test = "" + numero;
            editTextNum.setText(test);
            editTextRua.setText(end.getRua());
            editTextBairro.setText(end.getBairro());
            editTextCEP.setText(end.getCep());
        }else{
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro doador não encontrado!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
    }

    public void excluirDoador(View view){
        EditText editTextNumCad = (EditText) findViewById(R.id.editText2);
        String numCad = editTextNumCad.getText().toString();
        boolean b = false;
        try {
            b = controller.removerDoador(numCad);
        } catch (DoadorInexistenteException e) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro doador não encontrado!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        } catch (ConflitoException e) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro doação desse doador foi encontrada, não foi removido!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
        if(b != false){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Removido com sucesso!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }else{
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao remover!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
    }
}
