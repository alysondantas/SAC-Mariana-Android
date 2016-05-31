package br.com.alysondantas.sac_mariana;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import br.com.alysondantas.sac_mariana.controller.SACMarianaController;
import br.com.alysondantas.sac_mariana.exceptions.CampoObrigatorioInexistenteException;
import br.com.alysondantas.sac_mariana.exceptions.DoadorInexistenteException;
import br.com.alysondantas.sac_mariana.exceptions.ProdutoInexistenteException;

public class CadastrarDoacaoActivity extends AppCompatActivity {
    private SACMarianaController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_doacao);
        controller = SACMarianaController.getInstance();
    }

    public void cadastrarDoacao(View view){
        EditText editTextDoador = (EditText) findViewById(R.id.editTextDoador);
        String doadorNumero = editTextDoador.getText().toString();
        EditText editTextProduto = (EditText) findViewById(R.id.editTextProduto);
        String produtoNumero = editTextProduto.getText().toString();
        EditText editTextData = (EditText) findViewById(R.id.editTextDataDoacao);
        String data = editTextData.getText().toString();
        EditText editTextQuantidade = (EditText) findViewById(R.id.editTextQuantidade);
        String quantidade = editTextQuantidade.getText().toString();
        int qtd = -1;
        try{
            qtd = Integer.parseInt(quantidade);
        }catch (NumberFormatException e){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro quantidade não foi numerico!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
        CheckBox checkBoxMonetario = (CheckBox) findViewById(R.id.checkBox);
        boolean monetario = false;
        if(checkBoxMonetario.isSelected()){
            monetario = true;
        }
        boolean b = false;
        try {
            b = controller.efetuarDoacao(doadorNumero,produtoNumero,qtd,data,monetario);
        } catch (CampoObrigatorioInexistenteException e) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro campo obrigatorio não preenchido!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        } catch (ProdutoInexistenteException e) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro produto não encontrado!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        } catch (DoadorInexistenteException e) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro doador não encontrado!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
        if(b == true){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Doacao efetuada com sucesso!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }else{
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Error ao efetuar doação!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
    }
}
