package br.com.alysondantas.sac_mariana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.alysondantas.sac_mariana.controller.SACMarianaController;

public class MenuActivity extends AppCompatActivity {
    private SACMarianaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        controller = SACMarianaController.getInstance();
    }

    public void cadastrar(View view){
        Intent acessoActivity = new Intent(this, CadastrarActivity.class);
        startActivity(acessoActivity);
    }

    public void editar(View view){
        Intent editarActivity = new Intent(this, EditarActivity.class);
        startActivity(editarActivity);
    }

    public void cadastrarDoador(View view){
        Intent cadastrarDoadorActivity = new Intent(this, CadastrarDoadorActivity.class);
        startActivity(cadastrarDoadorActivity);
    }

    public void editarDoador(View view){
        Intent editarDoadorActivity = new Intent(this, EditarDoadorActivity.class);
        startActivity(editarDoadorActivity);
    }

    public void cadastrarDoacao(View view){
        Intent cadastrarDoacaoActivity = new Intent(this, CadastrarDoacaoActivity.class);
        startActivity(cadastrarDoacaoActivity);
    }
    public void  editarexcluirDoacao(View view){
        Intent cadastrarDoacaoActivity = new Intent(this, EditarDoacaoActivity.class);
        startActivity(cadastrarDoacaoActivity);
    }

    public void listarProdutos(View view){
        Intent listarProdutosActivity = new Intent(this, ListarActivity.class);
        startActivity(listarProdutosActivity);
    }
}
