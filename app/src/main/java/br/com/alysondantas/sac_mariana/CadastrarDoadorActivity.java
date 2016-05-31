package br.com.alysondantas.sac_mariana;

import android.app.AlertDialog;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.alysondantas.sac_mariana.controller.SACMarianaController;
import br.com.alysondantas.sac_mariana.exceptions.CampoObrigatorioInexistenteException;
import br.com.alysondantas.sac_mariana.exceptions.ConflitoException;

public class CadastrarDoadorActivity extends AppCompatActivity {
    private SACMarianaController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_doador);
        controller = SACMarianaController.getInstance();
    }

    public void cadastrarDoador1(View view){
        EditText editTextNome = (EditText) findViewById(R.id.editTextNome);
        String nome = editTextNome.getText().toString();
        EditText editTextNumCad = (EditText) findViewById(R.id.editTextNumcad);
        String numCad = editTextNumCad.getText().toString();
        EditText editTextdataNasc = (EditText) findViewById(R.id.editTextDtNasc);
        String dataNasc = editTextdataNasc.getText().toString();
        EditText editTextTipo = (EditText) findViewById(R.id.editTextTipo);
        String tipo = editTextTipo.getText().toString();
        EditText editTextPais = (EditText) findViewById(R.id.editTextPais);
        String pais = editTextPais.getText().toString();
        EditText editTextuf = (EditText) findViewById(R.id.editTextUf);
        String uf = editTextuf.getText().toString();
        EditText editTextcidade = (EditText) findViewById(R.id.editTextCidade);
        String cidade = editTextcidade.getText().toString();
        EditText editTextNum = (EditText) findViewById(R.id.editTextNum);
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
        EditText editTextRua = (EditText) findViewById(R.id.editTextRua);
        String rua = editTextRua.getText().toString();
        EditText editTextBairro = (EditText) findViewById(R.id.editTextBairro);
        String bairro = editTextBairro.getText().toString();
        EditText editTextCEP = (EditText) findViewById(R.id.editTextCep);
        String cep = editTextCEP.getText().toString();
        boolean b = false;
        try {
            b = controller.cadastrarDoador(numCad,nome,dataNasc,rua,num,bairro,cep,cidade,uf,pais,tipo);
        } catch (CampoObrigatorioInexistenteException e) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Campo Obrigatorio inexistente!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        } catch (ConflitoException e) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Doador ja cadastrado!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }

        if(b != false){
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
